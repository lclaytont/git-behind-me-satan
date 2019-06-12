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

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Boolean getIncompleteResults() {
        return incompleteResults;
    }

    public void setIncompleteResults(Boolean incompleteResults) {
        this.incompleteResults = incompleteResults;
    }

    public List<Repo> getItems() {
        return items;
    }

    public void setItems(List<Repo> items) {
        this.items = items;
    }
}
