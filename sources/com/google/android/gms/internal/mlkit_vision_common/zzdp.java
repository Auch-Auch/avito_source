package com.google.android.gms.internal.mlkit_vision_common;

import a2.b.a.a.a;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;
public class zzdp extends zzdq {
    public final byte[] zzb;

    public zzdp(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzdf, java.lang.Object
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdf) || zza() != ((zzdf) obj).zza()) {
            return false;
        }
        if (zza() == 0) {
            return true;
        }
        if (!(obj instanceof zzdp)) {
            return obj.equals(this);
        }
        zzdp zzdp = (zzdp) obj;
        int zzd = zzd();
        int zzd2 = zzdp.zzd();
        if (zzd == 0 || zzd2 == 0 || zzd == zzd2) {
            return zza(zzdp, 0, zza());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzdf
    public byte zza(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzdf
    public byte zzb(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzdf
    public final boolean zzc() {
        int zze = zze();
        return zzhi.zza(this.zzb, zze, zza() + zze);
    }

    public int zze() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzdf
    public int zza() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzdf
    public final zzdf zza(int i, int i2) {
        int zzb2 = zzdf.zzb(0, i2, zza());
        if (zzb2 == 0) {
            return zzdf.zza;
        }
        return new zzdm(this.zzb, zze(), zzb2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzdf
    public final void zza(zzdg zzdg) throws IOException {
        zzdg.zza(this.zzb, zze(), zza());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzdf
    public final String zza(Charset charset) {
        return new String(this.zzb, zze(), zza(), charset);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzdq
    public final boolean zza(zzdf zzdf, int i, int i2) {
        if (i2 > zzdf.zza()) {
            int zza = zza();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(zza);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 > zzdf.zza()) {
            throw new IllegalArgumentException(a.p2(59, "Ran off end of other: 0, ", i2, ", ", zzdf.zza()));
        } else if (!(zzdf instanceof zzdp)) {
            return zzdf.zza(0, i2).equals(zza(0, i2));
        } else {
            zzdp zzdp = (zzdp) zzdf;
            byte[] bArr = this.zzb;
            byte[] bArr2 = zzdp.zzb;
            int zze = zze() + i2;
            int zze2 = zze();
            int zze3 = zzdp.zze();
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

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzdf
    public final int zza(int i, int i2, int i3) {
        return zzem.zza(i, this.zzb, zze(), i3);
    }
}
