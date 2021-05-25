package dagger.internal;

import dagger.Lazy;
import javax.inject.Provider;
public final class ProviderOfLazy<T> implements Provider<Lazy<T>> {
    public final Provider<T> a;

    public ProviderOfLazy(Provider<T> provider) {
        this.a = provider;
    }

    public static <T> Provider<Lazy<T>> create(Provider<T> provider) {
        return new ProviderOfLazy((Provider) Preconditions.checkNotNull(provider));
    }

    @Override // javax.inject.Provider
    public Lazy<T> get() {
        return DoubleCheck.lazy(this.a);
    }
}
