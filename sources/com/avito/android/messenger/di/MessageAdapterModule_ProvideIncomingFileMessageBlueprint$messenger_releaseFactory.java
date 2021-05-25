package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.file.FileMessagePresenter;
import com.avito.android.messenger.conversation.adapter.file.IncomingFileMessageBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvideIncomingFileMessageBlueprint$messenger_releaseFactory implements Factory<IncomingFileMessageBlueprint> {
    public final MessageAdapterModule a;
    public final Provider<FileMessagePresenter> b;

    public MessageAdapterModule_ProvideIncomingFileMessageBlueprint$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<FileMessagePresenter> provider) {
        this.a = messageAdapterModule;
        this.b = provider;
    }

    public static MessageAdapterModule_ProvideIncomingFileMessageBlueprint$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<FileMessagePresenter> provider) {
        return new MessageAdapterModule_ProvideIncomingFileMessageBlueprint$messenger_releaseFactory(messageAdapterModule, provider);
    }

    public static IncomingFileMessageBlueprint provideIncomingFileMessageBlueprint$messenger_release(MessageAdapterModule messageAdapterModule, FileMessagePresenter fileMessagePresenter) {
        return (IncomingFileMessageBlueprint) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideIncomingFileMessageBlueprint$messenger_release(fileMessagePresenter));
    }

    @Override // javax.inject.Provider
    public IncomingFileMessageBlueprint get() {
        return provideIncomingFileMessageBlueprint$messenger_release(this.a, this.b.get());
    }
}
