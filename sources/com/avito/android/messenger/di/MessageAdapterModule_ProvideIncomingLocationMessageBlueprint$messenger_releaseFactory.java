package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.location.IncomingLocationMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.location.LocationMessagePresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvideIncomingLocationMessageBlueprint$messenger_releaseFactory implements Factory<IncomingLocationMessageBlueprint> {
    public final MessageAdapterModule a;
    public final Provider<LocationMessagePresenter> b;

    public MessageAdapterModule_ProvideIncomingLocationMessageBlueprint$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<LocationMessagePresenter> provider) {
        this.a = messageAdapterModule;
        this.b = provider;
    }

    public static MessageAdapterModule_ProvideIncomingLocationMessageBlueprint$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<LocationMessagePresenter> provider) {
        return new MessageAdapterModule_ProvideIncomingLocationMessageBlueprint$messenger_releaseFactory(messageAdapterModule, provider);
    }

    public static IncomingLocationMessageBlueprint provideIncomingLocationMessageBlueprint$messenger_release(MessageAdapterModule messageAdapterModule, LocationMessagePresenter locationMessagePresenter) {
        return (IncomingLocationMessageBlueprint) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideIncomingLocationMessageBlueprint$messenger_release(locationMessagePresenter));
    }

    @Override // javax.inject.Provider
    public IncomingLocationMessageBlueprint get() {
        return provideIncomingLocationMessageBlueprint$messenger_release(this.a, this.b.get());
    }
}
