package com.google.android.exoplayer2.source.hls.playlist;

import android.util.Base64;
import androidx.annotation.Nullable;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
public final class HlsPlaylistParser implements ParsingLoadable.Parser<HlsPlaylist> {
    public static final Pattern A = Pattern.compile("LANGUAGE=\"(.+?)\"");
    public static final Pattern B = Pattern.compile("NAME=\"(.+?)\"");
    public static final Pattern C = Pattern.compile("GROUP-ID=\"(.+?)\"");
    public static final Pattern D = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
    public static final Pattern E = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    public static final Pattern F = a("AUTOSELECT");
    public static final Pattern G = a(MessengerShareContentUtility.PREVIEW_DEFAULT);
    public static final Pattern H = a("FORCED");
    public static final Pattern I = Pattern.compile("VALUE=\"(.+?)\"");
    public static final Pattern J = Pattern.compile("IMPORT=\"(.+?)\"");
    public static final Pattern K = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");
    public static final Pattern b = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
    public static final Pattern c = Pattern.compile("VIDEO=\"(.+?)\"");
    public static final Pattern d = Pattern.compile("AUDIO=\"(.+?)\"");
    public static final Pattern e = Pattern.compile("SUBTITLES=\"(.+?)\"");
    public static final Pattern f = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");
    public static final Pattern g = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
    public static final Pattern h = Pattern.compile("CHANNELS=\"(.+?)\"");
    public static final Pattern i = Pattern.compile("CODECS=\"(.+?)\"");
    public static final Pattern j = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    public static final Pattern k = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");
    public static final Pattern l = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    public static final Pattern m = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    public static final Pattern n = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    public static final Pattern o = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    public static final Pattern p = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    public static final Pattern q = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
    public static final Pattern r = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    public static final Pattern s = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    public static final Pattern t = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    public static final Pattern u = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
    public static final Pattern v = Pattern.compile("KEYFORMAT=\"(.+?)\"");
    public static final Pattern w = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
    public static final Pattern x = Pattern.compile("URI=\"(.+?)\"");
    public static final Pattern y = Pattern.compile("IV=([^,.*]+)");
    public static final Pattern z = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    public final HlsMasterPlaylist a;

    public static class a {
        public final BufferedReader a;
        public final Queue<String> b;
        @Nullable
        public String c;

        public a(Queue<String> queue, BufferedReader bufferedReader) {
            this.b = queue;
            this.a = bufferedReader;
        }

        @EnsuresNonNullIf(expression = {"next"}, result = true)
        public boolean a() throws IOException {
            String trim;
            if (this.c != null) {
                return true;
            }
            if (!this.b.isEmpty()) {
                this.c = (String) Assertions.checkNotNull(this.b.poll());
                return true;
            }
            do {
                String readLine = this.a.readLine();
                this.c = readLine;
                if (readLine == null) {
                    return false;
                }
                trim = readLine.trim();
                this.c = trim;
            } while (trim.isEmpty());
            return true;
        }

        public String b() throws IOException {
            if (a()) {
                String str = this.c;
                this.c = null;
                return str;
            }
            throw new NoSuchElementException();
        }
    }

    public HlsPlaylistParser() {
        this(HlsMasterPlaylist.EMPTY);
    }

    public static Pattern a(String str) {
        StringBuilder K2 = a2.b.a.a.a.K(str.length() + 9, str, "=(", "NO", "|");
        K2.append("YES");
        K2.append(")");
        return Pattern.compile(K2.toString());
    }

    @Nullable
    public static DrmInitData.SchemeData b(String str, String str2, Map<String, String> map) throws ParserException {
        String h2 = h(str, w, "1", map);
        if ("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(str2)) {
            String j2 = j(str, x, map);
            return new DrmInitData.SchemeData(C.WIDEVINE_UUID, "video/mp4", Base64.decode(j2.substring(j2.indexOf(44)), 0));
        } else if ("com.widevine".equals(str2)) {
            return new DrmInitData.SchemeData(C.WIDEVINE_UUID, "hls", Util.getUtf8Bytes(str));
        } else {
            if (!"com.microsoft.playready".equals(str2) || !"1".equals(h2)) {
                return null;
            }
            String j3 = j(str, x, map);
            byte[] decode = Base64.decode(j3.substring(j3.indexOf(44)), 0);
            UUID uuid = C.PLAYREADY_UUID;
            return new DrmInitData.SchemeData(uuid, "video/mp4", PsshAtomUtil.buildPsshAtom(uuid, decode));
        }
    }

