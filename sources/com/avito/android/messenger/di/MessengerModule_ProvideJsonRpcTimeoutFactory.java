package com.avito.android.messenger.di;

import dagger.internal.Factory;
public final class MessengerModule_ProvideJsonRpcTimeoutFactory implements Factory<Long> {
    public final MessengerModule a;

    public MessengerModule_ProvideJsonRpcTimeoutFactory(MessengerModule messengerModule) {
        this.a = messengerModule;
    }

    public static MessengerModule_ProvideJsonRpcTimeoutFactory create(MessengerModule messengerModule) {
        return new MessengerModule_ProvideJsonRpcTimeoutFactory(messengerModule);
    }

    public static long provideJsonRpcTimeout(MessengerModule messengerModule) {
        return messengerModule.provideJsonRpcTimeout();
    }

    @Override // javax.inject.Provider
    public Long get() {
        return Long.valueOf(provideJsonRpcTimeout(this.a));
    }
}
