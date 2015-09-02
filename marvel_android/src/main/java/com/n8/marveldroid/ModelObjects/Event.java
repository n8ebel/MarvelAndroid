package com.n8.marveldroid.ModelObjects;

import com.n8.marveldroid.ModelObjects.Summary.CharacterSummary;
import com.n8.marveldroid.ModelObjects.Summary.ComicSummary;
import com.n8.marveldroid.ModelObjects.Summary.CreatorSummary;
import com.n8.marveldroid.ModelObjects.Summary.EventSummary;
import com.n8.marveldroid.ModelObjects.Summary.SeriesSummary;
import com.n8.marveldroid.ModelObjects.Summary.StorySummary;

import java.util.Date;
import java.util.List;

/**
 * http://developer.marvel.com/documentation/entity_types
 */
public class Event extends Entity{

    public String title;

    public String description;

    public String resourceURI;

    public List<Url> urls;

    public Date modified;

    public Date start;

    public Date end;

    public ImageInfo thumbnail;

    public ResourceList<ComicSummary> comics;

    public ResourceList<StorySummary> stories;

    public ResourceList<SeriesSummary> series;

    public ResourceList<CharacterSummary> characters;

    public ResourceList<CreatorSummary> creators;

    public EventSummary next;

    public EventSummary previous;
}
