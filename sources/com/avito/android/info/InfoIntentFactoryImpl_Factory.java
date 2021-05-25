package com.avito.android.info;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class InfoIntentFactoryImpl_Factory implements Factory<InfoIntentFactoryImpl> {
    public final Provider<Context> a;

    public InfoIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static InfoIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new InfoIntentFactoryImpl_Factory(provider);
    }

    public static InfoIntentFactoryImpl newInstance(Context context) {
        return new InfoIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public InfoIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
