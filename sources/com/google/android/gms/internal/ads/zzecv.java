package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
public final class zzecv implements zzeed {
    private static final ThreadLocal<Cipher> zzhxz = new zzecy();
    private final SecretKeySpec zzhya;
    private final int zzhyb;
    private final int zzhyc;

    public zzecv(byte[] bArr, int i) throws GeneralSecurityException {
        zzeej.zzfp(bArr.length);
        this.zzhya = new SecretKeySpec(bArr, "AES");
        int blockSize = zzhxz.get().getBlockSize();
        this.zzhyc = blockSize;
        if (i < 12 || i > blockSize) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.zzhyb = i;
    }

    @Override // com.google.android.gms.internal.ads.zzeed
    public final byte[] zzo(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.zzhyb;
        if (length <= Integer.MAX_VALUE - i) {
            byte[] bArr2 = new byte[(bArr.length + i)];
            byte[] zzfo = zzeei.zzfo(i);
            System.arraycopy(zzfo, 0, bArr2, 0, this.zzhyb);
            int length2 = bArr.length;
            int i2 = this.zzhyb;
            Cipher cipher = zzhxz.get();
            byte[] bArr3 = new byte[this.zzhyc];
            System.arraycopy(zzfo, 0, bArr3, 0, this.zzhyb);
            cipher.init(1, this.zzhya, new IvParameterSpec(bArr3));
            if (cipher.doFinal(bArr, 0, length2, bArr2, i2) == length2) {
                return bArr2;
            }
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
        throw new GeneralSecurityException(a.m2(43, "plaintext length can not exceed ", Integer.MAX_VALUE - this.zzhyb));
    }
}
