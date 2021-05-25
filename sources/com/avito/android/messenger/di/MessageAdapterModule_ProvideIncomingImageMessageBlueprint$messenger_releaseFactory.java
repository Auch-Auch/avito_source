package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.image.ImageMessagePresenter;
import com.avito.android.messenger.conversation.adapter.image.IncomingImageMessageBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvideIncomingImageMessageBlueprint$messenger_releaseFactory implements Factory<IncomingImageMessageBlueprint> {
    public final MessageAdapterModule a;
    public final Provider<ImageMessagePresenter> b;

    public MessageAdapterModule_ProvideIncomingImageMessageBlueprint$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<ImageMessagePresenter> provider) {
        this.a = messageAdapterModule;
        this.b = provider;
    }

    public static MessageAdapterModule_ProvideIncomingImageMessageBlueprint$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<ImageMessagePresenter> provider) {
        return new MessageAdapterModule_ProvideIncomingImageMessageBlueprint$messenger_releaseFactory(messageAdapterModule, provider);
    }

    public static IncomingImageMessageBlueprint provideIncomingImageMessageBlueprint$messenger_release(MessageAdapterModule messageAdapterModule, ImageMessagePresenter imageMessagePresenter) {
        return (IncomingImageMessageBlueprint) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideIncomingImageMessageBlueprint$messenger_release(imageMessagePresenter));
    }

    @Override // javax.inject.Provider
    public IncomingImageMessageBlueprint get() {
        return provideIncomingImageMessageBlueprint$messenger_release(this.a, this.b.get());
    }
}
