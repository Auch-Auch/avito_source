package com.google.android.gms.internal.ads;
public final class zzbbr<T> extends zzbbq<T> {
    private final T zzeef;

    private zzbbr(T t) {
        this.zzeef = t;
    }

    public static <T> zzbbr<T> zzl(T t) {
        return new zzbbr<>(t);
    }

    public final void zzys() {
        set(this.zzeef);
    }
}
