package com.n8.marveldroid.EntityModelObjects;

import java.util.List;

public class DataContainer<T> {
    public int offset;

    public int limit;

    public int total;

    public int count;

    public List<T> results;
}
