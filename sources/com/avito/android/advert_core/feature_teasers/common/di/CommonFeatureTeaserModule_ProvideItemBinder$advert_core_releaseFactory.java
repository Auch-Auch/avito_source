package com.avito.android.advert_core.feature_teasers.common.di;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class CommonFeatureTeaserModule_ProvideItemBinder$advert_core_releaseFactory implements Factory<ItemBinder> {
    public final Provider<Set<ItemBlueprint<?, ?>>> a;

    public CommonFeatureTeaserModule_ProvideItemBinder$advert_core_releaseFactory(Provider<Set<ItemBlueprint<?, ?>>> provider) {
        this.a = provider;
    }

    public static CommonFeatureTeaserModule_ProvideItemBinder$advert_core_releaseFactory create(Provider<Set<ItemBlueprint<?, ?>>> provider) {
        return new CommonFeatureTeaserModule_ProvideItemBinder$advert_core_releaseFactory(provider);
    }

    public static ItemBinder provideItemBinder$advert_core_release(Set<ItemBlueprint<?, ?>> set) {
        return (ItemBinder) Preconditions.checkNotNullFromProvides(CommonFeatureTeaserModule.provideItemBinder$advert_core_release(set));
    }

    @Override // javax.inject.Provider
    public ItemBinder get() {
        return provideItemBinder$advert_core_release(this.a.get());
    }
}
