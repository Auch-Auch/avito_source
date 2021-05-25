package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.app_call.AppCallMessagePresenter;
import com.avito.android.messenger.conversation.adapter.app_call.OutgoingAppCallMessageBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvideOutgoingAppCallMessageBlueprint$messenger_releaseFactory implements Factory<OutgoingAppCallMessageBlueprint> {
    public final MessageAdapterModule a;
    public final Provider<AppCallMessagePresenter> b;

    public MessageAdapterModule_ProvideOutgoingAppCallMessageBlueprint$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<AppCallMessagePresenter> provider) {
        this.a = messageAdapterModule;
        this.b = provider;
    }

    public static MessageAdapterModule_ProvideOutgoingAppCallMessageBlueprint$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<AppCallMessagePresenter> provider) {
        return new MessageAdapterModule_ProvideOutgoingAppCallMessageBlueprint$messenger_releaseFactory(messageAdapterModule, provider);
    }

    public static OutgoingAppCallMessageBlueprint provideOutgoingAppCallMessageBlueprint$messenger_release(MessageAdapterModule messageAdapterModule, AppCallMessagePresenter appCallMessagePresenter) {
        return (OutgoingAppCallMessageBlueprint) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideOutgoingAppCallMessageBlueprint$messenger_release(appCallMessagePresenter));
    }

    @Override // javax.inject.Provider
    public OutgoingAppCallMessageBlueprint get() {
        return provideOutgoingAppCallMessageBlueprint$messenger_release(this.a, this.b.get());
    }
}
