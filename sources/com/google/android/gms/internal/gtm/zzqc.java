package com.google.android.gms.internal.gtm;

import a2.b.a.a.a;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;
public class zzqc extends zzqb {
    public final byte[] zzawe;

    public zzqc(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.zzawe = bArr;
    }

    @Override // com.google.android.gms.internal.gtm.zzps, java.lang.Object
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzps) || size() != ((zzps) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzqc)) {
            return obj.equals(this);
        }
        zzqc zzqc = (zzqc) obj;
        int zzne = zzne();
        int zzne2 = zzqc.zzne();
        if (zzne == 0 || zzne2 == 0 || zzne == zzne2) {
            return zza(zzqc, 0, size());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.gtm.zzps
    public int size() {
        return this.zzawe.length;
    }

    @Override // com.google.android.gms.internal.gtm.zzps
    public final void zza(zzpr zzpr) throws IOException {
        zzpr.zza(this.zzawe, zznf(), size());
    }

    @Override // com.google.android.gms.internal.gtm.zzps
    public byte zzak(int i) {
        return this.zzawe[i];
    }

    @Override // com.google.android.gms.internal.gtm.zzps
    public byte zzal(int i) {
        return this.zzawe[i];
    }

    @Override // com.google.android.gms.internal.gtm.zzps
    public final zzps zzc(int i, int i2) {
        int zzb = zzps.zzb(0, i2, size());
        if (zzb == 0) {
            return zzps.zzavx;
        }
        return new zzpx(this.zzawe, zznf(), zzb);
    }

    @Override // com.google.android.gms.internal.gtm.zzps
    public final boolean zznd() {
        int zznf = zznf();
        return zztz.zzf(this.zzawe, zznf, size() + zznf);
    }

    public int zznf() {
        return 0;
    }

    @Override // com.google.android.gms.internal.gtm.zzps
    public final String zza(Charset charset) {
        return new String(this.zzawe, zznf(), size(), charset);
    }

    @Override // com.google.android.gms.internal.gtm.zzqb
    public final boolean zza(zzps zzps, int i, int i2) {
        if (i2 > zzps.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 > zzps.size()) {
            throw new IllegalArgumentException(a.p2(59, "Ran off end of other: 0, ", i2, ", ", zzps.size()));
        } else if (!(zzps instanceof zzqc)) {
            return zzps.zzc(0, i2).equals(zzc(0, i2));
        } else {
            zzqc zzqc = (zzqc) zzps;
            if (zztx.zza(this.zzawe, zznf(), zzqc.zzawe, zzqc.zznf(), i2) == -1) {
                return true;
            }
            return false;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzps
    public final int zza(int i, int i2, int i3) {
        return zzre.zza(i, this.zzawe, zznf(), i3);
    }
}
