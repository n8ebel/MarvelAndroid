package com.n8.marveldroid.RequestServices;

import com.n8.marveldroid.EntityModelObjects.Comic;
import com.n8.marveldroid.ServiceResponse;

import java.util.Date;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by n8 on 8/15/15.
 */
public interface ComicService {

    @GET("/v1/public/characters/{characterid}/comics")
    void getComicsForCharacterId(
            @Path("characterid") int characterId
            , @Query("limit") int limit
            , @Query("offset") int offset
            , @Query("ts") String timestamp
            , @Query("apikey") String apikey
            , @Query("hash") String hashSignature
            , @Query("format") String format
            , @Query("formatType") String formatType
            , @Query("noVariants") boolean noVariants
            , @Query("dateDescriptor") String dateDescriptor
            , @Query("dateRange") String dateRange
            , @Query("hasDigitalIssue") Boolean hasDigitalIssue
            , @Query("modifiedSince") Date modifiedSince
            , @Query("creators") String creators
            , @Query("series") String series
            , @Query("events") String events
            , @Query("stories") String stories
            , @Query("sharedAppearances") String sharedAppearances
            , @Query("collaborators") String collaborators
            , @Query("orderBy") String orderBy
            , Callback<ServiceResponse<Comic>> callback);

        @GET("/v1/public/characters/{characterid}/comics")
        Observable<ServiceResponse<Comic>> getObservableComicsForCharacterId(
                @Path("characterid") int characterId
                , @Query("limit") int limit
                , @Query("offset") int offset
                , @Query("ts") String timestamp
                , @Query("apikey") String apikey
                , @Query("hash") String hashSignature
                , @Query("format") String format
                , @Query("formatType") String formatType
                , @Query("noVariants") boolean noVariants
                , @Query("dateDescriptor") String dateDescriptor
                , @Query("dateRange") String dateRange
                , @Query("hasDigitalIssue") Boolean hasDigitalIssue
                , @Query("modifiedSince") Date modifiedSince
                , @Query("creators") String creators
                , @Query("series") String series
                , @Query("events") String events
                , @Query("stories") String stories
                , @Query("sharedAppearances") String sharedAppearances
                , @Query("collaborators") String collaborators
                , @Query("orderBy") String orderBy);
}
