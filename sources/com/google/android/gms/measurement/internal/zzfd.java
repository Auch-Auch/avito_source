package com.google.android.gms.measurement.internal;

import a2.b.a.a.a;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public final class zzfd {
    @NonNull
    public String zza;
    @NonNull
    public Bundle zzb;
    @NonNull
    private String zzc;
    private long zzd;

    private zzfd(@NonNull String str, @NonNull String str2, @Nullable Bundle bundle, long j) {
        this.zza = str;
        this.zzc = str2;
        this.zzb = bundle == null ? new Bundle() : bundle;
        this.zzd = j;
    }

    public static zzfd zza(zzao zzao) {
        return new zzfd(zzao.zza, zzao.zzc, zzao.zzb.zzb(), zzao.zzd);
    }

    public final String toString() {
        String str = this.zzc;
        String str2 = this.zza;
        String valueOf = String.valueOf(this.zzb);
        return a.t(a.K(valueOf.length() + a.q0(str2, a.q0(str, 21)), "origin=", str, ",name=", str2), ",params=", valueOf);
    }

    public final zzao zza() {
        return new zzao(this.zza, new zzan(new Bundle(this.zzb)), this.zzc, this.zzd);
    }
}
