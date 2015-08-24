package com.n8.marveldroid.RequestServices;

import com.n8.marveldroid.EntityModelObjects.Event;
import com.n8.marveldroid.ServiceResponse;

import java.util.Date;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

public interface EventService {

    // region Callbacks

    @GET("/v1/public/events")
    void getEvents(
        @Query("ts") String timestamp,
        @Query("apikey") String apikey,
        @Query("hash") String hashSignature,
        @Query("name") String name,
        @Query("nameStartsWith") String nameStartsWith,
        @Query("modifiedSince") Date modifiedSince,
        @Query("creators") String creators,
        @Query("characters") String characters,
        @Query("series") String series,
        @Query("comics") String comics,
        @Query("stories") String stories,
        @Query("orderBy") String orderBy,
        @Query("limit") int limit,
        @Query("offset") int offset,
        Callback<ServiceResponse<Event>> callback);

    @GET("/v1/public/events/{eventId}")
    void getEventForId(
        @Path("eventId") int eventId,
        @Query("ts") String timestamp,
        @Query("apikey") String apikey,
        @Query("hash") String hashSignature,
        Callback<ServiceResponse<Event>> callback);

    @GET("/v1/public/characters/{characterId}/events")
    void getEventsForCharacterId(
            @Path("characterId") int characterId,
            @Query("ts") String timestamp,
            @Query("apikey") String apikey,
            @Query("hash") String hashSignature,
            @Query("name") String name,
            @Query("nameStartsWith") String nameStartsWith,
            @Query("modifiedSince") Date modifiedSince,
            @Query("creators") String creators,
            @Query("series") String series,
            @Query("comics") String comics,
            @Query("stories") String stories,
            @Query("orderBy") String orderBy,
            @Query("limit") int limit,
            @Query("offset") int offset,
            Callback<ServiceResponse<Event>> callback);

    @GET("/v1/public/comics/{comicId}/events")
    void getEventsForComicId(
            @Path("comicId") int comicId,
            @Query("ts") String timestamp,
            @Query("apikey") String apikey,
            @Query("hash") String hashSignature,
            @Query("name") String name,
            @Query("nameStartsWith") String nameStartsWith,
            @Query("modifiedSince") Date modifiedSince,
            @Query("creators") String creators,
            @Query("characters") String characters,
            @Query("series") String series,
            @Query("stories") String stories,
            @Query("orderBy") String orderBy,
            @Query("limit") int limit,
            @Query("offset") int offset,
            Callback<ServiceResponse<Event>> callback);

    @GET("/v1/public/creators/{creatorId}/events")
    void getEventsForCreatorId(
            @Path("creatorId") int creatorId,
            @Query("ts") String timestamp,
            @Query("apikey") String apikey,
            @Query("hash") String hashSignature,
            @Query("name") String name,
            @Query("nameStartsWith") String nameStartsWith,
            @Query("modifiedSince") Date modifiedSince,
            @Query("characters") String characters,
            @Query("series") String series,
            @Query("comics") String comics,
            @Query("stories") String stories,
            @Query("orderBy") String orderBy,
            @Query("limit") int limit,
            @Query("offset") int offset,
            Callback<ServiceResponse<Event>> callback);

    @GET("/v1/public/series/{seriesId}/events")
    void getEventsForSeriesId(
            @Path("seriesId") int seriesId,
            @Query("ts") String timestamp,
            @Query("apikey") String apikey,
            @Query("hash") String hashSignature,
            @Query("name") String name,
            @Query("nameStartsWith") String nameStartsWith,
            @Query("modifiedSince") Date modifiedSince,
            @Query("creators") String creators,
            @Query("characters") String characters,
            @Query("comics") String comics,
            @Query("stories") String stories,
            @Query("orderBy") String orderBy,
            @Query("limit") int limit,
            @Query("offset") int offset,
            Callback<ServiceResponse<Event>> callback);

    @GET("/v1/public/stories/{storyId}/events")
    void getEventsForStoryId(
            @Path("storyId") int storyId,
            @Query("ts") String timestamp,
            @Query("apikey") String apikey,
            @Query("hash") String hashSignature,
            @Query("name") String name,
            @Query("nameStartsWith") String nameStartsWith,
            @Query("modifiedSince") Date modifiedSince,
            @Query("creators") String creators,
            @Query("characters") String characters,
            @Query("series") String series,
            @Query("comics") String comics,
            @Query("orderBy") String orderBy,
            @Query("limit") int limit,
            @Query("offset") int offset,
            Callback<ServiceResponse<Event>> callback);

