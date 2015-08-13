package com.n8.marveldroid.RequestServices;

import com.n8.marveldroid.EntityModelObjects.Character;

import java.util.Date;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface CharacterService {

    @GET("/v1/public/characters")
    public void listCharacters(@Query("limit") int limit
            , @Query("offset") int offset
            , @Query("ts") String timestamp
            , @Query("apikey") String apikey
            , @Query("hash") String hashSignature
            , @Query("name") String name
            , @Query("nameStartsWith") String nameStartsWith
            , @Query("modifiedSince") Date modifiedSince
            , @Query("comics") String comics
            , @Query("series") String series
            , @Query("events") String events
            , @Query("orderBy") String orderBy
            , Callback<ServiceResponse<Character>> callback);
}