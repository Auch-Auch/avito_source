package com.avito.android.connection_quality.di;

import com.facebook.network.connectionclass.ConnectionClassManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class ConnectionQualityInteractorModule_ProvideConnectionClassManager$connection_quality_releaseFactory implements Factory<ConnectionClassManager> {
    public final ConnectionQualityInteractorModule a;

    public ConnectionQualityInteractorModule_ProvideConnectionClassManager$connection_quality_releaseFactory(ConnectionQualityInteractorModule connectionQualityInteractorModule) {
        this.a = connectionQualityInteractorModule;
    }

    public static ConnectionQualityInteractorModule_ProvideConnectionClassManager$connection_quality_releaseFactory create(ConnectionQualityInteractorModule connectionQualityInteractorModule) {
        return new ConnectionQualityInteractorModule_ProvideConnectionClassManager$connection_quality_releaseFactory(connectionQualityInteractorModule);
    }

    public static ConnectionClassManager provideConnectionClassManager$connection_quality_release(ConnectionQualityInteractorModule connectionQualityInteractorModule) {
        return (ConnectionClassManager) Preconditions.checkNotNullFromProvides(connectionQualityInteractorModule.provideConnectionClassManager$connection_quality_release());
    }

    @Override // javax.inject.Provider
    public ConnectionClassManager get() {
        return provideConnectionClassManager$connection_quality_release(this.a);
    }
}
