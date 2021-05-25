package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.IncomingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.OutgoingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.file.FileMessageClickListener;
import com.avito.android.messenger.conversation.adapter.file.FileMessagePresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvideFileMessagePresenter$messenger_releaseFactory implements Factory<FileMessagePresenter> {
    public final MessageAdapterModule a;
    public final Provider<IncomingMessagePresenter> b;
    public final Provider<OutgoingMessagePresenter> c;
    public final Provider<FileMessageClickListener> d;

    public MessageAdapterModule_ProvideFileMessagePresenter$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<IncomingMessagePresenter> provider, Provider<OutgoingMessagePresenter> provider2, Provider<FileMessageClickListener> provider3) {
        this.a = messageAdapterModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static MessageAdapterModule_ProvideFileMessagePresenter$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<IncomingMessagePresenter> provider, Provider<OutgoingMessagePresenter> provider2, Provider<FileMessageClickListener> provider3) {
        return new MessageAdapterModule_ProvideFileMessagePresenter$messenger_releaseFactory(messageAdapterModule, provider, provider2, provider3);
    }

    public static FileMessagePresenter provideFileMessagePresenter$messenger_release(MessageAdapterModule messageAdapterModule, IncomingMessagePresenter incomingMessagePresenter, OutgoingMessagePresenter outgoingMessagePresenter, FileMessageClickListener fileMessageClickListener) {
        return (FileMessagePresenter) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideFileMessagePresenter$messenger_release(incomingMessagePresenter, outgoingMessagePresenter, fileMessageClickListener));
    }

    @Override // javax.inject.Provider
    public FileMessagePresenter get() {
        return provideFileMessagePresenter$messenger_release(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
