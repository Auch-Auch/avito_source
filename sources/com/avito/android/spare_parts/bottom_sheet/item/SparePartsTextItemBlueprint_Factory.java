package com.avito.android.spare_parts.bottom_sheet.item;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SparePartsTextItemBlueprint_Factory implements Factory<SparePartsTextItemBlueprint> {
    public final Provider<SparePartsTextItemPresenter> a;

    public SparePartsTextItemBlueprint_Factory(Provider<SparePartsTextItemPresenter> provider) {
        this.a = provider;
    }

    public static SparePartsTextItemBlueprint_Factory create(Provider<SparePartsTextItemPresenter> provider) {
        return new SparePartsTextItemBlueprint_Factory(provider);
    }

    public static SparePartsTextItemBlueprint newInstance(SparePartsTextItemPresenter sparePartsTextItemPresenter) {
        return new SparePartsTextItemBlueprint(sparePartsTextItemPresenter);
    }

    @Override // javax.inject.Provider
    public SparePartsTextItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
