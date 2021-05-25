package com.avito.android.messenger.channels.mvi.view;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.fps.FpsStateSupplier;
import com.avito.android.date_time_formatter.RelativeDateFormatter;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.messenger.channels.analytics.ChannelsTracker;
import com.avito.android.messenger.channels.mvi.presenter.ChannelsListPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class ChannelsListFragment_MembersInjector implements MembersInjector<ChannelsListFragment> {
    public final Provider<RelativeDateFormatter> a;
    public final Provider<Analytics> b;
    public final Provider<Features> c;
    public final Provider<ChannelsTracker> d;
    public final Provider<ChannelsListPresenter> e;
    public final Provider<ActivityIntentFactory> f;
    public final Provider<ItemVisibilityTracker> g;
    public final Provider<FpsStateSupplier> h;

    public ChannelsListFragment_MembersInjector(Provider<RelativeDateFormatter> provider, Provider<Analytics> provider2, Provider<Features> provider3, Provider<ChannelsTracker> provider4, Provider<ChannelsListPresenter> provider5, Provider<ActivityIntentFactory> provider6, Provider<ItemVisibilityTracker> provider7, Provider<FpsStateSupplier> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static MembersInjector<ChannelsListFragment> create(Provider<RelativeDateFormatter> provider, Provider<Analytics> provider2, Provider<Features> provider3, Provider<ChannelsTracker> provider4, Provider<ChannelsListPresenter> provider5, Provider<ActivityIntentFactory> provider6, Provider<ItemVisibilityTracker> provider7, Provider<FpsStateSupplier> provider8) {
        return new ChannelsListFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    @InjectedFieldSignature("com.avito.android.messenger.channels.mvi.view.ChannelsListFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(ChannelsListFragment channelsListFragment, ActivityIntentFactory activityIntentFactory) {
        channelsListFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.messenger.channels.mvi.view.ChannelsListFragment.analytics")
    public static void injectAnalytics(ChannelsListFragment channelsListFragment, Analytics analytics) {
        channelsListFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.messenger.channels.mvi.view.ChannelsListFragment.channelsListPresenter")
    public static void injectChannelsListPresenter(ChannelsListFragment channelsListFragment, ChannelsListPresenter channelsListPresenter) {
        channelsListFragment.channelsListPresenter = channelsListPresenter;
    }

    @InjectedFieldSignature("com.avito.android.messenger.channels.mvi.view.ChannelsListFragment.dateFormatter")
    public static void injectDateFormatter(ChannelsListFragment channelsListFragment, RelativeDateFormatter relativeDateFormatter) {
        channelsListFragment.dateFormatter = relativeDateFormatter;
    }

    @InjectedFieldSignature("com.avito.android.messenger.channels.mvi.view.ChannelsListFragment.features")
    public static void injectFeatures(ChannelsListFragment channelsListFragment, Features features) {
        channelsListFragment.features = features;
    }

    @InjectedFieldSignature("com.avito.android.messenger.channels.mvi.view.ChannelsListFragment.itemVisibilityTracker")
    public static void injectItemVisibilityTracker(ChannelsListFragment channelsListFragment, ItemVisibilityTracker itemVisibilityTracker) {
        channelsListFragment.itemVisibilityTracker = itemVisibilityTracker;
    }

    @InjectedFieldSignature("com.avito.android.messenger.channels.mvi.view.ChannelsListFragment.perfTracker")
    public static void injectPerfTracker(ChannelsListFragment channelsListFragment, ChannelsTracker channelsTracker) {
        channelsListFragment.perfTracker = channelsTracker;
    }

    @InjectedFieldSignature("com.avito.android.messenger.channels.mvi.view.ChannelsListFragment.supplier")
    public static void injectSupplier(ChannelsListFragment channelsListFragment, FpsStateSupplier fpsStateSupplier) {
        channelsListFragment.supplier = fpsStateSupplier;
    }

    public void injectMembers(ChannelsListFragment channelsListFragment) {
        injectDateFormatter(channelsListFragment, this.a.get());
        injectAnalytics(channelsListFragment, this.b.get());
        injectFeatures(channelsListFragment, this.c.get());
        injectPerfTracker(channelsListFragment, this.d.get());
        injectChannelsListPresenter(channelsListFragment, this.e.get());
        injectActivityIntentFactory(channelsListFragment, this.f.get());
        injectItemVisibilityTracker(channelsListFragment, this.g.get());
        injectSupplier(channelsListFragment, this.h.get());
    }
}
