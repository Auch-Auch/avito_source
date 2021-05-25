package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Map;
@VisibleForTesting
public final class zzeh {
    private final long zzabb;
    private final long zzagy;
    private final long zzagz;
    private String zzaha;
    private String zzant;
    private Map<String, String> zzanu;
    private String zzanv;

    public zzeh(long j, long j2, long j3) {
        this.zzagy = j;
        this.zzabb = j2;
        this.zzagz = j3;
    }

    public final void zzbc(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim())) {
            this.zzaha = str;
        }
    }

    public final void zzbt(String str) {
        this.zzant = str;
    }

    public final void zzbu(String str) {
        this.zzanv = str;
    }

    public final void zzg(Map<String, String> map) {
        this.zzanu = map;
    }

    public final long zzih() {
        return this.zzagy;
    }

    public final long zzii() {
        return this.zzagz;
    }

    public final String zzij() {
        return this.zzaha;
    }

    public final String zzkj() {
        return this.zzant;
    }

    public final Map<String, String> zzkk() {
        return this.zzanu;
    }

    public final String zzkl() {
        return this.zzanv;
    }
}