    public static String c(String str) {
        return ("SAMPLE-AES-CENC".equals(str) || "SAMPLE-AES-CTR".equals(str)) ? C.CENC_TYPE_cenc : C.CENC_TYPE_cbcs;
    }

    public static int d(String str, Pattern pattern) throws ParserException {
        return Integer.parseInt(j(str, pattern, Collections.emptyMap()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist e(com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser.a r38, java.lang.String r39) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1338
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser.e(com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser$a, java.lang.String):com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist");
    }

    public static HlsMediaPlaylist f(HlsMasterPlaylist hlsMasterPlaylist, a aVar, String str) throws IOException {
        long j2;
        long j3;
        TreeMap treeMap;
        DrmInitData drmInitData;
        HlsMasterPlaylist hlsMasterPlaylist2 = hlsMasterPlaylist;
        boolean z2 = hlsMasterPlaylist2.hasIndependentSegments;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        TreeMap treeMap2 = new TreeMap();
        long j4 = C.TIME_UNSET;
        long j5 = -9223372036854775807L;
        boolean z3 = false;
        int i2 = 0;
        String str2 = null;
        String str3 = null;
        long j6 = 0;
        DrmInitData drmInitData2 = null;
        int i3 = 0;
        long j7 = 0;
        int i4 = 1;
        boolean z4 = false;
        long j8 = 0;
        String str4 = null;
        int i5 = 0;
        long j9 = 0;
        DrmInitData drmInitData3 = null;
        HlsMediaPlaylist.Segment segment = null;
        long j10 = 0;
        while (true) {
            String str5 = str3;
            long j11 = j6;
            int i6 = i3;
            long j12 = j7;
            boolean z5 = z4;
            String str6 = str4;
            int i7 = i5;
            HlsMediaPlaylist.Segment segment2 = segment;
            long j13 = -1;
            boolean z7 = false;
            long j14 = 0;
            String str7 = "";
            int i8 = i4;
            int i9 = i2;
            String str8 = str2;
            long j15 = j5;
            while (aVar.a()) {
                String b2 = aVar.b();
                if (b2.startsWith("#EXT")) {
                    arrayList2.add(b2);
                }
                if (b2.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                    String j16 = j(b2, n, hashMap);
                    if ("VOD".equals(j16)) {
                        i9 = 1;
                    } else if ("EVENT".equals(j16)) {
                        i9 = 2;
                    }
                } else if (b2.startsWith("#EXT-X-START")) {
                    j4 = (long) (Double.parseDouble(j(b2, r, Collections.emptyMap())) * 1000000.0d);
                } else if (b2.startsWith("#EXT-X-MAP")) {
                    String j17 = j(b2, x, hashMap);
                    String i10 = i(b2, t, hashMap);
                    if (i10 != null) {
                        String[] split = i10.split("@");
                        long parseLong = Long.parseLong(split[0]);
                        if (split.length > 1) {
                            j8 = Long.parseLong(split[1]);
                        }
                        j3 = j8;
                        j2 = parseLong;
                    } else {
                        j3 = j8;
                        j2 = j13;
                    }
                    if (str8 == null || str6 != null) {
                        segment2 = new HlsMediaPlaylist.Segment(j17, j3, j2, str8, str6);
                        j13 = -1;
                        z2 = z2;
                        z3 = z3;
                        j8 = 0;
                    } else {
                        throw new ParserException("The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128.");
                    }
                } else {
                    if (b2.startsWith("#EXT-X-TARGETDURATION")) {
                        j15 = 1000000 * ((long) d(b2, l));
                    } else if (b2.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                        j12 = Long.parseLong(j(b2, o, Collections.emptyMap()));
                        j9 = j12;
                    } else if (b2.startsWith("#EXT-X-VERSION")) {
                        i8 = d(b2, m);
                    } else {
                        if (b2.startsWith("#EXT-X-DEFINE")) {
                            String i11 = i(b2, J, hashMap);
                            if (i11 != null) {
                                String str9 = hlsMasterPlaylist2.variableDefinitions.get(i11);
                                if (str9 != null) {
                                    hashMap.put(i11, str9);
                                }
                            } else {
                                hashMap.put(j(b2, B, hashMap), j(b2, I, hashMap));
                            }
                        } else if (b2.startsWith("#EXTINF")) {
                            str7 = h(b2, q, "", hashMap);
                            j14 = (long) (Double.parseDouble(j(b2, p, Collections.emptyMap())) * 1000000.0d);
                        } else if (b2.startsWith("#EXT-X-KEY")) {
                            String j18 = j(b2, u, hashMap);
                            String h2 = h(b2, v, "identity", hashMap);
                            if ("NONE".equals(j18)) {
                                treeMap2.clear();
                                z3 = z3;
                                str6 = null;
                            } else {
                                str6 = i(b2, y, hashMap);
                                if (!"identity".equals(h2)) {
                                    if (str5 == null) {
                                        str5 = c(j18);
                                    }
                                    DrmInitData.SchemeData b3 = b(b2, h2, hashMap);
                                    if (b3 != null) {
                                        treeMap2.put(h2, b3);
                                        z3 = z3;
                                    }
                                } else if ("AES-128".equals(j18)) {
                                    str8 = j(b2, x, hashMap);
                                }
                                z3 = z3;
                                str8 = null;
                                hlsMasterPlaylist2 = hlsMasterPlaylist;
                                z2 = z2;
                            }
                            str8 = null;
                            drmInitData3 = null;
                            hlsMasterPlaylist2 = hlsMasterPlaylist;
                            z2 = z2;
                        } else if (b2.startsWith("#EXT-X-BYTERANGE")) {
                            String[] split2 = j(b2, s, hashMap).split("@");
                            j13 = Long.parseLong(split2[0]);
                            if (split2.length > 1) {
                                j8 = Long.parseLong(split2[1]);
                            }
                        } else {
                            if (b2.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                                i6 = Integer.parseInt(b2.substring(b2.indexOf(58) + 1));
                                z3 = true;
                            } else if (b2.equals("#EXT-X-DISCONTINUITY")) {
                                i7++;
                            } else if (!b2.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                                z2 = true;
                                if (b2.equals("#EXT-X-GAP")) {
                                    hlsMasterPlaylist2 = hlsMasterPlaylist;
                                    z2 = z2;
                                    z3 = z3;
                                    z7 = true;
                                } else if (b2.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                                    hlsMasterPlaylist2 = hlsMasterPlaylist;
                                    z3 = z3;
                                } else if (b2.equals("#EXT-X-ENDLIST")) {
                                    hlsMasterPlaylist2 = hlsMasterPlaylist;
                                    z2 = z2;
                                    z3 = z3;
                                    z5 = true;
                                } else if (!b2.startsWith("#")) {
                                    String hexString = str8 == null ? null : str6 != null ? str6 : Long.toHexString(j9);
                                    long j19 = j9 + 1;
                                    int i12 = (j13 > -1 ? 1 : (j13 == -1 ? 0 : -1));
                                    if (i12 == 0) {
                                        j8 = 0;
                                    }
                                    if (drmInitData3 != null || treeMap2.isEmpty()) {
                                        treeMap = treeMap2;
                                        drmInitData = drmInitData3;
                                    } else {
                                        int i13 = 0;
                                        DrmInitData.SchemeData[] schemeDataArr = (DrmInitData.SchemeData[]) treeMap2.values().toArray(new DrmInitData.SchemeData[0]);
                                        drmInitData = new DrmInitData(str5, schemeDataArr);
                                        if (drmInitData2 == null) {
                                            DrmInitData.SchemeData[] schemeDataArr2 = new DrmInitData.SchemeData[schemeDataArr.length];
                                            treeMap = treeMap2;
                                            while (i13 < schemeDataArr.length) {
                                                schemeDataArr2[i13] = schemeDataArr[i13].copyWithData(null);
                                                i13++;
                                                schemeDataArr = schemeDataArr;
                                            }
                                            drmInitData2 = new DrmInitData(str5, schemeDataArr2);
                                        } else {
                                            treeMap = treeMap2;
                                        }
                                    }
                                    arrayList.add(new HlsMediaPlaylist.Segment(k(b2, hashMap), segment2, str7, j14, i7, j10, drmInitData, str8, hexString, j8, j13, z7));
                                    j10 += j14;
                                    if (i12 != 0) {
                                        j8 += j13;
                                    }
                                    hlsMasterPlaylist2 = hlsMasterPlaylist;
                                    str3 = str5;
                                    drmInitData3 = drmInitData;
                                    segment = segment2;
                                    j9 = j19;
                                    treeMap2 = treeMap;
                                    i4 = i8;
                                    j7 = j12;
                                    z4 = z5;
                                    i5 = i7;
                                    z2 = z2;
                                    z3 = z3;
                                    str4 = str6;
                                    i3 = i6;
                                    j6 = j11;
                                    i2 = i9;
                                    str2 = str8;
                                    j5 = j15;
                                }
                            } else if (j11 == 0) {
                                j11 = C.msToUs(Util.parseXsDateTime(b2.substring(b2.indexOf(58) + 1))) - j10;
                                z3 = z3;
                            }
                            hlsMasterPlaylist2 = hlsMasterPlaylist;
                            z2 = z2;
                        }
                        hlsMasterPlaylist2 = hlsMasterPlaylist;
                        treeMap2 = treeMap2;
                        z2 = z2;
                        z3 = z3;
                    }
                    z3 = z3;
                    hlsMasterPlaylist2 = hlsMasterPlaylist;
                    z2 = z2;
                }
            }
            return new HlsMediaPlaylist(i9, str, arrayList2, j4, j11, z3, i6, j12, i8, j15, z2, z5, j11 != 0, drmInitData2, arrayList);
        }
    }

    public static boolean g(String str, Pattern pattern, boolean z2) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? matcher.group(1).equals("YES") : z2;
    }

    public static String h(String str, Pattern pattern, String str2, Map<String, String> map) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str2 = matcher.group(1);
        }
        return (map.isEmpty() || str2 == null) ? str2 : k(str2, map);
    }

    @Nullable
    public static String i(String str, Pattern pattern, Map<String, String> map) {
        return h(str, pattern, null, map);
    }

    public static String j(String str, Pattern pattern, Map<String, String> map) throws ParserException {
        String h2 = h(str, pattern, null, map);
        if (h2 != null) {
            return h2;
        }
        String pattern2 = pattern.pattern();
        throw new ParserException(a2.b.a.a.a.t2(a2.b.a.a.a.q0(str, a2.b.a.a.a.q0(pattern2, 19)), "Couldn't match ", pattern2, " in ", str));
    }

    public static String k(String str, Map<String, String> map) {
        Matcher matcher = K.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String group = matcher.group(1);
            if (map.containsKey(group)) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(map.get(group)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public static int l(BufferedReader bufferedReader, boolean z2, int i2) throws IOException {
        while (i2 != -1 && Character.isWhitespace(i2) && (z2 || !Util.isLinebreak(i2))) {
            i2 = bufferedReader.read();
        }
        return i2;
    }

    public HlsPlaylistParser(HlsMasterPlaylist hlsMasterPlaylist) {
        this.a = hlsMasterPlaylist;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0050 A[Catch:{ all -> 0x00eb }, LOOP:1: B:18:0x0050->B:68:0x0050, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e3  */
    @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist parse(android.net.Uri r7, java.io.InputStream r8) throws java.io.IOException {
        /*
            r6 = this;
            java.io.BufferedReader r0 = new java.io.BufferedReader
            java.io.InputStreamReader r1 = new java.io.InputStreamReader
            r1.<init>(r8)
            r0.<init>(r1)
            java.util.ArrayDeque r8 = new java.util.ArrayDeque
            r8.<init>()
            int r1 = r0.read()     // Catch:{ all -> 0x00eb }
            r2 = 239(0xef, float:3.35E-43)
            r3 = 0
            if (r1 != r2) goto L_0x002d
            int r1 = r0.read()     // Catch:{ all -> 0x00eb }
            r2 = 187(0xbb, float:2.62E-43)
            if (r1 != r2) goto L_0x004e
            int r1 = r0.read()     // Catch:{ all -> 0x00eb }
            r2 = 191(0xbf, float:2.68E-43)
            if (r1 == r2) goto L_0x0029
            goto L_0x004e
        L_0x0029:
            int r1 = r0.read()     // Catch:{ all -> 0x00eb }
        L_0x002d:
            r2 = 1
            int r1 = l(r0, r2, r1)     // Catch:{ all -> 0x00eb }
            r2 = 7
            r4 = 0
        L_0x0034:
            if (r4 >= r2) goto L_0x0046
            java.lang.String r5 = "#EXTM3U"
            char r5 = r5.charAt(r4)     // Catch:{ all -> 0x00eb }
            if (r1 == r5) goto L_0x003f
            goto L_0x004e
        L_0x003f:
            int r1 = r0.read()     // Catch:{ all -> 0x00eb }
            int r4 = r4 + 1
            goto L_0x0034
        L_0x0046:
            int r1 = l(r0, r3, r1)     // Catch:{ all -> 0x00eb }
            boolean r3 = com.google.android.exoplayer2.util.Util.isLinebreak(r1)     // Catch:{ all -> 0x00eb }
        L_0x004e:
            if (r3 == 0) goto L_0x00e3
        L_0x0050:
            java.lang.String r1 = r0.readLine()     // Catch:{ all -> 0x00eb }
            if (r1 == 0) goto L_0x00d8
            java.lang.String r1 = r1.trim()     // Catch:{ all -> 0x00eb }
            boolean r2 = r1.isEmpty()     // Catch:{ all -> 0x00eb }
            if (r2 == 0) goto L_0x0061
            goto L_0x0050
        L_0x0061:
            java.lang.String r2 = "#EXT-X-STREAM-INF"
            boolean r2 = r1.startsWith(r2)     // Catch:{ all -> 0x00eb }
            if (r2 == 0) goto L_0x007d
            r8.add(r1)     // Catch:{ all -> 0x00eb }
            com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser$a r1 = new com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser$a     // Catch:{ all -> 0x00eb }
            r1.<init>(r8, r0)     // Catch:{ all -> 0x00eb }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00eb }
            com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist r7 = e(r1, r7)     // Catch:{ all -> 0x00eb }
            com.google.android.exoplayer2.util.Util.closeQuietly(r0)
            return r7
        L_0x007d:
            java.lang.String r2 = "#EXT-X-TARGETDURATION"
            boolean r2 = r1.startsWith(r2)
            if (r2 != 0) goto L_0x00c2
            java.lang.String r2 = "#EXT-X-MEDIA-SEQUENCE"
            boolean r2 = r1.startsWith(r2)
            if (r2 != 0) goto L_0x00c2
            java.lang.String r2 = "#EXTINF"
            boolean r2 = r1.startsWith(r2)
            if (r2 != 0) goto L_0x00c2
            java.lang.String r2 = "#EXT-X-KEY"
            boolean r2 = r1.startsWith(r2)
            if (r2 != 0) goto L_0x00c2
            java.lang.String r2 = "#EXT-X-BYTERANGE"
            boolean r2 = r1.startsWith(r2)
            if (r2 != 0) goto L_0x00c2
            java.lang.String r2 = "#EXT-X-DISCONTINUITY"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x00c2
            java.lang.String r2 = "#EXT-X-DISCONTINUITY-SEQUENCE"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x00c2
            java.lang.String r2 = "#EXT-X-ENDLIST"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x00be
            goto L_0x00c2
        L_0x00be:
            r8.add(r1)
            goto L_0x0050
        L_0x00c2:
            r8.add(r1)
            com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist r1 = r6.a
            com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser$a r2 = new com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser$a
            r2.<init>(r8, r0)
            java.lang.String r7 = r7.toString()
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist r7 = f(r1, r2, r7)
            com.google.android.exoplayer2.util.Util.closeQuietly(r0)
            return r7
        L_0x00d8:
            com.google.android.exoplayer2.util.Util.closeQuietly(r0)
            com.google.android.exoplayer2.ParserException r7 = new com.google.android.exoplayer2.ParserException
            java.lang.String r8 = "Failed to parse the playlist, could not identify any tags."
            r7.<init>(r8)
            throw r7
        L_0x00e3:
            com.google.android.exoplayer2.source.UnrecognizedInputFormatException r8 = new com.google.android.exoplayer2.source.UnrecognizedInputFormatException
            java.lang.String r1 = "Input does not start with the #EXTM3U header."
            r8.<init>(r1, r7)
            throw r8
        L_0x00eb:
            r7 = move-exception
            com.google.android.exoplayer2.util.Util.closeQuietly(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser.parse(android.net.Uri, java.io.InputStream):com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist");
    }
}
