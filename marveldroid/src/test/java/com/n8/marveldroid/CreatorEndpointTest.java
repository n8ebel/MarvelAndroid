package com.n8.marveldroid;

import android.support.annotation.NonNull;

import com.n8.marveldroid.Endpoints.BaseEndpoint;
import com.n8.marveldroid.Endpoints.ComicEndpoint;
import com.n8.marveldroid.Endpoints.CreatorEndpoint;
import com.n8.marveldroid.QueryParams.ComicQueryParams;
import com.n8.marveldroid.QueryParams.CreatorQueryParams;
import com.n8.marveldroid.RequestServices.ComicService;
import com.n8.marveldroid.RequestServices.CreatorService;

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
public class CreatorEndpointTest {

    private static final String PRIVATE_KEY = "private_key";
    private static final String PUBLIC_KEY = "public_key";
    private static final String HASH_SIG = "hash";
    private static final long TIMESTAMP = 123456789;
    private static final int CREATOR_ID = 1001;
    private static final int OTHER_ID = 2002;


    @Mock
    CreatorService mockCreatorService;

    MarvelAndroid mMarvelAndroid;

    private CreatorEndpoint mCreatorEndpoint;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        MarvelAndroid.initialize(RuntimeEnvironment.application, PRIVATE_KEY, PUBLIC_KEY, 5 * 1024 * 1024);
        mMarvelAndroid = MarvelAndroid.getInstance();

        mCreatorEndpoint = new MockCreatorEndpoint(mockCreatorService);
    }

    @Test
    public void testGetCreatorServiceCallbackMethodCalled() throws Exception {
        mCreatorEndpoint.getCreator(CREATOR_ID, null);

        Mockito.verify(mockCreatorService).getCreatorForId(CREATOR_ID, Long.toString(TIMESTAMP), PUBLIC_KEY, HASH_SIG, null);
    }

    @Test
    public void testGetCreatorServiceObservableMethodCalled() throws Exception {
        mCreatorEndpoint.getCreator(CREATOR_ID);

        Mockito.verify(mockCreatorService).getCreatorForId(CREATOR_ID, Long.toString(TIMESTAMP), PUBLIC_KEY, HASH_SIG);
    }

    @Test
    public void testGetCreatorsServiceCallbackMethodCalled() throws Exception {
        CreatorQueryParams queryParams = createQueryParams();
        mCreatorEndpoint.getCreators(queryParams, null);

        Mockito.verify(mockCreatorService).getCreators(
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
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
                null);
    }

    @Test
    public void testGetCreatorsServiceObservableMethodCalled() throws Exception {
        CreatorQueryParams queryParams = createQueryParams();
        mCreatorEndpoint.getCreators(queryParams);

        Mockito.verify(mockCreatorService).getCreators(
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
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

    @Test
    public void testGetCreatorsForComicIdServiceCallbackMethodCalled() throws Exception {
        CreatorQueryParams queryParams = createQueryParams();
        mCreatorEndpoint.getCreatorsForComicId(OTHER_ID, queryParams, null);

        Mockito.verify(mockCreatorService).getCreatorsForComicId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
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
                null);
    }

    @Test
    public void testGetCreatorsForComicIdServiceObservableMethodCalled() throws Exception {
        CreatorQueryParams queryParams = createQueryParams();
        mCreatorEndpoint.getCreatorsForComicId(OTHER_ID, queryParams);

        Mockito.verify(mockCreatorService).getCreatorsForComicId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
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

    @Test
    public void testGetCreatorsForEventIdServiceCallbackMethodCalled() throws Exception {
        CreatorQueryParams queryParams = createQueryParams();
        mCreatorEndpoint.getCreatorsForEventId(OTHER_ID, queryParams, null);

        Mockito.verify(mockCreatorService).getCreatorsForEventId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
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
                null);
    }

    @Test
    public void testGetCreatorsForEventIdServiceObservableMethodCalled() throws Exception {
        CreatorQueryParams queryParams = createQueryParams();
        mCreatorEndpoint.getCreatorsForEventId(OTHER_ID, queryParams);

        Mockito.verify(mockCreatorService).getCreatorsForEventId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
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

    @Test
    public void testGetCreatorsForSeriesIdServiceCallbackMethodCalled() throws Exception {
        CreatorQueryParams queryParams = createQueryParams();
        mCreatorEndpoint.getCreatorsForSeriesId(OTHER_ID, queryParams, null);

        Mockito.verify(mockCreatorService).getCreatorsForSeriesId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
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
                null);
    }

    @Test
    public void testGetCreatorsForSeriesIdServiceObservableMethodCalled() throws Exception {
        CreatorQueryParams queryParams = createQueryParams();
        mCreatorEndpoint.getCreatorsForSeriesId(OTHER_ID, queryParams);

        Mockito.verify(mockCreatorService).getCreatorsForSeriesId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
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

    @Test
    public void testGetCreatorsForStoryIdServiceCallbackMethodCalled() throws Exception {
        CreatorQueryParams queryParams = createQueryParams();
        mCreatorEndpoint.getCreatorsForStoryId(OTHER_ID, queryParams, null);

        Mockito.verify(mockCreatorService).getCreatorsForStoryId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
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
                null);
    }

    @Test
    public void testGetCreatorsForStoryIdServiceObservableMethodCalled() throws Exception {
        CreatorQueryParams queryParams = createQueryParams();
        mCreatorEndpoint.getCreatorsForStoryId(OTHER_ID, queryParams);

        Mockito.verify(mockCreatorService).getCreatorsForStoryId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
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





    @NonNull
    private CreatorQueryParams createQueryParams() {
        CreatorQueryParams queryParams = new CreatorQueryParams();
        queryParams.setFirstName("Brian");
        queryParams.setLastName("Bendis");
        queryParams.setMiddleName("Michael");
        queryParams.setSuffix("Jr");

        queryParams.setNameStartsWith("B");
        queryParams.setFirstNameStartsWith("Br");
        queryParams.setMiddleNameStartsWith("M");
        queryParams.setLastNameStartsWith("Ben");

        queryParams.setModifiedSince(new Date(System.currentTimeMillis()));
        queryParams.setEvents(Arrays.asList(7, 8));
        queryParams.setStories(Arrays.asList(9, 10));
        queryParams.setSeries(Arrays.asList(11, 12));
        queryParams.setOffset(1);
        queryParams.setLimit(20);

        queryParams.setOrderBy(CreatorQueryParams.OrderBy.FirstNameDescending);

        return queryParams;
    }

    private String getJoinedList(List<?> list) {
        return BaseEndpoint.getJoinedList(list);
    }

    private class MockCreatorEndpoint extends CreatorEndpoint {
        public MockCreatorEndpoint(@NonNull CreatorService creatorService) {
            super(creatorService);
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
