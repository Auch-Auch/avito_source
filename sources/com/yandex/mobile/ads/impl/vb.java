package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.yandex.mobile.ads.video.models.common.Extension;
import com.yandex.mobile.ads.video.models.common.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
public final class vb {
    @NonNull
    private final uv a;
    @NonNull
    private final va b;

    public vb(@NonNull uv uvVar) {
        this.a = uvVar;
        this.b = new va(uvVar);
    }

    @NonNull
    public static List<Extension> a(@NonNull XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        uv.a(xmlPullParser, "Extensions");
        ArrayList arrayList = new ArrayList();
        while (uv.b(xmlPullParser)) {
            if (uv.a(xmlPullParser)) {
                if ("Extension".equals(xmlPullParser.getName())) {
                    uv.a(xmlPullParser, "Extension");
                    Extension extension = null;
                    String attributeValue = xmlPullParser.getAttributeValue(null, "type");
                    String c = uv.c(xmlPullParser);
                    if (!TextUtils.isEmpty(attributeValue) && !TextUtils.isEmpty(c)) {
                        extension = a.a(attributeValue, c);
                    }
                    if (extension != null) {
                        arrayList.add(extension);
                    }
                } else {
                    uv.d(xmlPullParser);
                }
            }
        }
        return arrayList;
    }
}
