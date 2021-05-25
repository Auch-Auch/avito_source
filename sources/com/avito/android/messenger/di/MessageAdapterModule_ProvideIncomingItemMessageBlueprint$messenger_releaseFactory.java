package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.item.IncomingItemMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.item.ItemMessagePresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvideIncomingItemMessageBlueprint$messenger_releaseFactory implements Factory<IncomingItemMessageBlueprint> {
    public final MessageAdapterModule a;
    public final Provider<ItemMessagePresenter> b;

    public MessageAdapterModule_ProvideIncomingItemMessageBlueprint$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<ItemMessagePresenter> provider) {
        this.a = messageAdapterModule;
        this.b = provider;
    }

    public static MessageAdapterModule_ProvideIncomingItemMessageBlueprint$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<ItemMessagePresenter> provider) {
        return new MessageAdapterModule_ProvideIncomingItemMessageBlueprint$messenger_releaseFactory(messageAdapterModule, provider);
    }

    public static IncomingItemMessageBlueprint provideIncomingItemMessageBlueprint$messenger_release(MessageAdapterModule messageAdapterModule, ItemMessagePresenter itemMessagePresenter) {
        return (IncomingItemMessageBlueprint) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideIncomingItemMessageBlueprint$messenger_release(itemMessagePresenter));
    }

    @Override // javax.inject.Provider
    public IncomingItemMessageBlueprint get() {
        return provideIncomingItemMessageBlueprint$messenger_release(this.a, this.b.get());
    }
}
