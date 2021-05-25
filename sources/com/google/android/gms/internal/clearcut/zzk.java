package com.google.android.gms.internal.clearcut;

import a2.b.a.a.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.spongycastle.asn1.cmc.BodyPartID;
public final class zzk {
    private static int zza(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private static long zza(long j, long j2, long j3) {
        long j4 = (j ^ j2) * j3;
        long j5 = ((j4 ^ (j4 >>> 47)) ^ j2) * j3;
        return (j5 ^ (j5 >>> 47)) * j3;
    }

    public static long zza(byte[] bArr) {
        int length = bArr.length;
        if (length < 0 || length > bArr.length) {
            throw new IndexOutOfBoundsException(a.m2(67, "Out of bound index with offput: 0 and length: ", length));
        }
        int i = 37;
        long j = -5435081209227447693L;
        if (length <= 32) {
            if (length > 16) {
                long j2 = ((long) (length << 1)) - 7286425919675154353L;
                long zzb = zzb(bArr, 0) * -5435081209227447693L;
                long zzb2 = zzb(bArr, 8);
                int i2 = length + 0;
                long zzb3 = zzb(bArr, i2 - 8) * j2;
                return zza((zzb(bArr, i2 - 16) * -7286425919675154353L) + Long.rotateRight(zzb3, 30) + Long.rotateRight(zzb + zzb2, 43), Long.rotateRight(zzb2 - 7286425919675154353L, 18) + zzb + zzb3, j2);
            } else if (length >= 8) {
                long j3 = ((long) (length << 1)) - 7286425919675154353L;
                long zzb4 = zzb(bArr, 0) - 7286425919675154353L;
                long zzb5 = zzb(bArr, (length + 0) - 8);
                return zza((Long.rotateRight(zzb5, 37) * j3) + zzb4, (Long.rotateRight(zzb4, 25) + zzb5) * j3, j3);
            } else if (length >= 4) {
                return zza(((long) length) + ((((long) zza(bArr, 0)) & BodyPartID.bodyIdMax) << 3), ((long) zza(bArr, (length + 0) - 4)) & BodyPartID.bodyIdMax, ((long) (length << 1)) - 7286425919675154353L);
            } else if (length <= 0) {
                return -7286425919675154353L;
            } else {
                long j4 = (((long) ((bArr[0] & 255) + ((bArr[(length >> 1) + 0] & 255) << 8))) * -7286425919675154353L) ^ (((long) (length + ((bArr[(length - 1) + 0] & 255) << 2))) * -4348849565147123417L);
                return (j4 ^ (j4 >>> 47)) * -7286425919675154353L;
            }
        } else if (length <= 64) {
            long j5 = ((long) (length << 1)) - 7286425919675154353L;
            long zzb6 = zzb(bArr, 0) * -7286425919675154353L;
            long zzb7 = zzb(bArr, 8);
            int i3 = length + 0;
            long zzb8 = zzb(bArr, i3 - 8) * j5;
            long rotateRight = Long.rotateRight(zzb8, 30) + Long.rotateRight(zzb6 + zzb7, 43) + (zzb(bArr, i3 - 16) * -7286425919675154353L);
            long zza = zza(rotateRight, Long.rotateRight(zzb7 - 7286425919675154353L, 18) + zzb6 + zzb8, j5);
            long zzb9 = zzb(bArr, 16) * j5;
            long zzb10 = zzb(bArr, 24);
            long zzb11 = (rotateRight + zzb(bArr, i3 - 32)) * j5;
            return zza(Long.rotateRight(zzb11, 30) + Long.rotateRight(zzb9 + zzb10, 43) + ((zza + zzb(bArr, i3 - 24)) * j5), Long.rotateRight(zzb10 + zzb6, 18) + zzb9 + zzb11, j5);
        } else {
            long j6 = 2480279821605975764L;
            long[] jArr = new long[2];
            long[] jArr2 = new long[2];
            int i4 = length - 1;
            int i5 = ((i4 / 64) << 6) + 0;
            int i6 = i4 & 63;
            int i7 = (i5 + i6) - 63;
            long zzb12 = zzb(bArr, 0) + 95310865018149119L;
            char c = 0;
            long j7 = 1390051526045402406L;
            int i8 = 0;
            while (true) {
                long rotateRight2 = (Long.rotateRight(((zzb12 + j6) + jArr[c]) + zzb(bArr, i8 + 8), i) * j) ^ jArr2[1];
                long zzb13 = jArr[0] + zzb(bArr, i8 + 40) + (Long.rotateRight(j6 + jArr[1] + zzb(bArr, i8 + 48), 42) * j);
                long rotateRight3 = Long.rotateRight(j7 + jArr2[0], 33) * j;
                zza(bArr, i8, jArr[1] * j, rotateRight2 + jArr2[0], jArr);
                zza(bArr, i8 + 32, jArr2[1] + rotateRight3, zzb13 + zzb(bArr, i8 + 16), jArr2);
                i8 += 64;
                if (i8 == i5) {
                    long j8 = ((rotateRight2 & 255) << 1) - 5435081209227447693L;
                    jArr2[0] = jArr2[0] + ((long) i6);
                    jArr[0] = jArr[0] + jArr2[0];
                    jArr2[0] = jArr2[0] + jArr[0];
                    long rotateRight4 = (Long.rotateRight(((rotateRight3 + zzb13) + jArr[0]) + zzb(bArr, i7 + 8), 37) * j8) ^ (jArr2[1] * 9);
                    long zzb14 = (jArr[0] * 9) + zzb(bArr, i7 + 40) + (Long.rotateRight(zzb13 + jArr[1] + zzb(bArr, i7 + 48), 42) * j8);
                    long rotateRight5 = Long.rotateRight(rotateRight2 + jArr2[0], 33) * j8;
                    zza(bArr, i7, jArr[1] * j8, rotateRight4 + jArr2[0], jArr);
                    zza(bArr, i7 + 32, jArr2[1] + rotateRight5, zzb(bArr, i7 + 16) + zzb14, jArr2);
                    return zza(a.M0((zzb14 >>> 47) ^ zzb14, -4348849565147123417L, zza(jArr[0], jArr2[0], j8), rotateRight4), zza(jArr[1], jArr2[1], j8) + rotateRight5, j8);
                }
                i = 37;
                c = 0;
                i5 = i5;
                i6 = i6;
                j = -5435081209227447693L;
                j6 = zzb13;
                j7 = rotateRight2;
                zzb12 = rotateRight3;
            }
        }
    }

    private static void zza(byte[] bArr, int i, long j, long j2, long[] jArr) {
        long zzb = zzb(bArr, i);
        long zzb2 = zzb(bArr, i + 8);
        long zzb3 = zzb(bArr, i + 16);
        long zzb4 = zzb(bArr, i + 24);
        long j3 = j + zzb;
        long rotateRight = Long.rotateRight(j2 + j3 + zzb4, 21);
        long j4 = zzb2 + j3 + zzb3;
        jArr[0] = j4 + zzb4;
        jArr[1] = Long.rotateRight(j4, 44) + rotateRight + j3;
    }

    private static long zzb(byte[] bArr, int i) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i, 8);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        return wrap.getLong();
    }
}
