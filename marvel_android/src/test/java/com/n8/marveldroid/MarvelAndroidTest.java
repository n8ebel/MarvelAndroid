package com.n8.marveldroid;

import android.app.Application;
import android.content.Context;
import android.test.ApplicationTestCase;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.base.MockitoAssertionError;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.lang.reflect.Field;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@Config(constants = BuildConfig.class, sdk = 21)
@RunWith(RobolectricGradleTestRunner.class)
public class MarvelAndroidTest {

    public static final String PRIVATE_KEY = "private_key";
    public static final String PUBLIC_KEY = "public_key";

    @Mock
    Context mFakeContext;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInitialize_SuccessCase() throws Exception {
        MarvelAndroid.initialize(RuntimeEnvironment.application, PRIVATE_KEY, PUBLIC_KEY, 5 * 1024 * 1024);
        MarvelAndroid marvelAndroid = MarvelAndroid.getInstance();

        Field privateKeyField = marvelAndroid.getClass().getDeclaredField("sPrivateKey");
        privateKeyField.setAccessible(true);

        Field publicKeyField = marvelAndroid.getClass().getDeclaredField("sPublicKey");
        publicKeyField.setAccessible(true);

        String privateKey = (String) privateKeyField.get(marvelAndroid);
        String publicKey = (String) publicKeyField.get(marvelAndroid);

        assertTrue(privateKey.equals(PRIVATE_KEY));
        assertTrue(publicKey.equals(PUBLIC_KEY));
    }

    @Test
    public void testInitialize_NullContextCase() throws Exception {
        MarvelAndroid marvelAndroid = null;
        try {
            MarvelAndroid.initialize(null, PRIVATE_KEY, PUBLIC_KEY, 5 * 1024 * 1024);
            marvelAndroid = MarvelAndroid.getInstance();
        } catch (IllegalArgumentException e) {

        }

        assertNull(marvelAndroid);
    }

    @Test
    public void testInitialize_NullPrivateKeyCase() throws Exception {
        MarvelAndroid marvelAndroid = null;
        try {
            MarvelAndroid.initialize(RuntimeEnvironment.application, null, PUBLIC_KEY, 5 * 1024 * 1024);
            marvelAndroid = MarvelAndroid.getInstance();
        } catch (IllegalArgumentException e) {

        }

        assertNull(marvelAndroid);
    }

    @Test
    public void testInitialize_EmptyPrivateKeyCase() throws Exception {
        MarvelAndroid marvelAndroid = null;
        try {
            MarvelAndroid.initialize(RuntimeEnvironment.application, "", PUBLIC_KEY, 5 * 1024 * 1024);
            marvelAndroid = MarvelAndroid.getInstance();
        } catch (IllegalArgumentException e) {

        }

        assertNull(marvelAndroid);
    }

    @Test
    public void testInitialize_NullPublicKeyCase() throws Exception {
        MarvelAndroid marvelAndroid = null;
        try {
            MarvelAndroid.initialize(RuntimeEnvironment.application, PRIVATE_KEY, null, 5 * 1024 * 1024);
            marvelAndroid = MarvelAndroid.getInstance();
        } catch (IllegalArgumentException e) {

        }

        assertNull(marvelAndroid);
    }

    @Test
    public void testInitialize_EmptyPublicKeyCase() throws Exception {
        MarvelAndroid marvelAndroid = null;
        try {
            MarvelAndroid.initialize(RuntimeEnvironment.application, PRIVATE_KEY, "", 5 * 1024 * 1024);
            marvelAndroid = MarvelAndroid.getInstance();
        } catch (IllegalArgumentException e) {

        }

        assertNull(marvelAndroid);
    }
}