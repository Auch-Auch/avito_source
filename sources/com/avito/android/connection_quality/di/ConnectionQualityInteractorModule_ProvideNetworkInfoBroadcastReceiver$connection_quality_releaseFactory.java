package com.avito.android.connection_quality.di;

import com.avito.android.connection_quality.NetworkInfoBroadcastReceiver;
import com.avito.android.connection_quality.NetworkInfoChangeListener;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class ConnectionQualityInteractorModule_ProvideNetworkInfoBroadcastReceiver$connection_quality_releaseFactory implements Factory<NetworkInfoBroadcastReceiver> {
    public final ConnectionQualityInteractorModule a;
    public final Provider<Set<NetworkInfoChangeListener>> b;

    public ConnectionQualityInteractorModule_ProvideNetworkInfoBroadcastReceiver$connection_quality_releaseFactory(ConnectionQualityInteractorModule connectionQualityInteractorModule, Provider<Set<NetworkInfoChangeListener>> provider) {
        this.a = connectionQualityInteractorModule;
        this.b = provider;
    }

    public static ConnectionQualityInteractorModule_ProvideNetworkInfoBroadcastReceiver$connection_quality_releaseFactory create(ConnectionQualityInteractorModule connectionQualityInteractorModule, Provider<Set<NetworkInfoChangeListener>> provider) {
        return new ConnectionQualityInteractorModule_ProvideNetworkInfoBroadcastReceiver$connection_quality_releaseFactory(connectionQualityInteractorModule, provider);
    }

    public static NetworkInfoBroadcastReceiver provideNetworkInfoBroadcastReceiver$connection_quality_release(ConnectionQualityInteractorModule connectionQualityInteractorModule, Set<NetworkInfoChangeListener> set) {
        return (NetworkInfoBroadcastReceiver) Preconditions.checkNotNullFromProvides(connectionQualityInteractorModule.provideNetworkInfoBroadcastReceiver$connection_quality_release(set));
    }

    @Override // javax.inject.Provider
    public NetworkInfoBroadcastReceiver get() {
        return provideNetworkInfoBroadcastReceiver$connection_quality_release(this.a, this.b.get());
    }
}
