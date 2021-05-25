package com.google.android.exoplayer2.text.webvtt;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.vk.sdk.api.VKApiConst;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.Typography;
public final class WebvttCueParser {
    public static final Pattern CUE_HEADER_PATTERN = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
    public static final Pattern a = Pattern.compile("(\\S+?):(\\S+)");
    public static final Map<String, Integer> b;
    public static final Map<String, Integer> c;

    public static class b {
        public static final /* synthetic */ int c = 0;
        public final c a;
        public final int b;

        public b(c cVar, int i, a aVar) {
            this.a = cVar;
            this.b = i;
        }
    }

    public static final class c {
        public final String a;
        public final int b;
        public final String c;
        public final Set<String> d;

        public c(String str, int i, String str2, Set<String> set) {
            this.b = i;
            this.a = str;
            this.c = str2;
            this.d = set;
        }
    }

    public static final class d implements Comparable<d> {
        public final int a;
        public final WebvttCssStyle b;

        public d(int i, WebvttCssStyle webvttCssStyle) {
            this.a = i;
            this.b = webvttCssStyle;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public int compareTo(d dVar) {
            return Integer.compare(this.a, dVar.a);
        }
    }

    public static final class e {
        public long a = 0;
        public long b = 0;
        public CharSequence c;
        public int d = 2;
        public float e = -3.4028235E38f;
        public int f = 1;
        public int g = 0;
        public float h = -3.4028235E38f;
        public int i = Integer.MIN_VALUE;
        public float j = 1.0f;
        public int k = Integer.MIN_VALUE;

        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0074, code lost:
            if (r8 == 0) goto L_0x0076;
         */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0072  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0074  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x008e  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x00aa  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x00be  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.android.exoplayer2.text.Cue.Builder a() {
            /*
                r13 = this;
                float r0 = r13.h
                r1 = 1056964608(0x3f000000, float:0.5)
                r2 = 0
                r3 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
                r4 = 1065353216(0x3f800000, float:1.0)
                r5 = 5
                r6 = 4
                int r7 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
                if (r7 == 0) goto L_0x0011
                goto L_0x001e
            L_0x0011:
                int r0 = r13.d
                if (r0 == r6) goto L_0x001d
                if (r0 == r5) goto L_0x001a
                r0 = 1056964608(0x3f000000, float:0.5)
                goto L_0x001e
            L_0x001a:
                r0 = 1065353216(0x3f800000, float:1.0)
                goto L_0x001e
            L_0x001d:
                r0 = 0
            L_0x001e:
                int r7 = r13.i
                r8 = -2147483648(0xffffffff80000000, float:-0.0)
                r9 = 3
                r10 = 2
                r11 = 1
                if (r7 == r8) goto L_0x0028
                goto L_0x0037
            L_0x0028:
                int r7 = r13.d
                if (r7 == r11) goto L_0x0036
                if (r7 == r9) goto L_0x0034
                if (r7 == r6) goto L_0x0036
                if (r7 == r5) goto L_0x0034
                r7 = 1
                goto L_0x0037
            L_0x0034:
                r7 = 2
                goto L_0x0037
            L_0x0036:
                r7 = 0
            L_0x0037:
                com.google.android.exoplayer2.text.Cue$Builder r8 = new com.google.android.exoplayer2.text.Cue$Builder
                r8.<init>()
                int r12 = r13.d
                if (r12 == r11) goto L_0x0057
                if (r12 == r10) goto L_0x0054
                if (r12 == r9) goto L_0x0051
                if (r12 == r6) goto L_0x0057
                if (r12 == r5) goto L_0x0051
                java.lang.String r5 = "Unknown textAlignment: "
                java.lang.String r6 = "WebvttCueParser"
                a2.b.a.a.a.T0(r5, r12, r6)
                r5 = 0
                goto L_0x0059
            L_0x0051:
                android.text.Layout$Alignment r5 = android.text.Layout.Alignment.ALIGN_OPPOSITE
                goto L_0x0059
            L_0x0054:
                android.text.Layout$Alignment r5 = android.text.Layout.Alignment.ALIGN_CENTER
                goto L_0x0059
            L_0x0057:
                android.text.Layout$Alignment r5 = android.text.Layout.Alignment.ALIGN_NORMAL
            L_0x0059:
                com.google.android.exoplayer2.text.Cue$Builder r5 = r8.setTextAlignment(r5)
                float r6 = r13.e
                int r8 = r13.f
                int r9 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
                if (r9 == 0) goto L_0x0070
                if (r8 != 0) goto L_0x0070
                int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                if (r2 < 0) goto L_0x0076
                int r2 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                if (r2 <= 0) goto L_0x0070
                goto L_0x0076
            L_0x0070:
                if (r9 == 0) goto L_0x0074
                r3 = r6
                goto L_0x0078
            L_0x0074:
                if (r8 != 0) goto L_0x0078
            L_0x0076:
                r3 = 1065353216(0x3f800000, float:1.0)
            L_0x0078:
                com.google.android.exoplayer2.text.Cue$Builder r2 = r5.setLine(r3, r8)
                int r3 = r13.g
                com.google.android.exoplayer2.text.Cue$Builder r2 = r2.setLineAnchor(r3)
                com.google.android.exoplayer2.text.Cue$Builder r2 = r2.setPosition(r0)
                com.google.android.exoplayer2.text.Cue$Builder r2 = r2.setPositionAnchor(r7)
                float r3 = r13.j
                if (r7 == 0) goto L_0x00aa
                if (r7 == r11) goto L_0x009d
                if (r7 != r10) goto L_0x0093
                goto L_0x00ac
            L_0x0093:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = java.lang.String.valueOf(r7)
                r0.<init>(r1)
                throw r0
            L_0x009d:
                r5 = 1073741824(0x40000000, float:2.0)
                int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r1 > 0) goto L_0x00a6
                float r0 = r0 * r5
                goto L_0x00ac
            L_0x00a6:
                float r4 = r4 - r0
                float r0 = r4 * r5
                goto L_0x00ac
            L_0x00aa:
                float r0 = r4 - r0
            L_0x00ac:
                float r0 = java.lang.Math.min(r3, r0)
                com.google.android.exoplayer2.text.Cue$Builder r0 = r2.setSize(r0)
                int r1 = r13.k
                com.google.android.exoplayer2.text.Cue$Builder r0 = r0.setVerticalType(r1)
                java.lang.CharSequence r1 = r13.c
                if (r1 == 0) goto L_0x00c1
                r0.setText(r1)
            L_0x00c1:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.webvtt.WebvttCueParser.e.a():com.google.android.exoplayer2.text.Cue$Builder");
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap.put("lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap.put("cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap.put("red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap.put("yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap.put("magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap.put("blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap.put("black", Integer.valueOf(Color.rgb(0, 0, 0)));
        b = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        c = Collections.unmodifiableMap(hashMap2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:117:0x023d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0097 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x017c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(@androidx.annotation.Nullable java.lang.String r18, com.google.android.exoplayer2.text.webvtt.WebvttCueParser.c r19, java.util.List<com.google.android.exoplayer2.text.webvtt.WebvttCueParser.b> r20, android.text.SpannableStringBuilder r21, java.util.List<com.google.android.exoplayer2.text.webvtt.WebvttCssStyle> r22) {
        /*
        // Method dump skipped, instructions count: 594
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.webvtt.WebvttCueParser.a(java.lang.String, com.google.android.exoplayer2.text.webvtt.WebvttCueParser$c, java.util.List, android.text.SpannableStringBuilder, java.util.List):void");
    }

    public static List<d> b(List<WebvttCssStyle> list, @Nullable String str, c cVar) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            WebvttCssStyle webvttCssStyle = list.get(i);
            int specificityScore = webvttCssStyle.getSpecificityScore(str, cVar.a, cVar.d, cVar.c);
            if (specificityScore > 0) {
                arrayList.add(new d(specificityScore, webvttCssStyle));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static int c(List<WebvttCssStyle> list, @Nullable String str, c cVar) {
        List<d> b2 = b(list, str, cVar);
        int i = 0;
        while (true) {
            ArrayList arrayList = (ArrayList) b2;
            if (i >= arrayList.size()) {
                return -1;
            }
            WebvttCssStyle webvttCssStyle = ((d) arrayList.get(i)).b;
            if (webvttCssStyle.getRubyPosition() != -1) {
                return webvttCssStyle.getRubyPosition();
            }
            i++;
        }
    }

    @Nullable
    public static WebvttCueInfo d(@Nullable String str, Matcher matcher, ParsableByteArray parsableByteArray, List<WebvttCssStyle> list) {
        e eVar = new e();
        try {
            eVar.a = WebvttParserUtil.parseTimestampUs((String) Assertions.checkNotNull(matcher.group(1)));
            eVar.b = WebvttParserUtil.parseTimestampUs((String) Assertions.checkNotNull(matcher.group(2)));
            e((String) Assertions.checkNotNull(matcher.group(3)), eVar);
            StringBuilder sb = new StringBuilder();
            String readLine = parsableByteArray.readLine();
            while (!TextUtils.isEmpty(readLine)) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(readLine.trim());
                readLine = parsableByteArray.readLine();
            }
            eVar.c = f(str, sb.toString(), list);
            return new WebvttCueInfo(eVar.a().build(), eVar.a, eVar.b);
        } catch (NumberFormatException unused) {
            StringBuilder L = a2.b.a.a.a.L("Skipping cue with bad header: ");
            L.append(matcher.group());
            Log.w("WebvttCueParser", L.toString());
            return null;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void e(String str, e eVar) {
        Matcher matcher = a.matcher(str);
        while (matcher.find()) {
            int i = 1;
            String str2 = (String) Assertions.checkNotNull(matcher.group(1));
            String str3 = (String) Assertions.checkNotNull(matcher.group(2));
            try {
                if ("line".equals(str2)) {
                    g(str3, eVar);
                } else if ("align".equals(str2)) {
                    str3.hashCode();
                    str3.hashCode();
                    char c2 = 65535;
                    switch (str3.hashCode()) {
                        case -1364013995:
                            if (str3.equals("center")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case -1074341483:
                            if (str3.equals("middle")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 100571:
                            if (str3.equals("end")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 3317767:
                            if (str3.equals(ViewHierarchyConstants.DIMENSION_LEFT_KEY)) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case 108511772:
                            if (str3.equals("right")) {
                                c2 = 4;
                                break;
                            }
                            break;
                        case 109757538:
                            if (str3.equals(Tracker.Events.CREATIVE_START)) {
                                c2 = 5;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                        case 1:
                            i = 2;
                            break;
                        case 2:
                            i = 3;
                            break;
                        case 3:
                            i = 4;
                            break;
                        case 4:
                            i = 5;
                            break;
                        case 5:
                            break;
                        default:
                            Log.w("WebvttCueParser", "Invalid alignment value: " + str3);
                            i = 2;
                            break;
                    }
                    eVar.d = i;
                } else if (VKApiConst.POSITION.equals(str2)) {
                    h(str3, eVar);
                } else if ("size".equals(str2)) {
                    eVar.j = WebvttParserUtil.parsePercentage(str3);
                } else if ("vertical".equals(str2)) {
                    str3.hashCode();
                    if (str3.equals("lr")) {
                        i = 2;
                    } else if (!str3.equals("rl")) {
                        Log.w("WebvttCueParser", "Invalid 'vertical' value: " + str3);
                        i = Integer.MIN_VALUE;
                    }
                    eVar.k = i;
                } else {
                    Log.w("WebvttCueParser", "Unknown cue setting " + str2 + ":" + str3);
                }
            } catch (NumberFormatException unused) {
                StringBuilder L = a2.b.a.a.a.L("Skipping bad cue setting: ");
                L.append(matcher.group());
                Log.w("WebvttCueParser", L.toString());
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static SpannedString f(@Nullable String str, String str2, List<WebvttCssStyle> list) {
        char c2;
        boolean z;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (true) {
            String str3 = "";
            if (i2 < str2.length()) {
                char charAt = str2.charAt(i2);
                char c3 = 65535;
                if (charAt == '&') {
                    i2++;
                    int indexOf = str2.indexOf(59, i2);
                    int indexOf2 = str2.indexOf(32, i2);
                    if (indexOf == -1) {
                        indexOf = indexOf2;
                    } else if (indexOf2 != -1) {
                        indexOf = Math.min(indexOf, indexOf2);
                    }
                    if (indexOf != -1) {
                        String substring = str2.substring(i2, indexOf);
                        substring.hashCode();
                        switch (substring.hashCode()) {
                            case 3309:
                                if (substring.equals("gt")) {
                                    c3 = 0;
                                    break;
                                }
                                break;
                            case 3464:
                                if (substring.equals("lt")) {
                                    c3 = 1;
                                    break;
                                }
                                break;
                            case 96708:
                                if (substring.equals("amp")) {
                                    c3 = 2;
                                    break;
                                }
                                break;
                            case 3374865:
                                if (substring.equals("nbsp")) {
                                    c3 = 3;
                                    break;
                                }
                                break;
                        }
                        switch (c3) {
                            case 0:
                                spannableStringBuilder.append(Typography.greater);
                                break;
                            case 1:
                                spannableStringBuilder.append(Typography.less);
                                break;
                            case 2:
                                spannableStringBuilder.append(Typography.amp);
                                break;
                            case 3:
                                spannableStringBuilder.append(' ');
                                break;
                            default:
                                Log.w("WebvttCueParser", "ignoring unsupported entity: '&" + substring + ";'");
                                break;
                        }
                        if (indexOf == indexOf2) {
                            spannableStringBuilder.append((CharSequence) " ");
                        }
                        i2 = indexOf + 1;
                    } else {
                        spannableStringBuilder.append(charAt);
                    }
                } else if (charAt != '<') {
                    spannableStringBuilder.append(charAt);
                    i2++;
                } else {
                    int i3 = i2 + 1;
                    if (i3 < str2.length()) {
                        boolean z2 = str2.charAt(i3) == '/';
                        int indexOf3 = str2.indexOf(62, i3);
                        i3 = indexOf3 == -1 ? str2.length() : indexOf3 + 1;
                        int i4 = i3 - 2;
                        boolean z3 = str2.charAt(i4) == '/';
                        int i5 = i2 + (z2 ? 2 : 1);
                        if (!z3) {
                            i4 = i3 - 1;
                        }
                        String substring2 = str2.substring(i5, i4);
                        if (!substring2.trim().isEmpty()) {
                            String trim = substring2.trim();
                            Assertions.checkArgument(!trim.isEmpty());
                            String str4 = Util.splitAtFirst(trim, "[ \\.]")[i];
                            str4.hashCode();
                            switch (str4.hashCode()) {
                                case 98:
                                    if (str4.equals(AuthSource.BOOKING_ORDER)) {
                                        c2 = 0;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 99:
                                    if (str4.equals("c")) {
                                        c2 = 1;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 105:
                                    if (str4.equals("i")) {
                                        c2 = 2;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 117:
                                    if (str4.equals("u")) {
                                        c2 = 3;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 118:
                                    if (str4.equals(VKApiConst.VERSION)) {
                                        c2 = 4;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 3650:
                                    if (str4.equals("rt")) {
                                        c2 = 5;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 3314158:
                                    if (str4.equals(VKApiConst.LANG)) {
                                        c2 = 6;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 3511770:
                                    if (str4.equals("ruby")) {
                                        c2 = 7;
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
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                    z = true;
                                    break;
                                default:
                                    z = false;
                                    break;
                            }
                            if (z) {
                                if (z2) {
                                    while (!arrayDeque.isEmpty()) {
                                        c cVar = (c) arrayDeque.pop();
                                        a(str, cVar, arrayList, spannableStringBuilder, list);
                                        if (!arrayDeque.isEmpty()) {
                                            arrayList.add(new b(cVar, spannableStringBuilder.length(), null));
                                        } else {
                                            arrayList.clear();
                                        }
                                        if (cVar.a.equals(str4)) {
                                        }
                                    }
                                } else if (!z3) {
                                    int length = spannableStringBuilder.length();
                                    String trim2 = substring2.trim();
                                    Assertions.checkArgument(!trim2.isEmpty());
                                    int indexOf4 = trim2.indexOf(" ");
                                    if (indexOf4 != -1) {
                                        str3 = trim2.substring(indexOf4).trim();
                                        trim2 = trim2.substring(i, indexOf4);
                                    }
                                    String[] split = Util.split(trim2, "\\.");
                                    String str5 = split[i];
                                    HashSet hashSet = new HashSet();
                                    for (int i6 = 1; i6 < split.length; i6++) {
                                        hashSet.add(split[i6]);
                                    }
                                    arrayDeque.push(new c(str5, length, str3, hashSet));
                                }
                            }
                        }
                        i2 = i3;
                    }
                    i2 = i3;
                }
                i = 0;
            } else {
                while (!arrayDeque.isEmpty()) {
                    a(str, (c) arrayDeque.pop(), arrayList, spannableStringBuilder, list);
                }
                a(str, new c(str3, 0, str3, Collections.emptySet()), Collections.emptyList(), spannableStringBuilder, list);
                return SpannedString.valueOf(spannableStringBuilder);
            }
        }
    }

    public static void g(String str, e eVar) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            String substring = str.substring(indexOf + 1);
            substring.hashCode();
            substring.hashCode();
            int i = 2;
            char c2 = 65535;
            switch (substring.hashCode()) {
                case -1364013995:
                    if (substring.equals("center")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1074341483:
                    if (substring.equals("middle")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 100571:
                    if (substring.equals("end")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 109757538:
                    if (substring.equals(Tracker.Events.CREATIVE_START)) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                case 1:
                    i = 1;
                    break;
                case 2:
                    break;
                case 3:
                    i = 0;
                    break;
                default:
                    a2.b.a.a.a.V0("Invalid anchor value: ", substring, "WebvttCueParser");
                    i = Integer.MIN_VALUE;
                    break;
            }
            eVar.g = i;
            str = str.substring(0, indexOf);
        }
        if (str.endsWith("%")) {
            eVar.e = WebvttParserUtil.parsePercentage(str);
            eVar.f = 0;
            return;
        }
        eVar.e = (float) Integer.parseInt(str);
        eVar.f = 1;
    }

    public static void h(String str, e eVar) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            String substring = str.substring(indexOf + 1);
            substring.hashCode();
            substring.hashCode();
            int i = 2;
            char c2 = 65535;
            switch (substring.hashCode()) {
                case -1842484672:
                    if (substring.equals("line-left")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1364013995:
                    if (substring.equals("center")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1276788989:
                    if (substring.equals("line-right")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1074341483:
                    if (substring.equals("middle")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 100571:
                    if (substring.equals("end")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 109757538:
                    if (substring.equals(Tracker.Events.CREATIVE_START)) {
                        c2 = 5;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                case 5:
                    i = 0;
                    break;
                case 1:
                case 3:
                    i = 1;
                    break;
                case 2:
                case 4:
                    break;
                default:
                    a2.b.a.a.a.V0("Invalid anchor value: ", substring, "WebvttCueParser");
                    i = Integer.MIN_VALUE;
                    break;
            }
            eVar.i = i;
            str = str.substring(0, indexOf);
        }
        eVar.h = WebvttParserUtil.parsePercentage(str);
    }

    @Nullable
    public static WebvttCueInfo parseCue(ParsableByteArray parsableByteArray, List<WebvttCssStyle> list) {
        String readLine = parsableByteArray.readLine();
        if (readLine == null) {
            return null;
        }
        Pattern pattern = CUE_HEADER_PATTERN;
        Matcher matcher = pattern.matcher(readLine);
        if (matcher.matches()) {
            return d(null, matcher, parsableByteArray, list);
        }
        String readLine2 = parsableByteArray.readLine();
        if (readLine2 == null) {
            return null;
        }
        Matcher matcher2 = pattern.matcher(readLine2);
        if (matcher2.matches()) {
            return d(readLine.trim(), matcher2, parsableByteArray, list);
        }
        return null;
    }
}
