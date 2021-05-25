package com.avito.android.messenger.service.direct_reply;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.NetworkTypeProvider;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class DirectReplyServiceInteractorImpl_Factory implements Factory<DirectReplyServiceInteractorImpl> {
    public final Provider<MessengerClient<AvitoMessengerApi>> a;
    public final Provider<TimeSource> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<Analytics> d;
    public final Provider<NetworkTypeProvider> e;

    public DirectReplyServiceInteractorImpl_Factory(Provider<MessengerClient<AvitoMessengerApi>> provider, Provider<TimeSource> provider2, Provider<SchedulersFactory> provider3, Provider<Analytics> provider4, Provider<NetworkTypeProvider> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static DirectReplyServiceInteractorImpl_Factory create(Provider<MessengerClient<AvitoMessengerApi>> provider, Provider<TimeSource> provider2, Provider<SchedulersFactory> provider3, Provider<Analytics> provider4, Provider<NetworkTypeProvider> provider5) {
        return new DirectReplyServiceInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static DirectReplyServiceInteractorImpl newInstance(MessengerClient<AvitoMessengerApi> messengerClient, TimeSource timeSource, SchedulersFactory schedulersFactory, Analytics analytics, NetworkTypeProvider networkTypeProvider) {
        return new DirectReplyServiceInteractorImpl(messengerClient, timeSource, schedulersFactory, analytics, networkTypeProvider);
    }

    @Override // javax.inject.Provider
    public DirectReplyServiceInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
