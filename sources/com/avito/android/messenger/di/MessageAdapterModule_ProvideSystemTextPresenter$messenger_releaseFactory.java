package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.system.SystemTextPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class MessageAdapterModule_ProvideSystemTextPresenter$messenger_releaseFactory implements Factory<SystemTextPresenter> {
    public final MessageAdapterModule a;

    public MessageAdapterModule_ProvideSystemTextPresenter$messenger_releaseFactory(MessageAdapterModule messageAdapterModule) {
        this.a = messageAdapterModule;
    }

    public static MessageAdapterModule_ProvideSystemTextPresenter$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule) {
        return new MessageAdapterModule_ProvideSystemTextPresenter$messenger_releaseFactory(messageAdapterModule);
    }

    public static SystemTextPresenter provideSystemTextPresenter$messenger_release(MessageAdapterModule messageAdapterModule) {
        return (SystemTextPresenter) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideSystemTextPresenter$messenger_release());
    }

    @Override // javax.inject.Provider
    public SystemTextPresenter get() {
        return provideSystemTextPresenter$messenger_release(this.a);
    }
}
