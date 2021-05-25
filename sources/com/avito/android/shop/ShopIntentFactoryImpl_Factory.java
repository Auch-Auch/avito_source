package com.avito.android.shop;

import android.content.Context;
import com.avito.android.CoreActivityIntentFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopIntentFactoryImpl_Factory implements Factory<ShopIntentFactoryImpl> {
    public final Provider<Context> a;
    public final Provider<CoreActivityIntentFactory> b;

    public ShopIntentFactoryImpl_Factory(Provider<Context> provider, Provider<CoreActivityIntentFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ShopIntentFactoryImpl_Factory create(Provider<Context> provider, Provider<CoreActivityIntentFactory> provider2) {
        return new ShopIntentFactoryImpl_Factory(provider, provider2);
    }

    public static ShopIntentFactoryImpl newInstance(Context context, CoreActivityIntentFactory coreActivityIntentFactory) {
        return new ShopIntentFactoryImpl(context, coreActivityIntentFactory);
    }

    @Override // javax.inject.Provider
    public ShopIntentFactoryImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
