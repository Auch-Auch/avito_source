package com.avito.android.serp.adapter.map_banner;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MapBannerItemPresenterImpl_Factory implements Factory<MapBannerItemPresenterImpl> {
    public final Provider<MapBannerItemListener> a;

    public MapBannerItemPresenterImpl_Factory(Provider<MapBannerItemListener> provider) {
        this.a = provider;
    }

    public static MapBannerItemPresenterImpl_Factory create(Provider<MapBannerItemListener> provider) {
        return new MapBannerItemPresenterImpl_Factory(provider);
    }

    public static MapBannerItemPresenterImpl newInstance(Lazy<MapBannerItemListener> lazy) {
        return new MapBannerItemPresenterImpl(lazy);
    }

    @Override // javax.inject.Provider
    public MapBannerItemPresenterImpl get() {
        return newInstance(DoubleCheck.lazy(this.a));
    }
}
