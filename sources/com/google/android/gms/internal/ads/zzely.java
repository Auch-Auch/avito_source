package com.google.android.gms.internal.ads;
public final class zzely<T> implements zzelx<T> {
    private static final Object zzira = new Object();
    private volatile Object zzecl = zzira;
    private volatile zzelx<T> zzirb;

    private zzely(zzelx<T> zzelx) {
        this.zzirb = zzelx;
    }

    public static <P extends zzelx<T>, T> zzelx<T> zzas(P p) {
        return ((p instanceof zzely) || (p instanceof zzell)) ? p : new zzely((zzelx) zzelu.checkNotNull(p));
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final T get() {
        T t = (T) this.zzecl;
        if (t != zzira) {
            return t;
        }
        zzelx<T> zzelx = this.zzirb;
        if (zzelx == null) {
            return (T) this.zzecl;
        }
        T t2 = zzelx.get();
        this.zzecl = t2;
        this.zzirb = null;
        return t2;
    }
}
