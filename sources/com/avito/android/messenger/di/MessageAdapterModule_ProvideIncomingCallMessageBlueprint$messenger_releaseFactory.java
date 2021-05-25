package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.call.CallMessagePresenter;
import com.avito.android.messenger.conversation.adapter.call.IncomingCallMessageBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvideIncomingCallMessageBlueprint$messenger_releaseFactory implements Factory<IncomingCallMessageBlueprint> {
    public final MessageAdapterModule a;
    public final Provider<CallMessagePresenter> b;

    public MessageAdapterModule_ProvideIncomingCallMessageBlueprint$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<CallMessagePresenter> provider) {
        this.a = messageAdapterModule;
        this.b = provider;
    }

    public static MessageAdapterModule_ProvideIncomingCallMessageBlueprint$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<CallMessagePresenter> provider) {
        return new MessageAdapterModule_ProvideIncomingCallMessageBlueprint$messenger_releaseFactory(messageAdapterModule, provider);
    }

    public static IncomingCallMessageBlueprint provideIncomingCallMessageBlueprint$messenger_release(MessageAdapterModule messageAdapterModule, CallMessagePresenter callMessagePresenter) {
        return (IncomingCallMessageBlueprint) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideIncomingCallMessageBlueprint$messenger_release(callMessagePresenter));
    }

    @Override // javax.inject.Provider
    public IncomingCallMessageBlueprint get() {
        return provideIncomingCallMessageBlueprint$messenger_release(this.a, this.b.get());
    }
}
