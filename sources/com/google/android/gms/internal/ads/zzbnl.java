package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;
import java.util.Set;
public class zzbnl {
    private final View view;
    private final zzbfq zzdgc;
    private final zzdkw zzfnm;
    private final zzbpe zzfoc;

    public zzbnl(View view2, @Nullable zzbfq zzbfq, zzbpe zzbpe, zzdkw zzdkw) {
        this.view = view2;
        this.zzdgc = zzbfq;
        this.zzfoc = zzbpe;
        this.zzfnm = zzdkw;
    }

    public zzbue zza(Set<zzbys<zzbuj>> set) {
        return new zzbue(set);
    }

    @Nullable
    public final zzbfq zzahe() {
        return this.zzdgc;
    }

    public final View zzahq() {
        return this.view;
    }

    public final zzbpe zzahy() {
        return this.zzfoc;
    }

    public final zzdkw zzahz() {
        return this.zzfnm;
    }
}
