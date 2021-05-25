package com.google.android.gms.internal.vision;

import android.content.Context;
import android.net.Uri;
import javax.annotation.Nullable;
public final class zzbo {
    public final String zzgt;
    public final Uri zzgu;
    public final String zzgv;
    public final String zzgw;
    public final boolean zzgx;
    public final boolean zzgy;
    public final boolean zzgz;
    public final boolean zzha;
    @Nullable
    public final zzcw<Context, Boolean> zzhb;

    public zzbo(Uri uri) {
        this(null, uri, "", "", false, false, false, false, null);
    }

    public final <T> zzbi<T> zza(String str, T t, zzbp<T> zzbp) {
        return zzbi.zza(this, str, t, zzbp, true);
    }

    public final zzbo zzf(String str) {
        boolean z = this.zzgx;
        if (!z) {
            return new zzbo(this.zzgt, this.zzgu, str, this.zzgw, z, this.zzgy, this.zzgz, this.zzha, this.zzhb);
        }
        throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
    }

    private zzbo(String str, Uri uri, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, @Nullable zzcw<Context, Boolean> zzcw) {
        this.zzgt = str;
        this.zzgu = uri;
        this.zzgv = str2;
        this.zzgw = str3;
        this.zzgx = z;
        this.zzgy = z2;
        this.zzgz = z3;
        this.zzha = z4;
        this.zzhb = zzcw;
    }
}
