package com.n8.marveldroid.Endpoints;

import android.support.annotation.NonNull;

import com.n8.marveldroid.EntityModelObjects.*;
import com.n8.marveldroid.EntityModelObjects.Character;
import com.n8.marveldroid.QueryParams.CharacterQueryParams;
import com.n8.marveldroid.RequestServices.CharacterService;
import com.n8.marveldroid.ResponseCallback;
import com.n8.marveldroid.ServiceResponse;

import java.util.Date;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public class CharacterEndpoint extends BaseEndpoint{

    private CharacterService mCharacterService;

    public CharacterEndpoint(@NonNull CharacterService characterService) {
        mCharacterService = characterService;
    }

    public void getCharacters(CharacterQueryParams queryParams, Callback<ServiceResponse<Character>> callback) {
        mCharacterService.getCharacters(
                String.valueOf(queryParams.getTimestamp()),
                queryParams.getApiKey(),
                queryParams.getHashSignature(),
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                parameterizeList(queryParams.getComics()),
                parameterizeList(queryParams.getStories()),
                parameterizeList(queryParams.getSeries()),
                parameterizeList(queryParams.getEvents()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    public void getCharacterForId(int characterId, CharacterQueryParams queryParams, Callback<ServiceResponse<Character>> callback) {
        mCharacterService.getCharacterForId(
                characterId,
                String.valueOf(queryParams.getTimestamp()),
                queryParams.getApiKey(),
                queryParams.getHashSignature(),
                callback);
    }

    public void getCharactersForComicId(int comicId, CharacterQueryParams queryParams, Callback<ServiceResponse<Character>> callback) {
        mCharacterService.getCharactersForComicId(
                comicId,
                String.valueOf(queryParams.getTimestamp()),
                queryParams.getApiKey(),
                queryParams.getHashSignature(),
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                parameterizeList(queryParams.getSeries()),
                parameterizeList(queryParams.getEvents()),
                parameterizeList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }
}
