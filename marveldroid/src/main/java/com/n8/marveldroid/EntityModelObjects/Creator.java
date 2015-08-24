package com.n8.marveldroid.EntityModelObjects;

import com.n8.marveldroid.EntityModelObjects.List.ResourceList;
import com.n8.marveldroid.EntityModelObjects.Summary.ComicSummary;
import com.n8.marveldroid.EntityModelObjects.Summary.EventSummary;
import com.n8.marveldroid.EntityModelObjects.Summary.SeriesSummary;
import com.n8.marveldroid.EntityModelObjects.Summary.StorySummary;

import java.util.Date;
import java.util.List;

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
