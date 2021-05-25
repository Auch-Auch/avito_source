package com.avito.android.user_favorites.adapter.search.di;

import com.avito.android.design.widget.tab.TabBlueprint;
import com.avito.android.user_favorites.adapter.FavoritesTab;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SearchTabModule_ProvideTabBlueprintFactory implements Factory<TabBlueprint<? extends FavoritesTab>> {
    public final SearchTabModule a;

    public SearchTabModule_ProvideTabBlueprintFactory(SearchTabModule searchTabModule) {
        this.a = searchTabModule;
    }

    public static SearchTabModule_ProvideTabBlueprintFactory create(SearchTabModule searchTabModule) {
        return new SearchTabModule_ProvideTabBlueprintFactory(searchTabModule);
    }

    public static TabBlueprint<? extends FavoritesTab> provideTabBlueprint(SearchTabModule searchTabModule) {
        return (TabBlueprint) Preconditions.checkNotNullFromProvides(searchTabModule.provideTabBlueprint());
    }

    @Override // javax.inject.Provider
    public TabBlueprint<? extends FavoritesTab> get() {
        return provideTabBlueprint(this.a);
    }
}
