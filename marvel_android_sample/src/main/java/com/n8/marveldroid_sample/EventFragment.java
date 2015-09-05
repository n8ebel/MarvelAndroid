package com.n8.marveldroid_sample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.n8.marveldroid.Endpoints.ComicEndpoint;
import com.n8.marveldroid.Endpoints.EventEndpoint;
import com.n8.marveldroid.MarvelAndroid;
import com.n8.marveldroid.ModelObjects.Comic;
import com.n8.marveldroid.ModelObjects.Event;
import com.n8.marveldroid.QueryParams.ComicQueryParams;
import com.n8.marveldroid.QueryParams.EventQueryParams;
import com.n8.marveldroid.RequestResponse;
import com.n8.marveldroid_sample.R;

import org.w3c.dom.Text;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class EventFragment extends Fragment {

    private String mMsg;

    public EventFragment() { }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event, container, false);

        final TextView textView = (TextView) view.findViewById(R.id.event_fragment_events_textView);

        EventQueryParams queryParams = new EventQueryParams();
        queryParams.setOrderBy(EventQueryParams.OrderBy.StartDateDescending);

        MarvelAndroid marvelAndroid = MarvelAndroid.getInstance();
        EventEndpoint eventEndpoint = marvelAndroid.getEventEndpoint();

        /*
         * Standard way
         */

        mMsg = "";

        eventEndpoint.getEvents(queryParams, new Callback<RequestResponse<Event>>() {
            @Override
            public void success(RequestResponse<Event> requestResponse, Response response) {
                List<Event> events = requestResponse.data.results;

                mMsg += "*************************************\n";
                mMsg += "Comics\n";
                for (Event event : events) {
                    mMsg += event.title + "\n";
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
