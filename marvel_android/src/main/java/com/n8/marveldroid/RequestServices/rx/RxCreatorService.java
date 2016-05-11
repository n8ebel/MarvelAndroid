package com.n8.marveldroid.RequestServices.rx;

import com.n8.marveldroid.ModelObjects.Creator;
import com.n8.marveldroid.RequestResponse;

import java.util.Date;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface RxCreatorService {

    @GET("/v1/public/creators")
    Observable<RequestResponse<Creator>> getCreators(
            @Query("ts") String timestamp,
            @Query("apikey") String apikey,
            @Query("hash") String hashSignature,
            @Query("firstName") String firstName,
            @Query("middleName") String middleName,
            @Query("lastName") String lastName,
            @Query("suffix") String suffix,
            @Query("nameStartsWith") String nameStartsWith,
            @Query("firstNameStartsWith") String firstNameStartsWith,
            @Query("middleNameStartsWith") String middleNameStartsWith,
            @Query("lastNameStartsWith") String lastNameStartsWith,
            @Query("modifiedSince") Date modifiedSince,
            @Query("comics") String comics,
            @Query("series") String series,
            @Query("events") String events,
            @Query("stories") String stories,
            @Query("orderBy") String orderBy,
            @Query("limit") int limit,
            @Query("offset") int offset);

    @GET("/v1/public/creators/{creatorId}")
    Observable<RequestResponse<Creator>> getCreatorForId(
            @Path("creatorId") int creatorId,
            @Query("ts") String timestamp,
            @Query("apikey") String apikey,
            @Query("hash") String hashSignature);

    @GET("/v1/public/comics/{comicId}/creators")
    Observable<RequestResponse<Creator>> getCreatorsForComicId(
            @Path("comicId") int comicId,
            @Query("ts") String timestamp,
            @Query("apikey") String apikey,
            @Query("hash") String hashSignature,
            @Query("firstName") String firstName,
            @Query("middleName") String middleName,
            @Query("lastName") String lastName,
            @Query("suffix") String suffix,
            @Query("nameStartsWith") String nameStartsWith,
            @Query("firstNameStartsWith") String firstNameStartsWith,
            @Query("middleNameStartsWith") String middleNameStartsWith,
            @Query("lastNameStartsWith") String lastNameStartsWith,
            @Query("modifiedSince") Date modifiedSince,
            @Query("comics") String comics,
            @Query("series") String series,
            @Query("stories") String stories,
            @Query("orderBy") String orderBy,
            @Query("limit") int limit,
            @Query("offset") int offset);

    @GET("/v1/public/events/{eventId}/creators")
    Observable<RequestResponse<Creator>> getCreatorsForEventId(
            @Path("eventId") int eventId,
            @Query("ts") String timestamp,
            @Query("apikey") String apikey,
            @Query("hash") String hashSignature,
            @Query("firstName") String firstName,
            @Query("middleName") String middleName,
            @Query("lastName") String lastName,
            @Query("suffix") String suffix,
            @Query("nameStartsWith") String nameStartsWith,
            @Query("firstNameStartsWith") String firstNameStartsWith,
            @Query("middleNameStartsWith") String middleNameStartsWith,
            @Query("lastNameStartsWith") String lastNameStartsWith,
            @Query("modifiedSince") Date modifiedSince,
            @Query("comics") String comics,
            @Query("series") String series,
            @Query("stories") String stories,
            @Query("orderBy") String orderBy,
            @Query("limit") int limit,
            @Query("offset") int offset);

    @GET("/v1/public/series/{seriesId}/creators")
    Observable<RequestResponse<Creator>> getCreatorsForSeriesId(
            @Path("seriesId") int seriesId,
            @Query("ts") String timestamp,
            @Query("apikey") String apikey,
            @Query("hash") String hashSignature,
            @Query("firstName") String firstName,
            @Query("middleName") String middleName,
            @Query("lastName") String lastName,
            @Query("suffix") String suffix,
            @Query("nameStartsWith") String nameStartsWith,
            @Query("firstNameStartsWith") String firstNameStartsWith,
            @Query("middleNameStartsWith") String middleNameStartsWith,
            @Query("lastNameStartsWith") String lastNameStartsWith,
            @Query("modifiedSince") Date modifiedSince,
            @Query("comics") String comics,
            @Query("events") String events,
            @Query("stories") String stories,
            @Query("orderBy") String orderBy,
            @Query("limit") int limit,
            @Query("offset") int offset);

    @GET("/v1/public/stories/{storyId}/creators")
    Observable<RequestResponse<Creator>> getCreatorsForStoryId(
            @Path("storyId") int storyId,
            @Query("ts") String timestamp,
            @Query("apikey") String apikey,
            @Query("hash") String hashSignature,
            @Query("firstName") String firstName,
            @Query("middleName") String middleName,
            @Query("lastName") String lastName,
            @Query("suffix") String suffix,
            @Query("nameStartsWith") String nameStartsWith,
            @Query("firstNameStartsWith") String firstNameStartsWith,
            @Query("middleNameStartsWith") String middleNameStartsWith,
            @Query("lastNameStartsWith") String lastNameStartsWith,
            @Query("modifiedSince") Date modifiedSince,
            @Query("comics") String comics,
            @Query("series") String series,
            @Query("events") String events,
            @Query("orderBy") String orderBy,
            @Query("limit") int limit,
            @Query("offset") int offset);

    // endregion Observables
}
