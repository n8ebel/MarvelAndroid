package com.n8.marveldroid.EntityModelObjects;

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

    public ItemList series;

    public ItemList stories;

    public ItemList comics;

    public ItemList events;

}
