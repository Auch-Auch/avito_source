package com.google.android.gms.internal.ads;
public final class zzell<T> implements zzeli<T>, zzelx<T> {
    private static final Object zzira = new Object();
    private volatile Object zzecl = zzira;
    private volatile zzelx<T> zzirb;

    private zzell(zzelx<T> zzelx) {
        this.zzirb = zzelx;
    }

    public static <P extends zzelx<T>, T> zzelx<T> zzas(P p) {
        zzelu.checkNotNull(p);
        if (p instanceof zzell) {
            return p;
        }
        return new zzell(p);
    }

    public static <P extends zzelx<T>, T> zzeli<T> zzat(P p) {
        if (p instanceof zzeli) {
            return (zzeli) p;
        }
        return new zzell((zzelx) zzelu.checkNotNull(p));
    }

    @Override // com.google.android.gms.internal.ads.zzeli, com.google.android.gms.internal.ads.zzelx
    public final T get() {
        T t = (T) this.zzecl;
        Object obj = zzira;
        if (t == obj) {
            synchronized (this) {
                t = this.zzecl;
                if (t == obj) {
                    t = this.zzirb.get();
                    Object obj2 = this.zzecl;
                    if (obj2 != obj && !(obj2 instanceof zzelr)) {
                        if (obj2 != t) {
                            String valueOf = String.valueOf(obj2);
                            String valueOf2 = String.valueOf(t);
                            StringBuilder sb = new StringBuilder(valueOf.length() + 118 + valueOf2.length());
                            sb.append("Scoped provider was invoked recursively returning different results: ");
                            sb.append(valueOf);
                            sb.append(" & ");
                            sb.append(valueOf2);
                            sb.append(". This is likely due to a circular dependency.");
                            throw new IllegalStateException(sb.toString());
                        }
                    }
                    this.zzecl = t;
                    this.zzirb = null;
                }
            }
        }
        return t;
    }
}
