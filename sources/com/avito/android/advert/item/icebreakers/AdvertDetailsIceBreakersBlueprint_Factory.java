package com.avito.android.advert.item.icebreakers;

import com.avito.android.ab_tests.groups.AdvertDetailsIcebreakerStyleTestGroup;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsIceBreakersBlueprint_Factory implements Factory<AdvertDetailsIceBreakersBlueprint> {
    public final Provider<AdvertDetailsIceBreakersPresenter> a;
    public final Provider<AdvertDetailsIcebreakerStyleTestGroup> b;

    public AdvertDetailsIceBreakersBlueprint_Factory(Provider<AdvertDetailsIceBreakersPresenter> provider, Provider<AdvertDetailsIcebreakerStyleTestGroup> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AdvertDetailsIceBreakersBlueprint_Factory create(Provider<AdvertDetailsIceBreakersPresenter> provider, Provider<AdvertDetailsIcebreakerStyleTestGroup> provider2) {
        return new AdvertDetailsIceBreakersBlueprint_Factory(provider, provider2);
    }

    public static AdvertDetailsIceBreakersBlueprint newInstance(AdvertDetailsIceBreakersPresenter advertDetailsIceBreakersPresenter, AdvertDetailsIcebreakerStyleTestGroup advertDetailsIcebreakerStyleTestGroup) {
        return new AdvertDetailsIceBreakersBlueprint(advertDetailsIceBreakersPresenter, advertDetailsIcebreakerStyleTestGroup);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsIceBreakersBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
