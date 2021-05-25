package com.avito.android.select;

import com.avito.android.ab_tests.AutoGenerationsFilterWithPhotos;
import com.avito.android.ab_tests.groups.SimpleTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class SelectDialog_MembersInjector implements MembersInjector<SelectDialog> {
    public final Provider<SelectDialogInteractor> a;
    public final Provider<SelectDialogPresenter> b;
    public final Provider<ItemBinder> c;
    public final Provider<AdapterPresenter> d;
    public final Provider<SingleManuallyExposedAbTestGroup<SimpleTestGroup>> e;

    public SelectDialog_MembersInjector(Provider<SelectDialogInteractor> provider, Provider<SelectDialogPresenter> provider2, Provider<ItemBinder> provider3, Provider<AdapterPresenter> provider4, Provider<SingleManuallyExposedAbTestGroup<SimpleTestGroup>> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MembersInjector<SelectDialog> create(Provider<SelectDialogInteractor> provider, Provider<SelectDialogPresenter> provider2, Provider<ItemBinder> provider3, Provider<AdapterPresenter> provider4, Provider<SingleManuallyExposedAbTestGroup<SimpleTestGroup>> provider5) {
        return new SelectDialog_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.avito.android.select.SelectDialog.adapterPresenter")
    public static void injectAdapterPresenter(SelectDialog selectDialog, AdapterPresenter adapterPresenter) {
        selectDialog.adapterPresenter = adapterPresenter;
    }

    @AutoGenerationsFilterWithPhotos
    @InjectedFieldSignature("com.avito.android.select.SelectDialog.filterWithPhotosGroup")
    public static void injectFilterWithPhotosGroup(SelectDialog selectDialog, SingleManuallyExposedAbTestGroup<SimpleTestGroup> singleManuallyExposedAbTestGroup) {
        selectDialog.filterWithPhotosGroup = singleManuallyExposedAbTestGroup;
    }

    @InjectedFieldSignature("com.avito.android.select.SelectDialog.interactor")
    public static void injectInteractor(SelectDialog selectDialog, SelectDialogInteractor selectDialogInteractor) {
        selectDialog.interactor = selectDialogInteractor;
    }

    @InjectedFieldSignature("com.avito.android.select.SelectDialog.itemBinder")
    public static void injectItemBinder(SelectDialog selectDialog, ItemBinder itemBinder) {
        selectDialog.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.select.SelectDialog.presenter")
    public static void injectPresenter(SelectDialog selectDialog, SelectDialogPresenter selectDialogPresenter) {
        selectDialog.presenter = selectDialogPresenter;
    }

    public void injectMembers(SelectDialog selectDialog) {
        injectInteractor(selectDialog, this.a.get());
        injectPresenter(selectDialog, this.b.get());
        injectItemBinder(selectDialog, this.c.get());
        injectAdapterPresenter(selectDialog, this.d.get());
        injectFilterWithPhotosGroup(selectDialog, this.e.get());
    }
}
