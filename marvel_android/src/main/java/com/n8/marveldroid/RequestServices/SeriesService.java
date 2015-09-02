package com.n8.marveldroid.RequestServices;

import com.n8.marveldroid.ModelObjects.Series;
import com.n8.marveldroid.RequestResponse;

import java.util.Date;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

public interface SeriesService {

    // region Callbacks

    @GET("/v1/public/series/{seriesId}")
    void getSeriesForId(
        @Path("seriesId") int seriesId,
        @Query("ts") String timestamp,
        @Query("apikey") String apikey,
        @Query("hash") String hashSignature,
        Callback<RequestResponse<Series>> callback);

    @GET("/v1/public/series")
    void getSeries(
        @Query("ts") String timestamp,
        @Query("apikey") String apikey,
        @Query("hash") String hashSignature,
        @Query("title") String title,
        @Query("titleStartsWith") String titleStartsWith,
        @Query("startYear") Integer startYear,
        @Query("modifiedSince") Date modifiedSince,
        @Query("comics") String comics,
        @Query("stories") String stories,
        @Query("events") String events,
        @Query("creators") String creators,
        @Query("characters") String characters,
        @Query("seriesType") String seriesType,
        @Query("contains") String contains,
        @Query("orderBy") String orderBy,
        @Query("limit") int limit,
        @Query("offset") int offset,
        Callback<RequestResponse<Series>> callback);

    @GET("/v1/public/characters/{characterId}/series")
    void getSeriesForCharacterId(
        @Path("characterId") int characterId,
        @Query("ts") String timestamp,
        @Query("apikey") String apikey,
        @Query("hash") String hashSignature,
        @Query("title") String title,
        @Query("titleStartsWith") String titleStartsWith,
        @Query("startYear") Integer startYear,
        @Query("modifiedSince") Date modifiedSince,
        @Query("comics") String comics,
        @Query("stories") String stories,
        @Query("events") String events,
        @Query("creators") String creators,
        @Query("seriesType") String seriesType,
        @Query("contains") String contains,
        @Query("orderBy") String orderBy,
        @Query("limit") int limit,
        @Query("offset") int offset,
        Callback<RequestResponse<Series>> callback);

    @GET("/v1/public/creators/{creatorId}/series")
    void getSeriesForCreatorId(
        @Path("creatorId") int creatorId,
        @Query("ts") String timestamp,
        @Query("apikey") String apikey,
        @Query("hash") String hashSignature,
        @Query("title") String title,
        @Query("titleStartsWith") String titleStartsWith,
        @Query("startYear") Integer startYear,
        @Query("modifiedSince") Date modifiedSince,
        @Query("comics") String comics,
        @Query("stories") String stories,
        @Query("events") String events,
        @Query("characters") String characters,
        @Query("seriesType") String seriesType,
        @Query("contains") String contains,
        @Query("orderBy") String orderBy,
        @Query("limit") int limit,
        @Query("offset") int offset,
        Callback<RequestResponse<Series>> callback);

    @GET("/v1/public/events/{eventId}/series")
    void getSeriesForEventId(
        @Path("event") int eventId,
        @Query("ts") String timestamp,
        @Query("apikey") String apikey,
        @Query("hash") String hashSignature,
        @Query("title") String title,
        @Query("titleStartsWith") String titleStartsWith,
        @Query("startYear") Integer startYear,
        @Query("modifiedSince") Date modifiedSince,
        @Query("comics") String comics,
        @Query("stories") String stories,
        @Query("creators") String creators,
        @Query("characters") String characters,
        @Query("seriesType") String seriesType,
        @Query("contains") String contains,
        @Query("orderBy") String orderBy,
        @Query("limit") int limit,
        @Query("offset") int offset,
        Callback<RequestResponse<Series>> callback);

    @GET("/v1/public/stories/{storyId}/series")
    void getSeriesForStoryId(
        @Path("storyId") int storyId,
        @Query("ts") String timestamp,
        @Query("apikey") String apikey,
        @Query("hash") String hashSignature,
        @Query("title") String title,
        @Query("titleStartsWith") String titleStartsWith,
        @Query("startYear") Integer startYear,
        @Query("modifiedSince") Date modifiedSince,
        @Query("comics") String comics,
        @Query("events") String events,
        @Query("creators") String creators,
        @Query("characters") String characters,
        @Query("seriesType") String seriesType,
        @Query("contains") String contains,
        @Query("orderBy") String orderBy,
        @Query("limit") int limit,
        @Query("offset") int offset,
        Callback<RequestResponse<Series>> callback);

