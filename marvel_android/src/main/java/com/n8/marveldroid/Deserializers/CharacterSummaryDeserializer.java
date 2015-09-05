package com.n8.marveldroid.Deserializers;

import android.util.Log;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.n8.marveldroid.MarvelAndroid;
import com.n8.marveldroid.ModelObjects.Summary.CharacterSummary;

import java.lang.reflect.Type;

public class CharacterSummaryDeserializer implements JsonDeserializer<CharacterSummary> {
    private static final String TAG = CharacterSummaryDeserializer.class.getSimpleName();

    public CharacterSummary deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        CharacterSummary summary = new CharacterSummary();
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
            summary.role = json.getAsJsonObject().get("role").getAsString();
        } catch (Exception e) {
            if (MarvelAndroid.LOGGING_ENABLED) {
                Log.d(TAG, "Failed to parse 'role' from " + json.toString());
            }
        }

        return summary;
    }
}
