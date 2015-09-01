package com.n8.marveldroid_sample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.n8.marveldroid.Endpoints.CharacterEndpoint;
import com.n8.marveldroid.Endpoints.ComicEndpoint;
import com.n8.marveldroid.EntityModelObjects.*;
import com.n8.marveldroid.EntityModelObjects.Character;
import com.n8.marveldroid.MarvelAndroid;
import com.n8.marveldroid.QueryParams.CharacterQueryParams;
import com.n8.marveldroid.QueryParams.ComicQueryParams;
import com.n8.marveldroid.ServiceResponse;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ComicFragment extends Fragment {

    private String mMsg;

    public ComicFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_comic, container, false);

        final TextView textView = (TextView) view.findViewById(R.id.comic_fragment_comics_textView);

        ComicQueryParams queryParams = new ComicQueryParams();
        queryParams.setOrderBy(ComicQueryParams.OrderBy.FOCDateDescending);

        MarvelAndroid marvelAndroid = MarvelAndroid.getInstance();
        ComicEndpoint comicEndpoint = marvelAndroid.getmComicEndpoint();

        /*
         * Standard way
         */

        mMsg = "";

        comicEndpoint.getComics(queryParams, new Callback<ServiceResponse<Comic>>() {
            @Override
            public void success(ServiceResponse<Comic> serviceResponse, Response response) {
                List<Comic> comics = serviceResponse.data.results;

                mMsg += "*************************************\n";
                mMsg += "Comics\n";
                for (Comic comic : comics) {
                    mMsg += comic.title + "\n";
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
