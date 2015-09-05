package com.n8.marveldroid.Endpoints;

import android.support.annotation.NonNull;

import com.n8.marveldroid.ModelObjects.Series;
import com.n8.marveldroid.QueryParams.SeriesQueryParams;
import com.n8.marveldroid.RequestServices.SeriesService;
import com.n8.marveldroid.RequestResponse;

import retrofit.Callback;
import rx.Observable;

/**
 * Provides methods to retrieve series from the various rest endpoints (Character, Event, etc)
 */
public class SeriesEndpoint extends BaseEndpoint {

    private SeriesService mSeriesService;

    public SeriesEndpoint(@NonNull SeriesService seriesService, @NonNull String publicKey, @NonNull String privateKey) {
        super(publicKey, privateKey);
        mSeriesService = seriesService;
    }

    /**
     * Retrieves a {@link Series} for the specified seriesId
     *
     * @param seriesId  Unique identifier of the series to return
     * @param callback  Notifies caller that the request is complete
     */
    public void getSeriesForId(int seriesId, Callback<RequestResponse<Series>> callback) {
        mSeriesService.getSeriesForId(seriesId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                callback);
    }

    /**
     * Retrieves a {@link Series} for the specified seriesId
     *
     * @param seriesId  Unique identifier of the series to return
     *
     * @return  An observable of the series {@link RequestResponse}
     */
    public Observable<RequestResponse<Series>> getSeriesForId(int seriesId) {
        return mSeriesService.getSeriesForId(seriesId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature());
    }

    /**
     * Retrieves a list of {@link Series}
     *
     * @param queryParams   Defines the query used to search for and return series
     * @param callback  Notifies caller that the request is complete
     */
    public void getSeries(@NonNull SeriesQueryParams queryParams, Callback<RequestResponse<Series>> callback) {
        mSeriesService.getSeries(
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                queryParams.getSeriesType().getValue(),
                queryParams.getContains().getValue(),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    /**
     * Retrieves a list of {@link Series}
     *
     * @param queryParams   Defines the query used to search for and return series
     *
     * @return  An observable of the series {@link RequestResponse}
     */
    public Observable<RequestResponse<Series>> getSeries(@NonNull SeriesQueryParams queryParams) {
        return mSeriesService.getSeries(
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                queryParams.getSeriesType().getValue(),
                queryParams.getContains().getValue(),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    /**
     * Retrieves a list of {@link Series} for the specified characterId
     *
     * @param characterId   Unique identifier of the character to return series for
     * @param queryParams   Defines the query used to search for and return series
     * @param callback  Notifies the caller that the request is complete
     */
    public void getSeriesForCharacterId(int characterId, @NonNull SeriesQueryParams queryParams, Callback<RequestResponse<Series>> callback) {
        mSeriesService.getSeriesForCharacterId(
                characterId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getCreators()),
                queryParams.getSeriesType().getValue(),
                queryParams.getContains().getValue(),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    /**
     * Retrieves a list of {@link Series} for the specified characterId
     *
     * @param characterId   Unique identifier of the character to return series for
     * @param queryParams   Defines the query used to search for and return series
     *
     * @return An observable of the series {@link RequestResponse}
     */
    public Observable<RequestResponse<Series>> getSeriesForCharacterId(int characterId, @NonNull SeriesQueryParams queryParams) {
        return mSeriesService.getSeriesForCharacterId(
                characterId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getCreators()),
                queryParams.getSeriesType().getValue(),
                queryParams.getContains().getValue(),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    /**
     * Retrieves a list of {@link Series} for the specified creatorId
     *
     * @param creatorId   Unique identifier of the creator to return series for
     * @param queryParams   Defines the query used to search for and return series
     * @param callback  Notifies the caller that the request is complete
     */
    public void getSeriesForCreatorId(int creatorId, @NonNull SeriesQueryParams queryParams, Callback<RequestResponse<Series>> callback) {
        mSeriesService.getSeriesForCreatorId(
                creatorId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getCharacters()),
                queryParams.getSeriesType().getValue(),
                queryParams.getContains().getValue(),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    /**
     * Retrieves a list of {@link Series} for the specified creatorId
     *
     * @param creatorId   Unique identifier of the creator to return series for
     * @param queryParams   Defines the query used to search for and return series
     *
     * @return An observable of the series {@link RequestResponse}
     */
    public Observable<RequestResponse<Series>> getSeriesForCreatorId(int creatorId, @NonNull SeriesQueryParams queryParams) {
        return mSeriesService.getSeriesForCreatorId(
                creatorId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getCharacters()),
                queryParams.getSeriesType().getValue(),
                queryParams.getContains().getValue(),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    /**
     * Retrieves a list of {@link Series} for the specified eventId
     *
     * @param eventId   Unique identifier of the eventId to return series for
     * @param queryParams   Defines the query used to search for and return series
     * @param callback  Notifies the caller that the request is complete
     */
    public void getSeriesForEventId(int eventId, @NonNull SeriesQueryParams queryParams, Callback<RequestResponse<Series>> callback) {
        mSeriesService.getSeriesForEventId(
                eventId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                queryParams.getSeriesType().getValue(),
                queryParams.getContains().getValue(),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    /**
     * Retrieves a list of {@link Series} for the specified eventId
     *
     * @param eventId   Unique identifier of the event to return series for
     * @param queryParams   Defines the query used to search for and return series
     *
     * @return An observable of the series {@link RequestResponse}
     */
    public Observable<RequestResponse<Series>> getSeriesForEventId(int eventId, @NonNull SeriesQueryParams queryParams) {
        return mSeriesService.getSeriesForEventId(
                eventId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                queryParams.getSeriesType().getValue(),
                queryParams.getContains().getValue(),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    /**
     * Retrieves a list of {@link Series} for the specified storyId
     *
     * @param storyId   Unique identifier of the story to return series for
     * @param queryParams   Defines the query used to search for and return series
     * @param callback  Notifies the caller that the request is complete
     */
    public void getSeriesForStoryId(int storyId, @NonNull SeriesQueryParams queryParams, Callback<RequestResponse<Series>> callback) {
        mSeriesService.getSeriesForStoryId(
                storyId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                queryParams.getSeriesType().getValue(),
                queryParams.getContains().getValue(),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    /**
     * Retrieves a list of {@link Series} for the specified storyId
     *
     * @param storyId   Unique identifier of the story to return series for
     * @param queryParams   Defines the query used to search for and return series
     *
     * @return An observable of the series {@link RequestResponse}
     */
    public Observable<RequestResponse<Series>> getSeriesForStoryId(int storyId, @NonNull SeriesQueryParams queryParams) {
        return mSeriesService.getSeriesForStoryId(
                storyId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                queryParams.getSeriesType().getValue(),
                queryParams.getContains().getValue(),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }
}
