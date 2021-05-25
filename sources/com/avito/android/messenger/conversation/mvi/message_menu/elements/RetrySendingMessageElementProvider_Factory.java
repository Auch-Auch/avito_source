package com.avito.android.messenger.conversation.mvi.message_menu.elements;

import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.RetrySendingMessageElementProvider;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class RetrySendingMessageElementProvider_Factory implements Factory<RetrySendingMessageElementProvider> {
    public final Provider<MessageRepo> a;
    public final Provider<TimeSource> b;
    public final Provider<Analytics> c;
    public final Provider<SchedulersFactory> d;
    public final Provider<RetrySendingMessageElementProvider.Callback> e;

    public RetrySendingMessageElementProvider_Factory(Provider<MessageRepo> provider, Provider<TimeSource> provider2, Provider<Analytics> provider3, Provider<SchedulersFactory> provider4, Provider<RetrySendingMessageElementProvider.Callback> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static RetrySendingMessageElementProvider_Factory create(Provider<MessageRepo> provider, Provider<TimeSource> provider2, Provider<Analytics> provider3, Provider<SchedulersFactory> provider4, Provider<RetrySendingMessageElementProvider.Callback> provider5) {
        return new RetrySendingMessageElementProvider_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static RetrySendingMessageElementProvider newInstance(MessageRepo messageRepo, TimeSource timeSource, Analytics analytics, SchedulersFactory schedulersFactory, RetrySendingMessageElementProvider.Callback callback) {
        return new RetrySendingMessageElementProvider(messageRepo, timeSource, analytics, schedulersFactory, callback);
    }

    @Override // javax.inject.Provider
    public RetrySendingMessageElementProvider get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
