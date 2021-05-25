package com.avito.android.serp.adapter.advert_xl;

import com.avito.android.serp.adapter.SerpItemAbViewConfig;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertXlItemBlueprint_Factory implements Factory<AdvertXlItemBlueprint> {
    public final Provider<AdvertXlItemPresenter> a;
    public final Provider<SerpItemAbViewConfig> b;

    public AdvertXlItemBlueprint_Factory(Provider<AdvertXlItemPresenter> provider, Provider<SerpItemAbViewConfig> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AdvertXlItemBlueprint_Factory create(Provider<AdvertXlItemPresenter> provider, Provider<SerpItemAbViewConfig> provider2) {
        return new AdvertXlItemBlueprint_Factory(provider, provider2);
    }

    public static AdvertXlItemBlueprint newInstance(AdvertXlItemPresenter advertXlItemPresenter, SerpItemAbViewConfig serpItemAbViewConfig) {
        return new AdvertXlItemBlueprint(advertXlItemPresenter, serpItemAbViewConfig);
    }

    @Override // javax.inject.Provider
    public AdvertXlItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
