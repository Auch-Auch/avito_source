package com.avito.android.player.presenter;

import android.content.res.Resources;
import com.avito.android.remote.CallAdapterFactoryResourceProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PlayerResourcesProviderImpl_Factory implements Factory<PlayerResourcesProviderImpl> {
    public final Provider<Resources> a;
    public final Provider<CallAdapterFactoryResourceProvider> b;

    public PlayerResourcesProviderImpl_Factory(Provider<Resources> provider, Provider<CallAdapterFactoryResourceProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static PlayerResourcesProviderImpl_Factory create(Provider<Resources> provider, Provider<CallAdapterFactoryResourceProvider> provider2) {
        return new PlayerResourcesProviderImpl_Factory(provider, provider2);
    }

    public static PlayerResourcesProviderImpl newInstance(Resources resources, CallAdapterFactoryResourceProvider callAdapterFactoryResourceProvider) {
        return new PlayerResourcesProviderImpl(resources, callAdapterFactoryResourceProvider);
    }

    @Override // javax.inject.Provider
    public PlayerResourcesProviderImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
