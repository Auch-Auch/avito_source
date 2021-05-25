package com.avito.android.delivery.di.module;

import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.delivery.profile_settings.DeliveryProfileSettingsRepository;
import com.avito.android.delivery.profile_settings.DeliveryProfileSettingsResponseConverter;
import com.avito.android.delivery.profile_settings.DeliveryProfileSettingsViewModelFactory;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DeliveryProfileSettingsModule_ProvideDeliveryProfileSettingsViewModelFactoryFactory implements Factory<DeliveryProfileSettingsViewModelFactory> {
    public final DeliveryProfileSettingsModule a;
    public final Provider<SchedulersFactory> b;
    public final Provider<DeliveryProfileSettingsResponseConverter> c;
    public final Provider<DeliveryProfileSettingsRepository> d;
    public final Provider<BaseScreenPerformanceTracker> e;

    public DeliveryProfileSettingsModule_ProvideDeliveryProfileSettingsViewModelFactoryFactory(DeliveryProfileSettingsModule deliveryProfileSettingsModule, Provider<SchedulersFactory> provider, Provider<DeliveryProfileSettingsResponseConverter> provider2, Provider<DeliveryProfileSettingsRepository> provider3, Provider<BaseScreenPerformanceTracker> provider4) {
        this.a = deliveryProfileSettingsModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
    }

    public static DeliveryProfileSettingsModule_ProvideDeliveryProfileSettingsViewModelFactoryFactory create(DeliveryProfileSettingsModule deliveryProfileSettingsModule, Provider<SchedulersFactory> provider, Provider<DeliveryProfileSettingsResponseConverter> provider2, Provider<DeliveryProfileSettingsRepository> provider3, Provider<BaseScreenPerformanceTracker> provider4) {
        return new DeliveryProfileSettingsModule_ProvideDeliveryProfileSettingsViewModelFactoryFactory(deliveryProfileSettingsModule, provider, provider2, provider3, provider4);
    }

    public static DeliveryProfileSettingsViewModelFactory provideDeliveryProfileSettingsViewModelFactory(DeliveryProfileSettingsModule deliveryProfileSettingsModule, SchedulersFactory schedulersFactory, DeliveryProfileSettingsResponseConverter deliveryProfileSettingsResponseConverter, DeliveryProfileSettingsRepository deliveryProfileSettingsRepository, BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        return (DeliveryProfileSettingsViewModelFactory) Preconditions.checkNotNullFromProvides(deliveryProfileSettingsModule.provideDeliveryProfileSettingsViewModelFactory(schedulersFactory, deliveryProfileSettingsResponseConverter, deliveryProfileSettingsRepository, baseScreenPerformanceTracker));
    }

    @Override // javax.inject.Provider
    public DeliveryProfileSettingsViewModelFactory get() {
        return provideDeliveryProfileSettingsViewModelFactory(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
