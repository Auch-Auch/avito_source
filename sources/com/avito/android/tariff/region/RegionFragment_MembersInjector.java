package com.avito.android.tariff.region;

import com.avito.android.tariff.region.viewmodel.RegionViewModel;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import java.util.Set;
import javax.inject.Provider;
public final class RegionFragment_MembersInjector implements MembersInjector<RegionFragment> {
    public final Provider<ItemBinder> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<Set<ItemPresenter<?, ?>>> c;
    public final Provider<RegionViewModel> d;

    public RegionFragment_MembersInjector(Provider<ItemBinder> provider, Provider<AdapterPresenter> provider2, Provider<Set<ItemPresenter<?, ?>>> provider3, Provider<RegionViewModel> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<RegionFragment> create(Provider<ItemBinder> provider, Provider<AdapterPresenter> provider2, Provider<Set<ItemPresenter<?, ?>>> provider3, Provider<RegionViewModel> provider4) {
        return new RegionFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.tariff.region.RegionFragment.adapterPresenter")
    public static void injectAdapterPresenter(RegionFragment regionFragment, AdapterPresenter adapterPresenter) {
        regionFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.tariff.region.RegionFragment.itemBinder")
    public static void injectItemBinder(RegionFragment regionFragment, ItemBinder itemBinder) {
        regionFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.tariff.region.RegionFragment.itemPresenterSet")
    public static void injectItemPresenterSet(RegionFragment regionFragment, Set<ItemPresenter<?, ?>> set) {
        regionFragment.itemPresenterSet = set;
    }

    @InjectedFieldSignature("com.avito.android.tariff.region.RegionFragment.viewModel")
    public static void injectViewModel(RegionFragment regionFragment, RegionViewModel regionViewModel) {
        regionFragment.viewModel = regionViewModel;
    }

    public void injectMembers(RegionFragment regionFragment) {
        injectItemBinder(regionFragment, this.a.get());
        injectAdapterPresenter(regionFragment, this.b.get());
        injectItemPresenterSet(regionFragment, this.c.get());
        injectViewModel(regionFragment, this.d.get());
    }
}
