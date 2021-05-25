package com.google.android.gms.internal.ads;

import java.util.Objects;
public final class zzdqf extends zzdqb {
    private String zzhix;
    private Boolean zzhiy;
    private Boolean zzhiz;

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final zzdqc zzava() {
        String str = "";
        if (this.zzhix == null) {
            str = str.concat(" clientVersion");
        }
        if (this.zzhiy == null) {
            str = String.valueOf(str).concat(" shouldGetAdvertisingId");
        }
        if (this.zzhiz == null) {
            str = String.valueOf(str).concat(" isGooglePlayServicesAvailable");
        }
        if (str.isEmpty()) {
            return new zzdqd(this.zzhix, this.zzhiy.booleanValue(), this.zzhiz.booleanValue());
        }
        throw new IllegalStateException(str.length() != 0 ? "Missing required properties:".concat(str) : new String("Missing required properties:"));
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final zzdqb zzbq(boolean z) {
        this.zzhiy = Boolean.valueOf(z);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final zzdqb zzbr(boolean z) {
        this.zzhiz = Boolean.TRUE;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final zzdqb zzhb(String str) {
        Objects.requireNonNull(str, "Null clientVersion");
        this.zzhix = str;
        return this;
    }
}
