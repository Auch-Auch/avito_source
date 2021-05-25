package com.avito.android.messenger.channels.mvi.presenter;

import com.avito.android.Features;
import com.avito.android.ab_tests.groups.MessengerFolderTabsTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.channels.analytics.ChannelsTracker;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsBannerInteractor;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsListInteractor;
import com.avito.android.messenger.channels.mvi.interactor.ChatListAdBannerInteractor;
import com.avito.android.messenger.channels.mvi.viewstate.ChannelsListState;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ChannelsListPresenterImpl_Factory implements Factory<ChannelsListPresenterImpl> {
    public final Provider<ChannelsListState> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<ChannelsListDataConverter> c;
    public final Provider<ChannelsListInteractor> d;
    public final Provider<ChannelsBannerInteractor> e;
    public final Provider<Formatter<Throwable>> f;
    public final Provider<Analytics> g;
    public final Provider<ChannelsTracker> h;
    public final Provider<ChatListAdBannerInteractor> i;
    public final Provider<ChannelListAdBannerItemFactory> j;
    public final Provider<Features> k;
    public final Provider<ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup>> l;

    public ChannelsListPresenterImpl_Factory(Provider<ChannelsListState> provider, Provider<SchedulersFactory> provider2, Provider<ChannelsListDataConverter> provider3, Provider<ChannelsListInteractor> provider4, Provider<ChannelsBannerInteractor> provider5, Provider<Formatter<Throwable>> provider6, Provider<Analytics> provider7, Provider<ChannelsTracker> provider8, Provider<ChatListAdBannerInteractor> provider9, Provider<ChannelListAdBannerItemFactory> provider10, Provider<Features> provider11, Provider<ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup>> provider12) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
        this.k = provider11;
        this.l = provider12;
    }

    public static ChannelsListPresenterImpl_Factory create(Provider<ChannelsListState> provider, Provider<SchedulersFactory> provider2, Provider<ChannelsListDataConverter> provider3, Provider<ChannelsListInteractor> provider4, Provider<ChannelsBannerInteractor> provider5, Provider<Formatter<Throwable>> provider6, Provider<Analytics> provider7, Provider<ChannelsTracker> provider8, Provider<ChatListAdBannerInteractor> provider9, Provider<ChannelListAdBannerItemFactory> provider10, Provider<Features> provider11, Provider<ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup>> provider12) {
        return new ChannelsListPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }

    public static ChannelsListPresenterImpl newInstance(ChannelsListState channelsListState, SchedulersFactory schedulersFactory, ChannelsListDataConverter channelsListDataConverter, ChannelsListInteractor channelsListInteractor, ChannelsBannerInteractor channelsBannerInteractor, Formatter<Throwable> formatter, Analytics analytics, ChannelsTracker channelsTracker, ChatListAdBannerInteractor chatListAdBannerInteractor, ChannelListAdBannerItemFactory channelListAdBannerItemFactory, Features features, ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup> manuallyExposedAbTestGroup) {
        return new ChannelsListPresenterImpl(channelsListState, schedulersFactory, channelsListDataConverter, channelsListInteractor, channelsBannerInteractor, formatter, analytics, channelsTracker, chatListAdBannerInteractor, channelListAdBannerItemFactory, features, manuallyExposedAbTestGroup);
    }

    @Override // javax.inject.Provider
    public ChannelsListPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get());
    }
}
