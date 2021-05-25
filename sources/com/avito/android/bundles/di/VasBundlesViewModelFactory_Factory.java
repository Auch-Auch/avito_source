package com.avito.android.bundles.di;

import com.avito.android.bundles.VasBundlesConverter;
import com.avito.android.bundles.repository.VasBundlesRepository;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class VasBundlesViewModelFactory_Factory implements Factory<VasBundlesViewModelFactory> {
    public final Provider<String> a;
    public final Provider<VasBundlesRepository> b;
    public final Provider<VasBundlesConverter> c;
    public final Provider<SchedulersFactory3> d;

    public VasBundlesViewModelFactory_Factory(Provider<String> provider, Provider<VasBundlesRepository> provider2, Provider<VasBundlesConverter> provider3, Provider<SchedulersFactory3> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static VasBundlesViewModelFactory_Factory create(Provider<String> provider, Provider<VasBundlesRepository> provider2, Provider<VasBundlesConverter> provider3, Provider<SchedulersFactory3> provider4) {
        return new VasBundlesViewModelFactory_Factory(provider, provider2, provider3, provider4);
    }

    public static VasBundlesViewModelFactory newInstance(String str, VasBundlesRepository vasBundlesRepository, VasBundlesConverter vasBundlesConverter, SchedulersFactory3 schedulersFactory3) {
        return new VasBundlesViewModelFactory(str, vasBundlesRepository, vasBundlesConverter, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public VasBundlesViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
