package com.avito.android.spare_parts.bottom_sheet;

import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class SparePartsBottomSheetActivity_MembersInjector implements MembersInjector<SparePartsBottomSheetActivity> {
    public final Provider<SparePartsBottomSheetPresenter> a;
    public final Provider<SimpleRecyclerAdapter> b;

    public SparePartsBottomSheetActivity_MembersInjector(Provider<SparePartsBottomSheetPresenter> provider, Provider<SimpleRecyclerAdapter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MembersInjector<SparePartsBottomSheetActivity> create(Provider<SparePartsBottomSheetPresenter> provider, Provider<SimpleRecyclerAdapter> provider2) {
        return new SparePartsBottomSheetActivity_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.avito.android.spare_parts.bottom_sheet.SparePartsBottomSheetActivity.adapter")
    public static void injectAdapter(SparePartsBottomSheetActivity sparePartsBottomSheetActivity, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        sparePartsBottomSheetActivity.adapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.spare_parts.bottom_sheet.SparePartsBottomSheetActivity.presenter")
    public static void injectPresenter(SparePartsBottomSheetActivity sparePartsBottomSheetActivity, SparePartsBottomSheetPresenter sparePartsBottomSheetPresenter) {
        sparePartsBottomSheetActivity.presenter = sparePartsBottomSheetPresenter;
    }

    public void injectMembers(SparePartsBottomSheetActivity sparePartsBottomSheetActivity) {
        injectPresenter(sparePartsBottomSheetActivity, this.a.get());
        injectAdapter(sparePartsBottomSheetActivity, this.b.get());
    }
}
