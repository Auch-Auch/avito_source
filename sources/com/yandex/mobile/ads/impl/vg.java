package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Xml;
import com.yandex.mobile.ads.video.models.vmap.AdBreak;
import com.yandex.mobile.ads.video.models.vmap.Vmap;
import com.yandex.mobile.ads.video.models.vmap.a;
import com.yandex.mobile.ads.video.models.vmap.d;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
public final class vg {
    @NonNull
    private final uw a;
    @NonNull
    private final vb b;
    @NonNull
    private final uv c;
    @NonNull
    private final a d = new a();
    @NonNull
    private final vi e = new vi();

    public vg() {
        uv uvVar = new uv();
        this.c = uvVar;
        vb vbVar = new vb(uvVar);
        this.b = vbVar;
        this.a = new uw(uvVar, vbVar);
    }

    @Nullable
    public final Vmap a(@NonNull String str) throws IOException, XmlPullParserException {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        newPullParser.setInput(new StringReader(str));
        newPullParser.nextTag();
        return a(newPullParser);
    }

    @Nullable
    private static Vmap a(@NonNull XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        uv.a(xmlPullParser, "VMAP");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String attributeValue = xmlPullParser.getAttributeValue(null, "version");
        while (uv.b(xmlPullParser)) {
            if (uv.a(xmlPullParser)) {
                String name = xmlPullParser.getName();
                if ("AdBreak".equals(name)) {
                    AdBreak a3 = uw.a(xmlPullParser);
                    if (a3 != null) {
                        arrayList.add(a3);
                    }
                } else if ("Extensions".equals(name)) {
                    arrayList2.addAll(vb.a(xmlPullParser));
                } else {
                    uv.d(xmlPullParser);
                }
            }
        }
        if (TextUtils.isEmpty(attributeValue)) {
            return null;
        }
        a.a(arrayList, vi.a(arrayList2));
        return d.a(attributeValue, arrayList, arrayList2);
    }
}
