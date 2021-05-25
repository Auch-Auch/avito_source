package com.avito.android.messenger.channels.mvi.interactor;

import com.avito.android.Features;
import com.avito.android.ab_tests.groups.MessengerFolderTabsTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.timer.AnalyticsTimer;
import com.avito.android.messenger.analytics.graphite_counter.ChatListLoadingResult;
import com.avito.android.messenger.analytics.graphite_counter.ChatListRefreshResult;
import com.avito.android.messenger.analytics.graphite_counter.MessengerGraphiteCounter;
import com.avito.android.messenger.channels.analytics.ChannelsTracker;
import com.avito.android.messenger.channels.mvi.data.ChannelRepoReader;
import com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent;
import com.avito.android.messenger.service.OpenErrorTrackerScheduler;
import com.avito.android.messenger.service.user_last_activity.UserLastActivitySyncAgent;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import java.util.SortedSet;
import javax.inject.Provider;
import kotlin.Pair;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class ChannelsListInteractorImpl_Factory implements Factory<ChannelsListInteractorImpl> {
    public final Provider<SchedulersFactory> a;
    public final Provider<Features> b;
    public final Provider<AccountStateProvider> c;
    public final Provider<MessengerClient<AvitoMessengerApi>> d;
    public final Provider<ChannelSyncAgent> e;
    public final Provider<ChannelRepoReader> f;
    public final Provider<UserLastActivitySyncAgent> g;
    public final Provider<AnalyticsTimer<ChatListLoadingResult>> h;
    public final Provider<AnalyticsTimer<ChatListRefreshResult>> i;
    public final Provider<MessengerGraphiteCounter> j;
    public final Provider<ChannelsTracker> k;
    public final Provider<Analytics> l;
    public final Provider<OpenErrorTrackerScheduler> m;
    public final Provider<ChannelsErrorInteractor> n;
    public final Provider<Pair<? extends SortedSet<String>, ? extends SortedSet<String>>> o;
    public final Provider<Pair<? extends SortedSet<String>, ? extends SortedSet<String>>> p;
    public final Provider<Pair<? extends SortedSet<String>, ? extends SortedSet<String>>> q;
    public final Provider<ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup>> r;

    public ChannelsListInteractorImpl_Factory(Provider<SchedulersFactory> provider, Provider<Features> provider2, Provider<AccountStateProvider> provider3, Provider<MessengerClient<AvitoMessengerApi>> provider4, Provider<ChannelSyncAgent> provider5, Provider<ChannelRepoReader> provider6, Provider<UserLastActivitySyncAgent> provider7, Provider<AnalyticsTimer<ChatListLoadingResult>> provider8, Provider<AnalyticsTimer<ChatListRefreshResult>> provider9, Provider<MessengerGraphiteCounter> provider10, Provider<ChannelsTracker> provider11, Provider<Analytics> provider12, Provider<OpenErrorTrackerScheduler> provider13, Provider<ChannelsErrorInteractor> provider14, Provider<Pair<? extends SortedSet<String>, ? extends SortedSet<String>>> provider15, Provider<Pair<? extends SortedSet<String>, ? extends SortedSet<String>>> provider16, Provider<Pair<? extends SortedSet<String>, ? extends SortedSet<String>>> provider17, Provider<ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup>> provider18) {
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
        this.m = provider13;
        this.n = provider14;
        this.o = provider15;
        this.p = provider16;
        this.q = provider17;
        this.r = provider18;
    }

    public static ChannelsListInteractorImpl_Factory create(Provider<SchedulersFactory> provider, Provider<Features> provider2, Provider<AccountStateProvider> provider3, Provider<MessengerClient<AvitoMessengerApi>> provider4, Provider<ChannelSyncAgent> provider5, Provider<ChannelRepoReader> provider6, Provider<UserLastActivitySyncAgent> provider7, Provider<AnalyticsTimer<ChatListLoadingResult>> provider8, Provider<AnalyticsTimer<ChatListRefreshResult>> provider9, Provider<MessengerGraphiteCounter> provider10, Provider<ChannelsTracker> provider11, Provider<Analytics> provider12, Provider<OpenErrorTrackerScheduler> provider13, Provider<ChannelsErrorInteractor> provider14, Provider<Pair<? extends SortedSet<String>, ? extends SortedSet<String>>> provider15, Provider<Pair<? extends SortedSet<String>, ? extends SortedSet<String>>> provider16, Provider<Pair<? extends SortedSet<String>, ? extends SortedSet<String>>> provider17, Provider<ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup>> provider18) {
        return new ChannelsListInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18);
    }

    public static ChannelsListInteractorImpl newInstance(SchedulersFactory schedulersFactory, Features features, AccountStateProvider accountStateProvider, MessengerClient<AvitoMessengerApi> messengerClient, ChannelSyncAgent channelSyncAgent, ChannelRepoReader channelRepoReader, UserLastActivitySyncAgent userLastActivitySyncAgent, AnalyticsTimer<ChatListLoadingResult> analyticsTimer, AnalyticsTimer<ChatListRefreshResult> analyticsTimer2, MessengerGraphiteCounter messengerGraphiteCounter, ChannelsTracker channelsTracker, Analytics analytics, OpenErrorTrackerScheduler openErrorTrackerScheduler, ChannelsErrorInteractor channelsErrorInteractor, Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair, Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair2, Pair<? extends SortedSet<String>, ? extends SortedSet<String>> pair3, ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup> manuallyExposedAbTestGroup) {
        return new ChannelsListInteractorImpl(schedulersFactory, features, accountStateProvider, messengerClient, channelSyncAgent, channelRepoReader, userLastActivitySyncAgent, analyticsTimer, analyticsTimer2, messengerGraphiteCounter, channelsTracker, analytics, openErrorTrackerScheduler, channelsErrorInteractor, pair, pair2, pair3, manuallyExposedAbTestGroup);
    }

    @Override // javax.inject.Provider
    public ChannelsListInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get(), this.n.get(), this.o.get(), this.p.get(), this.q.get(), this.r.get());
    }
}
