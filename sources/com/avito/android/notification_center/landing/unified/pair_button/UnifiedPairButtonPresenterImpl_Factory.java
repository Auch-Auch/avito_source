package com.avito.android.notification_center.landing.unified.pair_button;

import com.jakewharton.rxrelay2.Relay;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UnifiedPairButtonPresenterImpl_Factory implements Factory<UnifiedPairButtonPresenterImpl> {
    public final Provider<Relay<UnifiedPairButtonItem>> a;
    public final Provider<Relay<UnifiedPairButtonItem>> b;

    public UnifiedPairButtonPresenterImpl_Factory(Provider<Relay<UnifiedPairButtonItem>> provider, Provider<Relay<UnifiedPairButtonItem>> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static UnifiedPairButtonPresenterImpl_Factory create(Provider<Relay<UnifiedPairButtonItem>> provider, Provider<Relay<UnifiedPairButtonItem>> provider2) {
        return new UnifiedPairButtonPresenterImpl_Factory(provider, provider2);
    }

    public static UnifiedPairButtonPresenterImpl newInstance(Relay<UnifiedPairButtonItem> relay, Relay<UnifiedPairButtonItem> relay2) {
        return new UnifiedPairButtonPresenterImpl(relay, relay2);
    }

    @Override // javax.inject.Provider
    public UnifiedPairButtonPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
