package com.avito.android.verification.verifications_list;

import com.avito.android.analytics.Analytics;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import java.util.Set;
import javax.inject.Provider;
public final class VerificationsListFragment_MembersInjector implements MembersInjector<VerificationsListFragment> {
    public final Provider<Analytics> a;
    public final Provider<SimpleRecyclerAdapter> b;
    public final Provider<AdapterPresenter> c;
    public final Provider<VerificationsListViewModel> d;
    public final Provider<Set<ItemPresenter<?, ?>>> e;

    public VerificationsListFragment_MembersInjector(Provider<Analytics> provider, Provider<SimpleRecyclerAdapter> provider2, Provider<AdapterPresenter> provider3, Provider<VerificationsListViewModel> provider4, Provider<Set<ItemPresenter<?, ?>>> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MembersInjector<VerificationsListFragment> create(Provider<Analytics> provider, Provider<SimpleRecyclerAdapter> provider2, Provider<AdapterPresenter> provider3, Provider<VerificationsListViewModel> provider4, Provider<Set<ItemPresenter<?, ?>>> provider5) {
        return new VerificationsListFragment_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.avito.android.verification.verifications_list.VerificationsListFragment.adapter")
    public static void injectAdapter(VerificationsListFragment verificationsListFragment, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        verificationsListFragment.adapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.verification.verifications_list.VerificationsListFragment.adapterPresenter")
    public static void injectAdapterPresenter(VerificationsListFragment verificationsListFragment, AdapterPresenter adapterPresenter) {
        verificationsListFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.verification.verifications_list.VerificationsListFragment.analytics")
    public static void injectAnalytics(VerificationsListFragment verificationsListFragment, Analytics analytics) {
        verificationsListFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.verification.verifications_list.VerificationsListFragment.itemPresentersSet")
    public static void injectItemPresentersSet(VerificationsListFragment verificationsListFragment, Set<ItemPresenter<?, ?>> set) {
        verificationsListFragment.itemPresentersSet = set;
    }

    @InjectedFieldSignature("com.avito.android.verification.verifications_list.VerificationsListFragment.viewModel")
    public static void injectViewModel(VerificationsListFragment verificationsListFragment, VerificationsListViewModel verificationsListViewModel) {
        verificationsListFragment.viewModel = verificationsListViewModel;
    }

    public void injectMembers(VerificationsListFragment verificationsListFragment) {
        injectAnalytics(verificationsListFragment, this.a.get());
        injectAdapter(verificationsListFragment, this.b.get());
        injectAdapterPresenter(verificationsListFragment, this.c.get());
        injectViewModel(verificationsListFragment, this.d.get());
        injectItemPresentersSet(verificationsListFragment, this.e.get());
    }
}
