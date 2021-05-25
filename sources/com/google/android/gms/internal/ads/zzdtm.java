package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzdtm<E> extends zzdte<E> {
    private int zzahr;
    @NullableDecl
    private Object[] zzhni;

    public zzdtm() {
        super(4);
    }

    @Override // com.google.android.gms.internal.ads.zzdth
    public final /* synthetic */ zzdth zza(Iterator it) {
        zzdsv.checkNotNull(it);
        while (it.hasNext()) {
            zzab(it.next());
        }
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdte
    public final /* synthetic */ zzdte zzaa(Object obj) {
        return (zzdtm) zzab(obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object[] */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzdte, com.google.android.gms.internal.ads.zzdth
    public final /* synthetic */ zzdth zzab(Object obj) {
        zzdsv.checkNotNull(obj);
        if (this.zzhni != null) {
            int zzen = zzdtn.zzen(this.size);
            Object[] objArr = this.zzhni;
            if (zzen <= objArr.length) {
                int length = objArr.length - 1;
                int hashCode = obj.hashCode();
                int zzel = zzdtc.zzel(hashCode);
                while (true) {
                    int i = zzel & length;
                    Object[] objArr2 = this.zzhni;
                    Object[] objArr3 = objArr2[i];
                    if (objArr3 != 0) {
                        if (objArr3.equals(obj)) {
                            break;
                        }
                        zzel = i + 1;
                    } else {
                        objArr2[i] = obj;
                        this.zzahr += hashCode;
                        super.zzab(obj);
                        break;
                    }
                }
                return this;
            }
        }
        this.zzhni = null;
        super.zzab(obj);
        return this;
    }

    public final zzdtn<E> zzawx() {
        zzdtn<E> zzdtn;
        int i = this.size;
        if (i == 0) {
            return zzdtw.zzhnu;
        }
        if (i == 1) {
            return zzdtn.zzad(this.zzhmy[0]);
        }
        if (this.zzhni == null || zzdtn.zzen(i) != this.zzhni.length) {
            zzdtn = zzdtn.zza(this.size, this.zzhmy);
            this.size = zzdtn.size();
        } else {
            Object[] copyOf = zzdtn.zzv(this.size, this.zzhmy.length) ? Arrays.copyOf(this.zzhmy, this.size) : this.zzhmy;
            int i2 = this.zzahr;
            Object[] objArr = this.zzhni;
            zzdtn = new zzdtw<>(copyOf, i2, objArr, objArr.length - 1, this.size);
        }
        this.zzhmz = true;
        this.zzhni = null;
        return zzdtn;
    }

    @Override // com.google.android.gms.internal.ads.zzdte, com.google.android.gms.internal.ads.zzdth
    public final /* synthetic */ zzdth zzg(Iterable iterable) {
        zzdsv.checkNotNull(iterable);
        if (this.zzhni != null) {
            for (Object obj : iterable) {
                zzab(obj);
            }
        } else {
            super.zzg(iterable);
        }
        return this;
    }

    public zzdtm(int i) {
        super(i);
        this.zzhni = new Object[zzdtn.zzen(i)];
    }
}
