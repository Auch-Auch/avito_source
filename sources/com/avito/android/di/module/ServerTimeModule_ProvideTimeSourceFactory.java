package com.avito.android.di.module;

import com.avito.android.server_time.ServerTimeSource;
import com.avito.android.server_time.TimeSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ServerTimeModule_ProvideTimeSourceFactory implements Factory<TimeSource> {
    public final Provider<ServerTimeSource> a;

    public ServerTimeModule_ProvideTimeSourceFactory(Provider<ServerTimeSource> provider) {
        this.a = provider;
    }

    public static ServerTimeModule_ProvideTimeSourceFactory create(Provider<ServerTimeSource> provider) {
        return new ServerTimeModule_ProvideTimeSourceFactory(provider);
    }

    public static TimeSource provideTimeSource(ServerTimeSource serverTimeSource) {
        return (TimeSource) Preconditions.checkNotNullFromProvides(ServerTimeModule.provideTimeSource(serverTimeSource));
    }

    @Override // javax.inject.Provider
    public TimeSource get() {
        return provideTimeSource(this.a.get());
    }
}
