package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;
public final class zzedu implements zzdwq {
    private final zzeed zzhzw;
    private final zzdxd zzhzx;
    private final int zzhzy;

    public zzedu(zzeed zzeed, zzdxd zzdxd, int i) {
        this.zzhzw = zzeed;
        this.zzhzx = zzdxd;
        this.zzhzy = i;
    }

    @Override // com.google.android.gms.internal.ads.zzdwq
    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] zzo = this.zzhzw.zzo(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        return zzedd.zza(zzo, this.zzhzx.zzl(zzedd.zza(bArr2, zzo, Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8))));
    }
}
