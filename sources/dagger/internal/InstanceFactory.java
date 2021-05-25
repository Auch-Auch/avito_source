package dagger.internal;

import dagger.Lazy;
public final class InstanceFactory<T> implements Factory<T>, Lazy<T> {
    public static final InstanceFactory<Object> b = new InstanceFactory<>(null);
    public final T a;

    public InstanceFactory(T t) {
        this.a = t;
    }

    public static <T> Factory<T> create(T t) {
        return new InstanceFactory(Preconditions.checkNotNull(t, "instance cannot be null"));
    }

    public static <T> Factory<T> createNullable(T t) {
        if (t == null) {
            return b;
        }
        return new InstanceFactory(t);
    }

    @Override // javax.inject.Provider
    public T get() {
        return this.a;
    }
}
