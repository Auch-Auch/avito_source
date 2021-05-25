package com.avito.android.user_favorites.di;

import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.user_favorites.adapter.FavoritesTab;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class UserFavoritesModule_ProvideTabsDataProvider$user_favorites_releaseFactory implements Factory<TabsDataProvider<FavoritesTab>> {

    public static final class a {
        public static final UserFavoritesModule_ProvideTabsDataProvider$user_favorites_releaseFactory a = new UserFavoritesModule_ProvideTabsDataProvider$user_favorites_releaseFactory();
    }

    public static UserFavoritesModule_ProvideTabsDataProvider$user_favorites_releaseFactory create() {
        return a.a;
    }

    public static TabsDataProvider<FavoritesTab> provideTabsDataProvider$user_favorites_release() {
        return (TabsDataProvider) Preconditions.checkNotNullFromProvides(UserFavoritesModule.provideTabsDataProvider$user_favorites_release());
    }

    @Override // javax.inject.Provider
    public TabsDataProvider<FavoritesTab> get() {
        return provideTabsDataProvider$user_favorites_release();
    }
}
