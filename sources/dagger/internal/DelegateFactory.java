package dagger.internal;

import javax.inject.Provider;
public final class DelegateFactory<T> implements Factory<T> {
    public Provider<T> a;

    public static <T> void setDelegate(Provider<T> provider, Provider<T> provider2) {
        Preconditions.checkNotNull(provider2);
        DelegateFactory delegateFactory = (DelegateFactory) provider;
        if (delegateFactory.a == null) {
            delegateFactory.a = provider2;
            return;
        }
        throw new IllegalStateException();
    }

    @Override // javax.inject.Provider
    public T get() {
        Provider<T> provider = this.a;
        if (provider != null) {
            return provider.get();
        }
        throw new IllegalStateException();
    }

    @Deprecated
    public void setDelegatedProvider(Provider<T> provider) {
        setDelegate(this, provider);
    }
}
