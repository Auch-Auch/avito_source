package com.avito.android.item_map;

import android.content.Context;
import com.avito.android.CoreActivityIntentFactory;
import com.avito.android.Features;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ItemMapIntentFactoryImpl_Factory implements Factory<ItemMapIntentFactoryImpl> {
    public final Provider<Context> a;
    public final Provider<Features> b;
    public final Provider<CoreActivityIntentFactory> c;

    public ItemMapIntentFactoryImpl_Factory(Provider<Context> provider, Provider<Features> provider2, Provider<CoreActivityIntentFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static ItemMapIntentFactoryImpl_Factory create(Provider<Context> provider, Provider<Features> provider2, Provider<CoreActivityIntentFactory> provider3) {
        return new ItemMapIntentFactoryImpl_Factory(provider, provider2, provider3);
    }

    public static ItemMapIntentFactoryImpl newInstance(Context context, Features features, CoreActivityIntentFactory coreActivityIntentFactory) {
        return new ItemMapIntentFactoryImpl(context, features, coreActivityIntentFactory);
    }

    @Override // javax.inject.Provider
    public ItemMapIntentFactoryImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
