package com.avito.android.advert_core.delivery;

import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDeliveryBlockViewModelFactory_Factory implements Factory<AdvertDeliveryBlockViewModelFactory> {
    public final Provider<AdvertDeliveryBlockRepository> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<AttributedTextFormatter> c;

    public AdvertDeliveryBlockViewModelFactory_Factory(Provider<AdvertDeliveryBlockRepository> provider, Provider<SchedulersFactory3> provider2, Provider<AttributedTextFormatter> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static AdvertDeliveryBlockViewModelFactory_Factory create(Provider<AdvertDeliveryBlockRepository> provider, Provider<SchedulersFactory3> provider2, Provider<AttributedTextFormatter> provider3) {
        return new AdvertDeliveryBlockViewModelFactory_Factory(provider, provider2, provider3);
    }

    public static AdvertDeliveryBlockViewModelFactory newInstance(AdvertDeliveryBlockRepository advertDeliveryBlockRepository, SchedulersFactory3 schedulersFactory3, AttributedTextFormatter attributedTextFormatter) {
        return new AdvertDeliveryBlockViewModelFactory(advertDeliveryBlockRepository, schedulersFactory3, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public AdvertDeliveryBlockViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
