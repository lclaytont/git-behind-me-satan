package com.clayterry.gitBehindMeSatan.ui.repoList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.clayterry.gitBehindMeSatan.data.entities.Repo;
import com.clayterry.gitBehindMeSatan.ui.common.BaseActivity;
import com.clayterry.gitbehindmesatan.R;

public class RepoListActivity extends BaseActivity {

    RecyclerView mRecyclerView;
    RepoListAdapter mRepoListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_repo_list);

        mRecyclerView.findViewById(R.id.repo_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRepoListAdapter = new RepoListAdapter();

    }
}
