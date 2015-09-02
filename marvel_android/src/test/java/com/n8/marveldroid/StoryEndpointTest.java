package com.n8.marveldroid;

import android.support.annotation.NonNull;

import com.n8.marveldroid.Endpoints.BaseEndpoint;
import com.n8.marveldroid.Endpoints.StoryEndpoint;
import com.n8.marveldroid.QueryParams.StoryQueryParams;
import com.n8.marveldroid.RequestServices.StoryService;

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
public class StoryEndpointTest {

    private static final String PRIVATE_KEY = "private_key";
    private static final String PUBLIC_KEY = "public_key";
    private static final String HASH_SIG = "hash";
    private static final long TIMESTAMP = 123456789;
    private static final int STORY_ID = 1001;
    private static final int OTHER_ID = 2002;


    @Mock StoryService mockStoryService;

    MarvelAndroid mMarvelAndroid;

    private StoryEndpoint mStoryEndpoint;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        MarvelAndroid.initialize(RuntimeEnvironment.application, PRIVATE_KEY, PUBLIC_KEY, 5 * 1024 * 1024);
        mMarvelAndroid = MarvelAndroid.getInstance();

        mStoryEndpoint = new MockStoryEndpoint(mockStoryService);
    }

    @Test
    public void testGetStoryForIdCallbackServiceMethod() throws Exception {
        mStoryEndpoint.getStoryForId(STORY_ID, null);

        Mockito.verify(mockStoryService).getStoryForId(STORY_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                null);
    }

    @Test
    public void testGetStoryForIdObservableServiceMethod() throws Exception {
        mStoryEndpoint.getStoryForId(STORY_ID);

        Mockito.verify(mockStoryService).getStoryForId(STORY_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG);
    }

    @Test
    public void testGetStoriesCallbackServiceMethod() throws Exception {
        StoryQueryParams queryParams = createQueryParams();
        mStoryEndpoint.getStories(queryParams, null);

        Mockito.verify(mockStoryService).getStories(
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                null);
    }

    @Test
    public void testGetStoriesObservableServiceMethod() throws Exception {
        StoryQueryParams queryParams = createQueryParams();
        mStoryEndpoint.getStories(queryParams);

        Mockito.verify(mockStoryService).getStories(
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    @Test
    public void testGetStoriesForCharacterIdCallbackServiceMethod() throws Exception {
        StoryQueryParams queryParams = createQueryParams();
        mStoryEndpoint.getStoriesForCharacterId(OTHER_ID, queryParams, null);

        Mockito.verify(mockStoryService).getStoriesForCharacterId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getCreators()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                null);
    }

    @Test
    public void testGetStoriesForCharacterIdObservableServiceMethod() throws Exception {
        StoryQueryParams queryParams = createQueryParams();
        mStoryEndpoint.getStoriesForCharacterId(OTHER_ID, queryParams);

        Mockito.verify(mockStoryService).getStoriesForCharacterId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getCreators()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    @Test
    public void testGetStoriesForComicIdCallbackServiceMethod() throws Exception {
        StoryQueryParams queryParams = createQueryParams();
        mStoryEndpoint.getStoriesForComicId(OTHER_ID, queryParams, null);

        Mockito.verify(mockStoryService).getStoriesForComicId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                null);
    }

    @Test
    public void testGetStoriesForComicIdObservableServiceMethod() throws Exception {
        StoryQueryParams queryParams = createQueryParams();
        mStoryEndpoint.getStoriesForComicId(OTHER_ID, queryParams);

        Mockito.verify(mockStoryService).getStoriesForComicId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    @Test
    public void testGetStoriesForCreatorIdCallbackServiceMethod() throws Exception {
        StoryQueryParams queryParams = createQueryParams();
        mStoryEndpoint.getStoriesForCreatorId(OTHER_ID, queryParams, null);

        Mockito.verify(mockStoryService).getStoriesForCreatorId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getCharacters()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                null);
    }

    @Test
    public void testGetStoriesForCreatorIdObservableServiceMethod() throws Exception {
        StoryQueryParams queryParams = createQueryParams();
        mStoryEndpoint.getStoriesForCreatorId(OTHER_ID, queryParams);

        Mockito.verify(mockStoryService).getStoriesForCreatorId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getCharacters()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    @Test
    public void testGetStoriesForEventIdCallbackServiceMethod() throws Exception {
        StoryQueryParams queryParams = createQueryParams();
        mStoryEndpoint.getStoriesForEventId(OTHER_ID, queryParams, null);

        Mockito.verify(mockStoryService).getStoriesForEventId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                null);
    }

    @Test
    public void testGetStoriesForEventIdObservableServiceMethod() throws Exception {
        StoryQueryParams queryParams = createQueryParams();
        mStoryEndpoint.getStoriesForEventId(OTHER_ID, queryParams);

        Mockito.verify(mockStoryService).getStoriesForEventId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    @Test
    public void testGetStoriesForSeriesIdCallbackServiceMethod() throws Exception {
        StoryQueryParams queryParams = createQueryParams();
        mStoryEndpoint.getStoriesForSeriesId(OTHER_ID, queryParams, null);

        Mockito.verify(mockStoryService).getStoriesForSeriesId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                null);
    }

    @Test
    public void testGetStoriesForSeriesIdObservableServiceMethod() throws Exception {
        StoryQueryParams queryParams = createQueryParams();
        mStoryEndpoint.getStoriesForSeriesId(OTHER_ID, queryParams);

        Mockito.verify(mockStoryService).getStoriesForSeriesId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    @NonNull
    private StoryQueryParams createQueryParams() {
        StoryQueryParams queryParams = new StoryQueryParams();

        queryParams.setModifiedSince(new Date(System.currentTimeMillis()));

        queryParams.setCreators(Arrays.asList(1, 2, 3));
        queryParams.setCharacters(Arrays.asList(4, 5));
        queryParams.setEvents(Arrays.asList(6));
        queryParams.setComics(Arrays.asList(7, 8, 9, 10));
        queryParams.setSeries(Arrays.asList(11, 12));

        queryParams.setOrderBy(StoryQueryParams.OrderBy.Default);

        queryParams.setLimit(25);
        queryParams.setOffset(0);

        return queryParams;
    }

    private String getJoinedList(List<?> list) {
        return BaseEndpoint.getJoinedList(list);
    }

    private class MockStoryEndpoint extends StoryEndpoint {
        public MockStoryEndpoint(@NonNull StoryService storyService) {
            super(storyService);
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
