package com.avito.android.favorite_sellers.adapter.recommendation.di;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class RecommendationItemModule_ProvideItemBinderFactory implements Factory<ItemBinder> {
    public final Provider<Set<ItemBlueprint<?, ?>>> a;

    public RecommendationItemModule_ProvideItemBinderFactory(Provider<Set<ItemBlueprint<?, ?>>> provider) {
        this.a = provider;
    }

    public static RecommendationItemModule_ProvideItemBinderFactory create(Provider<Set<ItemBlueprint<?, ?>>> provider) {
        return new RecommendationItemModule_ProvideItemBinderFactory(provider);
    }

    public static ItemBinder provideItemBinder(Set<ItemBlueprint<?, ?>> set) {
        return (ItemBinder) Preconditions.checkNotNullFromProvides(RecommendationItemModule.provideItemBinder(set));
    }

    @Override // javax.inject.Provider
    public ItemBinder get() {
        return provideItemBinder(this.a.get());
    }
}
