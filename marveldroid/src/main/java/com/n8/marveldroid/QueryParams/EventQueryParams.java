package com.n8.marveldroid.QueryParams;

import com.n8.marveldroid.RequestSignature;

import java.util.Date;
import java.util.List;

public class EventQueryParams extends BaseQueryParams {

    public enum OrderBy {
        Default(null),
        Name("name"),
        StartDate("startDate"),
        ModifiedDate("modified"),
        NameDescending("-name"),
        StartDateDescending("-startDate"),
        ModifiedDateDescending("-modified");

        private String mValue;

        OrderBy(String value){
            this.mValue = value;
        }

        public String getValue(){
            return this.mValue;
        }
    }

    private String name;
    private String nameStartsWith;

    private Date modifiedSince;

    private List<Integer> creators;
    private List<Integer> characters;
    private List<Integer> series;
    private List<Integer> comics;
    private List<Integer> stories;

    private OrderBy orderBy;

    private int limit;
    private int offset;

    public EventQueryParams() {
        super();
        this.orderBy = OrderBy.Default;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameStartsWith() {
        return nameStartsWith;
    }

    public void setNameStartsWith(String nameStartsWith) {
        this.nameStartsWith = nameStartsWith;
    }

    public Date getModifiedSince() {
        return modifiedSince;
    }

    public void setModifiedSince(Date modifiedSince) {
        this.modifiedSince = modifiedSince;
    }

    public List<Integer> getCreators() {
        return creators;
    }

    public void setCreators(List<Integer> creators) {
        this.creators = creators;
    }

    public List<Integer> getSeries() {
        return series;
    }

    public void setSeries(List<Integer> series) {
        this.series = series;
    }

    public List<Integer> getComics() {
        return comics;
    }

    public void setComics(List<Integer> comics) {
        this.comics = comics;
    }

    public List<Integer> getStories() {
        return stories;
    }

    public void setStories(List<Integer> stories) {
        this.stories = stories;
    }

    public List<Integer> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Integer> characters) {
        this.characters = characters;
    }

    public OrderBy getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(OrderBy orderBy) {
        this.orderBy = orderBy;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
