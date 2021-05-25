package com.google.android.gms.internal.mlkit_vision_face;

import a2.b.a.a.a;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;
public class zzfj extends zzfk {
    public final byte[] zzb;

    public zzfj(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzez, java.lang.Object
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzez) || zza() != ((zzez) obj).zza()) {
            return false;
        }
        if (zza() == 0) {
            return true;
        }
        if (!(obj instanceof zzfj)) {
            return obj.equals(this);
        }
        zzfj zzfj = (zzfj) obj;
        int zzd = zzd();
        int zzd2 = zzfj.zzd();
        if (zzd == 0 || zzd2 == 0 || zzd == zzd2) {
            return zza(zzfj, 0, zza());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzez
    public byte zza(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzez
    public byte zzb(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzez
    public final boolean zzc() {
        int zze = zze();
        return zzjc.zza(this.zzb, zze, zza() + zze);
    }

    public int zze() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzez
    public int zza() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzez
    public final zzez zza(int i, int i2) {
        int zzb2 = zzez.zzb(0, i2, zza());
        if (zzb2 == 0) {
            return zzez.zza;
        }
        return new zzfg(this.zzb, zze(), zzb2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzez
    public final void zza(zzfa zzfa) throws IOException {
        zzfa.zza(this.zzb, zze(), zza());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzez
    public final String zza(Charset charset) {
        return new String(this.zzb, zze(), zza(), charset);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzfk
    public final boolean zza(zzez zzez, int i, int i2) {
        if (i2 > zzez.zza()) {
            int zza = zza();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(zza);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 > zzez.zza()) {
            throw new IllegalArgumentException(a.p2(59, "Ran off end of other: 0, ", i2, ", ", zzez.zza()));
        } else if (!(zzez instanceof zzfj)) {
            return zzez.zza(0, i2).equals(zza(0, i2));
        } else {
            zzfj zzfj = (zzfj) zzez;
            byte[] bArr = this.zzb;
            byte[] bArr2 = zzfj.zzb;
            int zze = zze() + i2;
            int zze2 = zze();
            int zze3 = zzfj.zze();
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

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzez
    public final int zza(int i, int i2, int i3) {
        return zzgg.zza(i, this.zzb, zze(), i3);
    }
}
