package com.avito.android.messenger.di;

import com.avito.android.Features;
import com.avito.android.messenger.conversation.adapter.IncomingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.OutgoingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.app_call.AppCallMessageClickListener;
import com.avito.android.messenger.conversation.adapter.app_call.AppCallMessagePresenter;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvideAppCallMessagePresenter$messenger_releaseFactory implements Factory<AppCallMessagePresenter> {
    public final MessageAdapterModule a;
    public final Provider<IncomingMessagePresenter> b;
    public final Provider<OutgoingMessagePresenter> c;
    public final Provider<AppCallMessageClickListener> d;
    public final Provider<Features> e;

    public MessageAdapterModule_ProvideAppCallMessagePresenter$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<IncomingMessagePresenter> provider, Provider<OutgoingMessagePresenter> provider2, Provider<AppCallMessageClickListener> provider3, Provider<Features> provider4) {
        this.a = messageAdapterModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
    }

    public static MessageAdapterModule_ProvideAppCallMessagePresenter$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<IncomingMessagePresenter> provider, Provider<OutgoingMessagePresenter> provider2, Provider<AppCallMessageClickListener> provider3, Provider<Features> provider4) {
        return new MessageAdapterModule_ProvideAppCallMessagePresenter$messenger_releaseFactory(messageAdapterModule, provider, provider2, provider3, provider4);
    }

    public static AppCallMessagePresenter provideAppCallMessagePresenter$messenger_release(MessageAdapterModule messageAdapterModule, IncomingMessagePresenter incomingMessagePresenter, OutgoingMessagePresenter outgoingMessagePresenter, Lazy<AppCallMessageClickListener> lazy, Features features) {
        return (AppCallMessagePresenter) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideAppCallMessagePresenter$messenger_release(incomingMessagePresenter, outgoingMessagePresenter, lazy, features));
    }

    @Override // javax.inject.Provider
    public AppCallMessagePresenter get() {
        return provideAppCallMessagePresenter$messenger_release(this.a, this.b.get(), this.c.get(), DoubleCheck.lazy(this.d), this.e.get());
    }
}
