package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
public final class zzak {
    public final String zza;
    public final String zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;
    public final long zzf;
    public final long zzg;
    public final Long zzh;
    public final Long zzi;
    public final Long zzj;
    public final Boolean zzk;

    public zzak(String str, String str2, long j, long j2, long j3, long j4, long j5, Long l, Long l2, Long l3, Boolean bool) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        boolean z = true;
        Preconditions.checkArgument(j >= 0);
        Preconditions.checkArgument(j2 >= 0);
        Preconditions.checkArgument(j3 >= 0);
        Preconditions.checkArgument(j5 < 0 ? false : z);
        this.zza = str;
        this.zzb = str2;
        this.zzc = j;
        this.zzd = j2;
        this.zze = j3;
        this.zzf = j4;
        this.zzg = j5;
        this.zzh = l;
        this.zzi = l2;
        this.zzj = l3;
        this.zzk = bool;
    }

    public final zzak zza(long j) {
        return new zzak(this.zza, this.zzb, this.zzc, this.zzd, this.zze, j, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk);
    }

    public final zzak zza(long j, long j2) {
        return new zzak(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, j, Long.valueOf(j2), this.zzi, this.zzj, this.zzk);
    }

    public final zzak zza(Long l, Long l2, Boolean bool) {
        return new zzak(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, l, l2, (bool == null || bool.booleanValue()) ? bool : null);
    }

    public zzak(String str, String str2, long j, long j2, long j3, long j4, Long l, Long l2, Long l3, Boolean bool) {
        this(str, str2, 0, 0, 0, j3, 0, null, null, null, null);
    }
}
