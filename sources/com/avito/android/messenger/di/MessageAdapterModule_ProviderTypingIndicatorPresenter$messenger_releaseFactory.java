package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.typing.TypingIndicatorPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class MessageAdapterModule_ProviderTypingIndicatorPresenter$messenger_releaseFactory implements Factory<TypingIndicatorPresenter> {
    public final MessageAdapterModule a;

    public MessageAdapterModule_ProviderTypingIndicatorPresenter$messenger_releaseFactory(MessageAdapterModule messageAdapterModule) {
        this.a = messageAdapterModule;
    }

    public static MessageAdapterModule_ProviderTypingIndicatorPresenter$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule) {
        return new MessageAdapterModule_ProviderTypingIndicatorPresenter$messenger_releaseFactory(messageAdapterModule);
    }

    public static TypingIndicatorPresenter providerTypingIndicatorPresenter$messenger_release(MessageAdapterModule messageAdapterModule) {
        return (TypingIndicatorPresenter) Preconditions.checkNotNullFromProvides(messageAdapterModule.providerTypingIndicatorPresenter$messenger_release());
    }

    @Override // javax.inject.Provider
    public TypingIndicatorPresenter get() {
        return providerTypingIndicatorPresenter$messenger_release(this.a);
    }
}
