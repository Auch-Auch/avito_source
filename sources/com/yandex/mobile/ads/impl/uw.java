package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.yandex.mobile.ads.video.models.vmap.AdBreak;
import com.yandex.mobile.ads.video.models.vmap.AdSource;
import com.yandex.mobile.ads.video.models.vmap.TimeOffset;
import com.yandex.mobile.ads.video.models.vmap.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
public final class uw {
    @NonNull
    private final uv a;
    @NonNull
    private final ux b;
    @NonNull
    private final uz c = new uz();
    @NonNull
    private final vb d;
    @NonNull
    private final vc e = new vc();
    @NonNull
    private final vd f = new vd();
    @NonNull
    private final vf g = new vf();

    public uw(@NonNull uv uvVar, @NonNull vb vbVar) {
        this.a = uvVar;
        this.d = vbVar;
        this.b = new ux(uvVar);
    }

    @Nullable
    public static AdBreak a(@NonNull XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        uv.a(xmlPullParser, "AdBreak");
        String attributeValue = xmlPullParser.getAttributeValue(null, "breakId");
        Long a3 = vc.a(xmlPullParser);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "timeOffset");
        TimeOffset a4 = !TextUtils.isEmpty(attributeValue2) ? d.a(attributeValue2) : null;
        List<String> a5 = uz.a(xmlPullParser);
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        AdSource adSource = null;
        while (uv.b(xmlPullParser)) {
            if (uv.a(xmlPullParser)) {
                String name = xmlPullParser.getName();
                if ("AdSource".equals(name)) {
                    adSource = ux.a(xmlPullParser);
                } else if ("Extensions".equals(name)) {
                    arrayList.addAll(vb.a(xmlPullParser));
                } else if ("TrackingEvents".equals(name)) {
                    hashMap.putAll(vf.a(xmlPullParser));
                } else {
                    uv.d(xmlPullParser);
                }
            }
        }
        if (adSource == null || a4 == null || a5.isEmpty()) {
            return null;
        }
        return d.a(adSource, attributeValue, a3, a4, a5, arrayList, hashMap);
    }
}
