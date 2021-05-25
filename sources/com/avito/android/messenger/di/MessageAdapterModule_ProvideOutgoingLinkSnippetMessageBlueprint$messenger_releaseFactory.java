package com.avito.android.messenger.di;

import com.avito.android.Features;
import com.avito.android.messenger.conversation.adapter.link.LinkSnippetMessagePresenter;
import com.avito.android.messenger.conversation.adapter.link.OutgoingLinkSnippetMessageBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvideOutgoingLinkSnippetMessageBlueprint$messenger_releaseFactory implements Factory<OutgoingLinkSnippetMessageBlueprint> {
    public final MessageAdapterModule a;
    public final Provider<LinkSnippetMessagePresenter> b;
    public final Provider<Features> c;

    public MessageAdapterModule_ProvideOutgoingLinkSnippetMessageBlueprint$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<LinkSnippetMessagePresenter> provider, Provider<Features> provider2) {
        this.a = messageAdapterModule;
        this.b = provider;
        this.c = provider2;
    }

    public static MessageAdapterModule_ProvideOutgoingLinkSnippetMessageBlueprint$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<LinkSnippetMessagePresenter> provider, Provider<Features> provider2) {
        return new MessageAdapterModule_ProvideOutgoingLinkSnippetMessageBlueprint$messenger_releaseFactory(messageAdapterModule, provider, provider2);
    }

    public static OutgoingLinkSnippetMessageBlueprint provideOutgoingLinkSnippetMessageBlueprint$messenger_release(MessageAdapterModule messageAdapterModule, LinkSnippetMessagePresenter linkSnippetMessagePresenter, Features features) {
        return (OutgoingLinkSnippetMessageBlueprint) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideOutgoingLinkSnippetMessageBlueprint$messenger_release(linkSnippetMessagePresenter, features));
    }

    @Override // javax.inject.Provider
    public OutgoingLinkSnippetMessageBlueprint get() {
        return provideOutgoingLinkSnippetMessageBlueprint$messenger_release(this.a, this.b.get(), this.c.get());
    }
}
