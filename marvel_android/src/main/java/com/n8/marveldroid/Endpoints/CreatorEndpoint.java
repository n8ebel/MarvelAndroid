package com.n8.marveldroid.Endpoints;

import android.support.annotation.NonNull;

import com.n8.marveldroid.ModelObjects.Creator;
import com.n8.marveldroid.QueryParams.CreatorQueryParams;
import com.n8.marveldroid.RequestServices.CreatorService;
import com.n8.marveldroid.RequestResponse;

import retrofit.Callback;
import rx.Observable;

/**
 * Provides methods to retrieve {@link Creator}s for the various rest endpoints (Event, Story, etc).
 */
public class CreatorEndpoint extends BaseEndpoint {
    private CreatorService mCreatorService;

    public CreatorEndpoint(@NonNull CreatorService creatorService) {
        mCreatorService = creatorService;
    }

    /**
     * Retrieves a {@link Creator} for the specified creatorId
     *
     * @param creatorId Unique identifier of the creator to retrieve
     * @param callback  Notifes caller when the request is complete
     */
    public void getCreator(int creatorId, Callback<RequestResponse<Creator>> callback) {
        mCreatorService.getCreatorForId(
                creatorId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                callback);

    }

    /**
     * Retrieves a {@link Creator} for the specified creatorId
     *
     * @param creatorId Unique identifier of the creator to retrieve
     *
     * @return An observable of the creator {@link RequestResponse}
     */
    public Observable<RequestResponse<Creator>> getCreator(int creatorId) {
        return mCreatorService.getCreatorForId(
                creatorId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature());
    }

