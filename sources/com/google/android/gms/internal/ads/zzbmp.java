package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;
public final class zzbmp {
    private final View view;
    private final zzbfq zzdgc;
    private final zzdkw zzfnm;
    private final int zzfnn;
    private final boolean zzfno;
    private final boolean zzfnp;

    public zzbmp(View view2, @Nullable zzbfq zzbfq, zzdkw zzdkw, int i, boolean z, boolean z2) {
        this.view = view2;
        this.zzdgc = zzbfq;
        this.zzfnm = zzdkw;
        this.zzfnn = i;
        this.zzfno = z;
        this.zzfnp = z2;
    }

    @Nullable
    public final zzbfq zzahe() {
        return this.zzdgc;
    }

    public final View zzahf() {
        return this.view;
    }

    public final zzdkw zzahg() {
        return this.zzfnm;
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
}
