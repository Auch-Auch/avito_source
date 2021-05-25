package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
public final class zzeel extends zzedh {
    public zzeel(byte[] bArr) throws InvalidKeyException {
        super(bArr);
    }

    @Override // com.google.android.gms.internal.ads.zzedh, com.google.android.gms.internal.ads.zzdwq
    public final /* bridge */ /* synthetic */ byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return super.zzc(bArr, bArr2);
    }

    @Override // com.google.android.gms.internal.ads.zzedh
    public final zzedf zze(byte[] bArr, int i) throws InvalidKeyException {
        return new zzeem(bArr, i);
    }
}
