package com.avito.android.di.module;

import com.avito.android.ab_tests.ABTestConfigTracker;
import com.avito.android.ab_tests.AbTestsConfigStorage;
import com.avito.android.ab_tests.AbTestsReloadTask;
import com.avito.android.remote.ConfigApi;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestModule_ProvideAbTestsReloadTaskFactory implements Factory<AbTestsReloadTask> {
    public final Provider<ConfigApi> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<AbTestsConfigStorage> c;
    public final Provider<DeviceMetrics> d;
    public final Provider<ABTestConfigTracker> e;

    public AbTestModule_ProvideAbTestsReloadTaskFactory(Provider<ConfigApi> provider, Provider<SchedulersFactory3> provider2, Provider<AbTestsConfigStorage> provider3, Provider<DeviceMetrics> provider4, Provider<ABTestConfigTracker> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static AbTestModule_ProvideAbTestsReloadTaskFactory create(Provider<ConfigApi> provider, Provider<SchedulersFactory3> provider2, Provider<AbTestsConfigStorage> provider3, Provider<DeviceMetrics> provider4, Provider<ABTestConfigTracker> provider5) {
        return new AbTestModule_ProvideAbTestsReloadTaskFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static AbTestsReloadTask provideAbTestsReloadTask(ConfigApi configApi, SchedulersFactory3 schedulersFactory3, AbTestsConfigStorage abTestsConfigStorage, DeviceMetrics deviceMetrics, ABTestConfigTracker aBTestConfigTracker) {
        return (AbTestsReloadTask) Preconditions.checkNotNullFromProvides(AbTestModule.INSTANCE.provideAbTestsReloadTask(configApi, schedulersFactory3, abTestsConfigStorage, deviceMetrics, aBTestConfigTracker));
    }

    @Override // javax.inject.Provider
    public AbTestsReloadTask get() {
        return provideAbTestsReloadTask(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
