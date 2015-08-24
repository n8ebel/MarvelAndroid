package com.n8.marveldroid.Endpoints;

import android.support.annotation.NonNull;

import com.n8.marveldroid.EntityModelObjects.Character;
import com.n8.marveldroid.EntityModelObjects.Comic;
import com.n8.marveldroid.QueryParams.ComicQueryParams;
import com.n8.marveldroid.RequestServices.ComicService;
import com.n8.marveldroid.ServiceResponse;

import retrofit.Callback;
import rx.Observable;

/**
 * Provides methods to retrieve {@link Comic}s from the various rest endpoints
 * (Characters, Events, etc..).
 */
public class ComicEndpoint extends BaseEndpoint {

    private ComicService mComicService;

    public ComicEndpoint(@NonNull ComicService comicService) {
        mComicService = comicService;
    }

    /**
     * Retrieves a {@link Comic} for the specified comicId
     *
     * @param comicId  Unique identifier of the comic to return.
     * @param callback Notifies caller when request is complete.
     */
    public void getComic(int comicId, Callback<ServiceResponse<Comic>> callback) {
        mComicService.getComicForId(
                comicId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                callback);
    }

    /**
     * Retrieves a {@link Character} for the specified character id.
     *
     * @param comicId Unique identifier of the character to retrieve.
     * @return An observable of the character {@link ServiceResponse}.
     */
    public Observable<ServiceResponse<Comic>> getComic(int comicId) {
        return mComicService.getComicForId(
                comicId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature());
    }

