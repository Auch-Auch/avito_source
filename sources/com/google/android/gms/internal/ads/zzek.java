package com.google.android.gms.internal.ads;

import java.util.HashMap;
public final class zzek extends zzcu<Integer, Long> {
    public long zzyk;
    public long zzyl;

    public zzek() {
        this.zzyk = -1;
        this.zzyl = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    public final void zzan(String str) {
        HashMap zzao = zzcu.zzao(str);
        if (zzao != null) {
            this.zzyk = ((Long) zzao.get(0)).longValue();
            this.zzyl = ((Long) zzao.get(1)).longValue();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    public final HashMap<Integer, Long> zzbn() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, Long.valueOf(this.zzyk));
        hashMap.put(1, Long.valueOf(this.zzyl));
        return hashMap;
    }

    public zzek(String str) {
        this();
        zzan(str);
    }
}
