package com.n8.marveldroid;

import android.support.annotation.NonNull;

import com.n8.marveldroid.Endpoints.BaseEndpoint;
import com.n8.marveldroid.Endpoints.EventEndpoint;
import com.n8.marveldroid.QueryParams.EventQueryParams;
import com.n8.marveldroid.RequestServices.EventService;

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
public class EventEndpointTest {

    private static final String PRIVATE_KEY = "private_key";
    private static final String PUBLIC_KEY = "public_key";
    private static final String HASH_SIG = "hash";
    private static final long TIMESTAMP = 123456789;
    private static final int EVENT_ID = 1001;
    private static final int OTHER_ID = 2002;


    @Mock
    EventService mockEventService;

    MarvelAndroid mMarvelAndroid;

    private EventEndpoint mEventEndpoint;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        MarvelAndroid.initialize(RuntimeEnvironment.application, PRIVATE_KEY, PUBLIC_KEY, 5 * 1024 * 1024);
        mMarvelAndroid = MarvelAndroid.getInstance();

        mEventEndpoint = new MockEventEndpoint(mockEventService);
    }

    @Test
    public void testGetEventServiceCallbackMethodCalled() throws Exception {
        mEventEndpoint.getEvent(EVENT_ID, null);

        Mockito.verify(mockEventService).getEventForId(EVENT_ID, Long.toString(TIMESTAMP), PUBLIC_KEY, HASH_SIG, null);
    }

    @Test
    public void testGetEventServiceObservableMethodCalled() throws Exception {
        mEventEndpoint.getEvent(EVENT_ID);

        Mockito.verify(mockEventService).getEventForId(EVENT_ID, Long.toString(TIMESTAMP), PUBLIC_KEY, HASH_SIG);
    }

    @Test
    public void testGetEventsServiceCallbackMethodCalled() throws Exception {
        EventQueryParams queryParams = createQueryParams();
        mEventEndpoint.getEvents(queryParams, null);

        Mockito.verify(mockEventService).getEvents(
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                null);
    }

    @Test
    public void testGetEventsServiceObservableMethodCalled() throws Exception {
        EventQueryParams queryParams = createQueryParams();
        mEventEndpoint.getEvents(queryParams);

        Mockito.verify(mockEventService).getEvents(
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    @Test
    public void testGetEventsForCharacterIdServiceCallbackMethodCalled() throws Exception {
        EventQueryParams queryParams = createQueryParams();
        mEventEndpoint.getEventsForCharacterId(OTHER_ID, queryParams, null);

        Mockito.verify(mockEventService).getEventsForCharacterId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                null);
    }

    @Test
    public void testGetEventsForCharacterIdServiceObservableMethodCalled() throws Exception {
        EventQueryParams queryParams = createQueryParams();
        mEventEndpoint.getEventsForCharacterId(OTHER_ID, queryParams);

        Mockito.verify(mockEventService).getEventsForCharacterId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    @Test
    public void testGetEventsForComicIdServiceCallbackMethodCalled() throws Exception {
        EventQueryParams queryParams = createQueryParams();
        mEventEndpoint.getEventsForComicId(OTHER_ID, queryParams, null);

        Mockito.verify(mockEventService).getEventsForComicId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                null);
    }

    @Test
    public void testGetEventsForComicIdServiceObservableMethodCalled() throws Exception {
        EventQueryParams queryParams = createQueryParams();
        mEventEndpoint.getEventsForComicId(OTHER_ID, queryParams);

        Mockito.verify(mockEventService).getEventsForComicId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    @Test
    public void testGetEventsForCreatorIdServiceCallbackMethodCalled() throws Exception {
        EventQueryParams queryParams = createQueryParams();
        mEventEndpoint.getEventsForCreatorId(OTHER_ID, queryParams, null);

        Mockito.verify(mockEventService).getEventsForCreatorId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getCharacters()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                null);
    }

    @Test
    public void testGetEventsForCreatorIdServiceObservableMethodCalled() throws Exception {
        EventQueryParams queryParams = createQueryParams();
        mEventEndpoint.getEventsForCreatorId(OTHER_ID, queryParams);

        Mockito.verify(mockEventService).getEventsForCreatorId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getCharacters()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    @Test
    public void testGetEventsForSeriesIdServiceCallbackMethodCalled() throws Exception {
        EventQueryParams queryParams = createQueryParams();
        mEventEndpoint.getEventsForSeriesId(OTHER_ID, queryParams, null);

        Mockito.verify(mockEventService).getEventsForSeriesId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                null);
    }

    @Test
    public void testGetEventsForSeriesIdServiceObservableMethodCalled() throws Exception {
        EventQueryParams queryParams = createQueryParams();
        mEventEndpoint.getEventsForSeriesId(OTHER_ID, queryParams);

        Mockito.verify(mockEventService).getEventsForSeriesId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    @Test
    public void testGetEventsForStoryIdServiceCallbackMethodCalled() throws Exception {
        EventQueryParams queryParams = createQueryParams();
        mEventEndpoint.getEventsForStoryId(OTHER_ID, queryParams, null);

        Mockito.verify(mockEventService).getEventsForStoryId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getComics()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                null);
    }

    @Test
    public void testGetEventsForStoryIdServiceObservableMethodCalled() throws Exception {
        EventQueryParams queryParams = createQueryParams();
        mEventEndpoint.getEventsForStoryId(OTHER_ID, queryParams);

        Mockito.verify(mockEventService).getEventsForStoryId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getComics()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    @NonNull
    private EventQueryParams createQueryParams() {
        EventQueryParams queryParams = new EventQueryParams();

        queryParams.setName("Secret Wars");
        queryParams.setNameStartsWith("Se");
        queryParams.setModifiedSince(new Date(System.currentTimeMillis()));

        queryParams.setCreators(Arrays.asList(1, 2, 3));
        queryParams.setCharacters(Arrays.asList(4, 5));
        queryParams.setSeries(Arrays.asList(6));
        queryParams.setComics(Arrays.asList(7, 8, 9, 10));
        queryParams.setStories(Arrays.asList(11, 12));

        queryParams.setOrderBy(EventQueryParams.OrderBy.Default);

        queryParams.setLimit(25);
        queryParams.setOffset(0);

        return queryParams;
    }

    private String getJoinedList(List<?> list) {
        return BaseEndpoint.getCommaSeparatedList(list);
    }

    private class MockEventEndpoint extends EventEndpoint {
        public MockEventEndpoint(@NonNull EventService creatorService) {
            super(creatorService, PUBLIC_KEY, PRIVATE_KEY);
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
