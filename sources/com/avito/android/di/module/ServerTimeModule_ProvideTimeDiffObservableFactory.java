package com.avito.android.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.reactivex.Observable;
public final class ServerTimeModule_ProvideTimeDiffObservableFactory implements Factory<Observable<Long>> {

    public static final class a {
        public static final ServerTimeModule_ProvideTimeDiffObservableFactory a = new ServerTimeModule_ProvideTimeDiffObservableFactory();
    }

    public static ServerTimeModule_ProvideTimeDiffObservableFactory create() {
        return a.a;
    }

    public static Observable<Long> provideTimeDiffObservable() {
        return (Observable) Preconditions.checkNotNullFromProvides(ServerTimeModule.provideTimeDiffObservable());
    }

    @Override // javax.inject.Provider
    public Observable<Long> get() {
        return provideTimeDiffObservable();
    }
}
