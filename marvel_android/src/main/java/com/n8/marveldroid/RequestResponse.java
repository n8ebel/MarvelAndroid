package com.n8.marveldroid;

import com.n8.marveldroid.ModelObjects.ResultsContainer;

public class RequestResponse<T> {
    public int code;

    public String status;

    public String copyright;

    public String attributionText;

    public String attributionHTML;

    public String etag;

    public ResultsContainer<T> data;
}
