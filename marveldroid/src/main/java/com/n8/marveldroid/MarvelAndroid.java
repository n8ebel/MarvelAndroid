package com.n8.marveldroid;

import android.content.Context;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.n8.marveldroid.Endpoints.CharacterEndpoint;
import com.n8.marveldroid.RequestServices.CharacterService;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

public class MarvelAndroid {

    public static final String PORT = "80";
    public static final String API_DOMAIN = "http://gateway.marvel.com";
    public static final String API_URL = API_DOMAIN + ":" + PORT;

    private static final String TAG = MarvelAndroid.class.getSimpleName();

    private static MarvelAndroid sInstance;
    private static Context sContext;

    private static String sPrivateKey;
    private static String sPublicKey;

    private static long sCacheSize;

    private RestAdapter mRestAdapter;

    private CharacterEndpoint mCharacterEndpoint;

    public static MarvelAndroid getInstance() {
        return sInstance;
    }

    public static void initialize(@NonNull Context applicationContext,
                                  @NonNull String privateKey,
                                  @NonNull String publicKey,
                                  @IntRange(from = 0) long cacheSize) {

        if (applicationContext == null) {
            throw new IllegalArgumentException("Context cannot be null");
        }else if (privateKey == null || privateKey.equals("")) {
            throw new IllegalArgumentException("PrivateKey must be non-null and non-empty");
        }else if (publicKey == null || publicKey.equals("")) {
            throw new IllegalArgumentException("PublicKey must be non-null and non-empty");
        }

        sPrivateKey = privateKey;
        sPublicKey = publicKey;
        sContext = applicationContext;
        sCacheSize = cacheSize;

        sInstance = new MarvelAndroid();
    }

    public CharacterEndpoint getCharacterEndpoint() {
        if (mCharacterEndpoint == null) {
            mCharacterEndpoint = new CharacterEndpoint(mRestAdapter.create(CharacterService.class));
        }
        return mCharacterEndpoint;
    }

    private MarvelAndroid() {

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

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateAdapter())
                .create();

        mRestAdapter = new RestAdapter.Builder()
                .setClient(new OkClient(okHttpClient))
                .setConverter(new GsonConverter(gson))
                .setEndpoint(API_URL)
                .build();

    }

    public RestAdapter getRestAdapter() {
        return mRestAdapter;
    }

    private class DateAdapter implements JsonDeserializer<Date> {

        private final String[] DATE_FORMATS = new String[]{
                "yyyy-MM-dd'T'HH:mm:ssZ",
                "yyyy-MM-dd HH:mm:ss"
        };

        @Override
        public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws
                JsonParseException {
            for (String format : DATE_FORMATS) {
                try {
                    return new SimpleDateFormat(format, Locale.US).parse(jsonElement.getAsString());
                } catch (ParseException e) {
                    Log.d(TAG, "Caught ParseException for format: " + format);
                }
            }
            throw new JsonParseException("Unparseable date: \"" + jsonElement.getAsString()
                    + "\". Supported formats: " + Arrays.toString(DATE_FORMATS));
        }
    }
}
