package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.unknown.OutgoingUnknownMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.unknown.UnknownMessagePresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvideOutgoingUnknownMessageBlueprint$messenger_releaseFactory implements Factory<OutgoingUnknownMessageBlueprint> {
    public final MessageAdapterModule a;
    public final Provider<UnknownMessagePresenter> b;

    public MessageAdapterModule_ProvideOutgoingUnknownMessageBlueprint$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<UnknownMessagePresenter> provider) {
        this.a = messageAdapterModule;
        this.b = provider;
    }

    public static MessageAdapterModule_ProvideOutgoingUnknownMessageBlueprint$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<UnknownMessagePresenter> provider) {
        return new MessageAdapterModule_ProvideOutgoingUnknownMessageBlueprint$messenger_releaseFactory(messageAdapterModule, provider);
    }

    public static OutgoingUnknownMessageBlueprint provideOutgoingUnknownMessageBlueprint$messenger_release(MessageAdapterModule messageAdapterModule, UnknownMessagePresenter unknownMessagePresenter) {
        return (OutgoingUnknownMessageBlueprint) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideOutgoingUnknownMessageBlueprint$messenger_release(unknownMessagePresenter));
    }

    @Override // javax.inject.Provider
    public OutgoingUnknownMessageBlueprint get() {
        return provideOutgoingUnknownMessageBlueprint$messenger_release(this.a, this.b.get());
    }
}
