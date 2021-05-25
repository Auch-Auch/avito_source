package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import java.util.UUID;
public final class zzha {
    public static final int CHANNEL_OUT_7POINT1_SURROUND = (zzpq.SDK_INT < 23 ? 1020 : 6396);
    public static final UUID UUID_NIL = new UUID(0, 0);
    private static final UUID zzadx = new UUID(1186680826959645954L, -5988876978535335093L);
    private static final UUID zzady = new UUID(-1301668207276963122L, -6645017420763422227L);
    private static final UUID zzadz = new UUID(-7348484286925749626L, -6083546864340672619L);

    public static long zzdm(long j) {
        return j == C.TIME_UNSET ? C.TIME_UNSET : j / 1000;
    }

    public static long zzdn(long j) {
        return j == C.TIME_UNSET ? C.TIME_UNSET : j * 1000;
    }
}
