package com.google.android.play.core.internal;
public final class cg<T> implements ci, ce {
    public static final Object c = new Object();
    public volatile ci<T> a;
    public volatile Object b = c;

    public cg(ci<T> ciVar) {
        this.a = ciVar;
    }

    public static <P extends ci<T>, T> ci<T> a(P p) {
        bl.a(p);
        return !(p instanceof cg) ? new cg(p) : p;
    }

    public static <P extends ci<T>, T> ce<T> b(P p) {
        if (p instanceof ce) {
            return (ce) p;
        }
        bl.a(p);
        return new cg(p);
    }

    @Override // com.google.android.play.core.internal.ci
    public final T a() {
        T t = (T) this.b;
        Object obj = c;
        if (t == obj) {
            synchronized (this) {
                t = this.b;
                if (t == obj) {
                    t = this.a.a();
                    Object obj2 = this.b;
                    if (obj2 != obj) {
                        if (!(obj2 instanceof ch)) {
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
                    }
                    this.b = t;
                    this.a = null;
                }
            }
        }
        return t;
    }
}
