package com.avito.android.user_favorites;

import com.avito.android.ab_tests.groups.ViewedItemsTabTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.user_favorites.adapter.FavoritesTab;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UserFavoritesPresenterImpl_Factory implements Factory<UserFavoritesPresenterImpl> {
    public final Provider<UserFavoritesInteractor> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<TabsDataProvider<FavoritesTab>> c;
    public final Provider<Analytics> d;
    public final Provider<SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup>> e;
    public final Provider<Integer> f;
    public final Provider<Kundle> g;

    public UserFavoritesPresenterImpl_Factory(Provider<UserFavoritesInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<TabsDataProvider<FavoritesTab>> provider3, Provider<Analytics> provider4, Provider<SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup>> provider5, Provider<Integer> provider6, Provider<Kundle> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static UserFavoritesPresenterImpl_Factory create(Provider<UserFavoritesInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<TabsDataProvider<FavoritesTab>> provider3, Provider<Analytics> provider4, Provider<SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup>> provider5, Provider<Integer> provider6, Provider<Kundle> provider7) {
        return new UserFavoritesPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static UserFavoritesPresenterImpl newInstance(UserFavoritesInteractor userFavoritesInteractor, SchedulersFactory3 schedulersFactory3, TabsDataProvider<FavoritesTab> tabsDataProvider, Analytics analytics, SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup> singleManuallyExposedAbTestGroup, int i, Kundle kundle) {
        return new UserFavoritesPresenterImpl(userFavoritesInteractor, schedulersFactory3, tabsDataProvider, analytics, singleManuallyExposedAbTestGroup, i, kundle);
    }

    @Override // javax.inject.Provider
    public UserFavoritesPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get().intValue(), this.g.get());
    }
}
