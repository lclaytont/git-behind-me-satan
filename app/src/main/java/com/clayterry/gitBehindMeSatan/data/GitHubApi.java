package com.clayterry.gitBehindMeSatan.data;

import com.clayterry.gitBehindMeSatan.data.entities.GitHubResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GitHubApi {

    @GET("/search/topics")
    Call<GitHubResponse> fetchGitHubResponse(@Query("q") String searchParameter,
                                             @Query("page") String page,
                                             @Query("per_page") String perPage);
}
