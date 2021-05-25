package com.avito.android.item_map.view;

import com.avito.android.item_map.amenity.AmenityButtonsPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ItemMapViewBottomSheetAdapter_Factory implements Factory<ItemMapViewBottomSheetAdapter> {
    public final Provider<AmenityButtonsPresenter> a;

    public ItemMapViewBottomSheetAdapter_Factory(Provider<AmenityButtonsPresenter> provider) {
        this.a = provider;
    }

    public static ItemMapViewBottomSheetAdapter_Factory create(Provider<AmenityButtonsPresenter> provider) {
        return new ItemMapViewBottomSheetAdapter_Factory(provider);
    }

    public static ItemMapViewBottomSheetAdapter newInstance(AmenityButtonsPresenter amenityButtonsPresenter) {
        return new ItemMapViewBottomSheetAdapter(amenityButtonsPresenter);
    }

    @Override // javax.inject.Provider
    public ItemMapViewBottomSheetAdapter get() {
        return newInstance(this.a.get());
    }
}
