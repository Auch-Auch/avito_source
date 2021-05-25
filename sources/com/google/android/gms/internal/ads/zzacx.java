package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
public final class zzacx {
    private static zzaca<Long> zzdbu = zzaca.zzb("gads:ad_loader:timeout_ms", (long) DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS);
    public static zzaca<Long> zzdbv = zzaca.zzb("gads:rendering:timeout_ms", (long) DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS);
    private static zzaca<Long> zzdbw = zzaca.zzb("gads:resolve_future:default_timeout_ms", 30000L);
}
