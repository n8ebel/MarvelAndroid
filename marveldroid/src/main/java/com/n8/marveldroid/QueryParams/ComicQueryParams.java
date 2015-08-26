package com.n8.marveldroid.QueryParams;

import java.util.Date;
import java.util.List;

public class ComicQueryParams extends BaseQueryParams {

    public enum Format {
        Default(null),
        Comic ("comic"),
        Magazine ("magazine"),
        TradePaperback("trade paperback"),
        Hardcover ("hardcover"),
        Digest ("digest"),
        GraphicNovel ("graphic novel"),
        DigitalComic ("digital comic"),
        InfiniteComic ("infinite comic");

        private String mValue;

        Format(String value){
            mValue = value;
        }

        public String getValue(){
            return mValue;
        }
    }

    public enum FormatType {
        Default(null),
        Comic("comic"),
        Collection("collection");

        private String mValue;

        FormatType(String value){
            mValue = value;
        }

        public String getValue(){
            return mValue;
        }


    }

    public enum DateDescriptor{
        Default(null),
        LastWeek("lastWeek"),
        ThisWeek("thisWeek"),
        NextMonth("nextMonth"),
        ThisMonth("thisMonth");

        private String mValue;

        DateDescriptor(String value){
            mValue = value;
        }

        public String getValue(){
            return mValue;
        }
    }

    public enum OrderBy {
        Default(null),
        FOCDate("focDate"),
        FOCDateDescending("-focDate"),
        OnSaleDate("onsaleDate"),
        OnSaleDateDescending("-onsaleDate"),
        Title("title"),
        TitleDescending("-title"),
        IssueNumber("issueNumber"),
        IssueNumberDescending("-issueNumber"),
        ModifiedDate("modified"),
        ModifiedDateDescending("-modified");


        private String mValue;

        OrderBy(String value){
            mValue = value;
        }

        public String getValue(){
            return mValue;
        }
    }

    private Format format;
    private FormatType formatType;

    private boolean noVariants;

    private DateDescriptor dateDescriptor;
    private String dateRange;

    private String title;
    private String titleStartsWith;

    private int startYear;
    private int issueNumber;
    private String diamondCode;
    private int digitalId;

    private String upc;
    private String isbn;
    private String ean;
    private String issn;

    private boolean hasDigitalIssue;
    private Date modifiedSince;

    private List<Integer> creators;
    private List<Integer> characters;
    private List<Integer> series;
    private List<Integer> events;
    private List<Integer> stories;
    private List<Integer> sharedAppearances;
    private List<Integer> collaborators;

    private OrderBy orderBy;

    public ComicQueryParams() {
        super();
        format = Format.Default;
        formatType = FormatType.Default;
        dateDescriptor = DateDescriptor.Default;
        orderBy = OrderBy.Default;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public FormatType getFormatType() {
        return formatType;
    }

    public void setFormatType(FormatType formatType) {
        this.formatType = formatType;
    }

    public boolean isNoVariants() {
        return noVariants;
    }

    public void setNoVariants(boolean noVariants) {
        this.noVariants = noVariants;
    }

    public DateDescriptor getDateDescriptor() {
        return dateDescriptor;
    }

    public void setDateDescriptor(DateDescriptor dateDescriptor) {
        this.dateDescriptor = dateDescriptor;
    }

    public String getDateRange() {
        return dateRange;
    }

    public void setDateRange(String dateRange) {
        this.dateRange = dateRange;
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

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getDiamondCode() {
        return diamondCode;
    }

    public void setDiamondCode(String diamondCode) {
        this.diamondCode = diamondCode;
    }

    public int getDigitalId() {
        return digitalId;
    }

    public void setDigitalId(int digitalId) {
        this.digitalId = digitalId;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public boolean isHasDigitalIssue() {
        return hasDigitalIssue;
    }

    public void setHasDigitalIssue(boolean hasDigitalIssue) {
        this.hasDigitalIssue = hasDigitalIssue;
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

    public List<Integer> getSharedAppearances() {
        return sharedAppearances;
    }

    public void setSharedAppearances(List<Integer> sharedAppearances) {
        this.sharedAppearances = sharedAppearances;
    }

    public List<Integer> getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(List<Integer> collaborators) {
        this.collaborators = collaborators;
    }

    public OrderBy getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(OrderBy orderBy) {
        this.orderBy = orderBy;
    }
}
