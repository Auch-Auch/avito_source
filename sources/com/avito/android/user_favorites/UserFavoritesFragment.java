package com.avito.android.user_favorites;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.bottom_navigation.NavigationTabSetItem;
import com.avito.android.bottom_navigation.ui.fragment.ScrollToUpHandler;
import com.avito.android.bottom_navigation.ui.fragment.TabRootFragment;
import com.avito.android.cart_fab.CartFabView;
import com.avito.android.cart_fab.CartFabViewModel;
import com.avito.android.cart_fab.CartFloatingActionButton;
import com.avito.android.cart_fab.CartQuantityChangesHandler;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deprecated_design.R;
import com.avito.android.design.widget.tab.TabLayoutAdapter;
import com.avito.android.design.widget.tab.TabPagerAdapter;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.user_favorites.adapter.FavoritesTab;
import com.avito.android.user_favorites.di.DaggerUserFavoritesComponent;
import com.avito.android.user_favorites.di.UserFavoritesDependencies;
import com.avito.android.util.Bundles;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b`\u0010\u0015J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J!\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0011H\u0016¢\u0006\u0004\b#\u0010\u0015J)\u0010(\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u00172\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b(\u0010)R\"\u0010+\u001a\u00020*8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00102\u001a\u0002018\u0006@\u0006X.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00109\u001a\u0002088\u0006@\u0006X.¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010@\u001a\u00020?8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020F8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bG\u0010HR(\u0010L\u001a\b\u0012\u0004\u0012\u00020K0J8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\"\u0010S\u001a\u00020R8\u0000@\u0000X.¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\"\u0010Z\u001a\u00020Y8\u0000@\u0000X.¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_¨\u0006a"}, d2 = {"Lcom/avito/android/user_favorites/UserFavoritesFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/bottom_navigation/ui/fragment/TabRootFragment;", "Lcom/avito/android/bottom_navigation/ui/fragment/ScrollToUpHandler;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "()V", "onResume", "", "tab", "", "subscriptionId", "changeTab", "(ILjava/lang/String;)V", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "isRoot", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)Z", "scrollToUp", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Lcom/avito/android/user_favorites/UserFavoritesPresenter;", "presenter", "Lcom/avito/android/user_favorites/UserFavoritesPresenter;", "getPresenter", "()Lcom/avito/android/user_favorites/UserFavoritesPresenter;", "setPresenter", "(Lcom/avito/android/user_favorites/UserFavoritesPresenter;)V", "Lcom/avito/android/design/widget/tab/TabPagerAdapter;", "pagerAdapter", "Lcom/avito/android/design/widget/tab/TabPagerAdapter;", "getPagerAdapter", "()Lcom/avito/android/design/widget/tab/TabPagerAdapter;", "setPagerAdapter", "(Lcom/avito/android/design/widget/tab/TabPagerAdapter;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory$user_favorites_release", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory$user_favorites_release", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/user_favorites/UserFavoritesView;", "j", "Lcom/avito/android/user_favorites/UserFavoritesView;", "userFavoritesView", "Lcom/avito/android/design/widget/tab/TabLayoutAdapter;", "Lcom/avito/android/user_favorites/adapter/FavoritesTab;", "tabLayoutAdapter", "Lcom/avito/android/design/widget/tab/TabLayoutAdapter;", "getTabLayoutAdapter", "()Lcom/avito/android/design/widget/tab/TabLayoutAdapter;", "setTabLayoutAdapter", "(Lcom/avito/android/design/widget/tab/TabLayoutAdapter;)V", "Lcom/avito/android/cart_fab/CartFabViewModel;", "cartFabViewModel", "Lcom/avito/android/cart_fab/CartFabViewModel;", "getCartFabViewModel$user_favorites_release", "()Lcom/avito/android/cart_fab/CartFabViewModel;", "setCartFabViewModel$user_favorites_release", "(Lcom/avito/android/cart_fab/CartFabViewModel;)V", "Lcom/avito/android/cart_fab/CartQuantityChangesHandler;", "cartQuantityHandler", "Lcom/avito/android/cart_fab/CartQuantityChangesHandler;", "getCartQuantityHandler$user_favorites_release", "()Lcom/avito/android/cart_fab/CartQuantityChangesHandler;", "setCartQuantityHandler$user_favorites_release", "(Lcom/avito/android/cart_fab/CartQuantityChangesHandler;)V", "<init>", "user-favorites_release"}, k = 1, mv = {1, 4, 2})
public final class UserFavoritesFragment extends TabBaseFragment implements TabRootFragment, ScrollToUpHandler {
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public CartFabViewModel cartFabViewModel;
    @Inject
    public CartQuantityChangesHandler cartQuantityHandler;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    public UserFavoritesView j;
    @Inject
    public TabPagerAdapter pagerAdapter;
    @Inject
    public UserFavoritesPresenter presenter;
    @Inject
    public TabLayoutAdapter<FavoritesTab> tabLayoutAdapter;

    public static /* synthetic */ void changeTab$default(UserFavoritesFragment userFavoritesFragment, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        userFavoritesFragment.changeTab(i, str);
    }

    public final void changeTab(int i, @Nullable String str) {
        UserFavoritesPresenter userFavoritesPresenter = this.presenter;
        if (userFavoritesPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        userFavoritesPresenter.changeTab(i);
        if (str != null) {
            ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
            if (activityIntentFactory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
            }
            startActivityForResult(activityIntentFactory2.searchSubscriptionIntent(str), 1000);
        }
    }

    @NotNull
    public final ActivityIntentFactory getActivityIntentFactory() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        return activityIntentFactory2;
    }

    @NotNull
    public final CartFabViewModel getCartFabViewModel$user_favorites_release() {
        CartFabViewModel cartFabViewModel2 = this.cartFabViewModel;
        if (cartFabViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartFabViewModel");
        }
        return cartFabViewModel2;
    }

    @NotNull
    public final CartQuantityChangesHandler getCartQuantityHandler$user_favorites_release() {
        CartQuantityChangesHandler cartQuantityChangesHandler = this.cartQuantityHandler;
        if (cartQuantityChangesHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartQuantityHandler");
        }
        return cartQuantityChangesHandler;
    }

    @NotNull
    public final DeepLinkIntentFactory getDeepLinkIntentFactory$user_favorites_release() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
    }

    @NotNull
    public final TabPagerAdapter getPagerAdapter() {
        TabPagerAdapter tabPagerAdapter = this.pagerAdapter;
        if (tabPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        }
        return tabPagerAdapter;
    }

    @NotNull
    public final UserFavoritesPresenter getPresenter() {
        UserFavoritesPresenter userFavoritesPresenter = this.presenter;
        if (userFavoritesPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return userFavoritesPresenter;
    }

    @NotNull
    public final TabLayoutAdapter<FavoritesTab> getTabLayoutAdapter() {
        TabLayoutAdapter<FavoritesTab> tabLayoutAdapter2 = this.tabLayoutAdapter;
        if (tabLayoutAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayoutAdapter");
        }
        return tabLayoutAdapter2;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.TabRootFragment
    public boolean isRoot(@NotNull NavigationTabSetItem navigationTabSetItem) {
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
        return Intrinsics.areEqual(navigationTabSetItem, NavigationTab.FAVORITES.INSTANCE);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i == 1000) {
            UserFavoritesView userFavoritesView = this.j;
            if (userFavoritesView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userFavoritesView");
            }
            userFavoritesView.notifyTabsChanged();
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.user_favorites_tab, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        UserFavoritesPresenter userFavoritesPresenter = this.presenter;
        if (userFavoritesPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        userFavoritesPresenter.detachView();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        UserFavoritesPresenter userFavoritesPresenter = this.presenter;
        if (userFavoritesPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        userFavoritesPresenter.onResume();
        CartFabViewModel cartFabViewModel2 = this.cartFabViewModel;
        if (cartFabViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartFabViewModel");
        }
        cartFabViewModel2.loadCartSize();
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        UserFavoritesPresenter userFavoritesPresenter = this.presenter;
        if (userFavoritesPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "presenter_state", userFavoritesPresenter.onSaveState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        String string;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        setSupportActionBar((Toolbar) findViewById);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(com.avito.android.app.core.R.string.favorites);
        }
        TabLayoutAdapter<FavoritesTab> tabLayoutAdapter2 = this.tabLayoutAdapter;
        if (tabLayoutAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayoutAdapter");
        }
        TabPagerAdapter tabPagerAdapter = this.pagerAdapter;
        if (tabPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        }
        this.j = new UserFavoritesViewImpl(view, tabLayoutAdapter2, tabPagerAdapter);
        UserFavoritesPresenter userFavoritesPresenter = this.presenter;
        if (userFavoritesPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        UserFavoritesView userFavoritesView = this.j;
        if (userFavoritesView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userFavoritesView");
        }
        userFavoritesPresenter.attachView(userFavoritesView);
        if (features().getCartFloatingActionButton().invoke().booleanValue()) {
            View findViewById2 = view.findViewById(R.id.cart_fab_stub);
            Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.ViewStub");
            View inflate = ((ViewStub) findViewById2).inflate();
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type com.avito.android.cart_fab.CartFloatingActionButton");
            CartFloatingActionButton cartFloatingActionButton = (CartFloatingActionButton) inflate;
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
            CartFabViewModel cartFabViewModel2 = this.cartFabViewModel;
            if (cartFabViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cartFabViewModel");
            }
            CartQuantityChangesHandler cartQuantityChangesHandler = this.cartQuantityHandler;
            if (cartQuantityChangesHandler == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cartQuantityHandler");
            }
            DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
            if (deepLinkIntentFactory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
            }
            new CartFabView(cartFloatingActionButton, viewLifecycleOwner, cartFabViewModel2, cartQuantityChangesHandler, deepLinkIntentFactory2);
        }
        Bundle arguments = getArguments();
        if (arguments != null && (string = arguments.getString("subscription_id")) != null) {
            Intrinsics.checkNotNullExpressionValue(string, "it");
            ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
            if (activityIntentFactory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
            }
            startActivityForResult(activityIntentFactory2.searchSubscriptionIntent(string), 1000);
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                arguments2.remove("subscription_id");
            }
        }
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.ScrollToUpHandler
    public void scrollToUp() {
        UserFavoritesView userFavoritesView = this.j;
        if (userFavoritesView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userFavoritesView");
        }
        userFavoritesView.scrollToTop();
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setCartFabViewModel$user_favorites_release(@NotNull CartFabViewModel cartFabViewModel2) {
        Intrinsics.checkNotNullParameter(cartFabViewModel2, "<set-?>");
        this.cartFabViewModel = cartFabViewModel2;
    }

    public final void setCartQuantityHandler$user_favorites_release(@NotNull CartQuantityChangesHandler cartQuantityChangesHandler) {
        Intrinsics.checkNotNullParameter(cartQuantityChangesHandler, "<set-?>");
        this.cartQuantityHandler = cartQuantityChangesHandler;
    }

    public final void setDeepLinkIntentFactory$user_favorites_release(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setPagerAdapter(@NotNull TabPagerAdapter tabPagerAdapter) {
        Intrinsics.checkNotNullParameter(tabPagerAdapter, "<set-?>");
        this.pagerAdapter = tabPagerAdapter;
    }

    public final void setPresenter(@NotNull UserFavoritesPresenter userFavoritesPresenter) {
        Intrinsics.checkNotNullParameter(userFavoritesPresenter, "<set-?>");
        this.presenter = userFavoritesPresenter;
    }

    public final void setTabLayoutAdapter(@NotNull TabLayoutAdapter<FavoritesTab> tabLayoutAdapter2) {
        Intrinsics.checkNotNullParameter(tabLayoutAdapter2, "<set-?>");
        this.tabLayoutAdapter = tabLayoutAdapter2;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        int i = 0;
        if (arguments != null) {
            i = arguments.getInt("start_tab", 0);
        }
        DaggerUserFavoritesComponent.builder().dependentOn((UserFavoritesDependencies) ComponentDependenciesKt.getDependencies(UserFavoritesDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).with(bundle != null ? Bundles.getKundle(bundle, "presenter_state") : null).with(this).with(i).build().inject(this);
        return true;
    }
}
