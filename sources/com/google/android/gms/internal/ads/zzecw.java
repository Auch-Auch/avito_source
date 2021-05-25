package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
public final class zzecw implements zzdxd {
    private final SecretKey zzhyd;
    private final int zzhye;
    private byte[] zzhyf;
    private byte[] zzhyg;

    public zzecw(byte[] bArr, int i) throws GeneralSecurityException {
        zzeej.zzfp(bArr.length);
        if (i < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, min is 10 bytes");
        } else if (i <= 16) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            this.zzhyd = secretKeySpec;
            this.zzhye = i;
            Cipher zzbcq = zzbcq();
            zzbcq.init(1, secretKeySpec);
            byte[] zzq = zzede.zzq(zzbcq.doFinal(new byte[16]));
            this.zzhyf = zzq;
            this.zzhyg = zzede.zzq(zzq);
        } else {
            throw new InvalidAlgorithmParameterException("tag size too large, max is 16 bytes");
        }
    }

    private static Cipher zzbcq() throws GeneralSecurityException {
        return zzedt.zzhzm.zzhs("AES/ECB/NoPadding");
    }

    @Override // com.google.android.gms.internal.ads.zzdxd
    public final byte[] zzl(byte[] bArr) throws GeneralSecurityException {
        byte[] bArr2;
        Cipher zzbcq = zzbcq();
        zzbcq.init(1, this.zzhyd);
        int max = Math.max(1, (int) Math.ceil(((double) bArr.length) / 16.0d));
        if ((max << 4) == bArr.length) {
            bArr2 = zzedd.zza(bArr, (max - 1) << 4, this.zzhyf, 0, 16);
        } else {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, (max - 1) << 4, bArr.length);
            if (copyOfRange.length < 16) {
                byte[] copyOf = Arrays.copyOf(copyOfRange, 16);
                copyOf[copyOfRange.length] = Byte.MIN_VALUE;
                bArr2 = zzedd.zzd(copyOf, this.zzhyg);
            } else {
                throw new IllegalArgumentException("x must be smaller than a block.");
            }
        }
        byte[] bArr3 = new byte[16];
        for (int i = 0; i < max - 1; i++) {
            bArr3 = zzbcq.doFinal(zzedd.zza(bArr3, 0, bArr, i << 4, 16));
        }
        byte[] zzd = zzedd.zzd(bArr2, bArr3);
        byte[] bArr4 = new byte[this.zzhye];
        System.arraycopy(zzbcq.doFinal(zzd), 0, bArr4, 0, this.zzhye);
        return bArr4;
    }
}
