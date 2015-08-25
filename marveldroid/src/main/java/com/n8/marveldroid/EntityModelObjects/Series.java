package com.n8.marveldroid.EntityModelObjects;

import com.n8.marveldroid.EntityModelObjects.List.ResourceList;
import com.n8.marveldroid.EntityModelObjects.Summary.CharacterSummary;
import com.n8.marveldroid.EntityModelObjects.Summary.ComicSummary;
import com.n8.marveldroid.EntityModelObjects.Summary.CreatorSummary;
import com.n8.marveldroid.EntityModelObjects.Summary.EventSummary;
import com.n8.marveldroid.EntityModelObjects.Summary.SeriesSummary;
import com.n8.marveldroid.EntityModelObjects.Summary.StorySummary;

import java.util.Date;
import java.util.List;

public class Series extends Entity {

    public String title;

    public String description;

    public String resourceURI;

    public List<Url> urls;

    public int startYear;

    public int endYear;

    public String rating;

    public Date modified;

    public ImageInfo thumbnail;

    public ResourceList<ComicSummary> comics;

    public ResourceList<StorySummary> stories;

    public ResourceList<EventSummary> events;

    public ResourceList<CharacterSummary> characters;

    public ResourceList<CreatorSummary> creators;

    public SeriesSummary next;

    public SeriesSummary previous;
}
