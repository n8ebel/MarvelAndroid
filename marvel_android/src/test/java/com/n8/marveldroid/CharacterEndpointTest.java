package com.n8.marveldroid;

import android.support.annotation.NonNull;

import com.n8.marveldroid.Endpoints.BaseEndpoint;
import com.n8.marveldroid.Endpoints.CharacterEndpoint;
import com.n8.marveldroid.ModelObjects.Character;
import com.n8.marveldroid.QueryParams.CharacterQueryParams;
import com.n8.marveldroid.RequestServices.RxCharacterService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.List;

import rx.Observable;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@Config(constants = BuildConfig.class, sdk = 21)
@RunWith(RobolectricGradleTestRunner.class)
public class CharacterEndpointTest {

    private static final String PRIVATE_KEY = "private_key";
    private static final String PUBLIC_KEY = "public_key";
    private static final String HASH_SIG = "hash";
    private static final long TIMESTAMP = 123456789;
    private static final int CHARACTER_ID = 1001;
    private static final int OTHER_ID = 2002;


    @Mock
    RxCharacterService mockCharacterService;

    MarvelAndroid mMarvelAndroid;

    private CharacterEndpoint mCharacterEndpoint;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        MarvelAndroid.initialize(RuntimeEnvironment.application, PRIVATE_KEY, PUBLIC_KEY, 5 * 1024 * 1024);
        mMarvelAndroid = MarvelAndroid.getInstance();

        mCharacterEndpoint = new MockCharacterEndpoint(mockCharacterService);
    }

    @Test
    public void testGetCharacterServiceCallbackMethodCalled() throws Exception {
        mCharacterEndpoint.getCharacter(CHARACTER_ID, null);

        Mockito.verify(mockCharacterService).getCharacterForId(CHARACTER_ID, Long.toString(TIMESTAMP), PUBLIC_KEY, HASH_SIG, null);
    }

    @Test
    public void testGetCharacterServiceObservableMethodCalled() throws Exception {
        Observable<RequestResponse<Character>> observable = mCharacterEndpoint.getCharacter(CHARACTER_ID);

        Mockito.verify(mockCharacterService).getCharacterForId(CHARACTER_ID, Long.toString(TIMESTAMP), PUBLIC_KEY, HASH_SIG);
    }

    @Test
    public void testGetCharactersServiceCallbackMethodCalled() throws Exception {
        CharacterQueryParams queryParams = createBasicQueryParams();
        mCharacterEndpoint.getCharacters(queryParams, null);

        Mockito.verify(mockCharacterService).getCharacters(
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset(),
                null);
    }

    @Test
    public void testGetCharactersServiceObservableMethodCalled() throws Exception {
        CharacterQueryParams queryParams = createBasicQueryParams();
        Observable<RequestResponse<Character>> observable = mCharacterEndpoint.getCharacters(queryParams);

        Mockito.verify(mockCharacterService).getCharacters(
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getStories()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    @Test
    public void testGetComicsWithIdServiceCallbackMethodCalled() throws Exception {
        CharacterQueryParams queryParams = createBasicQueryParams();
        mCharacterEndpoint.getCharactersForComicId(OTHER_ID, queryParams, null);

        Mockito.verify(mockCharacterService).getCharactersForComicId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getName(),
                queryParams.getNameStartsWith(),
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
    public void testGetComicsWithIdServiceObservableMethodCalled() throws Exception {
        CharacterQueryParams queryParams = createBasicQueryParams();
        Observable<RequestResponse<Character>> observable = mCharacterEndpoint.getCharactersForComicId(OTHER_ID, queryParams);

        Mockito.verify(mockCharacterService).getCharactersForComicId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    @Test
    public void testGetCharactersEventIdServiceCallbackMethodCalled() throws Exception {
        CharacterQueryParams queryParams = createBasicQueryParams();
        mCharacterEndpoint.getCharactersForEventId(OTHER_ID, queryParams, null);

        Mockito.verify(mockCharacterService).getCharactersForEventId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getName(),
                queryParams.getNameStartsWith(),
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
    public void testGetCharactersEventIdServiceObservableMethodCalled() throws Exception {
        CharacterQueryParams queryParams = createBasicQueryParams();
        Observable<RequestResponse<Character>> observable = mCharacterEndpoint.getCharactersForEventId(OTHER_ID, queryParams);

        Mockito.verify(mockCharacterService).getCharactersForEventId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    @Test
    public void testGetCharactersSeriesIdServiceCallbackMethodCalled() throws Exception {
        CharacterQueryParams queryParams = createBasicQueryParams();
        mCharacterEndpoint.getCharactersForSeriesId(OTHER_ID, queryParams, null);

        Mockito.verify(mockCharacterService).getCharactersForSeriesId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getName(),
                queryParams.getNameStartsWith(),
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
    public void testGetCharactersSeriesIdServiceObservableMethodCalled() throws Exception {
        CharacterQueryParams queryParams = createBasicQueryParams();
        Observable<RequestResponse<Character>> observable = mCharacterEndpoint.getCharactersForSeriesId(OTHER_ID, queryParams);

        Mockito.verify(mockCharacterService).getCharactersForSeriesId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getEvents()),
                getJoinedList(queryParams.getStories()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    @Test
    public void testGetCharactersStoryIdServiceCallbackMethodCalled() throws Exception {
        CharacterQueryParams queryParams = createBasicQueryParams();
        mCharacterEndpoint.getCharactersForStoryId(OTHER_ID, queryParams, null);

        Mockito.verify(mockCharacterService).getCharactersForStoryId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getName(),
                queryParams.getNameStartsWith(),
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
    public void testGetCharactersStoryIdServiceObservableMethodCalled() throws Exception {
        CharacterQueryParams queryParams = createBasicQueryParams();
        Observable<RequestResponse<Character>> observable = mCharacterEndpoint.getCharactersForStoryId(OTHER_ID, queryParams);

        Mockito.verify(mockCharacterService).getCharactersForStoryId(
                OTHER_ID,
                Long.toString(TIMESTAMP),
                PUBLIC_KEY,
                HASH_SIG,
                queryParams.getName(),
                queryParams.getNameStartsWith(),
                queryParams.getModifiedSince(),
                getJoinedList(queryParams.getComics()),
                getJoinedList(queryParams.getSeries()),
                getJoinedList(queryParams.getEvents()),
                queryParams.getOrderBy().getValue(),
                queryParams.getLimit(),
                queryParams.getOffset());
    }

    @NonNull
    private CharacterQueryParams createBasicQueryParams() {
        return new CharacterQueryParams();
    }

    private String getJoinedList(List<?> list) {
        return BaseEndpoint.getCommaSeparatedList(list);
    }

    private class MockCharacterEndpoint extends CharacterEndpoint {
        public MockCharacterEndpoint(@NonNull RxCharacterService characterService) {
            super(characterService, PUBLIC_KEY, PRIVATE_KEY);
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
