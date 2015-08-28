package com.n8.marveldroid_sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.n8.marveldroid.Endpoints.CharacterEndpoint;
import com.n8.marveldroid.MarvelAndroid;
import com.n8.marveldroid.QueryParams.CharacterQueryParams;
import com.n8.marveldroid.ServiceResponse;
import com.n8.marveldroid.EntityModelObjects.Character;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    private TextView mResultTextView;

    private String msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mResultTextView = (TextView) findViewById(R.id.main_activity_result_textView);

        MarvelAndroid.initialize(
                this,
                new String(Base64.decode(getString(R.string.private_key), Base64.DEFAULT)),
                new String(Base64.decode(getString(R.string.public_key), Base64.DEFAULT)),
                5 * 1024 * 1024);

        CharacterQueryParams queryParams = new CharacterQueryParams();
        queryParams.setNameStartsWith("spider");

        MarvelAndroid marvelAndroid = MarvelAndroid.getInstance();
        CharacterEndpoint characterEndpoint = marvelAndroid.getCharacterEndpoint();

    /*
     * Standard way
     */
        msg = "";

        characterEndpoint.getCharacters(queryParams, new Callback<ServiceResponse<Character>>() {
            @Override
            public void success(ServiceResponse<Character> characterServiceResponse, Response response) {
                List<Character> characters = characterServiceResponse.data.results;

                msg += "*************************************\n";
                msg += "Characters\n";
                for (Character character : characters) {
                    msg += character.name + "\n";
                }
                msg += "*************************************\n";

                mResultTextView.setText(msg);
            }

            @Override
            public void failure(RetrofitError error) {
                msg += error.getLocalizedMessage() + "\n";
                mResultTextView.setText(msg);
            }
        });
    }
}
