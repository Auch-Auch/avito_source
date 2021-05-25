package com.avito.android.connection_quality.connectivity;

import android.content.Context;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ConnectivityProviderImpl_Factory implements Factory<ConnectivityProviderImpl> {
    public final Provider<Context> a;
    public final Provider<SchedulersFactory> b;

    public ConnectivityProviderImpl_Factory(Provider<Context> provider, Provider<SchedulersFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ConnectivityProviderImpl_Factory create(Provider<Context> provider, Provider<SchedulersFactory> provider2) {
        return new ConnectivityProviderImpl_Factory(provider, provider2);
    }

    public static ConnectivityProviderImpl newInstance(Context context, SchedulersFactory schedulersFactory) {
        return new ConnectivityProviderImpl(context, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public ConnectivityProviderImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
