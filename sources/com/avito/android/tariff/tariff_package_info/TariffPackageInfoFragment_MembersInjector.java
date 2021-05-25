package com.avito.android.tariff.tariff_package_info;

import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoViewModel;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import java.util.Set;
import javax.inject.Provider;
public final class TariffPackageInfoFragment_MembersInjector implements MembersInjector<TariffPackageInfoFragment> {
    public final Provider<TariffPackageInfoViewModel> a;
    public final Provider<ItemBinder> b;
    public final Provider<AdapterPresenter> c;
    public final Provider<SimpleRecyclerAdapter> d;
    public final Provider<AttributedTextFormatter> e;
    public final Provider<Set<ItemPresenter<?, ?>>> f;

    public TariffPackageInfoFragment_MembersInjector(Provider<TariffPackageInfoViewModel> provider, Provider<ItemBinder> provider2, Provider<AdapterPresenter> provider3, Provider<SimpleRecyclerAdapter> provider4, Provider<AttributedTextFormatter> provider5, Provider<Set<ItemPresenter<?, ?>>> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static MembersInjector<TariffPackageInfoFragment> create(Provider<TariffPackageInfoViewModel> provider, Provider<ItemBinder> provider2, Provider<AdapterPresenter> provider3, Provider<SimpleRecyclerAdapter> provider4, Provider<AttributedTextFormatter> provider5, Provider<Set<ItemPresenter<?, ?>>> provider6) {
        return new TariffPackageInfoFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.avito.android.tariff.tariff_package_info.TariffPackageInfoFragment.adapterPresenter")
    public static void injectAdapterPresenter(TariffPackageInfoFragment tariffPackageInfoFragment, AdapterPresenter adapterPresenter) {
        tariffPackageInfoFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.tariff.tariff_package_info.TariffPackageInfoFragment.attributedTextFormatter")
    public static void injectAttributedTextFormatter(TariffPackageInfoFragment tariffPackageInfoFragment, AttributedTextFormatter attributedTextFormatter) {
        tariffPackageInfoFragment.attributedTextFormatter = attributedTextFormatter;
    }

    @InjectedFieldSignature("com.avito.android.tariff.tariff_package_info.TariffPackageInfoFragment.itemBinder")
    public static void injectItemBinder(TariffPackageInfoFragment tariffPackageInfoFragment, ItemBinder itemBinder) {
        tariffPackageInfoFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.tariff.tariff_package_info.TariffPackageInfoFragment.itemPresenterSet")
    public static void injectItemPresenterSet(TariffPackageInfoFragment tariffPackageInfoFragment, Set<ItemPresenter<?, ?>> set) {
        tariffPackageInfoFragment.itemPresenterSet = set;
    }

    @InjectedFieldSignature("com.avito.android.tariff.tariff_package_info.TariffPackageInfoFragment.recyclerAdapter")
    public static void injectRecyclerAdapter(TariffPackageInfoFragment tariffPackageInfoFragment, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        tariffPackageInfoFragment.recyclerAdapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.tariff.tariff_package_info.TariffPackageInfoFragment.viewModel")
    public static void injectViewModel(TariffPackageInfoFragment tariffPackageInfoFragment, TariffPackageInfoViewModel tariffPackageInfoViewModel) {
        tariffPackageInfoFragment.viewModel = tariffPackageInfoViewModel;
    }

    public void injectMembers(TariffPackageInfoFragment tariffPackageInfoFragment) {
        injectViewModel(tariffPackageInfoFragment, this.a.get());
        injectItemBinder(tariffPackageInfoFragment, this.b.get());
        injectAdapterPresenter(tariffPackageInfoFragment, this.c.get());
        injectRecyclerAdapter(tariffPackageInfoFragment, this.d.get());
        injectAttributedTextFormatter(tariffPackageInfoFragment, this.e.get());
        injectItemPresenterSet(tariffPackageInfoFragment, this.f.get());
    }
}
