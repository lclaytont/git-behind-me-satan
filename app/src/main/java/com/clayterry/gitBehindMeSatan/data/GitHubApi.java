package com.clayterry.gitBehindMeSatan.data;

import android.support.annotation.Nullable;

import com.clayterry.gitBehindMeSatan.data.entities.GitHubResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface GitHubApi {

    @Headers(
            "Accept: application/vnd.github.mercy-preview+json"
    )
    @GET("search/topics")
    Call<GitHubResponse> fetchGitHubResponse(@Query("q") String searchParameter,
                                             @Query("page") Integer page,
                                             @Query("per_page") Integer per_page);
}
