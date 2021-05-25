package com.google.android.exoplayer2.extractor;

import a2.b.a.a.a;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;
public final class VorbisUtil {

    public static final class CommentHeader {
        public final String[] comments;
        public final int length;
        public final String vendor;

        public CommentHeader(String str, String[] strArr, int i) {
            this.vendor = str;
            this.comments = strArr;
            this.length = i;
        }
    }

    public static final class Mode {
        public final boolean blockFlag;
        public final int mapping;
        public final int transformType;
        public final int windowType;

        public Mode(boolean z, int i, int i2, int i3) {
            this.blockFlag = z;
            this.windowType = i;
            this.transformType = i2;
            this.mapping = i3;
        }
    }

    public static final class VorbisIdHeader {
        public final int bitrateMaximum;
        public final int bitrateMinimum;
        public final int bitrateNominal;
        public final int blockSize0;
        public final int blockSize1;
        public final int channels;
        public final byte[] data;
        public final boolean framingFlag;
        public final int sampleRate;
        public final int version;

        public VorbisIdHeader(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, byte[] bArr) {
            this.version = i;
            this.channels = i2;
            this.sampleRate = i3;
            this.bitrateMaximum = i4;
            this.bitrateNominal = i5;
            this.bitrateMinimum = i6;
            this.blockSize0 = i7;
            this.blockSize1 = i8;
            this.framingFlag = z;
            this.data = bArr;
        }
    }

