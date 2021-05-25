package com.avito.android.di.module;

import com.avito.android.messenger.UnreadMessagesCounterConsumer;
import com.avito.android.messenger.UnreadMessagesCounterRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UnreadMessagesCounterModule_ProvideConsumerFactory implements Factory<UnreadMessagesCounterConsumer> {
    public final Provider<UnreadMessagesCounterRelay> a;

    public UnreadMessagesCounterModule_ProvideConsumerFactory(Provider<UnreadMessagesCounterRelay> provider) {
        this.a = provider;
    }

    public static UnreadMessagesCounterModule_ProvideConsumerFactory create(Provider<UnreadMessagesCounterRelay> provider) {
        return new UnreadMessagesCounterModule_ProvideConsumerFactory(provider);
    }

    public static UnreadMessagesCounterConsumer provideConsumer(UnreadMessagesCounterRelay unreadMessagesCounterRelay) {
        return (UnreadMessagesCounterConsumer) Preconditions.checkNotNullFromProvides(UnreadMessagesCounterModule.provideConsumer(unreadMessagesCounterRelay));
    }

    @Override // javax.inject.Provider
    public UnreadMessagesCounterConsumer get() {
        return provideConsumer(this.a.get());
    }
}
