package com.avito.android.messenger.di;

import com.avito.android.Features;
import com.avito.android.messenger.conversation.adapter.GoogleApiKey;
import com.avito.android.messenger.conversation.adapter.IncomingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.YandexApiKey;
import com.avito.android.messenger.conversation.adapter.platform.from_avito.geo.PlatformGeoMessageFromAvitoPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvidePlatformGeoMessageFromAvitoPresenter$messenger_releaseFactory implements Factory<PlatformGeoMessageFromAvitoPresenter> {
    public final MessageAdapterModule a;
    public final Provider<IncomingMessagePresenter> b;
    public final Provider<GoogleApiKey> c;
    public final Provider<YandexApiKey> d;
    public final Provider<Features> e;

    public MessageAdapterModule_ProvidePlatformGeoMessageFromAvitoPresenter$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<IncomingMessagePresenter> provider, Provider<GoogleApiKey> provider2, Provider<YandexApiKey> provider3, Provider<Features> provider4) {
        this.a = messageAdapterModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
    }

    public static MessageAdapterModule_ProvidePlatformGeoMessageFromAvitoPresenter$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<IncomingMessagePresenter> provider, Provider<GoogleApiKey> provider2, Provider<YandexApiKey> provider3, Provider<Features> provider4) {
        return new MessageAdapterModule_ProvidePlatformGeoMessageFromAvitoPresenter$messenger_releaseFactory(messageAdapterModule, provider, provider2, provider3, provider4);
    }

    public static PlatformGeoMessageFromAvitoPresenter providePlatformGeoMessageFromAvitoPresenter$messenger_release(MessageAdapterModule messageAdapterModule, IncomingMessagePresenter incomingMessagePresenter, GoogleApiKey googleApiKey, YandexApiKey yandexApiKey, Features features) {
        return (PlatformGeoMessageFromAvitoPresenter) Preconditions.checkNotNullFromProvides(messageAdapterModule.providePlatformGeoMessageFromAvitoPresenter$messenger_release(incomingMessagePresenter, googleApiKey, yandexApiKey, features));
    }

    @Override // javax.inject.Provider
    public PlatformGeoMessageFromAvitoPresenter get() {
        return providePlatformGeoMessageFromAvitoPresenter$messenger_release(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
