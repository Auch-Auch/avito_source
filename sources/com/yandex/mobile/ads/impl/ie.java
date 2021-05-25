package com.yandex.mobile.ads.impl;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
public final class ie {
    public static <T> Collection<T> a(Collection<T> collection) {
        return collection == null ? Collections.emptyList() : collection;
    }

    public static String a(@Nullable List<String> list) {
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            String str = "";
            for (String str2 : list) {
                if (!TextUtils.isEmpty(str2)) {
                    sb.append(str);
                    sb.append(str2);
                    str = "\n";
                }
            }
        }
        return sb.toString();
    }
}
