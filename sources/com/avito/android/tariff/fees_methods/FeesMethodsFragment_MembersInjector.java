package com.avito.android.tariff.fees_methods;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.tariff.fees_methods.viewmodel.FeeMethodsViewModel;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import java.util.Set;
import javax.inject.Provider;
public final class FeesMethodsFragment_MembersInjector implements MembersInjector<FeesMethodsFragment> {
    public final Provider<ItemBinder> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<Set<ItemPresenter<?, ?>>> c;
    public final Provider<FeeMethodsViewModel> d;
    public final Provider<RecyclerView.ItemDecoration> e;
    public final Provider<AttributedTextFormatter> f;

    public FeesMethodsFragment_MembersInjector(Provider<ItemBinder> provider, Provider<AdapterPresenter> provider2, Provider<Set<ItemPresenter<?, ?>>> provider3, Provider<FeeMethodsViewModel> provider4, Provider<RecyclerView.ItemDecoration> provider5, Provider<AttributedTextFormatter> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static MembersInjector<FeesMethodsFragment> create(Provider<ItemBinder> provider, Provider<AdapterPresenter> provider2, Provider<Set<ItemPresenter<?, ?>>> provider3, Provider<FeeMethodsViewModel> provider4, Provider<RecyclerView.ItemDecoration> provider5, Provider<AttributedTextFormatter> provider6) {
        return new FeesMethodsFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.avito.android.tariff.fees_methods.FeesMethodsFragment.adapterPresenter")
    public static void injectAdapterPresenter(FeesMethodsFragment feesMethodsFragment, AdapterPresenter adapterPresenter) {
        feesMethodsFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.tariff.fees_methods.FeesMethodsFragment.attributedTextFormatter")
    public static void injectAttributedTextFormatter(FeesMethodsFragment feesMethodsFragment, AttributedTextFormatter attributedTextFormatter) {
        feesMethodsFragment.attributedTextFormatter = attributedTextFormatter;
    }

    @InjectedFieldSignature("com.avito.android.tariff.fees_methods.FeesMethodsFragment.itemBinder")
    public static void injectItemBinder(FeesMethodsFragment feesMethodsFragment, ItemBinder itemBinder) {
        feesMethodsFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.tariff.fees_methods.FeesMethodsFragment.itemDecoration")
    public static void injectItemDecoration(FeesMethodsFragment feesMethodsFragment, RecyclerView.ItemDecoration itemDecoration) {
        feesMethodsFragment.itemDecoration = itemDecoration;
    }

    @InjectedFieldSignature("com.avito.android.tariff.fees_methods.FeesMethodsFragment.itemPresenterSet")
    public static void injectItemPresenterSet(FeesMethodsFragment feesMethodsFragment, Set<ItemPresenter<?, ?>> set) {
        feesMethodsFragment.itemPresenterSet = set;
    }

    @InjectedFieldSignature("com.avito.android.tariff.fees_methods.FeesMethodsFragment.viewModel")
    public static void injectViewModel(FeesMethodsFragment feesMethodsFragment, FeeMethodsViewModel feeMethodsViewModel) {
        feesMethodsFragment.viewModel = feeMethodsViewModel;
    }

    public void injectMembers(FeesMethodsFragment feesMethodsFragment) {
        injectItemBinder(feesMethodsFragment, this.a.get());
        injectAdapterPresenter(feesMethodsFragment, this.b.get());
        injectItemPresenterSet(feesMethodsFragment, this.c.get());
        injectViewModel(feesMethodsFragment, this.d.get());
        injectItemDecoration(feesMethodsFragment, this.e.get());
        injectAttributedTextFormatter(feesMethodsFragment, this.f.get());
    }
}
