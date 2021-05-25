package com.avito.android.connection_quality.di;

import com.avito.android.connection_quality.ConnectionQualityInteractor;
import com.avito.android.connection_quality.NetworkInfoChangeListener;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ConnectionQualityInteractorModule_ProvideConnectionQualityNetworkListenerFactory implements Factory<NetworkInfoChangeListener> {
    public final ConnectionQualityInteractorModule a;
    public final Provider<ConnectionQualityInteractor> b;

    public ConnectionQualityInteractorModule_ProvideConnectionQualityNetworkListenerFactory(ConnectionQualityInteractorModule connectionQualityInteractorModule, Provider<ConnectionQualityInteractor> provider) {
        this.a = connectionQualityInteractorModule;
        this.b = provider;
    }

    public static ConnectionQualityInteractorModule_ProvideConnectionQualityNetworkListenerFactory create(ConnectionQualityInteractorModule connectionQualityInteractorModule, Provider<ConnectionQualityInteractor> provider) {
        return new ConnectionQualityInteractorModule_ProvideConnectionQualityNetworkListenerFactory(connectionQualityInteractorModule, provider);
    }

    public static NetworkInfoChangeListener provideConnectionQualityNetworkListener(ConnectionQualityInteractorModule connectionQualityInteractorModule, ConnectionQualityInteractor connectionQualityInteractor) {
        return (NetworkInfoChangeListener) Preconditions.checkNotNullFromProvides(connectionQualityInteractorModule.provideConnectionQualityNetworkListener(connectionQualityInteractor));
    }

    @Override // javax.inject.Provider
    public NetworkInfoChangeListener get() {
        return provideConnectionQualityNetworkListener(this.a, this.b.get());
    }
}
