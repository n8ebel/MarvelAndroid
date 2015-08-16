package com.n8.marveldroid.Endpoints;

import com.google.common.base.Joiner;

import java.util.List;

public class BaseEndpoint {
    protected String parameterizeList(List<?> list) {
        if (list == null) {
            return null;
        }

        Joiner joiner = Joiner.on(',');
        return joiner.join(list);
    }
}
