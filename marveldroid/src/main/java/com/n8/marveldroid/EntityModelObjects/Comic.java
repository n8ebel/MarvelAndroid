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
    public ResourceList<ComicSummary> variants;
    public ResourceList<ComicSummary> collection;
    public ResourceList<ComicSummary> collectedIssues;
    public List<ComicDate> dates;
    public List<ComicPrice> prices;
    public ImageInfo thumbnail;
    public List<ImageInfo> images;
    public ResourceList<CreatorSummary> creators;
    public ResourceList<CharacterSummary> characters;
    public ResourceList<StorySummary> stories;
    public ResourceList<EventSummary> events;


}
