package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
public final class zzrt extends zzrq {
    private MessageDigest zzbuc;

    @Override // com.google.android.gms.internal.ads.zzrq
    public final byte[] zzbu(String str) {
        byte[] bArr;
        byte[] bArr2;
        String[] split = str.split(" ");
        int i = 4;
        if (split.length == 1) {
            int zzbv = zzru.zzbv(split[0]);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(zzbv);
            bArr = allocate.array();
        } else {
            if (split.length < 5) {
                bArr2 = new byte[(split.length << 1)];
                for (int i2 = 0; i2 < split.length; i2++) {
                    int zzbv2 = zzru.zzbv(split[i2]);
                    int i3 = (zzbv2 >> 16) ^ (65535 & zzbv2);
                    byte[] bArr3 = {(byte) i3, (byte) (i3 >> 8)};
                    int i4 = i2 << 1;
                    bArr2[i4] = bArr3[0];
                    bArr2[i4 + 1] = bArr3[1];
                }
            } else {
                bArr2 = new byte[split.length];
                for (int i5 = 0; i5 < split.length; i5++) {
                    int zzbv3 = zzru.zzbv(split[i5]);
                    bArr2[i5] = (byte) ((zzbv3 >> 24) ^ (((zzbv3 & 255) ^ ((zzbv3 >> 8) & 255)) ^ ((zzbv3 >> 16) & 255)));
                }
            }
            bArr = bArr2;
        }
        this.zzbuc = zzmq();
        synchronized (this.mLock) {
            MessageDigest messageDigest = this.zzbuc;
            if (messageDigest == null) {
                return new byte[0];
            }
            messageDigest.reset();
            this.zzbuc.update(bArr);
            byte[] digest = this.zzbuc.digest();
            if (digest.length <= 4) {
                i = digest.length;
            }
            byte[] bArr4 = new byte[i];
            System.arraycopy(digest, 0, bArr4, 0, i);
            return bArr4;
        }
    }
}
