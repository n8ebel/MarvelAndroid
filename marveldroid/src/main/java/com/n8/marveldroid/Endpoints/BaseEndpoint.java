package com.n8.marveldroid.Endpoints;

import com.google.common.base.Joiner;
import com.n8.marveldroid.RequestSignature;

import java.util.List;

public class BaseEndpoint {

    protected RequestSignature mRequestSignature;

    public BaseEndpoint() {
        mRequestSignature = RequestSignature.create();
    }

    protected long getTimestamp() {
        return mRequestSignature.getTimeStamp();
    }

    protected String getHashSignature() {
        return mRequestSignature.getHashSignature();
    }

    protected String getApiKey() {
        return RequestSignature.sPublicKey;
    }

    protected String getJoinedList(List<?> list) {
        if (list == null) {
            return null;
        }

        Joiner joiner = Joiner.on(',');
        return joiner.join(list);
    }
}
