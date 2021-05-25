package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import javax.annotation.Nullable;
public final class zzdf {
    public final String zza;
    public final Uri zzb;
    public final String zzc;
    public final String zzd;
    public final boolean zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    @Nullable
    public final zzdp<Context, Boolean> zzi;

    public zzdf(Uri uri) {
        this(null, uri, "", "", false, false, false, false, null);
    }

    public final zzcw<Long> zza(String str, long j) {
        return zzcw.zzb(this, str, j, true);
    }

    private zzdf(String str, Uri uri, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, @Nullable zzdp<Context, Boolean> zzdp) {
        this.zza = null;
        this.zzb = uri;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = false;
        this.zzf = false;
        this.zzg = false;
        this.zzh = false;
        this.zzi = null;
    }

    public final zzcw<Boolean> zza(String str, boolean z) {
        return zzcw.zzb(this, str, z, true);
    }

    public final zzcw<Double> zza(String str, double d) {
        return zzcw.zzb(this, str, -3.0d, true);
    }

    public final zzcw<String> zza(String str, String str2) {
        return zzcw.zzb(this, str, str2, true);
    }
}
