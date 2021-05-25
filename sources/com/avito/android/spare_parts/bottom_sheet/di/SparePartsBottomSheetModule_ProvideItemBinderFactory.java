package com.avito.android.spare_parts.bottom_sheet.di;

import com.avito.android.spare_parts.bottom_sheet.item.SparePartsTextItemBlueprint;
import com.avito.konveyor.ItemBinder;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SparePartsBottomSheetModule_ProvideItemBinderFactory implements Factory<ItemBinder> {
    public final Provider<SparePartsTextItemBlueprint> a;

    public SparePartsBottomSheetModule_ProvideItemBinderFactory(Provider<SparePartsTextItemBlueprint> provider) {
        this.a = provider;
    }

    public static SparePartsBottomSheetModule_ProvideItemBinderFactory create(Provider<SparePartsTextItemBlueprint> provider) {
        return new SparePartsBottomSheetModule_ProvideItemBinderFactory(provider);
    }

    public static ItemBinder provideItemBinder(SparePartsTextItemBlueprint sparePartsTextItemBlueprint) {
        return (ItemBinder) Preconditions.checkNotNullFromProvides(SparePartsBottomSheetModule.provideItemBinder(sparePartsTextItemBlueprint));
    }

    @Override // javax.inject.Provider
    public ItemBinder get() {
        return provideItemBinder(this.a.get());
    }
}
