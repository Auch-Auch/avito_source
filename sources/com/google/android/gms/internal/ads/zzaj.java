package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
public final class zzaj<T> {
    @Nullable
    public final T result;
    @Nullable
    public final zzn zzbs;
    @Nullable
    public final zzao zzbt;
    public boolean zzbu;

    private zzaj(@Nullable T t, @Nullable zzn zzn) {
        this.zzbu = false;
        this.result = t;
        this.zzbs = zzn;
        this.zzbt = null;
    }

    public static <T> zzaj<T> zza(@Nullable T t, @Nullable zzn zzn) {
        return new zzaj<>(t, zzn);
    }

    public static <T> zzaj<T> zzd(zzao zzao) {
        return new zzaj<>(zzao);
    }

    public final boolean isSuccess() {
        return this.zzbt == null;
    }

    private zzaj(zzao zzao) {
        this.zzbu = false;
        this.result = null;
        this.zzbs = null;
        this.zzbt = zzao;
    }
}
