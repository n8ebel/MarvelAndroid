package com.n8.marveldroid.Endpoints;

import android.support.annotation.NonNull;

import com.n8.marveldroid.EntityModelObjects.Character;
import com.n8.marveldroid.QueryParams.CharacterQueryParams;
import com.n8.marveldroid.RequestServices.CharacterService;
import com.n8.marveldroid.ServiceResponse;

import retrofit.Callback;
import rx.Observable;

public class CharacterEndpoint extends BaseEndpoint {

    private CharacterService mCharacterService;

    public CharacterEndpoint(@NonNull CharacterService characterService) {
        mCharacterService = characterService;
    }

    /**
     * Retrieves a {@link Character} for the specified character id.
     *
     * @param characterId Unique identifier of the character to retrieve.
     * @param callback    Notifies caller when request is complete
     */
    public void getCharacter(int characterId, Callback<ServiceResponse<Character>> callback) {
        mCharacterService.getCharacterForId(
                characterId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                callback);
    }

    /**
     * Retreives a {@link Character} for the specified character id.
     *
     * @param characterId Unique identifier of the character to retrieve.
     * @return An observable of the character service response.
     */
    public Observable<ServiceResponse<Character>> getCharacter(int characterId) {
        return mCharacterService.getCharacterForId(
                characterId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature());
    }

    /**
     * Retrieves a list of {@link Character}
     *
     * @param queryParams Defines the query used to search for and return characters.
     * @param callback    Notifies caller when request is complete
     */
    public void getCharacters(CharacterQueryParams queryParams, Callback<ServiceResponse<Character>> callback) {
        mCharacterService.getCharacters(
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    /**
     * Retrieves a list of {@link Character}
     *
     * @param queryParams Defines the query used to serach for and return characters
     * @return An observable of the character service response.
     */
    public Observable<ServiceResponse<Character>> getCharacters(CharacterQueryParams queryParams) {
        return mCharacterService.getCharacters(
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    /**
     * Retrieves a list of {@link Character} for the comic matching the specified id
     *
     * @param comicId     Unique comic identifier to retrieve characters from.
     * @param queryParams Defines the query used to search for and return characters
     * @param callback    Notifies caller when request is complete
     */
    public void getCharactersForComicId(int comicId, CharacterQueryParams queryParams, Callback<ServiceResponse<Character>> callback) {
        mCharacterService.getCharactersForComicId(
                comicId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    /**
     * Retrieves a list of {@link Character} for the comic matching the specified id
     *
     * @param comicId     Unique comic identifier to retrieve characters from.
     * @param queryParams Defines the query used to search for and return characters.
     * @return An observable of the character service response.
     */
    public Observable<ServiceResponse<Character>> getCharactersForComicId(int comicId, CharacterQueryParams queryParams) {
        return mCharacterService.getCharactersForComicId(
                comicId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    /**
     * Retrieves a list of {@link Character}
     *
     * @param eventId     Unique event identifier to retrieve characters from.
     * @param queryParams Defines the query used to search for and return characters.
     * @param callback    Notifies caller when request is complete
     */
    public void getCharactersForEventId(int eventId, CharacterQueryParams queryParams, Callback<ServiceResponse<Character>> callback) {
        mCharacterService.getCharactersForEventId(
                eventId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    /**
     * Retrieves a list of {@link Character}
     *
     * @param eventId     Unique event identifier to retrieve characters from.
     * @param queryParams Defines the query used to search for and return characters.
     * @return An observable of the character service response.
     */
    public Observable<ServiceResponse<Character>> getCharactersForEventId(int eventId, CharacterQueryParams queryParams) {
        return mCharacterService.getCharactersForEventId(
                eventId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    /**
     * Retrieves a list of {@link Character}
     *
     * @param seriesId    Unique series identifier to retrieve characters from.
     * @param queryParams Defines the query used to search for and return characters.
     * @param callback    Notifies caller when request is complete
     */
    public void getCharactersForSeriesId(int seriesId, CharacterQueryParams queryParams, Callback<ServiceResponse<Character>> callback) {
        mCharacterService.getCharactersForSeriesId(
                seriesId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    /**
     * Retrieves a list of {@link Character}
     *
     * @param seriesId    Unique series identifier to retrieve characters from.
     * @param queryParams Defines the query used to search for and return characters.
     * @return An observable of the character service response.
     */
    public Observable<ServiceResponse<Character>> getCharactersForSeriesId(int seriesId, CharacterQueryParams queryParams) {
        return mCharacterService.getCharactersForSeriesId(
                seriesId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    /**
     * Retrieves a list of {@link Character}
     *
     * @param storyId     Unique story identifier to retrieve characters from.
     * @param queryParams Defines the query used to search for and return characters.
     * @param callback    Notifies caller when request is complete
     */
    public void getCharactersForStoryId(int storyId, CharacterQueryParams queryParams, Callback<ServiceResponse<Character>> callback) {
        mCharacterService.getCharactersForStoryId(
                storyId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    /**
     * Retrieves a list of {@link Character}
     *
     * @param storyId     Unique story identifier to retrieve characters from.
     * @param queryParams Defines the query used to search for and return characters.
     * @return An observable of the character service response.
     */
    public Observable<ServiceResponse<Character>> getCharactersForStoryId(int storyId, CharacterQueryParams queryParams) {
        return mCharacterService.getCharactersForStoryId(
                storyId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }
}
