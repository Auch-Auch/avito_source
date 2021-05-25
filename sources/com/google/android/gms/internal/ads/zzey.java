package com.google.android.gms.internal.ads;

import java.util.HashMap;
public final class zzey extends zzcu<Integer, Long> {
    public Long zzzi;
    public Long zzzj;

    public zzey() {
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    public final void zzan(String str) {
        HashMap zzao = zzcu.zzao(str);
        if (zzao != null) {
            this.zzzi = (Long) zzao.get(0);
            this.zzzj = (Long) zzao.get(1);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    public final HashMap<Integer, Long> zzbn() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zzzi);
        hashMap.put(1, this.zzzj);
        return hashMap;
    }

    public zzey(String str) {
        zzan(str);
    }
}
