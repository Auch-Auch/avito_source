package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
import java.io.IOException;
import java.util.Arrays;
public final class zzejq {
    private static final zzejq zzikg = new zzejq(0, new int[0], new Object[0], false);
    private int count;
    private boolean zzias;
    private int zzifp;
    private Object[] zziib;
    private int[] zzikh;

    private zzejq() {
        this(0, new int[8], new Object[8], true);
    }

    public static zzejq zza(zzejq zzejq, zzejq zzejq2) {
        int i = zzejq.count + zzejq2.count;
        int[] copyOf = Arrays.copyOf(zzejq.zzikh, i);
        System.arraycopy(zzejq2.zzikh, 0, copyOf, zzejq.count, zzejq2.count);
        Object[] copyOf2 = Arrays.copyOf(zzejq.zziib, i);
        System.arraycopy(zzejq2.zziib, 0, copyOf2, zzejq.count, zzejq2.count);
        return new zzejq(i, copyOf, copyOf2, true);
    }

    public static zzejq zzbhz() {
        return zzikg;
    }

    public static zzejq zzbia() {
        return new zzejq();
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzejq)) {
            return false;
        }
        zzejq zzejq = (zzejq) obj;
        int i = this.count;
        if (i == zzejq.count) {
            int[] iArr = this.zzikh;
            int[] iArr2 = zzejq.zzikh;
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
                Object[] objArr = this.zziib;
                Object[] objArr2 = zzejq.zziib;
                int i3 = this.count;
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
        int i = this.count;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzikh;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zziib;
        int i7 = this.count;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public final void zzb(zzekk zzekk) throws IOException {
        if (this.count != 0) {
            if (zzekk.zzbew() == zzegp.zze.zzigh) {
                for (int i = 0; i < this.count; i++) {
                    zzb(this.zzikh[i], this.zziib[i], zzekk);
                }
                return;
            }
            for (int i2 = this.count - 1; i2 >= 0; i2--) {
                zzb(this.zzikh[i2], this.zziib[i2], zzekk);
            }
        }
    }

    public final void zzbdg() {
        this.zzias = false;
    }

    public final int zzbfl() {
        int i;
        int i2 = this.zzifp;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.count; i4++) {
            int i5 = this.zzikh[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = zzefz.zzl(i6, ((Long) this.zziib[i4]).longValue());
            } else if (i7 == 1) {
                i = zzefz.zzn(i6, ((Long) this.zziib[i4]).longValue());
            } else if (i7 == 2) {
                i = zzefz.zzc(i6, (zzeff) this.zziib[i4]);
            } else if (i7 == 3) {
                i3 = ((zzejq) this.zziib[i4]).zzbfl() + (zzefz.zzgq(i6) << 1) + i3;
            } else if (i7 == 5) {
                i = zzefz.zzai(i6, ((Integer) this.zziib[i4]).intValue());
            } else {
                throw new IllegalStateException(zzegz.zzbgg());
            }
            i3 = i + i3;
        }
        this.zzifp = i3;
        return i3;
    }

    public final int zzbib() {
        int i = this.zzifp;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            i2 += zzefz.zzd(this.zzikh[i3] >>> 3, (zzeff) this.zziib[i3]);
        }
        this.zzifp = i2;
        return i2;
    }

    public final void zzd(int i, Object obj) {
        if (this.zzias) {
            int i2 = this.count;
            int[] iArr = this.zzikh;
            if (i2 == iArr.length) {
                int i3 = i2 + (i2 < 4 ? 8 : i2 >> 1);
                this.zzikh = Arrays.copyOf(iArr, i3);
                this.zziib = Arrays.copyOf(this.zziib, i3);
            }
            int[] iArr2 = this.zzikh;
            int i4 = this.count;
            iArr2[i4] = i;
            this.zziib[i4] = obj;
            this.count = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    private zzejq(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzifp = -1;
        this.count = i;
        this.zzikh = iArr;
        this.zziib = objArr;
        this.zzias = z;
    }

    private static void zzb(int i, Object obj, zzekk zzekk) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzekk.zzp(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            zzekk.zzj(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            zzekk.zza(i2, (zzeff) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                zzekk.zzae(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzegz.zzbgg());
        } else if (zzekk.zzbew() == zzegp.zze.zzigh) {
            zzekk.zzgz(i2);
            ((zzejq) obj).zzb(zzekk);
            zzekk.zzha(i2);
        } else {
            zzekk.zzha(i2);
            ((zzejq) obj).zzb(zzekk);
            zzekk.zzgz(i2);
        }
    }

    public final void zza(zzekk zzekk) throws IOException {
        if (zzekk.zzbew() == zzegp.zze.zzigi) {
            for (int i = this.count - 1; i >= 0; i--) {
                zzekk.zzc(this.zzikh[i] >>> 3, this.zziib[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            zzekk.zzc(this.zzikh[i2] >>> 3, this.zziib[i2]);
        }
    }

    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzeie.zza(sb, i, String.valueOf(this.zzikh[i2] >>> 3), this.zziib[i2]);
        }
    }
}
