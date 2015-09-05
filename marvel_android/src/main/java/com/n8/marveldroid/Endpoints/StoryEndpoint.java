package com.n8.marveldroid.Endpoints;

import android.support.annotation.NonNull;

import com.n8.marveldroid.ModelObjects.Story;
import com.n8.marveldroid.QueryParams.StoryQueryParams;
import com.n8.marveldroid.RequestServices.StoryService;
import com.n8.marveldroid.RequestResponse;

import retrofit.Callback;
import rx.Observable;

/**
 * Provides methods for retrieving {@link com.n8.marveldroid.ModelObjects.Story}s from the various rest endpoints
 * {Events, Creators, etc}
 */
public class StoryEndpoint extends BaseEndpoint {
    private StoryService mStoryService;

    public StoryEndpoint(@NonNull StoryService storyService, @NonNull String publicKey, @NonNull String privateKey) {
        super(publicKey, privateKey);
        mStoryService = storyService;
    }

    /**
     * Retrieves a {@link Story} for the specified storyId
     *
     * @param storyId   Unique identifier of the story to retrieve
     * @param callback  Notifies caller when request is complete
     */
    public void getStoryForId(int storyId, Callback<RequestResponse<Story>> callback) {
        mStoryService.getStoryForId(
            storyId,
            String.valueOf(getTimestamp()),
            getApiKey(),
            getHashSignature(),
            callback);
    }

    /**
     * Retrieves a {@link Story} for the specified storyId
     *
     * @param storyId Unique identifier of the story to retrieve
     *
     * @return  An observable of the story {@link RequestResponse}
     */
    public Observable<RequestResponse<Story>> getStoryForId(int storyId) {
        return mStoryService.getStoryForId(
            storyId,
            String.valueOf(getTimestamp()),
            getApiKey(),
            getHashSignature());
    }

    /**
     * Retrieves a list of {@link Story}
     *
     * @param queryParams   Defines the query used to search for and return stories
     * @param callback  Notifies caller when request is complete
     */
    public void getStories(@NonNull StoryQueryParams queryParams, Callback<RequestResponse<Story>> callback) {
        mStoryService.getStories(
            String.valueOf(getTimestamp()),
            getApiKey(),
            getHashSignature(),
            queryParams.getModifiedSince(),
            getJoinedList(queryParams.getComics()),
            getJoinedList(queryParams.getSeries()),
            getJoinedList(queryParams.getEvents()),
            getJoinedList(queryParams.getCreators()),
            getJoinedList(queryParams.getCharacters()),
            queryParams.getOrderBy().getValue(),
            queryParams.getLimit(),
            queryParams.getOffset(),
            callback);
    }

    /**
     * Retrieves a list of {@link Story}
     *
     * @param queryParams   Defines the query used to search for and return stories
     *
     * @return  An observable of story {@link RequestResponse}
     */
    public Observable<RequestResponse<Story>> getStories(@NonNull StoryQueryParams queryParams) {
        return mStoryService.getStories(
            String.valueOf(getTimestamp()),
            getApiKey(),
            getHashSignature(),
            queryParams.getModifiedSince(),
            getJoinedList(queryParams.getComics()),
            getJoinedList(queryParams.getSeries()),
            getJoinedList(queryParams.getEvents()),
            getJoinedList(queryParams.getCreators()),
            getJoinedList(queryParams.getCharacters()),
            queryParams.getOrderBy().getValue(),
            queryParams.getLimit(),
            queryParams.getOffset());
    }

    /**
     * Retrieves a list of {@link Story} for the specified characterId
     *
     * @param characterId   Unique identifier of the character to retrieve stories for
     * @param queryParams   Deinfes the query used to search for and return stories
     * @param callback  Notifies caller when request is complete.
     */
    public void getStoriesForCharacterId(int characterId, @NonNull StoryQueryParams queryParams, Callback<RequestResponse<Story>> callback) {
        mStoryService.getStoriesForCharacterId(
            characterId,
            String.valueOf(getTimestamp()),
            getApiKey(),
            getHashSignature(),
            queryParams.getModifiedSince(),
            getJoinedList(queryParams.getComics()),
            getJoinedList(queryParams.getSeries()),
            getJoinedList(queryParams.getEvents()),
            getJoinedList(queryParams.getCreators()),
            queryParams.getOrderBy().getValue(),
            queryParams.getLimit(),
            queryParams.getOffset(),
            callback);
    }