    // endregion Callbacks

    // region Observables

    @GET("/v1/public/series/{seriesId}")
    Observable<RequestResponse<Series>> getSeriesForId(
        @Path("seriesId") int seriesId,
        @Query("ts") String timestamp,
        @Query("apikey") String apikey,
        @Query("hash") String hashSignature);

    @GET("/v1/public/series")
    Observable<RequestResponse<Series>> getSeries(
        @Query("ts") String timestamp,
        @Query("apikey") String apikey,
        @Query("hash") String hashSignature,
        @Query("title") String title,
        @Query("titleStartsWith") String titleStartsWith,
        @Query("startYear") Integer startYear,
        @Query("modifiedSince") Date modifiedSince,
        @Query("comics") String comics,
        @Query("stories") String stories,
        @Query("events") String events,
        @Query("creators") String creators,
        @Query("characters") String characters,
        @Query("seriesType") String seriesType,
        @Query("contains") String contains,
        @Query("orderBy") String orderBy,
        @Query("limit") int limit,
        @Query("offset") int offset);

    @GET("/v1/public/characters/{characterId}/series")
    Observable<RequestResponse<Series>> getSeriesForCharacterId(
        @Path("characterId") int characterId,
        @Query("ts") String timestamp,
        @Query("apikey") String apikey,
        @Query("hash") String hashSignature,
        @Query("title") String title,
        @Query("titleStartsWith") String titleStartsWith,
        @Query("startYear") Integer startYear,
        @Query("modifiedSince") Date modifiedSince,
        @Query("comics") String comics,
        @Query("stories") String stories,
        @Query("events") String events,
        @Query("creators") String creators,
        @Query("seriesType") String seriesType,
        @Query("contains") String contains,
        @Query("orderBy") String orderBy,
        @Query("limit") int limit,
        @Query("offset") int offset);

    @GET("/v1/public/creators/{creatorId}/series")
    Observable<RequestResponse<Series>> getSeriesForCreatorId(
        @Path("creatorId") int creatorId,
        @Query("ts") String timestamp,
        @Query("apikey") String apikey,
        @Query("hash") String hashSignature,
        @Query("title") String title,
        @Query("titleStartsWith") String titleStartsWith,
        @Query("startYear") Integer startYear,
        @Query("modifiedSince") Date modifiedSince,
        @Query("comics") String comics,
        @Query("stories") String stories,
        @Query("events") String events,
        @Query("characters") String characters,
        @Query("seriesType") String seriesType,
        @Query("contains") String contains,
        @Query("orderBy") String orderBy,
        @Query("limit") int limit,
        @Query("offset") int offset);

    @GET("/v1/public/events/{eventId}/series")
    Observable<RequestResponse<Series>> getSeriesForEventId(
        @Path("event") int eventId,
        @Query("ts") String timestamp,
        @Query("apikey") String apikey,
        @Query("hash") String hashSignature,
        @Query("title") String title,
        @Query("titleStartsWith") String titleStartsWith,
        @Query("startYear") Integer startYear,
        @Query("modifiedSince") Date modifiedSince,
        @Query("comics") String comics,
        @Query("stories") String stories,
        @Query("creators") String creators,
        @Query("characters") String characters,
        @Query("seriesType") String seriesType,
        @Query("contains") String contains,
        @Query("orderBy") String orderBy,
        @Query("limit") int limit,
        @Query("offset") int offset);

    @GET("/v1/public/stories/{storyId}/series")
    Observable<RequestResponse<Series>> getSeriesForStoryId(
        @Path("storyId") int storyId,
        @Query("ts") String timestamp,
        @Query("apikey") String apikey,
        @Query("hash") String hashSignature,
        @Query("title") String title,
        @Query("titleStartsWith") String titleStartsWith,
        @Query("startYear") Integer startYear,
        @Query("modifiedSince") Date modifiedSince,
        @Query("comics") String comics,
        @Query("events") String events,
        @Query("creators") String creators,
        @Query("characters") String characters,
        @Query("seriesType") String seriesType,
        @Query("contains") String contains,
        @Query("orderBy") String orderBy,
        @Query("limit") int limit,
        @Query("offset") int offset);

    // endregion Observables
}
