package com.n8.marveldroid.Deserializers;

import android.util.Log;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.n8.marveldroid.MarvelAndroid;
import com.n8.marveldroid.ModelObjects.Summary.StorySummary;

import java.lang.reflect.Type;

public class StorySummaryDeserializer implements JsonDeserializer<StorySummary> {
    private static final String TAG = StorySummaryDeserializer.class.getSimpleName();

    public StorySummary deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        StorySummary summary = new StorySummary();
        try {
            summary.name = json.getAsJsonObject().get("name").getAsString();
        } catch (Exception e) {
            if (MarvelAndroid.LOGGING_ENABLED) {
                Log.d(TAG, "Failed to parse 'name' from " + json.toString());
            }
        }

        try {
            summary.resourceURI = json.getAsJsonObject().get("resourceURI").getAsString();
        } catch (Exception e) {
            if (MarvelAndroid.LOGGING_ENABLED) {
                Log.d(TAG, "Failed to parse 'resourceURI' from " + json.toString());
            }
        }

        try {
            summary.type = json.getAsJsonObject().get("type").getAsString();
        } catch (Exception e) {
            if (MarvelAndroid.LOGGING_ENABLED) {
                Log.d(TAG, "Failed to parse 'type' from " + json.toString());
            }
        }

        return summary;
    }
}
