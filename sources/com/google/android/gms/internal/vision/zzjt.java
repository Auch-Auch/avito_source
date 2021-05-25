package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzid;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
public final class zzjt<T> implements zzkf<T> {
    private final zzjn zzaao;
    private final boolean zzaap;
    private final zzkx<?, ?> zzaay;
    private final zzhq<?> zzaaz;

    private zzjt(zzkx<?, ?> zzkx, zzhq<?> zzhq, zzjn zzjn) {
        this.zzaay = zzkx;
        this.zzaap = zzhq.zze(zzjn);
        this.zzaaz = zzhq;
        this.zzaao = zzjn;
    }

    public static <T> zzjt<T> zza(zzkx<?, ?> zzkx, zzhq<?> zzhq, zzjn zzjn) {
        return new zzjt<>(zzkx, zzhq, zzjn);
    }

    @Override // com.google.android.gms.internal.vision.zzkf
    public final boolean equals(T t, T t2) {
        if (!this.zzaay.zzy(t).equals(this.zzaay.zzy(t2))) {
            return false;
        }
        if (this.zzaap) {
            return this.zzaaz.zzh(t).equals(this.zzaaz.zzh(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.vision.zzkf
    public final int hashCode(T t) {
        int hashCode = this.zzaay.zzy(t).hashCode();
        return this.zzaap ? (hashCode * 53) + this.zzaaz.zzh(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.vision.zzkf
    public final T newInstance() {
        return (T) this.zzaao.zzhd().zzgv();
    }

    @Override // com.google.android.gms.internal.vision.zzkf
    public final void zzd(T t, T t2) {
        zzkh.zza(this.zzaay, t, t2);
        if (this.zzaap) {
            zzkh.zza(this.zzaaz, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkf
    public final void zzj(T t) {
        this.zzaay.zzj(t);
        this.zzaaz.zzj(t);
    }

    @Override // com.google.android.gms.internal.vision.zzkf
    public final int zzu(T t) {
        zzkx<?, ?> zzkx = this.zzaay;
        int zzaa = zzkx.zzaa(zzkx.zzy(t)) + 0;
        return this.zzaap ? zzaa + this.zzaaz.zzh(t).zzgi() : zzaa;
    }

    @Override // com.google.android.gms.internal.vision.zzkf
    public final boolean zzw(T t) {
        return this.zzaaz.zzh(t).isInitialized();
    }

    @Override // com.google.android.gms.internal.vision.zzkf
    public final void zza(T t, zzlq zzlq) throws IOException {
        Iterator<Map.Entry<?, Object>> it = this.zzaaz.zzh(t).iterator();
        while (it.hasNext()) {
            Map.Entry<?, Object> next = it.next();
            zzhv zzhv = (zzhv) next.getKey();
            if (zzhv.zzgn() != zzlr.MESSAGE || zzhv.zzgo() || zzhv.zzgp()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zziq) {
                zzlq.zza(zzhv.zzak(), (Object) ((zziq) next).zzhr().zzee());
            } else {
                zzlq.zza(zzhv.zzak(), next.getValue());
            }
        }
        zzkx<?, ?> zzkx = this.zzaay;
        zzkx.zzc(zzkx.zzy(t), zzlq);
    }

    @Override // com.google.android.gms.internal.vision.zzkf
    public final void zza(T t, byte[] bArr, int i, int i2, zzgm zzgm) throws IOException {
        T t2 = t;
        zzkw zzkw = t2.zzxz;
        if (zzkw == zzkw.zzja()) {
            zzkw = zzkw.zzjb();
            t2.zzxz = zzkw;
        }
        zzht<zzid.zzd> zzhe = t.zzhe();
        zzid.zzg zzg = null;
        while (i < i2) {
            int zza = zzgk.zza(bArr, i, zzgm);
            int i3 = zzgm.zztk;
            if (i3 == 11) {
                int i4 = 0;
                zzgs zzgs = null;
                while (zza < i2) {
                    zza = zzgk.zza(bArr, zza, zzgm);
                    int i5 = zzgm.zztk;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 != 2) {
                        if (i6 == 3) {
                            if (zzg != null) {
                                zza = zzgk.zza(zzkb.zzik().zzf(zzg.zzyq.getClass()), bArr, zza, i2, zzgm);
                                zzhe.zza((zzht<zzid.zzd>) zzg.zzyr, zzgm.zztm);
                            } else if (i7 == 2) {
                                zza = zzgk.zze(bArr, zza, zzgm);
                                zzgs = (zzgs) zzgm.zztm;
                            }
                        }
                    } else if (i7 == 0) {
                        zza = zzgk.zza(bArr, zza, zzgm);
                        i4 = zzgm.zztk;
                        zzg = (zzid.zzg) this.zzaaz.zza(zzgm.zzcu, this.zzaao, i4);
                    }
                    if (i5 == 12) {
                        break;
                    }
                    zza = zzgk.zza(i5, bArr, zza, i2, zzgm);
                }
                if (zzgs != null) {
                    zzkw.zzb((i4 << 3) | 2, zzgs);
                }
                i = zza;
            } else if ((i3 & 7) == 2) {
                zzid.zzg zzg2 = (zzid.zzg) this.zzaaz.zza(zzgm.zzcu, this.zzaao, i3 >>> 3);
                if (zzg2 != null) {
                    i = zzgk.zza(zzkb.zzik().zzf(zzg2.zzyq.getClass()), bArr, zza, i2, zzgm);
                    zzhe.zza((zzht<zzid.zzd>) zzg2.zzyr, zzgm.zztm);
                } else {
                    i = zzgk.zza(i3, bArr, zza, i2, zzkw, zzgm);
                }
                zzg = zzg2;
            } else {
                i = zzgk.zza(i3, bArr, zza, i2, zzgm);
            }
        }
        if (i != i2) {
            throw zzin.zzhn();
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkf
    public final void zza(T t, zzkc zzkc, zzho zzho) throws IOException {
        boolean z;
        zzkx<?, ?> zzkx = this.zzaay;
        zzhq<?> zzhq = this.zzaaz;
        Object zzz = zzkx.zzz(t);
        zzht<?> zzi = zzhq.zzi(t);
        do {
            try {
                if (zzkc.zzeo() == Integer.MAX_VALUE) {
                    zzkx.zzg(t, zzz);
                    return;
                }
                int tag = zzkc.getTag();
                if (tag == 11) {
                    int i = 0;
                    Object obj = null;
                    zzgs zzgs = null;
                    while (zzkc.zzeo() != Integer.MAX_VALUE) {
                        int tag2 = zzkc.getTag();
                        if (tag2 == 16) {
                            i = zzkc.zzey();
                            obj = zzhq.zza(zzho, this.zzaao, i);
                        } else if (tag2 == 26) {
                            if (obj != null) {
                                zzhq.zza(zzkc, obj, zzho, zzi);
                            } else {
                                zzgs = zzkc.zzex();
                            }
                        } else if (!zzkc.zzep()) {
                            break;
                        }
                    }
                    if (zzkc.getTag() != 12) {
                        throw zzin.zzhl();
                    } else if (zzgs != null) {
                        if (obj != null) {
                            zzhq.zza(zzgs, obj, zzho, zzi);
                        } else {
                            zzkx.zza((zzkx<?, ?>) zzz, i, zzgs);
                        }
                    }
                } else if ((tag & 7) == 2) {
                    Object zza = zzhq.zza(zzho, this.zzaao, tag >>> 3);
                    if (zza != null) {
                        zzhq.zza(zzkc, zza, zzho, zzi);
                    } else {
                        z = zzkx.zza((zzkx<?, ?>) zzz, zzkc);
                        continue;
                    }
                } else {
                    z = zzkc.zzep();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzkx.zzg(t, zzz);
            }
        } while (z);
    }
}
