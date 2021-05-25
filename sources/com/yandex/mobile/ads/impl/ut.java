package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import org.xmlpull.v1.XmlPullParser;
public final class ut {
    @NonNull
    public static tv a(@NonNull XmlPullParser xmlPullParser) {
        return new tv(a(xmlPullParser, "allowMultipleAds"), a(xmlPullParser, "followAdditionalWrappers"));
    }

    private static boolean a(@NonNull XmlPullParser xmlPullParser, @NonNull String str) {
        return Boolean.parseBoolean(xmlPullParser.getAttributeValue(null, str));
    }
}
