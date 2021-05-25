package com.avito.android.favorites;

import a2.b.a.a.a;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AdvertDetailsIntentFactory;
import com.avito.android.Features;
import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.bottom_navigation.ui.fragment.ScrollToUpHandler;
import com.avito.android.common.ConstantsKt;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.favorites.FavoritesListPresenter;
import com.avito.android.favorites.action.FavoriteItemAction;
import com.avito.android.favorites.di.DaggerFavoriteAdvertsComponent;
import com.avito.android.favorites.di.FavoriteAdvertsComponent;
import com.avito.android.favorites.di.FavoriteAdvertsDependencies;
import com.avito.android.favorites.tracker.FavoritesTracker;
import com.avito.android.remote.model.Image;
import com.avito.android.similar_adverts.SimilarAdvertsDialog;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.util.Bundles;
import com.avito.android.util.Kundle;
import com.avito.android.util.MenuWrapper;
import com.avito.android.util.MenuWrapperImpl;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay2.PublishRelay;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\b¢\u0006\u0005\b\u0001\u0010\u0011J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0011J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010\u001f\u001a\u00020\u00172\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0006H\u0016¢\u0006\u0004\b!\u0010\u0011J\u000f\u0010\"\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\"\u0010\u0011J\u000f\u0010#\u001a\u00020\u0006H\u0016¢\u0006\u0004\b#\u0010\u0011J\u000f\u0010$\u001a\u00020\u0006H\u0016¢\u0006\u0004\b$\u0010\u0011J\u001f\u0010(\u001a\u00020\u00062\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u0017H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b,\u0010-JW\u00107\u001a\u00020\u00062\u0006\u0010&\u001a\u00020%2\b\u0010.\u001a\u0004\u0018\u00010%2\u0006\u0010/\u001a\u00020%2\b\u00100\u001a\u0004\u0018\u00010%2\b\u00101\u001a\u0004\u0018\u00010%2\b\u00103\u001a\u0004\u0018\u0001022\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u00020\u0017H\u0016¢\u0006\u0004\b7\u00108J\u0017\u0010:\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u0004H\u0016¢\u0006\u0004\b:\u0010\bJ\u000f\u0010;\u001a\u00020\u0006H\u0016¢\u0006\u0004\b;\u0010\u0011R\"\u0010=\u001a\u00020<8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010D\u001a\u00020C8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010K\u001a\u00020J8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010R\u001a\u00020Q8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\"\u0010Y\u001a\u00020X8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\"\u0010`\u001a\u00020_8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\"\u0010g\u001a\u00020f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\"\u0010n\u001a\u00020m8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\"\u0010u\u001a\u00020t8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bu\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\u0016\u0010~\u001a\u00020{8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b|\u0010}R)\u0010\u0001\u001a\u000208\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0000@\u0000X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X.¢\u0006\b\n\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/favorites/FavoritesFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/favorites/FavoritesListPresenter$Router;", "Lcom/avito/android/bottom_navigation/ui/fragment/ScrollToUpHandler;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onStart", "()V", "onResume", "onPause", "onStop", "Landroid/view/MenuItem;", "item", "", "onOptionsItemSelected", "(Landroid/view/MenuItem;)Z", "Landroid/view/Menu;", "menu", "Landroid/view/MenuInflater;", "onCreateOptionsMenu", "(Landroid/view/Menu;Landroid/view/MenuInflater;)V", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "onDestroyView", "startSync", "startUpload", "startUploadRemoved", "", "itemId", "isShop", "openSimilarAdverts", "(Ljava/lang/String;Z)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "context", "title", "price", "oldPrice", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "isMarketplace", "openFastAdvertDetails", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Z)V", "outState", "onSaveInstanceState", "scrollToUp", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "abTestsConfigProvider", "Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "getAbTestsConfigProvider", "()Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "setAbTestsConfigProvider", "(Lcom/avito/android/ab_tests/AbTestsConfigProvider;)V", "Lcom/avito/android/favorites/FavoriteAdvertsSyncRunner;", "favoriteAdvertsSyncRunner", "Lcom/avito/android/favorites/FavoriteAdvertsSyncRunner;", "getFavoriteAdvertsSyncRunner", "()Lcom/avito/android/favorites/FavoriteAdvertsSyncRunner;", "setFavoriteAdvertsSyncRunner", "(Lcom/avito/android/favorites/FavoriteAdvertsSyncRunner;)V", "Lcom/avito/android/favorites/FavoritesListInteractor;", "interactor", "Lcom/avito/android/favorites/FavoritesListInteractor;", "getInteractor", "()Lcom/avito/android/favorites/FavoritesListInteractor;", "setInteractor", "(Lcom/avito/android/favorites/FavoritesListInteractor;)V", "Lcom/avito/android/favorites/FavoritesListPresenter;", "presenter", "Lcom/avito/android/favorites/FavoritesListPresenter;", "getPresenter", "()Lcom/avito/android/favorites/FavoritesListPresenter;", "setPresenter", "(Lcom/avito/android/favorites/FavoritesListPresenter;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/android/favorites/FavoritesView;", "j", "Lcom/avito/android/favorites/FavoritesView;", "favoriteView", "Lcom/avito/android/favorites/tracker/FavoritesTracker;", "tracker", "Lcom/avito/android/favorites/tracker/FavoritesTracker;", "getTracker", "()Lcom/avito/android/favorites/tracker/FavoritesTracker;", "setTracker", "(Lcom/avito/android/favorites/tracker/FavoritesTracker;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics$favorites_release", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics$favorites_release", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/util/MenuWrapper;", "k", "Lcom/avito/android/util/MenuWrapper;", "menuWrapper", "<init>", "favorites_release"}, k = 1, mv = {1, 4, 2})
public final class FavoritesFragment extends TabBaseFragment implements FavoritesListPresenter.Router, ScrollToUpHandler {
    @Inject
    public AbTestsConfigProvider abTestsConfigProvider;
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public FavoriteAdvertsSyncRunner favoriteAdvertsSyncRunner;
    @Inject
    public Features features;
    @Inject
    public FavoritesListInteractor interactor;
    @Inject
    public ItemBinder itemBinder;
    public FavoritesView j;
    public MenuWrapper k;
    @Inject
    public FavoritesListPresenter presenter;
    @Inject
    public FavoritesTracker tracker;

