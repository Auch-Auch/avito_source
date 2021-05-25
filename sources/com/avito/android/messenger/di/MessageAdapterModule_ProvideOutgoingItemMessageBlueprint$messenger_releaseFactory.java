package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.item.ItemMessagePresenter;
import com.avito.android.messenger.conversation.adapter.item.OutgoingItemMessageBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvideOutgoingItemMessageBlueprint$messenger_releaseFactory implements Factory<OutgoingItemMessageBlueprint> {
    public final MessageAdapterModule a;
    public final Provider<ItemMessagePresenter> b;

    public MessageAdapterModule_ProvideOutgoingItemMessageBlueprint$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<ItemMessagePresenter> provider) {
        this.a = messageAdapterModule;
        this.b = provider;
    }

    public static MessageAdapterModule_ProvideOutgoingItemMessageBlueprint$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<ItemMessagePresenter> provider) {
        return new MessageAdapterModule_ProvideOutgoingItemMessageBlueprint$messenger_releaseFactory(messageAdapterModule, provider);
    }

    public static OutgoingItemMessageBlueprint provideOutgoingItemMessageBlueprint$messenger_release(MessageAdapterModule messageAdapterModule, ItemMessagePresenter itemMessagePresenter) {
        return (OutgoingItemMessageBlueprint) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideOutgoingItemMessageBlueprint$messenger_release(itemMessagePresenter));
    }

    @Override // javax.inject.Provider
    public OutgoingItemMessageBlueprint get() {
        return provideOutgoingItemMessageBlueprint$messenger_release(this.a, this.b.get());
    }
}
