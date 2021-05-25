package com.avito.android.notification_center.landing.unified.advert;

import com.avito.android.serp.adapter.FavorableItem;
import com.jakewharton.rxrelay2.Relay;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UnifiedAdvertPresenterImpl_Factory implements Factory<UnifiedAdvertPresenterImpl> {
    public final Provider<Relay<UnifiedAdvertItem>> a;
    public final Provider<Relay<FavorableItem>> b;

    public UnifiedAdvertPresenterImpl_Factory(Provider<Relay<UnifiedAdvertItem>> provider, Provider<Relay<FavorableItem>> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static UnifiedAdvertPresenterImpl_Factory create(Provider<Relay<UnifiedAdvertItem>> provider, Provider<Relay<FavorableItem>> provider2) {
        return new UnifiedAdvertPresenterImpl_Factory(provider, provider2);
    }

    public static UnifiedAdvertPresenterImpl newInstance(Relay<UnifiedAdvertItem> relay, Relay<FavorableItem> relay2) {
        return new UnifiedAdvertPresenterImpl(relay, relay2);
    }

    @Override // javax.inject.Provider
    public UnifiedAdvertPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
