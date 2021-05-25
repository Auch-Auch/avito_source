package com.avito.android.messenger.di;

import com.avito.android.Features;
import com.avito.android.messenger.conversation.adapter.GoogleApiKey;
import com.avito.android.messenger.conversation.adapter.IncomingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.OutgoingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.YandexApiKey;
import com.avito.android.messenger.conversation.adapter.location.LocationMessagePresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvideLocationMessagePresenter$messenger_releaseFactory implements Factory<LocationMessagePresenter> {
    public final MessageAdapterModule a;
    public final Provider<IncomingMessagePresenter> b;
    public final Provider<OutgoingMessagePresenter> c;
    public final Provider<GoogleApiKey> d;
    public final Provider<YandexApiKey> e;
    public final Provider<Features> f;

    public MessageAdapterModule_ProvideLocationMessagePresenter$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<IncomingMessagePresenter> provider, Provider<OutgoingMessagePresenter> provider2, Provider<GoogleApiKey> provider3, Provider<YandexApiKey> provider4, Provider<Features> provider5) {
        this.a = messageAdapterModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
    }

    public static MessageAdapterModule_ProvideLocationMessagePresenter$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<IncomingMessagePresenter> provider, Provider<OutgoingMessagePresenter> provider2, Provider<GoogleApiKey> provider3, Provider<YandexApiKey> provider4, Provider<Features> provider5) {
        return new MessageAdapterModule_ProvideLocationMessagePresenter$messenger_releaseFactory(messageAdapterModule, provider, provider2, provider3, provider4, provider5);
    }

    public static LocationMessagePresenter provideLocationMessagePresenter$messenger_release(MessageAdapterModule messageAdapterModule, IncomingMessagePresenter incomingMessagePresenter, OutgoingMessagePresenter outgoingMessagePresenter, GoogleApiKey googleApiKey, YandexApiKey yandexApiKey, Features features) {
        return (LocationMessagePresenter) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideLocationMessagePresenter$messenger_release(incomingMessagePresenter, outgoingMessagePresenter, googleApiKey, yandexApiKey, features));
    }

    @Override // javax.inject.Provider
    public LocationMessagePresenter get() {
        return provideLocationMessagePresenter$messenger_release(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
