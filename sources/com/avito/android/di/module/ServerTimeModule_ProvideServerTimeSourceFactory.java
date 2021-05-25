package com.avito.android.di.module;

import com.avito.android.server_time.ServerTimeSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.reactivex.Observable;
import javax.inject.Provider;
public final class ServerTimeModule_ProvideServerTimeSourceFactory implements Factory<ServerTimeSource> {
    public final Provider<Observable<Long>> a;

    public ServerTimeModule_ProvideServerTimeSourceFactory(Provider<Observable<Long>> provider) {
        this.a = provider;
    }

    public static ServerTimeModule_ProvideServerTimeSourceFactory create(Provider<Observable<Long>> provider) {
        return new ServerTimeModule_ProvideServerTimeSourceFactory(provider);
    }

    public static ServerTimeSource provideServerTimeSource(Observable<Long> observable) {
        return (ServerTimeSource) Preconditions.checkNotNullFromProvides(ServerTimeModule.provideServerTimeSource(observable));
    }

    @Override // javax.inject.Provider
    public ServerTimeSource get() {
        return provideServerTimeSource(this.a.get());
    }
}
