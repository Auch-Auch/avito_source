package com.avito.android.select.bottom_sheet;

import com.avito.android.ab_tests.AutoGenerationsFilterWithPhotos;
import com.avito.android.ab_tests.groups.SimpleTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.select.SelectDialogPresenter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class SelectBottomSheetFragment_MembersInjector implements MembersInjector<SelectBottomSheetFragment> {
    public final Provider<AdapterPresenter> a;
    public final Provider<ItemBinder> b;
    public final Provider<SelectDialogPresenter> c;
    public final Provider<SingleManuallyExposedAbTestGroup<SimpleTestGroup>> d;

    public SelectBottomSheetFragment_MembersInjector(Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2, Provider<SelectDialogPresenter> provider3, Provider<SingleManuallyExposedAbTestGroup<SimpleTestGroup>> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<SelectBottomSheetFragment> create(Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2, Provider<SelectDialogPresenter> provider3, Provider<SingleManuallyExposedAbTestGroup<SimpleTestGroup>> provider4) {
        return new SelectBottomSheetFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.select.bottom_sheet.SelectBottomSheetFragment.adapterPresenter")
    public static void injectAdapterPresenter(SelectBottomSheetFragment selectBottomSheetFragment, AdapterPresenter adapterPresenter) {
        selectBottomSheetFragment.adapterPresenter = adapterPresenter;
    }

    @AutoGenerationsFilterWithPhotos
    @InjectedFieldSignature("com.avito.android.select.bottom_sheet.SelectBottomSheetFragment.filterWithPhotosGroup")
    public static void injectFilterWithPhotosGroup(SelectBottomSheetFragment selectBottomSheetFragment, SingleManuallyExposedAbTestGroup<SimpleTestGroup> singleManuallyExposedAbTestGroup) {
        selectBottomSheetFragment.filterWithPhotosGroup = singleManuallyExposedAbTestGroup;
    }

    @InjectedFieldSignature("com.avito.android.select.bottom_sheet.SelectBottomSheetFragment.itemBinder")
    public static void injectItemBinder(SelectBottomSheetFragment selectBottomSheetFragment, ItemBinder itemBinder) {
        selectBottomSheetFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.select.bottom_sheet.SelectBottomSheetFragment.presenter")
    public static void injectPresenter(SelectBottomSheetFragment selectBottomSheetFragment, SelectDialogPresenter selectDialogPresenter) {
        selectBottomSheetFragment.presenter = selectDialogPresenter;
    }

    public void injectMembers(SelectBottomSheetFragment selectBottomSheetFragment) {
        injectAdapterPresenter(selectBottomSheetFragment, this.a.get());
        injectItemBinder(selectBottomSheetFragment, this.b.get());
        injectPresenter(selectBottomSheetFragment, this.c.get());
        injectFilterWithPhotosGroup(selectBottomSheetFragment, this.d.get());
    }
}
