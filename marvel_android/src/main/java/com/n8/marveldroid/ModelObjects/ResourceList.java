package com.n8.marveldroid.ModelObjects;

import com.n8.marveldroid.ModelObjects.Summary.Summary;

import java.util.List;

/**
 * http://developer.marvel.com/documentation/entity_types
 *
 * @param <T> An Entity summary type
 */
public class ResourceList<T extends Summary> {
    public int available;

    public int returned;

    public String collectionURI;

    public List<T> items;
}
