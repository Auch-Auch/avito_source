package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.platform.from_avito.item.PlatformItemMessageFromAvitoBlueprint;
import com.avito.android.messenger.conversation.adapter.platform.from_avito.item.PlatformItemMessageFromAvitoPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvidePlatformItemMessageFromAvitoBlueprint$messenger_releaseFactory implements Factory<PlatformItemMessageFromAvitoBlueprint> {
    public final MessageAdapterModule a;
    public final Provider<PlatformItemMessageFromAvitoPresenter> b;

    public MessageAdapterModule_ProvidePlatformItemMessageFromAvitoBlueprint$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<PlatformItemMessageFromAvitoPresenter> provider) {
        this.a = messageAdapterModule;
        this.b = provider;
    }

    public static MessageAdapterModule_ProvidePlatformItemMessageFromAvitoBlueprint$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<PlatformItemMessageFromAvitoPresenter> provider) {
        return new MessageAdapterModule_ProvidePlatformItemMessageFromAvitoBlueprint$messenger_releaseFactory(messageAdapterModule, provider);
    }

    public static PlatformItemMessageFromAvitoBlueprint providePlatformItemMessageFromAvitoBlueprint$messenger_release(MessageAdapterModule messageAdapterModule, PlatformItemMessageFromAvitoPresenter platformItemMessageFromAvitoPresenter) {
        return (PlatformItemMessageFromAvitoBlueprint) Preconditions.checkNotNullFromProvides(messageAdapterModule.providePlatformItemMessageFromAvitoBlueprint$messenger_release(platformItemMessageFromAvitoPresenter));
    }

    @Override // javax.inject.Provider
    public PlatformItemMessageFromAvitoBlueprint get() {
        return providePlatformItemMessageFromAvitoBlueprint$messenger_release(this.a, this.b.get());
    }
}
