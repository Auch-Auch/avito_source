package com.google.android.gms.internal.vision;

import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzdy extends zzdl<K, V> {
    private final /* synthetic */ zzdp zzmo;
    @NullableDecl
    private final K zzmr;
    private int zzms;

    public zzdy(zzdp zzdp, int i) {
        this.zzmo = zzdp;
        this.zzmr = (K) zzdp.zzmi[i];
        this.zzms = i;
    }

    private final void zzco() {
        int i = this.zzms;
        if (i == -1 || i >= this.zzmo.size() || !zzcz.equal(this.zzmr, this.zzmo.zzmi[this.zzms])) {
            this.zzms = this.zzmo.indexOf(this.zzmr);
        }
    }

    @Override // com.google.android.gms.internal.vision.zzdl, java.util.Map.Entry
    @NullableDecl
    public final K getKey() {
        return this.zzmr;
    }

    @Override // com.google.android.gms.internal.vision.zzdl, java.util.Map.Entry
    @NullableDecl
    public final V getValue() {
        Map zzcf = this.zzmo.zzcf();
        if (zzcf != null) {
            return (V) zzcf.get(this.zzmr);
        }
        zzco();
        int i = this.zzms;
        if (i == -1) {
            return null;
        }
        return (V) this.zzmo.zzmj[i];
    }

    @Override // com.google.android.gms.internal.vision.zzdl, java.util.Map.Entry
    public final V setValue(V v) {
        Map zzcf = this.zzmo.zzcf();
        if (zzcf != null) {
            return (V) zzcf.put(this.zzmr, v);
        }
        zzco();
        int i = this.zzms;
        if (i == -1) {
            this.zzmo.put(this.zzmr, v);
            return null;
        }
        Object[] objArr = this.zzmo.zzmj;
        V v2 = (V) objArr[i];
        objArr[i] = v;
        return v2;
    }
}
