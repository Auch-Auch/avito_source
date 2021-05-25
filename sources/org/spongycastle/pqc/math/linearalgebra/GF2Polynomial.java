package org.spongycastle.pqc.math.linearalgebra;

import a2.b.a.a.a;
import androidx.core.view.ViewCompat;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.common.base.Ascii;
import com.google.common.primitives.Shorts;
import java.math.BigInteger;
import java.util.Random;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.spongycastle.asn1.cmc.BodyPartID;
public class GF2Polynomial {
    public static Random d = new Random();
    public static final boolean[] e = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};
    public static final short[] f = {0, 1, 4, 5, 16, 17, 20, 21, 64, 65, 68, 69, 80, 81, 84, 85, 256, 257, 260, 261, 272, 273, 276, 277, 320, 321, 324, 325, 336, 337, 340, 341, SilenceSkippingAudioProcessor.DEFAULT_SILENCE_THRESHOLD_LEVEL, 1025, 1028, 1029, 1040, 1041, 1044, 1045, 1088, 1089, 1092, 1093, 1104, 1105, 1108, 1109, 1280, 1281, 1284, 1285, 1296, 1297, 1300, 1301, 1344, 1345, 1348, 1349, 1360, 1361, 1364, 1365, 4096, 4097, 4100, 4101, 4112, 4113, 4116, 4117, 4160, 4161, 4164, 4165, 4176, 4177, 4180, 4181, 4352, 4353, 4356, 4357, 4368, 4369, 4372, 4373, 4416, 4417, 4420, 4421, 4432, 4433, 4436, 4437, 5120, 5121, 5124, 5125, 5136, 5137, 5140, 5141, 5184, 5185, 5188, 5189, 5200, 5201, 5204, 5205, 5376, 5377, 5380, 5381, 5392, 5393, 5396, 5397, 5440, 5441, 5444, 5445, 5456, 5457, 5460, 5461, Shorts.MAX_POWER_OF_TWO, 16385, 16388, 16389, 16400, 16401, 16404, 16405, 16448, 16449, 16452, 16453, 16464, 16465, 16468, 16469, 16640, 16641, 16644, 16645, 16656, 16657, 16660, 16661, 16704, 16705, 16708, 16709, 16720, 16721, 16724, 16725, 17408, 17409, 17412, 17413, 17424, 17425, 17428, 17429, 17472, 17473, 17476, 17477, 17488, 17489, 17492, 17493, 17664, 17665, 17668, 17669, 17680, 17681, 17684, 17685, 17728, 17729, 17732, 17733, 17744, 17745, 17748, 17749, 20480, 20481, 20484, 20485, 20496, 20497, 20500, 20501, 20544, 20545, 20548, 20549, 20560, 20561, 20564, 20565, 20736, 20737, 20740, 20741, 20752, 20753, 20756, 20757, 20800, 20801, 20804, 20805, 20816, 20817, 20820, 20821, 21504, 21505, 21508, 21509, 21520, 21521, 21524, 21525, 21568, 21569, 21572, 21573, 21584, 21585, 21588, 21589, 21760, 21761, 21764, 21765, 21776, 21777, 21780, 21781, 21824, 21825, 21828, 21829, 21840, 21841, 21844, 21845};
    public static final int[] g = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824, Integer.MIN_VALUE, 0};
    public static final int[] h = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, ViewCompat.MEASURED_SIZE_MASK, 33554431, 67108863, 134217727, 268435455, 536870911, LockFreeTaskQueueCore.MAX_CAPACITY_MASK, Integer.MAX_VALUE, -1};
    public int a;
    public int b;
    public int[] c;

    public GF2Polynomial(int i) {
        i = i < 1 ? 1 : i;
        int i2 = ((i - 1) >> 5) + 1;
        this.b = i2;
        this.c = new int[i2];
        this.a = i;
    }

    public static int[] c(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[8];
        int[] iArr4 = new int[2];
        System.arraycopy(iArr, 0, iArr4, 0, Math.min(2, iArr.length));
        int[] iArr5 = new int[2];
        if (iArr.length > 2) {
            System.arraycopy(iArr, 2, iArr5, 0, Math.min(2, iArr.length - 2));
        }
        int[] iArr6 = new int[2];
        System.arraycopy(iArr2, 0, iArr6, 0, Math.min(2, iArr2.length));
        int[] iArr7 = new int[2];
        if (iArr2.length > 2) {
            System.arraycopy(iArr2, 2, iArr7, 0, Math.min(2, iArr2.length - 2));
        }
        if (iArr5[1] != 0 || iArr7[1] != 0) {
            int[] f2 = f(iArr5, iArr7);
            iArr3[7] = iArr3[7] ^ f2[3];
            iArr3[6] = iArr3[6] ^ f2[2];
            iArr3[5] = iArr3[5] ^ (f2[1] ^ f2[3]);
            iArr3[4] = iArr3[4] ^ (f2[0] ^ f2[2]);
            iArr3[3] = iArr3[3] ^ f2[1];
            iArr3[2] = f2[0] ^ iArr3[2];
        } else if (!(iArr5[0] == 0 && iArr7[0] == 0)) {
            int[] e2 = e(iArr5[0], iArr7[0]);
            iArr3[5] = iArr3[5] ^ e2[1];
            iArr3[4] = iArr3[4] ^ e2[0];
            iArr3[3] = iArr3[3] ^ e2[1];
            iArr3[2] = e2[0] ^ iArr3[2];
        }
        iArr5[0] = iArr5[0] ^ iArr4[0];
        iArr5[1] = iArr5[1] ^ iArr4[1];
        iArr7[0] = iArr7[0] ^ iArr6[0];
        iArr7[1] = iArr7[1] ^ iArr6[1];
        if (iArr5[1] == 0 && iArr7[1] == 0) {
            int[] e3 = e(iArr5[0], iArr7[0]);
            iArr3[3] = iArr3[3] ^ e3[1];
            iArr3[2] = e3[0] ^ iArr3[2];
        } else {
            int[] f3 = f(iArr5, iArr7);
            iArr3[5] = iArr3[5] ^ f3[3];
            iArr3[4] = iArr3[4] ^ f3[2];
            iArr3[3] = iArr3[3] ^ f3[1];
            iArr3[2] = f3[0] ^ iArr3[2];
        }
        if (iArr4[1] == 0 && iArr6[1] == 0) {
            int[] e4 = e(iArr4[0], iArr6[0]);
            iArr3[3] = iArr3[3] ^ e4[1];
            iArr3[2] = iArr3[2] ^ e4[0];
            iArr3[1] = iArr3[1] ^ e4[1];
            iArr3[0] = e4[0] ^ iArr3[0];
        } else {
            int[] f4 = f(iArr4, iArr6);
            iArr3[5] = iArr3[5] ^ f4[3];
            iArr3[4] = iArr3[4] ^ f4[2];
            iArr3[3] = iArr3[3] ^ (f4[1] ^ f4[3]);
            iArr3[2] = iArr3[2] ^ (f4[0] ^ f4[2]);
            iArr3[1] = iArr3[1] ^ f4[1];
            iArr3[0] = f4[0] ^ iArr3[0];
        }
        return iArr3;
    }

    public static int[] d(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[16];
        int[] iArr4 = new int[4];
        System.arraycopy(iArr, 0, iArr4, 0, Math.min(4, iArr.length));
        int[] iArr5 = new int[4];
        if (iArr.length > 4) {
            System.arraycopy(iArr, 4, iArr5, 0, Math.min(4, iArr.length - 4));
        }
        int[] iArr6 = new int[4];
        System.arraycopy(iArr2, 0, iArr6, 0, Math.min(4, iArr2.length));
        int[] iArr7 = new int[4];
        if (iArr2.length > 4) {
            System.arraycopy(iArr2, 4, iArr7, 0, Math.min(4, iArr2.length - 4));
        }
        if (iArr5[3] != 0 || iArr5[2] != 0 || iArr7[3] != 0 || iArr7[2] != 0) {
            int[] c2 = c(iArr5, iArr7);
            iArr3[15] = iArr3[15] ^ c2[7];
            iArr3[14] = iArr3[14] ^ c2[6];
            iArr3[13] = iArr3[13] ^ c2[5];
            iArr3[12] = iArr3[12] ^ c2[4];
            iArr3[11] = iArr3[11] ^ (c2[3] ^ c2[7]);
            iArr3[10] = iArr3[10] ^ (c2[2] ^ c2[6]);
            iArr3[9] = iArr3[9] ^ (c2[1] ^ c2[5]);
            iArr3[8] = iArr3[8] ^ (c2[0] ^ c2[4]);
            iArr3[7] = iArr3[7] ^ c2[3];
            iArr3[6] = iArr3[6] ^ c2[2];
            iArr3[5] = iArr3[5] ^ c2[1];
            iArr3[4] = c2[0] ^ iArr3[4];
        } else if (iArr5[1] != 0 || iArr7[1] != 0) {
            int[] f2 = f(iArr5, iArr7);
            iArr3[11] = iArr3[11] ^ f2[3];
            iArr3[10] = iArr3[10] ^ f2[2];
            iArr3[9] = iArr3[9] ^ f2[1];
            iArr3[8] = iArr3[8] ^ f2[0];
            iArr3[7] = iArr3[7] ^ f2[3];
            iArr3[6] = iArr3[6] ^ f2[2];
            iArr3[5] = iArr3[5] ^ f2[1];
            iArr3[4] = f2[0] ^ iArr3[4];
        } else if (!(iArr5[0] == 0 && iArr7[0] == 0)) {
            int[] e2 = e(iArr5[0], iArr7[0]);
            iArr3[9] = iArr3[9] ^ e2[1];
            iArr3[8] = iArr3[8] ^ e2[0];
            iArr3[5] = iArr3[5] ^ e2[1];
            iArr3[4] = e2[0] ^ iArr3[4];
        }
        iArr5[0] = iArr5[0] ^ iArr4[0];
        iArr5[1] = iArr5[1] ^ iArr4[1];
        iArr5[2] = iArr5[2] ^ iArr4[2];
        iArr5[3] = iArr5[3] ^ iArr4[3];
        iArr7[0] = iArr7[0] ^ iArr6[0];
        iArr7[1] = iArr7[1] ^ iArr6[1];
        iArr7[2] = iArr7[2] ^ iArr6[2];
        iArr7[3] = iArr7[3] ^ iArr6[3];
        int[] c3 = c(iArr5, iArr7);
        iArr3[11] = iArr3[11] ^ c3[7];
        iArr3[10] = iArr3[10] ^ c3[6];
        iArr3[9] = iArr3[9] ^ c3[5];
        iArr3[8] = iArr3[8] ^ c3[4];
        iArr3[7] = iArr3[7] ^ c3[3];
        iArr3[6] = iArr3[6] ^ c3[2];
        iArr3[5] = iArr3[5] ^ c3[1];
        iArr3[4] = c3[0] ^ iArr3[4];
        int[] c4 = c(iArr4, iArr6);
        iArr3[11] = iArr3[11] ^ c4[7];
        iArr3[10] = iArr3[10] ^ c4[6];
        iArr3[9] = iArr3[9] ^ c4[5];
        iArr3[8] = iArr3[8] ^ c4[4];
        iArr3[7] = iArr3[7] ^ (c4[3] ^ c4[7]);
        iArr3[6] = iArr3[6] ^ (c4[2] ^ c4[6]);
        iArr3[5] = iArr3[5] ^ (c4[1] ^ c4[5]);
        iArr3[4] = iArr3[4] ^ (c4[0] ^ c4[4]);
        iArr3[3] = iArr3[3] ^ c4[3];
        iArr3[2] = iArr3[2] ^ c4[2];
        iArr3[1] = iArr3[1] ^ c4[1];
        iArr3[0] = c4[0] ^ iArr3[0];
        return iArr3;
    }

    public static int[] e(int i, int i2) {
        int[] iArr = new int[2];
        if (!(i == 0 || i2 == 0)) {
            long j = ((long) i2) & BodyPartID.bodyIdMax;
            long j2 = 0;
            for (int i3 = 1; i3 <= 32; i3++) {
                if ((g[i3 - 1] & i) != 0) {
                    j2 ^= j;
                }
                j <<= 1;
            }
            iArr[1] = (int) (j2 >>> 32);
            iArr[0] = (int) (j2 & BodyPartID.bodyIdMax);
        }
        return iArr;
    }

    public static int[] f(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[4];
        int i = iArr[0];
        int i2 = iArr.length > 1 ? iArr[1] : 0;
        int i3 = iArr2[0];
        int i4 = iArr2.length > 1 ? iArr2[1] : 0;
        if (!(i2 == 0 && i4 == 0)) {
            int[] e2 = e(i2, i4);
            iArr3[3] = iArr3[3] ^ e2[1];
            iArr3[2] = iArr3[2] ^ (e2[0] ^ e2[1]);
            iArr3[1] = e2[0] ^ iArr3[1];
        }
        int[] e3 = e(i2 ^ i, i4 ^ i3);
        iArr3[2] = iArr3[2] ^ e3[1];
        iArr3[1] = e3[0] ^ iArr3[1];
        int[] e4 = e(i, i3);
        iArr3[2] = iArr3[2] ^ e4[1];
        iArr3[1] = iArr3[1] ^ (e4[0] ^ e4[1]);
        iArr3[0] = e4[0] ^ iArr3[0];
        return iArr3;
    }

    public final GF2Polynomial a(GF2Polynomial gF2Polynomial) {
        GF2Polynomial gF2Polynomial2 = new GF2Polynomial(this.a << 1);
        int i = this.a;
        if (i <= 32) {
            gF2Polynomial2.c = e(this.c[0], gF2Polynomial.c[0]);
            return gF2Polynomial2;
        } else if (i <= 64) {
            gF2Polynomial2.c = f(this.c, gF2Polynomial.c);
            return gF2Polynomial2;
        } else if (i <= 128) {
            gF2Polynomial2.c = c(this.c, gF2Polynomial.c);
            return gF2Polynomial2;
        } else if (i <= 256) {
            gF2Polynomial2.c = d(this.c, gF2Polynomial.c);
            return gF2Polynomial2;
        } else if (i <= 512) {
            int[] iArr = this.c;
            int[] iArr2 = gF2Polynomial.c;
            int[] iArr3 = new int[32];
            int[] iArr4 = new int[8];
            System.arraycopy(iArr, 0, iArr4, 0, Math.min(8, iArr.length));
            int[] iArr5 = new int[8];
            if (iArr.length > 8) {
                System.arraycopy(iArr, 8, iArr5, 0, Math.min(8, iArr.length - 8));
            }
            int[] iArr6 = new int[8];
            System.arraycopy(iArr2, 0, iArr6, 0, Math.min(8, iArr2.length));
            int[] iArr7 = new int[8];
            if (iArr2.length > 8) {
                System.arraycopy(iArr2, 8, iArr7, 0, Math.min(8, iArr2.length - 8));
            }
            int[] d2 = d(iArr5, iArr7);
            iArr3[31] = iArr3[31] ^ d2[15];
            iArr3[30] = iArr3[30] ^ d2[14];
            iArr3[29] = iArr3[29] ^ d2[13];
            iArr3[28] = iArr3[28] ^ d2[12];
            iArr3[27] = iArr3[27] ^ d2[11];
            iArr3[26] = iArr3[26] ^ d2[10];
            iArr3[25] = iArr3[25] ^ d2[9];
            iArr3[24] = iArr3[24] ^ d2[8];
            iArr3[23] = iArr3[23] ^ (d2[7] ^ d2[15]);
            iArr3[22] = iArr3[22] ^ (d2[6] ^ d2[14]);
            iArr3[21] = iArr3[21] ^ (d2[5] ^ d2[13]);
            iArr3[20] = iArr3[20] ^ (d2[4] ^ d2[12]);
            iArr3[19] = iArr3[19] ^ (d2[3] ^ d2[11]);
            iArr3[18] = iArr3[18] ^ (d2[2] ^ d2[10]);
            iArr3[17] = iArr3[17] ^ (d2[1] ^ d2[9]);
            iArr3[16] = iArr3[16] ^ (d2[0] ^ d2[8]);
            iArr3[15] = iArr3[15] ^ d2[7];
            iArr3[14] = iArr3[14] ^ d2[6];
            iArr3[13] = iArr3[13] ^ d2[5];
            iArr3[12] = iArr3[12] ^ d2[4];
            iArr3[11] = iArr3[11] ^ d2[3];
            iArr3[10] = iArr3[10] ^ d2[2];
            iArr3[9] = iArr3[9] ^ d2[1];
            iArr3[8] = iArr3[8] ^ d2[0];
            iArr5[0] = iArr5[0] ^ iArr4[0];
            iArr5[1] = iArr5[1] ^ iArr4[1];
            iArr5[2] = iArr5[2] ^ iArr4[2];
            iArr5[3] = iArr5[3] ^ iArr4[3];
            iArr5[4] = iArr5[4] ^ iArr4[4];
            iArr5[5] = iArr5[5] ^ iArr4[5];
            iArr5[6] = iArr5[6] ^ iArr4[6];
            iArr5[7] = iArr5[7] ^ iArr4[7];
            iArr7[0] = iArr7[0] ^ iArr6[0];
            iArr7[1] = iArr7[1] ^ iArr6[1];
            iArr7[2] = iArr7[2] ^ iArr6[2];
            iArr7[3] = iArr7[3] ^ iArr6[3];
            iArr7[4] = iArr7[4] ^ iArr6[4];
            iArr7[5] = iArr7[5] ^ iArr6[5];
            iArr7[6] = iArr7[6] ^ iArr6[6];
            iArr7[7] = iArr7[7] ^ iArr6[7];
            int[] d3 = d(iArr5, iArr7);
            iArr3[23] = iArr3[23] ^ d3[15];
            iArr3[22] = iArr3[22] ^ d3[14];
            iArr3[21] = iArr3[21] ^ d3[13];
            iArr3[20] = iArr3[20] ^ d3[12];
            iArr3[19] = iArr3[19] ^ d3[11];
            iArr3[18] = iArr3[18] ^ d3[10];
            iArr3[17] = iArr3[17] ^ d3[9];
            iArr3[16] = iArr3[16] ^ d3[8];
            iArr3[15] = iArr3[15] ^ d3[7];
            iArr3[14] = iArr3[14] ^ d3[6];
            iArr3[13] = iArr3[13] ^ d3[5];
            iArr3[12] = iArr3[12] ^ d3[4];
            iArr3[11] = iArr3[11] ^ d3[3];
            iArr3[10] = iArr3[10] ^ d3[2];
            iArr3[9] = iArr3[9] ^ d3[1];
            iArr3[8] = d3[0] ^ iArr3[8];
            int[] d4 = d(iArr4, iArr6);
            iArr3[23] = iArr3[23] ^ d4[15];
            iArr3[22] = iArr3[22] ^ d4[14];
            iArr3[21] = iArr3[21] ^ d4[13];
            iArr3[20] = iArr3[20] ^ d4[12];
            iArr3[19] = iArr3[19] ^ d4[11];
            iArr3[18] = iArr3[18] ^ d4[10];
            iArr3[17] = iArr3[17] ^ d4[9];
            iArr3[16] = iArr3[16] ^ d4[8];
            iArr3[15] = iArr3[15] ^ (d4[7] ^ d4[15]);
            iArr3[14] = iArr3[14] ^ (d4[6] ^ d4[14]);
            iArr3[13] = iArr3[13] ^ (d4[5] ^ d4[13]);
            iArr3[12] = iArr3[12] ^ (d4[4] ^ d4[12]);
            iArr3[11] = iArr3[11] ^ (d4[3] ^ d4[11]);
            iArr3[10] = iArr3[10] ^ (d4[2] ^ d4[10]);
            iArr3[9] = iArr3[9] ^ (d4[1] ^ d4[9]);
            iArr3[8] = iArr3[8] ^ (d4[0] ^ d4[8]);
            iArr3[7] = iArr3[7] ^ d4[7];
            iArr3[6] = iArr3[6] ^ d4[6];
            iArr3[5] = iArr3[5] ^ d4[5];
            iArr3[4] = iArr3[4] ^ d4[4];
            iArr3[3] = iArr3[3] ^ d4[3];
            iArr3[2] = iArr3[2] ^ d4[2];
            iArr3[1] = iArr3[1] ^ d4[1];
            iArr3[0] = d4[0] ^ iArr3[0];
            gF2Polynomial2.c = iArr3;
            return gF2Polynomial2;
        } else {
            int i2 = g[IntegerFunctions.floorLog(i - 1)];
            int i3 = ((i2 - 1) >> 5) + 1;
            GF2Polynomial b2 = b(i3);
            GF2Polynomial g2 = g(i3);
            GF2Polynomial b3 = gF2Polynomial.b(i3);
            GF2Polynomial g3 = gF2Polynomial.g(i3);
            GF2Polynomial a3 = g2.a(g3);
            GF2Polynomial a4 = b2.a(b3);
            b2.addToThis(g2);
            b3.addToThis(g3);
            GF2Polynomial a5 = b2.a(b3);
            gF2Polynomial2.shiftLeftAddThis(a3, i2 << 1);
            gF2Polynomial2.shiftLeftAddThis(a3, i2);
            gF2Polynomial2.shiftLeftAddThis(a5, i2);
            gF2Polynomial2.shiftLeftAddThis(a4, i2);
            gF2Polynomial2.addToThis(a4);
            return gF2Polynomial2;
        }
    }

    public GF2Polynomial add(GF2Polynomial gF2Polynomial) {
        return xor(gF2Polynomial);
    }

    public void addToThis(GF2Polynomial gF2Polynomial) {
        expandN(gF2Polynomial.a);
        xorThisBy(gF2Polynomial);
    }

    public void assignAll() {
        for (int i = 0; i < this.b; i++) {
            this.c[i] = -1;
        }
        h();
    }

    public void assignOne() {
        for (int i = 1; i < this.b; i++) {
            this.c[i] = 0;
        }
        this.c[0] = 1;
    }

    public void assignX() {
        for (int i = 1; i < this.b; i++) {
            this.c[i] = 0;
        }
        this.c[0] = 2;
    }

    public void assignZero() {
        for (int i = 0; i < this.b; i++) {
            this.c[i] = 0;
        }
    }

    public final GF2Polynomial b(int i) {
        GF2Polynomial gF2Polynomial = new GF2Polynomial(i << 5);
        System.arraycopy(this.c, 0, gF2Polynomial.c, 0, Math.min(i, this.b));
        return gF2Polynomial;
    }

    public Object clone() {
        return new GF2Polynomial(this);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x004d: APUT  
      (r0v1 org.spongycastle.pqc.math.linearalgebra.GF2Polynomial[])
      (0 ??[int, short, byte, char])
      (r1v0 org.spongycastle.pqc.math.linearalgebra.GF2Polynomial)
     */
    public GF2Polynomial[] divide(GF2Polynomial gF2Polynomial) throws RuntimeException {
        GF2Polynomial[] gF2PolynomialArr = new GF2Polynomial[2];
        GF2Polynomial gF2Polynomial2 = new GF2Polynomial(this.a);
        GF2Polynomial gF2Polynomial3 = new GF2Polynomial(this);
        GF2Polynomial gF2Polynomial4 = new GF2Polynomial(gF2Polynomial);
        if (!gF2Polynomial4.isZero()) {
            gF2Polynomial3.reduceN();
            gF2Polynomial4.reduceN();
            int i = gF2Polynomial3.a;
            int i2 = gF2Polynomial4.a;
            if (i < i2) {
                gF2PolynomialArr[0] = new GF2Polynomial(0);
                gF2PolynomialArr[1] = gF2Polynomial3;
                return gF2PolynomialArr;
            }
            int i3 = i - i2;
            gF2Polynomial2.expandN(i3 + 1);
            while (i3 >= 0) {
                gF2Polynomial3.subtractFromThis(gF2Polynomial4.shiftLeft(i3));
                gF2Polynomial3.reduceN();
                gF2Polynomial2.xorBit(i3);
                i3 = gF2Polynomial3.a - gF2Polynomial4.a;
            }
            gF2PolynomialArr[0] = gF2Polynomial2;
            gF2PolynomialArr[1] = gF2Polynomial3;
            return gF2PolynomialArr;
        }
        throw new RuntimeException();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof GF2Polynomial)) {
            return false;
        }
        GF2Polynomial gF2Polynomial = (GF2Polynomial) obj;
        if (this.a != gF2Polynomial.a) {
            return false;
        }
        for (int i = 0; i < this.b; i++) {
            if (this.c[i] != gF2Polynomial.c[i]) {
                return false;
            }
        }
        return true;
    }

    public void expandN(int i) {
        if (this.a < i) {
            this.a = i;
            int i2 = ((i - 1) >>> 5) + 1;
            int i3 = this.b;
            if (i3 < i2) {
                int[] iArr = this.c;
                if (iArr.length >= i2) {
                    while (i3 < i2) {
                        this.c[i3] = 0;
                        i3++;
                    }
                    this.b = i2;
                    return;
                }
                int[] iArr2 = new int[i2];
                System.arraycopy(iArr, 0, iArr2, 0, i3);
                this.b = i2;
                this.c = null;
                this.c = iArr2;
            }
        }
    }

    public final GF2Polynomial g(int i) {
        int min = Math.min(i, this.b - i);
        GF2Polynomial gF2Polynomial = new GF2Polynomial(min << 5);
        if (this.b >= i) {
            System.arraycopy(this.c, i, gF2Polynomial.c, 0, min);
        }
        return gF2Polynomial;
    }

    public GF2Polynomial gcd(GF2Polynomial gF2Polynomial) throws RuntimeException {
        if (isZero() && gF2Polynomial.isZero()) {
            throw new ArithmeticException("Both operands of gcd equal zero.");
        } else if (isZero()) {
            return new GF2Polynomial(gF2Polynomial);
        } else {
            if (gF2Polynomial.isZero()) {
                return new GF2Polynomial(this);
            }
            GF2Polynomial gF2Polynomial2 = new GF2Polynomial(this);
            GF2Polynomial gF2Polynomial3 = new GF2Polynomial(gF2Polynomial);
            GF2Polynomial gF2Polynomial4 = gF2Polynomial2;
            GF2Polynomial gF2Polynomial5 = gF2Polynomial3;
            while (!gF2Polynomial5.isZero()) {
                gF2Polynomial5 = gF2Polynomial4.remainder(gF2Polynomial5);
                gF2Polynomial4 = gF2Polynomial5;
            }
            return gF2Polynomial4;
        }
    }

    public int getBit(int i) {
        if (i < 0) {
            throw new RuntimeException();
        } else if (i > this.a - 1) {
            return 0;
        } else {
            if ((g[i & 31] & this.c[i >>> 5]) != 0) {
                return 1;
            }
            return 0;
        }
    }

    public int getLength() {
        return this.a;
    }

    public final void h() {
        int i = this.a;
        if ((i & 31) != 0) {
            int[] iArr = this.c;
            int i2 = this.b - 1;
            iArr[i2] = h[i & 31] & iArr[i2];
        }
    }

    public int hashCode() {
        return this.c.hashCode() + this.a;
    }

    public GF2Polynomial increase() {
        GF2Polynomial gF2Polynomial = new GF2Polynomial(this);
        gF2Polynomial.increaseThis();
        return gF2Polynomial;
    }

    public void increaseThis() {
        xorBit(0);
    }

    public boolean isIrreducible() {
        if (isZero()) {
            return false;
        }
        GF2Polynomial gF2Polynomial = new GF2Polynomial(this);
        gF2Polynomial.reduceN();
        int i = gF2Polynomial.a;
        int i2 = i - 1;
        GF2Polynomial gF2Polynomial2 = new GF2Polynomial(i, "X");
        for (int i3 = 1; i3 <= (i2 >> 1); i3++) {
            gF2Polynomial2.squareThisPreCalc();
            gF2Polynomial2 = gF2Polynomial2.remainder(gF2Polynomial);
            GF2Polynomial add = gF2Polynomial2.add(new GF2Polynomial(32, "X"));
            if (add.isZero() || !gF2Polynomial.gcd(add).isOne()) {
                return false;
            }
        }
        return true;
    }

    public boolean isOne() {
        for (int i = 1; i < this.b; i++) {
            if (this.c[i] != 0) {
                return false;
            }
        }
        return this.c[0] == 1;
    }

    public boolean isZero() {
        if (this.a == 0) {
            return true;
        }
        for (int i = 0; i < this.b; i++) {
            if (this.c[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public GF2Polynomial multiply(GF2Polynomial gF2Polynomial) {
        int max = Math.max(this.a, gF2Polynomial.a);
        expandN(max);
        gF2Polynomial.expandN(max);
        return a(gF2Polynomial);
    }

    public GF2Polynomial multiplyClassic(GF2Polynomial gF2Polynomial) {
        GF2Polynomial gF2Polynomial2 = new GF2Polynomial(Math.max(this.a, gF2Polynomial.a) << 1);
        GF2Polynomial[] gF2PolynomialArr = new GF2Polynomial[32];
        gF2PolynomialArr[0] = new GF2Polynomial(this);
        for (int i = 1; i <= 31; i++) {
            gF2PolynomialArr[i] = gF2PolynomialArr[i - 1].shiftLeft();
        }
        for (int i2 = 0; i2 < gF2Polynomial.b; i2++) {
            for (int i3 = 0; i3 <= 31; i3++) {
                if ((gF2Polynomial.c[i2] & g[i3]) != 0) {
                    gF2Polynomial2.xorThisBy(gF2PolynomialArr[i3]);
                }
            }
            for (int i4 = 0; i4 <= 31; i4++) {
                GF2Polynomial gF2Polynomial3 = gF2PolynomialArr[i4];
                int i5 = gF2Polynomial3.b + 1;
                gF2Polynomial3.b = i5;
                gF2Polynomial3.a += 32;
                int[] iArr = gF2Polynomial3.c;
                if (i5 <= iArr.length) {
                    int i6 = i5 - 1;
                    while (i6 >= 1) {
                        int[] iArr2 = gF2Polynomial3.c;
                        int i7 = i6 - 1;
                        iArr2[i6] = iArr2[i7];
                        i6 = i7;
                    }
                    gF2Polynomial3.c[0] = 0;
                } else {
                    int[] iArr3 = new int[i5];
                    System.arraycopy(iArr, 0, iArr3, 1, i5 - 1);
                    gF2Polynomial3.c = null;
                    gF2Polynomial3.c = iArr3;
                }
            }
        }
        return gF2Polynomial2;
    }

    public GF2Polynomial quotient(GF2Polynomial gF2Polynomial) throws RuntimeException {
        GF2Polynomial gF2Polynomial2 = new GF2Polynomial(this.a);
        GF2Polynomial gF2Polynomial3 = new GF2Polynomial(this);
        GF2Polynomial gF2Polynomial4 = new GF2Polynomial(gF2Polynomial);
        if (!gF2Polynomial4.isZero()) {
            gF2Polynomial3.reduceN();
            gF2Polynomial4.reduceN();
            int i = gF2Polynomial3.a;
            int i2 = gF2Polynomial4.a;
            if (i < i2) {
                return new GF2Polynomial(0);
            }
            int i3 = i - i2;
            gF2Polynomial2.expandN(i3 + 1);
            while (i3 >= 0) {
                gF2Polynomial3.subtractFromThis(gF2Polynomial4.shiftLeft(i3));
                gF2Polynomial3.reduceN();
                gF2Polynomial2.xorBit(i3);
                i3 = gF2Polynomial3.a - gF2Polynomial4.a;
            }
            return gF2Polynomial2;
        }
        throw new RuntimeException();
    }

    public void randomize() {
        for (int i = 0; i < this.b; i++) {
            this.c[i] = d.nextInt();
        }
        h();
    }

    public void reduceN() {
        int[] iArr;
        int i = this.b;
        while (true) {
            i--;
            iArr = this.c;
            if (iArr[i] != 0 || i <= 0) {
                break;
            }
        }
        int i2 = iArr[i];
        int i3 = 0;
        while (i2 != 0) {
            i2 >>>= 1;
            i3++;
        }
        this.a = (i << 5) + i3;
        this.b = i + 1;
    }

    public GF2Polynomial remainder(GF2Polynomial gF2Polynomial) throws RuntimeException {
        GF2Polynomial gF2Polynomial2 = new GF2Polynomial(this);
        GF2Polynomial gF2Polynomial3 = new GF2Polynomial(gF2Polynomial);
        if (!gF2Polynomial3.isZero()) {
            gF2Polynomial2.reduceN();
            gF2Polynomial3.reduceN();
            int i = gF2Polynomial2.a;
            int i2 = gF2Polynomial3.a;
            if (i < i2) {
                return gF2Polynomial2;
            }
            while (true) {
                int i3 = i - i2;
                if (i3 < 0) {
                    return gF2Polynomial2;
                }
                gF2Polynomial2.subtractFromThis(gF2Polynomial3.shiftLeft(i3));
                gF2Polynomial2.reduceN();
                i = gF2Polynomial2.a;
                i2 = gF2Polynomial3.a;
            }
        } else {
            throw new RuntimeException();
        }
    }

    public void resetBit(int i) throws RuntimeException {
        if (i < 0) {
            throw new RuntimeException();
        } else if (i <= this.a - 1) {
            int[] iArr = this.c;
            int i2 = i >>> 5;
            iArr[i2] = (~g[i & 31]) & iArr[i2];
        }
    }

    public void setBit(int i) throws RuntimeException {
        if (i < 0 || i > this.a - 1) {
            throw new RuntimeException();
        }
        int[] iArr = this.c;
        int i2 = i >>> 5;
        iArr[i2] = g[i & 31] | iArr[i2];
    }

    public GF2Polynomial shiftLeft() {
        GF2Polynomial gF2Polynomial = new GF2Polynomial(this.a + 1, this.c);
        for (int i = gF2Polynomial.b - 1; i >= 1; i--) {
            int[] iArr = gF2Polynomial.c;
            iArr[i] = iArr[i] << 1;
            iArr[i] = iArr[i] | (iArr[i - 1] >>> 31);
        }
        int[] iArr2 = gF2Polynomial.c;
        iArr2[0] = iArr2[0] << 1;
        return gF2Polynomial;
    }

    public void shiftLeftAddThis(GF2Polynomial gF2Polynomial, int i) {
        int i2;
        if (i == 0) {
            addToThis(gF2Polynomial);
            return;
        }
        expandN(gF2Polynomial.a + i);
        int i3 = i >>> 5;
        for (int i4 = gF2Polynomial.b - 1; i4 >= 0; i4--) {
            int i5 = i4 + i3;
            int i6 = i5 + 1;
            if (i6 < this.b && (i2 = i & 31) != 0) {
                int[] iArr = this.c;
                iArr[i6] = (gF2Polynomial.c[i4] >>> (32 - i2)) ^ iArr[i6];
            }
            int[] iArr2 = this.c;
            iArr2[i5] = iArr2[i5] ^ (gF2Polynomial.c[i4] << (i & 31));
        }
    }

    public void shiftLeftThis() {
        int i = this.a;
        if ((i & 31) == 0) {
            this.a = i + 1;
            int i2 = this.b + 1;
            this.b = i2;
            int[] iArr = this.c;
            if (i2 > iArr.length) {
                int[] iArr2 = new int[i2];
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                this.c = null;
                this.c = iArr2;
            }
            for (int i3 = this.b - 1; i3 >= 1; i3--) {
                int[] iArr3 = this.c;
                int i4 = i3 - 1;
                iArr3[i3] = iArr3[i3] | (iArr3[i4] >>> 31);
                iArr3[i4] = iArr3[i4] << 1;
            }
            return;
        }
        this.a = i + 1;
        for (int i5 = this.b - 1; i5 >= 1; i5--) {
            int[] iArr4 = this.c;
            iArr4[i5] = iArr4[i5] << 1;
            iArr4[i5] = iArr4[i5] | (iArr4[i5 - 1] >>> 31);
        }
        int[] iArr5 = this.c;
        iArr5[0] = iArr5[0] << 1;
    }

    public GF2Polynomial shiftRight() {
        int i;
        GF2Polynomial gF2Polynomial = new GF2Polynomial(this.a - 1);
        int i2 = 0;
        System.arraycopy(this.c, 0, gF2Polynomial.c, 0, gF2Polynomial.b);
        while (true) {
            i = gF2Polynomial.b;
            if (i2 > i - 2) {
                break;
            }
            int[] iArr = gF2Polynomial.c;
            iArr[i2] = iArr[i2] >>> 1;
            int i3 = i2 + 1;
            iArr[i2] = iArr[i2] | (iArr[i3] << 31);
            i2 = i3;
        }
        int[] iArr2 = gF2Polynomial.c;
        int i4 = i - 1;
        iArr2[i4] = iArr2[i4] >>> 1;
        if (i < this.b) {
            int i5 = i - 1;
            iArr2[i5] = (this.c[i] << 31) | iArr2[i5];
        }
        return gF2Polynomial;
    }

    public void shiftRightThis() {
        int i;
        int i2 = this.a - 1;
        this.a = i2;
        this.b = ((i2 - 1) >>> 5) + 1;
        int i3 = 0;
        while (true) {
            i = this.b;
            if (i3 > i - 2) {
                break;
            }
            int[] iArr = this.c;
            iArr[i3] = iArr[i3] >>> 1;
            int i4 = i3 + 1;
            iArr[i3] = iArr[i3] | (iArr[i4] << 31);
            i3 = i4;
        }
        int[] iArr2 = this.c;
        int i5 = i - 1;
        iArr2[i5] = iArr2[i5] >>> 1;
        if ((this.a & 31) == 0) {
            int i6 = i - 1;
            iArr2[i6] = (iArr2[i] << 31) | iArr2[i6];
        }
    }

    public void squareThisBitwise() {
        if (!isZero()) {
            int i = this.b;
            int i2 = i << 1;
            int[] iArr = new int[i2];
            for (int i3 = i - 1; i3 >= 0; i3--) {
                int i4 = this.c[i3];
                int i5 = 1;
                for (int i6 = 0; i6 < 16; i6++) {
                    if ((i4 & 1) != 0) {
                        int i7 = i3 << 1;
                        iArr[i7] = iArr[i7] | i5;
                    }
                    if ((65536 & i4) != 0) {
                        int i8 = (i3 << 1) + 1;
                        iArr[i8] = iArr[i8] | i5;
                    }
                    i5 <<= 2;
                    i4 >>>= 1;
                }
            }
            this.c = null;
            this.c = iArr;
            this.b = i2;
            this.a = (this.a << 1) - 1;
        }
    }

    public void squareThisPreCalc() {
        if (!isZero()) {
            int length = this.c.length;
            int i = this.b;
            if (length >= (i << 1)) {
                for (int i2 = i - 1; i2 >= 0; i2--) {
                    int[] iArr = this.c;
                    int i3 = i2 << 1;
                    short[] sArr = f;
                    iArr[i3 + 1] = sArr[(iArr[i2] & 16711680) >>> 16] | (sArr[(iArr[i2] & ViewCompat.MEASURED_STATE_MASK) >>> 24] << 16);
                    iArr[i3] = sArr[iArr[i2] & 255] | (sArr[(iArr[i2] & 65280) >>> 8] << 16);
                }
                this.b <<= 1;
                this.a = (this.a << 1) - 1;
                return;
            }
            int[] iArr2 = new int[(i << 1)];
            int i4 = 0;
            while (true) {
                int i5 = this.b;
                if (i4 < i5) {
                    int i6 = i4 << 1;
                    short[] sArr2 = f;
                    int[] iArr3 = this.c;
                    iArr2[i6] = sArr2[iArr3[i4] & 255] | (sArr2[(iArr3[i4] & 65280) >>> 8] << 16);
                    iArr2[i6 + 1] = (sArr2[(iArr3[i4] & ViewCompat.MEASURED_STATE_MASK) >>> 24] << 16) | sArr2[(iArr3[i4] & 16711680) >>> 16];
                    i4++;
                } else {
                    this.c = null;
                    this.c = iArr2;
                    this.b = i5 << 1;
                    this.a = (this.a << 1) - 1;
                    return;
                }
            }
        }
    }

    public GF2Polynomial subtract(GF2Polynomial gF2Polynomial) {
        return xor(gF2Polynomial);
    }

    public void subtractFromThis(GF2Polynomial gF2Polynomial) {
        expandN(gF2Polynomial.a);
        xorThisBy(gF2Polynomial);
    }

    public boolean testBit(int i) {
        if (i < 0) {
            throw new RuntimeException();
        } else if (i > this.a - 1) {
            return false;
        } else {
            if ((g[i & 31] & this.c[i >>> 5]) != 0) {
                return true;
            }
            return false;
        }
    }

    public byte[] toByteArray() {
        int i = ((this.a - 1) >> 3) + 1;
        int i2 = i & 3;
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < (i >> 2); i3++) {
            int i4 = (i - (i3 << 2)) - 1;
            int[] iArr = this.c;
            bArr[i4] = (byte) (255 & iArr[i3]);
            bArr[i4 - 1] = (byte) ((iArr[i3] & 65280) >>> 8);
            bArr[i4 - 2] = (byte) ((iArr[i3] & 16711680) >>> 16);
            bArr[i4 - 3] = (byte) ((iArr[i3] & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        }
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = ((i2 - i5) - 1) << 3;
            bArr[i5] = (byte) ((this.c[this.b - 1] & (255 << i6)) >>> i6);
        }
        return bArr;
    }

    public BigInteger toFlexiBigInt() {
        if (this.a == 0 || isZero()) {
            return new BigInteger(0, new byte[0]);
        }
        return new BigInteger(1, toByteArray());
    }

    public int[] toIntegerArray() {
        int i = this.b;
        int[] iArr = new int[i];
        System.arraycopy(this.c, 0, iArr, 0, i);
        return iArr;
    }

    public String toString(int i) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        String[] strArr = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", NativeContentAd.ASSET_HEADLINE, "1010", "1011", "1100", "1101", "1110", "1111"};
        String str = new String();
        if (i != 16) {
            int i2 = this.b;
            while (true) {
                i2--;
                if (i2 < 0) {
                    break;
                }
                StringBuilder L = a.L(str);
                L.append(strArr[(this.c[i2] >>> 28) & 15]);
                StringBuilder L2 = a.L(L.toString());
                L2.append(strArr[(this.c[i2] >>> 24) & 15]);
                StringBuilder L3 = a.L(L2.toString());
                L3.append(strArr[(this.c[i2] >>> 20) & 15]);
                StringBuilder L4 = a.L(L3.toString());
                L4.append(strArr[(this.c[i2] >>> 16) & 15]);
                StringBuilder L5 = a.L(L4.toString());
                L5.append(strArr[(this.c[i2] >>> 12) & 15]);
                StringBuilder L6 = a.L(L5.toString());
                L6.append(strArr[(this.c[i2] >>> 8) & 15]);
                StringBuilder L7 = a.L(L6.toString());
                L7.append(strArr[(this.c[i2] >>> 4) & 15]);
                StringBuilder L8 = a.L(L7.toString());
                L8.append(strArr[this.c[i2] & 15]);
                str = a.c3(L8.toString(), " ");
            }
        } else {
            int i3 = this.b;
            while (true) {
                i3--;
                if (i3 < 0) {
                    break;
                }
                StringBuilder L9 = a.L(str);
                L9.append(cArr[(this.c[i3] >>> 28) & 15]);
                StringBuilder L10 = a.L(L9.toString());
                L10.append(cArr[(this.c[i3] >>> 24) & 15]);
                StringBuilder L11 = a.L(L10.toString());
                L11.append(cArr[(this.c[i3] >>> 20) & 15]);
                StringBuilder L12 = a.L(L11.toString());
                L12.append(cArr[(this.c[i3] >>> 16) & 15]);
                StringBuilder L13 = a.L(L12.toString());
                L13.append(cArr[(this.c[i3] >>> 12) & 15]);
                StringBuilder L14 = a.L(L13.toString());
                L14.append(cArr[(this.c[i3] >>> 8) & 15]);
                StringBuilder L15 = a.L(L14.toString());
                L15.append(cArr[(this.c[i3] >>> 4) & 15]);
                StringBuilder L16 = a.L(L15.toString());
                L16.append(cArr[this.c[i3] & 15]);
                str = a.c3(L16.toString(), " ");
            }
        }
        return str;
    }

    public boolean vectorMult(GF2Polynomial gF2Polynomial) throws RuntimeException {
        if (this.a == gF2Polynomial.a) {
            boolean z = false;
            for (int i = 0; i < this.b; i++) {
                int i2 = this.c[i] & gF2Polynomial.c[i];
                boolean[] zArr = e;
                z = (((z ^ zArr[i2 & 255]) ^ zArr[(i2 >>> 8) & 255]) ^ zArr[(i2 >>> 16) & 255]) ^ zArr[(i2 >>> 24) & 255];
            }
            return z;
        }
        throw new RuntimeException();
    }

    public GF2Polynomial xor(GF2Polynomial gF2Polynomial) {
        GF2Polynomial gF2Polynomial2;
        int min = Math.min(this.b, gF2Polynomial.b);
        int i = 0;
        if (this.a >= gF2Polynomial.a) {
            gF2Polynomial2 = new GF2Polynomial(this);
            while (i < min) {
                int[] iArr = gF2Polynomial2.c;
                iArr[i] = iArr[i] ^ gF2Polynomial.c[i];
                i++;
            }
        } else {
            gF2Polynomial2 = new GF2Polynomial(gF2Polynomial);
            while (i < min) {
                int[] iArr2 = gF2Polynomial2.c;
                iArr2[i] = iArr2[i] ^ this.c[i];
                i++;
            }
        }
        gF2Polynomial2.h();
        return gF2Polynomial2;
    }

    public void xorBit(int i) throws RuntimeException {
        if (i < 0 || i > this.a - 1) {
            throw new RuntimeException();
        }
        int[] iArr = this.c;
        int i2 = i >>> 5;
        iArr[i2] = g[i & 31] ^ iArr[i2];
    }

    public void xorThisBy(GF2Polynomial gF2Polynomial) {
        for (int i = 0; i < Math.min(this.b, gF2Polynomial.b); i++) {
            int[] iArr = this.c;
            iArr[i] = iArr[i] ^ gF2Polynomial.c[i];
        }
        h();
    }

    public void randomize(Random random) {
        for (int i = 0; i < this.b; i++) {
            this.c[i] = random.nextInt();
        }
        h();
    }

    public GF2Polynomial(int i, Random random) {
        i = i < 1 ? 1 : i;
        int i2 = ((i - 1) >> 5) + 1;
        this.b = i2;
        this.c = new int[i2];
        this.a = i;
        randomize(random);
    }

    public GF2Polynomial shiftLeft(int i) {
        GF2Polynomial gF2Polynomial = new GF2Polynomial(this.a + i, this.c);
        if (i >= 32) {
            int i2 = i >>> 5;
            int i3 = gF2Polynomial.b;
            int[] iArr = gF2Polynomial.c;
            if (i3 <= iArr.length) {
                while (true) {
                    i3--;
                    if (i3 < i2) {
                        break;
                    }
                    int[] iArr2 = gF2Polynomial.c;
                    iArr2[i3] = iArr2[i3 - i2];
                }
                for (int i4 = 0; i4 < i2; i4++) {
                    gF2Polynomial.c[i4] = 0;
                }
            } else {
                int[] iArr3 = new int[i3];
                System.arraycopy(iArr, 0, iArr3, i2, i3 - i2);
                gF2Polynomial.c = null;
                gF2Polynomial.c = iArr3;
            }
        }
        int i5 = i & 31;
        if (i5 != 0) {
            for (int i6 = gF2Polynomial.b - 1; i6 >= 1; i6--) {
                int[] iArr4 = gF2Polynomial.c;
                iArr4[i6] = iArr4[i6] << i5;
                iArr4[i6] = iArr4[i6] | (iArr4[i6 - 1] >>> (32 - i5));
            }
            int[] iArr5 = gF2Polynomial.c;
            iArr5[0] = iArr5[0] << i5;
        }
        return gF2Polynomial;
    }

    public GF2Polynomial(int i, String str) {
        i = i < 1 ? 1 : i;
        int i2 = ((i - 1) >> 5) + 1;
        this.b = i2;
        this.c = new int[i2];
        this.a = i;
        if (str.equalsIgnoreCase("ZERO")) {
            assignZero();
        } else if (str.equalsIgnoreCase("ONE")) {
            assignOne();
        } else if (str.equalsIgnoreCase("RANDOM")) {
            randomize();
        } else if (str.equalsIgnoreCase("X")) {
            assignX();
        } else if (str.equalsIgnoreCase("ALL")) {
            assignAll();
        } else {
            throw new IllegalArgumentException(a.e3("Error: GF2Polynomial was called using ", str, " as value!"));
        }
    }

    public GF2Polynomial(int i, int[] iArr) {
        i = i < 1 ? 1 : i;
        int i2 = ((i - 1) >> 5) + 1;
        this.b = i2;
        this.c = new int[i2];
        this.a = i;
        System.arraycopy(iArr, 0, this.c, 0, Math.min(i2, iArr.length));
        h();
    }

    public GF2Polynomial(int i, byte[] bArr) {
        int i2;
        i = i < 1 ? 1 : i;
        int i3 = ((i - 1) >> 5) + 1;
        this.b = i3;
        this.c = new int[i3];
        this.a = i;
        int min = Math.min(((bArr.length - 1) >> 2) + 1, i3);
        int i4 = 0;
        while (true) {
            i2 = min - 1;
            if (i4 >= i2) {
                break;
            }
            int length = (bArr.length - (i4 << 2)) - 1;
            int[] iArr = this.c;
            iArr[i4] = bArr[length] & 255;
            iArr[i4] = (65280 & (bArr[length - 1] << 8)) | iArr[i4];
            iArr[i4] = (16711680 & (bArr[length - 2] << Ascii.DLE)) | iArr[i4];
            iArr[i4] = ((bArr[length - 3] << Ascii.CAN) & ViewCompat.MEASURED_STATE_MASK) | iArr[i4];
            i4++;
        }
        int length2 = (bArr.length - (i2 << 2)) - 1;
        int[] iArr2 = this.c;
        iArr2[i2] = bArr[length2] & 255;
        if (length2 > 0) {
            iArr2[i2] = (65280 & (bArr[length2 - 1] << 8)) | iArr2[i2];
        }
        if (length2 > 1) {
            iArr2[i2] = iArr2[i2] | (16711680 & (bArr[length2 - 2] << Ascii.DLE));
        }
        if (length2 > 2) {
            iArr2[i2] = ((bArr[length2 - 3] << Ascii.CAN) & ViewCompat.MEASURED_STATE_MASK) | iArr2[i2];
        }
        h();
        reduceN();
    }

    public GF2Polynomial(int i, BigInteger bigInteger) {
        i = i < 1 ? 1 : i;
        int i2 = ((i - 1) >> 5) + 1;
        this.b = i2;
        this.c = new int[i2];
        this.a = i;
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray[0] == 0) {
            int length = byteArray.length - 1;
            byte[] bArr = new byte[length];
            System.arraycopy(byteArray, 1, bArr, 0, length);
            byteArray = bArr;
        }
        int length2 = byteArray.length & 3;
        int length3 = ((byteArray.length - 1) >> 2) + 1;
        for (int i3 = 0; i3 < length2; i3++) {
            int[] iArr = this.c;
            int i4 = length3 - 1;
            iArr[i4] = iArr[i4] | ((byteArray[i3] & 255) << (((length2 - 1) - i3) << 3));
        }
        for (int i5 = 0; i5 <= ((byteArray.length - 4) >> 2); i5++) {
            int length4 = (byteArray.length - 1) - (i5 << 2);
            int[] iArr2 = this.c;
            iArr2[i5] = byteArray[length4] & 255;
            iArr2[i5] = iArr2[i5] | ((byteArray[length4 - 1] << 8) & 65280);
            iArr2[i5] = iArr2[i5] | ((byteArray[length4 - 2] << Ascii.DLE) & 16711680);
            iArr2[i5] = ((byteArray[length4 - 3] << Ascii.CAN) & ViewCompat.MEASURED_STATE_MASK) | iArr2[i5];
        }
        int i6 = this.a;
        if ((i6 & 31) != 0) {
            int[] iArr3 = this.c;
            int i7 = this.b - 1;
            iArr3[i7] = h[i6 & 31] & iArr3[i7];
        }
        reduceN();
    }

    public GF2Polynomial(GF2Polynomial gF2Polynomial) {
        this.a = gF2Polynomial.a;
        this.b = gF2Polynomial.b;
        this.c = IntUtils.clone(gF2Polynomial.c);
    }
}
