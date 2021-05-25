package com.avito.android.user_favorites;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.cart_fab.CartFabViewModel;
import com.avito.android.cart_fab.CartQuantityChangesHandler;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.design.widget.tab.TabLayoutAdapter;
import com.avito.android.design.widget.tab.TabPagerAdapter;
import com.avito.android.user_favorites.adapter.FavoritesTab;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class UserFavoritesFragment_MembersInjector implements MembersInjector<UserFavoritesFragment> {
    public final Provider<UserFavoritesPresenter> a;
    public final Provider<TabLayoutAdapter<FavoritesTab>> b;
    public final Provider<TabPagerAdapter> c;
    public final Provider<ActivityIntentFactory> d;
    public final Provider<DeepLinkIntentFactory> e;
    public final Provider<CartFabViewModel> f;
    public final Provider<CartQuantityChangesHandler> g;

    public UserFavoritesFragment_MembersInjector(Provider<UserFavoritesPresenter> provider, Provider<TabLayoutAdapter<FavoritesTab>> provider2, Provider<TabPagerAdapter> provider3, Provider<ActivityIntentFactory> provider4, Provider<DeepLinkIntentFactory> provider5, Provider<CartFabViewModel> provider6, Provider<CartQuantityChangesHandler> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static MembersInjector<UserFavoritesFragment> create(Provider<UserFavoritesPresenter> provider, Provider<TabLayoutAdapter<FavoritesTab>> provider2, Provider<TabPagerAdapter> provider3, Provider<ActivityIntentFactory> provider4, Provider<DeepLinkIntentFactory> provider5, Provider<CartFabViewModel> provider6, Provider<CartQuantityChangesHandler> provider7) {
        return new UserFavoritesFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @InjectedFieldSignature("com.avito.android.user_favorites.UserFavoritesFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(UserFavoritesFragment userFavoritesFragment, ActivityIntentFactory activityIntentFactory) {
        userFavoritesFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.user_favorites.UserFavoritesFragment.cartFabViewModel")
    public static void injectCartFabViewModel(UserFavoritesFragment userFavoritesFragment, CartFabViewModel cartFabViewModel) {
        userFavoritesFragment.cartFabViewModel = cartFabViewModel;
    }

    @InjectedFieldSignature("com.avito.android.user_favorites.UserFavoritesFragment.cartQuantityHandler")
    public static void injectCartQuantityHandler(UserFavoritesFragment userFavoritesFragment, CartQuantityChangesHandler cartQuantityChangesHandler) {
        userFavoritesFragment.cartQuantityHandler = cartQuantityChangesHandler;
    }

    @InjectedFieldSignature("com.avito.android.user_favorites.UserFavoritesFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(UserFavoritesFragment userFavoritesFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        userFavoritesFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.user_favorites.UserFavoritesFragment.pagerAdapter")
    public static void injectPagerAdapter(UserFavoritesFragment userFavoritesFragment, TabPagerAdapter tabPagerAdapter) {
        userFavoritesFragment.pagerAdapter = tabPagerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.user_favorites.UserFavoritesFragment.presenter")
    public static void injectPresenter(UserFavoritesFragment userFavoritesFragment, UserFavoritesPresenter userFavoritesPresenter) {
        userFavoritesFragment.presenter = userFavoritesPresenter;
    }

    @InjectedFieldSignature("com.avito.android.user_favorites.UserFavoritesFragment.tabLayoutAdapter")
    public static void injectTabLayoutAdapter(UserFavoritesFragment userFavoritesFragment, TabLayoutAdapter<FavoritesTab> tabLayoutAdapter) {
        userFavoritesFragment.tabLayoutAdapter = tabLayoutAdapter;
    }

    public void injectMembers(UserFavoritesFragment userFavoritesFragment) {
        injectPresenter(userFavoritesFragment, this.a.get());
        injectTabLayoutAdapter(userFavoritesFragment, this.b.get());
        injectPagerAdapter(userFavoritesFragment, this.c.get());
        injectActivityIntentFactory(userFavoritesFragment, this.d.get());
        injectDeepLinkIntentFactory(userFavoritesFragment, this.e.get());
        injectCartFabViewModel(userFavoritesFragment, this.f.get());
        injectCartQuantityHandler(userFavoritesFragment, this.g.get());
    }
}