    /**
     * Retrieves a list of {@link Story} for the specified characterId
     *
     * @param characterId Unique identifier of the character to retrieve stories for
     * @param queryParams   Defines the query used to search for and return stories
     *
     * @return  An observable of the story {@link RequestResponse}
     */
    public Observable<RequestResponse<Story>> getStoriesForCharacterId(int characterId, @NonNull StoryQueryParams queryParams) {
        return mStoryService.getStoriesForCharacterId(
            characterId,
            String.valueOf(getTimestamp()),
            getApiKey(),
            getHashSignature(),
            queryParams.getModifiedSince(),
            getJoinedList(queryParams.getComics()),
            getJoinedList(queryParams.getSeries()),
            getJoinedList(queryParams.getEvents()),
            getJoinedList(queryParams.getCreators()),
            queryParams.getOrderBy().getValue(),
            queryParams.getLimit(),
            queryParams.getOffset());
    }

    /**
     * Retrieves a list of {@link Story} for the specified creatorId
     *
     * @param creatorId   Unique identifier of the creator to retrieve stories for
     * @param queryParams   Deinfes the query used to search for and return stories
     * @param callback  Notifies caller when request is complete.
     */
    public void getStoriesForCreatorId(int creatorId, @NonNull StoryQueryParams queryParams, Callback<RequestResponse<Story>> callback) {
        mStoryService.getStoriesForCreatorId(
            creatorId,
            String.valueOf(getTimestamp()),
            getApiKey(),
            getHashSignature(),
            queryParams.getModifiedSince(),
            getJoinedList(queryParams.getComics()),
            getJoinedList(queryParams.getSeries()),
            getJoinedList(queryParams.getEvents()),
            getJoinedList(queryParams.getCharacters()),
            queryParams.getOrderBy().getValue(),
            queryParams.getLimit(),
            queryParams.getOffset(),
            callback);
    }

    /**
     * Retrieves a list of {@link Story} for the specified creatorId
     *
     * @param creatorId Unique identifier of the creator to retrieve stories for
     * @param queryParams   Defines the query used to search for and return stories
     *
     * @return  An observable of the story {@link RequestResponse}
     */
    public Observable<RequestResponse<Story>> getStoriesForCreatorId(int creatorId, @NonNull StoryQueryParams queryParams) {
        return mStoryService.getStoriesForCreatorId(
            creatorId,
            String.valueOf(getTimestamp()),
            getApiKey(),
            getHashSignature(),
            queryParams.getModifiedSince(),
            getJoinedList(queryParams.getComics()),
            getJoinedList(queryParams.getSeries()),
            getJoinedList(queryParams.getEvents()),
            getJoinedList(queryParams.getCharacters()),
            queryParams.getOrderBy().getValue(),
            queryParams.getLimit(),
            queryParams.getOffset());
    }

    /**
     * Retrieves a list of {@link Story} for the specified eventId
     *
     * @param eventId   Unique identifier of the event to retrieve stories for
     * @param queryParams   Deinfes the query used to search for and return stories
     * @param callback  Notifies caller when request is complete.
     */
    public void getStoriesForEventId(int eventId, @NonNull StoryQueryParams queryParams, Callback<RequestResponse<Story>> callback) {
        mStoryService.getStoriesForEventId(
            eventId,
            String.valueOf(getTimestamp()),
            getApiKey(),
            getHashSignature(),
            queryParams.getModifiedSince(),
            getJoinedList(queryParams.getComics()),
            getJoinedList(queryParams.getSeries()),
            getJoinedList(queryParams.getCreators()),
            getJoinedList(queryParams.getCharacters()),
            queryParams.getOrderBy().getValue(),
            queryParams.getLimit(),
            queryParams.getOffset(),
            callback);
    }

