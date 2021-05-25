package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;
public class zzefp extends zzefm {
    public final byte[] zzibo;

    public zzefp(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.zzibo = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzeff, java.lang.Object
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzeff) || size() != ((zzeff) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzefp)) {
            return obj.equals(this);
        }
        zzefp zzefp = (zzefp) obj;
        int zzbdp = zzbdp();
        int zzbdp2 = zzefp.zzbdp();
        if (zzbdp == 0 || zzbdp2 == 0 || zzbdp == zzbdp2) {
            return zza(zzefp, 0, size());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzeff
    public int size() {
        return this.zzibo.length;
    }

    @Override // com.google.android.gms.internal.ads.zzeff
    public final void zza(zzefc zzefc) throws IOException {
        zzefc.zzh(this.zzibo, zzbdq(), size());
    }

    @Override // com.google.android.gms.internal.ads.zzeff
    public void zzb(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzibo, i, bArr, i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzeff
    public final boolean zzbdk() {
        int zzbdq = zzbdq();
        return zzejw.zzm(this.zzibo, zzbdq, size() + zzbdq);
    }

    @Override // com.google.android.gms.internal.ads.zzeff
    public final zzefq zzbdl() {
        return zzefq.zzb(this.zzibo, zzbdq(), size(), true);
    }

    public int zzbdq() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzeff
    public byte zzfu(int i) {
        return this.zzibo[i];
    }

    @Override // com.google.android.gms.internal.ads.zzeff
    public byte zzfv(int i) {
        return this.zzibo[i];
    }

    @Override // com.google.android.gms.internal.ads.zzeff
    public final int zzg(int i, int i2, int i3) {
        int zzbdq = zzbdq() + i2;
        return zzejw.zzb(i, this.zzibo, zzbdq, i3 + zzbdq);
    }

    @Override // com.google.android.gms.internal.ads.zzeff
    public final int zzh(int i, int i2, int i3) {
        return zzegr.zza(i, this.zzibo, zzbdq() + i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzeff
    public final zzeff zzz(int i, int i2) {
        int zzi = zzeff.zzi(i, i2, size());
        if (zzi == 0) {
            return zzeff.zzibd;
        }
        return new zzefi(this.zzibo, zzbdq() + i, zzi);
    }

    @Override // com.google.android.gms.internal.ads.zzeff
    public final String zza(Charset charset) {
        return new String(this.zzibo, zzbdq(), size(), charset);
    }

    @Override // com.google.android.gms.internal.ads.zzefm
    public final boolean zza(zzeff zzeff, int i, int i2) {
        if (i2 <= zzeff.size()) {
            int i3 = i + i2;
            if (i3 > zzeff.size()) {
                int size = zzeff.size();
                StringBuilder sb = new StringBuilder(59);
                sb.append("Ran off end of other: ");
                sb.append(i);
                sb.append(", ");
                sb.append(i2);
                sb.append(", ");
                sb.append(size);
                throw new IllegalArgumentException(sb.toString());
            } else if (!(zzeff instanceof zzefp)) {
                return zzeff.zzz(i, i3).equals(zzz(0, i2));
            } else {
                zzefp zzefp = (zzefp) zzeff;
                byte[] bArr = this.zzibo;
                byte[] bArr2 = zzefp.zzibo;
                int zzbdq = zzbdq() + i2;
                int zzbdq2 = zzbdq();
                int zzbdq3 = zzefp.zzbdq() + i;
                while (zzbdq2 < zzbdq) {
                    if (bArr[zzbdq2] != bArr2[zzbdq3]) {
                        return false;
                    }
                    zzbdq2++;
                    zzbdq3++;
                }
                return true;
            }
        } else {
            int size2 = size();
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Length too large: ");
            sb2.append(i2);
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        }
    }
}
