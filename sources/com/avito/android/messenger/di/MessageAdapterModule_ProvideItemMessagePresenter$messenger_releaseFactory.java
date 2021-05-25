package com.avito.android.messenger.di;

import android.content.Context;
import com.avito.android.messenger.conversation.adapter.IncomingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.OutgoingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.item.ItemMessagePresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvideItemMessagePresenter$messenger_releaseFactory implements Factory<ItemMessagePresenter> {
    public final MessageAdapterModule a;
    public final Provider<IncomingMessagePresenter> b;
    public final Provider<OutgoingMessagePresenter> c;
    public final Provider<Context> d;

    public MessageAdapterModule_ProvideItemMessagePresenter$messenger_releaseFactory(MessageAdapterModule messageAdapterModule, Provider<IncomingMessagePresenter> provider, Provider<OutgoingMessagePresenter> provider2, Provider<Context> provider3) {
        this.a = messageAdapterModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static MessageAdapterModule_ProvideItemMessagePresenter$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule, Provider<IncomingMessagePresenter> provider, Provider<OutgoingMessagePresenter> provider2, Provider<Context> provider3) {
        return new MessageAdapterModule_ProvideItemMessagePresenter$messenger_releaseFactory(messageAdapterModule, provider, provider2, provider3);
    }

    public static ItemMessagePresenter provideItemMessagePresenter$messenger_release(MessageAdapterModule messageAdapterModule, IncomingMessagePresenter incomingMessagePresenter, OutgoingMessagePresenter outgoingMessagePresenter, Context context) {
        return (ItemMessagePresenter) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideItemMessagePresenter$messenger_release(incomingMessagePresenter, outgoingMessagePresenter, context));
    }

    @Override // javax.inject.Provider
    public ItemMessagePresenter get() {
        return provideItemMessagePresenter$messenger_release(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
