package com.avito.android.vas_performance.ui.applied_services;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import java.util.Set;
import javax.inject.Provider;
public final class AppliedServicesDialogFragment_MembersInjector implements MembersInjector<AppliedServicesDialogFragment> {
    public final Provider<Set<ItemPresenter<?, ?>>> a;
    public final Provider<AppliedServicesViewModel> b;
    public final Provider<ItemBinder> c;
    public final Provider<AdapterPresenter> d;

    public AppliedServicesDialogFragment_MembersInjector(Provider<Set<ItemPresenter<?, ?>>> provider, Provider<AppliedServicesViewModel> provider2, Provider<ItemBinder> provider3, Provider<AdapterPresenter> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<AppliedServicesDialogFragment> create(Provider<Set<ItemPresenter<?, ?>>> provider, Provider<AppliedServicesViewModel> provider2, Provider<ItemBinder> provider3, Provider<AdapterPresenter> provider4) {
        return new AppliedServicesDialogFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.vas_performance.ui.applied_services.AppliedServicesDialogFragment.adapterPresenter")
    public static void injectAdapterPresenter(AppliedServicesDialogFragment appliedServicesDialogFragment, AdapterPresenter adapterPresenter) {
        appliedServicesDialogFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.vas_performance.ui.applied_services.AppliedServicesDialogFragment.itemBinder")
    public static void injectItemBinder(AppliedServicesDialogFragment appliedServicesDialogFragment, ItemBinder itemBinder) {
        appliedServicesDialogFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.vas_performance.ui.applied_services.AppliedServicesDialogFragment.itemPresenterSet")
    public static void injectItemPresenterSet(AppliedServicesDialogFragment appliedServicesDialogFragment, Set<ItemPresenter<?, ?>> set) {
        appliedServicesDialogFragment.itemPresenterSet = set;
    }

    @InjectedFieldSignature("com.avito.android.vas_performance.ui.applied_services.AppliedServicesDialogFragment.viewModel")
    public static void injectViewModel(AppliedServicesDialogFragment appliedServicesDialogFragment, AppliedServicesViewModel appliedServicesViewModel) {
        appliedServicesDialogFragment.viewModel = appliedServicesViewModel;
    }

    public void injectMembers(AppliedServicesDialogFragment appliedServicesDialogFragment) {
        injectItemPresenterSet(appliedServicesDialogFragment, this.a.get());
        injectViewModel(appliedServicesDialogFragment, this.b.get());
        injectItemBinder(appliedServicesDialogFragment, this.c.get());
        injectAdapterPresenter(appliedServicesDialogFragment, this.d.get());
    }
}
