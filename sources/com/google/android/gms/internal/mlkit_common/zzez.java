package com.google.android.gms.internal.mlkit_common;

import a2.b.a.a.a;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;
public class zzez extends zzew {
    public final byte[] zzb;

    public zzez(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzep, java.lang.Object
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzep) || zza() != ((zzep) obj).zza()) {
            return false;
        }
        if (zza() == 0) {
            return true;
        }
        if (!(obj instanceof zzez)) {
            return obj.equals(this);
        }
        zzez zzez = (zzez) obj;
        int zzd = zzd();
        int zzd2 = zzez.zzd();
        if (zzd == 0 || zzd2 == 0 || zzd == zzd2) {
            return zza(zzez, 0, zza());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzep
    public byte zza(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzep
    public byte zzb(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzep
    public final boolean zzc() {
        int zze = zze();
        return zzir.zza(this.zzb, zze, zza() + zze);
    }

    public int zze() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzep
    public int zza() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzep
    public final zzep zza(int i, int i2) {
        int zzb2 = zzep.zzb(0, i2, zza());
        if (zzb2 == 0) {
            return zzep.zza;
        }
        return new zzes(this.zzb, zze(), zzb2);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzep
    public final void zza(zzem zzem) throws IOException {
        zzem.zza(this.zzb, zze(), zza());
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzep
    public final String zza(Charset charset) {
        return new String(this.zzb, zze(), zza(), charset);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzew
    public final boolean zza(zzep zzep, int i, int i2) {
        if (i2 > zzep.zza()) {
            int zza = zza();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(zza);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 > zzep.zza()) {
            throw new IllegalArgumentException(a.p2(59, "Ran off end of other: 0, ", i2, ", ", zzep.zza()));
        } else if (!(zzep instanceof zzez)) {
            return zzep.zza(0, i2).equals(zza(0, i2));
        } else {
            zzez zzez = (zzez) zzep;
            byte[] bArr = this.zzb;
            byte[] bArr2 = zzez.zzb;
            int zze = zze() + i2;
            int zze2 = zze();
            int zze3 = zzez.zze();
            while (zze2 < zze) {
                if (bArr[zze2] != bArr2[zze3]) {
                    return false;
                }
                zze2++;
                zze3++;
            }
            return true;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzep
    public final int zza(int i, int i2, int i3) {
        return zzfs.zza(i, this.zzb, zze(), i3);
    }
}
