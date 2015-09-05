package com.n8.marveldroid_sample;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.widget.TextView;

import com.n8.marveldroid.MarvelAndroid;

public class MainActivity extends AppCompatActivity {

    private TextView mResultTextView;

    private String msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         * You will need a public and private key from http://developer.marvel.com/
         */
        MarvelAndroid.initialize(
                this,
                getString(R.string.private_key),
                getString(R.string.public_key),
                5 * 1024 * 1024);

        ViewPager viewPager = (ViewPager) findViewById(R.id.main_activity_viewPager);
        PagerAdapter adapter = new MarvelousPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.main_activity_tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    private class MarvelousPagerAdapter extends FragmentStatePagerAdapter {

        public MarvelousPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Characters";
                case 1:
                    return "Comic";
                case 2:
                    return "Events";
                default:
                    return null;
            }
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new CharacterFragment();
                case 1:
                    return new ComicFragment();
                case 2:
                    return new EventFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
