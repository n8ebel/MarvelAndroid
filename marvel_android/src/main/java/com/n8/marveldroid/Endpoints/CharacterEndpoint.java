package com.n8.marveldroid.Endpoints;

import android.support.annotation.NonNull;

import com.n8.marveldroid.ModelObjects.Character;
import com.n8.marveldroid.QueryParams.CharacterQueryParams;
import com.n8.marveldroid.RequestServices.RxCharacterService;
import com.n8.marveldroid.RequestResponse;

import retrofit.Callback;
import rx.Observable;

/**
 * Provides methods to retrieve {@link Character}s from the various rest endpoints
 * (Comic, Story, etc..).
 */
public class CharacterEndpoint extends BaseEndpoint {

    private RxCharacterService mCharacterService;

    public CharacterEndpoint(@NonNull RxCharacterService characterService, @NonNull String publicKey, @NonNull String privateKey) {
        super(publicKey, privateKey);
        mCharacterService = characterService;
    }

    /**
     * Retrieves a {@link Character} for the specified character id.
     *
     * @param characterId Unique identifier of the character to retrieve.
     * @param callback    Notifies caller when request is complete
     */
    public void getCharacter(int characterId, Callback<RequestResponse<Character>> callback) {
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
    public Observable<RequestResponse<Character>> getCharacter(int characterId) {
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
    public void getCharacters(CharacterQueryParams queryParams, Callback<RequestResponse<Character>> callback) {
        mCharacterService.getCharacters(
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getCommaSeparatedList(queryParams.getComics()),
                getCommaSeparatedList(queryParams.getStories()),
                getCommaSeparatedList(queryParams.getSeries()),
                getCommaSeparatedList(queryParams.getEvents()),
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
    public Observable<RequestResponse<Character>> getCharacters(CharacterQueryParams queryParams) {
        return mCharacterService.getCharacters(
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getCommaSeparatedList(queryParams.getComics()),
                getCommaSeparatedList(queryParams.getStories()),
                getCommaSeparatedList(queryParams.getSeries()),
                getCommaSeparatedList(queryParams.getEvents()),
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
    public void getCharactersForComicId(int comicId, CharacterQueryParams queryParams, Callback<RequestResponse<Character>> callback) {
        mCharacterService.getCharactersForComicId(
                comicId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getCommaSeparatedList(queryParams.getSeries()),
                getCommaSeparatedList(queryParams.getEvents()),
                getCommaSeparatedList(queryParams.getStories()),
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
    public Observable<RequestResponse<Character>> getCharactersForComicId(int comicId, CharacterQueryParams queryParams) {
        return mCharacterService.getCharactersForComicId(
                comicId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getCommaSeparatedList(queryParams.getSeries()),
                getCommaSeparatedList(queryParams.getEvents()),
                getCommaSeparatedList(queryParams.getStories()),
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
    public void getCharactersForEventId(int eventId, CharacterQueryParams queryParams, Callback<RequestResponse<Character>> callback) {
        mCharacterService.getCharactersForEventId(
                eventId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getCommaSeparatedList(queryParams.getComics()),
                getCommaSeparatedList(queryParams.getSeries()),
                getCommaSeparatedList(queryParams.getStories()),
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
    public Observable<RequestResponse<Character>> getCharactersForEventId(int eventId, CharacterQueryParams queryParams) {
        return mCharacterService.getCharactersForEventId(
                eventId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getCommaSeparatedList(queryParams.getComics()),
                getCommaSeparatedList(queryParams.getSeries()),
                getCommaSeparatedList(queryParams.getStories()),
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
    public void getCharactersForSeriesId(int seriesId, CharacterQueryParams queryParams, Callback<RequestResponse<Character>> callback) {
        mCharacterService.getCharactersForSeriesId(
                seriesId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getCommaSeparatedList(queryParams.getComics()),
                getCommaSeparatedList(queryParams.getEvents()),
                getCommaSeparatedList(queryParams.getStories()),
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
    public Observable<RequestResponse<Character>> getCharactersForSeriesId(int seriesId, CharacterQueryParams queryParams) {
        return mCharacterService.getCharactersForSeriesId(
                seriesId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getCommaSeparatedList(queryParams.getComics()),
                getCommaSeparatedList(queryParams.getEvents()),
                getCommaSeparatedList(queryParams.getStories()),
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
    public void getCharactersForStoryId(int storyId, CharacterQueryParams queryParams, Callback<RequestResponse<Character>> callback) {
        mCharacterService.getCharactersForStoryId(
                storyId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getCommaSeparatedList(queryParams.getComics()),
                getCommaSeparatedList(queryParams.getSeries()),
                getCommaSeparatedList(queryParams.getEvents()),
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
    public Observable<RequestResponse<Character>> getCharactersForStoryId(int storyId, CharacterQueryParams queryParams) {
        return mCharacterService.getCharactersForStoryId(
                storyId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getCommaSeparatedList(queryParams.getComics()),
                getCommaSeparatedList(queryParams.getSeries()),
                getCommaSeparatedList(queryParams.getEvents()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }
}
