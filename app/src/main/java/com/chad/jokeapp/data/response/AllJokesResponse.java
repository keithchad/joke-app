package com.chad.jokeapp.data.response;

import java.util.List;

import com.chad.jokeapp.data.model.AllJokes;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllJokesResponse {

    @SerializedName("current_page")
    @Expose
    private Integer currentPage;

    @SerializedName("next_page")
    @Expose
    private Integer nextPage;

    @SerializedName("results")
    @Expose
    private List<AllJokes> allJokes;

    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public List<AllJokes> getAllJokes() {
        return allJokes;
    }

    public void setAllJokes(List<AllJokes> allJokes) {
        this.allJokes = allJokes;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }
}


