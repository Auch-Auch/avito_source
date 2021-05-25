package com.google.android.gms.internal.vision;

import a2.b.a.a.a;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;
public class zzhc extends zzhd {
    public final byte[] zzua;

    public zzhc(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.zzua = bArr;
    }

    @Override // com.google.android.gms.internal.vision.zzgs, java.lang.Object
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgs) || size() != ((zzgs) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzhc)) {
            return obj.equals(this);
        }
        zzhc zzhc = (zzhc) obj;
        int zzfn = zzfn();
        int zzfn2 = zzhc.zzfn();
        if (zzfn == 0 || zzfn2 == 0 || zzfn == zzfn2) {
            return zza(zzhc, 0, size());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.vision.zzgs
    public int size() {
        return this.zzua.length;
    }

    @Override // com.google.android.gms.internal.vision.zzgs
    public void zza(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzua, 0, bArr, 0, i3);
    }

    @Override // com.google.android.gms.internal.vision.zzgs
    public byte zzau(int i) {
        return this.zzua[i];
    }

    @Override // com.google.android.gms.internal.vision.zzgs
    public byte zzav(int i) {
        return this.zzua[i];
    }

    @Override // com.google.android.gms.internal.vision.zzgs
    public final int zzd(int i, int i2, int i3) {
        return zzie.zza(i, this.zzua, zzfo(), i3);
    }

    @Override // com.google.android.gms.internal.vision.zzgs
    public final boolean zzfm() {
        int zzfo = zzfo();
        return zzlf.zzf(this.zzua, zzfo, size() + zzfo);
    }

    public int zzfo() {
        return 0;
    }

    @Override // com.google.android.gms.internal.vision.zzgs
    public final zzgs zzi(int i, int i2) {
        int zze = zzgs.zze(0, i2, size());
        if (zze == 0) {
            return zzgs.zztt;
        }
        return new zzgz(this.zzua, zzfo(), zze);
    }

    @Override // com.google.android.gms.internal.vision.zzgs
    public final void zza(zzgt zzgt) throws IOException {
        zzgt.zzc(this.zzua, zzfo(), size());
    }

    @Override // com.google.android.gms.internal.vision.zzgs
    public final String zza(Charset charset) {
        return new String(this.zzua, zzfo(), size(), charset);
    }

    @Override // com.google.android.gms.internal.vision.zzhd
    public final boolean zza(zzgs zzgs, int i, int i2) {
        if (i2 > zzgs.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 > zzgs.size()) {
            throw new IllegalArgumentException(a.p2(59, "Ran off end of other: 0, ", i2, ", ", zzgs.size()));
        } else if (!(zzgs instanceof zzhc)) {
            return zzgs.zzi(0, i2).equals(zzi(0, i2));
        } else {
            zzhc zzhc = (zzhc) zzgs;
            byte[] bArr = this.zzua;
            byte[] bArr2 = zzhc.zzua;
            int zzfo = zzfo() + i2;
            int zzfo2 = zzfo();
            int zzfo3 = zzhc.zzfo();
            while (zzfo2 < zzfo) {
                if (bArr[zzfo2] != bArr2[zzfo3]) {
                    return false;
                }
                zzfo2++;
                zzfo3++;
            }
            return true;
        }
    }
}
