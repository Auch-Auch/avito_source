package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.image.MessagePictureProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class MessageAdapterModule_ProvideMessagePictureProvider$messenger_releaseFactory implements Factory<MessagePictureProvider> {
    public final MessageAdapterModule a;

    public MessageAdapterModule_ProvideMessagePictureProvider$messenger_releaseFactory(MessageAdapterModule messageAdapterModule) {
        this.a = messageAdapterModule;
    }

    public static MessageAdapterModule_ProvideMessagePictureProvider$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule) {
        return new MessageAdapterModule_ProvideMessagePictureProvider$messenger_releaseFactory(messageAdapterModule);
    }

    public static MessagePictureProvider provideMessagePictureProvider$messenger_release(MessageAdapterModule messageAdapterModule) {
        return (MessagePictureProvider) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideMessagePictureProvider$messenger_release());
    }

    @Override // javax.inject.Provider
    public MessagePictureProvider get() {
        return provideMessagePictureProvider$messenger_release(this.a);
    }
}
