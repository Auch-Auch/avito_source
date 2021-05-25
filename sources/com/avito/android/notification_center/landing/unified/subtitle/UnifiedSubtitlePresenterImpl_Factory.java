package com.avito.android.notification_center.landing.unified.subtitle;

import com.jakewharton.rxrelay2.Relay;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UnifiedSubtitlePresenterImpl_Factory implements Factory<UnifiedSubtitlePresenterImpl> {
    public final Provider<Relay<UnifiedSubtitleItem>> a;

    public UnifiedSubtitlePresenterImpl_Factory(Provider<Relay<UnifiedSubtitleItem>> provider) {
        this.a = provider;
    }

    public static UnifiedSubtitlePresenterImpl_Factory create(Provider<Relay<UnifiedSubtitleItem>> provider) {
        return new UnifiedSubtitlePresenterImpl_Factory(provider);
    }

    public static UnifiedSubtitlePresenterImpl newInstance(Relay<UnifiedSubtitleItem> relay) {
        return new UnifiedSubtitlePresenterImpl(relay);
    }

    @Override // javax.inject.Provider
    public UnifiedSubtitlePresenterImpl get() {
        return newInstance(this.a.get());
    }
}
