package com.avito.android.analytics;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NetworkTypeProviderImpl_Factory implements Factory<NetworkTypeProviderImpl> {
    public final Provider<Context> a;

    public NetworkTypeProviderImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static NetworkTypeProviderImpl_Factory create(Provider<Context> provider) {
        return new NetworkTypeProviderImpl_Factory(provider);
    }

    public static NetworkTypeProviderImpl newInstance(Context context) {
        return new NetworkTypeProviderImpl(context);
    }

    @Override // javax.inject.Provider
    public NetworkTypeProviderImpl get() {
        return newInstance(this.a.get());
    }
}
