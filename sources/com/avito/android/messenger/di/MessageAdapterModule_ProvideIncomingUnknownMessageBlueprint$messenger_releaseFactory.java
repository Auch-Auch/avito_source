package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.unknown.IncomingUnknownMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.unknown.UnknownMessagePresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvideIncomingUnknownMessageBlueprint$messenger_releaseFactory implements Factory<IncomingUnknownMessageBlueprint> {
    public final MessageAdapterModule a;
    public final Provider<UnknownMessagePresenter> b;

    public MessageAdapterModule_ProvideIncomingUnknownMessageBlueprint$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<UnknownMessagePresenter> provider) {
        this.a = messageAdapterModule;
        this.b = provider;
    }

    public static MessageAdapterModule_ProvideIncomingUnknownMessageBlueprint$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<UnknownMessagePresenter> provider) {
        return new MessageAdapterModule_ProvideIncomingUnknownMessageBlueprint$messenger_releaseFactory(messageAdapterModule, provider);
    }

    public static IncomingUnknownMessageBlueprint provideIncomingUnknownMessageBlueprint$messenger_release(MessageAdapterModule messageAdapterModule, UnknownMessagePresenter unknownMessagePresenter) {
        return (IncomingUnknownMessageBlueprint) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideIncomingUnknownMessageBlueprint$messenger_release(unknownMessagePresenter));
    }

    @Override // javax.inject.Provider
    public IncomingUnknownMessageBlueprint get() {
        return provideIncomingUnknownMessageBlueprint$messenger_release(this.a, this.b.get());
    }
}
