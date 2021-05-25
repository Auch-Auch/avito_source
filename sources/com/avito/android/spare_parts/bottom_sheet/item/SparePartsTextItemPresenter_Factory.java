package com.avito.android.spare_parts.bottom_sheet.item;

import com.avito.android.spare_parts.SparePartsResourceProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SparePartsTextItemPresenter_Factory implements Factory<SparePartsTextItemPresenter> {
    public final Provider<SparePartsResourceProvider> a;

    public SparePartsTextItemPresenter_Factory(Provider<SparePartsResourceProvider> provider) {
        this.a = provider;
    }

    public static SparePartsTextItemPresenter_Factory create(Provider<SparePartsResourceProvider> provider) {
        return new SparePartsTextItemPresenter_Factory(provider);
    }

    public static SparePartsTextItemPresenter newInstance(SparePartsResourceProvider sparePartsResourceProvider) {
        return new SparePartsTextItemPresenter(sparePartsResourceProvider);
    }

    @Override // javax.inject.Provider
    public SparePartsTextItemPresenter get() {
        return newInstance(this.a.get());
    }
}
