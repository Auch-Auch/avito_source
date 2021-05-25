package com.google.android.gms.internal.mlkit_vision_face;

import java.io.IOException;
import java.util.Arrays;
public final class zziw {
    private static final zziw zza = new zziw(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zziw() {
        this(0, new int[8], new Object[8], true);
    }

    public static zziw zza() {
        return zza;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zziw)) {
            return false;
        }
        zziw zziw = (zziw) obj;
        int i = this.zzb;
        if (i == zziw.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zziw.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                } else if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                Object[] objArr = this.zzd;
                Object[] objArr2 = zziw.zzd;
                int i3 = this.zzb;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    } else if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    } else {
                        i4++;
                    }
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzc;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public final void zzb() {
        this.zzf = false;
    }

    public final int zzc() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            i2 += zzfq.zzd(this.zzc[i3] >>> 3, (zzez) this.zzd[i3]);
        }
        this.zze = i2;
        return i2;
    }

    public final int zzd() {
        int i;
        int i2 = this.zze;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzb; i4++) {
            int i5 = this.zzc[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = zzfq.zze(i6, ((Long) this.zzd[i4]).longValue());
            } else if (i7 == 1) {
                i = zzfq.zzg(i6, ((Long) this.zzd[i4]).longValue());
            } else if (i7 == 2) {
                i = zzfq.zzc(i6, (zzez) this.zzd[i4]);
            } else if (i7 == 3) {
                i3 = ((zziw) this.zzd[i4]).zzd() + (zzfq.zze(i6) << 1) + i3;
            } else if (i7 == 5) {
                i = zzfq.zzi(i6, ((Integer) this.zzd[i4]).intValue());
            } else {
                throw new IllegalStateException(zzgl.zza());
            }
            i3 = i + i3;
        }
        this.zze = i3;
        return i3;
    }

    private zziw(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zziw zza(zziw zziw, zziw zziw2) {
        int i = zziw.zzb + zziw2.zzb;
        int[] copyOf = Arrays.copyOf(zziw.zzc, i);
        System.arraycopy(zziw2.zzc, 0, copyOf, zziw.zzb, zziw2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zziw.zzd, i);
        System.arraycopy(zziw2.zzd, 0, copyOf2, zziw.zzb, zziw2.zzb);
        return new zziw(i, copyOf, copyOf2, true);
    }

    public final void zzb(zzjn zzjn) throws IOException {
        if (this.zzb != 0) {
            if (zzjn.zza() == zzjq.zza) {
                for (int i = 0; i < this.zzb; i++) {
                    zza(this.zzc[i], this.zzd[i], zzjn);
                }
                return;
            }
            for (int i2 = this.zzb - 1; i2 >= 0; i2--) {
                zza(this.zzc[i2], this.zzd[i2], zzjn);
            }
        }
    }

    public final void zza(zzjn zzjn) throws IOException {
        if (zzjn.zza() == zzjq.zzb) {
            for (int i = this.zzb - 1; i >= 0; i--) {
                zzjn.zza(this.zzc[i] >>> 3, this.zzd[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzjn.zza(this.zzc[i2] >>> 3, this.zzd[i2]);
        }
    }

    private static void zza(int i, Object obj, zzjn zzjn) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzjn.zza(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            zzjn.zzd(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            zzjn.zza(i2, (zzez) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                zzjn.zzd(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzgl.zza());
        } else if (zzjn.zza() == zzjq.zza) {
            zzjn.zza(i2);
            ((zziw) obj).zzb(zzjn);
            zzjn.zzb(i2);
        } else {
            zzjn.zzb(i2);
            ((zziw) obj).zzb(zzjn);
            zzjn.zza(i2);
        }
    }

    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzhq.zza(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }
}
