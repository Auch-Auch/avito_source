package com.avito.android.update;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UpdateIntentFactoryImpl_Factory implements Factory<UpdateIntentFactoryImpl> {
    public final Provider<Context> a;

    public UpdateIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static UpdateIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new UpdateIntentFactoryImpl_Factory(provider);
    }

    public static UpdateIntentFactoryImpl newInstance(Context context) {
        return new UpdateIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public UpdateIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
