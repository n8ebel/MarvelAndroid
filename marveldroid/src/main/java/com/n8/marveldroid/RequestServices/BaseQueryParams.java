package com.n8.marveldroid.RequestServices;

import com.n8.marveldroid.RequestSignature;

public class BaseQueryParams {

    private static final int DEFAULT_QUERY_LIMIT = 20;

    private RequestSignature mRequestSignature;
    private int mQueryLimit;
    private int mQueryOffset;

    public BaseQueryParams(RequestSignature requestSignature){
        mRequestSignature = requestSignature;
        mQueryLimit = DEFAULT_QUERY_LIMIT;
    }

    public long getTimestamp(){
        return mRequestSignature.getTimeStamp();
    }

    public String getHashSignature(){
        return mRequestSignature.getHashSignature();
    }

    public String getApiKey(){
        return RequestSignature.sPublicKey;
    }

    public int getLimit() {
        return mQueryLimit;
    }

    public void setLimit(int limit) {
        mQueryLimit = limit;
    }

    public int getOffset() {
        return mQueryOffset;
    }

    public void setOffset(int offset) {
        mQueryOffset = offset;
    }

}