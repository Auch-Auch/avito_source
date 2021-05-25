package com.google.android.gms.ads;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class AdError {
    public static final String UNDEFINED_DOMAIN = "undefined";
    private final int code;
    @NonNull
    private final String zzacm;
    @NonNull
    private final String zzacn;
    @Nullable
    private final AdError zzaco;

    public AdError(int i, @NonNull String str, @NonNull String str2) {
        this.code = i;
        this.zzacm = str;
        this.zzacn = str2;
        this.zzaco = null;
    }

    @Nullable
    public AdError getCause() {
        return this.zzaco;
    }

    public int getCode() {
        return this.code;
    }

    @NonNull
    public String getDomain() {
        return this.zzacn;
    }

    @NonNull
    public String getMessage() {
        return this.zzacm;
    }

    public AdError(int i, @NonNull String str, @NonNull String str2, @NonNull AdError adError) {
        this.code = i;
        this.zzacm = str;
        this.zzacn = str2;
        this.zzaco = adError;
    }
}
