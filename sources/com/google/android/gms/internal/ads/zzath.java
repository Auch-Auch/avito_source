package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;
public final class zzath extends zzati {
    private final String type;
    private final int zzdva;

    public zzath(String str, int i) {
        this.type = str;
        this.zzdva = i;
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzath)) {
            zzath zzath = (zzath) obj;
            if (Objects.equal(this.type, zzath.type) && Objects.equal(Integer.valueOf(this.zzdva), Integer.valueOf(zzath.zzdva))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final int getAmount() {
        return this.zzdva;
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final String getType() {
        return this.type;
    }
}
