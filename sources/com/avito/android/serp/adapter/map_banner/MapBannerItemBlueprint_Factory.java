package com.avito.android.serp.adapter.map_banner;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class MapBannerItemBlueprint_Factory implements Factory<MapBannerItemBlueprint> {
    public final Provider<MapBannerItemPresenter> a;

    public MapBannerItemBlueprint_Factory(Provider<MapBannerItemPresenter> provider) {
        this.a = provider;
    }

    public static MapBannerItemBlueprint_Factory create(Provider<MapBannerItemPresenter> provider) {
        return new MapBannerItemBlueprint_Factory(provider);
    }

    public static MapBannerItemBlueprint newInstance(MapBannerItemPresenter mapBannerItemPresenter) {
        return new MapBannerItemBlueprint(mapBannerItemPresenter);
    }

    @Override // javax.inject.Provider
    public MapBannerItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
