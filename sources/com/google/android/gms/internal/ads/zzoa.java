package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.Arrays;
import java.util.Map;
public abstract class zzoa extends zzog {
    private int zzaib = 0;
    private final SparseArray<Map<zznp, zzoc>> zzbhn = new SparseArray<>();
    private final SparseBooleanArray zzbho = new SparseBooleanArray();
    private zznz zzbhp;

    @Override // com.google.android.gms.internal.ads.zzog
    public final zzoi zza(zzhw[] zzhwArr, zznp zznp) throws zzhd {
        int[] iArr;
        int[] iArr2 = new int[(zzhwArr.length + 1)];
        int length = zzhwArr.length + 1;
        zznq[][] zznqArr = new zznq[length][];
        int[][][] iArr3 = new int[(zzhwArr.length + 1)][][];
        for (int i = 0; i < length; i++) {
            int i2 = zznp.length;
            zznqArr[i] = new zznq[i2];
            iArr3[i] = new int[i2][];
        }
        int length2 = zzhwArr.length;
        int[] iArr4 = new int[length2];
        for (int i3 = 0; i3 < length2; i3++) {
            iArr4[i3] = zzhwArr[i3].zzee();
        }
        for (int i4 = 0; i4 < zznp.length; i4++) {
            zznq zzbd = zznp.zzbd(i4);
            int length3 = zzhwArr.length;
            int i5 = 0;
            for (int i6 = 0; i6 < zzhwArr.length; i6++) {
                zzhw zzhw = zzhwArr[i6];
                for (int i7 = 0; i7 < zzbd.length; i7++) {
                    int zza = zzhw.zza(zzbd.zzbe(i7)) & 3;
                    if (zza > i5) {
                        length3 = i6;
                        if (zza == 3) {
                            break;
                        }
                        i5 = zza;
                    }
                }
            }
            if (length3 == zzhwArr.length) {
                iArr = new int[zzbd.length];
            } else {
                zzhw zzhw2 = zzhwArr[length3];
                int[] iArr5 = new int[zzbd.length];
                for (int i8 = 0; i8 < zzbd.length; i8++) {
                    iArr5[i8] = zzhw2.zza(zzbd.zzbe(i8));
                }
                iArr = iArr5;
            }
            int i9 = iArr2[length3];
            zznqArr[length3][i9] = zzbd;
            iArr3[length3][i9] = iArr;
            iArr2[length3] = iArr2[length3] + 1;
        }
        zznp[] zznpArr = new zznp[zzhwArr.length];
        int[] iArr6 = new int[zzhwArr.length];
        for (int i10 = 0; i10 < zzhwArr.length; i10++) {
            int i11 = iArr2[i10];
            zznpArr[i10] = new zznp((zznq[]) Arrays.copyOf(zznqArr[i10], i11));
            iArr3[i10] = (int[][]) Arrays.copyOf(iArr3[i10], i11);
            iArr6[i10] = zzhwArr[i10].getTrackType();
        }
        zznp zznp2 = new zznp((zznq[]) Arrays.copyOf(zznqArr[zzhwArr.length], iArr2[zzhwArr.length]));
        zzob[] zza2 = zza(zzhwArr, zznpArr, iArr3);
        int i12 = 0;
        while (true) {
            zzoc zzoc = null;
            if (i12 < zzhwArr.length) {
                if (this.zzbho.get(i12)) {
                    zza2[i12] = null;
                } else {
                    zznp zznp3 = zznpArr[i12];
                    Map<zznp, zzoc> map = this.zzbhn.get(i12);
                    if (map != null) {
                        zzoc = map.get(zznp3);
                    }
                    if (zzoc != null) {
                        throw new NoSuchMethodError();
                    }
                }
                i12++;
            } else {
                zznz zznz = new zznz(iArr6, zznpArr, iArr4, iArr3, zznp2);
                zzhz[] zzhzArr = new zzhz[zzhwArr.length];
                for (int i13 = 0; i13 < zzhwArr.length; i13++) {
                    zzhzArr[i13] = zza2[i13] != null ? zzhz.zzaia : null;
                }
                return new zzoi(zznp, new zzod(zza2), zznz, zzhzArr);
            }
        }
    }

    public abstract zzob[] zza(zzhw[] zzhwArr, zznp[] zznpArr, int[][][] iArr) throws zzhd;

    @Override // com.google.android.gms.internal.ads.zzog
    public final void zzd(Object obj) {
        this.zzbhp = (zznz) obj;
    }

    public final void zzf(int i, boolean z) {
        if (this.zzbho.get(i) != z) {
            this.zzbho.put(i, z);
            invalidate();
        }
    }
}
