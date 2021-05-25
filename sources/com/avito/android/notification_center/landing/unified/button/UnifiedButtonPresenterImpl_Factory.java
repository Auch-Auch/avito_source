package com.avito.android.notification_center.landing.unified.button;

import com.jakewharton.rxrelay2.Relay;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UnifiedButtonPresenterImpl_Factory implements Factory<UnifiedButtonPresenterImpl> {
    public final Provider<Relay<UnifiedButtonItem>> a;

    public UnifiedButtonPresenterImpl_Factory(Provider<Relay<UnifiedButtonItem>> provider) {
        this.a = provider;
    }

    public static UnifiedButtonPresenterImpl_Factory create(Provider<Relay<UnifiedButtonItem>> provider) {
        return new UnifiedButtonPresenterImpl_Factory(provider);
    }

    public static UnifiedButtonPresenterImpl newInstance(Relay<UnifiedButtonItem> relay) {
        return new UnifiedButtonPresenterImpl(relay);
    }

    @Override // javax.inject.Provider
    public UnifiedButtonPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
