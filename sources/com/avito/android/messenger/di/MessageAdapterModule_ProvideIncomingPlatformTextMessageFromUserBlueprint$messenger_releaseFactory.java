package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.platform.from_user.text.IncomingPlatformTextMessageFromUserBlueprint;
import com.avito.android.messenger.conversation.adapter.platform.from_user.text.PlatformTextMessageFromUserPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvideIncomingPlatformTextMessageFromUserBlueprint$messenger_releaseFactory implements Factory<IncomingPlatformTextMessageFromUserBlueprint> {
    public final MessageAdapterModule a;
    public final Provider<PlatformTextMessageFromUserPresenter> b;

    public MessageAdapterModule_ProvideIncomingPlatformTextMessageFromUserBlueprint$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<PlatformTextMessageFromUserPresenter> provider) {
        this.a = messageAdapterModule;
        this.b = provider;
    }

    public static MessageAdapterModule_ProvideIncomingPlatformTextMessageFromUserBlueprint$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<PlatformTextMessageFromUserPresenter> provider) {
        return new MessageAdapterModule_ProvideIncomingPlatformTextMessageFromUserBlueprint$messenger_releaseFactory(messageAdapterModule, provider);
    }

    public static IncomingPlatformTextMessageFromUserBlueprint provideIncomingPlatformTextMessageFromUserBlueprint$messenger_release(MessageAdapterModule messageAdapterModule, PlatformTextMessageFromUserPresenter platformTextMessageFromUserPresenter) {
        return (IncomingPlatformTextMessageFromUserBlueprint) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideIncomingPlatformTextMessageFromUserBlueprint$messenger_release(platformTextMessageFromUserPresenter));
    }

    @Override // javax.inject.Provider
    public IncomingPlatformTextMessageFromUserBlueprint get() {
        return provideIncomingPlatformTextMessageFromUserBlueprint$messenger_release(this.a, this.b.get());
    }
}
