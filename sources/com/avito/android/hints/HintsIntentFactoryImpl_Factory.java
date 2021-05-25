package com.avito.android.hints;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class HintsIntentFactoryImpl_Factory implements Factory<HintsIntentFactoryImpl> {
    public final Provider<Context> a;

    public HintsIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static HintsIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new HintsIntentFactoryImpl_Factory(provider);
    }

    public static HintsIntentFactoryImpl newInstance(Context context) {
        return new HintsIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public HintsIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
