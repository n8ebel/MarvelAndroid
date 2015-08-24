package com.n8.marveldroid.Endpoints;

import android.support.annotation.NonNull;

import com.n8.marveldroid.EntityModelObjects.Event;
import com.n8.marveldroid.QueryParams.EventQueryParams;
import com.n8.marveldroid.RequestServices.EventService;
import com.n8.marveldroid.ServiceResponse;

import retrofit.Callback;
import rx.Observable;

public class EventEndpoint extends BaseEndpoint {
    private EventService eventService;

    public EventEndpoint(@NonNull EventService eventService) {
        this.eventService = eventService;
    }

    public void getEvents(@NonNull EventQueryParams queryParams, Callback<ServiceResponse<Event>> callback) {

    }

    public Observable<ServiceResponse<Event>> getEvents(@NonNull EventQueryParams queryParams) {
        return null;
    }

    public void getEvent(int eventId, Callback<ServiceResponse<Event>> callback) {

    }

    public Observable<ServiceResponse<Event>> getEvent(int eventId) {
        return null;
    }

    public void getEventsForCharacterId(int characterId, @NonNull EventQueryParams queryParams, Callback<ServiceResponse<Event>> callback) {

    }

    public Observable<ServiceResponse<Event>> getEventsForCharacterId(int characterId, @NonNull EventQueryParams queryParams) {
        return null;
    }

    public void getEventsForComicId(int comic, @NonNull EventQueryParams queryParams, Callback<ServiceResponse<Event>> callback) {

    }

    public Observable<ServiceResponse<Event>> getEventsForComicId(int comicId, @NonNull EventQueryParams queryParams) {
        return null;
    }

    public void getEventsForCreatorId(int creatorId, @NonNull EventQueryParams queryParams, Callback<ServiceResponse<Event>> callback) {

    }

    public Observable<ServiceResponse<Event>> getEventsForCreatorId(int creatorId, @NonNull EventQueryParams queryParams) {
        return null;
    }

    public void getEventsForSeriesId(int seriesId, @NonNull EventQueryParams queryParams, Callback<ServiceResponse<Event>> callback) {

    }

    public Observable<ServiceResponse<Event>> getEventsForSeriesId(int seriesId, @NonNull EventQueryParams queryParams) {
        return null;
    }

    public void getEventsForStoryId(int storyId, @NonNull EventQueryParams queryParams, Callback<ServiceResponse<Event>> callback) {

    }

    public Observable<ServiceResponse<Event>> getEventsForStoryId(int storyId, @NonNull EventQueryParams queryParams) {
        return null;
    }
}
