package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.IncomingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.platform.from_avito.item.PlatformItemMessageFromAvitoPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvidePlatformItemMessageFromAvitoPresenter$messenger_releaseFactory implements Factory<PlatformItemMessageFromAvitoPresenter> {
    public final MessageAdapterModule a;
    public final Provider<IncomingMessagePresenter> b;

    public MessageAdapterModule_ProvidePlatformItemMessageFromAvitoPresenter$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<IncomingMessagePresenter> provider) {
        this.a = messageAdapterModule;
        this.b = provider;
    }

    public static MessageAdapterModule_ProvidePlatformItemMessageFromAvitoPresenter$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<IncomingMessagePresenter> provider) {
        return new MessageAdapterModule_ProvidePlatformItemMessageFromAvitoPresenter$messenger_releaseFactory(messageAdapterModule, provider);
    }

    public static PlatformItemMessageFromAvitoPresenter providePlatformItemMessageFromAvitoPresenter$messenger_release(MessageAdapterModule messageAdapterModule, IncomingMessagePresenter incomingMessagePresenter) {
        return (PlatformItemMessageFromAvitoPresenter) Preconditions.checkNotNullFromProvides(messageAdapterModule.providePlatformItemMessageFromAvitoPresenter$messenger_release(incomingMessagePresenter));
    }

    @Override // javax.inject.Provider
    public PlatformItemMessageFromAvitoPresenter get() {
        return providePlatformItemMessageFromAvitoPresenter$messenger_release(this.a, this.b.get());
    }
}
