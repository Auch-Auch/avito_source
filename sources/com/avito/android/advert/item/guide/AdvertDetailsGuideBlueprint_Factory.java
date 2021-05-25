package com.avito.android.advert.item.guide;

import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsGuideBlueprint_Factory implements Factory<AdvertDetailsGuideBlueprint> {
    public final Provider<AdvertDetailsGuidePresenter> a;
    public final Provider<SimpleRecyclerAdapter> b;

    public AdvertDetailsGuideBlueprint_Factory(Provider<AdvertDetailsGuidePresenter> provider, Provider<SimpleRecyclerAdapter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AdvertDetailsGuideBlueprint_Factory create(Provider<AdvertDetailsGuidePresenter> provider, Provider<SimpleRecyclerAdapter> provider2) {
        return new AdvertDetailsGuideBlueprint_Factory(provider, provider2);
    }

    public static AdvertDetailsGuideBlueprint newInstance(AdvertDetailsGuidePresenter advertDetailsGuidePresenter, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        return new AdvertDetailsGuideBlueprint(advertDetailsGuidePresenter, simpleRecyclerAdapter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsGuideBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