    public static int iLog(int i) {
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    public static CommentHeader readVorbisCommentHeader(ParsableByteArray parsableByteArray) throws ParserException {
        return readVorbisCommentHeader(parsableByteArray, true, true);
    }

    public static VorbisIdHeader readVorbisIdentificationHeader(ParsableByteArray parsableByteArray) throws ParserException {
        boolean z = true;
        verifyVorbisHeaderCapturePattern(1, parsableByteArray, false);
        int readLittleEndianUnsignedIntToInt = parsableByteArray.readLittleEndianUnsignedIntToInt();
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int readLittleEndianUnsignedIntToInt2 = parsableByteArray.readLittleEndianUnsignedIntToInt();
        int readLittleEndianInt = parsableByteArray.readLittleEndianInt();
        if (readLittleEndianInt <= 0) {
            readLittleEndianInt = -1;
        }
        int readLittleEndianInt2 = parsableByteArray.readLittleEndianInt();
        if (readLittleEndianInt2 <= 0) {
            readLittleEndianInt2 = -1;
        }
        int readLittleEndianInt3 = parsableByteArray.readLittleEndianInt();
        if (readLittleEndianInt3 <= 0) {
            readLittleEndianInt3 = -1;
        }
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        int pow = (int) Math.pow(2.0d, (double) (readUnsignedByte2 & 15));
        int pow2 = (int) Math.pow(2.0d, (double) ((readUnsignedByte2 & 240) >> 4));
        if ((parsableByteArray.readUnsignedByte() & 1) <= 0) {
            z = false;
        }
        return new VorbisIdHeader(readLittleEndianUnsignedIntToInt, readUnsignedByte, readLittleEndianUnsignedIntToInt2, readLittleEndianInt, readLittleEndianInt2, readLittleEndianInt3, pow, pow2, z, Arrays.copyOf(parsableByteArray.getData(), parsableByteArray.limit()));
    }

    public static Mode[] readVorbisModes(ParsableByteArray parsableByteArray, int i) throws ParserException {
        int i2 = 5;
        int i3 = 0;
        verifyVorbisHeaderCapturePattern(5, parsableByteArray, false);
        int readUnsignedByte = parsableByteArray.readUnsignedByte() + 1;
        VorbisBitArray vorbisBitArray = new VorbisBitArray(parsableByteArray.getData());
        vorbisBitArray.skipBits(parsableByteArray.getPosition() * 8);
        int i4 = 0;
        while (i4 < readUnsignedByte) {
            if (vorbisBitArray.readBits(24) == 5653314) {
                int readBits = vorbisBitArray.readBits(16);
                int readBits2 = vorbisBitArray.readBits(24);
                long[] jArr = new long[readBits2];
                if (!vorbisBitArray.readBit()) {
                    boolean readBit = vorbisBitArray.readBit();
                    while (i3 < readBits2) {
                        if (!readBit) {
                            jArr[i3] = (long) (vorbisBitArray.readBits(5) + 1);
                        } else if (vorbisBitArray.readBit()) {
                            jArr[i3] = (long) (vorbisBitArray.readBits(5) + 1);
                        } else {
                            jArr[i3] = 0;
                        }
                        i3++;
                    }
                } else {
                    int readBits3 = vorbisBitArray.readBits(5) + 1;
                    int i5 = 0;
                    while (i5 < readBits2) {
                        int readBits4 = vorbisBitArray.readBits(iLog(readBits2 - i5));
                        for (int i6 = 0; i6 < readBits4 && i5 < readBits2; i6++) {
                            jArr[i5] = (long) readBits3;
                            i5++;
                        }
                        readBits3++;
                    }
                }
                int readBits5 = vorbisBitArray.readBits(4);
                if (readBits5 <= 2) {
                    if (readBits5 == 1 || readBits5 == 2) {
                        vorbisBitArray.skipBits(32);
                        vorbisBitArray.skipBits(32);
                        int readBits6 = vorbisBitArray.readBits(4) + 1;
                        vorbisBitArray.skipBits(1);
                        vorbisBitArray.skipBits((int) ((readBits5 == 1 ? readBits != 0 ? (long) Math.floor(Math.pow((double) ((long) readBits2), 1.0d / ((double) ((long) readBits)))) : 0 : ((long) readBits2) * ((long) readBits)) * ((long) readBits6)));
                    }
                    i4++;
                    i3 = 0;
                } else {
                    throw new ParserException(a.M2("lookup type greater than 2 not decodable: ", readBits5));
                }
            } else {
                StringBuilder L = a.L("expected code book to start with [0x56, 0x43, 0x42] at ");
                L.append(vorbisBitArray.getPosition());
                throw new ParserException(L.toString());
            }
        }
        int readBits7 = vorbisBitArray.readBits(6) + 1;
        for (int i7 = 0; i7 < readBits7; i7++) {
            if (vorbisBitArray.readBits(16) != 0) {
                throw new ParserException("placeholder of time domain transforms not zeroed out");
            }
        }
        int readBits8 = vorbisBitArray.readBits(6) + 1;
        int i8 = 0;
        while (true) {
            int i9 = 3;
            if (i8 < readBits8) {
                int readBits9 = vorbisBitArray.readBits(16);
                if (readBits9 == 0) {
                    int i10 = 8;
                    vorbisBitArray.skipBits(8);
                    vorbisBitArray.skipBits(16);
                    vorbisBitArray.skipBits(16);
                    vorbisBitArray.skipBits(6);
                    vorbisBitArray.skipBits(8);
                    int readBits10 = vorbisBitArray.readBits(4) + 1;
                    int i11 = 0;
                    while (i11 < readBits10) {
                        vorbisBitArray.skipBits(i10);
                        i11++;
                        i10 = 8;
                    }
                } else if (readBits9 == 1) {
                    int readBits11 = vorbisBitArray.readBits(i2);
                    int[] iArr = new int[readBits11];
                    int i12 = -1;
                    for (int i13 = 0; i13 < readBits11; i13++) {
                        iArr[i13] = vorbisBitArray.readBits(4);
                        if (iArr[i13] > i12) {
                            i12 = iArr[i13];
                        }
                    }
                    int i14 = i12 + 1;
                    int[] iArr2 = new int[i14];
                    int i15 = 0;
                    while (i15 < i14) {
                        iArr2[i15] = vorbisBitArray.readBits(i9) + 1;
                        int readBits12 = vorbisBitArray.readBits(2);
                        int i16 = 8;
                        if (readBits12 > 0) {
                            vorbisBitArray.skipBits(8);
                        }
                        int i17 = 0;
                        while (i17 < (1 << readBits12)) {
                            vorbisBitArray.skipBits(i16);
                            i17++;
                            i16 = 8;
                        }
                        i15++;
                        i9 = 3;
                    }
                    vorbisBitArray.skipBits(2);
                    int readBits13 = vorbisBitArray.readBits(4);
                    int i18 = 0;
                    int i19 = 0;
                    for (int i20 = 0; i20 < readBits11; i20++) {
                        i18 += iArr2[iArr[i20]];
                        while (i19 < i18) {
                            vorbisBitArray.skipBits(readBits13);
                            i19++;
                        }
                    }
                } else {
                    throw new ParserException(a.M2("floor type greater than 1 not decodable: ", readBits9));
                }
                i8++;
                i2 = 5;
            } else {
                int readBits14 = vorbisBitArray.readBits(6) + 1;
                for (int i21 = 0; i21 < readBits14; i21++) {
                    if (vorbisBitArray.readBits(16) <= 2) {
                        vorbisBitArray.skipBits(24);
                        vorbisBitArray.skipBits(24);
                        vorbisBitArray.skipBits(24);
                        int readBits15 = vorbisBitArray.readBits(6) + 1;
                        int i22 = 8;
                        vorbisBitArray.skipBits(8);
                        int[] iArr3 = new int[readBits15];
                        for (int i23 = 0; i23 < readBits15; i23++) {
                            iArr3[i23] = ((vorbisBitArray.readBit() ? vorbisBitArray.readBits(5) : 0) * 8) + vorbisBitArray.readBits(3);
                        }
                        int i24 = 0;
                        while (i24 < readBits15) {
                            int i25 = 0;
                            while (i25 < i22) {
                                if ((iArr3[i24] & (1 << i25)) != 0) {
                                    vorbisBitArray.skipBits(i22);
                                }
                                i25++;
                                i22 = 8;
                            }
                            i24++;
                            i22 = 8;
                        }
                    } else {
                        throw new ParserException("residueType greater than 2 is not decodable");
                    }
                }
                int readBits16 = vorbisBitArray.readBits(6) + 1;
                for (int i26 = 0; i26 < readBits16; i26++) {
                    int readBits17 = vorbisBitArray.readBits(16);
                    if (readBits17 != 0) {
                        Log.e("VorbisUtil", "mapping type other than 0 not supported: " + readBits17);
                    } else {
                        int readBits18 = vorbisBitArray.readBit() ? vorbisBitArray.readBits(4) + 1 : 1;
                        if (vorbisBitArray.readBit()) {
                            int readBits19 = vorbisBitArray.readBits(8) + 1;
                            for (int i27 = 0; i27 < readBits19; i27++) {
                                int i28 = i - 1;
                                vorbisBitArray.skipBits(iLog(i28));
                                vorbisBitArray.skipBits(iLog(i28));
                            }
                        }
                        if (vorbisBitArray.readBits(2) == 0) {
                            if (readBits18 > 1) {
                                for (int i29 = 0; i29 < i; i29++) {
                                    vorbisBitArray.skipBits(4);
                                }
                            }
                            for (int i30 = 0; i30 < readBits18; i30++) {
                                vorbisBitArray.skipBits(8);
                                vorbisBitArray.skipBits(8);
                                vorbisBitArray.skipBits(8);
                            }
                        } else {
                            throw new ParserException("to reserved bits must be zero after mapping coupling steps");
                        }
                    }
                }
                int readBits20 = vorbisBitArray.readBits(6) + 1;
                Mode[] modeArr = new Mode[readBits20];
                for (int i31 = 0; i31 < readBits20; i31++) {
                    modeArr[i31] = new Mode(vorbisBitArray.readBit(), vorbisBitArray.readBits(16), vorbisBitArray.readBits(16), vorbisBitArray.readBits(8));
                }
                if (vorbisBitArray.readBit()) {
                    return modeArr;
                }
                throw new ParserException("framing bit after modes not set as expected");
            }
        }
    }

    public static boolean verifyVorbisHeaderCapturePattern(int i, ParsableByteArray parsableByteArray, boolean z) throws ParserException {
        if (parsableByteArray.bytesLeft() < 7) {
            if (z) {
                return false;
            }
            StringBuilder L = a.L("too short header: ");
            L.append(parsableByteArray.bytesLeft());
            throw new ParserException(L.toString());
        } else if (parsableByteArray.readUnsignedByte() != i) {
            if (z) {
                return false;
            }
            StringBuilder L2 = a.L("expected header type ");
            L2.append(Integer.toHexString(i));
            throw new ParserException(L2.toString());
        } else if (parsableByteArray.readUnsignedByte() == 118 && parsableByteArray.readUnsignedByte() == 111 && parsableByteArray.readUnsignedByte() == 114 && parsableByteArray.readUnsignedByte() == 98 && parsableByteArray.readUnsignedByte() == 105 && parsableByteArray.readUnsignedByte() == 115) {
            return true;
        } else {
            if (z) {
                return false;
            }
            throw new ParserException("expected characters 'vorbis'");
        }
    }

    public static CommentHeader readVorbisCommentHeader(ParsableByteArray parsableByteArray, boolean z, boolean z2) throws ParserException {
        if (z) {
            verifyVorbisHeaderCapturePattern(3, parsableByteArray, false);
        }
        String readString = parsableByteArray.readString((int) parsableByteArray.readLittleEndianUnsignedInt());
        long readLittleEndianUnsignedInt = parsableByteArray.readLittleEndianUnsignedInt();
        String[] strArr = new String[((int) readLittleEndianUnsignedInt)];
        int length = readString.length() + 11 + 4;
        for (int i = 0; ((long) i) < readLittleEndianUnsignedInt; i++) {
            strArr[i] = parsableByteArray.readString((int) parsableByteArray.readLittleEndianUnsignedInt());
            length = length + 4 + strArr[i].length();
        }
        if (!z2 || (parsableByteArray.readUnsignedByte() & 1) != 0) {
            return new CommentHeader(readString, strArr, length + 1);
        }
        throw new ParserException("framing bit expected to be set");
    }
}
