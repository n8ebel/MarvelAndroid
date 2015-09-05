package com.n8.marveldroid;

import android.content.Context;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.n8.marveldroid.Deserializers.DateDeserializer;
import com.n8.marveldroid.Endpoints.CharacterEndpoint;
import com.n8.marveldroid.Endpoints.ComicEndpoint;
import com.n8.marveldroid.Endpoints.CreatorEndpoint;
import com.n8.marveldroid.Endpoints.EventEndpoint;
import com.n8.marveldroid.Endpoints.SeriesEndpoint;
import com.n8.marveldroid.Endpoints.StoryEndpoint;
import com.n8.marveldroid.Deserializers.CharacterSummaryDeserializer;
import com.n8.marveldroid.Deserializers.ComicSummaryDeserializer;
import com.n8.marveldroid.Deserializers.CreatorSummaryAdapter;
import com.n8.marveldroid.Deserializers.EventSummaryDeserializer;
import com.n8.marveldroid.Deserializers.SeriesSummaryDeserializer;
import com.n8.marveldroid.Deserializers.StorySummaryDeserializer;
import com.n8.marveldroid.ModelObjects.Summary.CharacterSummary;
import com.n8.marveldroid.ModelObjects.Summary.ComicSummary;
import com.n8.marveldroid.ModelObjects.Summary.CreatorSummary;
import com.n8.marveldroid.ModelObjects.Summary.EventSummary;
import com.n8.marveldroid.ModelObjects.Summary.SeriesSummary;
import com.n8.marveldroid.ModelObjects.Summary.StorySummary;
import com.n8.marveldroid.RequestServices.CharacterService;
import com.n8.marveldroid.RequestServices.ComicService;
import com.n8.marveldroid.RequestServices.CreatorService;
import com.n8.marveldroid.RequestServices.EventService;
import com.n8.marveldroid.RequestServices.SeriesService;
import com.n8.marveldroid.RequestServices.StoryService;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import java.io.IOException;
import java.util.Date;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

public class MarvelAndroid {

    public static final String PORT = "80";
    public static final String API_DOMAIN = "http://gateway.marvel.com";
    public static final String API_URL = API_DOMAIN + ":" + PORT;

    public static boolean LOGGING_ENABLED = false;

    private static final String TAG = MarvelAndroid.class.getSimpleName();

    private static MarvelAndroid sInstance;
    private static Context sContext;

    private static String sPrivateKey;
    private static String sPublicKey;

    private static long sCacheSize;

    private RestAdapter mRestAdapter;

    private CharacterEndpoint mCharacterEndpoint;
    private ComicEndpoint mComicEndpoint;
    private CreatorEndpoint mCreatorEndpoint;
    private EventEndpoint mEventEndpoint;
    private SeriesEndpoint mSeriesEndpoint;
    private StoryEndpoint mStoryEndpoint;

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
            mCharacterEndpoint = new CharacterEndpoint(mRestAdapter.create(CharacterService.class), sPublicKey, sPrivateKey);
        }
        return mCharacterEndpoint;
    }

    public ComicEndpoint getComicEndpoint() {
        if (mComicEndpoint == null) {
            mComicEndpoint = new ComicEndpoint(mRestAdapter.create(ComicService.class), sPublicKey, sPrivateKey);
        }
        return mComicEndpoint;
    }

    public CreatorEndpoint getCreatorEndpoint() {
        if (mCreatorEndpoint == null) {
            mCreatorEndpoint = new CreatorEndpoint(mRestAdapter.create(CreatorService.class), sPublicKey, sPrivateKey);
        }
        return mCreatorEndpoint;
    }

    public EventEndpoint getEventEndpoint() {
        if (mEventEndpoint == null) {
            mEventEndpoint = new EventEndpoint(mRestAdapter.create(EventService.class), sPublicKey, sPrivateKey);
        }
        return mEventEndpoint;
    }

    public SeriesEndpoint getSeriesEndpoint() {
        if (mSeriesEndpoint == null) {
            mSeriesEndpoint = new SeriesEndpoint(mRestAdapter.create(SeriesService.class), sPublicKey, sPrivateKey);
        }
        return mSeriesEndpoint;
    }

    public StoryEndpoint getStoryEndpoint() {
        if (mStoryEndpoint == null) {
            mStoryEndpoint = new StoryEndpoint(mRestAdapter.create(StoryService.class), sPublicKey, sPrivateKey);
        }
        return mStoryEndpoint;
    }

    private MarvelAndroid() {

        OkHttpClient okHttpClient = new OkHttpClient();
        Cache cache = null;

        try {
            cache = new Cache(sContext.getCacheDir(), sCacheSize);
        } catch (IOException e) {
            Log.d(TAG, "Failed to newInstance cache: " + e.getLocalizedMessage());
        }

        okHttpClient.setCache(cache);

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateDeserializer())
                .registerTypeAdapter(CharacterSummary.class, new CharacterSummaryDeserializer())
                .registerTypeAdapter(ComicSummary.class, new ComicSummaryDeserializer())
                .registerTypeAdapter(CreatorSummary.class, new CreatorSummaryAdapter())
                .registerTypeAdapter(EventSummary.class, new EventSummaryDeserializer())
                .registerTypeAdapter(SeriesSummary.class, new SeriesSummaryDeserializer())
                .registerTypeAdapter(StorySummary.class, new StorySummaryDeserializer())
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
}
