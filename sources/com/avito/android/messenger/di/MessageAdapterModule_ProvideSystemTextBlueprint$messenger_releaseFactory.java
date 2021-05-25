package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.system.SystemTextBlueprint;
import com.avito.android.messenger.conversation.adapter.system.SystemTextPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvideSystemTextBlueprint$messenger_releaseFactory implements Factory<SystemTextBlueprint> {
    public final MessageAdapterModule a;
    public final Provider<SystemTextPresenter> b;

    public MessageAdapterModule_ProvideSystemTextBlueprint$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<SystemTextPresenter> provider) {
        this.a = messageAdapterModule;
        this.b = provider;
    }

    public static MessageAdapterModule_ProvideSystemTextBlueprint$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<SystemTextPresenter> provider) {
        return new MessageAdapterModule_ProvideSystemTextBlueprint$messenger_releaseFactory(messageAdapterModule, provider);
    }

    public static SystemTextBlueprint provideSystemTextBlueprint$messenger_release(MessageAdapterModule messageAdapterModule, SystemTextPresenter systemTextPresenter) {
        return (SystemTextBlueprint) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideSystemTextBlueprint$messenger_release(systemTextPresenter));
    }

    @Override // javax.inject.Provider
    public SystemTextBlueprint get() {
        return provideSystemTextBlueprint$messenger_release(this.a, this.b.get());
    }
}
