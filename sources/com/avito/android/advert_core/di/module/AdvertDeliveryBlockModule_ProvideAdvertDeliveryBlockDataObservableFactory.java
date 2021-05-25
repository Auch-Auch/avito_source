package com.avito.android.advert_core.di.module;

import com.avito.android.remote.model.AdvertDeliveryC2C;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class AdvertDeliveryBlockModule_ProvideAdvertDeliveryBlockDataObservableFactory implements Factory<PublishRelay<AdvertDeliveryC2C>> {

    public static final class a {
        public static final AdvertDeliveryBlockModule_ProvideAdvertDeliveryBlockDataObservableFactory a = new AdvertDeliveryBlockModule_ProvideAdvertDeliveryBlockDataObservableFactory();
    }

    public static AdvertDeliveryBlockModule_ProvideAdvertDeliveryBlockDataObservableFactory create() {
        return a.a;
    }

    public static PublishRelay<AdvertDeliveryC2C> provideAdvertDeliveryBlockDataObservable() {
        return (PublishRelay) Preconditions.checkNotNullFromProvides(AdvertDeliveryBlockModule.provideAdvertDeliveryBlockDataObservable());
    }

    @Override // javax.inject.Provider
    public PublishRelay<AdvertDeliveryC2C> get() {
        return provideAdvertDeliveryBlockDataObservable();
    }
}
