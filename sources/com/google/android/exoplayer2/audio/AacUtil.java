package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
public final class AacUtil {
    public static final int AAC_ELD_MAX_RATE_BYTES_PER_SECOND = 8000;
    public static final int AAC_HE_AUDIO_SAMPLE_COUNT = 2048;
    public static final int AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND = 16000;
    public static final int AAC_HE_V2_MAX_RATE_BYTES_PER_SECOND = 7000;
    public static final int AAC_LC_AUDIO_SAMPLE_COUNT = 1024;
    public static final int AAC_LC_MAX_RATE_BYTES_PER_SECOND = 100000;
    public static final int AAC_LD_AUDIO_SAMPLE_COUNT = 512;
    public static final int AAC_XHE_AUDIO_SAMPLE_COUNT = 1024;
    public static final int AAC_XHE_MAX_RATE_BYTES_PER_SECOND = 256000;
    public static final int AUDIO_OBJECT_TYPE_AAC_ELD = 23;
    public static final int AUDIO_OBJECT_TYPE_AAC_ER_BSAC = 22;
    public static final int AUDIO_OBJECT_TYPE_AAC_LC = 2;
    public static final int AUDIO_OBJECT_TYPE_AAC_PS = 29;
    public static final int AUDIO_OBJECT_TYPE_AAC_SBR = 5;
    public static final int AUDIO_OBJECT_TYPE_AAC_XHE = 42;
    public static final int[] a = {96000, 88200, 64000, OpusUtil.SAMPLE_RATE, 44100, 32000, 24000, 22050, AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND, 12000, 11025, 8000, 7350};
    public static final int[] b = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface AacAudioObjectType {
    }

    public static final class Config {
        public final int channelCount;
        public final String codecs;
        public final int sampleRateHz;

        public Config(int i, int i2, String str, a aVar) {
            this.sampleRateHz = i;
            this.channelCount = i2;
            this.codecs = str;
        }
    }

    public static int a(ParsableBitArray parsableBitArray) {
        int readBits = parsableBitArray.readBits(4);
        if (readBits == 15) {
            return parsableBitArray.readBits(24);
        }
        Assertions.checkArgument(readBits < 13);
        return a[readBits];
    }

    public static byte[] buildAacLcAudioSpecificConfig(int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        int i5 = -1;
        while (true) {
            int[] iArr = a;
            if (i4 >= iArr.length) {
                break;
            }
            if (i == iArr[i4]) {
                i5 = i4;
            }
            i4++;
        }
        int i6 = -1;
        while (true) {
            int[] iArr2 = b;
            if (i3 >= iArr2.length) {
                break;
            }
            if (i2 == iArr2[i3]) {
                i6 = i3;
            }
            i3++;
        }
        if (i != -1 && i6 != -1) {
            return buildAudioSpecificConfig(2, i5, i6);
        }
        throw new IllegalArgumentException(a2.b.a.a.a.R2("Invalid sample rate or number of channels: ", i, ", ", i2));
    }

    public static byte[] buildAudioSpecificConfig(int i, int i2, int i3) {
        return new byte[]{(byte) (((i << 3) & 248) | ((i2 >> 1) & 7)), (byte) (((i2 << 7) & 128) | ((i3 << 3) & 120))};
    }

    public static int getEncodingForAudioObjectType(int i) {
        if (i == 2) {
            return 10;
        }
        if (i == 5) {
            return 11;
        }
        if (i == 29) {
            return 12;
        }
        if (i == 42) {
            return 16;
        }
        if (i != 22) {
            return i != 23 ? 0 : 15;
        }
        return 1073741824;
    }

    public static Config parseAudioSpecificConfig(byte[] bArr) throws ParserException {
        return parseAudioSpecificConfig(new ParsableBitArray(bArr), false);
    }

    public static Config parseAudioSpecificConfig(ParsableBitArray parsableBitArray, boolean z) throws ParserException {
        int readBits = parsableBitArray.readBits(5);
        if (readBits == 31) {
            readBits = parsableBitArray.readBits(6) + 32;
        }
        int a3 = a(parsableBitArray);
        int readBits2 = parsableBitArray.readBits(4);
        String M2 = a2.b.a.a.a.M2("mp4a.40.", readBits);
        if (readBits == 5 || readBits == 29) {
            a3 = a(parsableBitArray);
            int readBits3 = parsableBitArray.readBits(5);
            if (readBits3 == 31) {
                readBits3 = parsableBitArray.readBits(6) + 32;
            }
            readBits = readBits3;
            if (readBits == 22) {
                readBits2 = parsableBitArray.readBits(4);
            }
        }
        boolean z2 = true;
        if (z) {
            if (!(readBits == 1 || readBits == 2 || readBits == 3 || readBits == 4 || readBits == 6 || readBits == 7 || readBits == 17)) {
                switch (readBits) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw new ParserException(a2.b.a.a.a.M2("Unsupported audio object type: ", readBits));
                }
            }
            if (parsableBitArray.readBit()) {
                Log.w("AacUtil", "Unexpected frameLengthFlag = 1");
            }
            if (parsableBitArray.readBit()) {
                parsableBitArray.skipBits(14);
            }
            boolean readBit = parsableBitArray.readBit();
            if (readBits2 != 0) {
                if (readBits == 6 || readBits == 20) {
                    parsableBitArray.skipBits(3);
                }
                if (readBit) {
                    if (readBits == 22) {
                        parsableBitArray.skipBits(16);
                    }
                    if (readBits == 17 || readBits == 19 || readBits == 20 || readBits == 23) {
                        parsableBitArray.skipBits(3);
                    }
                    parsableBitArray.skipBits(1);
                }
                switch (readBits) {
                    case 17:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        int readBits4 = parsableBitArray.readBits(2);
                        if (readBits4 == 2 || readBits4 == 3) {
                            throw new ParserException(a2.b.a.a.a.M2("Unsupported epConfig: ", readBits4));
                        }
                }
            } else {
                throw new UnsupportedOperationException();
            }
        }
        int i = b[readBits2];
        if (i == -1) {
            z2 = false;
        }
        Assertions.checkArgument(z2);
        return new Config(a3, i, M2, null);
    }
}
