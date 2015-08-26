package com.n8.marveldroid.EntityModelObjects;

import com.n8.marveldroid.EntityModelObjects.List.ResourceList;
import com.n8.marveldroid.EntityModelObjects.Summary.ComicSummary;

import java.util.Date;

public class Story extends Entity {

    public String title;

    public String description;

    public String resourceURI;

    public String type;

    public Date modified;

    public ImageInfo thumbnail;

    public ResourceList<Comic> comics;

    public ResourceList<Series> series;

    public ResourceList<Character> characters;

    public ResourceList<Creator> creators;

    public ComicSummary originalIssue;

}

