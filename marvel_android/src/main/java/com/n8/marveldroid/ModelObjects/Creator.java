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
public class Creator extends Entity{

    public String firstName;

    public String middleName;

    public String lastName;

    public String suffix;

    public String fullName;

    public Date modified;

    public String resourceURI;

    public List<Url> urls;

    public ImageInfo thumbnail;

    public ResourceList<SeriesSummary> series;

    public ResourceList<StorySummary> stories;

    public ResourceList<ComicSummary> comics;

    public ResourceList<EventSummary> events;

}
