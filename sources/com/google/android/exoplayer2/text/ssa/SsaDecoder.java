package com.google.android.exoplayer2.text.ssa;

import a2.j.b.b.a1.f.a;
import a2.j.b.b.a1.f.b;
import android.graphics.PointF;
import android.text.Layout;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.ssa.SsaStyle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public final class SsaDecoder extends SimpleSubtitleDecoder {
    public static final Pattern t = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    public final boolean o;
    @Nullable
    public final a p;
    public Map<String, SsaStyle> q;
    public float r;
    public float s;

    public SsaDecoder() {
        this(null);
    }

    public static int e(long j, List<Long> list, List<List<Cue>> list2) {
        int i;
        ArrayList arrayList;
        int size = list.size() - 1;
        while (true) {
            if (size < 0) {
                i = 0;
                break;
            } else if (list.get(size).longValue() == j) {
                return size;
            } else {
                if (list.get(size).longValue() < j) {
                    i = size + 1;
                    break;
                }
                size--;
            }
        }
        list.add(i, Long.valueOf(j));
        if (i != 0) {
            arrayList = new ArrayList(list2.get(i - 1));
        }
        list2.add(i, arrayList);
        return i;
    }

    public static float f(int i) {
        if (i == 0) {
            return 0.05f;
        }
        if (i != 1) {
            return i != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    public static long h(String str) {
        Matcher matcher = t.matcher(str.trim());
        if (!matcher.matches()) {
            return C.TIME_UNSET;
        }
        long parseLong = (Long.parseLong((String) Util.castNonNull(matcher.group(2))) * 60 * 1000000) + (Long.parseLong((String) Util.castNonNull(matcher.group(1))) * 60 * 60 * 1000000);
        return (Long.parseLong((String) Util.castNonNull(matcher.group(4))) * 10000) + (Long.parseLong((String) Util.castNonNull(matcher.group(3))) * 1000000) + parseLong;
    }

    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public Subtitle decode(byte[] bArr, int i, boolean z) {
        ParsableByteArray parsableByteArray;
        Layout.Alignment alignment;
        int i2;
        int i3;
        int i4;
        SsaDecoder ssaDecoder = this;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ParsableByteArray parsableByteArray2 = new ParsableByteArray(bArr, i);
        if (!ssaDecoder.o) {
            ssaDecoder.g(parsableByteArray2);
        }
        a aVar = ssaDecoder.o ? ssaDecoder.p : null;
        while (true) {
            String readLine = parsableByteArray2.readLine();
            if (readLine == null) {
                return new b(arrayList, arrayList2);
            }
            if (readLine.startsWith("Format:")) {
                aVar = a.a(readLine);
            } else {
                if (readLine.startsWith("Dialogue:")) {
                    if (aVar == null) {
                        a2.b.a.a.a.V0("Skipping dialogue line before complete format: ", readLine, "SsaDecoder");
                    } else {
                        Assertions.checkArgument(readLine.startsWith("Dialogue:"));
                        String[] split = readLine.substring(9).split(",", aVar.e);
                        if (split.length != aVar.e) {
                            a2.b.a.a.a.V0("Skipping dialogue line with fewer columns than format: ", readLine, "SsaDecoder");
                        } else {
                            long h = h(split[aVar.a]);
                            if (h == C.TIME_UNSET) {
                                a2.b.a.a.a.V0("Skipping invalid timing: ", readLine, "SsaDecoder");
                            } else {
                                long h2 = h(split[aVar.b]);
                                if (h2 == C.TIME_UNSET) {
                                    a2.b.a.a.a.V0("Skipping invalid timing: ", readLine, "SsaDecoder");
                                } else {
                                    Map<String, SsaStyle> map = ssaDecoder.q;
                                    SsaStyle ssaStyle = (map == null || (i4 = aVar.c) == -1) ? null : map.get(split[i4].trim());
                                    String str = split[aVar.d];
                                    Matcher matcher = SsaStyle.b.c.matcher(str);
                                    PointF pointF = null;
                                    int i5 = -1;
                                    while (true) {
                                        parsableByteArray = parsableByteArray2;
                                        if (matcher.find()) {
                                            String str2 = (String) Assertions.checkNotNull(matcher.group(1));
                                            try {
                                                PointF a = SsaStyle.b.a(str2);
                                                if (a != null) {
                                                    pointF = a;
                                                }
                                            } catch (RuntimeException unused) {
                                            }
                                            try {
                                                Matcher matcher2 = SsaStyle.b.f.matcher(str2);
                                                int a3 = matcher2.find() ? SsaStyle.a((String) Assertions.checkNotNull(matcher2.group(1))) : -1;
                                                if (a3 != -1) {
                                                    i5 = a3;
                                                }
                                            } catch (RuntimeException unused2) {
                                            }
                                            parsableByteArray2 = parsableByteArray;
                                        } else {
                                            SsaStyle.b bVar = new SsaStyle.b(i5, pointF);
                                            String replace = SsaStyle.b.c.matcher(str).replaceAll("").replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " ");
                                            float f = ssaDecoder.r;
                                            float f2 = ssaDecoder.s;
                                            Cue.Builder text = new Cue.Builder().setText(replace);
                                            int i6 = bVar.a;
                                            if (i6 == -1) {
                                                i6 = ssaStyle != null ? ssaStyle.b : -1;
                                            }
                                            switch (i6) {
                                                case 0:
                                                default:
                                                    a2.b.a.a.a.T0("Unknown alignment: ", i6, "SsaDecoder");
                                                case -1:
                                                    alignment = null;
                                                    break;
                                                case 1:
                                                case 4:
                                                case 7:
                                                    alignment = Layout.Alignment.ALIGN_NORMAL;
                                                    break;
                                                case 2:
                                                case 5:
                                                case 8:
                                                    alignment = Layout.Alignment.ALIGN_CENTER;
                                                    break;
                                                case 3:
                                                case 6:
                                                case 9:
                                                    alignment = Layout.Alignment.ALIGN_OPPOSITE;
                                                    break;
                                            }
                                            Cue.Builder textAlignment = text.setTextAlignment(alignment);
                                            switch (i6) {
                                                case 0:
                                                default:
                                                    a2.b.a.a.a.T0("Unknown alignment: ", i6, "SsaDecoder");
                                                case -1:
                                                    i2 = Integer.MIN_VALUE;
                                                    break;
                                                case 1:
                                                case 4:
                                                case 7:
                                                    i2 = 0;
                                                    break;
                                                case 2:
                                                case 5:
                                                case 8:
                                                    i2 = 1;
                                                    break;
                                                case 3:
                                                case 6:
                                                case 9:
                                                    i2 = 2;
                                                    break;
                                            }
                                            Cue.Builder positionAnchor = textAlignment.setPositionAnchor(i2);
                                            switch (i6) {
                                                case 0:
                                                default:
                                                    a2.b.a.a.a.T0("Unknown alignment: ", i6, "SsaDecoder");
                                                case -1:
                                                    i3 = Integer.MIN_VALUE;
                                                    break;
                                                case 1:
                                                case 2:
                                                case 3:
                                                    i3 = 2;
                                                    break;
                                                case 4:
                                                case 5:
                                                case 6:
                                                    i3 = 1;
                                                    break;
                                                case 7:
                                                case 8:
                                                case 9:
                                                    i3 = 0;
                                                    break;
                                            }
                                            positionAnchor.setLineAnchor(i3);
                                            PointF pointF2 = bVar.b;
                                            if (pointF2 == null || f2 == -3.4028235E38f || f == -3.4028235E38f) {
                                                text.setPosition(f(text.getPositionAnchor()));
                                                text.setLine(f(text.getLineAnchor()), 0);
                                            } else {
                                                text.setPosition(pointF2.x / f);
                                                text.setLine(bVar.b.y / f2, 0);
                                            }
                                            Cue build = text.build();
                                            int e = e(h2, arrayList2, arrayList);
                                            for (int e2 = e(h, arrayList2, arrayList); e2 < e; e2++) {
                                                ((List) arrayList.get(e2)).add(build);
                                            }
                                            ssaDecoder = this;
                                            parsableByteArray2 = parsableByteArray;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                parsableByteArray = parsableByteArray2;
                ssaDecoder = this;
                parsableByteArray2 = parsableByteArray;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x007a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x014a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g(com.google.android.exoplayer2.util.ParsableByteArray r15) {
        /*
        // Method dump skipped, instructions count: 365
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.ssa.SsaDecoder.g(com.google.android.exoplayer2.util.ParsableByteArray):void");
    }

    public SsaDecoder(@Nullable List<byte[]> list) {
        super("SsaDecoder");
        this.r = -3.4028235E38f;
        this.s = -3.4028235E38f;
        if (list == null || list.isEmpty()) {
            this.o = false;
            this.p = null;
            return;
        }
        this.o = true;
        String fromUtf8Bytes = Util.fromUtf8Bytes(list.get(0));
        Assertions.checkArgument(fromUtf8Bytes.startsWith("Format:"));
        this.p = (a) Assertions.checkNotNull(a.a(fromUtf8Bytes));
        g(new ParsableByteArray(list.get(1)));
    }
}
