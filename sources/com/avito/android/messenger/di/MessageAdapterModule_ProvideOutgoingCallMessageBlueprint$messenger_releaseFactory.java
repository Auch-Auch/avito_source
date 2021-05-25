package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.call.CallMessagePresenter;
import com.avito.android.messenger.conversation.adapter.call.OutgoingCallMessageBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvideOutgoingCallMessageBlueprint$messenger_releaseFactory implements Factory<OutgoingCallMessageBlueprint> {
    public final MessageAdapterModule a;
    public final Provider<CallMessagePresenter> b;

    public MessageAdapterModule_ProvideOutgoingCallMessageBlueprint$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<CallMessagePresenter> provider) {
        this.a = messageAdapterModule;
        this.b = provider;
    }

    public static MessageAdapterModule_ProvideOutgoingCallMessageBlueprint$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<CallMessagePresenter> provider) {
        return new MessageAdapterModule_ProvideOutgoingCallMessageBlueprint$messenger_releaseFactory(messageAdapterModule, provider);
    }

    public static OutgoingCallMessageBlueprint provideOutgoingCallMessageBlueprint$messenger_release(MessageAdapterModule messageAdapterModule, CallMessagePresenter callMessagePresenter) {
        return (OutgoingCallMessageBlueprint) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideOutgoingCallMessageBlueprint$messenger_release(callMessagePresenter));
    }

    @Override // javax.inject.Provider
    public OutgoingCallMessageBlueprint get() {
        return provideOutgoingCallMessageBlueprint$messenger_release(this.a, this.b.get());
    }
}
