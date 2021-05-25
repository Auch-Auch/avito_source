package com.avito.android.messenger.blacklist.mvi;

import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.blacklist.mvi.di.BlacklistFragmentModule;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class BlacklistFragment_MembersInjector implements MembersInjector<BlacklistFragment> {
    public final Provider<SchedulersFactory> a;
    public final Provider<Analytics> b;
    public final Provider<AdapterPresenter> c;
    public final Provider<ItemBinder> d;
    public final Provider<BlacklistPresenter> e;

    public BlacklistFragment_MembersInjector(Provider<SchedulersFactory> provider, Provider<Analytics> provider2, Provider<AdapterPresenter> provider3, Provider<ItemBinder> provider4, Provider<BlacklistPresenter> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MembersInjector<BlacklistFragment> create(Provider<SchedulersFactory> provider, Provider<Analytics> provider2, Provider<AdapterPresenter> provider3, Provider<ItemBinder> provider4, Provider<BlacklistPresenter> provider5) {
        return new BlacklistFragment_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @BlacklistFragmentModule.Blacklist
    @InjectedFieldSignature("com.avito.android.messenger.blacklist.mvi.BlacklistFragment.adapterPresenter")
    public static void injectAdapterPresenter(BlacklistFragment blacklistFragment, AdapterPresenter adapterPresenter) {
        blacklistFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.messenger.blacklist.mvi.BlacklistFragment.analytics")
    public static void injectAnalytics(BlacklistFragment blacklistFragment, Analytics analytics) {
        blacklistFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.messenger.blacklist.mvi.BlacklistFragment.blacklistPresenter")
    public static void injectBlacklistPresenter(BlacklistFragment blacklistFragment, BlacklistPresenter blacklistPresenter) {
        blacklistFragment.blacklistPresenter = blacklistPresenter;
    }

    @BlacklistFragmentModule.Blacklist
    @InjectedFieldSignature("com.avito.android.messenger.blacklist.mvi.BlacklistFragment.itemBinder")
    public static void injectItemBinder(BlacklistFragment blacklistFragment, ItemBinder itemBinder) {
        blacklistFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.messenger.blacklist.mvi.BlacklistFragment.schedulers")
    public static void injectSchedulers(BlacklistFragment blacklistFragment, SchedulersFactory schedulersFactory) {
        blacklistFragment.schedulers = schedulersFactory;
    }

    public void injectMembers(BlacklistFragment blacklistFragment) {
        injectSchedulers(blacklistFragment, this.a.get());
        injectAnalytics(blacklistFragment, this.b.get());
        injectAdapterPresenter(blacklistFragment, this.c.get());
        injectItemBinder(blacklistFragment, this.d.get());
        injectBlacklistPresenter(blacklistFragment, this.e.get());
    }
}
