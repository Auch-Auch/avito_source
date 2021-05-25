package com.avito.android.delivery.di.module;

import com.avito.android.delivery.profile_settings.DeliveryProfileSettingsViewModel;
import com.avito.android.delivery.profile_settings.DeliveryProfileSettingsViewModelFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DeliveryProfileSettingsModule_ProvideDeliveryProfileSettingsViewModelFactory implements Factory<DeliveryProfileSettingsViewModel> {
    public final DeliveryProfileSettingsModule a;
    public final Provider<DeliveryProfileSettingsViewModelFactory> b;

    public DeliveryProfileSettingsModule_ProvideDeliveryProfileSettingsViewModelFactory(DeliveryProfileSettingsModule deliveryProfileSettingsModule, Provider<DeliveryProfileSettingsViewModelFactory> provider) {
        this.a = deliveryProfileSettingsModule;
        this.b = provider;
    }

    public static DeliveryProfileSettingsModule_ProvideDeliveryProfileSettingsViewModelFactory create(DeliveryProfileSettingsModule deliveryProfileSettingsModule, Provider<DeliveryProfileSettingsViewModelFactory> provider) {
        return new DeliveryProfileSettingsModule_ProvideDeliveryProfileSettingsViewModelFactory(deliveryProfileSettingsModule, provider);
    }

    public static DeliveryProfileSettingsViewModel provideDeliveryProfileSettingsViewModel(DeliveryProfileSettingsModule deliveryProfileSettingsModule, DeliveryProfileSettingsViewModelFactory deliveryProfileSettingsViewModelFactory) {
        return (DeliveryProfileSettingsViewModel) Preconditions.checkNotNullFromProvides(deliveryProfileSettingsModule.provideDeliveryProfileSettingsViewModel(deliveryProfileSettingsViewModelFactory));
    }

    @Override // javax.inject.Provider
    public DeliveryProfileSettingsViewModel get() {
        return provideDeliveryProfileSettingsViewModel(this.a, this.b.get());
    }
}
