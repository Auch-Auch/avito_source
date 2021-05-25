package com.avito.android.favorite_sellers.adapter.recommendation.advert_details;

import com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsRecommendationItemBlueprint_Factory implements Factory<AdvertDetailsRecommendationItemBlueprint> {
    public final Provider<RecommendationItemPresenter> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<ItemBinder> c;

    public AdvertDetailsRecommendationItemBlueprint_Factory(Provider<RecommendationItemPresenter> provider, Provider<AdapterPresenter> provider2, Provider<ItemBinder> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static AdvertDetailsRecommendationItemBlueprint_Factory create(Provider<RecommendationItemPresenter> provider, Provider<AdapterPresenter> provider2, Provider<ItemBinder> provider3) {
        return new AdvertDetailsRecommendationItemBlueprint_Factory(provider, provider2, provider3);
    }

    public static AdvertDetailsRecommendationItemBlueprint newInstance(RecommendationItemPresenter recommendationItemPresenter, AdapterPresenter adapterPresenter, ItemBinder itemBinder) {
        return new AdvertDetailsRecommendationItemBlueprint(recommendationItemPresenter, adapterPresenter, itemBinder);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsRecommendationItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
