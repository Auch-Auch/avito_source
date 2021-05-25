package com.avito.android.messenger.search;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.util.BuildInfo;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class ChannelsSearchFragment_MembersInjector implements MembersInjector<ChannelsSearchFragment> {
    public final Provider<ActivityIntentFactory> a;
    public final Provider<ChannelsSearchPresenter> b;
    public final Provider<AdapterPresenter> c;
    public final Provider<ItemBinder> d;
    public final Provider<BuildInfo> e;

    public ChannelsSearchFragment_MembersInjector(Provider<ActivityIntentFactory> provider, Provider<ChannelsSearchPresenter> provider2, Provider<AdapterPresenter> provider3, Provider<ItemBinder> provider4, Provider<BuildInfo> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MembersInjector<ChannelsSearchFragment> create(Provider<ActivityIntentFactory> provider, Provider<ChannelsSearchPresenter> provider2, Provider<AdapterPresenter> provider3, Provider<ItemBinder> provider4, Provider<BuildInfo> provider5) {
        return new ChannelsSearchFragment_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.avito.android.messenger.search.ChannelsSearchFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(ChannelsSearchFragment channelsSearchFragment, ActivityIntentFactory activityIntentFactory) {
        channelsSearchFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.messenger.search.ChannelsSearchFragment.adapterPresenter")
    public static void injectAdapterPresenter(ChannelsSearchFragment channelsSearchFragment, AdapterPresenter adapterPresenter) {
        channelsSearchFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.messenger.search.ChannelsSearchFragment.buildInfo")
    public static void injectBuildInfo(ChannelsSearchFragment channelsSearchFragment, BuildInfo buildInfo) {
        channelsSearchFragment.buildInfo = buildInfo;
    }

    @InjectedFieldSignature("com.avito.android.messenger.search.ChannelsSearchFragment.itemBinder")
    public static void injectItemBinder(ChannelsSearchFragment channelsSearchFragment, ItemBinder itemBinder) {
        channelsSearchFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.messenger.search.ChannelsSearchFragment.searchPresenter")
    public static void injectSearchPresenter(ChannelsSearchFragment channelsSearchFragment, ChannelsSearchPresenter channelsSearchPresenter) {
        channelsSearchFragment.searchPresenter = channelsSearchPresenter;
    }

    public void injectMembers(ChannelsSearchFragment channelsSearchFragment) {
        injectActivityIntentFactory(channelsSearchFragment, this.a.get());
        injectSearchPresenter(channelsSearchFragment, this.b.get());
        injectAdapterPresenter(channelsSearchFragment, this.c.get());
        injectItemBinder(channelsSearchFragment, this.d.get());
        injectBuildInfo(channelsSearchFragment, this.e.get());
    }
}
