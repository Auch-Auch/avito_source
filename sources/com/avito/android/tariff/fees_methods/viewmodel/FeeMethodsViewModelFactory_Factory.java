package com.avito.android.tariff.fees_methods.viewmodel;

import com.avito.android.publish_limits_info.analytics.PublishLimitsEventTracker;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FeeMethodsViewModelFactory_Factory implements Factory<FeeMethodsViewModelFactory> {
    public final Provider<String> a;
    public final Provider<FeeMethodsRepository> b;
    public final Provider<FeeMethodsConverter> c;
    public final Provider<SchedulersFactory> d;
    public final Provider<Boolean> e;
    public final Provider<PublishLimitsEventTracker> f;

    public FeeMethodsViewModelFactory_Factory(Provider<String> provider, Provider<FeeMethodsRepository> provider2, Provider<FeeMethodsConverter> provider3, Provider<SchedulersFactory> provider4, Provider<Boolean> provider5, Provider<PublishLimitsEventTracker> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static FeeMethodsViewModelFactory_Factory create(Provider<String> provider, Provider<FeeMethodsRepository> provider2, Provider<FeeMethodsConverter> provider3, Provider<SchedulersFactory> provider4, Provider<Boolean> provider5, Provider<PublishLimitsEventTracker> provider6) {
        return new FeeMethodsViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static FeeMethodsViewModelFactory newInstance(String str, FeeMethodsRepository feeMethodsRepository, FeeMethodsConverter feeMethodsConverter, SchedulersFactory schedulersFactory, boolean z, PublishLimitsEventTracker publishLimitsEventTracker) {
        return new FeeMethodsViewModelFactory(str, feeMethodsRepository, feeMethodsConverter, schedulersFactory, z, publishLimitsEventTracker);
    }

    @Override // javax.inject.Provider
    public FeeMethodsViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get().booleanValue(), this.f.get());
    }
}
