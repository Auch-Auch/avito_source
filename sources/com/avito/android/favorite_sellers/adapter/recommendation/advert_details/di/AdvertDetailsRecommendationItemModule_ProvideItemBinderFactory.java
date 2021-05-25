package com.avito.android.favorite_sellers.adapter.recommendation.advert_details.di;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class AdvertDetailsRecommendationItemModule_ProvideItemBinderFactory implements Factory<ItemBinder> {
    public final Provider<Set<ItemBlueprint<?, ?>>> a;

    public AdvertDetailsRecommendationItemModule_ProvideItemBinderFactory(Provider<Set<ItemBlueprint<?, ?>>> provider) {
        this.a = provider;
    }

    public static AdvertDetailsRecommendationItemModule_ProvideItemBinderFactory create(Provider<Set<ItemBlueprint<?, ?>>> provider) {
        return new AdvertDetailsRecommendationItemModule_ProvideItemBinderFactory(provider);
    }

    public static ItemBinder provideItemBinder(Set<ItemBlueprint<?, ?>> set) {
        return (ItemBinder) Preconditions.checkNotNullFromProvides(AdvertDetailsRecommendationItemModule.provideItemBinder(set));
    }

    @Override // javax.inject.Provider
    public ItemBinder get() {
        return provideItemBinder(this.a.get());
    }
}
