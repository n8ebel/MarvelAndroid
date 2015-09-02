package com.n8.marveldroid.QueryParams;

import java.util.Date;
import java.util.List;

/**
 * Defines a query that is used to return {@link com.n8.marveldroid.ModelObjects.Character} from
 * various endpoints.
 */
public class CharacterQueryParams extends BaseQueryParams {

    public enum OrderBy {
        Default(null),
        Name("name"),
        Date("date"),
        NameDescending("-name"),
        DateDescending("-date");

        private String mValue;

        OrderBy(String value) {
            mValue = value;
        }

        public String getValue() {
            return mValue;
        }
    }

    private String name;
    private String nameStartsWith;

    private Date modifiedSince;

    private List<Integer> comics;
    private List<Integer> series;
    private List<Integer> events;
    private List<Integer> stories;

    private OrderBy orderBy;


    public CharacterQueryParams() {
        super();
        orderBy = OrderBy.Default;
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

    public List<Integer> getComics() {
        return comics;
    }

    public void setComics(List<Integer> comics) {
        this.comics = comics;
    }

    public List<Integer> getSeries() {
        return series;
    }

    public void setSeries(List<Integer> series) {
        this.series = series;
    }

    public List<Integer> getEvents() {
        return events;
    }

    public void setEvents(List<Integer> events) {
        this.events = events;
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
