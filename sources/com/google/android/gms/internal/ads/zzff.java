package com.google.android.gms.internal.ads;

import java.util.HashMap;
public final class zzff extends zzcu<Integer, Long> {
    public Long zzaab;
    public Long zzaac;
    public Long zzaad;
    public Long zzaae;

    public zzff() {
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    public final void zzan(String str) {
        HashMap zzao = zzcu.zzao(str);
        if (zzao != null) {
            this.zzaab = (Long) zzao.get(0);
            this.zzaac = (Long) zzao.get(1);
            this.zzaad = (Long) zzao.get(2);
            this.zzaae = (Long) zzao.get(3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    public final HashMap<Integer, Long> zzbn() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zzaab);
        hashMap.put(1, this.zzaac);
        hashMap.put(2, this.zzaad);
        hashMap.put(3, this.zzaae);
        return hashMap;
    }

    public zzff(String str) {
        zzan(str);
    }
}
