package com.n8.marveldroid.RequestServices;

public class ServiceResponse<E>{
    public int code;
    public String status;
    public String etag;
    public DataContainer<E> data;

}
