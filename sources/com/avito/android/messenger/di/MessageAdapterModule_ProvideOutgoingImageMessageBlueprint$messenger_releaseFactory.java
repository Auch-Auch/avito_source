package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.image.ImageMessagePresenter;
import com.avito.android.messenger.conversation.adapter.image.OutgoingImageMessageBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvideOutgoingImageMessageBlueprint$messenger_releaseFactory implements Factory<OutgoingImageMessageBlueprint> {
    public final MessageAdapterModule a;
    public final Provider<ImageMessagePresenter> b;

    public MessageAdapterModule_ProvideOutgoingImageMessageBlueprint$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<ImageMessagePresenter> provider) {
        this.a = messageAdapterModule;
        this.b = provider;
    }

    public static MessageAdapterModule_ProvideOutgoingImageMessageBlueprint$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<ImageMessagePresenter> provider) {
        return new MessageAdapterModule_ProvideOutgoingImageMessageBlueprint$messenger_releaseFactory(messageAdapterModule, provider);
    }

    public static OutgoingImageMessageBlueprint provideOutgoingImageMessageBlueprint$messenger_release(MessageAdapterModule messageAdapterModule, ImageMessagePresenter imageMessagePresenter) {
        return (OutgoingImageMessageBlueprint) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideOutgoingImageMessageBlueprint$messenger_release(imageMessagePresenter));
    }

    @Override // javax.inject.Provider
    public OutgoingImageMessageBlueprint get() {
        return provideOutgoingImageMessageBlueprint$messenger_release(this.a, this.b.get());
    }
}
