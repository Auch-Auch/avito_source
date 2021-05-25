package com.avito.android.user_favorites.adapter.viewed_items.di;

import com.avito.android.design.widget.tab.TabBlueprint;
import com.avito.android.user_favorites.adapter.FavoritesTab;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class ViewedItemsTabModule_ProvideTabBlueprintFactory implements Factory<TabBlueprint<? extends FavoritesTab>> {
    public final ViewedItemsTabModule a;

    public ViewedItemsTabModule_ProvideTabBlueprintFactory(ViewedItemsTabModule viewedItemsTabModule) {
        this.a = viewedItemsTabModule;
    }

    public static ViewedItemsTabModule_ProvideTabBlueprintFactory create(ViewedItemsTabModule viewedItemsTabModule) {
        return new ViewedItemsTabModule_ProvideTabBlueprintFactory(viewedItemsTabModule);
    }

    public static TabBlueprint<? extends FavoritesTab> provideTabBlueprint(ViewedItemsTabModule viewedItemsTabModule) {
        return (TabBlueprint) Preconditions.checkNotNullFromProvides(viewedItemsTabModule.provideTabBlueprint());
    }

    @Override // javax.inject.Provider
    public TabBlueprint<? extends FavoritesTab> get() {
        return provideTabBlueprint(this.a);
    }
}