    /**
     * Retrieves a list of {@link Story} for the specified eventId
     *
     * @param eventId Unique identifier of the event to retrieve stories for
     * @param queryParams   Defines the query used to search for and return stories
     *
     * @return  An observable of the story {@link RequestResponse}
     */
    public Observable<RequestResponse<Story>> getStoriesForEventId(int eventId, @NonNull StoryQueryParams queryParams) {
        return mStoryService.getStoriesForEventId(
            eventId,
            String.valueOf(getTimestamp()),
            getApiKey(),
            getHashSignature(),
            queryParams.getModifiedSince(),
            getJoinedList(queryParams.getComics()),
            getJoinedList(queryParams.getSeries()),
            getJoinedList(queryParams.getCreators()),
            getJoinedList(queryParams.getCharacters()),
            queryParams.getOrderBy().getValue(),
            queryParams.getLimit(),
            queryParams.getOffset());
    }

    /**
     * Retrieves a list of {@link Story} for the specified seriesId
     *
     * @param seriesId   Unique identifier of the series to retrieve stories for
     * @param queryParams   Deinfes the query used to search for and return stories
     * @param callback  Notifies caller when request is complete.
     */
    public void getStoriesForSeriesId(int seriesId, @NonNull StoryQueryParams queryParams, Callback<RequestResponse<Story>> callback) {
        mStoryService.getStoriesForSeriesId(
            seriesId,
            String.valueOf(getTimestamp()),
            getApiKey(),
            getHashSignature(),
            queryParams.getModifiedSince(),
            getJoinedList(queryParams.getComics()),
            getJoinedList(queryParams.getEvents()),
            getJoinedList(queryParams.getCreators()),
            getJoinedList(queryParams.getCharacters()),
            queryParams.getOrderBy().getValue(),
            queryParams.getLimit(),
            queryParams.getOffset(),
            callback);
    }

    /**
     * Retrieves a list of {@link Story} for the specified seriesId
     *
     * @param seriesId Unique identifier of the series to retrieve stories for
     * @param queryParams   Defines the query used to search for and return stories
     *
     * @return  An observable of the story {@link RequestResponse}
     */
    public Observable<RequestResponse<Story>> getStoriesForSeriesId(int seriesId, @NonNull StoryQueryParams queryParams) {
        return mStoryService.getStoriesForSeriesId(
            seriesId,
            String.valueOf(getTimestamp()),
            getApiKey(),
            getHashSignature(),
            queryParams.getModifiedSince(),
            getJoinedList(queryParams.getComics()),
            getJoinedList(queryParams.getEvents()),
            getJoinedList(queryParams.getCreators()),
            getJoinedList(queryParams.getCharacters()),
            queryParams.getOrderBy().getValue(),
            queryParams.getLimit(),
            queryParams.getOffset());
    }

    /**
     * Retrieves a list of {@link Story} for the specified comicId
     *
     * @param comicId   Unique identifier of the comic to retrieve stories for
     * @param queryParams   Deinfes the query used to search for and return stories
     * @param callback  Notifies caller when request is complete.
     */
    public void getStoriesForComicId(int comicId, @NonNull StoryQueryParams queryParams, Callback<RequestResponse<Story>> callback) {
        mStoryService.getStoriesForComicId(
            comicId,
            String.valueOf(getTimestamp()),
            getApiKey(),
            getHashSignature(),
            queryParams.getModifiedSince(),
            getJoinedList(queryParams.getSeries()),
            getJoinedList(queryParams.getEvents()),
            getJoinedList(queryParams.getCreators()),
            getJoinedList(queryParams.getCharacters()),
            queryParams.getOrderBy().getValue(),
            queryParams.getLimit(),
            queryParams.getOffset(),
            callback);
    }

    /**
     * Retrieves a list of {@link Story} for the specified comicId
     *
     * @param comicId Unique identifier of the comic to retrieve stories for
     * @param queryParams   Defines the query used to search for and return stories
     *
     * @return  An observable of the story {@link RequestResponse}
     */
    public Observable<RequestResponse<Story>> getStoriesForComicId(int comicId, @NonNull StoryQueryParams queryParams) {
        return mStoryService.getStoriesForComicId(
            comicId,
            String.valueOf(getTimestamp()),
            getApiKey(),
            getHashSignature(),
            queryParams.getModifiedSince(),
            getJoinedList(queryParams.getSeries()),
            getJoinedList(queryParams.getEvents()),
            getJoinedList(queryParams.getCreators()),
            getJoinedList(queryParams.getCharacters()),
            queryParams.getOrderBy().getValue(),
            queryParams.getLimit(),
            queryParams.getOffset());
    }
}
