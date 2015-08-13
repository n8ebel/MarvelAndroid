package com.n8.marveldroid;

import com.n8.marveldroid.EntityModelObjects.Entity;

import java.util.List;

public interface ResponseCallback<T extends Entity> {
    void onRequestComplete(List<T> responseEntities, Throwable error);
}
