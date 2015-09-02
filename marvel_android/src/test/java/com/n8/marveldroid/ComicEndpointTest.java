package com.n8.marveldroid;

import android.support.annotation.NonNull;

import com.n8.marveldroid.Endpoints.BaseEndpoint;
import com.n8.marveldroid.Endpoints.ComicEndpoint;
import com.n8.marveldroid.QueryParams.ComicQueryParams;
import com.n8.marveldroid.RequestServices.ComicService;

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
public class ComicEndpointTest {

    private static final String PRIVATE_KEY = "private_key";
    private static final String PUBLIC_KEY = "public_key";
    private static final String HASH_SIG = "hash";
    private static final long TIMESTAMP = 123456789;
    private static final int COMIC_ID = 1001;
    private static final int OTHER_ID = 2002;


    @Mock
    ComicService mockComicService;

    MarvelAndroid mMarvelAndroid;

    private ComicEndpoint mComicEndpoint;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        MarvelAndroid.initialize(RuntimeEnvironment.application, PRIVATE_KEY, PUBLIC_KEY, 5 * 1024 * 1024);
        mMarvelAndroid = MarvelAndroid.getInstance();

        mComicEndpoint = new MockComicEndpoint(mockComicService);
    }

    @Test
    public void testGetComicServiceCallbackMethodCalled() throws Exception {
        mComicEndpoint.getComic(COMIC_ID, null);

        Mockito.verify(mockComicService).getComicForId(COMIC_ID, Long.toString(TIMESTAMP), PUBLIC_KEY, HASH_SIG, null);
    }

    @Test
    public void testGetComicServiceObservableMethodCalled() throws Exception {
        mComicEndpoint.getComic(COMIC_ID);

        Mockito.verify(mockComicService).getComicForId(COMIC_ID, Long.toString(TIMESTAMP), PUBLIC_KEY, HASH_SIG);
    }

    @Test
    public void testGetComicsServiceCallbackMethodCalled() throws Exception {
        ComicQueryParams queryParams = createQueryParams();
        mComicEndpoint.getComics(queryParams, null);

        Mockito.verify(mockComicService).getComics(
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getFormat().getValue(),
                queryParams.getFormatType().getValue(),
                queryParams.isNoVariants(),
                queryParams.getDateDescriptor().getValue(),
                queryParams.getDateRange(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getIssueNumber(),
                queryParams.getDiamondCode(),
                queryParams.getDigitalId(),
                queryParams.getUpc(),
                queryParams.getIsbn(),
                queryParams.getEan(),
                queryParams.getIssn(),
                queryParams.isHasDigitalIssue(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getSharedAppearances()),
                getJoinedList(queryParams.getCollaborators()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                null);
    }

    @Test
    public void testGetComicsServiceObservableMethodCalled() throws Exception {
        ComicQueryParams queryParams = createQueryParams();
        mComicEndpoint.getComics(queryParams);

        Mockito.verify(mockComicService).getComics(
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getFormat().getValue(),
                queryParams.getFormatType().getValue(),
                queryParams.isNoVariants(),
                queryParams.getDateDescriptor().getValue(),
                queryParams.getDateRange(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getIssueNumber(),
                queryParams.getDiamondCode(),
                queryParams.getDigitalId(),
                queryParams.getUpc(),
                queryParams.getIsbn(),
                queryParams.getEan(),
                queryParams.getIssn(),
                queryParams.isHasDigitalIssue(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getSharedAppearances()),
                getJoinedList(queryParams.getCollaborators()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    @Test
    public void testGetComicsForCharacterIdServiceCallbackMethodCalled() throws Exception {
        ComicQueryParams queryParams = createQueryParams();
        mComicEndpoint.getComicsForCharacterId(OTHER_ID, queryParams, null);

        Mockito.verify(mockComicService).getComicsForCharacterId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getFormat().getValue(),
                queryParams.getFormatType().getValue(),
                queryParams.isNoVariants(),
                queryParams.getDateDescriptor().getValue(),
                queryParams.getDateRange(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getIssueNumber(),
                queryParams.getDiamondCode(),
                queryParams.getDigitalId(),
                queryParams.getUpc(),
                queryParams.getIsbn(),
                queryParams.getEan(),
                queryParams.getIssn(),
                queryParams.isHasDigitalIssue(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getSharedAppearances()),
                getJoinedList(queryParams.getCollaborators()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                null);
    }

    @Test
    public void testGetComicsForCharacterIdServiceObservableMethodCalled() throws Exception {
        ComicQueryParams queryParams = createQueryParams();
        mComicEndpoint.getComicsForCharacterId(OTHER_ID, queryParams);

        Mockito.verify(mockComicService).getComicsForCharacterId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getFormat().getValue(),
                queryParams.getFormatType().getValue(),
                queryParams.isNoVariants(),
                queryParams.getDateDescriptor().getValue(),
                queryParams.getDateRange(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getIssueNumber(),
                queryParams.getDiamondCode(),
                queryParams.getDigitalId(),
                queryParams.getUpc(),
                queryParams.getIsbn(),
                queryParams.getEan(),
                queryParams.getIssn(),
                queryParams.isHasDigitalIssue(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getSharedAppearances()),
                getJoinedList(queryParams.getCollaborators()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    @Test
    public void testGetComicsForCreatorIdServiceCallbackMethodCalled() throws Exception {
        ComicQueryParams queryParams = createQueryParams();
        mComicEndpoint.getComicsForCreatorId(OTHER_ID, queryParams, null);

        Mockito.verify(mockComicService).getComicsForCreatorId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getFormat().getValue(),
                queryParams.getFormatType().getValue(),
                queryParams.isNoVariants(),
                queryParams.getDateDescriptor().getValue(),
                queryParams.getDateRange(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getIssueNumber(),
                queryParams.getDiamondCode(),
                queryParams.getDigitalId(),
                queryParams.getUpc(),
                queryParams.getIsbn(),
                queryParams.getEan(),
                queryParams.getIssn(),
                queryParams.isHasDigitalIssue(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getCharacters()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getSharedAppearances()),
                getJoinedList(queryParams.getCollaborators()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                null);
    }

    @Test
    public void testGetComicsForCreatorIdServiceObservableMethodCalled() throws Exception {
        ComicQueryParams queryParams = createQueryParams();
        mComicEndpoint.getComicsForCreatorId(OTHER_ID, queryParams);

        Mockito.verify(mockComicService).getComicsForCreatorId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getFormat().getValue(),
                queryParams.getFormatType().getValue(),
                queryParams.isNoVariants(),
                queryParams.getDateDescriptor().getValue(),
                queryParams.getDateRange(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getIssueNumber(),
                queryParams.getDiamondCode(),
                queryParams.getDigitalId(),
                queryParams.getUpc(),
                queryParams.getIsbn(),
                queryParams.getEan(),
                queryParams.getIssn(),
                queryParams.isHasDigitalIssue(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getCharacters()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getSharedAppearances()),
                getJoinedList(queryParams.getCollaborators()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    @Test
    public void testGetComicsForEventIdServiceCallbackMethodCalled() throws Exception {
        ComicQueryParams queryParams = createQueryParams();
        mComicEndpoint.getComicsForEventId(OTHER_ID, queryParams, null);

        Mockito.verify(mockComicService).getComicsForEventId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getFormat().getValue(),
                queryParams.getFormatType().getValue(),
                queryParams.isNoVariants(),
                queryParams.getDateDescriptor().getValue(),
                queryParams.getDateRange(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getIssueNumber(),
                queryParams.getDiamondCode(),
                queryParams.getDigitalId(),
                queryParams.getUpc(),
                queryParams.getIsbn(),
                queryParams.getEan(),
                queryParams.getIssn(),
                queryParams.isHasDigitalIssue(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getSharedAppearances()),
                getJoinedList(queryParams.getCollaborators()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                null);
    }

    @Test
    public void testGetComicsForEventIdServiceObservableMethodCalled() throws Exception {
        ComicQueryParams queryParams = createQueryParams();
        mComicEndpoint.getComicsForEventId(OTHER_ID, queryParams);

        Mockito.verify(mockComicService).getComicsForEventId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getFormat().getValue(),
                queryParams.getFormatType().getValue(),
                queryParams.isNoVariants(),
                queryParams.getDateDescriptor().getValue(),
                queryParams.getDateRange(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getIssueNumber(),
                queryParams.getDiamondCode(),
                queryParams.getDigitalId(),
                queryParams.getUpc(),
                queryParams.getIsbn(),
                queryParams.getEan(),
                queryParams.getIssn(),
                queryParams.isHasDigitalIssue(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getSharedAppearances()),
                getJoinedList(queryParams.getCollaborators()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    @Test
    public void testGetComicsForSeriesIdServiceCallbackMethodCalled() throws Exception {
        ComicQueryParams queryParams = createQueryParams();
        mComicEndpoint.getComicsForSeriesId(OTHER_ID, queryParams, null);

        Mockito.verify(mockComicService).getComicsForSeriesId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getFormat().getValue(),
                queryParams.getFormatType().getValue(),
                queryParams.isNoVariants(),
                queryParams.getDateDescriptor().getValue(),
                queryParams.getDateRange(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getIssueNumber(),
                queryParams.getDiamondCode(),
                queryParams.getDigitalId(),
                queryParams.getUpc(),
                queryParams.getIsbn(),
                queryParams.getEan(),
                queryParams.getIssn(),
                queryParams.isHasDigitalIssue(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getSharedAppearances()),
                getJoinedList(queryParams.getCollaborators()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                null);
    }

    @Test
    public void testGetComicsForSeriesIdServiceObservableMethodCalled() throws Exception {
        ComicQueryParams queryParams = createQueryParams();
        mComicEndpoint.getComicsForSeriesId(OTHER_ID, queryParams);

        Mockito.verify(mockComicService).getComicsForSeriesId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getFormat().getValue(),
                queryParams.getFormatType().getValue(),
                queryParams.isNoVariants(),
                queryParams.getDateDescriptor().getValue(),
                queryParams.getDateRange(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getIssueNumber(),
                queryParams.getDiamondCode(),
                queryParams.getDigitalId(),
                queryParams.getUpc(),
                queryParams.getIsbn(),
                queryParams.getEan(),
                queryParams.getIssn(),
                queryParams.isHasDigitalIssue(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getSharedAppearances()),
                getJoinedList(queryParams.getCollaborators()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    @Test
    public void testGetComicsForStoryIdServiceCallbackMethodCalled() throws Exception {
        ComicQueryParams queryParams = createQueryParams();
        mComicEndpoint.getComicsForStoryId(OTHER_ID, queryParams, null);

        Mockito.verify(mockComicService).getComicsForStoryId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getFormat().getValue(),
                queryParams.getFormatType().getValue(),
                queryParams.isNoVariants(),
                queryParams.getDateDescriptor().getValue(),
                queryParams.getDateRange(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getIssueNumber(),
                queryParams.getDiamondCode(),
                queryParams.getDigitalId(),
                queryParams.getUpc(),
                queryParams.getIsbn(),
                queryParams.getEan(),
                queryParams.getIssn(),
                queryParams.isHasDigitalIssue(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getSharedAppearances()),
                getJoinedList(queryParams.getCollaborators()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                null);
    }

    @Test
    public void testGetComicsForStoryIdServiceObservableMethodCalled() throws Exception {
        ComicQueryParams queryParams = createQueryParams();
        mComicEndpoint.getComicsForStoryId(OTHER_ID, queryParams);

        Mockito.verify(mockComicService).getComicsForStoryId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getFormat().getValue(),
                queryParams.getFormatType().getValue(),
                queryParams.isNoVariants(),
                queryParams.getDateDescriptor().getValue(),
                queryParams.getDateRange(),
                queryParams.getTitle(),
                queryParams.getTitleStartsWith(),
                queryParams.getStartYear(),
                queryParams.getIssueNumber(),
                queryParams.getDiamondCode(),
                queryParams.getDigitalId(),
                queryParams.getUpc(),
                queryParams.getIsbn(),
                queryParams.getEan(),
                queryParams.getIssn(),
                queryParams.isHasDigitalIssue(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getCreators()),
                getJoinedList(queryParams.getCharacters()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getSharedAppearances()),
                getJoinedList(queryParams.getCollaborators()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }



    @NonNull
    private ComicQueryParams createQueryParams() {
        ComicQueryParams queryParams = new ComicQueryParams();
        queryParams.setFormat(ComicQueryParams.Format.Comic);
        queryParams.setFormatType(ComicQueryParams.FormatType.Collection);
        queryParams.setNoVariants(true);
        queryParams.setDateDescriptor(ComicQueryParams.DateDescriptor.LastWeek);
        queryParams.setDateRange("date range");
        queryParams.setTitle("title");
        queryParams.setTitleStartsWith("titleStartsWith");
        queryParams.setStartYear(-1);
        queryParams.setIssueNumber(-2);
        queryParams.setDiamondCode("diamondCode");
        queryParams.setDigitalId(-3);
        queryParams.setUpc("upc");
        queryParams.setIsbn("isbn");
        queryParams.setEan("ean");
        queryParams.setIssn("issn");
        queryParams.setHasDigitalIssue(true);
        queryParams.setModifiedSince(new Date(System.currentTimeMillis()));
        queryParams.setCreators(Arrays.asList(1, 2, 3));
        queryParams.setCharacters(Arrays.asList(4, 5, 6));
        queryParams.setEvents(Arrays.asList(7, 8));
        queryParams.setStories(Arrays.asList(9, 10));
        queryParams.setSeries(Arrays.asList(11, 12));
        queryParams.setCollaborators(Arrays.asList(13, 14, 15));
        queryParams.setSharedAppearances(Arrays.asList(16));
        queryParams.setOffset(1);
        queryParams.setLimit(20);

        return queryParams;
    }

    private String getJoinedList(List<?> list) {
        return BaseEndpoint.getJoinedList(list);
    }

    private class MockComicEndpoint extends ComicEndpoint {
        public MockComicEndpoint(@NonNull ComicService comicService) {
            super(comicService);
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
