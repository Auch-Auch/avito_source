package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.platform.from_user.item.OutgoingPlatformItemMessageFromUserBlueprint;
import com.avito.android.messenger.conversation.adapter.platform.from_user.item.PlatformItemMessageFromUserPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvideOutgoingPlatformItemMessageFromUserBlueprint$messenger_releaseFactory implements Factory<OutgoingPlatformItemMessageFromUserBlueprint> {
    public final MessageAdapterModule a;
    public final Provider<PlatformItemMessageFromUserPresenter> b;

    public MessageAdapterModule_ProvideOutgoingPlatformItemMessageFromUserBlueprint$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<PlatformItemMessageFromUserPresenter> provider) {
        this.a = messageAdapterModule;
        this.b = provider;
    }

    public static MessageAdapterModule_ProvideOutgoingPlatformItemMessageFromUserBlueprint$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<PlatformItemMessageFromUserPresenter> provider) {
        return new MessageAdapterModule_ProvideOutgoingPlatformItemMessageFromUserBlueprint$messenger_releaseFactory(messageAdapterModule, provider);
    }

    public static OutgoingPlatformItemMessageFromUserBlueprint provideOutgoingPlatformItemMessageFromUserBlueprint$messenger_release(MessageAdapterModule messageAdapterModule, PlatformItemMessageFromUserPresenter platformItemMessageFromUserPresenter) {
        return (OutgoingPlatformItemMessageFromUserBlueprint) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideOutgoingPlatformItemMessageFromUserBlueprint$messenger_release(platformItemMessageFromUserPresenter));
    }

    @Override // javax.inject.Provider
    public OutgoingPlatformItemMessageFromUserBlueprint get() {
        return provideOutgoingPlatformItemMessageFromUserBlueprint$messenger_release(this.a, this.b.get());
    }
}
