package com.avito.android.express_cv;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ExpressCvIntentFactoryImpl_Factory implements Factory<ExpressCvIntentFactoryImpl> {
    public final Provider<Context> a;

    public ExpressCvIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static ExpressCvIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new ExpressCvIntentFactoryImpl_Factory(provider);
    }

    public static ExpressCvIntentFactoryImpl newInstance(Context context) {
        return new ExpressCvIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public ExpressCvIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
