package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.IncomingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.image.MessagePictureProvider;
import com.avito.android.messenger.conversation.adapter.platform.from_avito.image.PlatformImageMessageFromAvitoPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvidePlatformImageMessageFromAvitoPresenter$messenger_releaseFactory implements Factory<PlatformImageMessageFromAvitoPresenter> {
    public final MessageAdapterModule a;
    public final Provider<IncomingMessagePresenter> b;
    public final Provider<MessagePictureProvider> c;

    public MessageAdapterModule_ProvidePlatformImageMessageFromAvitoPresenter$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<IncomingMessagePresenter> provider, Provider<MessagePictureProvider> provider2) {
        this.a = messageAdapterModule;
        this.b = provider;
        this.c = provider2;
    }

    public static MessageAdapterModule_ProvidePlatformImageMessageFromAvitoPresenter$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<IncomingMessagePresenter> provider, Provider<MessagePictureProvider> provider2) {
        return new MessageAdapterModule_ProvidePlatformImageMessageFromAvitoPresenter$messenger_releaseFactory(messageAdapterModule, provider, provider2);
    }

    public static PlatformImageMessageFromAvitoPresenter providePlatformImageMessageFromAvitoPresenter$messenger_release(MessageAdapterModule messageAdapterModule, IncomingMessagePresenter incomingMessagePresenter, MessagePictureProvider messagePictureProvider) {
        return (PlatformImageMessageFromAvitoPresenter) Preconditions.checkNotNullFromProvides(messageAdapterModule.providePlatformImageMessageFromAvitoPresenter$messenger_release(incomingMessagePresenter, messagePictureProvider));
    }

    @Override // javax.inject.Provider
    public PlatformImageMessageFromAvitoPresenter get() {
        return providePlatformImageMessageFromAvitoPresenter$messenger_release(this.a, this.b.get(), this.c.get());
    }
}
