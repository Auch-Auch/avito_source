package com.google.android.exoplayer2.metadata.id3;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.metadata.SimpleMetadataDecoder;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import org.spongycastle.asn1.cmc.BodyPartID;
public final class Id3Decoder extends SimpleMetadataDecoder {
    public static final int ID3_HEADER_LENGTH = 10;
    public static final int ID3_TAG = 4801587;
    public static final FramePredicate NO_FRAMES_PREDICATE = a2.j.b.b.w0.b.a.a;
    @Nullable
    public final FramePredicate a;

    public interface FramePredicate {
        boolean evaluate(int i, int i2, int i3, int i4, int i5);
    }

    public static final class a {
        public final int a;
        public final boolean b;
        public final int c;

        public a(int i, boolean z, int i2) {
            this.a = i;
            this.b = z;
            this.c = i2;
        }
    }

    public Id3Decoder() {
        this(null);
    }

    public static byte[] a(byte[] bArr, int i, int i2) {
        if (i2 <= i) {
            return Util.EMPTY_BYTE_ARRAY;
        }
        return Arrays.copyOfRange(bArr, i, i2);
    }

    public static ApicFrame b(ParsableByteArray parsableByteArray, int i, int i2) throws UnsupportedEncodingException {
        String str;
        int i3;
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String p = p(readUnsignedByte);
        int i4 = i - 1;
        byte[] bArr = new byte[i4];
        parsableByteArray.readBytes(bArr, 0, i4);
        if (i2 == 2) {
            StringBuilder L = a2.b.a.a.a.L("image/");
            L.append(Util.toLowerInvariant(new String(bArr, 0, 3, "ISO-8859-1")));
            str = L.toString();
            if ("image/jpg".equals(str)) {
                str = "image/jpeg";
            }
            i3 = 2;
        } else {
            int s = s(bArr, 0);
            String lowerInvariant = Util.toLowerInvariant(new String(bArr, 0, s, "ISO-8859-1"));
            if (lowerInvariant.indexOf(47) == -1) {
                i3 = s;
                str = a2.b.a.a.a.c3("image/", lowerInvariant);
            } else {
                i3 = s;
                str = lowerInvariant;
            }
        }
        int i5 = i3 + 2;
        int r = r(bArr, i5, readUnsignedByte);
        return new ApicFrame(str, new String(bArr, i5, r - i5, p), bArr[i3 + 1] & 255, a(bArr, o(readUnsignedByte) + r, i4));
    }

