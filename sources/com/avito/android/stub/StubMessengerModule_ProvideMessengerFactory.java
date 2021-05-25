package com.avito.android.stub;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import ru.avito.messenger.Messenger;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class StubMessengerModule_ProvideMessengerFactory implements Factory<Messenger<AvitoMessengerApi>> {

    public static final class a {
        public static final StubMessengerModule_ProvideMessengerFactory a = new StubMessengerModule_ProvideMessengerFactory();
    }

    public static StubMessengerModule_ProvideMessengerFactory create() {
        return a.a;
    }

    public static Messenger<AvitoMessengerApi> provideMessenger() {
        return (Messenger) Preconditions.checkNotNullFromProvides(StubMessengerModule.INSTANCE.provideMessenger());
    }

    @Override // javax.inject.Provider
    public Messenger<AvitoMessengerApi> get() {
        return provideMessenger();
    }
}
