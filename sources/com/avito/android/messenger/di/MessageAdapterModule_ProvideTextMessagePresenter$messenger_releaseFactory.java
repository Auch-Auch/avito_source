package com.avito.android.messenger.di;

import com.avito.android.Features;
import com.avito.android.messenger.conversation.adapter.IncomingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.OutgoingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.text.MessageLinkClickListener;
import com.avito.android.messenger.conversation.adapter.text.TextMessagePresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvideTextMessagePresenter$messenger_releaseFactory implements Factory<TextMessagePresenter> {
    public final MessageAdapterModule a;
    public final Provider<IncomingMessagePresenter> b;
    public final Provider<OutgoingMessagePresenter> c;
    public final Provider<MessageLinkClickListener> d;
    public final Provider<Features> e;

    public MessageAdapterModule_ProvideTextMessagePresenter$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<IncomingMessagePresenter> provider, Provider<OutgoingMessagePresenter> provider2, Provider<MessageLinkClickListener> provider3, Provider<Features> provider4) {
        this.a = messageAdapterModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
    }

    public static MessageAdapterModule_ProvideTextMessagePresenter$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<IncomingMessagePresenter> provider, Provider<OutgoingMessagePresenter> provider2, Provider<MessageLinkClickListener> provider3, Provider<Features> provider4) {
        return new MessageAdapterModule_ProvideTextMessagePresenter$messenger_releaseFactory(messageAdapterModule, provider, provider2, provider3, provider4);
    }

    public static TextMessagePresenter provideTextMessagePresenter$messenger_release(MessageAdapterModule messageAdapterModule, IncomingMessagePresenter incomingMessagePresenter, OutgoingMessagePresenter outgoingMessagePresenter, MessageLinkClickListener messageLinkClickListener, Features features) {
        return (TextMessagePresenter) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideTextMessagePresenter$messenger_release(incomingMessagePresenter, outgoingMessagePresenter, messageLinkClickListener, features));
    }

    @Override // javax.inject.Provider
    public TextMessagePresenter get() {
        return provideTextMessagePresenter$messenger_release(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
