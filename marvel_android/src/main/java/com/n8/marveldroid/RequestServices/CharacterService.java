package com.n8.marveldroid.RequestServices;

import com.n8.marveldroid.ModelObjects.Character;
import com.n8.marveldroid.RequestResponse;

import java.util.Date;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CharacterService {

    @GET("/v1/public/characters")
    Call<RequestResponse<Character>> getCharacters(
            @Query("ts") String timestamp,
            @Query("apikey") String apikey,
            @Query("hash") String hashSignature,
            @Query("name") String name,
            @Query("nameStartsWith") String nameStartsWith,
            @Query("modifiedSince") Date modifiedSince,
            @Query("comics") String comics,
            @Query("series") String series,
            @Query("events") String events,
            @Query("stories") String stories,
            @Query("orderBy") String orderBy,
            @Query("limit") int limit,
            @Query("offset") int offset);

    @GET("/v1/public/characters/{characterid}")
    Call<RequestResponse<Character>> getCharacterForId(
            @Path("characterid") int characterId,
            @Query("ts") String timestamp,
            @Query("apikey") String apikey,
            @Query("hash") String hashSignature);

    @GET("/v1/public/comics/{comicId}/characters")
    Call<RequestResponse<Character>> getCharactersForComicId(
            @Path("comicId") int comicId,
            @Query("ts") String timestamp,
            @Query("apikey") String apikey,
            @Query("hash") String hashSignature,
            @Query("name") String name,
            @Query("nameStartsWith") String nameStartsWith,
            @Query("modifiedSince") Date modifiedSince,
            @Query("series") String series,
            @Query("events") String events,
            @Query("stories") String stories,
            @Query("orderBy") String orderBy,
            @Query("limit") int limit,
            @Query("offset") int offset);

    @GET("/v1/public/events/{eventId}/characters")
    Call<RequestResponse<Character>> getCharactersForEventId(
            @Path("eventId") int eventId,
            @Query("ts") String timestamp,
            @Query("apikey") String apikey,
            @Query("hash") String hashSignature,
            @Query("name") String name,
            @Query("nameStartsWith") String nameStartsWith,
            @Query("modifiedSince") Date modifiedSince,
            @Query("comics") String comics,
            @Query("series") String series,
            @Query("stories") String stories,
            @Query("orderBy") String orderBy,
            @Query("limit") int limit,
            @Query("offset") int offset);

    @GET("/v1/public/series/{seriesId}/characters")
    Call<RequestResponse<Character>> getCharactersForSeriesId(
            @Path("seriesId") int seriesId,
            @Query("ts") String timestamp,
            @Query("apikey") String apikey,
            @Query("hash") String hashSignature,
            @Query("name") String name,
            @Query("nameStartsWith") String nameStartsWith,
            @Query("modifiedSince") Date modifiedSince,
            @Query("comics") String comics,
            @Query("events") String events,
            @Query("stories") String stories,
            @Query("orderBy") String orderBy,
            @Query("limit") int limit,
            @Query("offset") int offset);

    @GET("/v1/public/stories/{storyId}/characters")
    Call<RequestResponse<Character>> getCharactersForStoryId(
            @Path("storyId") int storyId,
            @Query("ts") String timestamp,
            @Query("apikey") String apikey,
            @Query("hash") String hashSignature,
            @Query("name") String name,
            @Query("nameStartsWith") String nameStartsWith,
            @Query("modifiedSince") Date modifiedSince,
            @Query("comics") String comics,
            @Query("series") String series,
            @Query("events") String events,
            @Query("orderBy") String orderBy,
            @Query("limit") int limit,
            @Query("offset") int offset);

}