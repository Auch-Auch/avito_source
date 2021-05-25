package com.avito.android.messenger.conversation.mvi.sync;

import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class IncompleteMessageBodyLoader_Factory implements Factory<IncompleteMessageBodyLoader> {
    public final Provider<MessageRepo> a;
    public final Provider<MessageBodyResolver> b;
    public final Provider<SchedulersFactory> c;

    public IncompleteMessageBodyLoader_Factory(Provider<MessageRepo> provider, Provider<MessageBodyResolver> provider2, Provider<SchedulersFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static IncompleteMessageBodyLoader_Factory create(Provider<MessageRepo> provider, Provider<MessageBodyResolver> provider2, Provider<SchedulersFactory> provider3) {
        return new IncompleteMessageBodyLoader_Factory(provider, provider2, provider3);
    }

    public static IncompleteMessageBodyLoader newInstance(MessageRepo messageRepo, MessageBodyResolver messageBodyResolver, SchedulersFactory schedulersFactory) {
        return new IncompleteMessageBodyLoader(messageRepo, messageBodyResolver, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public IncompleteMessageBodyLoader get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
