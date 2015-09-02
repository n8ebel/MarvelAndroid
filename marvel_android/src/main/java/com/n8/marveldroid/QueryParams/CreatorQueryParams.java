package com.n8.marveldroid.QueryParams;

import java.util.Date;
import java.util.List;

/**
 * Defines a query that is used to return {@link com.n8.marveldroid.ModelObjects.Creator} from
 * various endpoints.
 */
public class CreatorQueryParams extends BaseQueryParams {

    public enum OrderBy {
        Default(null),
        LastName("lastName"),
        FistName("firstName"),
        MiddleName("middletName"),
        Suffix("suffix"),
        ModifiedDate("modified"),
        LastNameDescending("-lastName"),
        FirstNameDescending("-firstName"),
        MiddleNameDescending("-middleName"),
        SuffixDescending("-suffix"),
        ModifiedDateDescending("-modified");

        private String mValue;

        OrderBy(String value){
            this.mValue = value;
        }
        public String getValue(){
            return this.mValue;
        }

    }

    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    private String nameStartsWith;
    private String firstNameStartsWith;
    private String middleNameStartsWith;
    private String lastNameStartsWith;

    private Date modifiedSince;

    private List<Integer> comics;
    private List<Integer> events;
    private List<Integer> series;
    private List<Integer> stories;

    private OrderBy orderBy;

    public CreatorQueryParams() {
        super();
        this.orderBy = OrderBy.Default;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getNameStartsWith() {
        return nameStartsWith;
    }

    public void setNameStartsWith(String nameStartsWith) {
        this.nameStartsWith = nameStartsWith;
    }

    public String getFirstNameStartsWith() {
        return firstNameStartsWith;
    }

    public void setFirstNameStartsWith(String firstNameStartsWith) {
        this.firstNameStartsWith = firstNameStartsWith;
    }

    public String getMiddleNameStartsWith() {
        return middleNameStartsWith;
    }

    public void setMiddleNameStartsWith(String middleNameStartsWith) {
        this.middleNameStartsWith = middleNameStartsWith;
    }

    public String getLastNameStartsWith() {
        return lastNameStartsWith;
    }

    public void setLastNameStartsWith(String lastNameStartsWith) {
        this.lastNameStartsWith = lastNameStartsWith;
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

    public List<Integer> getEvents() {
        return events;
    }

    public void setEvents(List<Integer> events) {
        this.events = events;
    }

    public List<Integer> getSeries() {
        return series;
    }

    public void setSeries(List<Integer> series) {
        this.series = series;
    }

    public OrderBy getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(OrderBy orderBy) {
        this.orderBy = orderBy;
    }

    public List<Integer> getStories() {
        return stories;
    }

    public void setStories(List<Integer> stories) {
        this.stories = stories;
    }
}
