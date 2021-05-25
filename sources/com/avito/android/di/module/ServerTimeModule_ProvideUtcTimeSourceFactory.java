package com.avito.android.di.module;

import com.avito.android.server_time.ServerTimeSource;
import com.avito.android.server_time.UtcTimeSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ServerTimeModule_ProvideUtcTimeSourceFactory implements Factory<UtcTimeSource> {
    public final Provider<ServerTimeSource> a;

    public ServerTimeModule_ProvideUtcTimeSourceFactory(Provider<ServerTimeSource> provider) {
        this.a = provider;
    }

    public static ServerTimeModule_ProvideUtcTimeSourceFactory create(Provider<ServerTimeSource> provider) {
        return new ServerTimeModule_ProvideUtcTimeSourceFactory(provider);
    }

    public static UtcTimeSource provideUtcTimeSource(ServerTimeSource serverTimeSource) {
        return (UtcTimeSource) Preconditions.checkNotNullFromProvides(ServerTimeModule.provideUtcTimeSource(serverTimeSource));
    }

    @Override // javax.inject.Provider
    public UtcTimeSource get() {
        return provideUtcTimeSource(this.a.get());
    }
}
