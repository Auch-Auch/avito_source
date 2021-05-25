package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
public final class zzeeg implements zzdxd {
    private final Mac zzhzz;
    private final int zziaa;
    private final String zziab;
    private final Key zziac;

    public zzeeg(String str, Key key, int i) throws GeneralSecurityException {
        if (i < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
        } else if (key.getEncoded().length >= 16) {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1823053428:
                    if (str.equals("HMACSHA1")) {
                        c = 0;
                        break;
                    }
                    break;
                case 392315118:
                    if (str.equals("HMACSHA256")) {
                        c = 1;
                        break;
                    }
                    break;
                case 392317873:
                    if (str.equals("HMACSHA512")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    if (i > 20) {
                        throw new InvalidAlgorithmParameterException("tag size too big");
                    }
                    break;
                case 1:
                    if (i > 32) {
                        throw new InvalidAlgorithmParameterException("tag size too big");
                    }
                    break;
                case 2:
                    if (i > 64) {
                        throw new InvalidAlgorithmParameterException("tag size too big");
                    }
                    break;
                default:
                    throw new NoSuchAlgorithmException(str.length() != 0 ? "unknown Hmac algorithm: ".concat(str) : new String("unknown Hmac algorithm: "));
            }
            this.zziab = str;
            this.zziaa = i;
            this.zziac = key;
            Mac zzhs = zzedt.zzhzn.zzhs(str);
            this.zzhzz = zzhs;
            zzhs.init(key);
        } else {
            throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdxd
    public final byte[] zzl(byte[] bArr) throws GeneralSecurityException {
        Mac mac;
        try {
            mac = (Mac) this.zzhzz.clone();
        } catch (CloneNotSupportedException unused) {
            mac = zzedt.zzhzn.zzhs(this.zziab);
            mac.init(this.zziac);
        }
        mac.update(bArr);
        byte[] bArr2 = new byte[this.zziaa];
        System.arraycopy(mac.doFinal(), 0, bArr2, 0, this.zziaa);
        return bArr2;
    }
}
