package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.platform.from_avito.image.PlatformImageMessageFromAvitoBlueprint;
import com.avito.android.messenger.conversation.adapter.platform.from_avito.image.PlatformImageMessageFromAvitoPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvidePlatformImageMessageFromAvitoBlueprint$messenger_releaseFactory implements Factory<PlatformImageMessageFromAvitoBlueprint> {
    public final MessageAdapterModule a;
    public final Provider<PlatformImageMessageFromAvitoPresenter> b;

    public MessageAdapterModule_ProvidePlatformImageMessageFromAvitoBlueprint$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<PlatformImageMessageFromAvitoPresenter> provider) {
        this.a = messageAdapterModule;
        this.b = provider;
    }

    public static MessageAdapterModule_ProvidePlatformImageMessageFromAvitoBlueprint$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<PlatformImageMessageFromAvitoPresenter> provider) {
        return new MessageAdapterModule_ProvidePlatformImageMessageFromAvitoBlueprint$messenger_releaseFactory(messageAdapterModule, provider);
    }

    public static PlatformImageMessageFromAvitoBlueprint providePlatformImageMessageFromAvitoBlueprint$messenger_release(MessageAdapterModule messageAdapterModule, PlatformImageMessageFromAvitoPresenter platformImageMessageFromAvitoPresenter) {
        return (PlatformImageMessageFromAvitoBlueprint) Preconditions.checkNotNullFromProvides(messageAdapterModule.providePlatformImageMessageFromAvitoBlueprint$messenger_release(platformImageMessageFromAvitoPresenter));
    }

    @Override // javax.inject.Provider
    public PlatformImageMessageFromAvitoBlueprint get() {
        return providePlatformImageMessageFromAvitoBlueprint$messenger_release(this.a, this.b.get());
    }
}
