package com.avito.android.advert.item.features_teaser.di;

import com.avito.android.serp.adapter.promo_card.PromoCardItemPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PromoCardModule_GetBlueprintFactory implements Factory<ItemBlueprint<?, ?>> {
    public final Provider<PromoCardItemPresenter> a;

    public PromoCardModule_GetBlueprintFactory(Provider<PromoCardItemPresenter> provider) {
        this.a = provider;
    }

    public static PromoCardModule_GetBlueprintFactory create(Provider<PromoCardItemPresenter> provider) {
        return new PromoCardModule_GetBlueprintFactory(provider);
    }

    public static ItemBlueprint<?, ?> getBlueprint(PromoCardItemPresenter promoCardItemPresenter) {
        return (ItemBlueprint) Preconditions.checkNotNullFromProvides(PromoCardModule.INSTANCE.getBlueprint(promoCardItemPresenter));
    }

    @Override // javax.inject.Provider
    public ItemBlueprint<?, ?> get() {
        return getBlueprint(this.a.get());
    }
}
