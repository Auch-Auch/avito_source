package com.avito.android.spare_parts.bottom_sheet;

import com.avito.android.remote.models.SparePartsResponse;
import com.avito.android.spare_parts.SparePartsFormatter;
import com.avito.android.spare_parts.SparePartsResourceProvider;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SparePartsBottomSheetPresenterImpl_Factory implements Factory<SparePartsBottomSheetPresenterImpl> {
    public final Provider<SparePartsResponse.SparePartsGroup> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<SparePartsFormatter> c;
    public final Provider<SparePartsResourceProvider> d;

    public SparePartsBottomSheetPresenterImpl_Factory(Provider<SparePartsResponse.SparePartsGroup> provider, Provider<AdapterPresenter> provider2, Provider<SparePartsFormatter> provider3, Provider<SparePartsResourceProvider> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static SparePartsBottomSheetPresenterImpl_Factory create(Provider<SparePartsResponse.SparePartsGroup> provider, Provider<AdapterPresenter> provider2, Provider<SparePartsFormatter> provider3, Provider<SparePartsResourceProvider> provider4) {
        return new SparePartsBottomSheetPresenterImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static SparePartsBottomSheetPresenterImpl newInstance(SparePartsResponse.SparePartsGroup sparePartsGroup, AdapterPresenter adapterPresenter, SparePartsFormatter sparePartsFormatter, SparePartsResourceProvider sparePartsResourceProvider) {
        return new SparePartsBottomSheetPresenterImpl(sparePartsGroup, adapterPresenter, sparePartsFormatter, sparePartsResourceProvider);
    }

    @Override // javax.inject.Provider
    public SparePartsBottomSheetPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
