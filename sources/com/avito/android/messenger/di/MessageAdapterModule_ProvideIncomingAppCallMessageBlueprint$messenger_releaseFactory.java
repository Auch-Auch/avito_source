package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.app_call.AppCallMessagePresenter;
import com.avito.android.messenger.conversation.adapter.app_call.IncomingAppCallMessageBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvideIncomingAppCallMessageBlueprint$messenger_releaseFactory implements Factory<IncomingAppCallMessageBlueprint> {
    public final MessageAdapterModule a;
    public final Provider<AppCallMessagePresenter> b;

    public MessageAdapterModule_ProvideIncomingAppCallMessageBlueprint$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<AppCallMessagePresenter> provider) {
        this.a = messageAdapterModule;
        this.b = provider;
    }

    public static MessageAdapterModule_ProvideIncomingAppCallMessageBlueprint$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<AppCallMessagePresenter> provider) {
        return new MessageAdapterModule_ProvideIncomingAppCallMessageBlueprint$messenger_releaseFactory(messageAdapterModule, provider);
    }

    public static IncomingAppCallMessageBlueprint provideIncomingAppCallMessageBlueprint$messenger_release(MessageAdapterModule messageAdapterModule, AppCallMessagePresenter appCallMessagePresenter) {
        return (IncomingAppCallMessageBlueprint) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideIncomingAppCallMessageBlueprint$messenger_release(appCallMessagePresenter));
    }

    @Override // javax.inject.Provider
    public IncomingAppCallMessageBlueprint get() {
        return provideIncomingAppCallMessageBlueprint$messenger_release(this.a, this.b.get());
    }
}
