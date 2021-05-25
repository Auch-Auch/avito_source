package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.typing.TypingIndicatorBlueprint;
import com.avito.android.messenger.conversation.adapter.typing.TypingIndicatorPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvideTypingIndicatorBlueprint$messenger_releaseFactory implements Factory<TypingIndicatorBlueprint> {
    public final MessageAdapterModule a;
    public final Provider<TypingIndicatorPresenter> b;

    public MessageAdapterModule_ProvideTypingIndicatorBlueprint$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<TypingIndicatorPresenter> provider) {
        this.a = messageAdapterModule;
        this.b = provider;
    }

    public static MessageAdapterModule_ProvideTypingIndicatorBlueprint$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<TypingIndicatorPresenter> provider) {
        return new MessageAdapterModule_ProvideTypingIndicatorBlueprint$messenger_releaseFactory(messageAdapterModule, provider);
    }

    public static TypingIndicatorBlueprint provideTypingIndicatorBlueprint$messenger_release(MessageAdapterModule messageAdapterModule, TypingIndicatorPresenter typingIndicatorPresenter) {
        return (TypingIndicatorBlueprint) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideTypingIndicatorBlueprint$messenger_release(typingIndicatorPresenter));
    }

    @Override // javax.inject.Provider
    public TypingIndicatorBlueprint get() {
        return provideTypingIndicatorBlueprint$messenger_release(this.a, this.b.get());
    }
}
