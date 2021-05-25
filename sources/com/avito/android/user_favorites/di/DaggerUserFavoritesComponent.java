package com.avito.android.user_favorites.di;

import android.content.Context;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.cart_fab.CartFabModule_ProvideCartFabViewModelFactory;
import com.avito.android.cart_fab.CartFabPreferences;
import com.avito.android.cart_fab.CartFabPreferencesImpl;
import com.avito.android.cart_fab.CartFabPreferencesImpl_Factory;
import com.avito.android.cart_fab.CartFabQuantityVisibilityHandler_Factory;
import com.avito.android.cart_fab.CartFabRepository;
import com.avito.android.cart_fab.CartFabRepositoryImpl;
import com.avito.android.cart_fab.CartFabRepositoryImpl_Factory;
import com.avito.android.cart_fab.CartFabViewModel;
import com.avito.android.cart_fab.CartFabViewModelFactory;
import com.avito.android.cart_fab.CartFabViewModelFactory_Factory;
import com.avito.android.cart_fab.CartQuantityChangesHandler;
import com.avito.android.common.CounterInteractor;
import com.avito.android.db.SearchSubscriptionDao;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.design.widget.tab.TabBlueprint;
import com.avito.android.design.widget.tab.TabLayoutAdapter;
import com.avito.android.design.widget.tab.TabPagerAdapter;
import com.avito.android.preferences.UserFavoritesStorage;
import com.avito.android.remote.cart.CartApi;
import com.avito.android.search.subscriptions.SearchSubscriptionObservable;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.user_favorites.UserFavoritesFragment;
import com.avito.android.user_favorites.UserFavoritesFragment_MembersInjector;
import com.avito.android.user_favorites.UserFavoritesInteractorImpl;
import com.avito.android.user_favorites.UserFavoritesPresenterImpl;
import com.avito.android.user_favorites.UserFavoritesResourceProviderImpl;
import com.avito.android.user_favorites.adapter.FavoritesTab;
import com.avito.android.user_favorites.adapter.items.di.ItemsTabModule;
import com.avito.android.user_favorites.adapter.items.di.ItemsTabModule_ProvideTabBlueprintFactory;
import com.avito.android.user_favorites.adapter.search.di.SearchTabModule;
import com.avito.android.user_favorites.adapter.search.di.SearchTabModule_ProvideTabBlueprintFactory;
import com.avito.android.user_favorites.adapter.sellers.di.SellersTabModule;
import com.avito.android.user_favorites.adapter.sellers.di.SellersTabModule_ProvideTabBlueprintFactory;
import com.avito.android.user_favorites.adapter.viewed_items.di.ViewedItemsTabModule;
import com.avito.android.user_favorites.adapter.viewed_items.di.ViewedItemsTabModule_ProvideTabBlueprintFactory;
import com.avito.android.user_favorites.di.UserFavoritesComponent;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.SearchContextWrapper;
import com.avito.android.util.preferences.Preferences;
import com.avito.android.viewed_items.ViewedItemsCountInteractor;
import com.google.common.base.Optional;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerUserFavoritesComponent implements UserFavoritesComponent {
    public static final Provider D = InstanceFactory.create(Optional.absent());
    public Provider<CartFabViewModelFactory> A;
    public Provider<CartFabViewModel> B;
    public Provider<CartQuantityChangesHandler> C;
    public final UserFavoritesDependencies a;
    public final Integer b;
    public final Kundle c;
    public Provider<Fragment> d;
    public Provider<Resources> e;
    public Provider<TabsDataProvider<FavoritesTab>> f = DoubleCheck.provider(UserFavoritesModule_ProvideTabsDataProvider$user_favorites_releaseFactory.create());
    public Provider<Context> g;
    public Provider<TabLayoutAdapter<FavoritesTab>> h;
    public Provider<FragmentManager> i;
    public Provider<TabBlueprint<? extends FavoritesTab>> j;
    public Provider<TabBlueprint<? extends FavoritesTab>> k;
    public Provider<TabBlueprint<? extends FavoritesTab>> l;
    public Provider<TabBlueprint<? extends FavoritesTab>> m;
    public Provider<Set<TabBlueprint<? extends FavoritesTab>>> n;
    public Provider<TabPagerAdapter> o;
    public Provider<Features> p;
    public Provider<CartApi> q;
    public Provider<SchedulersFactory3> r;
    public Provider<CartFabRepositoryImpl> s;
    public Provider<CartFabRepository> t;
    public Provider<Preferences> u;
    public Provider<CartFabPreferencesImpl> v;
    public Provider<CartFabPreferences> w;
    public Provider<AccountStateProvider> x;
    public Provider<Analytics> y;
    public Provider<Optional<SearchContextWrapper>> z;

    public static final class b implements UserFavoritesComponent.Builder {
        public UserFavoritesDependencies a;
        public Kundle b;
        public Fragment c;
        public Integer d;

        public b(a aVar) {
        }

        @Override // com.avito.android.user_favorites.di.UserFavoritesComponent.Builder
        public UserFavoritesComponent build() {
            Preconditions.checkBuilderRequirement(this.a, UserFavoritesDependencies.class);
            Preconditions.checkBuilderRequirement(this.c, Fragment.class);
            Preconditions.checkBuilderRequirement(this.d, Integer.class);
            return new DaggerUserFavoritesComponent(new ItemsTabModule(), new SearchTabModule(), new SellersTabModule(), new ViewedItemsTabModule(), this.a, this.b, this.c, this.d, null);
        }

        @Override // com.avito.android.user_favorites.di.UserFavoritesComponent.Builder
        public UserFavoritesComponent.Builder dependentOn(UserFavoritesDependencies userFavoritesDependencies) {
            this.a = (UserFavoritesDependencies) Preconditions.checkNotNull(userFavoritesDependencies);
            return this;
        }

        @Override // com.avito.android.user_favorites.di.UserFavoritesComponent.Builder
        public UserFavoritesComponent.Builder with(Kundle kundle) {
            this.b = kundle;
            return this;
        }

        @Override // com.avito.android.user_favorites.di.UserFavoritesComponent.Builder
        public UserFavoritesComponent.Builder with(Fragment fragment) {
            this.c = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }

        @Override // com.avito.android.user_favorites.di.UserFavoritesComponent.Builder
        public UserFavoritesComponent.Builder with(int i) {
            this.d = (Integer) Preconditions.checkNotNull(Integer.valueOf(i));
            return this;
        }
    }

    public static class c implements Provider<AccountStateProvider> {
        public final UserFavoritesDependencies a;

        public c(UserFavoritesDependencies userFavoritesDependencies) {
            this.a = userFavoritesDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class d implements Provider<Analytics> {
        public final UserFavoritesDependencies a;

        public d(UserFavoritesDependencies userFavoritesDependencies) {
            this.a = userFavoritesDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class e implements Provider<CartApi> {
        public final UserFavoritesDependencies a;

        public e(UserFavoritesDependencies userFavoritesDependencies) {
            this.a = userFavoritesDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CartApi get() {
            return (CartApi) Preconditions.checkNotNullFromComponent(this.a.cartApi());
        }
    }

    public static class f implements Provider<Features> {
        public final UserFavoritesDependencies a;

        public f(UserFavoritesDependencies userFavoritesDependencies) {
            this.a = userFavoritesDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class g implements Provider<Preferences> {
        public final UserFavoritesDependencies a;

        public g(UserFavoritesDependencies userFavoritesDependencies) {
            this.a = userFavoritesDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Preferences get() {
            return (Preferences) Preconditions.checkNotNullFromComponent(this.a.preferences());
        }
    }

    public static class h implements Provider<SchedulersFactory3> {
        public final UserFavoritesDependencies a;

        public h(UserFavoritesDependencies userFavoritesDependencies) {
            this.a = userFavoritesDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public DaggerUserFavoritesComponent(ItemsTabModule itemsTabModule, SearchTabModule searchTabModule, SellersTabModule sellersTabModule, ViewedItemsTabModule viewedItemsTabModule, UserFavoritesDependencies userFavoritesDependencies, Kundle kundle, Fragment fragment, Integer num, a aVar) {
        this.a = userFavoritesDependencies;
        this.b = num;
        this.c = kundle;
        Factory create = InstanceFactory.create(fragment);
        this.d = create;
        this.e = DoubleCheck.provider(UserFavoritesModule_ProvideResourceFactory.create(create));
        Provider<Context> provider = DoubleCheck.provider(UserFavoritesModule_ProvideContextFactory.create(this.d));
        this.g = provider;
        this.h = DoubleCheck.provider(UserFavoritesModule_ProvideTabsLayout$user_favorites_releaseFactory.create(this.f, provider));
        this.i = DoubleCheck.provider(UserFavoritesModule_ProvideFragmentManagerFactory.create(this.d));
        this.j = DoubleCheck.provider(ItemsTabModule_ProvideTabBlueprintFactory.create(itemsTabModule));
        this.k = DoubleCheck.provider(SearchTabModule_ProvideTabBlueprintFactory.create(searchTabModule));
        this.l = DoubleCheck.provider(SellersTabModule_ProvideTabBlueprintFactory.create(sellersTabModule));
        this.m = DoubleCheck.provider(ViewedItemsTabModule_ProvideTabBlueprintFactory.create(viewedItemsTabModule));
        SetFactory build = SetFactory.builder(4, 0).addProvider(this.j).addProvider(this.k).addProvider(this.l).addProvider(this.m).build();
        this.n = build;
        this.o = DoubleCheck.provider(UserFavoritesModule_ProvideTabPagerAdapter$user_favorites_releaseFactory.create(this.i, this.f, build));
        this.p = new f(userFavoritesDependencies);
        e eVar = new e(userFavoritesDependencies);
        this.q = eVar;
        h hVar = new h(userFavoritesDependencies);
        this.r = hVar;
        CartFabRepositoryImpl_Factory create2 = CartFabRepositoryImpl_Factory.create(eVar, hVar);
        this.s = create2;
        this.t = SingleCheck.provider(create2);
        g gVar = new g(userFavoritesDependencies);
        this.u = gVar;
        CartFabPreferencesImpl_Factory create3 = CartFabPreferencesImpl_Factory.create(gVar);
        this.v = create3;
        Provider<CartFabPreferences> provider2 = SingleCheck.provider(create3);
        this.w = provider2;
        c cVar = new c(userFavoritesDependencies);
        this.x = cVar;
        d dVar = new d(userFavoritesDependencies);
        this.y = dVar;
        Provider<Optional<SearchContextWrapper>> provider3 = D;
        this.z = provider3;
        CartFabViewModelFactory_Factory create4 = CartFabViewModelFactory_Factory.create(this.p, this.t, provider2, cVar, this.r, dVar, provider3);
        this.A = create4;
        this.B = SingleCheck.provider(CartFabModule_ProvideCartFabViewModelFactory.create(this.d, create4));
        this.C = SingleCheck.provider(CartFabQuantityVisibilityHandler_Factory.create());
    }

    public static UserFavoritesComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.user_favorites.di.UserFavoritesComponent
    public void inject(UserFavoritesFragment userFavoritesFragment) {
        UserFavoritesFragment_MembersInjector.injectPresenter(userFavoritesFragment, new UserFavoritesPresenterImpl(new UserFavoritesInteractorImpl((AccountStorageInteractor) Preconditions.checkNotNullFromComponent(this.a.accountStorageInteractor()), new UserFavoritesResourceProviderImpl(this.e.get()), (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3()), (SearchSubscriptionDao) Preconditions.checkNotNullFromComponent(this.a.searchSubscriptionDao()), (CounterInteractor) Preconditions.checkNotNullFromComponent(this.a.favoriteSellersCounterProvider()), (CounterInteractor) Preconditions.checkNotNullFromComponent(this.a.favoritesCounterInteractor()), (SearchSubscriptionObservable) Preconditions.checkNotNullFromComponent(this.a.searchSubscriptionObservable()), (SingleManuallyExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.viewedItemsTestGroup()), (ViewedItemsCountInteractor) Preconditions.checkNotNullFromComponent(this.a.viewedItemsCountInteractor()), (UserFavoritesStorage) Preconditions.checkNotNullFromComponent(this.a.userFavoritesStorage()), (Features) Preconditions.checkNotNullFromComponent(this.a.features())), (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3()), this.f.get(), (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()), (SingleManuallyExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.viewedItemsTestGroup()), this.b.intValue(), this.c));
        UserFavoritesFragment_MembersInjector.injectTabLayoutAdapter(userFavoritesFragment, this.h.get());
        UserFavoritesFragment_MembersInjector.injectPagerAdapter(userFavoritesFragment, this.o.get());
        UserFavoritesFragment_MembersInjector.injectActivityIntentFactory(userFavoritesFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        UserFavoritesFragment_MembersInjector.injectDeepLinkIntentFactory(userFavoritesFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        UserFavoritesFragment_MembersInjector.injectCartFabViewModel(userFavoritesFragment, this.B.get());
        UserFavoritesFragment_MembersInjector.injectCartQuantityHandler(userFavoritesFragment, this.C.get());
    }
}
