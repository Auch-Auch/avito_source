package com.avito.android.connection_quality;

import dagger.internal.Factory;
public final class NetworkSpeedProviderImpl_Factory implements Factory<NetworkSpeedProviderImpl> {

    public static final class a {
        public static final NetworkSpeedProviderImpl_Factory a = new NetworkSpeedProviderImpl_Factory();
    }

    public static NetworkSpeedProviderImpl_Factory create() {
        return a.a;
    }

    public static NetworkSpeedProviderImpl newInstance() {
        return new NetworkSpeedProviderImpl();
    }

    @Override // javax.inject.Provider
    public NetworkSpeedProviderImpl get() {
        return newInstance();
    }
}
