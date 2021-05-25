package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.platform.from_avito.geo.PlatformGeoMessageFromAvitoBlueprint;
import com.avito.android.messenger.conversation.adapter.platform.from_avito.geo.PlatformGeoMessageFromAvitoPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvidePlatformGeoMessageFromAvitoBlueprint$messenger_releaseFactory implements Factory<PlatformGeoMessageFromAvitoBlueprint> {
    public final MessageAdapterModule a;
    public final Provider<PlatformGeoMessageFromAvitoPresenter> b;

    public MessageAdapterModule_ProvidePlatformGeoMessageFromAvitoBlueprint$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<PlatformGeoMessageFromAvitoPresenter> provider) {
        this.a = messageAdapterModule;
        this.b = provider;
    }

    public static MessageAdapterModule_ProvidePlatformGeoMessageFromAvitoBlueprint$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<PlatformGeoMessageFromAvitoPresenter> provider) {
        return new MessageAdapterModule_ProvidePlatformGeoMessageFromAvitoBlueprint$messenger_releaseFactory(messageAdapterModule, provider);
    }

    public static PlatformGeoMessageFromAvitoBlueprint providePlatformGeoMessageFromAvitoBlueprint$messenger_release(MessageAdapterModule messageAdapterModule, PlatformGeoMessageFromAvitoPresenter platformGeoMessageFromAvitoPresenter) {
        return (PlatformGeoMessageFromAvitoBlueprint) Preconditions.checkNotNullFromProvides(messageAdapterModule.providePlatformGeoMessageFromAvitoBlueprint$messenger_release(platformGeoMessageFromAvitoPresenter));
    }

    @Override // javax.inject.Provider
    public PlatformGeoMessageFromAvitoBlueprint get() {
        return providePlatformGeoMessageFromAvitoBlueprint$messenger_release(this.a, this.b.get());
    }
}
