package com.avito.android.vas_discount.ui.dialog;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import java.util.Set;
import javax.inject.Provider;
public final class DiscountDialogFragment_MembersInjector implements MembersInjector<DiscountDialogFragment> {
    public final Provider<ItemBinder> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<DiscountPickerViewModel> c;
    public final Provider<Set<ItemPresenter<?, ?>>> d;

    public DiscountDialogFragment_MembersInjector(Provider<ItemBinder> provider, Provider<AdapterPresenter> provider2, Provider<DiscountPickerViewModel> provider3, Provider<Set<ItemPresenter<?, ?>>> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<DiscountDialogFragment> create(Provider<ItemBinder> provider, Provider<AdapterPresenter> provider2, Provider<DiscountPickerViewModel> provider3, Provider<Set<ItemPresenter<?, ?>>> provider4) {
        return new DiscountDialogFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.vas_discount.ui.dialog.DiscountDialogFragment.adapterPresenter")
    public static void injectAdapterPresenter(DiscountDialogFragment discountDialogFragment, AdapterPresenter adapterPresenter) {
        discountDialogFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.vas_discount.ui.dialog.DiscountDialogFragment.itemBinder")
    public static void injectItemBinder(DiscountDialogFragment discountDialogFragment, ItemBinder itemBinder) {
        discountDialogFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.vas_discount.ui.dialog.DiscountDialogFragment.itemPresenterSet")
    public static void injectItemPresenterSet(DiscountDialogFragment discountDialogFragment, Set<ItemPresenter<?, ?>> set) {
        discountDialogFragment.itemPresenterSet = set;
    }

    @InjectedFieldSignature("com.avito.android.vas_discount.ui.dialog.DiscountDialogFragment.viewModel")
    public static void injectViewModel(DiscountDialogFragment discountDialogFragment, DiscountPickerViewModel discountPickerViewModel) {
        discountDialogFragment.viewModel = discountPickerViewModel;
    }

    public void injectMembers(DiscountDialogFragment discountDialogFragment) {
        injectItemBinder(discountDialogFragment, this.a.get());
        injectAdapterPresenter(discountDialogFragment, this.b.get());
        injectViewModel(discountDialogFragment, this.c.get());
        injectItemPresenterSet(discountDialogFragment, this.d.get());
    }
}
