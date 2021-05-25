package com.avito.android.bundles.vas_union.viewmodel;

import com.avito.android.bundles.vas_union.VasUnionConverter;
import com.avito.android.bundles.vas_union.repository.VasUnionRepository;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class VasUnionViewModelFactory_Factory implements Factory<VasUnionViewModelFactory> {
    public final Provider<String> a;
    public final Provider<VasUnionRepository> b;
    public final Provider<VasUnionConverter> c;
    public final Provider<SchedulersFactory3> d;

    public VasUnionViewModelFactory_Factory(Provider<String> provider, Provider<VasUnionRepository> provider2, Provider<VasUnionConverter> provider3, Provider<SchedulersFactory3> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static VasUnionViewModelFactory_Factory create(Provider<String> provider, Provider<VasUnionRepository> provider2, Provider<VasUnionConverter> provider3, Provider<SchedulersFactory3> provider4) {
        return new VasUnionViewModelFactory_Factory(provider, provider2, provider3, provider4);
    }

    public static VasUnionViewModelFactory newInstance(String str, VasUnionRepository vasUnionRepository, VasUnionConverter vasUnionConverter, SchedulersFactory3 schedulersFactory3) {
        return new VasUnionViewModelFactory(str, vasUnionRepository, vasUnionConverter, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public VasUnionViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
