package com.avito.android.autoteka_details;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AutotekaDetailsIntentFactoryImpl_Factory implements Factory<AutotekaDetailsIntentFactoryImpl> {
    public final Provider<Context> a;

    public AutotekaDetailsIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static AutotekaDetailsIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new AutotekaDetailsIntentFactoryImpl_Factory(provider);
    }

    public static AutotekaDetailsIntentFactoryImpl newInstance(Context context) {
        return new AutotekaDetailsIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public AutotekaDetailsIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
