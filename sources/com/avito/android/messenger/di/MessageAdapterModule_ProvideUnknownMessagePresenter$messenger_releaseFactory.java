package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.IncomingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.OutgoingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.unknown.UnknownMessagePresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvideUnknownMessagePresenter$messenger_releaseFactory implements Factory<UnknownMessagePresenter> {
    public final MessageAdapterModule a;
    public final Provider<IncomingMessagePresenter> b;
    public final Provider<OutgoingMessagePresenter> c;

    public MessageAdapterModule_ProvideUnknownMessagePresenter$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<IncomingMessagePresenter> provider, Provider<OutgoingMessagePresenter> provider2) {
        this.a = messageAdapterModule;
        this.b = provider;
        this.c = provider2;
    }

    public static MessageAdapterModule_ProvideUnknownMessagePresenter$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<IncomingMessagePresenter> provider, Provider<OutgoingMessagePresenter> provider2) {
        return new MessageAdapterModule_ProvideUnknownMessagePresenter$messenger_releaseFactory(messageAdapterModule, provider, provider2);
    }

    public static UnknownMessagePresenter provideUnknownMessagePresenter$messenger_release(MessageAdapterModule messageAdapterModule, IncomingMessagePresenter incomingMessagePresenter, OutgoingMessagePresenter outgoingMessagePresenter) {
        return (UnknownMessagePresenter) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideUnknownMessagePresenter$messenger_release(incomingMessagePresenter, outgoingMessagePresenter));
    }

    @Override // javax.inject.Provider
    public UnknownMessagePresenter get() {
        return provideUnknownMessagePresenter$messenger_release(this.a, this.b.get(), this.c.get());
    }
}
