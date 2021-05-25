package com.avito.android.user_stats.tab;

import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.user_stats.tracker.UserStatsTabTracker;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import java.util.Set;
import javax.inject.Provider;
public final class UserStatsTabFragment_MembersInjector implements MembersInjector<UserStatsTabFragment> {
    public final Provider<UserStatsTabViewModel> a;
    public final Provider<SimpleRecyclerAdapter> b;
    public final Provider<AdapterPresenter> c;
    public final Provider<DeepLinkIntentFactory> d;
    public final Provider<Set<ItemPresenter<?, ?>>> e;
    public final Provider<UserStatsTabTracker> f;

    public UserStatsTabFragment_MembersInjector(Provider<UserStatsTabViewModel> provider, Provider<SimpleRecyclerAdapter> provider2, Provider<AdapterPresenter> provider3, Provider<DeepLinkIntentFactory> provider4, Provider<Set<ItemPresenter<?, ?>>> provider5, Provider<UserStatsTabTracker> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static MembersInjector<UserStatsTabFragment> create(Provider<UserStatsTabViewModel> provider, Provider<SimpleRecyclerAdapter> provider2, Provider<AdapterPresenter> provider3, Provider<DeepLinkIntentFactory> provider4, Provider<Set<ItemPresenter<?, ?>>> provider5, Provider<UserStatsTabTracker> provider6) {
        return new UserStatsTabFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.avito.android.user_stats.tab.UserStatsTabFragment.adapter")
    public static void injectAdapter(UserStatsTabFragment userStatsTabFragment, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        userStatsTabFragment.adapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.user_stats.tab.UserStatsTabFragment.adapterPresenter")
    public static void injectAdapterPresenter(UserStatsTabFragment userStatsTabFragment, AdapterPresenter adapterPresenter) {
        userStatsTabFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.user_stats.tab.UserStatsTabFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(UserStatsTabFragment userStatsTabFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        userStatsTabFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.user_stats.tab.UserStatsTabFragment.itemPresentersSet")
    public static void injectItemPresentersSet(UserStatsTabFragment userStatsTabFragment, Set<ItemPresenter<?, ?>> set) {
        userStatsTabFragment.itemPresentersSet = set;
    }

    @InjectedFieldSignature("com.avito.android.user_stats.tab.UserStatsTabFragment.userStatsTabTracker")
    public static void injectUserStatsTabTracker(UserStatsTabFragment userStatsTabFragment, UserStatsTabTracker userStatsTabTracker) {
        userStatsTabFragment.userStatsTabTracker = userStatsTabTracker;
    }

    @InjectedFieldSignature("com.avito.android.user_stats.tab.UserStatsTabFragment.viewModel")
    public static void injectViewModel(UserStatsTabFragment userStatsTabFragment, UserStatsTabViewModel userStatsTabViewModel) {
        userStatsTabFragment.viewModel = userStatsTabViewModel;
    }

    public void injectMembers(UserStatsTabFragment userStatsTabFragment) {
        injectViewModel(userStatsTabFragment, this.a.get());
        injectAdapter(userStatsTabFragment, this.b.get());
        injectAdapterPresenter(userStatsTabFragment, this.c.get());
        injectDeepLinkIntentFactory(userStatsTabFragment, this.d.get());
        injectItemPresentersSet(userStatsTabFragment, this.e.get());
        injectUserStatsTabTracker(userStatsTabFragment, this.f.get());
    }
}
