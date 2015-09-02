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
public class Comic extends Entity {
    public int digitalId;
    public String title;
    public double issueNumber;

    public String variantDescription;
    public String description;

    public Date modified;

    public String isbn;
    public String upc;
    public String diamondCode;
    public String ean;
    public String issn;

    public String format;
    public int pageCount;
    public List<TextObject> textObjects;
    public String resourceURI;
    public List<Url> urls;

    public SeriesSummary series;

    public List<ComicSummary> variants;
    public List<ComicSummary> collection;
    public List<ComicSummary> collectedIssues;

    public List<ComicDate> dates;
    public List<ComicPrice> prices;

    public ImageInfo thumbnail;
    public List<ImageInfo> images;

    public ResourceList<CreatorSummary> creators;
    public ResourceList<CharacterSummary> characters;
    public ResourceList<StorySummary> stories;
    public ResourceList<EventSummary> events;


}
