package com.n8.marveldroid_sample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.n8.marveldroid.Endpoints.CharacterEndpoint;
import com.n8.marveldroid.ModelObjects.Character;
import com.n8.marveldroid.MarvelAndroid;
import com.n8.marveldroid.QueryParams.CharacterQueryParams;
import com.n8.marveldroid.RequestResponse;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class CharacterFragment extends Fragment {

    private String mMsg;

    public CharacterFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_character, container, false);

        final TextView textView = (TextView) view.findViewById(R.id.character_fragment_character_textView);

        CharacterQueryParams queryParams = new CharacterQueryParams();
        queryParams.setNameStartsWith("spider");

        MarvelAndroid marvelAndroid = MarvelAndroid.getInstance();
        CharacterEndpoint characterEndpoint = marvelAndroid.getCharacterEndpoint();

    /*
     * Standard way
     */
        mMsg = "";

        characterEndpoint.getCharacters(queryParams, new Callback<RequestResponse<Character>>() {
            @Override
            public void success(RequestResponse<Character> characterRequestResponse, Response response) {
                List<Character> characters = characterRequestResponse.data.results;

                mMsg += "*************************************\n";
                mMsg += "Characters\n";
                for (Character character : characters) {
                    mMsg += character.name + "\n";
                }
                mMsg += "*************************************\n";

                textView.setText(mMsg);
            }

            @Override
            public void failure(RetrofitError error) {
                mMsg += error.getLocalizedMessage() + "\n";
                textView.setText(mMsg);
            }
        });

        return view;
    }
}
