package com.google.zxing.aztec.decoder;

import a2.g.r.g;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.advert.item.AdvertDetailsPresenterKt;
import com.avito.android.remote.auth.AuthSource;
import com.google.zxing.FormatException;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.vk.sdk.api.VKApiConst;
import java.util.Arrays;
public final class Decoder {
    public static final String[] b = {"CTRL_PS", " ", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, "T", "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    public static final String[] c = {"CTRL_PS", " ", AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "c", "d", "e", "f", g.a, "h", "i", "j", "k", "l", AuthSource.OPEN_CHANNEL_LIST, "n", "o", "p", VKApiConst.Q, "r", "s", "t", "u", VKApiConst.VERSION, "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    public static final String[] d = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    public static final String[] e = {"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", "/", ":", ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};
    public static final String[] f = {"CTRL_PS", " ", "0", "1", ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8", AdvertDetailsPresenterKt.AUTO_CATEGORY_ID, ",", ".", "CTRL_UL", "CTRL_US"};
    public AztecDetectorResult a;

    public enum a {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    public static String a(boolean[] zArr) {
        String str;
        a aVar = a.UPPER;
        int length = zArr.length;
        StringBuilder sb = new StringBuilder(20);
        a aVar2 = aVar;
        a aVar3 = aVar2;
        int i = 0;
        while (i < length) {
            a aVar4 = a.BINARY;
            if (aVar2 == aVar4) {
                if (length - i < 5) {
                    break;
                }
                int b2 = b(zArr, i, 5);
                i += 5;
                if (b2 == 0) {
                    if (length - i < 11) {
                        break;
                    }
                    b2 = b(zArr, i, 11) + 31;
                    i += 11;
                }
                int i2 = 0;
                while (true) {
                    if (i2 >= b2) {
                        break;
                    } else if (length - i < 8) {
                        i = length;
                        break;
                    } else {
                        sb.append((char) b(zArr, i, 8));
                        i += 8;
                        i2++;
                    }
                }
            } else {
                a aVar5 = a.DIGIT;
                int i3 = aVar2 == aVar5 ? 4 : 5;
                if (length - i < i3) {
                    break;
                }
                int b3 = b(zArr, i, i3);
                i += i3;
                int ordinal = aVar2.ordinal();
                if (ordinal == 0) {
                    str = b[b3];
                } else if (ordinal == 1) {
                    str = c[b3];
                } else if (ordinal == 2) {
                    str = d[b3];
                } else if (ordinal == 3) {
                    str = f[b3];
                } else if (ordinal == 4) {
                    str = e[b3];
                } else {
                    throw new IllegalStateException("Bad table");
                }
                if (str.startsWith("CTRL_")) {
                    char charAt = str.charAt(5);
                    if (charAt != 'B') {
                        aVar3 = charAt != 'D' ? charAt != 'P' ? charAt != 'L' ? charAt != 'M' ? aVar : a.MIXED : a.LOWER : a.PUNCT : aVar5;
                    } else {
                        aVar3 = aVar4;
                    }
                    if (str.charAt(6) != 'L') {
                        aVar3 = aVar2;
                        aVar2 = aVar3;
                    }
                } else {
                    sb.append(str);
                }
            }
            aVar2 = aVar3;
        }
        return sb.toString();
    }

    public static int b(boolean[] zArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 <<= 1;
            if (zArr[i4]) {
                i3 |= 1;
            }
        }
        return i3;
    }

    public static String highLevelDecode(boolean[] zArr) {
        return a(zArr);
    }

    public DecoderResult decode(AztecDetectorResult aztecDetectorResult) throws FormatException {
        int i;
        GenericGF genericGF;
        int i2;
        this.a = aztecDetectorResult;
        BitMatrix bits = aztecDetectorResult.getBits();
        boolean isCompact = this.a.isCompact();
        int nbLayers = this.a.getNbLayers();
        int i3 = (isCompact ? 11 : 14) + (nbLayers << 2);
        int[] iArr = new int[i3];
        int i4 = ((isCompact ? 88 : 112) + (nbLayers << 4)) * nbLayers;
        boolean[] zArr = new boolean[i4];
        int i5 = 2;
        if (isCompact) {
            for (int i6 = 0; i6 < i3; i6++) {
                iArr[i6] = i6;
            }
        } else {
            int i7 = i3 / 2;
            int i8 = ((((i7 - 1) / 15) * 2) + (i3 + 1)) / 2;
            for (int i9 = 0; i9 < i7; i9++) {
                int i10 = (i9 / 15) + i9;
                iArr[(i7 - i9) - 1] = (i8 - i10) - 1;
                iArr[i7 + i9] = i10 + i8 + 1;
            }
        }
        int i11 = 0;
        int i12 = 0;
        while (true) {
            i = 12;
            if (i11 >= nbLayers) {
                break;
            }
            int i13 = (nbLayers - i11) << i5;
            if (isCompact) {
                i = 9;
            }
            int i14 = i13 + i;
            int i15 = i11 << 1;
            int i16 = (i3 - 1) - i15;
            int i17 = 0;
            while (i17 < i14) {
                int i18 = i17 << 1;
                int i19 = 0;
                while (i19 < i5) {
                    int i20 = i15 + i19;
                    int i21 = i15 + i17;
                    zArr[i12 + i18 + i19] = bits.get(iArr[i20], iArr[i21]);
                    int i22 = i16 - i19;
                    zArr[(i14 * 2) + i12 + i18 + i19] = bits.get(iArr[i21], iArr[i22]);
                    int i23 = i16 - i17;
                    zArr[(i14 * 4) + i12 + i18 + i19] = bits.get(iArr[i22], iArr[i23]);
                    zArr[(i14 * 6) + i12 + i18 + i19] = bits.get(iArr[i23], iArr[i20]);
                    i19++;
                    i3 = i3;
                    nbLayers = nbLayers;
                    isCompact = isCompact;
                    i5 = 2;
                }
                i17++;
                i5 = 2;
            }
            i12 += i14 << 3;
            i11++;
            isCompact = isCompact;
            i5 = 2;
        }
        if (this.a.getNbLayers() <= 2) {
            genericGF = GenericGF.AZTEC_DATA_6;
            i = 6;
        } else if (this.a.getNbLayers() <= 8) {
            genericGF = GenericGF.AZTEC_DATA_8;
            i = 8;
        } else if (this.a.getNbLayers() <= 22) {
            i = 10;
            genericGF = GenericGF.AZTEC_DATA_10;
        } else {
            genericGF = GenericGF.AZTEC_DATA_12;
        }
        int nbDatablocks = this.a.getNbDatablocks();
        int i24 = i4 / i;
        if (i24 >= nbDatablocks) {
            int i25 = i4 % i;
            int[] iArr2 = new int[i24];
            int i26 = 0;
            while (i26 < i24) {
                iArr2[i26] = b(zArr, i25, i);
                i26++;
                i25 += i;
            }
            try {
                new ReedSolomonDecoder(genericGF).decode(iArr2, i24 - nbDatablocks);
                int i27 = 1;
                int i28 = (1 << i) - 1;
                int i29 = 0;
                int i30 = 0;
                while (i29 < nbDatablocks) {
                    int i31 = iArr2[i29];
                    if (i31 == 0 || i31 == i28) {
                        throw FormatException.getFormatInstance();
                    }
                    if (i31 == i27 || i31 == i28 - 1) {
                        i30++;
                    }
                    i29++;
                    i27 = 1;
                }
                int i32 = (nbDatablocks * i) - i30;
                boolean[] zArr2 = new boolean[i32];
                int i33 = 0;
                for (int i34 = 0; i34 < nbDatablocks; i34++) {
                    int i35 = iArr2[i34];
                    int i36 = 1;
                    if (i35 == 1 || i35 == i28 - 1) {
                        Arrays.fill(zArr2, i33, (i33 + i) - 1, i35 > 1);
                        i33 = (i - 1) + i33;
                    } else {
                        int i37 = i - 1;
                        while (i37 >= 0) {
                            int i38 = i33 + 1;
                            zArr2[i33] = ((i36 << i37) & i35) != 0;
                            i37--;
                            i33 = i38;
                            i36 = 1;
                        }
                    }
                }
                int i39 = (i32 + 7) / 8;
                byte[] bArr = new byte[i39];
                for (int i40 = 0; i40 < i39; i40++) {
                    int i41 = i40 << 3;
                    int i42 = i32 - i41;
                    if (i42 >= 8) {
                        i2 = b(zArr2, i41, 8);
                    } else {
                        i2 = b(zArr2, i41, i42) << (8 - i42);
                    }
                    bArr[i40] = (byte) i2;
                }
                DecoderResult decoderResult = new DecoderResult(bArr, a(zArr2), null, null);
                decoderResult.setNumBits(i32);
                return decoderResult;
            } catch (ReedSolomonException e2) {
                throw FormatException.getFormatInstance(e2);
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }
}
