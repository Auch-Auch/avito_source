package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.IncomingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.OutgoingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.image.ImageMessagePresenter;
import com.avito.android.messenger.conversation.adapter.image.MessagePictureProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvideImageMessagePresenter$messenger_releaseFactory implements Factory<ImageMessagePresenter> {
    public final MessageAdapterModule a;
    public final Provider<IncomingMessagePresenter> b;
    public final Provider<OutgoingMessagePresenter> c;
    public final Provider<MessagePictureProvider> d;

    public MessageAdapterModule_ProvideImageMessagePresenter$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<IncomingMessagePresenter> provider, Provider<OutgoingMessagePresenter> provider2, Provider<MessagePictureProvider> provider3) {
        this.a = messageAdapterModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static MessageAdapterModule_ProvideImageMessagePresenter$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<IncomingMessagePresenter> provider, Provider<OutgoingMessagePresenter> provider2, Provider<MessagePictureProvider> provider3) {
        return new MessageAdapterModule_ProvideImageMessagePresenter$messenger_releaseFactory(messageAdapterModule, provider, provider2, provider3);
    }

    public static ImageMessagePresenter provideImageMessagePresenter$messenger_release(MessageAdapterModule messageAdapterModule, IncomingMessagePresenter incomingMessagePresenter, OutgoingMessagePresenter outgoingMessagePresenter, MessagePictureProvider messagePictureProvider) {
        return (ImageMessagePresenter) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideImageMessagePresenter$messenger_release(incomingMessagePresenter, outgoingMessagePresenter, messagePictureProvider));
    }

    @Override // javax.inject.Provider
    public ImageMessagePresenter get() {
        return provideImageMessagePresenter$messenger_release(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
