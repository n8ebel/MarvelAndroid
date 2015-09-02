package com.n8.marveldroid.QueryParams;

import java.util.Date;
import java.util.List;

/**
 * Defines a query that is used to return {@link com.n8.marveldroid.ModelObjects.Event} from
 * various endpoints.
 */
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

    public List<Integer> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Integer> characters) {
        this.characters = characters;
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

    public OrderBy getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(OrderBy orderBy) {
        this.orderBy = orderBy;
    }
}
