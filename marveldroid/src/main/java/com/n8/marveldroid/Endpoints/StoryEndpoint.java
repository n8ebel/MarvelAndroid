package com.n8.marveldroid.Endpoints;

import android.support.annotation.NonNull;

import com.n8.marveldroid.EntityModelObjects.Story;
import com.n8.marveldroid.QueryParams.StoryQueryParams;
import com.n8.marveldroid.RequestServices.StoryService;
import com.n8.marveldroid.ServiceResponse;

import retrofit.Callback;
import rx.Observable;

/**
 * Provides methods for retrieving {@link com.n8.marveldroid.EntityModelObjects.Story}s from the various rest endpoints
 * {Events, Creators, etc}
 */
public class StoryEndpoint extends BaseEndpoint {
    private StoryService storyService;

    public StoryEndpoint(@NonNull StoryService storyService) {
        this.storyService = storyService;
    }

    public void getStoryForId(int storyId, Callback<ServiceResponse<Story>> callback) {

    }

    public Observable<ServiceResponse<Story>> getStoryForId(int storyId) {
        return null;
    }

    public void getStories(@NonNull StoryQueryParams queryParams, Callback<ServiceResponse<Story>> callback) {

    }

    public Observable<ServiceResponse<Story>> getStories(@NonNull StoryQueryParams queryParams) {
        return null;
    }

    public void getStoriesForCharacterId(int characterId, @NonNull StoryQueryParams queryParams, Callback<ServiceResponse<Story>> callback) {

    }

    public Observable<ServiceResponse<Story>> getStoriesForCharacterId(int storyId, @NonNull StoryQueryParams queryParams) {
        return null;
    }

    public void getStoriesForCreatorId(int creatorId, @NonNull StoryQueryParams queryParams, Callback<ServiceResponse<Story>> callback) {

    }

    public Observable<ServiceResponse<Story>> getStoriesForCreatorId(int creatorId, @NonNull StoryQueryParams queryParams) {
        return null;
    }

    public void getStoriesForEventId(int eventId, @NonNull StoryQueryParams queryParams, Callback<ServiceResponse<Story>> callback) {

    }

    public Observable<ServiceResponse<Story>> getStoriesForEventId(int eventId, @NonNull StoryQueryParams queryParams) {
        return null;
    }

    public void getStoriesForSeriesId(int seriesId, @NonNull StoryQueryParams queryParams, Callback<ServiceResponse<Story>> callback) {

    }

    public Observable<ServiceResponse<Story>> getStoriesForSeriesId(int seriesId, @NonNull StoryQueryParams queryParams) {
        return null;
    }

    public void getStoriesForComicId(int comicId, @NonNull StoryQueryParams queryParams, Callback<ServiceResponse<Story>> callback) {

    }

    public Observable<ServiceResponse<Story>> getStoriesForComicId(int comicId, @NonNull StoryQueryParams queryParams) {
        return null;
    }
}
