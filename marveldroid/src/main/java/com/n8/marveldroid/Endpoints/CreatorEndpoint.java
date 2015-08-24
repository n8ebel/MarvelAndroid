package com.n8.marveldroid.Endpoints;

import android.support.annotation.NonNull;

import com.n8.marveldroid.EntityModelObjects.Creator;
import com.n8.marveldroid.QueryParams.CreatorQueryParams;
import com.n8.marveldroid.RequestServices.CreatorService;
import com.n8.marveldroid.ServiceResponse;

import retrofit.Callback;
import rx.Observable;

/**
 * Provides methods to retrieve {@link Creator}s for the various rest endpoints (Event, Story, etc).
 */
public class CreatorEndpoint extends BaseEndpoint {
    private CreatorService mCreatorService;

    public CreatorEndpoint(@NonNull CreatorService creatorService) {
        mCreatorService = creatorService;
    }

    public void getCreator(int creatorId, Callback<ServiceResponse<Creator>> callback) {
        mCreatorService.getCreatorForId(
                creatorId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                callback);

    }

    public Observable<ServiceResponse<Creator>> getCreator(int creatorId) {
        return mCreatorService.getCreatorForId(
                creatorId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature());
    }

    public void getCreators(CreatorQueryParams queryParams, Callback<ServiceResponse<Creator>> callback) {
        mCreatorService.getCreators(
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getFirstName(),
                queryParams.getMiddleName(),
                queryParams.getLastName(),
                queryParams.getSuffix(),
                queryParams.getNameStartsWith(),
                queryParams.getFirstNameStartsWith(),
                queryParams.getMiddleNameStartsWith(),
                queryParams.getLastNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    public Observable<ServiceResponse<Creator>> getCreators(CreatorQueryParams queryParams) {
        return mCreatorService.getCreators(
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getFirstName(),
                queryParams.getMiddleName(),
                queryParams.getLastName(),
                queryParams.getSuffix(),
                queryParams.getNameStartsWith(),
                queryParams.getFirstNameStartsWith(),
                queryParams.getMiddleNameStartsWith(),
                queryParams.getLastNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    public void getCreatorsForComicId(int comicId, CreatorQueryParams queryParams, Callback<ServiceResponse<Creator>> callback) {
        mCreatorService.getCreatorsForComicId(
                comicId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getFirstName(),
                queryParams.getMiddleName(),
                queryParams.getLastName(),
                queryParams.getSuffix(),
                queryParams.getNameStartsWith(),
                queryParams.getFirstNameStartsWith(),
                queryParams.getMiddleNameStartsWith(),
                queryParams.getLastNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    public Observable<ServiceResponse<Creator>>  getCreatorsForComicId(int comicId, CreatorQueryParams queryParams) {
        return mCreatorService.getCreatorsForComicId(
                comicId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getFirstName(),
                queryParams.getMiddleName(),
                queryParams.getLastName(),
                queryParams.getSuffix(),
                queryParams.getNameStartsWith(),
                queryParams.getFirstNameStartsWith(),
                queryParams.getMiddleNameStartsWith(),
                queryParams.getLastNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    public void getCreatorsForEventId(int eventId, CreatorQueryParams queryParams, Callback<ServiceResponse<Creator>> callback) {
        mCreatorService.getCreatorsForEventId(
                eventId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getFirstName(),
                queryParams.getMiddleName(),
                queryParams.getLastName(),
                queryParams.getSuffix(),
                queryParams.getNameStartsWith(),
                queryParams.getFirstNameStartsWith(),
                queryParams.getMiddleNameStartsWith(),
                queryParams.getLastNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    public Observable<ServiceResponse<Creator>> getCreatorsForEventId(int eventId, CreatorQueryParams queryParams) {
        return mCreatorService.getCreatorsForEventId(
                eventId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getFirstName(),
                queryParams.getMiddleName(),
                queryParams.getLastName(),
                queryParams.getSuffix(),
                queryParams.getNameStartsWith(),
                queryParams.getFirstNameStartsWith(),
                queryParams.getMiddleNameStartsWith(),
                queryParams.getLastNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    public void getCreatorsForSeriesId(int seriesId, CreatorQueryParams queryParams, Callback<ServiceResponse<Creator>> callback) {
        mCreatorService.getCreatorsForSeriesId(
                seriesId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getFirstName(),
                queryParams.getMiddleName(),
                queryParams.getLastName(),
                queryParams.getSuffix(),
                queryParams.getNameStartsWith(),
                queryParams.getFirstNameStartsWith(),
                queryParams.getMiddleNameStartsWith(),
                queryParams.getLastNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    public Observable<ServiceResponse<Creator>>  getCreatorsForSeriesId(int seriesId, CreatorQueryParams queryParams) {
        return mCreatorService.getCreatorsForSeriesId(
                seriesId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getFirstName(),
                queryParams.getMiddleName(),
                queryParams.getLastName(),
                queryParams.getSuffix(),
                queryParams.getNameStartsWith(),
                queryParams.getFirstNameStartsWith(),
                queryParams.getMiddleNameStartsWith(),
                queryParams.getLastNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    public void getCreatorsForStoryId(int storyId, CreatorQueryParams queryParams, Callback<ServiceResponse<Creator>> callback) {
        mCreatorService.getCreatorsForStoryId(
                storyId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getFirstName(),
                queryParams.getMiddleName(),
                queryParams.getLastName(),
                queryParams.getSuffix(),
                queryParams.getNameStartsWith(),
                queryParams.getFirstNameStartsWith(),
                queryParams.getMiddleNameStartsWith(),
                queryParams.getLastNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                callback);
    }

    public Observable<ServiceResponse<Creator>>  getCreatorsForStoryId(int storyId, CreatorQueryParams queryParams) {
        return mCreatorService.getCreatorsForStoryId(
                storyId,
                String.valueOf(getTimestamp()),
                getApiKey(),
                getHashSignature(),
                queryParams.getFirstName(),
                queryParams.getMiddleName(),
                queryParams.getLastName(),
                queryParams.getSuffix(),
                queryParams.getNameStartsWith(),
                queryParams.getFirstNameStartsWith(),
                queryParams.getMiddleNameStartsWith(),
                queryParams.getLastNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }


}
