package com.avito.android.deep_linking;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeepLinkingIntentFactoryImpl_Factory implements Factory<DeepLinkingIntentFactoryImpl> {
    public final Provider<Context> a;

    public DeepLinkingIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static DeepLinkingIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new DeepLinkingIntentFactoryImpl_Factory(provider);
    }

    public static DeepLinkingIntentFactoryImpl newInstance(Context context) {
        return new DeepLinkingIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public DeepLinkingIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
