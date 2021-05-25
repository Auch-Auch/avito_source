package com.google.android.gms.internal.ads;

import java.util.Set;
public final class zzdab implements zzelo<zzczz> {
    private final zzelx<Set<String>> zzgsu;

    private zzdab(zzelx<Set<String>> zzelx) {
        this.zzgsu = zzelx;
    }

    public static zzdab zzal(zzelx<Set<String>> zzelx) {
        return new zzdab(zzelx);
    }

    public static zzczz zzd(Set<String> set) {
        return new zzczz(set);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return zzd(this.zzgsu.get());
    }
}
