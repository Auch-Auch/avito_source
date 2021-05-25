package com.avito.android.connection_quality.di;

import com.avito.android.connection_quality.ConnectionManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class ConnectionQualityInteractorModule_ProvideConnectionManager$connection_quality_releaseFactory implements Factory<ConnectionManager> {
    public final ConnectionQualityInteractorModule a;

    public ConnectionQualityInteractorModule_ProvideConnectionManager$connection_quality_releaseFactory(ConnectionQualityInteractorModule connectionQualityInteractorModule) {
        this.a = connectionQualityInteractorModule;
    }

    public static ConnectionQualityInteractorModule_ProvideConnectionManager$connection_quality_releaseFactory create(ConnectionQualityInteractorModule connectionQualityInteractorModule) {
        return new ConnectionQualityInteractorModule_ProvideConnectionManager$connection_quality_releaseFactory(connectionQualityInteractorModule);
    }

    public static ConnectionManager provideConnectionManager$connection_quality_release(ConnectionQualityInteractorModule connectionQualityInteractorModule) {
        return (ConnectionManager) Preconditions.checkNotNullFromProvides(connectionQualityInteractorModule.provideConnectionManager$connection_quality_release());
    }

    @Override // javax.inject.Provider
    public ConnectionManager get() {
        return provideConnectionManager$connection_quality_release(this.a);
    }
}
