package com.avito.android.delivery.di.module;

import com.avito.android.delivery.profile_settings.DeliveryProfileSettingsRepository;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DeliveryProfileSettingsModule_ProvideDeliveryProfileSettingsRepositoryFactory implements Factory<DeliveryProfileSettingsRepository> {
    public final DeliveryProfileSettingsModule a;
    public final Provider<ProfileApi> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<TypedErrorThrowableConverter> d;

    public DeliveryProfileSettingsModule_ProvideDeliveryProfileSettingsRepositoryFactory(DeliveryProfileSettingsModule deliveryProfileSettingsModule, Provider<ProfileApi> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3) {
        this.a = deliveryProfileSettingsModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static DeliveryProfileSettingsModule_ProvideDeliveryProfileSettingsRepositoryFactory create(DeliveryProfileSettingsModule deliveryProfileSettingsModule, Provider<ProfileApi> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3) {
        return new DeliveryProfileSettingsModule_ProvideDeliveryProfileSettingsRepositoryFactory(deliveryProfileSettingsModule, provider, provider2, provider3);
    }

    public static DeliveryProfileSettingsRepository provideDeliveryProfileSettingsRepository(DeliveryProfileSettingsModule deliveryProfileSettingsModule, ProfileApi profileApi, SchedulersFactory schedulersFactory, TypedErrorThrowableConverter typedErrorThrowableConverter) {
        return (DeliveryProfileSettingsRepository) Preconditions.checkNotNullFromProvides(deliveryProfileSettingsModule.provideDeliveryProfileSettingsRepository(profileApi, schedulersFactory, typedErrorThrowableConverter));
    }

    @Override // javax.inject.Provider
    public DeliveryProfileSettingsRepository get() {
        return provideDeliveryProfileSettingsRepository(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
