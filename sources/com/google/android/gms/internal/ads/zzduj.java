package com.google.android.gms.internal.ads;

import java.lang.Throwable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzduj<V, X extends Throwable> extends zzduh<V, X, zzdsl<? super X, ? extends V>, V> {
    public zzduj(zzdvt<? extends V> zzdvt, Class<X> cls, zzdsl<? super X, ? extends V> zzdsl) {
        super(zzdvt, cls, zzdsl);
    }

    @Override // com.google.android.gms.internal.ads.zzduh
    public final void setResult(@NullableDecl V v) {
        set(v);
    }

    @Override // com.google.android.gms.internal.ads.zzduh
    @NullableDecl
    public final /* synthetic */ Object zza(Object obj, Throwable th) throws Exception {
        return ((zzdsl) obj).apply(th);
    }
}
