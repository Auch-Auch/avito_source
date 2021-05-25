package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
public final class zzecx implements zzdwq {
    private static final ThreadLocal<Cipher> zzhyh = new zzeda();
    private static final ThreadLocal<Cipher> zzhyi = new zzecz();
    private final SecretKeySpec zzhya;
    private final byte[] zzhyj;
    private final byte[] zzhyk;
    private final int zzhyl;

    public zzecx(byte[] bArr, int i) throws GeneralSecurityException {
        if (i == 12 || i == 16) {
            this.zzhyl = i;
            zzeej.zzfp(bArr.length);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            this.zzhya = secretKeySpec;
            Cipher cipher = zzhyh.get();
            cipher.init(1, secretKeySpec);
            byte[] zzp = zzp(cipher.doFinal(new byte[16]));
            this.zzhyj = zzp;
            this.zzhyk = zzp(zzp);
            return;
        }
        throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
    }

    private final byte[] zza(Cipher cipher, int i, byte[] bArr, int i2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        byte[] bArr2;
        byte[] bArr3 = new byte[16];
        bArr3[15] = (byte) i;
        if (i3 == 0) {
            return cipher.doFinal(zzd(bArr3, this.zzhyj));
        }
        byte[] doFinal = cipher.doFinal(bArr3);
        int i4 = 0;
        while (i3 - i4 > 16) {
            for (int i5 = 0; i5 < 16; i5++) {
                doFinal[i5] = (byte) (doFinal[i5] ^ bArr[(i2 + i4) + i5]);
            }
            doFinal = cipher.doFinal(doFinal);
            i4 += 16;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i4 + i2, i2 + i3);
        if (copyOfRange.length == 16) {
            bArr2 = zzd(copyOfRange, this.zzhyj);
        } else {
            byte[] copyOf = Arrays.copyOf(this.zzhyk, 16);
            for (int i6 = 0; i6 < copyOfRange.length; i6++) {
                copyOf[i6] = (byte) (copyOf[i6] ^ copyOfRange[i6]);
            }
            copyOf[copyOfRange.length] = (byte) (copyOf[copyOfRange.length] ^ 128);
            bArr2 = copyOf;
        }
        return cipher.doFinal(zzd(doFinal, bArr2));
    }

    private static byte[] zzd(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    private static byte[] zzp(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        int i2 = 0;
        while (i2 < 15) {
            int i3 = i2 + 1;
            bArr2[i2] = (byte) ((bArr[i2] << 1) ^ ((bArr[i3] & 255) >>> 7));
            i2 = i3;
        }
        int i4 = bArr[15] << 1;
        if ((bArr[0] & 128) != 0) {
            i = 135;
        }
        bArr2[15] = (byte) (i4 ^ i);
        return bArr2;
    }

    @Override // com.google.android.gms.internal.ads.zzdwq
    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.zzhyl;
        if (length <= (Integer.MAX_VALUE - i) - 16) {
            byte[] bArr3 = new byte[(bArr.length + i + 16)];
            byte[] zzfo = zzeei.zzfo(i);
            System.arraycopy(zzfo, 0, bArr3, 0, this.zzhyl);
            Cipher cipher = zzhyh.get();
            cipher.init(1, this.zzhya);
            byte[] zza = zza(cipher, 0, zzfo, 0, zzfo.length);
            byte[] bArr4 = bArr2 == null ? new byte[0] : bArr2;
            byte[] zza2 = zza(cipher, 1, bArr4, 0, bArr4.length);
            Cipher cipher2 = zzhyi.get();
            cipher2.init(1, this.zzhya, new IvParameterSpec(zza));
            cipher2.doFinal(bArr, 0, bArr.length, bArr3, this.zzhyl);
            byte[] zza3 = zza(cipher, 2, bArr3, this.zzhyl, bArr.length);
            int length2 = bArr.length + this.zzhyl;
            for (int i2 = 0; i2 < 16; i2++) {
                bArr3[length2 + i2] = (byte) ((zza2[i2] ^ zza[i2]) ^ zza3[i2]);
            }
            return bArr3;
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}
