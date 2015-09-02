package com.n8.marveldroid.ModelObjects;

import com.n8.marveldroid.ModelObjects.Summary.CharacterSummary;
import com.n8.marveldroid.ModelObjects.Summary.ComicSummary;
import com.n8.marveldroid.ModelObjects.Summary.CreatorSummary;
import com.n8.marveldroid.ModelObjects.Summary.SeriesSummary;

import java.util.Date;

/**
 * http://developer.marvel.com/documentation/entity_types
 */
public class Story extends Entity {

    public String title;

    public String description;

    public String resourceURI;

    public String type;

    public Date modified;

    public ImageInfo thumbnail;

    public ResourceList<ComicSummary> comics;

    public ResourceList<SeriesSummary> series;

    public ResourceList<CharacterSummary> characters;

    public ResourceList<CreatorSummary> creators;

    public ComicSummary originalIssue;

}

