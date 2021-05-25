package com.avito.android.messenger.di;

import com.avito.android.Features;
import com.avito.android.messenger.conversation.adapter.link.IncomingLinkSnippetMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.link.LinkSnippetMessagePresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvideIncomingLinkSnippetMessageBlueprint$messenger_releaseFactory implements Factory<IncomingLinkSnippetMessageBlueprint> {
    public final MessageAdapterModule a;
    public final Provider<LinkSnippetMessagePresenter> b;
    public final Provider<Features> c;

    public MessageAdapterModule_ProvideIncomingLinkSnippetMessageBlueprint$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<LinkSnippetMessagePresenter> provider, Provider<Features> provider2) {
        this.a = messageAdapterModule;
        this.b = provider;
        this.c = provider2;
    }

    public static MessageAdapterModule_ProvideIncomingLinkSnippetMessageBlueprint$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<LinkSnippetMessagePresenter> provider, Provider<Features> provider2) {
        return new MessageAdapterModule_ProvideIncomingLinkSnippetMessageBlueprint$messenger_releaseFactory(messageAdapterModule, provider, provider2);
    }

    public static IncomingLinkSnippetMessageBlueprint provideIncomingLinkSnippetMessageBlueprint$messenger_release(MessageAdapterModule messageAdapterModule, LinkSnippetMessagePresenter linkSnippetMessagePresenter, Features features) {
        return (IncomingLinkSnippetMessageBlueprint) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideIncomingLinkSnippetMessageBlueprint$messenger_release(linkSnippetMessagePresenter, features));
    }

    @Override // javax.inject.Provider
    public IncomingLinkSnippetMessageBlueprint get() {
        return provideIncomingLinkSnippetMessageBlueprint$messenger_release(this.a, this.b.get(), this.c.get());
    }
}
