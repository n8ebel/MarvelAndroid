package com.n8.marveldroid.Endpoints;

import android.support.annotation.NonNull;

import com.n8.marveldroid.RequestServices.SeriesService;

public class SeriesEndpoint extends BaseEndpoint {

    private SeriesService seriesService;

    public SeriesEndpoint(@NonNull SeriesService seriesService) {
        this.seriesService = seriesService;
    }
}
