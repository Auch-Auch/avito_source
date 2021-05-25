package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.util.Arrays;
import org.spongycastle.asn1.cmc.BodyPartID;
public final class zzeef {
    private static void zza(byte[] bArr, long j, int i) {
        int i2 = 0;
        while (i2 < 4) {
            bArr[i + i2] = (byte) ((int) (255 & j));
            i2++;
            j >>= 8;
        }
    }

    public static byte[] zze(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 32) {
            long zzg = zzg(bArr, 0, 0) & 67108863;
            int i = 3;
            long zzg2 = zzg(bArr, 3, 2) & 67108611;
            long zzg3 = zzg(bArr, 6, 4) & 67092735;
            long zzg4 = zzg(bArr, 9, 6) & 66076671;
            long zzg5 = zzg(bArr, 12, 8) & 1048575;
            long j = zzg2 * 5;
            long j2 = zzg3 * 5;
            long j3 = zzg4 * 5;
            long j4 = zzg5 * 5;
            int i2 = 17;
            byte[] bArr3 = new byte[17];
            long j5 = 0;
            long j6 = 0;
            long j7 = 0;
            long j8 = 0;
            long j9 = 0;
            int i3 = 0;
            while (i3 < bArr2.length) {
                int min = Math.min(16, bArr2.length - i3);
                System.arraycopy(bArr2, i3, bArr3, 0, min);
                bArr3[min] = 1;
                if (min != 16) {
                    Arrays.fill(bArr3, min + 1, i2, (byte) 0);
                }
                long zzg6 = j9 + zzg(bArr3, 0, 0);
                long zzg7 = j5 + zzg(bArr3, i, 2);
                long zzg8 = j6 + zzg(bArr3, 6, 4);
                long zzg9 = j7 + zzg(bArr3, 9, 6);
                long zzg10 = j8 + (zzg(bArr3, 12, 8) | ((long) (bArr3[16] << Ascii.CAN)));
                long j10 = (zzg10 * j) + (zzg9 * j2) + (zzg8 * j3) + (zzg7 * j4) + (zzg6 * zzg);
                long j11 = (zzg10 * j2) + (zzg9 * j3) + (zzg8 * j4) + (zzg7 * zzg) + (zzg6 * zzg2);
                long j12 = (zzg10 * j3) + (zzg9 * j4) + (zzg8 * zzg) + (zzg7 * zzg2) + (zzg6 * zzg3);
                long j13 = (zzg9 * zzg) + (zzg8 * zzg2) + (zzg7 * zzg3) + (zzg6 * zzg4);
                long j14 = zzg9 * zzg2;
                long j15 = zzg10 * zzg;
                long j16 = j11 + (j10 >> 26);
                long j17 = j12 + (j16 >> 26);
                long j18 = (zzg10 * j4) + j13 + (j17 >> 26);
                long j19 = j15 + j14 + (zzg8 * zzg3) + (zzg7 * zzg4) + (zzg6 * zzg5) + (j18 >> 26);
                long j20 = j19 >> 26;
                j8 = j19 & 67108863;
                long j21 = (j20 * 5) + (j10 & 67108863);
                i3 += 16;
                j6 = j17 & 67108863;
                j7 = j18 & 67108863;
                i2 = 17;
                i = 3;
                j9 = j21 & 67108863;
                j5 = (j16 & 67108863) + (j21 >> 26);
            }
            long j22 = j6 + (j5 >> 26);
            long j23 = j22 & 67108863;
            long j24 = j7 + (j22 >> 26);
            long j25 = j24 & 67108863;
            long j26 = j8 + (j24 >> 26);
            long j27 = j26 & 67108863;
            long j28 = ((j26 >> 26) * 5) + j9;
            long j29 = j28 >> 26;
            long j30 = j28 & 67108863;
            long j31 = (j5 & 67108863) + j29;
            long j32 = j30 + 5;
            long j33 = j32 & 67108863;
            long j34 = (j32 >> 26) + j31;
            long j35 = j23 + (j34 >> 26);
            long j36 = j25 + (j35 >> 26);
            long j37 = (j27 + (j36 >> 26)) - 67108864;
            long j38 = j37 >> 63;
            long j39 = j30 & j38;
            long j40 = j31 & j38;
            long j41 = j23 & j38;
            long j42 = j25 & j38;
            long j43 = j27 & j38;
            long j44 = ~j38;
            long j45 = j40 | (j34 & 67108863 & j44);
            long j46 = j41 | (j35 & 67108863 & j44);
            long j47 = j42 | (j36 & 67108863 & j44);
            long j48 = (j39 | (j33 & j44) | (j45 << 26)) & BodyPartID.bodyIdMax;
            long j49 = ((j45 >> 6) | (j46 << 20)) & BodyPartID.bodyIdMax;
            long j50 = ((j46 >> 12) | (j47 << 14)) & BodyPartID.bodyIdMax;
            long j51 = ((j47 >> 18) | ((j43 | (j37 & j44)) << 8)) & BodyPartID.bodyIdMax;
            long zzf = j48 + zzf(bArr, 16);
            long j52 = zzf & BodyPartID.bodyIdMax;
            long zzf2 = j49 + zzf(bArr, 20) + (zzf >> 32);
            long j53 = zzf2 & BodyPartID.bodyIdMax;
            long zzf3 = j50 + zzf(bArr, 24) + (zzf2 >> 32);
            long j54 = zzf3 & BodyPartID.bodyIdMax;
            long zzf4 = (j51 + zzf(bArr, 28) + (zzf3 >> 32)) & BodyPartID.bodyIdMax;
            byte[] bArr4 = new byte[16];
            zza(bArr4, j52, 0);
            zza(bArr4, j53, 4);
            zza(bArr4, j54, 8);
            zza(bArr4, zzf4, 12);
            return bArr4;
        }
        throw new IllegalArgumentException("The key length in bytes must be 32.");
    }

    private static long zzf(byte[] bArr, int i) {
        return ((long) (((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16))) & BodyPartID.bodyIdMax;
    }

    private static long zzg(byte[] bArr, int i, int i2) {
        return (zzf(bArr, i) >> i2) & 67108863;
    }
}
