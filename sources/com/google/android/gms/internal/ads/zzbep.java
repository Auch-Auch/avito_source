package com.google.android.gms.internal.ads;
public final class zzbep extends zzbm {
    public static final zzbep zzeko = new zzbep();

    @Override // com.google.android.gms.internal.ads.zzbm
    public final zzbp zza(String str, byte[] bArr, String str2) {
        if ("moov".equals(str)) {
            return new zzbr();
        }
        if ("mvhd".equals(str)) {
            return new zzbu();
        }
        return new zzbt(str);
    }
}
