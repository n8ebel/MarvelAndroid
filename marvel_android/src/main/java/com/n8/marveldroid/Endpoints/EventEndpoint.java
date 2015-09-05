package com.n8.marveldroid.Endpoints;

import android.support.annotation.NonNull;

import com.n8.marveldroid.ModelObjects.Event;
import com.n8.marveldroid.QueryParams.EventQueryParams;
import com.n8.marveldroid.RequestServices.EventService;
import com.n8.marveldroid.RequestResponse;

import retrofit.Callback;
import rx.Observable;

/**
 * Provides methods to retrieve {@link Event}s from the various endpoints (Character, Stories, ect.)
 */
public class EventEndpoint extends BaseEndpoint {
    private EventService mEventService;

    public EventEndpoint(@NonNull EventService eventService, @NonNull String publicKey, @NonNull String privateKey) {
        super(publicKey, privateKey);
        mEventService = eventService;
    }

    /**
     * Retrieves a {@link Event} for the specified eventId
     *
     * @param eventId   Unique identifier of the event to retrieve
     * @param callback  Notifies caller when the request is complete
     */
    public void getEvent(int eventId, Callback<RequestResponse<Event>> callback) {
        mEventService.getEventForId(
                eventId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                callback);
    }

    /**
     * Retrieves a {@link Event} for the specified eventId
     *
     * @param eventId Unique identifier of the event to retrieve
     *
     * @return  An observable of the event {@link RequestResponse}
     */
    public Observable<RequestResponse<Event>> getEvent(int eventId) {
        return mEventService.getEventForId(
                eventId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature());
    }

