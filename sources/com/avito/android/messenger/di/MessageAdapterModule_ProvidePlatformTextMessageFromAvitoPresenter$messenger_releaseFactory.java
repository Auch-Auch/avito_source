package com.avito.android.messenger.di;

import android.view.ActionMode;
import com.avito.android.messenger.conversation.adapter.IncomingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.platform.from_avito.text.PlatformTextMessageFromAvitoPresenter;
import com.avito.android.messenger.conversation.mvi.deeplinks.DeeplinkProcessor;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvidePlatformTextMessageFromAvitoPresenter$messenger_releaseFactory implements Factory<PlatformTextMessageFromAvitoPresenter> {
    public final MessageAdapterModule a;
    public final Provider<IncomingMessagePresenter> b;
    public final Provider<DeeplinkProcessor> c;
    public final Provider<AttributedTextFormatter> d;
    public final Provider<ActionMode.Callback> e;

    public MessageAdapterModule_ProvidePlatformTextMessageFromAvitoPresenter$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<IncomingMessagePresenter> provider, Provider<DeeplinkProcessor> provider2, Provider<AttributedTextFormatter> provider3, Provider<ActionMode.Callback> provider4) {
        this.a = messageAdapterModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
    }

    public static MessageAdapterModule_ProvidePlatformTextMessageFromAvitoPresenter$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<IncomingMessagePresenter> provider, Provider<DeeplinkProcessor> provider2, Provider<AttributedTextFormatter> provider3, Provider<ActionMode.Callback> provider4) {
        return new MessageAdapterModule_ProvidePlatformTextMessageFromAvitoPresenter$messenger_releaseFactory(messageAdapterModule, provider, provider2, provider3, provider4);
    }

    public static PlatformTextMessageFromAvitoPresenter providePlatformTextMessageFromAvitoPresenter$messenger_release(MessageAdapterModule messageAdapterModule, IncomingMessagePresenter incomingMessagePresenter, Lazy<DeeplinkProcessor> lazy, AttributedTextFormatter attributedTextFormatter, Lazy<ActionMode.Callback> lazy2) {
        return (PlatformTextMessageFromAvitoPresenter) Preconditions.checkNotNullFromProvides(messageAdapterModule.providePlatformTextMessageFromAvitoPresenter$messenger_release(incomingMessagePresenter, lazy, attributedTextFormatter, lazy2));
    }

    @Override // javax.inject.Provider
    public PlatformTextMessageFromAvitoPresenter get() {
        return providePlatformTextMessageFromAvitoPresenter$messenger_release(this.a, this.b.get(), DoubleCheck.lazy(this.c), this.d.get(), DoubleCheck.lazy(this.e));
    }
}
