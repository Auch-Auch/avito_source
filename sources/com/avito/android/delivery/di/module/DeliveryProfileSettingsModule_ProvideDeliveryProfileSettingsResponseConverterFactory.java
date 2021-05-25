package com.avito.android.delivery.di.module;

import com.avito.android.delivery.profile_settings.DeliveryProfileSettingsResponseConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class DeliveryProfileSettingsModule_ProvideDeliveryProfileSettingsResponseConverterFactory implements Factory<DeliveryProfileSettingsResponseConverter> {
    public final DeliveryProfileSettingsModule a;

    public DeliveryProfileSettingsModule_ProvideDeliveryProfileSettingsResponseConverterFactory(DeliveryProfileSettingsModule deliveryProfileSettingsModule) {
        this.a = deliveryProfileSettingsModule;
    }

    public static DeliveryProfileSettingsModule_ProvideDeliveryProfileSettingsResponseConverterFactory create(DeliveryProfileSettingsModule deliveryProfileSettingsModule) {
        return new DeliveryProfileSettingsModule_ProvideDeliveryProfileSettingsResponseConverterFactory(deliveryProfileSettingsModule);
    }

    public static DeliveryProfileSettingsResponseConverter provideDeliveryProfileSettingsResponseConverter(DeliveryProfileSettingsModule deliveryProfileSettingsModule) {
        return (DeliveryProfileSettingsResponseConverter) Preconditions.checkNotNullFromProvides(deliveryProfileSettingsModule.provideDeliveryProfileSettingsResponseConverter());
    }

    @Override // javax.inject.Provider
    public DeliveryProfileSettingsResponseConverter get() {
        return provideDeliveryProfileSettingsResponseConverter(this.a);
    }
}
