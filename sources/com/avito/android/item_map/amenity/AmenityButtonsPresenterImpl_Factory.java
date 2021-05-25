package com.avito.android.item_map.amenity;

import com.avito.android.avito_map.amenity.AmenityMarkerIconFactory;
import com.avito.android.item_map.view.ItemMapView;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AmenityButtonsPresenterImpl_Factory implements Factory<AmenityButtonsPresenterImpl> {
    public final Provider<AmenityButtonsInteractor> a;
    public final Provider<AmenityMarkerIconFactory> b;
    public final Provider<ItemMapView.ItemMapState> c;
    public final Provider<Kundle> d;
    public final Provider<SchedulersFactory3> e;

    public AmenityButtonsPresenterImpl_Factory(Provider<AmenityButtonsInteractor> provider, Provider<AmenityMarkerIconFactory> provider2, Provider<ItemMapView.ItemMapState> provider3, Provider<Kundle> provider4, Provider<SchedulersFactory3> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static AmenityButtonsPresenterImpl_Factory create(Provider<AmenityButtonsInteractor> provider, Provider<AmenityMarkerIconFactory> provider2, Provider<ItemMapView.ItemMapState> provider3, Provider<Kundle> provider4, Provider<SchedulersFactory3> provider5) {
        return new AmenityButtonsPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static AmenityButtonsPresenterImpl newInstance(AmenityButtonsInteractor amenityButtonsInteractor, AmenityMarkerIconFactory amenityMarkerIconFactory, ItemMapView.ItemMapState itemMapState, Kundle kundle, SchedulersFactory3 schedulersFactory3) {
        return new AmenityButtonsPresenterImpl(amenityButtonsInteractor, amenityMarkerIconFactory, itemMapState, kundle, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public AmenityButtonsPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
