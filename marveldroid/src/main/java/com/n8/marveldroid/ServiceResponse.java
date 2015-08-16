package com.n8.marveldroid;

import com.n8.marveldroid.EntityModelObjects.DataContainer;

public class ServiceResponse<E> {
    public int code;
    public String status;
    public String etag;
    public DataContainer<E> data;

}
