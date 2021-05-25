package com.avito.android.messenger.di;

import dagger.internal.Factory;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.MessengerApiWrapper;
public final class MessengerModule_ProvideMessengerApiWrapperFactory implements Factory<MessengerApiWrapper> {
    public final MessengerModule a;

    public MessengerModule_ProvideMessengerApiWrapperFactory(MessengerModule messengerModule) {
        this.a = messengerModule;
    }

    public static MessengerModule_ProvideMessengerApiWrapperFactory create(MessengerModule messengerModule) {
        return new MessengerModule_ProvideMessengerApiWrapperFactory(messengerModule);
    }

    @Nullable
    public static MessengerApiWrapper provideMessengerApiWrapper(MessengerModule messengerModule) {
        return messengerModule.provideMessengerApiWrapper();
    }

    @Override // javax.inject.Provider
    @Nullable
    public MessengerApiWrapper get() {
        return provideMessengerApiWrapper(this.a);
    }
}
