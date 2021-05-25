package dagger.internal;

import dagger.Lazy;
import javax.inject.Provider;
public final class DoubleCheck<T> implements Provider<T>, Lazy<T> {
    public static final Object c = new Object();
    public volatile Provider<T> a;
    public volatile Object b = c;

    public DoubleCheck(Provider<T> provider) {
        this.a = provider;
    }

    public static <P extends Provider<T>, T> Lazy<T> lazy(P p) {
        if (p instanceof Lazy) {
            return (Lazy) p;
        }
        return new DoubleCheck((Provider) Preconditions.checkNotNull(p));
    }

    public static <P extends Provider<T>, T> Provider<T> provider(P p) {
        Preconditions.checkNotNull(p);
        if (p instanceof DoubleCheck) {
            return p;
        }
        return new DoubleCheck(p);
    }

    public static Object reentrantCheck(Object obj, Object obj2) {
        if (!(obj != c && !(obj instanceof MemoizedSentinel)) || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // javax.inject.Provider
    public T get() {
        T t = (T) this.b;
        Object obj = c;
        if (t == obj) {
            synchronized (this) {
                t = this.b;
                if (t == obj) {
                    t = this.a.get();
                    this.b = reentrantCheck(this.b, t);
                    this.a = null;
                }
            }
        }
        return t;
    }
}
