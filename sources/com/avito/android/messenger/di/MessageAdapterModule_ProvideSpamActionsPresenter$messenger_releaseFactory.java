package com.avito.android.messenger.di;

import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.conversation.adapter.spam_actions.SpamActionsPresenter;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvideSpamActionsPresenter$messenger_releaseFactory implements Factory<SpamActionsPresenter> {
    public final MessageAdapterModule a;
    public final Provider<SpamActionsPresenter.Listener> b;
    public final Provider<Analytics> c;

    public MessageAdapterModule_ProvideSpamActionsPresenter$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<SpamActionsPresenter.Listener> provider, Provider<Analytics> provider2) {
        this.a = messageAdapterModule;
        this.b = provider;
        this.c = provider2;
    }

    public static MessageAdapterModule_ProvideSpamActionsPresenter$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<SpamActionsPresenter.Listener> provider, Provider<Analytics> provider2) {
        return new MessageAdapterModule_ProvideSpamActionsPresenter$messenger_releaseFactory(messageAdapterModule, provider, provider2);
    }

    public static SpamActionsPresenter provideSpamActionsPresenter$messenger_release(MessageAdapterModule messageAdapterModule, Lazy<SpamActionsPresenter.Listener> lazy, Analytics analytics) {
        return (SpamActionsPresenter) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideSpamActionsPresenter$messenger_release(lazy, analytics));
    }

    @Override // javax.inject.Provider
    public SpamActionsPresenter get() {
        return provideSpamActionsPresenter$messenger_release(this.a, DoubleCheck.lazy(this.b), this.c.get());
    }
}
