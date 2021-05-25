package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.platform.from_avito.text.PlatformTextMessageFromAvitoBlueprint;
import com.avito.android.messenger.conversation.adapter.platform.from_avito.text.PlatformTextMessageFromAvitoPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvidePlatformTextMessageFromAvitoBlueprint$messenger_releaseFactory implements Factory<PlatformTextMessageFromAvitoBlueprint> {
    public final MessageAdapterModule a;
    public final Provider<PlatformTextMessageFromAvitoPresenter> b;

    public MessageAdapterModule_ProvidePlatformTextMessageFromAvitoBlueprint$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<PlatformTextMessageFromAvitoPresenter> provider) {
        this.a = messageAdapterModule;
        this.b = provider;
    }

    public static MessageAdapterModule_ProvidePlatformTextMessageFromAvitoBlueprint$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<PlatformTextMessageFromAvitoPresenter> provider) {
        return new MessageAdapterModule_ProvidePlatformTextMessageFromAvitoBlueprint$messenger_releaseFactory(messageAdapterModule, provider);
    }

    public static PlatformTextMessageFromAvitoBlueprint providePlatformTextMessageFromAvitoBlueprint$messenger_release(MessageAdapterModule messageAdapterModule, PlatformTextMessageFromAvitoPresenter platformTextMessageFromAvitoPresenter) {
        return (PlatformTextMessageFromAvitoBlueprint) Preconditions.checkNotNullFromProvides(messageAdapterModule.providePlatformTextMessageFromAvitoBlueprint$messenger_release(platformTextMessageFromAvitoPresenter));
    }

    @Override // javax.inject.Provider
    public PlatformTextMessageFromAvitoBlueprint get() {
        return providePlatformTextMessageFromAvitoBlueprint$messenger_release(this.a, this.b.get());
    }
}
