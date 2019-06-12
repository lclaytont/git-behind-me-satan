package com.clayterry.gitBehindMeSatan.ui.repoList;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.clayterry.gitBehindMeSatan.Constants;
import com.clayterry.gitBehindMeSatan.data.GitHubApi;
import com.clayterry.gitBehindMeSatan.data.entities.GitHubResponse;
import com.clayterry.gitBehindMeSatan.data.entities.Repo;
import com.clayterry.gitBehindMeSatan.ui.common.BaseActivity;
import com.clayterry.gitbehindmesatan.R;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RepoListActivity extends BaseActivity {
    private static final String TAG = "RepoListActivity";
    GitHubApi mGitHubApi;
    RecyclerView mRecyclerView;
    RepoListAdapter mRepoListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_repo_list);

        mGitHubApi = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GitHubApi.class);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String searchParam = extras.getString("search_param");
            fetchGitHubResponse(searchParam);
        }

    }

    private void fetchGitHubResponse(String searchParam) {
        Call<GitHubResponse> call = mGitHubApi.fetchGitHubResponse(searchParam, 1, 20);
        call.enqueue(new Callback<GitHubResponse>() {
            @Override
            public void onResponse(Call<GitHubResponse> call, Response<GitHubResponse> response) {
                Log.d(TAG, response.raw().toString());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        bindRepos(response.body());
                    } else {
                        Log.d(TAG, "Bpdy is null");
                        showErrorMessage();
                    }
                } else {
                    Log.d(TAG, "Network unsuccessful: " + response.errorBody());
                    showErrorMessage();
                }
            }



            @Override
            public void onFailure(Call<GitHubResponse> call, Throwable t) {
                Log.d(TAG, "Network Call Failure: " + t.getMessage());
                showErrorMessage();
            }
        });
    }

    private void bindRepos(GitHubResponse gitHubResponse) {
        List<Repo> repos = new ArrayList<>();
        repos.addAll(gitHubResponse.getItems());

        mRecyclerView = findViewById(R.id.repo_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRepoListAdapter = new RepoListAdapter(repos);
        mRecyclerView.setAdapter(mRepoListAdapter);
    }

    private void showErrorMessage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setMessage(R.string.error_loading_repos)
                .setPositiveButton("Ok", (dialog, which) -> {
                  // Dismiss alert
                });

        builder.show();
    }
}
