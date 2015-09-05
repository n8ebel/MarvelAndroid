package com.n8.marveldroid.Deserializers;

import android.util.Log;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.n8.marveldroid.MarvelAndroid;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class DateDeserializer implements JsonDeserializer<Date> {
    private static final String TAG = DateDeserializer.class.getSimpleName();

    private final String[] FORMATS = new String[]{
            "yyyy-MM-dd HH:mm:ss",
            "yyyy-MM-dd'T'HH:mm:ssZ"
    };

    @Override
    public Date deserialize(JsonElement jsonElement,
                            Type type, JsonDeserializationContext jsonDeserializationContext)
            throws JsonParseException {

        for (String format : FORMATS) {
            try {
                return new SimpleDateFormat(format, Locale.US).parse(jsonElement.getAsString());
            } catch (ParseException e) { }
        }

        if (MarvelAndroid.LOGGING_ENABLED) {
            Log.d(TAG, "Failed to parse 'date' from \"" + jsonElement.getAsString()
                    + "\". Supported formats: " + Arrays.toString(FORMATS));
        }

        return null;
    }
}
