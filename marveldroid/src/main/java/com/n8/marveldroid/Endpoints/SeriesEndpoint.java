package com.n8.marveldroid.Endpoints;

import android.support.annotation.NonNull;

import com.n8.marveldroid.EntityModelObjects.Series;
import com.n8.marveldroid.QueryParams.SeriesQueryParams;
import com.n8.marveldroid.RequestServices.SeriesService;
import com.n8.marveldroid.ServiceResponse;

import retrofit.Callback;
import rx.Observable;

public class SeriesEndpoint extends BaseEndpoint {

    private SeriesService seriesService;

    public SeriesEndpoint(@NonNull SeriesService seriesService) {
        this.seriesService = seriesService;
    }

    public void getSeriesForId(int seriesId, Callback<ServiceResponse<Series>> callback) {

    }

    public Observable<ServiceResponse<Series>> getSeriesForId(int seriesId) {
        return null;
    }

    public void getSeries(@NonNull SeriesQueryParams queryParams, Callback<ServiceResponse<Series>> callback) {

    }

    public Observable<ServiceResponse<Series>> getSeries(@NonNull SeriesQueryParams queryParams) {
        return null;
    }

    public void getSeriesForCharacterId(int characterId, @NonNull SeriesQueryParams queryParams, Callback<ServiceResponse<Series>> callback) {

    }

    public Observable<ServiceResponse<Series>> getSeriesForCharacterId(int characterId, @NonNull SeriesQueryParams queryParams) {
        return null;
    }

    public void getSeriesForCreatorId(int creatorId, @NonNull SeriesQueryParams queryParams, Callback<ServiceResponse<Series>> callback) {

    }

    public Observable<ServiceResponse<Series>> getSeriesForCreatorId(int creatorId, @NonNull SeriesQueryParams queryParams) {
        return null;
    }

    public void getSeriesForEventId(int eventId, @NonNull SeriesQueryParams queryParams, Callback<ServiceResponse<Series>> callback) {

    }

    public Observable<ServiceResponse<Series>> getSeriesForEventId(int eventId, @NonNull SeriesQueryParams queryParams) {
        return null;
    }

    public void getSeriesForStoryId(int storyId, @NonNull SeriesQueryParams queryParams, Callback<ServiceResponse<Series>> callback) {

    }

    public Observable<ServiceResponse<Series>> getSeriesForStoryId(int storyId, @NonNull SeriesQueryParams queryParams) {
        return null;
    }
}
