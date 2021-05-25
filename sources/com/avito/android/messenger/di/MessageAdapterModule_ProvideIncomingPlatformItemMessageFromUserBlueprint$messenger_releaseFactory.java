package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.platform.from_user.item.IncomingPlatformItemMessageFromUserBlueprint;
import com.avito.android.messenger.conversation.adapter.platform.from_user.item.PlatformItemMessageFromUserPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvideIncomingPlatformItemMessageFromUserBlueprint$messenger_releaseFactory implements Factory<IncomingPlatformItemMessageFromUserBlueprint> {
    public final MessageAdapterModule a;
    public final Provider<PlatformItemMessageFromUserPresenter> b;

    public MessageAdapterModule_ProvideIncomingPlatformItemMessageFromUserBlueprint$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<PlatformItemMessageFromUserPresenter> provider) {
        this.a = messageAdapterModule;
        this.b = provider;
    }

    public static MessageAdapterModule_ProvideIncomingPlatformItemMessageFromUserBlueprint$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<PlatformItemMessageFromUserPresenter> provider) {
        return new MessageAdapterModule_ProvideIncomingPlatformItemMessageFromUserBlueprint$messenger_releaseFactory(messageAdapterModule, provider);
    }

    public static IncomingPlatformItemMessageFromUserBlueprint provideIncomingPlatformItemMessageFromUserBlueprint$messenger_release(MessageAdapterModule messageAdapterModule, PlatformItemMessageFromUserPresenter platformItemMessageFromUserPresenter) {
        return (IncomingPlatformItemMessageFromUserBlueprint) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideIncomingPlatformItemMessageFromUserBlueprint$messenger_release(platformItemMessageFromUserPresenter));
    }

    @Override // javax.inject.Provider
    public IncomingPlatformItemMessageFromUserBlueprint get() {
        return provideIncomingPlatformItemMessageFromUserBlueprint$messenger_release(this.a, this.b.get());
    }
}