    /**
     * Retrieves a list of {@link Comic}
     *
     * @param queryParams Defines the query used to search for and return comics.
     * @param callback    Notifies caller when request is complete.
     */
    public void getComics(ComicQueryParams queryParams, Callback<ServiceResponse<Comic>> callback) {
        mComicService.getComics(
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getFormat().getValue(),
                queryParams.getFormatType().getValue(),
                queryParams.isNoVariants(),
                queryParams.getDateDescriptor().getValue(),
                queryParams.getDateRange(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getIssueNumber(),
                queryParams.getDiamondCode(),
                queryParams.getDigitalId(),
                queryParams.getUpc(),
                queryParams.getIsbn(),
                queryParams.getEan(),
                queryParams.getIssn(),
                queryParams.isHasDigitalIssue(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getSharedAppearances()),
                getJoinedList(queryParams.getCollaborators()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    /**
     * Retrieves a list of {@link Comic}
     *
     * @param queryParams Defines the query used to search for and return comics
     * @return An observable of the comic {@link ServiceResponse}.
     */
    public Observable<ServiceResponse<Comic>> getComics(ComicQueryParams queryParams) {
        return mComicService.getComics(
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getFormat().getValue(),
                queryParams.getFormatType().getValue(),
                queryParams.isNoVariants(),
                queryParams.getDateDescriptor().getValue(),
                queryParams.getDateRange(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getIssueNumber(),
                queryParams.getDiamondCode(),
                queryParams.getDigitalId(),
                queryParams.getUpc(),
                queryParams.getIsbn(),
                queryParams.getEan(),
                queryParams.getIssn(),
                queryParams.isHasDigitalIssue(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getSharedAppearances()),
                getJoinedList(queryParams.getCollaborators()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    /**
     * Retrieves a list of {@link Comic} for the specified character id.
     *
     * @param characterId Unique identifier of the character to return comics for.
     * @param queryParams Defines the query used to search for and return comics
     * @param callback    Notifies caller when request is complete.
     */
    public void getComicsForCharacterId(int characterId, ComicQueryParams queryParams, Callback<ServiceResponse<Comic>> callback) {
        mComicService.getComicsForCharacterId(
                characterId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getFormat().getValue(),
                queryParams.getFormatType().getValue(),
                queryParams.isNoVariants(),
                queryParams.getDateDescriptor().getValue(),
                queryParams.getDateRange(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getIssueNumber(),
                queryParams.getDiamondCode(),
                queryParams.getDigitalId(),
                queryParams.getUpc(),
                queryParams.getIsbn(),
                queryParams.getEan(),
                queryParams.getIssn(),
                queryParams.isHasDigitalIssue(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getSharedAppearances()),
                getJoinedList(queryParams.getCollaborators()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    /**
     * Retrieves a list of {@link Comic} for the specified character id.
     *
     * @param characterId Unique identifier of the character to return comics for.
     * @param queryParams Defines the query used to search for and return comics.
     * @return An observable of the comic {@link ServiceResponse}.
     */
    public Observable<ServiceResponse<Comic>> getComicsForCharacterId(int characterId, ComicQueryParams queryParams) {
        return mComicService.getComicsForCharacterId(
                characterId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getFormat().getValue(),
                queryParams.getFormatType().getValue(),
                queryParams.isNoVariants(),
                queryParams.getDateDescriptor().getValue(),
                queryParams.getDateRange(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getIssueNumber(),
                queryParams.getDiamondCode(),
                queryParams.getDigitalId(),
                queryParams.getUpc(),
                queryParams.getIsbn(),
                queryParams.getEan(),
                queryParams.getIssn(),
                queryParams.isHasDigitalIssue(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getSharedAppearances()),
                getJoinedList(queryParams.getCollaborators()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    /**
     * Retrieves a list of {@link Comic} for the specified creator id.
     *
     * @param creatorId   Unique identifier of the creator to return comics for.
     * @param queryParams Defines the query used to search for and return comics.
     * @param callback    Notifies caller when request is complete.
     */
    public void getComicsForCreatorId(int creatorId, ComicQueryParams queryParams, Callback<ServiceResponse<Comic>> callback) {
        mComicService.getComicsForCreatorId(
                creatorId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getFormat().getValue(),
                queryParams.getFormatType().getValue(),
                queryParams.isNoVariants(),
                queryParams.getDateDescriptor().getValue(),
                queryParams.getDateRange(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getIssueNumber(),
                queryParams.getDiamondCode(),
                queryParams.getDigitalId(),
                queryParams.getUpc(),
                queryParams.getIsbn(),
                queryParams.getEan(),
                queryParams.getIssn(),
                queryParams.isHasDigitalIssue(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getCharacters()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getSharedAppearances()),
                getJoinedList(queryParams.getCollaborators()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    /**
     * Retrieves a list of {@link Comic} for the specified creator id.
     *
     * @param creatorId   Unique identifier of the creator to return comics for.
     * @param queryParams Defines the query used to search for and return comics
     * @return An observable of the comic {@link ServiceResponse}.
     */
    public Observable<ServiceResponse<Comic>> getComicsForCreatorId(int creatorId, ComicQueryParams queryParams) {
        return mComicService.getComicsForCreatorId(
                creatorId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getFormat().getValue(),
                queryParams.getFormatType().getValue(),
                queryParams.isNoVariants(),
                queryParams.getDateDescriptor().getValue(),
                queryParams.getDateRange(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getIssueNumber(),
                queryParams.getDiamondCode(),
                queryParams.getDigitalId(),
                queryParams.getUpc(),
                queryParams.getIsbn(),
                queryParams.getEan(),
                queryParams.getIssn(),
                queryParams.isHasDigitalIssue(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getCharacters()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getSharedAppearances()),
                getJoinedList(queryParams.getCollaborators()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    /**
     * Retrieves a list of {@link Comic} for the specified event id.
     *
     * @param eventId     Unique identifier of the event to return comics for.
     * @param queryParams Defines the query used to search for and return comics.
     * @param callback    Notifies the caller when the request is complete.
     */
    public void getComicsForEventId(int eventId, ComicQueryParams queryParams, Callback<ServiceResponse<Comic>> callback) {
        mComicService.getComicsForEventId(
                eventId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getFormat().getValue(),
                queryParams.getFormatType().getValue(),
                queryParams.isNoVariants(),
                queryParams.getDateDescriptor().getValue(),
                queryParams.getDateRange(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getIssueNumber(),
                queryParams.getDiamondCode(),
                queryParams.getDigitalId(),
                queryParams.getUpc(),
                queryParams.getIsbn(),
                queryParams.getEan(),
                queryParams.getIssn(),
                queryParams.isHasDigitalIssue(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getSharedAppearances()),
                getJoinedList(queryParams.getCollaborators()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    /**
     * Retrieves a list of {@link Comic} for the specified event id.
     *
     * @param eventId     Unique identifier of event to return comics for.
     * @param queryParams Defines the query used to search for and return comics.
     * @return An observable of the comic {@link ServiceResponse}.
     */
    public Observable<ServiceResponse<Comic>> getComicsForEventId(int eventId, ComicQueryParams queryParams) {
        return mComicService.getComicsForEventId(
                eventId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getFormat().getValue(),
                queryParams.getFormatType().getValue(),
                queryParams.isNoVariants(),
                queryParams.getDateDescriptor().getValue(),
                queryParams.getDateRange(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getIssueNumber(),
                queryParams.getDiamondCode(),
                queryParams.getDigitalId(),
                queryParams.getUpc(),
                queryParams.getIsbn(),
                queryParams.getEan(),
                queryParams.getIssn(),
                queryParams.isHasDigitalIssue(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getSharedAppearances()),
                getJoinedList(queryParams.getCollaborators()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    /**
     * Retrieves a list of {@link Comic} for the specified series id.
     *
     * @param seriesId    Unique identifier of the series to return comics for.
     * @param queryParams Defines the query used to search for and return comics.
     * @param callback    Notifies the caller when request is complete.
     */
    public void getComicsForSeriesId(int seriesId, ComicQueryParams queryParams, Callback<ServiceResponse<Comic>> callback) {
        mComicService.getComicsForSeriesId(
                seriesId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getFormat().getValue(),
                queryParams.getFormatType().getValue(),
                queryParams.isNoVariants(),
                queryParams.getDateDescriptor().getValue(),
                queryParams.getDateRange(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getIssueNumber(),
                queryParams.getDiamondCode(),
                queryParams.getDigitalId(),
                queryParams.getUpc(),
                queryParams.getIsbn(),
                queryParams.getEan(),
                queryParams.getIssn(),
                queryParams.isHasDigitalIssue(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getSharedAppearances()),
                getJoinedList(queryParams.getCollaborators()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    /**
     * Retrieves a list of {@link Comic} for the specified series id.
     *
     * @param seriesId    Unique identifier of the series to return comics for.
     * @param queryParams Defines the query used to search for and return comics.
     * @return An observable of the comic {@link ServiceResponse}.
     */
    public Observable<ServiceResponse<Comic>> getComicsForSeriesId(int seriesId, ComicQueryParams queryParams) {
        return mComicService.getComicsForSeriesId(
                seriesId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getFormat().getValue(),
                queryParams.getFormatType().getValue(),
                queryParams.isNoVariants(),
                queryParams.getDateDescriptor().getValue(),
                queryParams.getDateRange(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getIssueNumber(),
                queryParams.getDiamondCode(),
                queryParams.getDigitalId(),
                queryParams.getUpc(),
                queryParams.getIsbn(),
                queryParams.getEan(),
                queryParams.getIssn(),
                queryParams.isHasDigitalIssue(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getSharedAppearances()),
                getJoinedList(queryParams.getCollaborators()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    /**
     * Retrieves a list of {@link Comic} for the specified story id.
     *
     * @param storyId     Unique identifier of the story to return comics for.
     * @param queryParams Defines the query used to search for and return comics.
     * @param callback    Notifies caller that the request is compelte.
     */
    public void getComicsForStoryId(int storyId, ComicQueryParams queryParams, Callback<ServiceResponse<Comic>> callback) {
        mComicService.getComicsForStoryId(
                storyId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getFormat().getValue(),
                queryParams.getFormatType().getValue(),
                queryParams.isNoVariants(),
                queryParams.getDateDescriptor().getValue(),
                queryParams.getDateRange(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getIssueNumber(),
                queryParams.getDiamondCode(),
                queryParams.getDigitalId(),
                queryParams.getUpc(),
                queryParams.getIsbn(),
                queryParams.getEan(),
                queryParams.getIssn(),
                queryParams.isHasDigitalIssue(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getSharedAppearances()),
                getJoinedList(queryParams.getCollaborators()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    /**
     * Retrieves a list of {@link Comic} for the specified story id.
     *
     * @param storyId     Unique identifier of the story to return comics for.
     * @param queryParams Defines the query used to search for and return comics.
     * @return An observable of the comic {@link ServiceResponse}.
     */
    public Observable<ServiceResponse<Comic>> getComicsForStoryId(int storyId, ComicQueryParams queryParams) {
        return mComicService.getComicsForStoryId(
                storyId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getFormat().getValue(),
                queryParams.getFormatType().getValue(),
                queryParams.isNoVariants(),
                queryParams.getDateDescriptor().getValue(),
                queryParams.getDateRange(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getIssueNumber(),
                queryParams.getDiamondCode(),
                queryParams.getDigitalId(),
                queryParams.getUpc(),
                queryParams.getIsbn(),
                queryParams.getEan(),
                queryParams.getIssn(),
                queryParams.isHasDigitalIssue(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getSharedAppearances()),
                getJoinedList(queryParams.getCollaborators()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }


}
