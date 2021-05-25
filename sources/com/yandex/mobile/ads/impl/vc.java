package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParser;
public final class vc {
    @Nullable
    public static Long a(@NonNull XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "repeatAfter");
        if (!TextUtils.isEmpty(attributeValue)) {
            return a(attributeValue);
        }
        return null;
    }

    @Nullable
    private static Long a(@NonNull String str) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.US);
            return Long.valueOf(simpleDateFormat.parse(str).getTime() - simpleDateFormat.parse("00:00:00").getTime());
        } catch (Exception unused) {
            return null;
        }
    }
}
