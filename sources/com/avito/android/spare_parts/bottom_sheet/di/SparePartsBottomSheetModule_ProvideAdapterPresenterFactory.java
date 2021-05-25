package com.avito.android.spare_parts.bottom_sheet.di;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SparePartsBottomSheetModule_ProvideAdapterPresenterFactory implements Factory<AdapterPresenter> {
    public final Provider<ItemBinder> a;

    public SparePartsBottomSheetModule_ProvideAdapterPresenterFactory(Provider<ItemBinder> provider) {
        this.a = provider;
    }

    public static SparePartsBottomSheetModule_ProvideAdapterPresenterFactory create(Provider<ItemBinder> provider) {
        return new SparePartsBottomSheetModule_ProvideAdapterPresenterFactory(provider);
    }

    public static AdapterPresenter provideAdapterPresenter(ItemBinder itemBinder) {
        return (AdapterPresenter) Preconditions.checkNotNullFromProvides(SparePartsBottomSheetModule.provideAdapterPresenter(itemBinder));
    }

    @Override // javax.inject.Provider
    public AdapterPresenter get() {
        return provideAdapterPresenter(this.a.get());
    }
}
