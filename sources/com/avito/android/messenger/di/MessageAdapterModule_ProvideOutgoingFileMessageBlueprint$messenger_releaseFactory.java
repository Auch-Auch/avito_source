package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.file.FileMessagePresenter;
import com.avito.android.messenger.conversation.adapter.file.OutgoingFileMessageBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvideOutgoingFileMessageBlueprint$messenger_releaseFactory implements Factory<OutgoingFileMessageBlueprint> {
    public final MessageAdapterModule a;
    public final Provider<FileMessagePresenter> b;

    public MessageAdapterModule_ProvideOutgoingFileMessageBlueprint$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<FileMessagePresenter> provider) {
        this.a = messageAdapterModule;
        this.b = provider;
    }

    public static MessageAdapterModule_ProvideOutgoingFileMessageBlueprint$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<FileMessagePresenter> provider) {
        return new MessageAdapterModule_ProvideOutgoingFileMessageBlueprint$messenger_releaseFactory(messageAdapterModule, provider);
    }

    public static OutgoingFileMessageBlueprint provideOutgoingFileMessageBlueprint$messenger_release(MessageAdapterModule messageAdapterModule, FileMessagePresenter fileMessagePresenter) {
        return (OutgoingFileMessageBlueprint) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideOutgoingFileMessageBlueprint$messenger_release(fileMessagePresenter));
    }

    @Override // javax.inject.Provider
    public OutgoingFileMessageBlueprint get() {
        return provideOutgoingFileMessageBlueprint$messenger_release(this.a, this.b.get());
    }
}
