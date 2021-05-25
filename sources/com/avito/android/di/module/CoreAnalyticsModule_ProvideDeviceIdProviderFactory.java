package com.avito.android.di.module;

import android.app.Application;
import com.avito.android.AppConfigurationToggles;
import com.avito.android.remote.DeviceIdProvider;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CoreAnalyticsModule_ProvideDeviceIdProviderFactory implements Factory<DeviceIdProvider> {
    public final CoreAnalyticsModule a;
    public final Provider<Application> b;
    public final Provider<Preferences> c;
    public final Provider<AppConfigurationToggles> d;

    public CoreAnalyticsModule_ProvideDeviceIdProviderFactory(CoreAnalyticsModule coreAnalyticsModule, Provider<Application> provider, Provider<Preferences> provider2, Provider<AppConfigurationToggles> provider3) {
        this.a = coreAnalyticsModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static CoreAnalyticsModule_ProvideDeviceIdProviderFactory create(CoreAnalyticsModule coreAnalyticsModule, Provider<Application> provider, Provider<Preferences> provider2, Provider<AppConfigurationToggles> provider3) {
        return new CoreAnalyticsModule_ProvideDeviceIdProviderFactory(coreAnalyticsModule, provider, provider2, provider3);
    }

    public static DeviceIdProvider provideDeviceIdProvider(CoreAnalyticsModule coreAnalyticsModule, Application application, Preferences preferences, AppConfigurationToggles appConfigurationToggles) {
        return (DeviceIdProvider) Preconditions.checkNotNullFromProvides(coreAnalyticsModule.provideDeviceIdProvider(application, preferences, appConfigurationToggles));
    }

    @Override // javax.inject.Provider
    public DeviceIdProvider get() {
        return provideDeviceIdProvider(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