    /**
     * Retrieves a list of {@link Event}
     *
     * @param queryParams   Defines the query used to search for and return events
     * @param callback  Notifies caller that the request is complete
     */
    public void getEvents(@NonNull EventQueryParams queryParams, Callback<RequestResponse<Event>> callback) {
        mEventService.getEvents(
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getCommaSeparatedList(queryParams.getCreators()),
                getCommaSeparatedList(queryParams.getCharacters()),
                getCommaSeparatedList(queryParams.getSeries()),
                getCommaSeparatedList(queryParams.getComics()),
                getCommaSeparatedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    /**
     * Retrieves a list of {@link Event}
     *
     * @param queryParams Defines the query used to search for and return events
     *
     * @return  An observable of the event {@link RequestResponse}
     */
    public Observable<RequestResponse<Event>> getEvents(@NonNull EventQueryParams queryParams) {
        return mEventService.getEvents(
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getCommaSeparatedList(queryParams.getCreators()),
                getCommaSeparatedList(queryParams.getCharacters()),
                getCommaSeparatedList(queryParams.getSeries()),
                getCommaSeparatedList(queryParams.getComics()),
                getCommaSeparatedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    /**
     * Retrieves a list of {@link Event} for the specified characterId
     *
     * @param characterId   Unique identifier for the character to retrieve events for
     * @param queryParams   Defines the query used to serach for and return events
     * @param callback  Notifies caller when request is complete
     */
    public void getEventsForCharacterId(int characterId, @NonNull EventQueryParams queryParams, Callback<RequestResponse<Event>> callback) {
        mEventService.getEventsForCharacterId(
                characterId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getCommaSeparatedList(queryParams.getCreators()),
                getCommaSeparatedList(queryParams.getSeries()),
                getCommaSeparatedList(queryParams.getComics()),
                getCommaSeparatedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback
        );
    }

    /**
     * Retrieves a list of {@link Event} for the specified characterId
     *
     * @param characterId   Unique identifier for the character to retrieve events for
     * @param queryParams   Defines the query used to serach for and return events
     *
     * @return  An observable of the event {@link RequestResponse}
     */
    public Observable<RequestResponse<Event>> getEventsForCharacterId(int characterId, @NonNull EventQueryParams queryParams) {
        return mEventService.getEventsForCharacterId(
                characterId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getCommaSeparatedList(queryParams.getCreators()),
                getCommaSeparatedList(queryParams.getSeries()),
                getCommaSeparatedList(queryParams.getComics()),
                getCommaSeparatedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    /**
     * Retrieves a list of {@link Event} for the specified comicId
     *
     * @param comicId   Unique identifier for the comic to retrieve events for
     * @param queryParams   Defines the query used to serach for and return events
     * @param callback  Notifies caller when request is complete
     */
    public void getEventsForComicId(int comicId, @NonNull EventQueryParams queryParams, Callback<RequestResponse<Event>> callback) {
        mEventService.getEventsForComicId(
                comicId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getCommaSeparatedList(queryParams.getCreators()),
                getCommaSeparatedList(queryParams.getCharacters()),
                getCommaSeparatedList(queryParams.getSeries()),
                getCommaSeparatedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    /**
     * Retrieves a list of {@link Event} for the specified comicId
     *
     * @param comicId   Unique identifier for the comic to retrieve events for
     * @param queryParams   Defines the query used to search for and return events
     *
     * @return  An observable of the event {@link RequestResponse}
     */
    public Observable<RequestResponse<Event>> getEventsForComicId(int comicId, @NonNull EventQueryParams queryParams) {
        return mEventService.getEventsForComicId(
                comicId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getCommaSeparatedList(queryParams.getCreators()),
                getCommaSeparatedList(queryParams.getCharacters()),
                getCommaSeparatedList(queryParams.getSeries()),
                getCommaSeparatedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    /**
     * Retrieves a list of {@link Event} for the specified creatorId
     *
     * @param creatorId   Unique identifier for the creator to retrieve events for
     * @param queryParams   Defines the query used to search for and return events
     * @param callback  Notifies caller when request is complete
     */
    public void getEventsForCreatorId(int creatorId, @NonNull EventQueryParams queryParams, Callback<RequestResponse<Event>> callback) {
        mEventService.getEventsForCreatorId(
                creatorId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getCommaSeparatedList(queryParams.getCharacters()),
                getCommaSeparatedList(queryParams.getSeries()),
                getCommaSeparatedList(queryParams.getComics()),
                getCommaSeparatedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    /**
     * Retrieves a list of {@link Event} for the specified creatorId
     *
     * @param creatorId   Unique identifier for the creator to retrieve events for
     * @param queryParams   Defines the query used to search for and return events
     *
     * @return  An observable of the event {@link RequestResponse}
     */
    public Observable<RequestResponse<Event>> getEventsForCreatorId(int creatorId, @NonNull EventQueryParams queryParams) {
        return mEventService.getEventsForCreatorId(
                creatorId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getCommaSeparatedList(queryParams.getCharacters()),
                getCommaSeparatedList(queryParams.getSeries()),
                getCommaSeparatedList(queryParams.getComics()),
                getCommaSeparatedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    /**
     * Retrieves a list of {@link Event} for the specified seriesId
     *
     * @param seriesId   Unique identifier for the series to retrieve events for
     * @param queryParams   Defines the query used to search for and return events
     * @param callback  Notifies caller when request is complete
     */
    public void getEventsForSeriesId(int seriesId, @NonNull EventQueryParams queryParams, Callback<RequestResponse<Event>> callback) {
        mEventService.getEventsForSeriesId(
                seriesId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getCommaSeparatedList(queryParams.getCreators()),
                getCommaSeparatedList(queryParams.getCharacters()),
                getCommaSeparatedList(queryParams.getComics()),
                getCommaSeparatedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    /**
     * Retrieves a list of {@link Event} for the specified seriesId
     *
     * @param seriesId   Unique identifier for the series to retrieve events for
     * @param queryParams   Defines the query used to search for and return events
     *
     * @return  An observable of the event {@link RequestResponse}
     */
    public Observable<RequestResponse<Event>> getEventsForSeriesId(int seriesId, @NonNull EventQueryParams queryParams) {
        return mEventService.getEventsForSeriesId(
                seriesId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getCommaSeparatedList(queryParams.getCreators()),
                getCommaSeparatedList(queryParams.getCharacters()),
                getCommaSeparatedList(queryParams.getComics()),
                getCommaSeparatedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    /**
     * Retrieves a list of {@link Event} for the specified storyId
     *
     * @param storyId   Unique identifier for the story to retrieve events for
     * @param queryParams   Defines the query used to search for and return events
     * @param callback  Notifies caller when request is complete
     */
    public void getEventsForStoryId(int storyId, @NonNull EventQueryParams queryParams, Callback<RequestResponse<Event>> callback) {
        mEventService.getEventsForStoryId(
                storyId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getCommaSeparatedList(queryParams.getCreators()),
                getCommaSeparatedList(queryParams.getCharacters()),
                getCommaSeparatedList(queryParams.getSeries()),
                getCommaSeparatedList(queryParams.getComics()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    /**
     * Retrieves a list of {@link Event} for the specified storyId
     *
     * @param storyId   Unique identifier for the story to retrieve events for
     * @param queryParams   Defines the query used to search for and return events
     *
     * @return  An observable of the event {@link RequestResponse}
     */
    public Observable<RequestResponse<Event>> getEventsForStoryId(int storyId, @NonNull EventQueryParams queryParams) {
        return mEventService.getEventsForStoryId(
                storyId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getCommaSeparatedList(queryParams.getCreators()),
                getCommaSeparatedList(queryParams.getCharacters()),
                getCommaSeparatedList(queryParams.getSeries()),
                getCommaSeparatedList(queryParams.getComics()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }
}
