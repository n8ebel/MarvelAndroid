package com.n8.marveldroid.Endpoints;

import android.support.annotation.NonNull;

public class ComicEndpoint extends BaseEndpoint {

    private ComicService mComicService;

    public ComicEndpoint(@NonNull ComicService comicService) {
        mCharacterService = characterService;
    }
}
