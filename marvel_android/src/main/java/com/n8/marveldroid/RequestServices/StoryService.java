package com.n8.marveldroid.RequestServices;

import com.n8.marveldroid.ModelObjects.Story;
import com.n8.marveldroid.RequestResponse;

import java.util.Date;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

public interface StoryService {

    // region Callbacks

    @GET("/v1/public/stories/{storyId}")
    void getStoryForId(
        @Path("storyId") int storyId,
        @Query("ts") String timestamp,
        @Query("apikey") String apikey,
        @Query("hash") String hashSignature,
        Callback<RequestResponse<Story>> callback);

    @GET("/v1/public/stories")
    void getStories(
        @Query("ts") String timestamp,
        @Query("apikey") String apikey,
        @Query("hash") String hashSignature,
        @Query("modifiedSince") Date modifiedSince,
        @Query("comics") String comics,
        @Query("series") String series,
        @Query("events") String events,
        @Query("creators") String creators,
        @Query("characters") String characters,
        @Query("orderBy") String orderBy,
        @Query("limit") int limit,
        @Query("offset") int offset,
        Callback<RequestResponse<Story>> callback);

    @GET("/v1/public/characters/{characterId}/stories")
    void getStoriesForCharacterId(
        @Path("characterId") int characterId,
        @Query("ts") String timestamp,
        @Query("apikey") String apikey,
        @Query("hash") String hashSignature,
        @Query("modifiedSince") Date modifiedSince,
        @Query("comics") String comics,
        @Query("series") String series,
        @Query("events") String events,
        @Query("creators") String creators,
        @Query("orderBy") String orderBy,
        @Query("limit") int limit,
        @Query("offset") int offset,
        Callback<RequestResponse<Story>> callback);

    @GET("v1/public/comics/{comicId}/stories")
    void getStoriesForComicId(
        @Path("comicId") int comicId,
        @Query("ts") String timestamp,
        @Query("apikey") String apikey,
        @Query("hash") String hashSignature,
        @Query("modifiedSince") Date modifiedSince,
        @Query("series") String series,
        @Query("events") String events,
        @Query("creators") String creators,
        @Query("characters") String characters,
        @Query("orderBy") String orderBy,
        @Query("limit") int limit,
        @Query("offset") int offset,
        Callback<RequestResponse<Story>> callback);

    @GET("/v1/public/creators/{creatorId}/stories")
    void getStoriesForCreatorId(
        @Path("creatorId") int creatorId,
        @Query("ts") String timestamp,
        @Query("apikey") String apikey,
        @Query("hash") String hashSignature,
        @Query("modifiedSince") Date modifiedSince,
        @Query("comics") String comics,
        @Query("series") String series,
        @Query("events") String events,
        @Query("characters") String characters,
        @Query("orderBy") String orderBy,
        @Query("limit") int limit,
        @Query("offset") int offset,
        Callback<RequestResponse<Story>> callback);

    @GET("/v1/public/events/{eventId}/stories")
    void getStoriesForEventId(
        @Path("eventId") int eventId,
        @Query("ts") String timestamp,
        @Query("apikey") String apikey,
        @Query("hash") String hashSignature,
        @Query("modifiedSince") Date modifiedSince,
        @Query("comics") String comics,
        @Query("series") String series,
        @Query("creators") String creators,
        @Query("characters") String characters,
        @Query("orderBy") String orderBy,
        @Query("limit") int limit,
        @Query("offset") int offset,
        Callback<RequestResponse<Story>> callback);

    @GET("/v1/public/series/{seriesId}/stories")
    void getStoriesForSeriesId(
        @Path("seriesId") int seriesId,
        @Query("ts") String timestamp,
        @Query("apikey") String apikey,
        @Query("hash") String hashSignature,
        @Query("modifiedSince") Date modifiedSince,
        @Query("comics") String comics,
        @Query("events") String events,
        @Query("creators") String creators,
        @Query("characters") String characters,
        @Query("orderBy") String orderBy,
        @Query("limit") int limit,
        @Query("offset") int offset,
        Callback<RequestResponse<Story>> callback);