    public static ChapterFrame c(ParsableByteArray parsableByteArray, int i, int i2, boolean z, int i3, @Nullable FramePredicate framePredicate) throws UnsupportedEncodingException {
        int position = parsableByteArray.getPosition();
        int s = s(parsableByteArray.getData(), position);
        String str = new String(parsableByteArray.getData(), position, s - position, "ISO-8859-1");
        parsableByteArray.setPosition(s + 1);
        int readInt = parsableByteArray.readInt();
        int readInt2 = parsableByteArray.readInt();
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        long j = readUnsignedInt == BodyPartID.bodyIdMax ? -1 : readUnsignedInt;
        long readUnsignedInt2 = parsableByteArray.readUnsignedInt();
        long j2 = readUnsignedInt2 == BodyPartID.bodyIdMax ? -1 : readUnsignedInt2;
        ArrayList arrayList = new ArrayList();
        int i4 = position + i;
        while (parsableByteArray.getPosition() < i4) {
            Id3Frame f = f(i2, parsableByteArray, z, i3, framePredicate);
            if (f != null) {
                arrayList.add(f);
            }
        }
        return new ChapterFrame(str, readInt, readInt2, j, j2, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    public static ChapterTocFrame d(ParsableByteArray parsableByteArray, int i, int i2, boolean z, int i3, @Nullable FramePredicate framePredicate) throws UnsupportedEncodingException {
        int position = parsableByteArray.getPosition();
        int s = s(parsableByteArray.getData(), position);
        String str = new String(parsableByteArray.getData(), position, s - position, "ISO-8859-1");
        parsableByteArray.setPosition(s + 1);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        boolean z2 = (readUnsignedByte & 2) != 0;
        boolean z3 = (readUnsignedByte & 1) != 0;
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        String[] strArr = new String[readUnsignedByte2];
        for (int i4 = 0; i4 < readUnsignedByte2; i4++) {
            int position2 = parsableByteArray.getPosition();
            int s2 = s(parsableByteArray.getData(), position2);
            strArr[i4] = new String(parsableByteArray.getData(), position2, s2 - position2, "ISO-8859-1");
            parsableByteArray.setPosition(s2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i5 = position + i;
        while (parsableByteArray.getPosition() < i5) {
            Id3Frame f = f(i2, parsableByteArray, z, i3, framePredicate);
            if (f != null) {
                arrayList.add(f);
            }
        }
        return new ChapterTocFrame(str, z2, z3, strArr, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    @Nullable
    public static CommentFrame e(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        if (i < 4) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String p = p(readUnsignedByte);
        byte[] bArr = new byte[3];
        parsableByteArray.readBytes(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i2 = i - 4;
        byte[] bArr2 = new byte[i2];
        parsableByteArray.readBytes(bArr2, 0, i2);
        int r = r(bArr2, 0, readUnsignedByte);
        String str2 = new String(bArr2, 0, r, p);
        int o = o(readUnsignedByte) + r;
        return new CommentFrame(str, str2, j(bArr2, o, r(bArr2, o, readUnsignedByte), p));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:130:0x018d, code lost:
        if (r13 == 67) goto L_0x018f;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.exoplayer2.metadata.id3.Id3Frame f(int r18, com.google.android.exoplayer2.util.ParsableByteArray r19, boolean r20, int r21, @androidx.annotation.Nullable com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate r22) {
        /*
        // Method dump skipped, instructions count: 567
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.id3.Id3Decoder.f(int, com.google.android.exoplayer2.util.ParsableByteArray, boolean, int, com.google.android.exoplayer2.metadata.id3.Id3Decoder$FramePredicate):com.google.android.exoplayer2.metadata.id3.Id3Frame");
    }

    public static GeobFrame g(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String p = p(readUnsignedByte);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        int s = s(bArr, 0);
        String str = new String(bArr, 0, s, "ISO-8859-1");
        int i3 = s + 1;
        int r = r(bArr, i3, readUnsignedByte);
        String j = j(bArr, i3, r, p);
        int o = o(readUnsignedByte) + r;
        int r2 = r(bArr, o, readUnsignedByte);
        return new GeobFrame(str, j, j(bArr, o, r2, p), a(bArr, o(readUnsignedByte) + r2, i2));
    }

    public static MlltFrame h(ParsableByteArray parsableByteArray, int i) {
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int readUnsignedInt24 = parsableByteArray.readUnsignedInt24();
        int readUnsignedInt242 = parsableByteArray.readUnsignedInt24();
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        ParsableBitArray parsableBitArray = new ParsableBitArray();
        parsableBitArray.reset(parsableByteArray);
        int i2 = ((i - 10) * 8) / (readUnsignedByte + readUnsignedByte2);
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int readBits = parsableBitArray.readBits(readUnsignedByte);
            int readBits2 = parsableBitArray.readBits(readUnsignedByte2);
            iArr[i3] = readBits;
            iArr2[i3] = readBits2;
        }
        return new MlltFrame(readUnsignedShort, readUnsignedInt24, readUnsignedInt242, iArr, iArr2);
    }

    public static PrivFrame i(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        parsableByteArray.readBytes(bArr, 0, i);
        int s = s(bArr, 0);
        return new PrivFrame(new String(bArr, 0, s, "ISO-8859-1"), a(bArr, s + 1, i));
    }

    public static String j(byte[] bArr, int i, int i2, String str) throws UnsupportedEncodingException {
        return (i2 <= i || i2 > bArr.length) ? "" : new String(bArr, i, i2 - i, str);
    }

    @Nullable
    public static TextInformationFrame k(ParsableByteArray parsableByteArray, int i, String str) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String p = p(readUnsignedByte);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        return new TextInformationFrame(str, null, new String(bArr, 0, r(bArr, 0, readUnsignedByte), p));
    }

    @Nullable
    public static TextInformationFrame l(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String p = p(readUnsignedByte);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        int r = r(bArr, 0, readUnsignedByte);
        String str = new String(bArr, 0, r, p);
        int o = o(readUnsignedByte) + r;
        return new TextInformationFrame("TXXX", str, j(bArr, o, r(bArr, o, readUnsignedByte), p));
    }

    public static UrlLinkFrame m(ParsableByteArray parsableByteArray, int i, String str) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        parsableByteArray.readBytes(bArr, 0, i);
        return new UrlLinkFrame(str, null, new String(bArr, 0, s(bArr, 0), "ISO-8859-1"));
    }

    @Nullable
    public static UrlLinkFrame n(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String p = p(readUnsignedByte);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        int r = r(bArr, 0, readUnsignedByte);
        String str = new String(bArr, 0, r, p);
        int o = o(readUnsignedByte) + r;
        return new UrlLinkFrame("WXXX", str, j(bArr, o, s(bArr, o), "ISO-8859-1"));
    }

    public static int o(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    public static String p(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "ISO-8859-1" : "UTF-8" : "UTF-16BE" : C.UTF16_NAME;
    }

    public static String q(int i, int i2, int i3, int i4, int i5) {
        if (i == 2) {
            return String.format(Locale.US, "%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        }
        return String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    public static int r(byte[] bArr, int i, int i2) {
        int s = s(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return s;
        }
        while (s < bArr.length - 1) {
            if (s % 2 == 0 && bArr[s + 1] == 0) {
                return s;
            }
            s = s(bArr, s + 1);
        }
        return bArr.length;
    }

    public static int s(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    public static int t(ParsableByteArray parsableByteArray, int i) {
        byte[] data = parsableByteArray.getData();
        int position = parsableByteArray.getPosition();
        int i2 = position;
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= position + i) {
                return i;
            }
            if ((data[i2] & 255) == 255 && data[i3] == 0) {
                System.arraycopy(data, i2 + 2, data, i3, (i - (i2 - position)) - 2);
                i--;
            }
            i2 = i3;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0076, code lost:
        if ((r10 & 1) != 0) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0084, code lost:
        if ((r10 & 128) != 0) goto L_0x0089;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean u(com.google.android.exoplayer2.util.ParsableByteArray r18, int r19, int r20, boolean r21) {
        /*
            r1 = r18
            r0 = r19
            int r2 = r18.getPosition()
        L_0x0008:
            int r3 = r18.bytesLeft()     // Catch:{ all -> 0x00ad }
            r4 = 1
            r5 = r20
            if (r3 < r5) goto L_0x00a9
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L_0x0022
            int r7 = r18.readInt()     // Catch:{ all -> 0x00ad }
            long r8 = r18.readUnsignedInt()     // Catch:{ all -> 0x00ad }
            int r10 = r18.readUnsignedShort()     // Catch:{ all -> 0x00ad }
            goto L_0x002c
        L_0x0022:
            int r7 = r18.readUnsignedInt24()     // Catch:{ all -> 0x00ad }
            int r8 = r18.readUnsignedInt24()     // Catch:{ all -> 0x00ad }
            long r8 = (long) r8
            r10 = 0
        L_0x002c:
            r11 = 0
            if (r7 != 0) goto L_0x003a
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L_0x003a
            if (r10 != 0) goto L_0x003a
            r1.setPosition(r2)
            return r4
        L_0x003a:
            r7 = 4
            if (r0 != r7) goto L_0x006b
            if (r21 != 0) goto L_0x006b
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 == 0) goto L_0x004b
            r1.setPosition(r2)
            return r6
        L_0x004b:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 16
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 14
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 24
            long r8 = r8 >> r15
            long r8 = r8 & r11
            r11 = 21
            long r8 = r8 << r11
            long r8 = r8 | r13
        L_0x006b:
            if (r0 != r7) goto L_0x0079
            r3 = r10 & 64
            if (r3 == 0) goto L_0x0073
            r3 = 1
            goto L_0x0074
        L_0x0073:
            r3 = 0
        L_0x0074:
            r7 = r10 & 1
            if (r7 == 0) goto L_0x0088
            goto L_0x0089
        L_0x0079:
            if (r0 != r3) goto L_0x0087
            r3 = r10 & 32
            if (r3 == 0) goto L_0x0081
            r3 = 1
            goto L_0x0082
        L_0x0081:
            r3 = 0
        L_0x0082:
            r7 = r10 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x0088
            goto L_0x0089
        L_0x0087:
            r3 = 0
        L_0x0088:
            r4 = 0
        L_0x0089:
            if (r4 == 0) goto L_0x008d
            int r3 = r3 + 4
        L_0x008d:
            long r3 = (long) r3
            int r7 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r7 >= 0) goto L_0x0096
            r1.setPosition(r2)
            return r6
        L_0x0096:
            int r3 = r18.bytesLeft()
            long r3 = (long) r3
            int r7 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r7 >= 0) goto L_0x00a3
            r1.setPosition(r2)
            return r6
        L_0x00a3:
            int r3 = (int) r8
            r1.skipBytes(r3)
            goto L_0x0008
        L_0x00a9:
            r1.setPosition(r2)
            return r4
        L_0x00ad:
            r0 = move-exception
            r1.setPosition(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.id3.Id3Decoder.u(com.google.android.exoplayer2.util.ParsableByteArray, int, int, boolean):boolean");
    }

    @Override // com.google.android.exoplayer2.metadata.SimpleMetadataDecoder
    @Nullable
    public Metadata decode(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        return decode(byteBuffer.array(), byteBuffer.limit());
    }

    public Id3Decoder(@Nullable FramePredicate framePredicate) {
        this.a = framePredicate;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b6 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b7  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.metadata.Metadata decode(byte[] r13, int r14) {
        /*
        // Method dump skipped, instructions count: 271
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.id3.Id3Decoder.decode(byte[], int):com.google.android.exoplayer2.metadata.Metadata");
    }
}
