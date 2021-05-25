package com.avito.android.messenger.di;

import com.avito.android.messenger.MessageLocalIdGenerator;
import com.avito.android.util.RandomKeyProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessengerModule_ProvideMessageMessageLocalIdGeneratorFactory implements Factory<MessageLocalIdGenerator> {
    public final MessengerModule a;
    public final Provider<RandomKeyProvider> b;

    public MessengerModule_ProvideMessageMessageLocalIdGeneratorFactory(MessengerModule messengerModule, Provider<RandomKeyProvider> provider) {
        this.a = messengerModule;
        this.b = provider;
    }

    public static MessengerModule_ProvideMessageMessageLocalIdGeneratorFactory create(MessengerModule messengerModule, Provider<RandomKeyProvider> provider) {
        return new MessengerModule_ProvideMessageMessageLocalIdGeneratorFactory(messengerModule, provider);
    }

    public static MessageLocalIdGenerator provideMessageMessageLocalIdGenerator(MessengerModule messengerModule, RandomKeyProvider randomKeyProvider) {
        return (MessageLocalIdGenerator) Preconditions.checkNotNullFromProvides(messengerModule.provideMessageMessageLocalIdGenerator(randomKeyProvider));
    }

    @Override // javax.inject.Provider
    public MessageLocalIdGenerator get() {
        return provideMessageMessageLocalIdGenerator(this.a, this.b.get());
    }
}
