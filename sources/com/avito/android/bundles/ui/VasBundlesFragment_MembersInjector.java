package com.avito.android.bundles.ui;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.bundles.viewmodel.VasBundlesViewModel;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import java.util.Set;
import javax.inject.Provider;
public final class VasBundlesFragment_MembersInjector implements MembersInjector<VasBundlesFragment> {
    public final Provider<VasBundlesViewModel> a;
    public final Provider<ItemBinder> b;
    public final Provider<DataAwareAdapterPresenter> c;
    public final Provider<RecyclerView.Adapter<BaseViewHolder>> d;
    public final Provider<Set<ItemPresenter<?, ?>>> e;

    public VasBundlesFragment_MembersInjector(Provider<VasBundlesViewModel> provider, Provider<ItemBinder> provider2, Provider<DataAwareAdapterPresenter> provider3, Provider<RecyclerView.Adapter<BaseViewHolder>> provider4, Provider<Set<ItemPresenter<?, ?>>> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MembersInjector<VasBundlesFragment> create(Provider<VasBundlesViewModel> provider, Provider<ItemBinder> provider2, Provider<DataAwareAdapterPresenter> provider3, Provider<RecyclerView.Adapter<BaseViewHolder>> provider4, Provider<Set<ItemPresenter<?, ?>>> provider5) {
        return new VasBundlesFragment_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.avito.android.bundles.ui.VasBundlesFragment.adapterPresenter")
    public static void injectAdapterPresenter(VasBundlesFragment vasBundlesFragment, DataAwareAdapterPresenter dataAwareAdapterPresenter) {
        vasBundlesFragment.adapterPresenter = dataAwareAdapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.bundles.ui.VasBundlesFragment.itemBinder")
    public static void injectItemBinder(VasBundlesFragment vasBundlesFragment, ItemBinder itemBinder) {
        vasBundlesFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.bundles.ui.VasBundlesFragment.itemPresenterSet")
    public static void injectItemPresenterSet(VasBundlesFragment vasBundlesFragment, Set<ItemPresenter<?, ?>> set) {
        vasBundlesFragment.itemPresenterSet = set;
    }

    @InjectedFieldSignature("com.avito.android.bundles.ui.VasBundlesFragment.recyclerAdapter")
    public static void injectRecyclerAdapter(VasBundlesFragment vasBundlesFragment, RecyclerView.Adapter<BaseViewHolder> adapter) {
        vasBundlesFragment.recyclerAdapter = adapter;
    }

    @InjectedFieldSignature("com.avito.android.bundles.ui.VasBundlesFragment.viewModel")
    public static void injectViewModel(VasBundlesFragment vasBundlesFragment, VasBundlesViewModel vasBundlesViewModel) {
        vasBundlesFragment.viewModel = vasBundlesViewModel;
    }

    public void injectMembers(VasBundlesFragment vasBundlesFragment) {
        injectViewModel(vasBundlesFragment, this.a.get());
        injectItemBinder(vasBundlesFragment, this.b.get());
        injectAdapterPresenter(vasBundlesFragment, this.c.get());
        injectRecyclerAdapter(vasBundlesFragment, this.d.get());
        injectItemPresenterSet(vasBundlesFragment, this.e.get());
    }
}
