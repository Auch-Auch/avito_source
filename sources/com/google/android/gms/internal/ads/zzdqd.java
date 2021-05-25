package com.google.android.gms.internal.ads;
public final class zzdqd extends zzdqc {
    private final String zzhix;
    private final boolean zzxj;
    private final boolean zzzf;

    private zzdqd(String str, boolean z, boolean z2) {
        this.zzhix = str;
        this.zzxj = z;
        this.zzzf = z2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzdqc) {
            zzdqc zzdqc = (zzdqc) obj;
            if (this.zzhix.equals(zzdqc.zzavb()) && this.zzxj == zzdqc.zzavc() && this.zzzf == zzdqc.zzcm()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 1231;
        int hashCode = (((this.zzhix.hashCode() ^ 1000003) * 1000003) ^ (this.zzxj ? 1231 : 1237)) * 1000003;
        if (!this.zzzf) {
            i = 1237;
        }
        return hashCode ^ i;
    }

    public final String toString() {
        String str = this.zzhix;
        boolean z = this.zzxj;
        boolean z2 = this.zzzf;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 99);
        sb.append("AdShield2Options{clientVersion=");
        sb.append(str);
        sb.append(", shouldGetAdvertisingId=");
        sb.append(z);
        sb.append(", isGooglePlayServicesAvailable=");
        sb.append(z2);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzdqc
    public final String zzavb() {
        return this.zzhix;
    }

    @Override // com.google.android.gms.internal.ads.zzdqc
    public final boolean zzavc() {
        return this.zzxj;
    }

    @Override // com.google.android.gms.internal.ads.zzdqc
    public final boolean zzcm() {
        return this.zzzf;
    }
}
