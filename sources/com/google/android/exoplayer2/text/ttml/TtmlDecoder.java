package com.google.android.exoplayer2.text.ttml;

import a2.j.b.b.a1.h.d;
import android.text.Layout;
import androidx.annotation.Nullable;
import com.avito.android.remote.model.ProfileTab;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ColorParser;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.XmlPullParserUtil;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
public final class TtmlDecoder extends SimpleSubtitleDecoder {
    public static final Pattern p = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    public static final Pattern q = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    public static final Pattern r = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    public static final Pattern s = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    public static final Pattern t = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");
    public static final Pattern u = Pattern.compile("^(\\d+) (\\d+)$");
    public static final b v = new b(30.0f, 1, 1);
    public static final a w = new a(32, 15);
    public final XmlPullParserFactory o;

    public static final class a {
        public final int a;

        public a(int i, int i2) {
            this.a = i2;
        }
    }

    public static final class b {
        public final float a;
        public final int b;
        public final int c;

        public b(float f, int i, int i2) {
            this.a = f;
            this.b = i;
            this.c = i2;
        }
    }

    public static final class c {
        public final int a;
        public final int b;

        public c(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    public TtmlDecoder() {
        super("TtmlDecoder");
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            this.o = newInstance;
            newInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    public static TtmlStyle e(@Nullable TtmlStyle ttmlStyle) {
        return ttmlStyle == null ? new TtmlStyle() : ttmlStyle;
    }

    public static boolean f(String str) {
        return str.equals("tt") || str.equals("head") || str.equals(SDKConstants.PARAM_A2U_BODY) || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE) || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals("image") || str.equals("data") || str.equals("information");
    }

    public static a g(XmlPullParser xmlPullParser, a aVar) throws SubtitleDecoderException {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return aVar;
        }
        Matcher matcher = u.matcher(attributeValue);
        if (!matcher.matches()) {
            a2.b.a.a.a.V0("Ignoring malformed cell resolution: ", attributeValue, "TtmlDecoder");
            return aVar;
        }
        try {
            int parseInt = Integer.parseInt((String) Assertions.checkNotNull(matcher.group(1)));
            int parseInt2 = Integer.parseInt((String) Assertions.checkNotNull(matcher.group(2)));
            if (parseInt != 0 && parseInt2 != 0) {
                return new a(parseInt, parseInt2);
            }
            throw new SubtitleDecoderException("Invalid cell resolution " + parseInt + " " + parseInt2);
        } catch (NumberFormatException unused) {
            a2.b.a.a.a.V0("Ignoring malformed cell resolution: ", attributeValue, "TtmlDecoder");
            return aVar;
        }
    }

