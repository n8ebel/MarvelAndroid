package com.n8.marveldroid;

import com.n8.marveldroid.EntityModelObjects.ResultsContainer;

public class ServiceResponse<E> {
    public int code;

    public String status;

    public String copyright;

    public String attributionText;

    public String attributionHTML;

    public String etag;

    public ResultsContainer<E> data;
}
