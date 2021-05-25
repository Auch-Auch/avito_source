package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;
public final class zzbnc extends zzbpd {
    private final View view;
    @Nullable
    private final zzbfq zzdgc;
    private final zzdkw zzfnm;
    private final int zzfnn;
    private final boolean zzfno;
    private final boolean zzfnp;
    @Nullable
    private zzsj zzfnv;
    private final zzbmt zzfnw;

    public zzbnc(zzbpg zzbpg, View view2, @Nullable zzbfq zzbfq, zzdkw zzdkw, int i, boolean z, boolean z2, zzbmt zzbmt) {
        super(zzbpg);
        this.view = view2;
        this.zzdgc = zzbfq;
        this.zzfnm = zzdkw;
        this.zzfnn = i;
        this.zzfno = z;
        this.zzfnp = z2;
        this.zzfnw = zzbmt;
    }

    public final void zza(zzsc zzsc) {
        zzbfq zzbfq = this.zzdgc;
        if (zzbfq != null) {
            zzbfq.zza(zzsc);
        }
    }

    public final boolean zzabx() {
        zzbfq zzbfq = this.zzdgc;
        return (zzbfq == null || zzbfq.zzabe() == null || !this.zzdgc.zzabe().zzabx()) ? false : true;
    }

    public final int zzahh() {
        return this.zzfnn;
    }

    public final boolean zzahi() {
        return this.zzfno;
    }

    public final boolean zzahj() {
        return this.zzfnp;
    }

    public final zzdkw zzahp() {
        return zzdls.zza(this.zzfpf.zzhan, this.zzfnm);
    }

    public final View zzahq() {
        return this.view;
    }

    public final boolean zzahr() {
        zzbfq zzbfq = this.zzdgc;
        return zzbfq != null && zzbfq.zzabg();
    }

    @Nullable
    public final zzsj zzahs() {
        return this.zzfnv;
    }

    public final void zzfd(long j) {
        this.zzfnw.zzfd(j);
    }

    public final void zza(zzsj zzsj) {
        this.zzfnv = zzsj;
    }
}
