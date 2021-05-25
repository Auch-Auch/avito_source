package a2.j.b.b.u0.j;

import a2.j.b.b.u0.j.e;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
public final class f {
    public static final byte[] a = Util.getUtf8Bytes("OpusHead");

    public interface a {
        int a();

        int b();

        int c();
    }

    public static final class b implements a {
        public final int a;
        public final int b;
        public final ParsableByteArray c;

        public b(e.b bVar) {
            ParsableByteArray parsableByteArray = bVar.b;
            this.c = parsableByteArray;
            parsableByteArray.setPosition(12);
            int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            this.a = readUnsignedIntToInt == 0 ? -1 : readUnsignedIntToInt;
            this.b = parsableByteArray.readUnsignedIntToInt();
        }

        @Override // a2.j.b.b.u0.j.f.a
        public int a() {
            int i = this.a;
            return i == -1 ? this.c.readUnsignedIntToInt() : i;
        }

        @Override // a2.j.b.b.u0.j.f.a
        public int b() {
            return this.b;
        }

        @Override // a2.j.b.b.u0.j.f.a
        public int c() {
            return this.a;
        }
    }

    public static final class c implements a {
        public final ParsableByteArray a;
        public final int b;
        public final int c;
        public int d;
        public int e;

        public c(e.b bVar) {
            ParsableByteArray parsableByteArray = bVar.b;
            this.a = parsableByteArray;
            parsableByteArray.setPosition(12);
            this.c = parsableByteArray.readUnsignedIntToInt() & 255;
            this.b = parsableByteArray.readUnsignedIntToInt();
        }

        @Override // a2.j.b.b.u0.j.f.a
        public int a() {
            int i = this.c;
            if (i == 8) {
                return this.a.readUnsignedByte();
            }
            if (i == 16) {
                return this.a.readUnsignedShort();
            }
            int i2 = this.d;
            this.d = i2 + 1;
            if (i2 % 2 != 0) {
                return this.e & 15;
            }
            int readUnsignedByte = this.a.readUnsignedByte();
            this.e = readUnsignedByte;
            return (readUnsignedByte & 240) >> 4;
        }

        @Override // a2.j.b.b.u0.j.f.a
        public int b() {
            return this.b;
        }

        @Override // a2.j.b.b.u0.j.f.a
        public int c() {
            return -1;
        }
    }

    public static Pair<String, byte[]> a(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 8 + 4);
        parsableByteArray.skipBytes(1);
        b(parsableByteArray);
        parsableByteArray.skipBytes(2);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        if ((readUnsignedByte & 128) != 0) {
            parsableByteArray.skipBytes(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            parsableByteArray.skipBytes(parsableByteArray.readUnsignedShort());
        }
        if ((readUnsignedByte & 32) != 0) {
            parsableByteArray.skipBytes(2);
        }
        parsableByteArray.skipBytes(1);
        b(parsableByteArray);
        String mimeTypeFromMp4ObjectType = MimeTypes.getMimeTypeFromMp4ObjectType(parsableByteArray.readUnsignedByte());
        if (MimeTypes.AUDIO_MPEG.equals(mimeTypeFromMp4ObjectType) || MimeTypes.AUDIO_DTS.equals(mimeTypeFromMp4ObjectType) || MimeTypes.AUDIO_DTS_HD.equals(mimeTypeFromMp4ObjectType)) {
            return Pair.create(mimeTypeFromMp4ObjectType, null);
        }
        parsableByteArray.skipBytes(12);
        parsableByteArray.skipBytes(1);
        int b2 = b(parsableByteArray);
        byte[] bArr = new byte[b2];
        parsableByteArray.readBytes(bArr, 0, b2);
        return Pair.create(mimeTypeFromMp4ObjectType, bArr);
    }

    public static int b(ParsableByteArray parsableByteArray) {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i = readUnsignedByte & 127;
        while ((readUnsignedByte & 128) == 128) {
            readUnsignedByte = parsableByteArray.readUnsignedByte();
            i = (i << 7) | (readUnsignedByte & 127);
        }
        return i;
    }