    // endregion Callbacks

    // region Observables

    @GET("/v1/public/stories/{storyId}")
    Observable<RequestResponse<Story>> getStoryForId(
            @Path("storyId") int storyId,
            @Query("ts") String timestamp,
            @Query("apikey") String apikey,
            @Query("hash") String hashSignature);

    @GET("/v1/public/stories")
    Observable<RequestResponse<Story>> getStories(
            @Query("ts") String timestamp,
            @Query("apikey") String apikey,
            @Query("hash") String hashSignature,
            @Query("modifiedSince") Date modifiedSince,
            @Query("comics") String comics,
            @Query("series") String series,
            @Query("events") String events,
            @Query("creators") String creators,
            @Query("characters") String characters,
            @Query("orderBy") String orderBy,
            @Query("limit") int limit,
            @Query("offset") int offset);

    @GET("/v1/public/characters/{characterId}/stories")
    Observable<RequestResponse<Story>> getStoriesForCharacterId(
            @Path("characterId") int characterId,
            @Query("ts") String timestamp,
            @Query("apikey") String apikey,
            @Query("hash") String hashSignature,
            @Query("modifiedSince") Date modifiedSince,
            @Query("comics") String comics,
            @Query("series") String series,
            @Query("events") String events,
            @Query("creators") String creators,
            @Query("orderBy") String orderBy,
            @Query("limit") int limit,
            @Query("offset") int offset);

    @GET("/v1/public/comics/{comicId}/stories")
    Observable<RequestResponse<Story>> getStoriesForComicId(
            @Path("comicId") int comicId,
            @Query("ts") String timestamp,
            @Query("apikey") String apikey,
            @Query("hash") String hashSignature,
            @Query("modifiedSince") Date modifiedSince,
            @Query("series") String series,
            @Query("events") String events,
            @Query("creators") String creators,
            @Query("characters") String characters,
            @Query("orderBy") String orderBy,
            @Query("limit") int limit,
            @Query("offset") int offset);

    @GET("v1/public/creators/{creatorId}/stories")
    Observable<RequestResponse<Story>> getStoriesForCreatorId(
            @Path("creatorId") int creatorId,
            @Query("ts") String timestamp,
            @Query("apikey") String apikey,
            @Query("hash") String hashSignature,
            @Query("modifiedSince") Date modifiedSince,
            @Query("comics") String comics,
            @Query("series") String series,
            @Query("events") String events,
            @Query("characters") String characters,
            @Query("orderBy") String orderBy,
            @Query("limit") int limit,
            @Query("offset") int offset);

    @GET("/v1/public/events/{eventId}/stories")
    Observable<RequestResponse<Story>> getStoriesForEventId(
            @Path("eventId") int eventId,
            @Query("ts") String timestamp,
            @Query("apikey") String apikey,
            @Query("hash") String hashSignature,
            @Query("modifiedSince") Date modifiedSince,
            @Query("comics") String comics,
            @Query("series") String series,
            @Query("creators") String creators,
            @Query("characters") String characters,
            @Query("orderBy") String orderBy,
            @Query("limit") int limit,
            @Query("offset") int offset);

    @GET("/v1/public/series/{seriesId}/stories")
    Observable<RequestResponse<Story>> getStoriesForSeriesId(
            @Path("seriesId") int seriesId,
            @Query("ts") String timestamp,
            @Query("apikey") String apikey,
            @Query("hash") String hashSignature,
            @Query("modifiedSince") Date modifiedSince,
            @Query("comics") String comics,
            @Query("events") String events,
            @Query("creators") String creators,
            @Query("characters") String characters,
            @Query("orderBy") String orderBy,
            @Query("limit") int limit,
            @Query("offset") int offset);

    // endregion Observables

}
