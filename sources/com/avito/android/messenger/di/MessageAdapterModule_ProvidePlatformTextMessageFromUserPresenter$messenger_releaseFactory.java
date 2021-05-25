package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.IncomingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.OutgoingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.platform.from_user.text.PlatformTextMessageFromUserPresenter;
import com.avito.android.messenger.conversation.adapter.text.MessageLinkClickListener;
import com.avito.android.messenger.conversation.mvi.deeplinks.DeeplinkProcessor;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvidePlatformTextMessageFromUserPresenter$messenger_releaseFactory implements Factory<PlatformTextMessageFromUserPresenter> {
    public final MessageAdapterModule a;
    public final Provider<IncomingMessagePresenter> b;
    public final Provider<OutgoingMessagePresenter> c;
    public final Provider<DeeplinkProcessor> d;
    public final Provider<MessageLinkClickListener> e;
    public final Provider<AttributedTextFormatter> f;

    public MessageAdapterModule_ProvidePlatformTextMessageFromUserPresenter$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<IncomingMessagePresenter> provider, Provider<OutgoingMessagePresenter> provider2, Provider<DeeplinkProcessor> provider3, Provider<MessageLinkClickListener> provider4, Provider<AttributedTextFormatter> provider5) {
        this.a = messageAdapterModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
    }

    public static MessageAdapterModule_ProvidePlatformTextMessageFromUserPresenter$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<IncomingMessagePresenter> provider, Provider<OutgoingMessagePresenter> provider2, Provider<DeeplinkProcessor> provider3, Provider<MessageLinkClickListener> provider4, Provider<AttributedTextFormatter> provider5) {
        return new MessageAdapterModule_ProvidePlatformTextMessageFromUserPresenter$messenger_releaseFactory(messageAdapterModule, provider, provider2, provider3, provider4, provider5);
    }

    public static PlatformTextMessageFromUserPresenter providePlatformTextMessageFromUserPresenter$messenger_release(MessageAdapterModule messageAdapterModule, IncomingMessagePresenter incomingMessagePresenter, OutgoingMessagePresenter outgoingMessagePresenter, Lazy<DeeplinkProcessor> lazy, MessageLinkClickListener messageLinkClickListener, AttributedTextFormatter attributedTextFormatter) {
        return (PlatformTextMessageFromUserPresenter) Preconditions.checkNotNullFromProvides(messageAdapterModule.providePlatformTextMessageFromUserPresenter$messenger_release(incomingMessagePresenter, outgoingMessagePresenter, lazy, messageLinkClickListener, attributedTextFormatter));
    }

    @Override // javax.inject.Provider
    public PlatformTextMessageFromUserPresenter get() {
        return providePlatformTextMessageFromUserPresenter$messenger_release(this.a, this.b.get(), this.c.get(), DoubleCheck.lazy(this.d), this.e.get(), this.f.get());
    }
}
