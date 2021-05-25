package dagger.internal;

import javax.inject.Provider;
public final class SingleCheck<T> implements Provider<T> {
    public static final Object c = new Object();
    public volatile Provider<T> a;
    public volatile Object b = c;

    public SingleCheck(Provider<T> provider) {
        this.a = provider;
    }

    public static <P extends Provider<T>, T> Provider<T> provider(P p) {
        return ((p instanceof SingleCheck) || (p instanceof DoubleCheck)) ? p : new SingleCheck((Provider) Preconditions.checkNotNull(p));
    }

    @Override // javax.inject.Provider
    public T get() {
        T t = (T) this.b;
        if (t != c) {
            return t;
        }
        Provider<T> provider = this.a;
        if (provider == null) {
            return (T) this.b;
        }
        T t2 = provider.get();
        this.b = t2;
        this.a = null;
        return t2;
    }
}
