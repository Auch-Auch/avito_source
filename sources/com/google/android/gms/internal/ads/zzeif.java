package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
public final class zzeif<T> implements zzeiv<T> {
    private final zzehz zziie;
    private final boolean zziif;
    private final zzejn<?, ?> zziio;
    private final zzege<?> zziip;

    private zzeif(zzejn<?, ?> zzejn, zzege<?> zzege, zzehz zzehz) {
        this.zziio = zzejn;
        this.zziif = zzege.zzj(zzehz);
        this.zziip = zzege;
        this.zziie = zzehz;
    }

    public static <T> zzeif<T> zza(zzejn<?, ?> zzejn, zzege<?> zzege, zzehz zzehz) {
        return new zzeif<>(zzejn, zzege, zzehz);
    }

    @Override // com.google.android.gms.internal.ads.zzeiv
    public final boolean equals(T t, T t2) {
        if (!this.zziio.zzax(t).equals(this.zziio.zzax(t2))) {
            return false;
        }
        if (this.zziif) {
            return this.zziip.zzah(t).equals(this.zziip.zzah(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzeiv
    public final int hashCode(T t) {
        int hashCode = this.zziio.zzax(t).hashCode();
        return this.zziif ? (hashCode * 53) + this.zziip.zzah(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.ads.zzeiv
    public final T newInstance() {
        return (T) this.zziie.zzbfq().zzbfw();
    }

    @Override // com.google.android.gms.internal.ads.zzeiv
    public final void zzaj(T t) {
        this.zziio.zzaj(t);
        this.zziip.zzaj(t);
    }

    @Override // com.google.android.gms.internal.ads.zzeiv
    public final int zzat(T t) {
        zzejn<?, ?> zzejn = this.zziio;
        int zzaz = zzejn.zzaz(zzejn.zzax(t)) + 0;
        return this.zziif ? zzaz + this.zziip.zzah(t).zzbfd() : zzaz;
    }

    @Override // com.google.android.gms.internal.ads.zzeiv
    public final boolean zzav(T t) {
        return this.zziip.zzah(t).isInitialized();
    }

    @Override // com.google.android.gms.internal.ads.zzeiv
    public final void zzg(T t, T t2) {
        zzeix.zza(this.zziio, t, t2);
        if (this.zziif) {
            zzeix.zza(this.zziip, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeiv
    public final void zza(T t, zzekk zzekk) throws IOException {
        Iterator<Map.Entry<?, Object>> it = this.zziip.zzah(t).iterator();
        while (it.hasNext()) {
            Map.Entry<?, Object> next = it.next();
            zzegk zzegk = (zzegk) next.getKey();
            if (zzegk.zzbff() != zzekh.MESSAGE || zzegk.zzbfg() || zzegk.zzbfh()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzehg) {
                zzekk.zzc(zzegk.zzv(), ((zzehg) next).zzbgm().zzbda());
            } else {
                zzekk.zzc(zzegk.zzv(), next.getValue());
            }
        }
        zzejn<?, ?> zzejn = this.zziio;
        zzejn.zzc(zzejn.zzax(t), zzekk);
    }

    @Override // com.google.android.gms.internal.ads.zzeiv
    public final void zza(T t, byte[] bArr, int i, int i2, zzefa zzefa) throws IOException {
        T t2 = t;
        zzejq zzejq = t2.zzifo;
        if (zzejq == zzejq.zzbhz()) {
            zzejq = zzejq.zzbia();
            t2.zzifo = zzejq;
        }
        t.zzbfy();
        zzegp.zzf zzf = null;
        while (i < i2) {
            int zza = zzefb.zza(bArr, i, zzefa);
            int i3 = zzefa.zziaw;
            if (i3 == 11) {
                int i4 = 0;
                zzeff zzeff = null;
                while (zza < i2) {
                    zza = zzefb.zza(bArr, zza, zzefa);
                    int i5 = zzefa.zziaw;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 != 2) {
                        if (i6 == 3) {
                            if (zzf != null) {
                                zzeio.zzbhg();
                                throw new NoSuchMethodError();
                            } else if (i7 == 2) {
                                zza = zzefb.zze(bArr, zza, zzefa);
                                zzeff = (zzeff) zzefa.zziay;
                            }
                        }
                    } else if (i7 == 0) {
                        zza = zzefb.zza(bArr, zza, zzefa);
                        i4 = zzefa.zziaw;
                        zzf = (zzegp.zzf) this.zziip.zza(zzefa.zziaz, this.zziie, i4);
                    }
                    if (i5 == 12) {
                        break;
                    }
                    zza = zzefb.zza(i5, bArr, zza, i2, zzefa);
                }
                if (zzeff != null) {
                    zzejq.zzd((i4 << 3) | 2, zzeff);
                }
                i = zza;
            } else if ((i3 & 7) == 2) {
                zzf = (zzegp.zzf) this.zziip.zza(zzefa.zziaz, this.zziie, i3 >>> 3);
                if (zzf == null) {
                    i = zzefb.zza(i3, bArr, zza, i2, zzejq, zzefa);
                } else {
                    zzeio.zzbhg();
                    throw new NoSuchMethodError();
                }
            } else {
                i = zzefb.zza(i3, bArr, zza, i2, zzefa);
            }
        }
        if (i != i2) {
            throw zzegz.zzbgi();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeiv
    public final void zza(T t, zzeip zzeip, zzegc zzegc) throws IOException {
        boolean z;
        zzejn<?, ?> zzejn = this.zziio;
        zzege<?> zzege = this.zziip;
        Object zzay = zzejn.zzay(t);
        zzegi<?> zzai = zzege.zzai(t);
        do {
            try {
                if (zzeip.zzber() == Integer.MAX_VALUE) {
                    zzejn.zzj(t, zzay);
                    return;
                }
                int tag = zzeip.getTag();
                if (tag == 11) {
                    int i = 0;
                    Object obj = null;
                    zzeff zzeff = null;
                    while (zzeip.zzber() != Integer.MAX_VALUE) {
                        int tag2 = zzeip.getTag();
                        if (tag2 == 16) {
                            i = zzeip.zzbec();
                            obj = zzege.zza(zzegc, this.zziie, i);
                        } else if (tag2 == 26) {
                            if (obj != null) {
                                zzege.zza(zzeip, obj, zzegc, zzai);
                            } else {
                                zzeff = zzeip.zzbeb();
                            }
                        } else if (!zzeip.zzbes()) {
                            break;
                        }
                    }
                    if (zzeip.getTag() != 12) {
                        throw zzegz.zzbgf();
                    } else if (zzeff != null) {
                        if (obj != null) {
                            zzege.zza(zzeff, obj, zzegc, zzai);
                        } else {
                            zzejn.zza((zzejn<?, ?>) zzay, i, zzeff);
                        }
                    }
                } else if ((tag & 7) == 2) {
                    Object zza = zzege.zza(zzegc, this.zziie, tag >>> 3);
                    if (zza != null) {
                        zzege.zza(zzeip, zza, zzegc, zzai);
                    } else {
                        z = zzejn.zza((zzejn<?, ?>) zzay, zzeip);
                        continue;
                    }
                } else {
                    z = zzeip.zzbes();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzejn.zzj(t, zzay);
            }
        } while (z);
    }
}
