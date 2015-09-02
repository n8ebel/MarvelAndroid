package com.n8.marveldroid.QueryParams;

public class BaseQueryParams {

    private static final int DEFAULT_QUERY_LIMIT = 20;
    private static final int DEFAULT_QUERY_OFFSET = 0;

    private int mQueryLimit;

    private int mQueryOffset;

    public BaseQueryParams() {
        mQueryLimit = DEFAULT_QUERY_LIMIT;
        mQueryOffset = DEFAULT_QUERY_OFFSET;
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