    public static void h(String str, TtmlStyle ttmlStyle) throws SubtitleDecoderException {
        Matcher matcher;
        String[] split = Util.split(str, "\\s+");
        if (split.length == 1) {
            matcher = r.matcher(str);
        } else if (split.length == 2) {
            matcher = r.matcher(split[1]);
            Log.w("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        } else {
            throw new SubtitleDecoderException(a2.b.a.a.a.j(a2.b.a.a.a.L("Invalid number of entries for fontSize: "), split.length, "."));
        }
        if (matcher.matches()) {
            String str2 = (String) Assertions.checkNotNull(matcher.group(3));
            str2.hashCode();
            str2.hashCode();
            char c2 = 65535;
            switch (str2.hashCode()) {
                case 37:
                    if (str2.equals("%")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3240:
                    if (str2.equals(UserDataStore.EMAIL)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3592:
                    if (str2.equals("px")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    ttmlStyle.j = 3;
                    break;
                case 1:
                    ttmlStyle.j = 2;
                    break;
                case 2:
                    ttmlStyle.j = 1;
                    break;
                default:
                    throw new SubtitleDecoderException(a2.b.a.a.a.e3("Invalid unit for fontSize: '", str2, "'."));
            }
            ttmlStyle.k = Float.parseFloat((String) Assertions.checkNotNull(matcher.group(1)));
            return;
        }
        throw new SubtitleDecoderException(a2.b.a.a.a.e3("Invalid expression for fontSize: '", str, "'."));
    }

    public static b i(XmlPullParser xmlPullParser) throws SubtitleDecoderException {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        float f = 1.0f;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            String[] split = Util.split(attributeValue2, " ");
            if (split.length == 2) {
                f = ((float) Integer.parseInt(split[0])) / ((float) Integer.parseInt(split[1]));
            } else {
                throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
            }
        }
        b bVar = v;
        int i = bVar.b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i = Integer.parseInt(attributeValue3);
        }
        int i2 = bVar.c;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i2 = Integer.parseInt(attributeValue4);
        }
        return new b(((float) parseInt) * f, i, i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01c4 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0206  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlStyle> j(org.xmlpull.v1.XmlPullParser r18, java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlStyle> r19, com.google.android.exoplayer2.text.ttml.TtmlDecoder.a r20, @androidx.annotation.Nullable com.google.android.exoplayer2.text.ttml.TtmlDecoder.c r21, java.util.Map<java.lang.String, a2.j.b.b.a1.h.c> r22, java.util.Map<java.lang.String, java.lang.String> r23) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        /*
        // Method dump skipped, instructions count: 583
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.ttml.TtmlDecoder.j(org.xmlpull.v1.XmlPullParser, java.util.Map, com.google.android.exoplayer2.text.ttml.TtmlDecoder$a, com.google.android.exoplayer2.text.ttml.TtmlDecoder$c, java.util.Map, java.util.Map):java.util.Map");
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static a2.j.b.b.a1.h.b k(XmlPullParser xmlPullParser, @Nullable a2.j.b.b.a1.h.b bVar, Map<String, a2.j.b.b.a1.h.c> map, b bVar2) throws SubtitleDecoderException {
        long j;
        long j2;
        char c2;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        int attributeCount = xmlPullParser.getAttributeCount();
        TtmlStyle l = l(xmlPullParser2, null);
        String str = null;
        String str2 = "";
        long j3 = C.TIME_UNSET;
        long j4 = C.TIME_UNSET;
        long j5 = C.TIME_UNSET;
        String[] strArr = null;
        int i = 0;
        while (i < attributeCount) {
            String attributeName = xmlPullParser2.getAttributeName(i);
            String attributeValue = xmlPullParser2.getAttributeValue(i);
            attributeName.hashCode();
            switch (attributeName.hashCode()) {
                case -934795532:
                    if (attributeName.equals("region")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 99841:
                    if (attributeName.equals("dur")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 100571:
                    if (attributeName.equals("end")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 93616297:
                    if (attributeName.equals("begin")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 109780401:
                    if (attributeName.equals(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1292595405:
                    if (attributeName.equals("backgroundImage")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 != 0) {
                if (c2 == 1) {
                    j5 = n(attributeValue, bVar2);
                } else if (c2 == 2) {
                    j4 = n(attributeValue, bVar2);
                } else if (c2 == 3) {
                    j3 = n(attributeValue, bVar2);
                } else if (c2 == 4) {
                    String[] m = m(attributeValue);
                    if (m.length > 0) {
                        strArr = m;
                    }
                } else if (c2 == 5 && attributeValue.startsWith("#")) {
                    str = attributeValue.substring(1);
                }
            } else if (map.containsKey(attributeValue)) {
                str2 = attributeValue;
            }
            i++;
            xmlPullParser2 = xmlPullParser;
        }
        if (bVar != null) {
            long j6 = bVar.d;
            j = C.TIME_UNSET;
            if (j6 != C.TIME_UNSET) {
                if (j3 != C.TIME_UNSET) {
                    j3 += j6;
                }
                if (j4 != C.TIME_UNSET) {
                    j4 += j6;
                }
            }
        } else {
            j = C.TIME_UNSET;
        }
        if (j4 == j) {
            if (j5 != j) {
                j2 = j3 + j5;
            } else if (bVar != null) {
                long j7 = bVar.e;
                if (j7 != j) {
                    j2 = j7;
                }
            }
            return new a2.j.b.b.a1.h.b(xmlPullParser.getName(), null, j3, j2, l, strArr, str2, str, bVar);
        }
        j2 = j4;
        return new a2.j.b.b.a1.h.b(xmlPullParser.getName(), null, j3, j2, l, strArr, str2, str, bVar);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static TtmlStyle l(XmlPullParser xmlPullParser, TtmlStyle ttmlStyle) {
        char c2;
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeValue = xmlPullParser.getAttributeValue(i);
            String attributeName = xmlPullParser.getAttributeName(i);
            attributeName.hashCode();
            switch (attributeName.hashCode()) {
                case -1550943582:
                    if (attributeName.equals("fontStyle")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1224696685:
                    if (attributeName.equals("fontFamily")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1065511464:
                    if (attributeName.equals("textAlign")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -879295043:
                    if (attributeName.equals("textDecoration")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -734428249:
                    if (attributeName.equals("fontWeight")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3355:
                    if (attributeName.equals("id")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3511770:
                    if (attributeName.equals("ruby")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 94842723:
                    if (attributeName.equals("color")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 110138194:
                    if (attributeName.equals("textCombine")) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 365601008:
                    if (attributeName.equals("fontSize")) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1115953443:
                    if (attributeName.equals("rubyPosition")) {
                        c2 = '\n';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1287124693:
                    if (attributeName.equals("backgroundColor")) {
                        c2 = 11;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    ttmlStyle = e(ttmlStyle);
                    ttmlStyle.i = "italic".equalsIgnoreCase(attributeValue) ? 1 : 0;
                    break;
                case 1:
                    ttmlStyle = e(ttmlStyle);
                    ttmlStyle.a = attributeValue;
                    break;
                case 2:
                    String lowerInvariant = Util.toLowerInvariant(attributeValue);
                    lowerInvariant.hashCode();
                    lowerInvariant.hashCode();
                    char c3 = 65535;
                    switch (lowerInvariant.hashCode()) {
                        case -1364013995:
                            if (lowerInvariant.equals("center")) {
                                c3 = 0;
                                break;
                            }
                            break;
                        case 100571:
                            if (lowerInvariant.equals("end")) {
                                c3 = 1;
                                break;
                            }
                            break;
                        case 3317767:
                            if (lowerInvariant.equals(ViewHierarchyConstants.DIMENSION_LEFT_KEY)) {
                                c3 = 2;
                                break;
                            }
                            break;
                        case 108511772:
                            if (lowerInvariant.equals("right")) {
                                c3 = 3;
                                break;
                            }
                            break;
                        case 109757538:
                            if (lowerInvariant.equals(Tracker.Events.CREATIVE_START)) {
                                c3 = 4;
                                break;
                            }
                            break;
                    }
                    switch (c3) {
                        case 0:
                            ttmlStyle = e(ttmlStyle);
                            ttmlStyle.o = Layout.Alignment.ALIGN_CENTER;
                            continue;
                        case 1:
                        case 3:
                            ttmlStyle = e(ttmlStyle);
                            ttmlStyle.o = Layout.Alignment.ALIGN_OPPOSITE;
                            continue;
                        case 2:
                        case 4:
                            ttmlStyle = e(ttmlStyle);
                            ttmlStyle.o = Layout.Alignment.ALIGN_NORMAL;
                            continue;
                    }
                case 3:
                    String lowerInvariant2 = Util.toLowerInvariant(attributeValue);
                    lowerInvariant2.hashCode();
                    lowerInvariant2.hashCode();
                    char c4 = 65535;
                    switch (lowerInvariant2.hashCode()) {
                        case -1461280213:
                            if (lowerInvariant2.equals("nounderline")) {
                                c4 = 0;
                                break;
                            }
                            break;
                        case -1026963764:
                            if (lowerInvariant2.equals("underline")) {
                                c4 = 1;
                                break;
                            }
                            break;
                        case 913457136:
                            if (lowerInvariant2.equals("nolinethrough")) {
                                c4 = 2;
                                break;
                            }
                            break;
                        case 1679736913:
                            if (lowerInvariant2.equals("linethrough")) {
                                c4 = 3;
                                break;
                            }
                            break;
                    }
                    switch (c4) {
                        case 0:
                            ttmlStyle = e(ttmlStyle);
                            ttmlStyle.g = 0;
                            continue;
                        case 1:
                            ttmlStyle = e(ttmlStyle);
                            ttmlStyle.g = 1;
                            continue;
                        case 2:
                            ttmlStyle = e(ttmlStyle);
                            ttmlStyle.f = 0;
                            continue;
                        case 3:
                            ttmlStyle = e(ttmlStyle);
                            ttmlStyle.f = 1;
                            continue;
                    }
                case 4:
                    ttmlStyle = e(ttmlStyle);
                    ttmlStyle.h = "bold".equalsIgnoreCase(attributeValue) ? 1 : 0;
                    break;
                case 5:
                    if (AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE.equals(xmlPullParser.getName())) {
                        ttmlStyle = e(ttmlStyle);
                        ttmlStyle.l = attributeValue;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    String lowerInvariant3 = Util.toLowerInvariant(attributeValue);
                    lowerInvariant3.hashCode();
                    lowerInvariant3.hashCode();
                    char c5 = 65535;
                    switch (lowerInvariant3.hashCode()) {
                        case -618561360:
                            if (lowerInvariant3.equals("baseContainer")) {
                                c5 = 0;
                                break;
                            }
                            break;
                        case -410956671:
                            if (lowerInvariant3.equals("container")) {
                                c5 = 1;
                                break;
                            }
                            break;
                        case -250518009:
                            if (lowerInvariant3.equals("delimiter")) {
                                c5 = 2;
                                break;
                            }
                            break;
                        case -136074796:
                            if (lowerInvariant3.equals("textContainer")) {
                                c5 = 3;
                                break;
                            }
                            break;
                        case 3016401:
                            if (lowerInvariant3.equals("base")) {
                                c5 = 4;
                                break;
                            }
                            break;
                        case 3556653:
                            if (lowerInvariant3.equals("text")) {
                                c5 = 5;
                                break;
                            }
                            break;
                    }
                    switch (c5) {
                        case 0:
                        case 4:
                            ttmlStyle = e(ttmlStyle);
                            ttmlStyle.m = 2;
                            continue;
                        case 1:
                            ttmlStyle = e(ttmlStyle);
                            ttmlStyle.m = 1;
                            continue;
                        case 2:
                            ttmlStyle = e(ttmlStyle);
                            ttmlStyle.m = 4;
                            continue;
                        case 3:
                        case 5:
                            ttmlStyle = e(ttmlStyle);
                            ttmlStyle.m = 3;
                            continue;
                    }
                case 7:
                    ttmlStyle = e(ttmlStyle);
                    try {
                        ttmlStyle.b = ColorParser.parseTtmlColor(attributeValue);
                        ttmlStyle.c = true;
                        break;
                    } catch (IllegalArgumentException unused) {
                        a2.b.a.a.a.V0("Failed parsing color value: ", attributeValue, "TtmlDecoder");
                        break;
                    }
                case '\b':
                    String lowerInvariant4 = Util.toLowerInvariant(attributeValue);
                    lowerInvariant4.hashCode();
                    if (!lowerInvariant4.equals(ProfileTab.ALL)) {
                        if (!lowerInvariant4.equals("none")) {
                            break;
                        } else {
                            ttmlStyle = e(ttmlStyle);
                            ttmlStyle.p = 0;
                            break;
                        }
                    } else {
                        ttmlStyle = e(ttmlStyle);
                        ttmlStyle.p = 1;
                        break;
                    }
                case '\t':
                    try {
                        ttmlStyle = e(ttmlStyle);
                        h(attributeValue, ttmlStyle);
                        break;
                    } catch (SubtitleDecoderException unused2) {
                        a2.b.a.a.a.V0("Failed parsing fontSize value: ", attributeValue, "TtmlDecoder");
                        break;
                    }
                case '\n':
                    String lowerInvariant5 = Util.toLowerInvariant(attributeValue);
                    lowerInvariant5.hashCode();
                    if (!lowerInvariant5.equals("before")) {
                        if (!lowerInvariant5.equals("after")) {
                            break;
                        } else {
                            ttmlStyle = e(ttmlStyle);
                            ttmlStyle.n = 2;
                            break;
                        }
                    } else {
                        ttmlStyle = e(ttmlStyle);
                        ttmlStyle.n = 1;
                        break;
                    }
                case 11:
                    ttmlStyle = e(ttmlStyle);
                    try {
                        ttmlStyle.d = ColorParser.parseTtmlColor(attributeValue);
                        ttmlStyle.e = true;
                        break;
                    } catch (IllegalArgumentException unused3) {
                        a2.b.a.a.a.V0("Failed parsing background value: ", attributeValue, "TtmlDecoder");
                        break;
                    }
            }
        }
        return ttmlStyle;
    }

    public static String[] m(String str) {
        String trim = str.trim();
        return trim.isEmpty() ? new String[0] : Util.split(trim, "\\s+");
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00bd, code lost:
        if (r13.equals("ms") == false) goto L_0x00ec;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long n(java.lang.String r13, com.google.android.exoplayer2.text.ttml.TtmlDecoder.b r14) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        /*
        // Method dump skipped, instructions count: 318
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.ttml.TtmlDecoder.n(java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlDecoder$b):long");
    }

    @Nullable
    public static c o(XmlPullParser xmlPullParser) {
        String attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, "extent");
        if (attributeValue == null) {
            return null;
        }
        Matcher matcher = t.matcher(attributeValue);
        if (!matcher.matches()) {
            a2.b.a.a.a.V0("Ignoring non-pixel tts extent: ", attributeValue, "TtmlDecoder");
            return null;
        }
        try {
            return new c(Integer.parseInt((String) Assertions.checkNotNull(matcher.group(1))), Integer.parseInt((String) Assertions.checkNotNull(matcher.group(2))));
        } catch (NumberFormatException unused) {
            a2.b.a.a.a.V0("Ignoring malformed tts extent: ", attributeValue, "TtmlDecoder");
            return null;
        }
    }

    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public Subtitle decode(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        b bVar;
        try {
            XmlPullParser newPullParser = this.o.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            hashMap2.put("", new a2.j.b.b.a1.h.c("", -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE));
            c cVar = null;
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            b bVar2 = v;
            a aVar = w;
            d dVar = null;
            int i2 = 0;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.getEventType()) {
                a2.j.b.b.a1.h.b bVar3 = (a2.j.b.b.a1.h.b) arrayDeque.peek();
                if (i2 == 0) {
                    String name = newPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            bVar2 = i(newPullParser);
                            aVar = g(newPullParser, w);
                            cVar = o(newPullParser);
                        }
                        if (!f(name)) {
                            Log.i("TtmlDecoder", "Ignoring unsupported tag: " + newPullParser.getName());
                            i2++;
                            bVar = bVar2;
                        } else if ("head".equals(name)) {
                            bVar = bVar2;
                            j(newPullParser, hashMap, aVar, cVar, hashMap2, hashMap3);
                        } else {
                            bVar = bVar2;
                            try {
                                a2.j.b.b.a1.h.b k = k(newPullParser, bVar3, hashMap2, bVar);
                                arrayDeque.push(k);
                                if (bVar3 != null) {
                                    bVar3.a(k);
                                }
                            } catch (SubtitleDecoderException e) {
                                Log.w("TtmlDecoder", "Suppressing parser error", e);
                                i2++;
                            }
                        }
                        bVar2 = bVar;
                        cVar = cVar;
                        aVar = aVar;
                    } else if (eventType == 4) {
                        a2.j.b.b.a1.h.b bVar4 = (a2.j.b.b.a1.h.b) Assertions.checkNotNull(bVar3);
                        a2.j.b.b.a1.h.b b2 = a2.j.b.b.a1.h.b.b(newPullParser.getText());
                        if (bVar4.m == null) {
                            bVar4.m = new ArrayList();
                        }
                        bVar4.m.add(b2);
                    } else if (eventType == 3) {
                        if (newPullParser.getName().equals("tt")) {
                            dVar = new d((a2.j.b.b.a1.h.b) Assertions.checkNotNull((a2.j.b.b.a1.h.b) arrayDeque.peek()), hashMap, hashMap2, hashMap3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i2++;
                } else if (eventType == 3) {
                    i2--;
                }
                newPullParser.next();
            }
            if (dVar != null) {
                return dVar;
            }
            throw new SubtitleDecoderException("No TTML subtitles found");
        } catch (XmlPullParserException e2) {
            throw new SubtitleDecoderException("Unable to decode source", e2);
        } catch (IOException e3) {
            throw new IllegalStateException("Unexpected error when reading input.", e3);
        }
    }
}
