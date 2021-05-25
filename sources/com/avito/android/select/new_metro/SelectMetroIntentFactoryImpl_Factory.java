package com.avito.android.select.new_metro;

import android.content.Context;
import com.avito.android.CoreActivityIntentFactory;
import com.avito.android.Features;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SelectMetroIntentFactoryImpl_Factory implements Factory<SelectMetroIntentFactoryImpl> {
    public final Provider<Context> a;
    public final Provider<Features> b;
    public final Provider<CoreActivityIntentFactory> c;

    public SelectMetroIntentFactoryImpl_Factory(Provider<Context> provider, Provider<Features> provider2, Provider<CoreActivityIntentFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static SelectMetroIntentFactoryImpl_Factory create(Provider<Context> provider, Provider<Features> provider2, Provider<CoreActivityIntentFactory> provider3) {
        return new SelectMetroIntentFactoryImpl_Factory(provider, provider2, provider3);
    }

    public static SelectMetroIntentFactoryImpl newInstance(Context context, Features features, CoreActivityIntentFactory coreActivityIntentFactory) {
        return new SelectMetroIntentFactoryImpl(context, features, coreActivityIntentFactory);
    }

    @Override // javax.inject.Provider
    public SelectMetroIntentFactoryImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
