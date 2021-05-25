package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.location.LocationMessagePresenter;
import com.avito.android.messenger.conversation.adapter.location.OutgoingLocationMessageBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvideOutgoingLocationMessageBlueprint$messenger_releaseFactory implements Factory<OutgoingLocationMessageBlueprint> {
    public final MessageAdapterModule a;
    public final Provider<LocationMessagePresenter> b;

    public MessageAdapterModule_ProvideOutgoingLocationMessageBlueprint$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<LocationMessagePresenter> provider) {
        this.a = messageAdapterModule;
        this.b = provider;
    }

    public static MessageAdapterModule_ProvideOutgoingLocationMessageBlueprint$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<LocationMessagePresenter> provider) {
        return new MessageAdapterModule_ProvideOutgoingLocationMessageBlueprint$messenger_releaseFactory(messageAdapterModule, provider);
    }

    public static OutgoingLocationMessageBlueprint provideOutgoingLocationMessageBlueprint$messenger_release(MessageAdapterModule messageAdapterModule, LocationMessagePresenter locationMessagePresenter) {
        return (OutgoingLocationMessageBlueprint) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideOutgoingLocationMessageBlueprint$messenger_release(locationMessagePresenter));
    }

    @Override // javax.inject.Provider
    public OutgoingLocationMessageBlueprint get() {
        return provideOutgoingLocationMessageBlueprint$messenger_release(this.a, this.b.get());
    }
}
