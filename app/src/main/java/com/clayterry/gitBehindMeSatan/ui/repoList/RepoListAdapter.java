package com.clayterry.gitBehindMeSatan.ui.repoList;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.clayterry.gitBehindMeSatan.data.entities.Repo;
import com.clayterry.gitbehindmesatan.R;

import java.util.ArrayList;
import java.util.List;

class RepoListAdapter extends RecyclerView.Adapter<RepoListAdapter.MyViewHolder> {

    private List<Repo> mRepositories = new ArrayList<>();

    public RepoListAdapter(List<Repo> mRepositories) {
        this.mRepositories.addAll(mRepositories);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.viewholder_repo, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Repo repo = mRepositories.get(i);

        myViewHolder.mRepoName.setText(repo.getName());
        if (repo.getDescription() != null) {
            myViewHolder.mRepoDescription.setText(repo.getDescription());
        } else {
            myViewHolder.mRepoDescription.setText(R.string.vh_repo_desc);
        }

    }

    @Override
    public int getItemCount() {
        return mRepositories.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mRepoName;
        TextView mRepoDescription;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mRepoName = itemView.findViewById(R.id.viewholder_repo_name);
            mRepoDescription =itemView.findViewById(R.id.viewholder_repo_desc);
        }
    }
}
