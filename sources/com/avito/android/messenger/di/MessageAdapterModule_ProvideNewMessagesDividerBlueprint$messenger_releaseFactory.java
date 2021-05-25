package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.new_messages_divider.NewMessagesDividerBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class MessageAdapterModule_ProvideNewMessagesDividerBlueprint$messenger_releaseFactory implements Factory<NewMessagesDividerBlueprint> {
    public final MessageAdapterModule a;

    public MessageAdapterModule_ProvideNewMessagesDividerBlueprint$messenger_releaseFactory(MessageAdapterModule messageAdapterModule) {
        this.a = messageAdapterModule;
    }

    public static MessageAdapterModule_ProvideNewMessagesDividerBlueprint$messenger_releaseFactory create(MessageAdapterModule messageAdapterModule) {
        return new MessageAdapterModule_ProvideNewMessagesDividerBlueprint$messenger_releaseFactory(messageAdapterModule);
    }

    public static NewMessagesDividerBlueprint provideNewMessagesDividerBlueprint$messenger_release(MessageAdapterModule messageAdapterModule) {
        return (NewMessagesDividerBlueprint) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideNewMessagesDividerBlueprint$messenger_release());
    }

    @Override // javax.inject.Provider
    public NewMessagesDividerBlueprint get() {
        return provideNewMessagesDividerBlueprint$messenger_release(this.a);
    }
}