    @Nullable
    public static Pair<Integer, TrackEncryptionBox> c(ParsableByteArray parsableByteArray, int i, int i2) {
        Pair<Integer, TrackEncryptionBox> pair;
        Integer num;
        TrackEncryptionBox trackEncryptionBox;
        int i3;
        int i4;
        byte[] bArr;
        int position = parsableByteArray.getPosition();
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int readInt = parsableByteArray.readInt();
            Assertions.checkState(readInt > 0, "childAtomSize should be positive");
            if (parsableByteArray.readInt() == 1936289382) {
                int i5 = position + 8;
                int i6 = -1;
                int i7 = 0;
                String str = null;
                Integer num2 = null;
                while (i5 - position < readInt) {
                    parsableByteArray.setPosition(i5);
                    int readInt2 = parsableByteArray.readInt();
                    int readInt3 = parsableByteArray.readInt();
                    if (readInt3 == 1718775137) {
                        num2 = Integer.valueOf(parsableByteArray.readInt());
                    } else if (readInt3 == 1935894637) {
                        parsableByteArray.skipBytes(4);
                        str = parsableByteArray.readString(4);
                    } else if (readInt3 == 1935894633) {
                        i6 = i5;
                        i7 = readInt2;
                    }
                    i5 += readInt2;
                }
                if (C.CENC_TYPE_cenc.equals(str) || C.CENC_TYPE_cbc1.equals(str) || C.CENC_TYPE_cens.equals(str) || C.CENC_TYPE_cbcs.equals(str)) {
                    Assertions.checkStateNotNull(num2, "frma atom is mandatory");
                    Assertions.checkState(i6 != -1, "schi atom is mandatory");
                    int i8 = i6 + 8;
                    while (true) {
                        if (i8 - i6 >= i7) {
                            num = num2;
                            trackEncryptionBox = null;
                            break;
                        }
                        parsableByteArray.setPosition(i8);
                        int readInt4 = parsableByteArray.readInt();
                        if (parsableByteArray.readInt() == 1952804451) {
                            int readInt5 = (parsableByteArray.readInt() >> 24) & 255;
                            parsableByteArray.skipBytes(1);
                            if (readInt5 == 0) {
                                parsableByteArray.skipBytes(1);
                                i4 = 0;
                                i3 = 0;
                            } else {
                                int readUnsignedByte = parsableByteArray.readUnsignedByte();
                                i4 = readUnsignedByte & 15;
                                i3 = (readUnsignedByte & 240) >> 4;
                            }
                            boolean z = parsableByteArray.readUnsignedByte() == 1;
                            int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                            byte[] bArr2 = new byte[16];
                            parsableByteArray.readBytes(bArr2, 0, 16);
                            if (!z || readUnsignedByte2 != 0) {
                                bArr = null;
                            } else {
                                int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                                byte[] bArr3 = new byte[readUnsignedByte3];
                                parsableByteArray.readBytes(bArr3, 0, readUnsignedByte3);
                                bArr = bArr3;
                            }
                            num = num2;
                            trackEncryptionBox = new TrackEncryptionBox(z, str, readUnsignedByte2, bArr2, i3, i4, bArr);
                        } else {
                            i8 += readInt4;
                        }
                    }
                    pair = Pair.create(num, (TrackEncryptionBox) Assertions.checkStateNotNull(trackEncryptionBox, "tenc atom is mandatory"));
                } else {
                    pair = null;
                }
                if (pair != null) {
                    return pair;
                }
            }
            position += readInt;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:143:0x0367  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x036a  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0392  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x03a3  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01dd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static a2.j.b.b.u0.j.l d(com.google.android.exoplayer2.extractor.mp4.Track r39, a2.j.b.b.u0.j.e.a r40, com.google.android.exoplayer2.extractor.GaplessInfoHolder r41) throws com.google.android.exoplayer2.ParserException {
        /*
        // Method dump skipped, instructions count: 1554
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.j.b.b.u0.j.f.d(com.google.android.exoplayer2.extractor.mp4.Track, a2.j.b.b.u0.j.e$a, com.google.android.exoplayer2.extractor.GaplessInfoHolder):a2.j.b.b.u0.j.l");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00fb, code lost:
        if (r8 == 0) goto L_0x00fd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x055a  */
    /* JADX WARNING: Removed duplicated region for block: B:501:0x0a07  */
    /* JADX WARNING: Removed duplicated region for block: B:502:0x0a0a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<a2.j.b.b.u0.j.l> e(a2.j.b.b.u0.j.e.a r45, com.google.android.exoplayer2.extractor.GaplessInfoHolder r46, long r47, @androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmInitData r49, boolean r50, boolean r51, com.google.common.base.Function<com.google.android.exoplayer2.extractor.mp4.Track, com.google.android.exoplayer2.extractor.mp4.Track> r52) throws com.google.android.exoplayer2.ParserException {
        /*
        // Method dump skipped, instructions count: 2672
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.j.b.b.u0.j.f.e(a2.j.b.b.u0.j.e$a, com.google.android.exoplayer2.extractor.GaplessInfoHolder, long, com.google.android.exoplayer2.drm.DrmInitData, boolean, boolean, com.google.common.base.Function):java.util.List");
    }
}
