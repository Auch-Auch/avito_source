package com.avito.android.basket.paid_services;

import com.avito.android.deep_linking.DeepLinkIntentFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PaidServiceDeeplinkHandlerImpl_Factory implements Factory<PaidServiceDeeplinkHandlerImpl> {
    public final Provider<DeepLinkIntentFactory> a;

    public PaidServiceDeeplinkHandlerImpl_Factory(Provider<DeepLinkIntentFactory> provider) {
        this.a = provider;
    }

    public static PaidServiceDeeplinkHandlerImpl_Factory create(Provider<DeepLinkIntentFactory> provider) {
        return new PaidServiceDeeplinkHandlerImpl_Factory(provider);
    }

    public static PaidServiceDeeplinkHandlerImpl newInstance(DeepLinkIntentFactory deepLinkIntentFactory) {
        return new PaidServiceDeeplinkHandlerImpl(deepLinkIntentFactory);
    }

    @Override // javax.inject.Provider
    public PaidServiceDeeplinkHandlerImpl get() {
        return newInstance(this.a.get());
    }
}
