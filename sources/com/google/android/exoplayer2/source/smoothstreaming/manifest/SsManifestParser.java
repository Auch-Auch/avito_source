package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
public class SsManifestParser implements ParsingLoadable.Parser<SsManifest> {
    public final XmlPullParserFactory a;

    public static class MissingFieldException extends ParserException {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public MissingFieldException(java.lang.String r3) {
            /*
                r2 = this;
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r0 = r3.length()
                java.lang.String r1 = "Missing required field: "
                if (r0 == 0) goto L_0x0011
                java.lang.String r3 = r1.concat(r3)
                goto L_0x0016
            L_0x0011:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r1)
            L_0x0016:
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.MissingFieldException.<init>(java.lang.String):void");
        }
    }

    public static abstract class a {
        public final String a;
        public final String b;
        @Nullable
        public final a c;
        public final List<Pair<String, Object>> d = new LinkedList();

        public a(@Nullable a aVar, String str, String str2) {
            this.c = aVar;
            this.a = str;
            this.b = str2;
        }

        public void a(Object obj) {
        }

        public abstract Object b();

        @Nullable
        public final Object c(String str) {
            for (int i = 0; i < this.d.size(); i++) {
                Pair<String, Object> pair = this.d.get(i);
                if (((String) pair.first).equals(str)) {
                    return pair.second;
                }
            }
            a aVar = this.c;
            if (aVar == null) {
                return null;
            }
            return aVar.c(str);
        }

        public boolean d(String str) {
            return false;
        }

        public final Object e(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
            boolean z = false;
            int i = 0;
            while (true) {
                int eventType = xmlPullParser.getEventType();
                a aVar = null;
                if (eventType == 1) {
                    return null;
                }
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if (this.b.equals(name)) {
                        k(xmlPullParser);
                        z = true;
                    } else if (z) {
                        if (i > 0) {
                            i++;
                        } else if (d(name)) {
                            k(xmlPullParser);
                        } else {
                            String str = this.a;
                            if ("QualityLevel".equals(name)) {
                                aVar = new c(this, str);
                            } else if ("Protection".equals(name)) {
                                aVar = new b(this, str);
                            } else if ("StreamIndex".equals(name)) {
                                aVar = new e(this, str);
                            }
                            if (aVar == null) {
                                i = 1;
                            } else {
                                a(aVar.e(xmlPullParser));
                            }
                        }
                    }
                } else if (eventType != 3) {
                    if (eventType == 4 && z && i == 0) {
                        l(xmlPullParser);
                    }
                } else if (!z) {
                    continue;
                } else if (i > 0) {
                    i--;
                } else {
                    String name2 = xmlPullParser.getName();
                    f(xmlPullParser);
                    if (!d(name2)) {
                        return b();
                    }
                }
                xmlPullParser.next();
            }
        }

        public void f(XmlPullParser xmlPullParser) {
        }

        public final int g(XmlPullParser xmlPullParser, String str, int i) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                return i;
            }
            try {
                return Integer.parseInt(attributeValue);
            } catch (NumberFormatException e) {
                throw new ParserException(e);
            }
        }

        public final long h(XmlPullParser xmlPullParser, String str, long j) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                return j;
            }
            try {
                return Long.parseLong(attributeValue);
            } catch (NumberFormatException e) {
                throw new ParserException(e);
            }
        }

        public final int i(XmlPullParser xmlPullParser, String str) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue != null) {
                try {
                    return Integer.parseInt(attributeValue);
                } catch (NumberFormatException e) {
                    throw new ParserException(e);
                }
            } else {
                throw new MissingFieldException(str);
            }
        }

        public final String j(XmlPullParser xmlPullParser, String str) throws MissingFieldException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue != null) {
                return attributeValue;
            }
            throw new MissingFieldException(str);
        }

        public abstract void k(XmlPullParser xmlPullParser) throws ParserException;

        public void l(XmlPullParser xmlPullParser) {
        }
    }

    public static class b extends a {
        public boolean e;
        public UUID f;
        public byte[] g;

        public b(a aVar, String str) {
            super(aVar, str, "Protection");
        }

        public static void m(byte[] bArr, int i, int i2) {
            byte b = bArr[i];
            bArr[i] = bArr[i2];
            bArr[i2] = b;
        }

        /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x006d: APUT  
          (r6v0 com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox[])
          (0 ??[int, short, byte, char])
          (wrap: com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox : 0x006a: CONSTRUCTOR  (r15v0 com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox) = true, (null java.lang.String), (8 int), (r11v0 byte[]), (0 int), (0 int), (null byte[]) call: com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox.<init>(boolean, java.lang.String, int, byte[], int, int, byte[]):void type: CONSTRUCTOR)
         */
        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object b() {
            UUID uuid = this.f;
            byte[] buildPsshAtom = PsshAtomUtil.buildPsshAtom(uuid, this.g);
            byte[] bArr = this.g;
            TrackEncryptionBox[] trackEncryptionBoxArr = new TrackEncryptionBox[1];
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bArr.length; i += 2) {
                sb.append((char) bArr[i]);
            }
            String sb2 = sb.toString();
            byte[] decode = Base64.decode(sb2.substring(sb2.indexOf("<KID>") + 5, sb2.indexOf("</KID>")), 0);
            m(decode, 0, 3);
            byte b = decode[1];
            decode[1] = decode[2];
            decode[2] = b;
            byte b2 = decode[4];
            decode[4] = decode[5];
            decode[5] = b2;
            byte b3 = decode[6];
            decode[6] = decode[7];
            decode[7] = b3;
            trackEncryptionBoxArr[0] = new TrackEncryptionBox(true, null, 8, decode, 0, 0, null);
            return new SsManifest.ProtectionElement(uuid, buildPsshAtom, trackEncryptionBoxArr);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public boolean d(String str) {
            return "ProtectionHeader".equals(str);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void f(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.e = false;
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void k(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.e = true;
                String attributeValue = xmlPullParser.getAttributeValue(null, "SystemID");
                if (attributeValue.charAt(0) == '{' && attributeValue.charAt(attributeValue.length() - 1) == '}') {
                    attributeValue = attributeValue.substring(1, attributeValue.length() - 1);
                }
                this.f = UUID.fromString(attributeValue);
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void l(XmlPullParser xmlPullParser) {
            if (this.e) {
                this.g = Base64.decode(xmlPullParser.getText(), 0);
            }
        }
    }

    public static class c extends a {
        public Format e;

        public c(a aVar, String str) {
            super(aVar, str, "QualityLevel");
        }

        public static List<byte[]> m(String str) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                byte[] bytesFromHexString = Util.getBytesFromHexString(str);
                byte[][] splitNalUnits = CodecSpecificDataUtil.splitNalUnits(bytesFromHexString);
                if (splitNalUnits == null) {
                    arrayList.add(bytesFromHexString);
                } else {
                    Collections.addAll(arrayList, splitNalUnits);
                }
            }
            return arrayList;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object b() {
            return this.e;
        }

        /* JADX WARNING: Removed duplicated region for block: B:51:0x00f0  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0117  */
        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void k(org.xmlpull.v1.XmlPullParser r19) throws com.google.android.exoplayer2.ParserException {
            /*
            // Method dump skipped, instructions count: 429
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.c.k(org.xmlpull.v1.XmlPullParser):void");
        }
    }

    public static class d extends a {
        public final List<SsManifest.StreamElement> e = new LinkedList();
        public int f;
        public int g;
        public long h;
        public long i;
        public long j;
        public int k = -1;
        public boolean l;
        @Nullable
        public SsManifest.ProtectionElement m = null;

        public d(a aVar, String str) {
            super(null, str, "SmoothStreamingMedia");
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void a(Object obj) {
            if (obj instanceof SsManifest.StreamElement) {
                this.e.add((SsManifest.StreamElement) obj);
            } else if (obj instanceof SsManifest.ProtectionElement) {
                Assertions.checkState(this.m == null);
                this.m = (SsManifest.ProtectionElement) obj;
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object b() {
            int size = this.e.size();
            SsManifest.StreamElement[] streamElementArr = new SsManifest.StreamElement[size];
            this.e.toArray(streamElementArr);
            SsManifest.ProtectionElement protectionElement = this.m;
            if (protectionElement != null) {
                DrmInitData drmInitData = new DrmInitData(new DrmInitData.SchemeData(protectionElement.uuid, "video/mp4", protectionElement.data));
                for (int i2 = 0; i2 < size; i2++) {
                    SsManifest.StreamElement streamElement = streamElementArr[i2];
                    int i3 = streamElement.type;
                    if (i3 == 2 || i3 == 1) {
                        Format[] formatArr = streamElement.formats;
                        for (int i4 = 0; i4 < formatArr.length; i4++) {
                            formatArr[i4] = formatArr[i4].copyWithDrmInitData(drmInitData);
                        }
                    }
                }
            }
            return new SsManifest(this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, streamElementArr);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void k(XmlPullParser xmlPullParser) throws ParserException {
            this.f = i(xmlPullParser, "MajorVersion");
            this.g = i(xmlPullParser, "MinorVersion");
            this.h = h(xmlPullParser, "TimeScale", 10000000);
            String attributeValue = xmlPullParser.getAttributeValue(null, "Duration");
            if (attributeValue != null) {
                try {
                    this.i = Long.parseLong(attributeValue);
                    this.j = h(xmlPullParser, "DVRWindowLength", 0);
                    this.k = g(xmlPullParser, "LookaheadCount", -1);
                    boolean z = false;
                    String attributeValue2 = xmlPullParser.getAttributeValue(null, "IsLive");
                    if (attributeValue2 != null) {
                        z = Boolean.parseBoolean(attributeValue2);
                    }
                    this.l = z;
                    this.d.add(Pair.create("TimeScale", Long.valueOf(this.h)));
                } catch (NumberFormatException e2) {
                    throw new ParserException(e2);
                }
            } else {
                throw new MissingFieldException("Duration");
            }
        }
    }

    public static class e extends a {
        public final String e;
        public final List<Format> f = new LinkedList();
        public int g;
        public String h;
        public long i;
        public String j;
        public String k;
        public int l;
        public int m;
        public int n;
        public int o;
        public String p;
        public ArrayList<Long> q;
        public long r;

        public e(a aVar, String str) {
            super(aVar, str, "StreamIndex");
            this.e = str;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void a(Object obj) {
            if (obj instanceof Format) {
                this.f.add((Format) obj);
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object b() {
            Format[] formatArr = new Format[this.f.size()];
            this.f.toArray(formatArr);
            return new SsManifest.StreamElement(this.e, this.k, this.g, this.h, this.i, this.j, this.l, this.m, this.n, this.o, this.p, formatArr, this.q, this.r);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public boolean d(String str) {
            return "c".equals(str);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void k(XmlPullParser xmlPullParser) throws ParserException {
            int i2 = 1;
            if ("c".equals(xmlPullParser.getName())) {
                int size = this.q.size();
                long h2 = h(xmlPullParser, "t", C.TIME_UNSET);
                if (h2 == C.TIME_UNSET) {
                    if (size == 0) {
                        h2 = 0;
                    } else if (this.r != -1) {
                        h2 = this.r + this.q.get(size - 1).longValue();
                    } else {
                        throw new ParserException("Unable to infer start time");
                    }
                }
                this.q.add(Long.valueOf(h2));
                this.r = h(xmlPullParser, "d", C.TIME_UNSET);
                long h3 = h(xmlPullParser, "r", 1);
                if (h3 <= 1 || this.r != C.TIME_UNSET) {
                    while (true) {
                        long j2 = (long) i2;
                        if (j2 < h3) {
                            this.q.add(Long.valueOf((this.r * j2) + h2));
                            i2++;
                        } else {
                            return;
                        }
                    }
                } else {
                    throw new ParserException("Repeated chunk with unspecified duration");
                }
            } else {
                String attributeValue = xmlPullParser.getAttributeValue(null, "Type");
                if (attributeValue != null) {
                    if (!"audio".equalsIgnoreCase(attributeValue)) {
                        if ("video".equalsIgnoreCase(attributeValue)) {
                            i2 = 2;
                        } else if ("text".equalsIgnoreCase(attributeValue)) {
                            i2 = 3;
                        } else {
                            throw new ParserException(a2.b.a.a.a.s2(attributeValue.length() + 19, "Invalid key value[", attributeValue, "]"));
                        }
                    }
                    this.g = i2;
                    this.d.add(Pair.create("Type", Integer.valueOf(i2)));
                    if (this.g == 3) {
                        this.h = j(xmlPullParser, "Subtype");
                    } else {
                        this.h = xmlPullParser.getAttributeValue(null, "Subtype");
                    }
                    this.d.add(Pair.create("Subtype", this.h));
                    this.j = xmlPullParser.getAttributeValue(null, "Name");
                    this.k = j(xmlPullParser, "Url");
                    this.l = g(xmlPullParser, "MaxWidth", -1);
                    this.m = g(xmlPullParser, "MaxHeight", -1);
                    this.n = g(xmlPullParser, "DisplayWidth", -1);
                    this.o = g(xmlPullParser, "DisplayHeight", -1);
                    String attributeValue2 = xmlPullParser.getAttributeValue(null, "Language");
                    this.p = attributeValue2;
                    this.d.add(Pair.create("Language", attributeValue2));
                    long g2 = (long) g(xmlPullParser, "TimeScale", -1);
                    this.i = g2;
                    if (g2 == -1) {
                        this.i = ((Long) c("TimeScale")).longValue();
                    }
                    this.q = new ArrayList<>();
                    return;
                }
                throw new MissingFieldException("Type");
            }
        }
    }

    public SsManifestParser() {
        try {
            this.a = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
    public SsManifest parse(Uri uri, InputStream inputStream) throws IOException {
        try {
            XmlPullParser newPullParser = this.a.newPullParser();
            newPullParser.setInput(inputStream, null);
            return (SsManifest) new d(null, uri.toString()).e(newPullParser);
        } catch (XmlPullParserException e2) {
            throw new ParserException(e2);
        }
    }
}
