package com.google.android.gms.internal.ads;
public final class zzdnm implements zzdnk {
    private final String zzcn;

    public zzdnm(String str) {
        this.zzcn = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdnk
    public final boolean equals(Object obj) {
        if (!(obj instanceof zzdnm)) {
            return false;
        }
        return this.zzcn.equals(((zzdnm) obj).zzcn);
    }

    @Override // com.google.android.gms.internal.ads.zzdnk
    public final int hashCode() {
        return this.zzcn.hashCode();
    }

    public final String toString() {
        return this.zzcn;
    }
}
