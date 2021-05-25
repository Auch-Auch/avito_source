package com.google.android.gms.common;

import java.lang.ref.WeakReference;
public abstract class zzf extends zzd {
    private static final WeakReference<byte[]> zzb = new WeakReference<>(null);
    private WeakReference<byte[]> zza = zzb;

    public zzf(byte[] bArr) {
        super(bArr);
    }

    @Override // com.google.android.gms.common.zzd
    public final byte[] zza() {
        byte[] bArr;
        synchronized (this) {
            bArr = this.zza.get();
            if (bArr == null) {
                bArr = zzd();
                this.zza = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }

    public abstract byte[] zzd();
}
