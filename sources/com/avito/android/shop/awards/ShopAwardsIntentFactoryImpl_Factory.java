package com.avito.android.shop.awards;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopAwardsIntentFactoryImpl_Factory implements Factory<ShopAwardsIntentFactoryImpl> {
    public final Provider<Application> a;

    public ShopAwardsIntentFactoryImpl_Factory(Provider<Application> provider) {
        this.a = provider;
    }

    public static ShopAwardsIntentFactoryImpl_Factory create(Provider<Application> provider) {
        return new ShopAwardsIntentFactoryImpl_Factory(provider);
    }

    public static ShopAwardsIntentFactoryImpl newInstance(Application application) {
        return new ShopAwardsIntentFactoryImpl(application);
    }

    @Override // javax.inject.Provider
    public ShopAwardsIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
