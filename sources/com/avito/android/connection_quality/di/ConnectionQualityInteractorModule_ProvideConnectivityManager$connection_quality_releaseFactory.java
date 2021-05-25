package com.avito.android.connection_quality.di;

import android.app.Application;
import android.net.ConnectivityManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ConnectionQualityInteractorModule_ProvideConnectivityManager$connection_quality_releaseFactory implements Factory<ConnectivityManager> {
    public final ConnectionQualityInteractorModule a;
    public final Provider<Application> b;

    public ConnectionQualityInteractorModule_ProvideConnectivityManager$connection_quality_releaseFactory(ConnectionQualityInteractorModule connectionQualityInteractorModule, Provider<Application> provider) {
        this.a = connectionQualityInteractorModule;
        this.b = provider;
    }

    public static ConnectionQualityInteractorModule_ProvideConnectivityManager$connection_quality_releaseFactory create(ConnectionQualityInteractorModule connectionQualityInteractorModule, Provider<Application> provider) {
        return new ConnectionQualityInteractorModule_ProvideConnectivityManager$connection_quality_releaseFactory(connectionQualityInteractorModule, provider);
    }

    public static ConnectivityManager provideConnectivityManager$connection_quality_release(ConnectionQualityInteractorModule connectionQualityInteractorModule, Application application) {
        return (ConnectivityManager) Preconditions.checkNotNullFromProvides(connectionQualityInteractorModule.provideConnectivityManager$connection_quality_release(application));
    }

    @Override // javax.inject.Provider
    public ConnectivityManager get() {
        return provideConnectivityManager$connection_quality_release(this.a, this.b.get());
    }
}
