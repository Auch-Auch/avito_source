package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;
public final class zzedm implements zzdwt {
    private static final byte[] zzhsk = new byte[0];
    private final String zzhyt;
    private final byte[] zzhyu;
    private final zzedr zzhyv;
    private final zzedk zzhyw;
    private final zzedo zzhyx;

    public zzedm(ECPublicKey eCPublicKey, byte[] bArr, String str, zzedr zzedr, zzedk zzedk) throws GeneralSecurityException {
        zzedq.zza(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
        this.zzhyx = new zzedo(eCPublicKey);
        this.zzhyu = bArr;
        this.zzhyt = str;
        this.zzhyv = zzedr;
        this.zzhyw = zzedk;
    }

    @Override // com.google.android.gms.internal.ads.zzdwt
    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzedn zza = this.zzhyx.zza(this.zzhyt, this.zzhyu, bArr2, this.zzhyw.zzayh(), this.zzhyv);
        byte[] zzc = this.zzhyw.zzn(zza.zzbcu()).zzc(bArr, zzhsk);
        byte[] zzbct = zza.zzbct();
        return ByteBuffer.allocate(zzbct.length + zzc.length).put(zzbct).put(zzc).array();
    }
}