    @Override // com.avito.android.favorites.FavoritesListPresenter.Router
    public void followDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            startActivity(intent);
        }
    }

    @NotNull
    public final AbTestsConfigProvider getAbTestsConfigProvider() {
        AbTestsConfigProvider abTestsConfigProvider2 = this.abTestsConfigProvider;
        if (abTestsConfigProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("abTestsConfigProvider");
        }
        return abTestsConfigProvider2;
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
    public final AdapterPresenter getAdapterPresenter() {
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return adapterPresenter2;
    }

    @NotNull
    public final Analytics getAnalytics$favorites_release() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
    }

    @NotNull
    public final FavoriteAdvertsSyncRunner getFavoriteAdvertsSyncRunner() {
        FavoriteAdvertsSyncRunner favoriteAdvertsSyncRunner2 = this.favoriteAdvertsSyncRunner;
        if (favoriteAdvertsSyncRunner2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteAdvertsSyncRunner");
        }
        return favoriteAdvertsSyncRunner2;
    }

    @NotNull
    public final Features getFeatures() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        return features2;
    }

    @NotNull
    public final FavoritesListInteractor getInteractor() {
        FavoritesListInteractor favoritesListInteractor = this.interactor;
        if (favoritesListInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        return favoritesListInteractor;
    }

    @NotNull
    public final ItemBinder getItemBinder() {
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        return itemBinder2;
    }

    @NotNull
    public final FavoritesListPresenter getPresenter() {
        FavoritesListPresenter favoritesListPresenter = this.presenter;
        if (favoritesListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return favoritesListPresenter;
    }

    @NotNull
    public final FavoritesTracker getTracker() {
        FavoritesTracker favoritesTracker = this.tracker;
        if (favoritesTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        return favoritesTracker;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        if (bundle == null) {
            Features features2 = this.features;
            if (features2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("features");
            }
            if (features2.getByuerAsksSellerTtlItem().invoke().booleanValue()) {
                AbTestsConfigProvider abTestsConfigProvider2 = this.abTestsConfigProvider;
                if (abTestsConfigProvider2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("abTestsConfigProvider");
                }
                abTestsConfigProvider2.buyerAsksSellerTtlItem().expose();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(@NotNull Menu menu, @NotNull MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        MenuWrapper menuWrapper = this.k;
        if (menuWrapper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("menuWrapper");
        }
        menuWrapper.onCreateMenu(menu, menuInflater);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FavoritesTracker favoritesTracker = this.tracker;
        if (favoritesTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        favoritesTracker.startInit();
        if (bundle != null) {
            FavoritesListPresenter favoritesListPresenter = this.presenter;
            if (favoritesListPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            favoritesListPresenter.onRestoreState();
        }
        View inflate = layoutInflater.inflate(R.layout.favorites_list, viewGroup, false);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        MenuWrapperImpl menuWrapperImpl = new MenuWrapperImpl(requireActivity);
        this.k = menuWrapperImpl;
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) inflate;
        if (menuWrapperImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("menuWrapper");
        }
        FavoritesListPresenter favoritesListPresenter2 = this.presenter;
        if (favoritesListPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        Bundle arguments = getArguments();
        Integer num = null;
        if (arguments != null && arguments.containsKey(ConstantsKt.KEY_LIST_BOTTOM_PADDING)) {
            num = Integer.valueOf(arguments.getInt(ConstantsKt.KEY_LIST_BOTTOM_PADDING));
        }
        this.j = new FavoritesViewImpl(viewGroup2, menuWrapperImpl, favoritesListPresenter2, adapterPresenter2, itemBinder2, analytics2, num);
        FavoritesListPresenter favoritesListPresenter3 = this.presenter;
        if (favoritesListPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        FavoritesView favoritesView = this.j;
        if (favoritesView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteView");
        }
        favoritesListPresenter3.attachView(favoritesView);
        FavoritesTracker favoritesTracker2 = this.tracker;
        if (favoritesTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        favoritesTracker2.trackInit();
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        FavoritesListPresenter favoritesListPresenter = this.presenter;
        if (favoritesListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        favoritesListPresenter.detachView();
        MenuWrapper menuWrapper = this.k;
        if (menuWrapper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("menuWrapper");
        }
        menuWrapper.clear();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        MenuWrapper menuWrapper = this.k;
        if (menuWrapper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("menuWrapper");
        }
        menuWrapper.onItemClicked(menuItem);
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        FavoritesListPresenter favoritesListPresenter = this.presenter;
        if (favoritesListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        favoritesListPresenter.onVisibilityChanged(false);
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        FavoritesListPresenter favoritesListPresenter = this.presenter;
        if (favoritesListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        favoritesListPresenter.onVisibilityChanged(true);
        super.onResume();
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        FavoritesListPresenter favoritesListPresenter = this.presenter;
        if (favoritesListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "presenter_state", favoritesListPresenter.onSaveState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        FavoritesListPresenter favoritesListPresenter = this.presenter;
        if (favoritesListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        favoritesListPresenter.attachRouter(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        FavoritesListPresenter favoritesListPresenter = this.presenter;
        if (favoritesListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        favoritesListPresenter.detachRouter();
        super.onStop();
    }

    @Override // com.avito.android.favorites.FavoritesListPresenter.Router
    public void openFastAdvertDetails(@NotNull String str, @Nullable String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable Image image, @NotNull TreeClickStreamParent treeClickStreamParent, boolean z) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(str3, "title");
        Intrinsics.checkNotNullParameter(treeClickStreamParent, "treeParent");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(AdvertDetailsIntentFactory.DefaultImpls.advertDetailsIntent$default(activityIntentFactory2, str, str2, str3, str4, str5, image, z, treeClickStreamParent, SystemClock.elapsedRealtime(), null, currentTab(), null, 2560, null));
    }

    @Override // com.avito.android.favorites.FavoritesListPresenter.Router
    public void openSimilarAdverts(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        SimilarAdvertsDialog.Companion.createInstance(str, z).show(getChildFragmentManager(), (String) null);
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.ScrollToUpHandler
    public void scrollToUp() {
        FavoritesView favoritesView = this.j;
        if (favoritesView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteView");
        }
        favoritesView.scrollToTop();
    }

    public final void setAbTestsConfigProvider(@NotNull AbTestsConfigProvider abTestsConfigProvider2) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider2, "<set-?>");
        this.abTestsConfigProvider = abTestsConfigProvider2;
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setAnalytics$favorites_release(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setFavoriteAdvertsSyncRunner(@NotNull FavoriteAdvertsSyncRunner favoriteAdvertsSyncRunner2) {
        Intrinsics.checkNotNullParameter(favoriteAdvertsSyncRunner2, "<set-?>");
        this.favoriteAdvertsSyncRunner = favoriteAdvertsSyncRunner2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setInteractor(@NotNull FavoritesListInteractor favoritesListInteractor) {
        Intrinsics.checkNotNullParameter(favoritesListInteractor, "<set-?>");
        this.interactor = favoritesListInteractor;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setPresenter(@NotNull FavoritesListPresenter favoritesListPresenter) {
        Intrinsics.checkNotNullParameter(favoritesListPresenter, "<set-?>");
        this.presenter = favoritesListPresenter;
    }

    public final void setTracker(@NotNull FavoritesTracker favoritesTracker) {
        Intrinsics.checkNotNullParameter(favoritesTracker, "<set-?>");
        this.tracker = favoritesTracker;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Timer B1 = a.B1();
        Kundle kundle = bundle != null ? Bundles.getKundle(bundle, "presenter_state") : null;
        FavoriteAdvertsComponent.Builder dependentOn = DaggerFavoriteAdvertsComponent.builder().dependentOn((FavoriteAdvertsDependencies) ComponentDependenciesKt.getDependencies(FavoriteAdvertsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)));
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        FavoriteAdvertsComponent.Builder withResources = dependentOn.withResources(resources);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        FavoriteAdvertsComponent.Builder withContext = withResources.withContext(requireContext);
        PublishRelay<FavoriteItemAction> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        withContext.withActionRelay(create).withPresenterState(kundle).build().inject(this);
        FavoritesTracker favoritesTracker = this.tracker;
        if (favoritesTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        favoritesTracker.trackDiInject(B1.elapsed());
        return true;
    }

    @Override // com.avito.android.favorites.FavoritesListPresenter.Router
    public void startSync() {
        FavoriteAdvertsSyncRunner favoriteAdvertsSyncRunner2 = this.favoriteAdvertsSyncRunner;
        if (favoriteAdvertsSyncRunner2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteAdvertsSyncRunner");
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        favoriteAdvertsSyncRunner2.startSync(requireContext);
    }

    @Override // com.avito.android.favorites.FavoritesListPresenter.Router
    public void startUpload() {
        FavoriteAdvertsSyncRunner favoriteAdvertsSyncRunner2 = this.favoriteAdvertsSyncRunner;
        if (favoriteAdvertsSyncRunner2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteAdvertsSyncRunner");
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        favoriteAdvertsSyncRunner2.startUpload(requireContext);
    }

    @Override // com.avito.android.favorites.FavoritesListPresenter.Router
    public void startUploadRemoved() {
        FavoriteAdvertsSyncRunner favoriteAdvertsSyncRunner2 = this.favoriteAdvertsSyncRunner;
        if (favoriteAdvertsSyncRunner2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteAdvertsSyncRunner");
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        favoriteAdvertsSyncRunner2.startUploadRemoved(requireContext);
    }
}
