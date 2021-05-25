package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzdum<I, O> extends zzduk<I, O, zzdsl<? super I, ? extends O>, O> {
    public zzdum(zzdvt<? extends I> zzdvt, zzdsl<? super I, ? extends O> zzdsl) {
        super(zzdvt, zzdsl);
    }

    @Override // com.google.android.gms.internal.ads.zzduk
    public final void setResult(@NullableDecl O o) {
        set(o);
    }

    @Override // com.google.android.gms.internal.ads.zzduk
    @NullableDecl
    public final /* synthetic */ Object zzd(Object obj, @NullableDecl Object obj2) throws Exception {
        return ((zzdsl) obj).apply(obj2);
    }
}
