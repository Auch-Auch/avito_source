package com.avito.android.safedeal.profile_settings;

import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.safedeal.profile_settings.konveyor.ProfileDeliverySettingsItemsConverter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeliveryProfileSettingsViewModelFactory_Factory implements Factory<DeliveryProfileSettingsViewModelFactory> {
    public final Provider<ProfileDeliverySettingsInteractor> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<ProfileDeliverySettingsItemsConverter> c;
    public final Provider<ProfileDeliverySettingsResourceProvider> d;
    public final Provider<BaseScreenPerformanceTracker> e;

    public DeliveryProfileSettingsViewModelFactory_Factory(Provider<ProfileDeliverySettingsInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<ProfileDeliverySettingsItemsConverter> provider3, Provider<ProfileDeliverySettingsResourceProvider> provider4, Provider<BaseScreenPerformanceTracker> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static DeliveryProfileSettingsViewModelFactory_Factory create(Provider<ProfileDeliverySettingsInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<ProfileDeliverySettingsItemsConverter> provider3, Provider<ProfileDeliverySettingsResourceProvider> provider4, Provider<BaseScreenPerformanceTracker> provider5) {
        return new DeliveryProfileSettingsViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static DeliveryProfileSettingsViewModelFactory newInstance(ProfileDeliverySettingsInteractor profileDeliverySettingsInteractor, SchedulersFactory3 schedulersFactory3, ProfileDeliverySettingsItemsConverter profileDeliverySettingsItemsConverter, ProfileDeliverySettingsResourceProvider profileDeliverySettingsResourceProvider, BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        return new DeliveryProfileSettingsViewModelFactory(profileDeliverySettingsInteractor, schedulersFactory3, profileDeliverySettingsItemsConverter, profileDeliverySettingsResourceProvider, baseScreenPerformanceTracker);
    }

    @Override // javax.inject.Provider
    public DeliveryProfileSettingsViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
