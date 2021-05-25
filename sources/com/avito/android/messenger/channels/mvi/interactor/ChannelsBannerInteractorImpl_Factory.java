package com.avito.android.messenger.channels.mvi.interactor;

import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.channels.action_banner.ChannelsBannerShowTimeStorage;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsBannerInteractor;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ChannelsBannerInteractorImpl_Factory implements Factory<ChannelsBannerInteractorImpl> {
    public final Provider<ChannelsBannerInteractor.State> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<TimeSource> c;
    public final Provider<ChannelsBannerShowTimeStorage> d;
    public final Provider<NotificationManagerProvider> e;
    public final Provider<Analytics> f;
    public final Provider<Long> g;

    public ChannelsBannerInteractorImpl_Factory(Provider<ChannelsBannerInteractor.State> provider, Provider<SchedulersFactory> provider2, Provider<TimeSource> provider3, Provider<ChannelsBannerShowTimeStorage> provider4, Provider<NotificationManagerProvider> provider5, Provider<Analytics> provider6, Provider<Long> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static ChannelsBannerInteractorImpl_Factory create(Provider<ChannelsBannerInteractor.State> provider, Provider<SchedulersFactory> provider2, Provider<TimeSource> provider3, Provider<ChannelsBannerShowTimeStorage> provider4, Provider<NotificationManagerProvider> provider5, Provider<Analytics> provider6, Provider<Long> provider7) {
        return new ChannelsBannerInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static ChannelsBannerInteractorImpl newInstance(ChannelsBannerInteractor.State state, SchedulersFactory schedulersFactory, TimeSource timeSource, ChannelsBannerShowTimeStorage channelsBannerShowTimeStorage, NotificationManagerProvider notificationManagerProvider, Analytics analytics, long j) {
        return new ChannelsBannerInteractorImpl(state, schedulersFactory, timeSource, channelsBannerShowTimeStorage, notificationManagerProvider, analytics, j);
    }

    @Override // javax.inject.Provider
    public ChannelsBannerInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get().longValue());
    }
}
