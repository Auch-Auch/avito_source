package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.IncomingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.OutgoingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.platform.from_user.item.PlatformItemMessageFromUserPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvidePlatformItemMessageFromUserPresenter$messenger_releaseFactory implements Factory<PlatformItemMessageFromUserPresenter> {
    public final MessageAdapterModule a;
    public final Provider<IncomingMessagePresenter> b;
    public final Provider<OutgoingMessagePresenter> c;

    public MessageAdapterModule_ProvidePlatformItemMessageFromUserPresenter$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<IncomingMessagePresenter> provider, Provider<OutgoingMessagePresenter> provider2) {
        this.a = messageAdapterModule;
        this.b = provider;
        this.c = provider2;
    }

    public static MessageAdapterModule_ProvidePlatformItemMessageFromUserPresenter$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<IncomingMessagePresenter> provider, Provider<OutgoingMessagePresenter> provider2) {
        return new MessageAdapterModule_ProvidePlatformItemMessageFromUserPresenter$messenger_releaseFactory(messageAdapterModule, provider, provider2);
    }

    public static PlatformItemMessageFromUserPresenter providePlatformItemMessageFromUserPresenter$messenger_release(MessageAdapterModule messageAdapterModule, IncomingMessagePresenter incomingMessagePresenter, OutgoingMessagePresenter outgoingMessagePresenter) {
        return (PlatformItemMessageFromUserPresenter) Preconditions.checkNotNullFromProvides(messageAdapterModule.providePlatformItemMessageFromUserPresenter$messenger_release(incomingMessagePresenter, outgoingMessagePresenter));
    }

    @Override // javax.inject.Provider
    public PlatformItemMessageFromUserPresenter get() {
        return providePlatformItemMessageFromUserPresenter$messenger_release(this.a, this.b.get(), this.c.get());
    }
}
