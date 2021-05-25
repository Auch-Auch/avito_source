package com.avito.android.fees.refactor;

import com.avito.android.util.DialogRouter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class MvvmPackageFeeFragment_MembersInjector implements MembersInjector<MvvmPackageFeeFragment> {
    public final Provider<ItemBinder> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<PackageFeeViewModel> c;
    public final Provider<DialogRouter> d;

    public MvvmPackageFeeFragment_MembersInjector(Provider<ItemBinder> provider, Provider<AdapterPresenter> provider2, Provider<PackageFeeViewModel> provider3, Provider<DialogRouter> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<MvvmPackageFeeFragment> create(Provider<ItemBinder> provider, Provider<AdapterPresenter> provider2, Provider<PackageFeeViewModel> provider3, Provider<DialogRouter> provider4) {
        return new MvvmPackageFeeFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.fees.refactor.MvvmPackageFeeFragment.adapterPresenter")
    public static void injectAdapterPresenter(MvvmPackageFeeFragment mvvmPackageFeeFragment, AdapterPresenter adapterPresenter) {
        mvvmPackageFeeFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.fees.refactor.MvvmPackageFeeFragment.dialogRouter")
    public static void injectDialogRouter(MvvmPackageFeeFragment mvvmPackageFeeFragment, DialogRouter dialogRouter) {
        mvvmPackageFeeFragment.dialogRouter = dialogRouter;
    }

    @InjectedFieldSignature("com.avito.android.fees.refactor.MvvmPackageFeeFragment.itemBinder")
    public static void injectItemBinder(MvvmPackageFeeFragment mvvmPackageFeeFragment, ItemBinder itemBinder) {
        mvvmPackageFeeFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.fees.refactor.MvvmPackageFeeFragment.viewModel")
    public static void injectViewModel(MvvmPackageFeeFragment mvvmPackageFeeFragment, PackageFeeViewModel packageFeeViewModel) {
        mvvmPackageFeeFragment.viewModel = packageFeeViewModel;
    }

    public void injectMembers(MvvmPackageFeeFragment mvvmPackageFeeFragment) {
        injectItemBinder(mvvmPackageFeeFragment, this.a.get());
        injectAdapterPresenter(mvvmPackageFeeFragment, this.b.get());
        injectViewModel(mvvmPackageFeeFragment, this.c.get());
        injectDialogRouter(mvvmPackageFeeFragment, this.d.get());
    }
}
