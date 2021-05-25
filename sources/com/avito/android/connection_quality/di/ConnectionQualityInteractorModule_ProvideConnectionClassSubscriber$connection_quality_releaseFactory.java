package com.avito.android.connection_quality.di;

import com.avito.android.connection_quality.ConnectionManager;
import com.avito.android.connection_quality.ConnectionQualityInteractor;
import com.avito.android.connection_quality.ConnectionQualitySubscriber;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ConnectionQualityInteractorModule_ProvideConnectionClassSubscriber$connection_quality_releaseFactory implements Factory<ConnectionQualitySubscriber> {
    public final ConnectionQualityInteractorModule a;
    public final Provider<ConnectionManager> b;
    public final Provider<ConnectionQualityInteractor> c;

    public ConnectionQualityInteractorModule_ProvideConnectionClassSubscriber$connection_quality_releaseFactory(ConnectionQualityInteractorModule connectionQualityInteractorModule, Provider<ConnectionManager> provider, Provider<ConnectionQualityInteractor> provider2) {
        this.a = connectionQualityInteractorModule;
        this.b = provider;
        this.c = provider2;
    }

    public static ConnectionQualityInteractorModule_ProvideConnectionClassSubscriber$connection_quality_releaseFactory create(ConnectionQualityInteractorModule connectionQualityInteractorModule, Provider<ConnectionManager> provider, Provider<ConnectionQualityInteractor> provider2) {
        return new ConnectionQualityInteractorModule_ProvideConnectionClassSubscriber$connection_quality_releaseFactory(connectionQualityInteractorModule, provider, provider2);
    }

    public static ConnectionQualitySubscriber provideConnectionClassSubscriber$connection_quality_release(ConnectionQualityInteractorModule connectionQualityInteractorModule, ConnectionManager connectionManager, ConnectionQualityInteractor connectionQualityInteractor) {
        return (ConnectionQualitySubscriber) Preconditions.checkNotNullFromProvides(connectionQualityInteractorModule.provideConnectionClassSubscriber$connection_quality_release(connectionManager, connectionQualityInteractor));
    }

    @Override // javax.inject.Provider
    public ConnectionQualitySubscriber get() {
        return provideConnectionClassSubscriber$connection_quality_release(this.a, this.b.get(), this.c.get());
    }
}
