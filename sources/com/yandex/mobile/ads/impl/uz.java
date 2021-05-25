package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
public final class uz {
    @NonNull
    public static List<String> a(@NonNull XmlPullParser xmlPullParser) {
        ArrayList arrayList = new ArrayList();
        try {
            String attributeValue = xmlPullParser.getAttributeValue(null, "breakType");
            return !TextUtils.isEmpty(attributeValue) ? Arrays.asList(attributeValue.split(",")) : arrayList;
        } catch (Exception unused) {
            return arrayList;
        }
    }
}
