package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.PriorityQueue;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
public final class zzrv {
    public static void zza(String[] strArr, int i, int i2, PriorityQueue<zzry> priorityQueue) {
        if (strArr.length < i2) {
            zza(i, zzb(strArr, 0, strArr.length), zza(strArr, 0, strArr.length), strArr.length, priorityQueue);
            return;
        }
        long zzb = zzb(strArr, 0, i2);
        zza(i, zzb, zza(strArr, 0, i2), i2, priorityQueue);
        long zza = zza(16785407, i2 - 1);
        for (int i3 = 1; i3 < (strArr.length - i2) + 1; i3++) {
            int zzbv = zzru.zzbv(strArr[i3 - 1]);
            long zzbv2 = (((long) zzru.zzbv(strArr[(i3 + i2) - 1])) + 2147483647L) % 1073807359;
            zzb = (zzbv2 + (((((zzb + 1073807359) - ((((((long) zzbv) + 2147483647L) % 1073807359) * zza) % 1073807359)) % 1073807359) * 16785407) % 1073807359)) % 1073807359;
            zza(i, zzb, zza(strArr, i3, i2), strArr.length, priorityQueue);
        }
    }

    private static long zzb(String[] strArr, int i, int i2) {
        long zzbv = (((long) zzru.zzbv(strArr[0])) + 2147483647L) % 1073807359;
        for (int i3 = 1; i3 < i2; i3++) {
            zzbv = (((((long) zzru.zzbv(strArr[i3])) + 2147483647L) % 1073807359) + ((zzbv * 16785407) % 1073807359)) % 1073807359;
        }
        return zzbv;
    }

    @VisibleForTesting
    private static void zza(int i, long j, String str, int i2, PriorityQueue<zzry> priorityQueue) {
        zzry zzry = new zzry(j, str, i2);
        if ((priorityQueue.size() != i || (priorityQueue.peek().zzbtv <= zzry.zzbtv && priorityQueue.peek().value <= zzry.value)) && !priorityQueue.contains(zzry)) {
            priorityQueue.add(zzry);
            if (priorityQueue.size() > i) {
                priorityQueue.poll();
            }
        }
    }

    @VisibleForTesting
    private static String zza(String[] strArr, int i, int i2) {
        int i3 = i2 + i;
        if (strArr.length < i3) {
            zzbbd.zzfc("Unable to construct shingle");
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i4 = i3 - 1;
            if (i < i4) {
                sb.append(strArr[i]);
                sb.append(' ');
                i++;
            } else {
                sb.append(strArr[i4]);
                return sb.toString();
            }
        }
    }

    @VisibleForTesting
    private static long zza(long j, int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return j;
        }
        if (i % 2 == 0) {
            return zza((j * j) % 1073807359, i / 2) % 1073807359;
        }
        return ((zza((j * j) % 1073807359, i / 2) % 1073807359) * j) % 1073807359;
    }
}
