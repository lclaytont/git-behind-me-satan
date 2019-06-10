package com.clayterry.gitBehindMeSatan.data.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GitHubResponse {
    @SerializedName("total_count")
    private Integer totalCount;

    @SerializedName("incomplete_results")
    private Boolean incompleteResults;

    @SerializedName("items")
    List<Repo> items;
}
