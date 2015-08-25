package com.n8.marveldroid.Endpoints;

import android.support.annotation.NonNull;

import com.n8.marveldroid.EntityModelObjects.Series;
import com.n8.marveldroid.QueryParams.SeriesQueryParams;
import com.n8.marveldroid.RequestServices.SeriesService;
import com.n8.marveldroid.ServiceResponse;

import retrofit.Callback;
import rx.Observable;

public class SeriesEndpoint extends BaseEndpoint {

    private SeriesService mSeriesService;

    public SeriesEndpoint(@NonNull SeriesService seriesService) {
        mSeriesService = seriesService;
    }

    public void getSeriesForId(int seriesId, Callback<ServiceResponse<Series>> callback) {
        mSeriesService.getSeriesForId(seriesId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                callback);
    }

    public Observable<ServiceResponse<Series>> getSeriesForId(int seriesId) {
        return mSeriesService.getSeriesForId(seriesId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature());
    }

    public void getSeries(@NonNull SeriesQueryParams queryParams, Callback<ServiceResponse<Series>> callback) {
        mSeriesService.getSeries(
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                queryParams.getSeriesType().getValue(),
                queryParams.getContains().getValue(),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    public Observable<ServiceResponse<Series>> getSeries(@NonNull SeriesQueryParams queryParams) {
        return mSeriesService.getSeries(
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                queryParams.getSeriesType().getValue(),
                queryParams.getContains().getValue(),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    public void getSeriesForCharacterId(int characterId, @NonNull SeriesQueryParams queryParams, Callback<ServiceResponse<Series>> callback) {
        mSeriesService.getSeriesForCharacterId(
                characterId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getCreators()),
                queryParams.getSeriesType().getValue(),
                queryParams.getContains().getValue(),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    public Observable<ServiceResponse<Series>> getSeriesForCharacterId(int characterId, @NonNull SeriesQueryParams queryParams) {
        return mSeriesService.getSeriesForCharacterId(
                characterId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getCreators()),
                queryParams.getSeriesType().getValue(),
                queryParams.getContains().getValue(),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    public void getSeriesForCreatorId(int creatorId, @NonNull SeriesQueryParams queryParams, Callback<ServiceResponse<Series>> callback) {
        mSeriesService.getSeriesForCreatorId(
                creatorId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getCharacters()),
                queryParams.getSeriesType().getValue(),
                queryParams.getContains().getValue(),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    public Observable<ServiceResponse<Series>> getSeriesForCreatorId(int creatorId, @NonNull SeriesQueryParams queryParams) {
        return mSeriesService.getSeriesForCreatorId(
                creatorId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getCharacters()),
                queryParams.getSeriesType().getValue(),
                queryParams.getContains().getValue(),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    public void getSeriesForEventId(int eventId, @NonNull SeriesQueryParams queryParams, Callback<ServiceResponse<Series>> callback) {
        mSeriesService.getSeriesForEventId(
                eventId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                queryParams.getSeriesType().getValue(),
                queryParams.getContains().getValue(),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    public Observable<ServiceResponse<Series>> getSeriesForEventId(int eventId, @NonNull SeriesQueryParams queryParams) {
        return mSeriesService.getSeriesForEventId(
                eventId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                queryParams.getSeriesType().getValue(),
                queryParams.getContains().getValue(),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    public void getSeriesForStoryId(int storyId, @NonNull SeriesQueryParams queryParams, Callback<ServiceResponse<Series>> callback) {
        mSeriesService.getSeriesForStoryId(
                storyId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                queryParams.getSeriesType().getValue(),
                queryParams.getContains().getValue(),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    public Observable<ServiceResponse<Series>> getSeriesForStoryId(int storyId, @NonNull SeriesQueryParams queryParams) {
        return mSeriesService.getSeriesForStoryId(
                storyId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                queryParams.getSeriesType().getValue(),
                queryParams.getContains().getValue(),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }
}
