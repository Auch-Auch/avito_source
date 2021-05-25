package com.avito.android.di.module;

import com.avito.android.messenger.UnreadMessagesCounterRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class UnreadMessagesCounterModule_ProvideRelayFactory implements Factory<UnreadMessagesCounterRelay> {

    public static final class a {
        public static final UnreadMessagesCounterModule_ProvideRelayFactory a = new UnreadMessagesCounterModule_ProvideRelayFactory();
    }

    public static UnreadMessagesCounterModule_ProvideRelayFactory create() {
        return a.a;
    }

    public static UnreadMessagesCounterRelay provideRelay() {
        return (UnreadMessagesCounterRelay) Preconditions.checkNotNullFromProvides(UnreadMessagesCounterModule.provideRelay());
    }

    @Override // javax.inject.Provider
    public UnreadMessagesCounterRelay get() {
        return provideRelay();
    }
}
