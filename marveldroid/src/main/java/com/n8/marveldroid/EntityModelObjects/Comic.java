package com.n8.marveldroid.EntityModelObjects;

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
    public Item series;
    public List<Item> variants;
    public List<Item> collection;
    public List<Item> collectedIssues;
    public List<ComicDate> dates;
    public List<ComicPrice> prices;
    public ImageInfo thumbnail;
    public List<ImageInfo> images;
    public CreatorList creators;
    public CharacterList characters;
    public ItemList stories;
    public ItemList events;


}
