package com.avito.android.messenger.di;

import com.avito.android.Features;
import com.avito.android.messenger.conversation.adapter.text.OutgoingTextMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.text.TextMessagePresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvideOutgoingTextMessageBlueprint$messenger_releaseFactory implements Factory<OutgoingTextMessageBlueprint> {
    public final MessageAdapterModule a;
    public final Provider<TextMessagePresenter> b;
    public final Provider<Features> c;

    public MessageAdapterModule_ProvideOutgoingTextMessageBlueprint$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<TextMessagePresenter> provider, Provider<Features> provider2) {
        this.a = messageAdapterModule;
        this.b = provider;
        this.c = provider2;
    }

    public static MessageAdapterModule_ProvideOutgoingTextMessageBlueprint$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<TextMessagePresenter> provider, Provider<Features> provider2) {
        return new MessageAdapterModule_ProvideOutgoingTextMessageBlueprint$messenger_releaseFactory(messageAdapterModule, provider, provider2);
    }

    public static OutgoingTextMessageBlueprint provideOutgoingTextMessageBlueprint$messenger_release(MessageAdapterModule messageAdapterModule, TextMessagePresenter textMessagePresenter, Features features) {
        return (OutgoingTextMessageBlueprint) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideOutgoingTextMessageBlueprint$messenger_release(textMessagePresenter, features));
    }

    @Override // javax.inject.Provider
    public OutgoingTextMessageBlueprint get() {
        return provideOutgoingTextMessageBlueprint$messenger_release(this.a, this.b.get(), this.c.get());
    }
}
