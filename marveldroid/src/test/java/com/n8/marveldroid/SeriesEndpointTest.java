package com.n8.marveldroid;

import android.support.annotation.NonNull;

import com.n8.marveldroid.Endpoints.BaseEndpoint;
import com.n8.marveldroid.Endpoints.EventEndpoint;
import com.n8.marveldroid.Endpoints.SeriesEndpoint;
import com.n8.marveldroid.QueryParams.EventQueryParams;
import com.n8.marveldroid.QueryParams.SeriesQueryParams;
import com.n8.marveldroid.RequestServices.EventService;
import com.n8.marveldroid.RequestServices.SeriesService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Config(constants = BuildConfig.class, sdk = 21)
@RunWith(RobolectricGradleTestRunner.class)
public class SeriesEndpointTest {

    private static final String PRIVATE_KEY = "private_key";
    private static final String PUBLIC_KEY = "public_key";
    private static final String HASH_SIG = "hash";
    private static final long TIMESTAMP = 123456789;
    private static final int SERIES_ID = 1001;
    private static final int OTHER_ID = 2002;


    @Mock
    SeriesService mockSeriesService;

    MarvelAndroid mMarvelAndroid;

    private SeriesEndpoint mSeriesEndpoint;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        MarvelAndroid.initialize(RuntimeEnvironment.application, PRIVATE_KEY, PUBLIC_KEY, 5 * 1024 * 1024);
        mMarvelAndroid = MarvelAndroid.getInstance();

        mSeriesEndpoint = new MockSeriesEndpoint(mockSeriesService);
    }

    @Test
    public void testGetSeriesServiceCallbackMethodCalled() throws Exception {
        SeriesQueryParams queryParams = createQueryParams();
        mSeriesEndpoint.getSeries(queryParams, null);

        Mockito.verify(mockSeriesService).getSeries(
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
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
                null);
    }

    @Test
    public void testGetSeriesServiceObservableMethodCalled() throws Exception {
        SeriesQueryParams queryParams = createQueryParams();
        mSeriesEndpoint.getSeries(queryParams);

        Mockito.verify(mockSeriesService).getSeries(
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
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

    @Test
    public void testGetSeriesForIdServiceCallbackMethodCalled() throws Exception {
        mSeriesEndpoint.getSeriesForId(SERIES_ID, null);

        Mockito.verify(mockSeriesService).getSeriesForId(
                SERIES_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                null);
    }

    @Test
    public void testGetSeriesForIdServiceObservableMethodCalled() throws Exception {
        mSeriesEndpoint.getSeriesForId(SERIES_ID);

        Mockito.verify(mockSeriesService).getSeriesForId(
                SERIES_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG);
    }

    @Test
    public void testGetSeriesForCharacterIdServiceCallbackMethodCalled() throws Exception {
        SeriesQueryParams queryParams = createQueryParams();
        mSeriesEndpoint.getSeriesForCharacterId(OTHER_ID, queryParams, null);

        Mockito.verify(mockSeriesService).getSeriesForCharacterId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
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
                null);
    }

    @Test
    public void testGetSeriesForCharacterIdServiceObservableMethodCalled() throws Exception {
        SeriesQueryParams queryParams = createQueryParams();
        mSeriesEndpoint.getSeriesForCharacterId(OTHER_ID, queryParams);

        Mockito.verify(mockSeriesService).getSeriesForCharacterId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
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

    @Test
    public void testGetSeriesForCreatorIdServiceCallbackMethodCalled() throws Exception {
        SeriesQueryParams queryParams = createQueryParams();
        mSeriesEndpoint.getSeriesForCreatorId(OTHER_ID, queryParams, null);

        Mockito.verify(mockSeriesService).getSeriesForCreatorId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
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
                null);
    }

    @Test
    public void testGetSeriesForCreatorIdServiceObservableMethodCalled() throws Exception {
        SeriesQueryParams queryParams = createQueryParams();
        mSeriesEndpoint.getSeriesForCreatorId(OTHER_ID, queryParams);

        Mockito.verify(mockSeriesService).getSeriesForCreatorId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
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

    @Test
    public void testGetSeriesForEventIdServiceCallbackMethodCalled() throws Exception {
        SeriesQueryParams queryParams = createQueryParams();
        mSeriesEndpoint.getSeriesForEventId(OTHER_ID, queryParams, null);

        Mockito.verify(mockSeriesService).getSeriesForEventId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
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
                null);
    }

    @Test
    public void testGetSeriesForEventIdServiceObservableMethodCalled() throws Exception {
        SeriesQueryParams queryParams = createQueryParams();
        mSeriesEndpoint.getSeriesForEventId(OTHER_ID, queryParams);

        Mockito.verify(mockSeriesService).getSeriesForEventId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
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

    @Test
    public void testGetSeriesForStoryIdServiceCallbackMethodCalled() throws Exception {
        SeriesQueryParams queryParams = createQueryParams();
        mSeriesEndpoint.getSeriesForStoryId(OTHER_ID, queryParams, null);

        Mockito.verify(mockSeriesService).getSeriesForStoryId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
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
                null);
    }

    @Test
    public void testGetSeriesForStoryIdServiceObservableMethodCalled() throws Exception {
        SeriesQueryParams queryParams = createQueryParams();
        mSeriesEndpoint.getSeriesForStoryId(OTHER_ID, queryParams);

        Mockito.verify(mockSeriesService).getSeriesForStoryId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
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

    @NonNull
    private SeriesQueryParams createQueryParams() {
        SeriesQueryParams queryParams = new SeriesQueryParams();

        queryParams.setTitle("Spider-Man");
        queryParams.setTitleStartsWith("Sp");
        queryParams.setStartYear(1972);

        queryParams.setModifiedSince(new Date(System.currentTimeMillis()));

        queryParams.setCreators(Arrays.asList(1, 2, 3));
        queryParams.setCharacters(Arrays.asList(4, 5));
        queryParams.setEvents(Arrays.asList(6));
        queryParams.setComics(Arrays.asList(7, 8, 9, 10));
        queryParams.setStories(Arrays.asList(11, 12));

        queryParams.setSeriesType(SeriesQueryParams.SeriesType.Collection);
        queryParams.setContains(SeriesQueryParams.Contains.Comic);
        queryParams.setOrderBy(SeriesQueryParams.OrderBy.Default);

        queryParams.setLimit(25);
        queryParams.setOffset(0);

        return queryParams;
    }

    private String getJoinedList(List<?> list) {
        return BaseEndpoint.getJoinedList(list);
    }

    private class MockSeriesEndpoint extends SeriesEndpoint {
        public MockSeriesEndpoint(@NonNull SeriesService seriesService) {
            super(seriesService);
        }

        @Override
        protected long getTimestamp() {
            return TIMESTAMP;
        }

        @Override
        protected String getHashSignature() {
            return HASH_SIG;
        }

        @Override
        protected String getApiKey() {
            return PUBLIC_KEY;
        }
    }
}
