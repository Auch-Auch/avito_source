package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.spam_actions.SpamActionsBlueprint;
import com.avito.android.messenger.conversation.adapter.spam_actions.SpamActionsPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvideSpamActionsBlueprint$messenger_releaseFactory implements Factory<SpamActionsBlueprint> {
    public final MessageAdapterModule a;
    public final Provider<SpamActionsPresenter> b;

    public MessageAdapterModule_ProvideSpamActionsBlueprint$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<SpamActionsPresenter> provider) {
        this.a = messageAdapterModule;
        this.b = provider;
    }

    public static MessageAdapterModule_ProvideSpamActionsBlueprint$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<SpamActionsPresenter> provider) {
        return new MessageAdapterModule_ProvideSpamActionsBlueprint$messenger_releaseFactory(messageAdapterModule, provider);
    }

    public static SpamActionsBlueprint provideSpamActionsBlueprint$messenger_release(MessageAdapterModule messageAdapterModule, SpamActionsPresenter spamActionsPresenter) {
        return (SpamActionsBlueprint) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideSpamActionsBlueprint$messenger_release(spamActionsPresenter));
    }

    @Override // javax.inject.Provider
    public SpamActionsBlueprint get() {
        return provideSpamActionsBlueprint$messenger_release(this.a, this.b.get());
    }
}
