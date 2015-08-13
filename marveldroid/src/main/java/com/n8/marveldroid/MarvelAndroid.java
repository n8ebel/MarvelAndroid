package com.n8.marveldroid;

import android.content.Context;
import android.util.Log;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.n8.marveldroid.EntityModelObjects.Character;
import com.n8.marveldroid.RequestServices.CharacterQueryParams;
import com.n8.marveldroid.RequestServices.CharacterService;
import com.n8.marveldroid.RequestServices.ServiceResponse;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;

public class MarvelAndroid {

    public static final String PORT = "80";
    public static final String API_DOMAIN = "http://gateway.marvel.com";
    public static final String API_URL = API_DOMAIN + ":" + PORT;

    private static final String TAG = MarvelAndroid.class.getSimpleName();

    private CharacterService characters;

    private static MarvelAndroid sInstance;

    private static String sPrivateKey;

    private static String sPublicKey;

    private static Context sContext;

    private static long sCacheSize;

    private RestAdapter mRestAdapter;

    public static MarvelAndroid getInstance() {
        return sInstance;
    }

    public static void initialize(String privateKey, String publicKey, Context applicationContext, long cacheSize){
        sPrivateKey = privateKey;
        sPublicKey = publicKey;
        sContext = applicationContext;
        sCacheSize = cacheSize;

        sInstance = new MarvelAndroid();
    }

    private MarvelAndroid(){

        // Initialize RequestSignature so it can be used to generate the request signatures.
        RequestSignature.initialize(sPrivateKey, sPublicKey);

        OkHttpClient okHttpClient = new OkHttpClient();
        Cache cache = null;

        try {
            cache = new Cache(sContext.getCacheDir(), sCacheSize);
        } catch (IOException e) {
            Log.d(TAG, "Failed to create cache: " + e.getLocalizedMessage());
        }

        okHttpClient.setCache(cache);

        Gson gson = new GsonBuilder().create();

        mRestAdapter = new RestAdapter.Builder()
                .setClient(new OkClient(okHttpClient))
                .setConverter(new GsonConverter(gson))
                .setEndpoint(API_URL)
                .build();

        characters = mRestAdapter.create(CharacterService.class);
    }

    public RestAdapter getRestAdapter(){
        return mRestAdapter;
    }

    public void listCharacters(CharacterQueryParams queryParams, final ResponseCallback<Character> callback) {
        characters.listCharacters(queryParams.getLimit()
                , queryParams.getOffset()
                , String.valueOf(queryParams.getTimestamp())
                , queryParams.getApiKey()
                , queryParams.getHashSignature()
                , queryParams.getName()
                , queryParams.getNameStartsWith()
                , queryParams.getModifiedSince()
                , parameterizeList(queryParams.getStories())
                , parameterizeList(queryParams.getSeries())
                , parameterizeList(queryParams.getEvents())
                , queryParams.getOrderBy().getValue()
                , new Callback<ServiceResponse<Character>>() {
                    @Override
                    public void success(
                        ServiceResponse<Character> characterServiceResponse, Response response) {
                        callback.onRequestComplete(characterServiceResponse.data.results, null);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        callback.onRequestComplete(null, new Throwable(error.getLocalizedMessage()));
                    }
                });
    }

    private String parameterizeList(List<?> list) {
        if (list == null) {
            return null;
        }

        Joiner joiner = Joiner.on(',');
        return joiner.join(list);
    }
}