    /**
     * Retrieves a list of {@link Creator}
     *
     * @param queryParams   Defines the query used to search for and return creators
     * @param callback  Notifies caller when request is complete
     */
    public void getCreators(CreatorQueryParams queryParams, Callback<RequestResponse<Creator>> callback) {
        mCreatorService.getCreators(
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getFirstName(),
                queryParams.getMiddleName(),
                queryParams.getLastName(),
                queryParams.getSuffix(),
                queryParams.getNameStartsWith(),
                queryParams.getFirstNameStartsWith(),
                queryParams.getMiddleNameStartsWith(),
                queryParams.getLastNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    /**
     * Retrieves a list of {@link Creator}
     *
     * @param queryParams   Defines the query used to search for and return creators
     *
     * @return An observable of the creator {@link RequestResponse}
     */
    public Observable<RequestResponse<Creator>> getCreators(CreatorQueryParams queryParams) {
        return mCreatorService.getCreators(
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getFirstName(),
                queryParams.getMiddleName(),
                queryParams.getLastName(),
                queryParams.getSuffix(),
                queryParams.getNameStartsWith(),
                queryParams.getFirstNameStartsWith(),
                queryParams.getMiddleNameStartsWith(),
                queryParams.getLastNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    /**
     * Retrieves a list of {@link Creator} for the specified comicId
     *
     * @param comicId   Unique identifier of the comic to retrieve creators for
     * @param queryParams   Defines the query used to search for and return creators
     * @param callback  Notifies caller when request is complete
     */
    public void getCreatorsForComicId(int comicId, CreatorQueryParams queryParams, Callback<RequestResponse<Creator>> callback) {
        mCreatorService.getCreatorsForComicId(
                comicId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getFirstName(),
                queryParams.getMiddleName(),
                queryParams.getLastName(),
                queryParams.getSuffix(),
                queryParams.getNameStartsWith(),
                queryParams.getFirstNameStartsWith(),
                queryParams.getMiddleNameStartsWith(),
                queryParams.getLastNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    /**
     * Retrieves a list of {@link Creator} for the specified comicId
     *
     * @param comicId   Unique identifier of the comic to retrieve creators for
     * @param queryParams   Defines the query used to search for and return creators
     *
     * @return An observable of the creator {@link RequestResponse}
     */
    public Observable<RequestResponse<Creator>> getCreatorsForComicId(int comicId, CreatorQueryParams queryParams) {
        return mCreatorService.getCreatorsForComicId(
                comicId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getFirstName(),
                queryParams.getMiddleName(),
                queryParams.getLastName(),
                queryParams.getSuffix(),
                queryParams.getNameStartsWith(),
                queryParams.getFirstNameStartsWith(),
                queryParams.getMiddleNameStartsWith(),
                queryParams.getLastNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    /**
     * Retrieves a list of {@link Creator} for the specified eventId
     *
     * @param eventId   Unique identifier of the event to retrieve creators for
     * @param queryParams   Defines the query used to search for and return creators
     * @param callback  Notifies caller when request is complete
     */
    public void getCreatorsForEventId(int eventId, CreatorQueryParams queryParams, Callback<RequestResponse<Creator>> callback) {
        mCreatorService.getCreatorsForEventId(
                eventId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getFirstName(),
                queryParams.getMiddleName(),
                queryParams.getLastName(),
                queryParams.getSuffix(),
                queryParams.getNameStartsWith(),
                queryParams.getFirstNameStartsWith(),
                queryParams.getMiddleNameStartsWith(),
                queryParams.getLastNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    /**
     * Retrieves a list of {@link Creator} for the specified eventId
     *
     * @param eventId   Unique identifier of the event to retrieve creators for
     * @param queryParams   Defines the query used to search for and return creators
     *
     * @return An observable of the creator {@link RequestResponse}
     */
    public Observable<RequestResponse<Creator>> getCreatorsForEventId(int eventId, CreatorQueryParams queryParams) {
        return mCreatorService.getCreatorsForEventId(
                eventId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getFirstName(),
                queryParams.getMiddleName(),
                queryParams.getLastName(),
                queryParams.getSuffix(),
                queryParams.getNameStartsWith(),
                queryParams.getFirstNameStartsWith(),
                queryParams.getMiddleNameStartsWith(),
                queryParams.getLastNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    /**
     * Retrieves a list of {@link Creator} for the specified series
     *
     * @param seriesId   Unique identifier of the series to retrieve creators for
     * @param queryParams   Defines the query used to search for and return creators
     * @param callback  Notifies caller when request is complete
     */
    public void getCreatorsForSeriesId(int seriesId, CreatorQueryParams queryParams, Callback<RequestResponse<Creator>> callback) {
        mCreatorService.getCreatorsForSeriesId(
                seriesId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getFirstName(),
                queryParams.getMiddleName(),
                queryParams.getLastName(),
                queryParams.getSuffix(),
                queryParams.getNameStartsWith(),
                queryParams.getFirstNameStartsWith(),
                queryParams.getMiddleNameStartsWith(),
                queryParams.getLastNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    /**
     * Retrieves a list of {@link Creator} for the specified seriesId
     *
     * @param seriesId   Unique identifier of the series to retrieve creators for
     * @param queryParams   Defines the query used to search for and return creators
     *
     * @return An observable of the creator {@link RequestResponse}
     */
    public Observable<RequestResponse<Creator>> getCreatorsForSeriesId(int seriesId, CreatorQueryParams queryParams) {
        return mCreatorService.getCreatorsForSeriesId(
                seriesId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getFirstName(),
                queryParams.getMiddleName(),
                queryParams.getLastName(),
                queryParams.getSuffix(),
                queryParams.getNameStartsWith(),
                queryParams.getFirstNameStartsWith(),
                queryParams.getMiddleNameStartsWith(),
                queryParams.getLastNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    /**
     * Retrieves a list of {@link Creator} for the specified storyId
     *
     * @param storyId   Unique identifier of the story to retrieve creators for
     * @param queryParams   Defines the query used to search for and return creators
     * @param callback  Notifies caller when request is complete
     */
    public void getCreatorsForStoryId(int storyId, CreatorQueryParams queryParams, Callback<RequestResponse<Creator>> callback) {
        mCreatorService.getCreatorsForStoryId(
                storyId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getFirstName(),
                queryParams.getMiddleName(),
                queryParams.getLastName(),
                queryParams.getSuffix(),
                queryParams.getNameStartsWith(),
                queryParams.getFirstNameStartsWith(),
                queryParams.getMiddleNameStartsWith(),
                queryParams.getLastNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    /**
     * Retrieves a list of {@link Creator} for the specified storyId
     *
     * @param storyId   Unique identifier of the story to retrieve creators for
     * @param queryParams   Defines the query used to search for and return creators
     *
     * @return An observable of the creator {@link RequestResponse}
     */
    public Observable<RequestResponse<Creator>> getCreatorsForStoryId(int storyId, CreatorQueryParams queryParams) {
        return mCreatorService.getCreatorsForStoryId(
                storyId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getFirstName(),
                queryParams.getMiddleName(),
                queryParams.getLastName(),
                queryParams.getSuffix(),
                queryParams.getNameStartsWith(),
                queryParams.getFirstNameStartsWith(),
                queryParams.getMiddleNameStartsWith(),
                queryParams.getLastNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }


}
