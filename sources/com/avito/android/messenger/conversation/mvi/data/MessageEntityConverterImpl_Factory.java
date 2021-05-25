package com.avito.android.messenger.conversation.mvi.data;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class MessageEntityConverterImpl_Factory implements Factory<MessageEntityConverterImpl> {
    public final Provider<MessageBodySerializer> a;

    public MessageEntityConverterImpl_Factory(Provider<MessageBodySerializer> provider) {
        this.a = provider;
    }

    public static MessageEntityConverterImpl_Factory create(Provider<MessageBodySerializer> provider) {
        return new MessageEntityConverterImpl_Factory(provider);
    }

    public static MessageEntityConverterImpl newInstance(MessageBodySerializer messageBodySerializer) {
        return new MessageEntityConverterImpl(messageBodySerializer);
    }

    @Override // javax.inject.Provider
    public MessageEntityConverterImpl get() {
        return newInstance(this.a.get());
    }
}
