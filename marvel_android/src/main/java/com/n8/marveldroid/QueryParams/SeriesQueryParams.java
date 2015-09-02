package com.n8.marveldroid.QueryParams;

import java.util.Date;
import java.util.List;

/**
 * Defines a query that is used to return {@link com.n8.marveldroid.ModelObjects.Series} from
 * various endpoints.
 */
public class SeriesQueryParams extends BaseQueryParams {

    public enum OrderBy {
        Default(null),
        Title("title"),
        ModifiedDate("modified"),
        StartYear("startYear"),
        TitleDescending("-title"),
        ModifiedDateDescending("-modified"),
        StartYearDescending("-startYear");

        private String mValue;

        OrderBy(String value){
            this.mValue = value;
        }

        public String getValue(){
            return this.mValue;
        }
    }

    public enum SeriesType {
        Default(null),
        Collection("collection"),
        Oneshot("oneshot"),
        Limited("limited"),
        Ongoing("ongoing");

        private String mValue;

        SeriesType(String value){
            this.mValue = value;
        }

        public String getValue(){
            return this.mValue;
        }
    }

    public enum Contains {
        Default(null),
        Comic("comic"),
        Magazine("magazine"),
        TradePaperback("trade paperback"),
        Hardcover("hardcover"),
        Digest("digest"),
        GraphicNovel("graphic novel"),
        DigitalComic("digital comic");

        private String mValue;

        Contains(String value){
            this.mValue = value;
        }

        public String getValue(){
            return this.mValue;
        }
    }

    private String title;
    private String titleStartsWith;

    private Integer startYear;
    private Date modifiedSince;

    private List<Integer> comics;
    private List<Integer> stories;
    private List<Integer> events;
    private List<Integer> creators;
    private List<Integer> characters;

    private SeriesType seriesType;
    private Contains contains;
    private OrderBy orderBy;

    public SeriesQueryParams(){
        super();
        orderBy = OrderBy.Default;
        contains = Contains.Default;
        seriesType = SeriesType.Default;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleStartsWith() {
        return titleStartsWith;
    }

    public void setTitleStartsWith(String titleStartsWith) {
        this.titleStartsWith = titleStartsWith;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
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

    public List<Integer> getStories() {
        return stories;
    }

    public void setStories(List<Integer> stories) {
        this.stories = stories;
    }

    public List<Integer> getEvents() {
        return events;
    }

    public void setEvents(List<Integer> events) {
        this.events = events;
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

    public SeriesType getSeriesType() {
        return seriesType;
    }

    public void setSeriesType(SeriesType seriesType) {
        this.seriesType = seriesType;
    }

    public Contains getContains() {
        return contains;
    }

    public void setContains(Contains contains) {
        this.contains = contains;
    }

    public OrderBy getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(OrderBy orderBy) {
        this.orderBy = orderBy;
    }
}
