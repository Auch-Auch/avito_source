package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;
public final class zznb implements zzmx, zzna {
    private zznp zzafb;
    private zzna zzbdr;
    public final zzmx[] zzbet;
    private final IdentityHashMap<zznm, Integer> zzbeu = new IdentityHashMap<>();
    private int zzbev;
    private zzmx[] zzbew;
    private zznl zzbex;

    public zznb(zzmx... zzmxArr) {
        this.zzbet = zzmxArr;
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final void zza(zzna zzna, long j) {
        this.zzbdr = zzna;
        zzmx[] zzmxArr = this.zzbet;
        this.zzbev = zzmxArr.length;
        for (zzmx zzmx : zzmxArr) {
            zzmx.zza(this, j);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final void zzee(long j) {
        for (zzmx zzmx : this.zzbew) {
            zzmx.zzee(j);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmx, com.google.android.gms.internal.ads.zznl
    public final boolean zzef(long j) {
        return this.zzbex.zzef(j);
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final long zzeg(long j) {
        long zzeg = this.zzbew[0].zzeg(j);
        int i = 1;
        while (true) {
            zzmx[] zzmxArr = this.zzbew;
            if (i >= zzmxArr.length) {
                return zzeg;
            }
            if (zzmxArr[i].zzeg(zzeg) == zzeg) {
                i++;
            } else {
                throw new IllegalStateException("Children seeked to different positions");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final void zzhl() throws IOException {
        for (zzmx zzmx : this.zzbet) {
            zzmx.zzhl();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final zznp zzhm() {
        return this.zzafb;
    }

    @Override // com.google.android.gms.internal.ads.zzmx, com.google.android.gms.internal.ads.zznl
    public final long zzhn() {
        return this.zzbex.zzhn();
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final long zzho() {
        long zzho = this.zzbet[0].zzho();
        int i = 1;
        while (true) {
            zzmx[] zzmxArr = this.zzbet;
            if (i >= zzmxArr.length) {
                if (zzho != C.TIME_UNSET) {
                    zzmx[] zzmxArr2 = this.zzbew;
                    for (zzmx zzmx : zzmxArr2) {
                        if (zzmx != this.zzbet[0] && zzmx.zzeg(zzho) != zzho) {
                            throw new IllegalStateException("Children seeked to different positions");
                        }
                    }
                }
                return zzho;
            } else if (zzmxArr[i].zzho() == C.TIME_UNSET) {
                i++;
            } else {
                throw new IllegalStateException("Child reported discontinuity");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final long zzhp() {
        long j = Long.MAX_VALUE;
        for (zzmx zzmx : this.zzbew) {
            long zzhp = zzmx.zzhp();
            if (zzhp != Long.MIN_VALUE) {
                j = Math.min(j, zzhp);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final long zza(zzob[] zzobArr, boolean[] zArr, zznm[] zznmArr, boolean[] zArr2, long j) {
        int i;
        zznm[] zznmArr2 = zznmArr;
        int[] iArr = new int[zzobArr.length];
        int[] iArr2 = new int[zzobArr.length];
        for (int i2 = 0; i2 < zzobArr.length; i2++) {
            if (zznmArr2[i2] == null) {
                i = -1;
            } else {
                i = this.zzbeu.get(zznmArr2[i2]).intValue();
            }
            iArr[i2] = i;
            iArr2[i2] = -1;
            if (zzobArr[i2] != null) {
                zznq zzij = zzobArr[i2].zzij();
                int i3 = 0;
                while (true) {
                    zzmx[] zzmxArr = this.zzbet;
                    if (i3 >= zzmxArr.length) {
                        break;
                    } else if (zzmxArr[i3].zzhm().zza(zzij) != -1) {
                        iArr2[i2] = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        this.zzbeu.clear();
        int length = zzobArr.length;
        zznm[] zznmArr3 = new zznm[length];
        zznm[] zznmArr4 = new zznm[zzobArr.length];
        zzob[] zzobArr2 = new zzob[zzobArr.length];
        ArrayList arrayList = new ArrayList(this.zzbet.length);
        long j2 = j;
        int i4 = 0;
        while (i4 < this.zzbet.length) {
            for (int i5 = 0; i5 < zzobArr.length; i5++) {
                zzob zzob = null;
                zznmArr4[i5] = iArr[i5] == i4 ? zznmArr2[i5] : null;
                if (iArr2[i5] == i4) {
                    zzob = zzobArr[i5];
                }
                zzobArr2[i5] = zzob;
            }
            long zza = this.zzbet[i4].zza(zzobArr2, zArr, zznmArr4, zArr2, j2);
            if (i4 == 0) {
                j2 = zza;
            } else if (zza != j2) {
                throw new IllegalStateException("Children enabled at different positions");
            }
            boolean z = false;
            for (int i6 = 0; i6 < zzobArr.length; i6++) {
                boolean z2 = true;
                if (iArr2[i6] == i4) {
                    zzoz.checkState(zznmArr4[i6] != null);
                    zznmArr3[i6] = zznmArr4[i6];
                    this.zzbeu.put(zznmArr4[i6], Integer.valueOf(i4));
                    z = true;
                } else if (iArr[i6] == i4) {
                    if (zznmArr4[i6] != null) {
                        z2 = false;
                    }
                    zzoz.checkState(z2);
                }
            }
            if (z) {
                arrayList.add(this.zzbet[i4]);
            }
            i4++;
            arrayList = arrayList;
            zzobArr2 = zzobArr2;
            zznmArr2 = zznmArr;
        }
        System.arraycopy(zznmArr3, 0, zznmArr2, 0, length);
        zzmx[] zzmxArr2 = new zzmx[arrayList.size()];
        this.zzbew = zzmxArr2;
        arrayList.toArray(zzmxArr2);
        this.zzbex = new zzmo(this.zzbew);
        return j2;
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void zza(zzmx zzmx) {
        int i = this.zzbev - 1;
        this.zzbev = i;
        if (i <= 0) {
            int i2 = 0;
            for (zzmx zzmx2 : this.zzbet) {
                i2 += zzmx2.zzhm().length;
            }
            zznq[] zznqArr = new zznq[i2];
            int i3 = 0;
            for (zzmx zzmx3 : this.zzbet) {
                zznp zzhm = zzmx3.zzhm();
                int i4 = zzhm.length;
                int i5 = 0;
                while (i5 < i4) {
                    zznqArr[i3] = zzhm.zzbd(i5);
                    i5++;
                    i3++;
                }
            }
            this.zzafb = new zznp(zznqArr);
            this.zzbdr.zza((zzmx) this);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zznl] */
    @Override // com.google.android.gms.internal.ads.zzno
    public final /* synthetic */ void zza(zzmx zzmx) {
        if (this.zzafb != null) {
            this.zzbdr.zza((zzna) this);
        }
    }
}