    // endregion Callbacks

    // region Observables

    @GET("/v1/public/events")
    Observable<ServiceResponse<Event>> getEvents(
            @Query("ts") String timestamp,
            @Query("apikey") String apikey,
            @Query("hash") String hashSignature,
            @Query("name") String name,
            @Query("nameStartsWith") String nameStartsWith,
            @Query("modifiedSince") Date modifiedSince,
            @Query("creators") String creators,
            @Query("characters") String characters,
            @Query("series") String series,
            @Query("comics") String comics,
            @Query("stories") String stories,
            @Query("orderBy") String orderBy,
            @Query("limit") int limit,
            @Query("offset") int offset);

    @GET("/v1/public/events/{eventId}")
    Observable<ServiceResponse<Event>> getEventForId(
            @Path("eventId") int eventId,
            @Query("ts") String timestamp,
            @Query("apikey") String apikey,
            @Query("hash") String hashSignature);

    @GET("/v1/public/characters/{characterId}/events")
    Observable<ServiceResponse<Event>> getEventsForCharacterId(
            @Path("characterId") int characterId,
            @Query("ts") String timestamp,
            @Query("apikey") String apikey,
            @Query("hash") String hashSignature,
            @Query("name") String name,
            @Query("nameStartsWith") String nameStartsWith,
            @Query("modifiedSince") Date modifiedSince,
            @Query("creators") String creators,
            @Query("series") String series,
            @Query("comics") String comics,
            @Query("stories") String stories,
            @Query("orderBy") String orderBy,
            @Query("limit") int limit,
            @Query("offset") int offset);

    @GET("/v1/public/comics/{comicId}/events")
    Observable<ServiceResponse<Event>> getEventsForComicId(
            @Path("comicId") int comicId,
            @Query("ts") String timestamp,
            @Query("apikey") String apikey,
            @Query("hash") String hashSignature,
            @Query("name") String name,
            @Query("nameStartsWith") String nameStartsWith,
            @Query("modifiedSince") Date modifiedSince,
            @Query("creators") String creators,
            @Query("characters") String characters,
            @Query("series") String series,
            @Query("stories") String stories,
            @Query("orderBy") String orderBy,
            @Query("limit") int limit,
            @Query("offset") int offset);

    @GET("/v1/public/creators/{creatorId}/events")
    Observable<ServiceResponse<Event>> getEventsForCreatorId(
            @Path("creatorId") int creatorId,
            @Query("ts") String timestamp,
            @Query("apikey") String apikey,
            @Query("hash") String hashSignature,
            @Query("name") String name,
            @Query("nameStartsWith") String nameStartsWith,
            @Query("modifiedSince") Date modifiedSince,
            @Query("characters") String characters,
            @Query("series") String series,
            @Query("comics") String comics,
            @Query("stories") String stories,
            @Query("orderBy") String orderBy,
            @Query("limit") int limit,
            @Query("offset") int offset);

    @GET("/v1/public/series/{seriesId}/events")
    Observable<ServiceResponse<Event>> getEventsForSeriesId(
            @Path("seriesId") int seriesId,
            @Query("ts") String timestamp,
            @Query("apikey") String apikey,
            @Query("hash") String hashSignature,
            @Query("name") String name,
            @Query("nameStartsWith") String nameStartsWith,
            @Query("modifiedSince") Date modifiedSince,
            @Query("creators") String creators,
            @Query("characters") String characters,
            @Query("comics") String comics,
            @Query("stories") String stories,
            @Query("orderBy") String orderBy,
            @Query("limit") int limit,
            @Query("offset") int offset);

    @GET("/v1/public/stories/{storyId}/events")
    Observable<ServiceResponse<Event>> getEventsForStoryId(
            @Path("storyId") int storyId,
            @Query("ts") String timestamp,
            @Query("apikey") String apikey,
            @Query("hash") String hashSignature,
            @Query("name") String name,
            @Query("nameStartsWith") String nameStartsWith,
            @Query("modifiedSince") Date modifiedSince,
            @Query("creators") String creators,
            @Query("characters") String characters,
            @Query("series") String series,
            @Query("comics") String comics,
            @Query("orderBy") String orderBy,
            @Query("limit") int limit,
            @Query("offset") int offset);

    // endregion Observables
}
