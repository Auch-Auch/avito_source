package com.google.android.gms.internal.mlkit_common;

import java.io.IOException;
import java.util.Arrays;
public final class zzii {
    private static final zzii zza = new zzii(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzii() {
        this(0, new int[8], new Object[8], true);
    }

    public static zzii zza() {
        return zza;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzii)) {
            return false;
        }
        zzii zzii = (zzii) obj;
        int i = this.zzb;
        if (i == zzii.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzii.zzc;
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
                Object[] objArr2 = zzii.zzd;
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
            i2 += zzfc.zzd(this.zzc[i3] >>> 3, (zzep) this.zzd[i3]);
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
                i = zzfc.zze(i6, ((Long) this.zzd[i4]).longValue());
            } else if (i7 == 1) {
                i = zzfc.zzg(i6, ((Long) this.zzd[i4]).longValue());
            } else if (i7 == 2) {
                i = zzfc.zzc(i6, (zzep) this.zzd[i4]);
            } else if (i7 == 3) {
                i3 = ((zzii) this.zzd[i4]).zzd() + (zzfc.zze(i6) << 1) + i3;
            } else if (i7 == 5) {
                i = zzfc.zzi(i6, ((Integer) this.zzd[i4]).intValue());
            } else {
                throw new IllegalStateException(zzgb.zza());
            }
            i3 = i + i3;
        }
        this.zze = i3;
        return i3;
    }

    private zzii(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzii zza(zzii zzii, zzii zzii2) {
        int i = zzii.zzb + zzii2.zzb;
        int[] copyOf = Arrays.copyOf(zzii.zzc, i);
        System.arraycopy(zzii2.zzc, 0, copyOf, zzii.zzb, zzii2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzii.zzd, i);
        System.arraycopy(zzii2.zzd, 0, copyOf2, zzii.zzb, zzii2.zzb);
        return new zzii(i, copyOf, copyOf2, true);
    }

    public final void zzb(zzjd zzjd) throws IOException {
        if (this.zzb != 0) {
            if (zzjd.zza() == zzjc.zza) {
                for (int i = 0; i < this.zzb; i++) {
                    zza(this.zzc[i], this.zzd[i], zzjd);
                }
                return;
            }
            for (int i2 = this.zzb - 1; i2 >= 0; i2--) {
                zza(this.zzc[i2], this.zzd[i2], zzjd);
            }
        }
    }

    public final void zza(zzjd zzjd) throws IOException {
        if (zzjd.zza() == zzjc.zzb) {
            for (int i = this.zzb - 1; i >= 0; i--) {
                zzjd.zza(this.zzc[i] >>> 3, this.zzd[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzjd.zza(this.zzc[i2] >>> 3, this.zzd[i2]);
        }
    }

    private static void zza(int i, Object obj, zzjd zzjd) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzjd.zza(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            zzjd.zzd(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            zzjd.zza(i2, (zzep) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                zzjd.zzd(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzgb.zza());
        } else if (zzjd.zza() == zzjc.zza) {
            zzjd.zza(i2);
            ((zzii) obj).zzb(zzjd);
            zzjd.zzb(i2);
        } else {
            zzjd.zzb(i2);
            ((zzii) obj).zzb(zzjd);
            zzjd.zza(i2);
        }
    }

    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzhc.zza(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }
}
