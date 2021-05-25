package com.avito.android.search.map.interactor;

import android.content.res.Resources;
import android.view.View;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MapViewPortProviderImpl_Factory implements Factory<MapViewPortProviderImpl> {
    public final Provider<View> a;
    public final Provider<Resources> b;

    public MapViewPortProviderImpl_Factory(Provider<View> provider, Provider<Resources> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MapViewPortProviderImpl_Factory create(Provider<View> provider, Provider<Resources> provider2) {
        return new MapViewPortProviderImpl_Factory(provider, provider2);
    }

    public static MapViewPortProviderImpl newInstance(View view, Resources resources) {
        return new MapViewPortProviderImpl(view, resources);
    }

    @Override // javax.inject.Provider
    public MapViewPortProviderImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
