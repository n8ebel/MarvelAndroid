package com.n8.marveldroid.Endpoints;

import com.google.common.base.Joiner;
import com.n8.marveldroid.Request;

import java.util.List;

public class BaseEndpoint {

    public static String getJoinedList(List<?> list) {
        if (list == null) {
            return null;
        }

        Joiner joiner = Joiner.on(',');
        return joiner.join(list);
    }

    protected Request mRequest;

    public BaseEndpoint() {
        mRequest = Request.newInstance();
    }

    protected long getTimestamp() {
        return mRequest.getTimeStamp();
    }

    protected String getHashSignature() {
        return mRequest.getHash();
    }

    protected String getApiKey() {
        return Request.sPublicKey;
    }
}
