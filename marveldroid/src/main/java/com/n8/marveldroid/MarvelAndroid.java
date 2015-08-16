package com.n8.marveldroid;

import android.content.Context;
import android.util.Log;

import com.google.common.base.Joiner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.n8.marveldroid.Endpoints.CharacterEndpoint;
import com.n8.marveldroid.EntityModelObjects.Character;
import com.n8.marveldroid.EntityModelObjects.Comic;
import com.n8.marveldroid.QueryParams.CharacterQueryParams;
import com.n8.marveldroid.RequestServices.CharacterService;
import com.n8.marveldroid.QueryParams.ComicQueryParams;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;
import rx.Observable;

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

    private CharacterEndpoint mCharacterEndpoint;

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

    public CharacterEndpoint getCharacterEndpoint() {
        if (mCharacterEndpoint == null) {
            characters = mRestAdapter.create(CharacterService.class);
            mCharacterEndpoint = new CharacterEndpoint(characters);
        }
        return mCharacterEndpoint;
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

      Gson gson = new GsonBuilder()
          .registerTypeAdapter(Date.class, new DateAdapter())
          .create();

        mRestAdapter = new RestAdapter.Builder()
                .setClient(new OkClient(okHttpClient))
                .setConverter(new GsonConverter(gson))
                .setEndpoint(API_URL)
                .build();

    }

    public RestAdapter getRestAdapter(){
        return mRestAdapter;
    }



  public void getComicsForCharacterId(int characterId, ComicQueryParams queryParams, Callback<ServiceResponse<Comic>> callback) {
    characters.getComicsForCharacterId(characterId
        , queryParams.getLimit()
        , queryParams.getOffset()
        , String.valueOf(queryParams.getTimestamp())
        , queryParams.getApiKey()
        , queryParams.getHashSignature()
        , queryParams.getFormat().getValue()
        , queryParams.getFormatType().getValue()
        , queryParams.isNoVariants()
        , queryParams.getDateDescriptor().getValue()
        , queryParams.getDateRange()
        , queryParams.isHasDigitalIssue()
        , queryParams.getModifiedSince()
        , parameterizeList(queryParams.getCreators())
        , parameterizeList(queryParams.getSeries())
        , parameterizeList(queryParams.getEvents())
        , parameterizeList(queryParams.getStories())
        , parameterizeList(queryParams.getSharedAppearances())
        , parameterizeList(queryParams.getCollaborators())
        , queryParams.getOrderBy().getValue()
        , callback);
  }

  public Observable<ServiceResponse<Character>> getCharacters(CharacterQueryParams queryParams) {
    return characters.getObservableCharacters(queryParams.getLimit()
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
        , queryParams.getOrderBy().getValue());
  }

  public Observable<ServiceResponse<Comic>> getComicsForCharacterId(int characterId, ComicQueryParams queryParams) {
    return characters.getObservableComicsForCharacterId(characterId
        , queryParams.getLimit()
        , queryParams.getOffset()
        , String.valueOf(queryParams.getTimestamp())
        , queryParams.getApiKey()
        , queryParams.getHashSignature()
        , queryParams.getFormat().getValue()
        , queryParams.getFormatType().getValue()
        , queryParams.isNoVariants()
        , queryParams.getDateDescriptor().getValue()
        , queryParams.getDateRange()
        , queryParams.isHasDigitalIssue()
        , queryParams.getModifiedSince()
        , parameterizeList(queryParams.getCreators())
        , parameterizeList(queryParams.getSeries())
        , parameterizeList(queryParams.getEvents())
        , parameterizeList(queryParams.getStories())
        , parameterizeList(queryParams.getSharedAppearances())
        , parameterizeList(queryParams.getCollaborators())
        , queryParams.getOrderBy().getValue());
  }

  private class DateAdapter implements JsonDeserializer<Date> {

    private final String[] DATE_FORMATS = new String[] {
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
        }
      }
      throw new JsonParseException("Unparseable date: \"" + jsonElement.getAsString()
          + "\". Supported formats: " + Arrays.toString(DATE_FORMATS));
    }
  }
}
