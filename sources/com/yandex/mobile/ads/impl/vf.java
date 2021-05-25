package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.yandex.mobile.ads.video.models.common.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
public final class vf {
    @NonNull
    private final uv a = new uv();
    @NonNull
    private final ve b = new ve();

    @NonNull
    public static Map<String, List<String>> a(@NonNull XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        uv.a(xmlPullParser, "TrackingEvents");
        HashMap hashMap = new HashMap();
        while (uv.b(xmlPullParser)) {
            if (uv.a(xmlPullParser)) {
                if ("Tracking".equals(xmlPullParser.getName())) {
                    uv.a(xmlPullParser, "Tracking");
                    b bVar = null;
                    String attributeValue = xmlPullParser.getAttributeValue(null, "event");
                    String c = uv.c(xmlPullParser);
                    boolean z = !TextUtils.isEmpty(attributeValue);
                    boolean z2 = !TextUtils.isEmpty(c);
                    if (z && z2) {
                        bVar = new b(attributeValue, c);
                    }
                    if (bVar != null) {
                        String a3 = bVar.a();
                        String b2 = bVar.b();
                        if (!hashMap.containsKey(a3)) {
                            hashMap.put(a3, new ArrayList());
                        }
                        ((List) hashMap.get(a3)).add(b2);
                    }
                } else {
                    uv.d(xmlPullParser);
                }
            }
        }
        return hashMap;
    }
}
