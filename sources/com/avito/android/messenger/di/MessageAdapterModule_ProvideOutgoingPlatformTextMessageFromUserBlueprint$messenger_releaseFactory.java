package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.platform.from_user.text.OutgoingPlatformTextMessageFromUserBlueprint;
import com.avito.android.messenger.conversation.adapter.platform.from_user.text.PlatformTextMessageFromUserPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvideOutgoingPlatformTextMessageFromUserBlueprint$messenger_releaseFactory implements Factory<OutgoingPlatformTextMessageFromUserBlueprint> {
    public final MessageAdapterModule a;
    public final Provider<PlatformTextMessageFromUserPresenter> b;

    public MessageAdapterModule_ProvideOutgoingPlatformTextMessageFromUserBlueprint$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<PlatformTextMessageFromUserPresenter> provider) {
        this.a = messageAdapterModule;
        this.b = provider;
    }

    public static MessageAdapterModule_ProvideOutgoingPlatformTextMessageFromUserBlueprint$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<PlatformTextMessageFromUserPresenter> provider) {
        return new MessageAdapterModule_ProvideOutgoingPlatformTextMessageFromUserBlueprint$messenger_releaseFactory(messageAdapterModule, provider);
    }

    public static OutgoingPlatformTextMessageFromUserBlueprint provideOutgoingPlatformTextMessageFromUserBlueprint$messenger_release(MessageAdapterModule messageAdapterModule, PlatformTextMessageFromUserPresenter platformTextMessageFromUserPresenter) {
        return (OutgoingPlatformTextMessageFromUserBlueprint) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideOutgoingPlatformTextMessageFromUserBlueprint$messenger_release(platformTextMessageFromUserPresenter));
    }

    @Override // javax.inject.Provider
    public OutgoingPlatformTextMessageFromUserBlueprint get() {
        return provideOutgoingPlatformTextMessageFromUserBlueprint$messenger_release(this.a, this.b.get());
    }
}
