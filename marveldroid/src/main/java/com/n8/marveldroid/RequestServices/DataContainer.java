package com.n8.marveldroid.RequestServices;

import java.util.List;

public class DataContainer <E> {

    public int offset;
    public int limit;
    public int total;
    public int count;
    public List<E> results;

}
