package com.avito.android.bundles.vas_union;

import com.avito.android.bundles.vas_union.viewmodel.VasUnionViewModel;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import java.util.Set;
import javax.inject.Provider;
public final class VasUnionFragment_MembersInjector implements MembersInjector<VasUnionFragment> {
    public final Provider<VasUnionViewModel> a;
    public final Provider<ItemBinder> b;
    public final Provider<DeepLinkIntentFactory> c;
    public final Provider<AdapterPresenter> d;
    public final Provider<SimpleRecyclerAdapter> e;
    public final Provider<Set<ItemPresenter<?, ?>>> f;

    public VasUnionFragment_MembersInjector(Provider<VasUnionViewModel> provider, Provider<ItemBinder> provider2, Provider<DeepLinkIntentFactory> provider3, Provider<AdapterPresenter> provider4, Provider<SimpleRecyclerAdapter> provider5, Provider<Set<ItemPresenter<?, ?>>> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static MembersInjector<VasUnionFragment> create(Provider<VasUnionViewModel> provider, Provider<ItemBinder> provider2, Provider<DeepLinkIntentFactory> provider3, Provider<AdapterPresenter> provider4, Provider<SimpleRecyclerAdapter> provider5, Provider<Set<ItemPresenter<?, ?>>> provider6) {
        return new VasUnionFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.avito.android.bundles.vas_union.VasUnionFragment.adapterPresenter")
    public static void injectAdapterPresenter(VasUnionFragment vasUnionFragment, AdapterPresenter adapterPresenter) {
        vasUnionFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.bundles.vas_union.VasUnionFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(VasUnionFragment vasUnionFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        vasUnionFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.bundles.vas_union.VasUnionFragment.itemBinder")
    public static void injectItemBinder(VasUnionFragment vasUnionFragment, ItemBinder itemBinder) {
        vasUnionFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.bundles.vas_union.VasUnionFragment.itemPresenterSet")
    public static void injectItemPresenterSet(VasUnionFragment vasUnionFragment, Set<ItemPresenter<?, ?>> set) {
        vasUnionFragment.itemPresenterSet = set;
    }

    @InjectedFieldSignature("com.avito.android.bundles.vas_union.VasUnionFragment.recyclerAdapter")
    public static void injectRecyclerAdapter(VasUnionFragment vasUnionFragment, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        vasUnionFragment.recyclerAdapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.bundles.vas_union.VasUnionFragment.viewModel")
    public static void injectViewModel(VasUnionFragment vasUnionFragment, VasUnionViewModel vasUnionViewModel) {
        vasUnionFragment.viewModel = vasUnionViewModel;
    }

    public void injectMembers(VasUnionFragment vasUnionFragment) {
        injectViewModel(vasUnionFragment, this.a.get());
        injectItemBinder(vasUnionFragment, this.b.get());
        injectDeepLinkIntentFactory(vasUnionFragment, this.c.get());
        injectAdapterPresenter(vasUnionFragment, this.d.get());
        injectRecyclerAdapter(vasUnionFragment, this.e.get());
        injectItemPresenterSet(vasUnionFragment, this.f.get());
    }
}
