package com.almosafer.models;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pojopost {

    private String productId;
    private String sortBy;
    private String totalResults;
    private String totalPages;
    private String pageSize;
    private String currentPageNumber;
    private String nextPageUrl;
    private String checkout;

    public Pojopost(){

    }


    public Pojopost (String productId ,String sortBy){
        this.productId = productId;
        this.sortBy = sortBy;

    }



    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(String totalPages) {
        this.totalPages = totalPages;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getCurrentPageNumber() {
        return currentPageNumber;
    }

    public void setCurrentPageNumber(String currentPageNumber) {
        this.currentPageNumber = currentPageNumber;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }


    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }



    public String getProductId() {

        return productId;
    }


    public void setProductId(String productId) {

        this.productId = productId;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {

        this.sortBy = sortBy;
    }


}
