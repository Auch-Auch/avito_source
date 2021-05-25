package com.avito.android.user_favorites.adapter.items.di;

import com.avito.android.design.widget.tab.TabBlueprint;
import com.avito.android.user_favorites.adapter.FavoritesTab;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class ItemsTabModule_ProvideTabBlueprintFactory implements Factory<TabBlueprint<? extends FavoritesTab>> {
    public final ItemsTabModule a;

    public ItemsTabModule_ProvideTabBlueprintFactory(ItemsTabModule itemsTabModule) {
        this.a = itemsTabModule;
    }

    public static ItemsTabModule_ProvideTabBlueprintFactory create(ItemsTabModule itemsTabModule) {
        return new ItemsTabModule_ProvideTabBlueprintFactory(itemsTabModule);
    }

    public static TabBlueprint<? extends FavoritesTab> provideTabBlueprint(ItemsTabModule itemsTabModule) {
        return (TabBlueprint) Preconditions.checkNotNullFromProvides(itemsTabModule.provideTabBlueprint());
    }

    @Override // javax.inject.Provider
    public TabBlueprint<? extends FavoritesTab> get() {
        return provideTabBlueprint(this.a);
    }
}
