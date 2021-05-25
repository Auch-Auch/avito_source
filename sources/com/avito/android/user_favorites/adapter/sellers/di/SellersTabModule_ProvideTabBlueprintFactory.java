package com.avito.android.user_favorites.adapter.sellers.di;

import com.avito.android.design.widget.tab.TabBlueprint;
import com.avito.android.user_favorites.adapter.FavoritesTab;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SellersTabModule_ProvideTabBlueprintFactory implements Factory<TabBlueprint<? extends FavoritesTab>> {
    public final SellersTabModule a;

    public SellersTabModule_ProvideTabBlueprintFactory(SellersTabModule sellersTabModule) {
        this.a = sellersTabModule;
    }

    public static SellersTabModule_ProvideTabBlueprintFactory create(SellersTabModule sellersTabModule) {
        return new SellersTabModule_ProvideTabBlueprintFactory(sellersTabModule);
    }

    public static TabBlueprint<? extends FavoritesTab> provideTabBlueprint(SellersTabModule sellersTabModule) {
        return (TabBlueprint) Preconditions.checkNotNullFromProvides(sellersTabModule.provideTabBlueprint());
    }

    @Override // javax.inject.Provider
    public TabBlueprint<? extends FavoritesTab> get() {
        return provideTabBlueprint(this.a);
    }
}
