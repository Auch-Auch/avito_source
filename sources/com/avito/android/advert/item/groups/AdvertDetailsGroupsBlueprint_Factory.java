package com.avito.android.advert.item.groups;

import com.avito.android.advert_core.advert.AdvertDetailsGroupsListener;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsGroupsBlueprint_Factory implements Factory<AdvertDetailsGroupsBlueprint> {
    public final Provider<AdvertDetailsGroupsPresenter> a;
    public final Provider<AdvertDetailsGroupsListener> b;

    public AdvertDetailsGroupsBlueprint_Factory(Provider<AdvertDetailsGroupsPresenter> provider, Provider<AdvertDetailsGroupsListener> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AdvertDetailsGroupsBlueprint_Factory create(Provider<AdvertDetailsGroupsPresenter> provider, Provider<AdvertDetailsGroupsListener> provider2) {
        return new AdvertDetailsGroupsBlueprint_Factory(provider, provider2);
    }

    public static AdvertDetailsGroupsBlueprint newInstance(AdvertDetailsGroupsPresenter advertDetailsGroupsPresenter, AdvertDetailsGroupsListener advertDetailsGroupsListener) {
        return new AdvertDetailsGroupsBlueprint(advertDetailsGroupsPresenter, advertDetailsGroupsListener);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsGroupsBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
