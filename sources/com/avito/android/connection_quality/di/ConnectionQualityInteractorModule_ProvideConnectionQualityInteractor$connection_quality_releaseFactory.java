package com.avito.android.connection_quality.di;

import android.net.ConnectivityManager;
import com.avito.android.connection_quality.ConnectionQualityInteractor;
import com.facebook.network.connectionclass.ConnectionClassManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ConnectionQualityInteractorModule_ProvideConnectionQualityInteractor$connection_quality_releaseFactory implements Factory<ConnectionQualityInteractor> {
    public final ConnectionQualityInteractorModule a;
    public final Provider<ConnectivityManager> b;
    public final Provider<ConnectionClassManager> c;

    public ConnectionQualityInteractorModule_ProvideConnectionQualityInteractor$connection_quality_releaseFactory(ConnectionQualityInteractorModule connectionQualityInteractorModule, Provider<ConnectivityManager> provider, Provider<ConnectionClassManager> provider2) {
        this.a = connectionQualityInteractorModule;
        this.b = provider;
        this.c = provider2;
    }

    public static ConnectionQualityInteractorModule_ProvideConnectionQualityInteractor$connection_quality_releaseFactory create(ConnectionQualityInteractorModule connectionQualityInteractorModule, Provider<ConnectivityManager> provider, Provider<ConnectionClassManager> provider2) {
        return new ConnectionQualityInteractorModule_ProvideConnectionQualityInteractor$connection_quality_releaseFactory(connectionQualityInteractorModule, provider, provider2);
    }

    public static ConnectionQualityInteractor provideConnectionQualityInteractor$connection_quality_release(ConnectionQualityInteractorModule connectionQualityInteractorModule, ConnectivityManager connectivityManager, ConnectionClassManager connectionClassManager) {
        return (ConnectionQualityInteractor) Preconditions.checkNotNullFromProvides(connectionQualityInteractorModule.provideConnectionQualityInteractor$connection_quality_release(connectivityManager, connectionClassManager));
    }

    @Override // javax.inject.Provider
    public ConnectionQualityInteractor get() {
        return provideConnectionQualityInteractor$connection_quality_release(this.a, this.b.get(), this.c.get());
    }
}
