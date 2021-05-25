package com.avito.android.stub;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class StubMessengerModule_ProvideAvitoMessengerApiFactory implements Factory<AvitoMessengerApi> {

    public static final class a {
        public static final StubMessengerModule_ProvideAvitoMessengerApiFactory a = new StubMessengerModule_ProvideAvitoMessengerApiFactory();
    }

    public static StubMessengerModule_ProvideAvitoMessengerApiFactory create() {
        return a.a;
    }

    public static AvitoMessengerApi provideAvitoMessengerApi() {
        return (AvitoMessengerApi) Preconditions.checkNotNullFromProvides(StubMessengerModule.INSTANCE.provideAvitoMessengerApi());
    }

    @Override // javax.inject.Provider
    public AvitoMessengerApi get() {
        return provideAvitoMessengerApi();
    }
}
