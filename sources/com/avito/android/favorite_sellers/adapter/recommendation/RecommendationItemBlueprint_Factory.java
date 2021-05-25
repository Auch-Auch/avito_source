package com.avito.android.favorite_sellers.adapter.recommendation;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class RecommendationItemBlueprint_Factory implements Factory<RecommendationItemBlueprint> {
    public final Provider<RecommendationItemPresenter> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<ItemBinder> c;

    public RecommendationItemBlueprint_Factory(Provider<RecommendationItemPresenter> provider, Provider<AdapterPresenter> provider2, Provider<ItemBinder> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static RecommendationItemBlueprint_Factory create(Provider<RecommendationItemPresenter> provider, Provider<AdapterPresenter> provider2, Provider<ItemBinder> provider3) {
        return new RecommendationItemBlueprint_Factory(provider, provider2, provider3);
    }

    public static RecommendationItemBlueprint newInstance(RecommendationItemPresenter recommendationItemPresenter, AdapterPresenter adapterPresenter, ItemBinder itemBinder) {
        return new RecommendationItemBlueprint(recommendationItemPresenter, adapterPresenter, itemBinder);
    }

    @Override // javax.inject.Provider
    public RecommendationItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
