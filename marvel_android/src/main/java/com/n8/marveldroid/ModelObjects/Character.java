package com.n8.marveldroid.ModelObjects;

import com.n8.marveldroid.ModelObjects.Summary.ComicSummary;
import com.n8.marveldroid.ModelObjects.Summary.EventSummary;
import com.n8.marveldroid.ModelObjects.Summary.SeriesSummary;
import com.n8.marveldroid.ModelObjects.Summary.StorySummary;

import java.util.Date;
import java.util.List;

/**
 * http://developer.marvel.com/documentation/entity_types
 */
public class Character extends Entity {
    public String name;

    public String description;

    public Date modified;

    public String resourceURI;

    public List<Url> urls;

    public ImageInfo thumbnail;

    public ResourceList<ComicSummary> comics;

    public ResourceList<StorySummary> stories;

    public ResourceList<EventSummary> events;

    public ResourceList<SeriesSummary> series;
}
