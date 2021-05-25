package com.avito.android.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.reactivex.functions.Consumer;
public final class ServerTimeModule_ProvideTimeDiffActionFactory implements Factory<Consumer<Long>> {

    public static final class a {
        public static final ServerTimeModule_ProvideTimeDiffActionFactory a = new ServerTimeModule_ProvideTimeDiffActionFactory();
    }

    public static ServerTimeModule_ProvideTimeDiffActionFactory create() {
        return a.a;
    }

    public static Consumer<Long> provideTimeDiffAction() {
        return (Consumer) Preconditions.checkNotNullFromProvides(ServerTimeModule.provideTimeDiffAction());
    }

    @Override // javax.inject.Provider
    public Consumer<Long> get() {
        return provideTimeDiffAction();
    }
}
