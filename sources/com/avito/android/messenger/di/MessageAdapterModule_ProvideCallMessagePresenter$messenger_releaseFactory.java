package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.IncomingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.OutgoingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.call.CallMessagePresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvideCallMessagePresenter$messenger_releaseFactory implements Factory<CallMessagePresenter> {
    public final MessageAdapterModule a;
    public final Provider<IncomingMessagePresenter> b;
    public final Provider<OutgoingMessagePresenter> c;

    public MessageAdapterModule_ProvideCallMessagePresenter$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<IncomingMessagePresenter> provider, Provider<OutgoingMessagePresenter> provider2) {
        this.a = messageAdapterModule;
        this.b = provider;
        this.c = provider2;
    }

    public static MessageAdapterModule_ProvideCallMessagePresenter$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<IncomingMessagePresenter> provider, Provider<OutgoingMessagePresenter> provider2) {
        return new MessageAdapterModule_ProvideCallMessagePresenter$messenger_releaseFactory(messageAdapterModule, provider, provider2);
    }

    public static CallMessagePresenter provideCallMessagePresenter$messenger_release(MessageAdapterModule messageAdapterModule, IncomingMessagePresenter incomingMessagePresenter, OutgoingMessagePresenter outgoingMessagePresenter) {
        return (CallMessagePresenter) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideCallMessagePresenter$messenger_release(incomingMessagePresenter, outgoingMessagePresenter));
    }

    @Override // javax.inject.Provider
    public CallMessagePresenter get() {
        return provideCallMessagePresenter$messenger_release(this.a, this.b.get(), this.c.get());
    }
}
