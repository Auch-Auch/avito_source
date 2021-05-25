package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.yandex.mobile.ads.video.models.vmap.AdSource;
import com.yandex.mobile.ads.video.models.vmap.c;
import com.yandex.mobile.ads.video.models.vmap.d;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
public final class ux {
    @NonNull
    private final uv a;
    @NonNull
    private final uy b;

    public ux(@NonNull uv uvVar) {
        this.a = uvVar;
        this.b = new uy(uvVar);
    }

    @Nullable
    public static AdSource a(@NonNull XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        uv.a(xmlPullParser, "AdSource");
        Boolean b2 = uv.b(xmlPullParser, "allowMultipleAds");
        Boolean b3 = uv.b(xmlPullParser, "followRedirects");
        String attributeValue = xmlPullParser.getAttributeValue(null, "id");
        AdSource adSource = null;
        while (uv.b(xmlPullParser)) {
            if (uv.a(xmlPullParser)) {
                if ("AdTagURI".equals(xmlPullParser.getName())) {
                    uv.a(xmlPullParser, "AdTagURI");
                    String attributeValue2 = xmlPullParser.getAttributeValue(null, "templateType");
                    String c = uv.c(xmlPullParser);
                    c a3 = !TextUtils.isEmpty(c) ? d.a(c, attributeValue2) : null;
                    if (a3 != null) {
                        adSource = d.a(a3, b2, b3, attributeValue);
                    }
                } else {
                    uv.d(xmlPullParser);
                }
            }
        }
        return adSource;
    }
}
