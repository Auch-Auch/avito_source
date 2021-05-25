package com.avito.android.shop.detailed;

import com.avito.android.server_time.TimeSource;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopItemVisibilityTrackerImpl_Factory implements Factory<ShopItemVisibilityTrackerImpl> {
    public final Provider<TimeSource> a;

    public ShopItemVisibilityTrackerImpl_Factory(Provider<TimeSource> provider) {
        this.a = provider;
    }

    public static ShopItemVisibilityTrackerImpl_Factory create(Provider<TimeSource> provider) {
        return new ShopItemVisibilityTrackerImpl_Factory(provider);
    }

    public static ShopItemVisibilityTrackerImpl newInstance(TimeSource timeSource) {
        return new ShopItemVisibilityTrackerImpl(timeSource);
    }

    @Override // javax.inject.Provider
    public ShopItemVisibilityTrackerImpl get() {
        return newInstance(this.a.get());
    }
}
