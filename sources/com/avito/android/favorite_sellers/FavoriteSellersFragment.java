package com.avito.android.favorite_sellers;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AdvertDetailsIntentFactory;
import com.avito.android.Features;
import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.favorite.SubscriptionSource;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.bottom_navigation.ui.fragment.ScrollToUpHandler;
import com.avito.android.common.ConstantsKt;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.favorite_sellers.FavoriteSellersPresenter;
import com.avito.android.favorite_sellers.action.FavoriteSellersItemAction;
import com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemPresenter;
import com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenter;
import com.avito.android.favorite_sellers.di.DaggerFavoriteSellersComponent;
import com.avito.android.favorite_sellers.di.FavoriteSellersComponent;
import com.avito.android.favorite_sellers.di.FavoriteSellersDependencies;
import com.avito.android.favorite_sellers.interactor.FavoriteSellersReadInteractorImpl;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.performance.DiInjectTracker;
import com.avito.android.performance.ScreenTracker;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.remote.model.Image;
import com.avito.android.subscriptions_settings.SubscriptionSettingsViewImpl;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.util.Bundles;
import com.avito.android.util.CompressedParcelable;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Kundle;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\b¢\u0006\u0005\b\u0001\u0010\u0015J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0017\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0019\u0010\u0010J\u000f\u0010\u001a\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001a\u0010\u0015J\u0017\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001f\u0010\u001eJ)\u0010%\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b%\u0010&JY\u00103\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020'2\b\u0010)\u001a\u0004\u0018\u00010'2\u0006\u0010*\u001a\u00020'2\b\u0010+\u001a\u0004\u0018\u00010'2\b\u0010,\u001a\u0004\u0018\u00010'2\b\u0010.\u001a\u0004\u0018\u00010-2\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u000eH\u0016¢\u0006\u0004\b5\u0010\u0015J\u000f\u00106\u001a\u00020\u000eH\u0016¢\u0006\u0004\b6\u0010\u0015J\u000f\u00107\u001a\u00020\u000eH\u0016¢\u0006\u0004\b7\u0010\u0015J\u000f\u00108\u001a\u00020\u000eH\u0016¢\u0006\u0004\b8\u0010\u0015R\"\u0010:\u001a\u0002098\u0006@\u0006X.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010A\u001a\u00020@8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010H\u001a\u00020G8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010O\u001a\u00020N8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u0016\u0010X\u001a\u00020U8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bZ\u0010[R\"\u0010^\u001a\u00020]8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\"\u0010e\u001a\u00020d8\u0006@\u0006X.¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\"\u0010l\u001a\u00020k8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\"\u0010s\u001a\u00020r8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bs\u0010t\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\"\u0010z\u001a\u00020y8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/favorite_sellers/FavoriteSellersFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/favorite_sellers/FavoriteSellersPresenter$Router;", "Lcom/avito/android/bottom_navigation/ui/fragment/ScrollToUpHandler;", "Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationItemPresenter$Router;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "onCreate", "(Landroid/os/Bundle;)V", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDestroyView", "outState", "onSaveInstanceState", "leaveScreen", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLinkFromRecommendations", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "followDeepLink", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "", "itemId", "context", "title", "price", "oldPrice", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "", "isMarketplace", "openFastAdvertDetails", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Z)V", "openNotificationsSettings", "onResume", "onPause", "scrollToUp", "Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "abTestsConfigProvider", "Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "getAbTestsConfigProvider", "()Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "setAbTestsConfigProvider", "(Lcom/avito/android/ab_tests/AbTestsConfigProvider;)V", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Lcom/avito/android/performance/ScreenTracker;", "screenTracker", "Lcom/avito/android/performance/ScreenTracker;", "getScreenTracker", "()Lcom/avito/android/performance/ScreenTracker;", "setScreenTracker", "(Lcom/avito/android/performance/ScreenTracker;)V", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "k", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "viewDisposables", "Lcom/avito/android/favorite_sellers/FavoriteSellersView;", "j", "Lcom/avito/android/favorite_sellers/FavoriteSellersView;", "favoriteSellersView", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "viewHolderBuilder", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "getViewHolderBuilder", "()Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "setViewHolderBuilder", "(Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;)V", "Lcom/avito/android/favorite_sellers/FavoriteSellersPresenter;", "presenter", "Lcom/avito/android/favorite_sellers/FavoriteSellersPresenter;", "getPresenter", "()Lcom/avito/android/favorite_sellers/FavoriteSellersPresenter;", "setPresenter", "(Lcom/avito/android/favorite_sellers/FavoriteSellersPresenter;)V", "Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationItemPresenter;", "recommendationPresenter", "Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationItemPresenter;", "getRecommendationPresenter", "()Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationItemPresenter;", "setRecommendationPresenter", "(Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationItemPresenter;)V", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "snackbarPresenter", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "getSnackbarPresenter", "()Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "setSnackbarPresenter", "(Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/favorite_sellers/adapter/advert_list/AdvertListItemPresenter;", "advertListItemPresenter", "Lcom/avito/android/favorite_sellers/adapter/advert_list/AdvertListItemPresenter;", "getAdvertListItemPresenter", "()Lcom/avito/android/favorite_sellers/adapter/advert_list/AdvertListItemPresenter;", "setAdvertListItemPresenter", "(Lcom/avito/android/favorite_sellers/adapter/advert_list/AdvertListItemPresenter;)V", "<init>", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteSellersFragment extends TabBaseFragment implements FavoriteSellersPresenter.Router, ScrollToUpHandler, RecommendationItemPresenter.Router {
    @Inject
    public AbTestsConfigProvider abTestsConfigProvider;
    @Inject
    public ResponsiveAdapterPresenter adapterPresenter;
    @Inject
    public AdvertListItemPresenter advertListItemPresenter;
    @Inject
    public Analytics analytics;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public Features features;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    @Inject
    public ActivityIntentFactory intentFactory;
    public FavoriteSellersView j;
    public final CompositeDisposable k = new CompositeDisposable();
    @Inject
    public FavoriteSellersPresenter presenter;
    @Inject
    public RecommendationItemPresenter recommendationPresenter;
    @Inject
    public ScreenTracker screenTracker;
    @Inject
    public CompositeSnackbarPresenter snackbarPresenter;
    @Inject
    public DestroyableViewHolderBuilder viewHolderBuilder;

    public static final class a<T> implements Consumer<Integer> {
        public final /* synthetic */ FavoriteSellersFragment a;

        public a(FavoriteSellersFragment favoriteSellersFragment) {
            this.a = favoriteSellersFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Integer num) {
            this.a.getRecommendationPresenter().resetAutoScroll();
        }
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersPresenter.Router
    public void followDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            startActivityForResult(intent, 1);
        }
    }

    @Override // com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenter.Router
    public void followDeepLinkFromRecommendations(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            startActivityForResult(intent, 3);
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
    public final ResponsiveAdapterPresenter getAdapterPresenter() {
        ResponsiveAdapterPresenter responsiveAdapterPresenter = this.adapterPresenter;
        if (responsiveAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return responsiveAdapterPresenter;
    }

    @NotNull
    public final AdvertListItemPresenter getAdvertListItemPresenter() {
        AdvertListItemPresenter advertListItemPresenter2 = this.advertListItemPresenter;
        if (advertListItemPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertListItemPresenter");
        }
        return advertListItemPresenter2;
    }

    @NotNull
    public final Analytics getAnalytics() {
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
    public final Features getFeatures() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        return features2;
    }

    @NotNull
    public final ImplicitIntentFactory getImplicitIntentFactory() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        return implicitIntentFactory2;
    }

    @NotNull
    public final ActivityIntentFactory getIntentFactory() {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        return activityIntentFactory;
    }

    @NotNull
    public final FavoriteSellersPresenter getPresenter() {
        FavoriteSellersPresenter favoriteSellersPresenter = this.presenter;
        if (favoriteSellersPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return favoriteSellersPresenter;
    }

    @NotNull
    public final RecommendationItemPresenter getRecommendationPresenter() {
        RecommendationItemPresenter recommendationItemPresenter = this.recommendationPresenter;
        if (recommendationItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recommendationPresenter");
        }
        return recommendationItemPresenter;
    }

    @NotNull
    public final ScreenTracker getScreenTracker() {
        ScreenTracker screenTracker2 = this.screenTracker;
        if (screenTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenTracker");
        }
        return screenTracker2;
    }

    @NotNull
    public final CompositeSnackbarPresenter getSnackbarPresenter() {
        CompositeSnackbarPresenter compositeSnackbarPresenter = this.snackbarPresenter;
        if (compositeSnackbarPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snackbarPresenter");
        }
        return compositeSnackbarPresenter;
    }

    @NotNull
    public final DestroyableViewHolderBuilder getViewHolderBuilder() {
        DestroyableViewHolderBuilder destroyableViewHolderBuilder = this.viewHolderBuilder;
        if (destroyableViewHolderBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewHolderBuilder");
        }
        return destroyableViewHolderBuilder;
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersPresenter.Router
    public void leaveScreen() {
        requireActivity().finish();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i != 3) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            RecommendationItemPresenter recommendationItemPresenter = this.recommendationPresenter;
            if (recommendationItemPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recommendationPresenter");
            }
            recommendationItemPresenter.onSubscriptionDeepLinkReturned();
        }
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        CompressedParcelable compressedParcelable = bundle != null ? (CompressedParcelable) bundle.getParcelable("presenter_state") : null;
        Kundle kundle = compressedParcelable != null ? (Kundle) compressedParcelable.restore(Kundle.class) : null;
        Timer started = DiInjectTracker.Companion.started();
        FavoriteSellersComponent.Builder dependentOn = DaggerFavoriteSellersComponent.builder().dependentOn((FavoriteSellersDependencies) ComponentDependenciesKt.getDependencies(FavoriteSellersDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)));
        Bundle arguments = getArguments();
        FavoriteSellersComponent.Builder withRecommendationPresenterState = dependentOn.with(arguments != null ? arguments.getBoolean("editable") : false).with(kundle).withAdvertListItemPresenterState(bundle != null ? Bundles.getKundle(bundle, "advert_list_item_presenter_state") : null).withRecommendationPresenterState(bundle != null ? Bundles.getKundle(bundle, "recommendation_presenter_state") : null);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        FavoriteSellersComponent.Builder with = withRecommendationPresenterState.with(requireActivity);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        FavoriteSellersComponent.Builder with2 = with.with(resources);
        Bundle arguments2 = getArguments();
        FavoriteSellersComponent.Builder withUserKey = with2.withUserKey(arguments2 != null ? arguments2.getString("user_key") : null);
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (str = arguments3.getString("data_type")) == null) {
            str = FavoriteSellersReadInteractorImpl.TYPE;
        }
        Intrinsics.checkNotNullExpressionValue(str, "arguments?.getString(KEY…rsReadInteractorImpl.TYPE");
        FavoriteSellersComponent.Builder withDataType = withUserKey.withDataType(str);
        PublishRelay<FavoriteSellersItemAction> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        withDataType.with(create).withAnalyticsRecommendationSource(SubscriptionSource.FAVORITE_SELLERS_REC).withSerpOnboardingHandler(null).build().inject(this);
        ScreenTracker screenTracker2 = this.screenTracker;
        if (screenTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenTracker");
        }
        screenTracker2.getDiInject().finished(started);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ScreenTracker screenTracker2 = this.screenTracker;
        if (screenTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenTracker");
        }
        screenTracker2.getInit().started();
        View inflate = layoutInflater.inflate(R.layout.favorite_sellers, viewGroup, false);
        ScreenTracker screenTracker3 = this.screenTracker;
        if (screenTracker3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenTracker");
        }
        screenTracker3.resetSession();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        SubscriptionSettingsViewImpl subscriptionSettingsViewImpl = new SubscriptionSettingsViewImpl(requireActivity);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        DestroyableViewHolderBuilder destroyableViewHolderBuilder = this.viewHolderBuilder;
        if (destroyableViewHolderBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewHolderBuilder");
        }
        ResponsiveAdapterPresenter responsiveAdapterPresenter = this.adapterPresenter;
        if (responsiveAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
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
        this.j = new FavoriteSellersViewImpl(inflate, subscriptionSettingsViewImpl, destroyableViewHolderBuilder, responsiveAdapterPresenter, analytics2, num);
        CompositeSnackbarPresenter compositeSnackbarPresenter = this.snackbarPresenter;
        if (compositeSnackbarPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snackbarPresenter");
        }
        FavoriteSellersView favoriteSellersView = this.j;
        if (favoriteSellersView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteSellersView");
        }
        compositeSnackbarPresenter.setDefaultElement(favoriteSellersView);
        CompositeSnackbarPresenter compositeSnackbarPresenter2 = this.snackbarPresenter;
        if (compositeSnackbarPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snackbarPresenter");
        }
        compositeSnackbarPresenter2.addOptionalElement(subscriptionSettingsViewImpl);
        CompositeDisposable compositeDisposable = this.k;
        FavoriteSellersView favoriteSellersView2 = this.j;
        if (favoriteSellersView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteSellersView");
        }
        Disposable subscribe = favoriteSellersView2.scrollStateChanges().subscribe(new a(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "favoriteSellersView.scro…setAutoScroll()\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        FavoriteSellersPresenter favoriteSellersPresenter = this.presenter;
        if (favoriteSellersPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        FavoriteSellersView favoriteSellersView3 = this.j;
        if (favoriteSellersView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteSellersView");
        }
        favoriteSellersPresenter.attachView(favoriteSellersView3);
        FragmentActivity requireActivity2 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
        SubscriptionSettingsViewImpl subscriptionSettingsViewImpl2 = new SubscriptionSettingsViewImpl(requireActivity2);
        RecommendationItemPresenter recommendationItemPresenter = this.recommendationPresenter;
        if (recommendationItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recommendationPresenter");
        }
        recommendationItemPresenter.attachView(subscriptionSettingsViewImpl2);
        CompositeSnackbarPresenter compositeSnackbarPresenter3 = this.snackbarPresenter;
        if (compositeSnackbarPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snackbarPresenter");
        }
        compositeSnackbarPresenter3.addOptionalElement(subscriptionSettingsViewImpl2);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        DestroyableViewHolderBuilder destroyableViewHolderBuilder = this.viewHolderBuilder;
        if (destroyableViewHolderBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewHolderBuilder");
        }
        destroyableViewHolderBuilder.destroy();
        FavoriteSellersPresenter favoriteSellersPresenter = this.presenter;
        if (favoriteSellersPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        favoriteSellersPresenter.detachView();
        RecommendationItemPresenter recommendationItemPresenter = this.recommendationPresenter;
        if (recommendationItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recommendationPresenter");
        }
        recommendationItemPresenter.detachView();
        CompositeSnackbarPresenter compositeSnackbarPresenter = this.snackbarPresenter;
        if (compositeSnackbarPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snackbarPresenter");
        }
        compositeSnackbarPresenter.clear();
        ScreenTracker screenTracker2 = this.screenTracker;
        if (screenTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenTracker");
        }
        screenTracker2.stop();
        this.k.clear();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        FavoriteSellersPresenter favoriteSellersPresenter = this.presenter;
        if (favoriteSellersPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        favoriteSellersPresenter.onVisibilityChanged(false);
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        FavoriteSellersPresenter favoriteSellersPresenter = this.presenter;
        if (favoriteSellersPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        favoriteSellersPresenter.onVisibilityChanged(true);
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        FavoriteSellersPresenter favoriteSellersPresenter = this.presenter;
        if (favoriteSellersPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle.putParcelable("presenter_state", new CompressedParcelable(favoriteSellersPresenter.onSaveState()));
        AdvertListItemPresenter advertListItemPresenter2 = this.advertListItemPresenter;
        if (advertListItemPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertListItemPresenter");
        }
        Bundles.putKundle(bundle, "advert_list_item_presenter_state", advertListItemPresenter2.onSaveState());
        RecommendationItemPresenter recommendationItemPresenter = this.recommendationPresenter;
        if (recommendationItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recommendationPresenter");
        }
        Bundles.putKundle(bundle, "recommendation_presenter_state", recommendationItemPresenter.onSaveState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        FavoriteSellersPresenter favoriteSellersPresenter = this.presenter;
        if (favoriteSellersPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        favoriteSellersPresenter.attachRouter(this);
        RecommendationItemPresenter recommendationItemPresenter = this.recommendationPresenter;
        if (recommendationItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recommendationPresenter");
        }
        recommendationItemPresenter.attachRouter(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        FavoriteSellersPresenter favoriteSellersPresenter = this.presenter;
        if (favoriteSellersPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        favoriteSellersPresenter.detachRouter();
        RecommendationItemPresenter recommendationItemPresenter = this.recommendationPresenter;
        if (recommendationItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recommendationPresenter");
        }
        recommendationItemPresenter.detachRouter();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ScreenTracker screenTracker2 = this.screenTracker;
        if (screenTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenTracker");
        }
        screenTracker2.getInit().finished();
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersPresenter.Router
    public void openFastAdvertDetails(@NotNull String str, @Nullable String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable Image image, @Nullable TreeClickStreamParent treeClickStreamParent, boolean z) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(str3, "title");
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivity(AdvertDetailsIntentFactory.DefaultImpls.advertDetailsIntent$default(activityIntentFactory, str, str2, str3, str4, str5, image, z, treeClickStreamParent, SystemClock.elapsedRealtime(), null, currentTab(), null, 2560, null));
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersPresenter.Router, com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenter.Router
    public void openNotificationsSettings() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        startActivity(implicitIntentFactory2.notificationsSettingsIntent());
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.ScrollToUpHandler
    public void scrollToUp() {
        FavoriteSellersView favoriteSellersView = this.j;
        if (favoriteSellersView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteSellersView");
        }
        favoriteSellersView.scrollToTop();
    }

    public final void setAbTestsConfigProvider(@NotNull AbTestsConfigProvider abTestsConfigProvider2) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider2, "<set-?>");
        this.abTestsConfigProvider = abTestsConfigProvider2;
    }

    public final void setAdapterPresenter(@NotNull ResponsiveAdapterPresenter responsiveAdapterPresenter) {
        Intrinsics.checkNotNullParameter(responsiveAdapterPresenter, "<set-?>");
        this.adapterPresenter = responsiveAdapterPresenter;
    }

    public final void setAdvertListItemPresenter(@NotNull AdvertListItemPresenter advertListItemPresenter2) {
        Intrinsics.checkNotNullParameter(advertListItemPresenter2, "<set-?>");
        this.advertListItemPresenter = advertListItemPresenter2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setImplicitIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory2) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory2, "<set-?>");
        this.implicitIntentFactory = implicitIntentFactory2;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setPresenter(@NotNull FavoriteSellersPresenter favoriteSellersPresenter) {
        Intrinsics.checkNotNullParameter(favoriteSellersPresenter, "<set-?>");
        this.presenter = favoriteSellersPresenter;
    }

    public final void setRecommendationPresenter(@NotNull RecommendationItemPresenter recommendationItemPresenter) {
        Intrinsics.checkNotNullParameter(recommendationItemPresenter, "<set-?>");
        this.recommendationPresenter = recommendationItemPresenter;
    }

    public final void setScreenTracker(@NotNull ScreenTracker screenTracker2) {
        Intrinsics.checkNotNullParameter(screenTracker2, "<set-?>");
        this.screenTracker = screenTracker2;
    }

    public final void setSnackbarPresenter(@NotNull CompositeSnackbarPresenter compositeSnackbarPresenter) {
        Intrinsics.checkNotNullParameter(compositeSnackbarPresenter, "<set-?>");
        this.snackbarPresenter = compositeSnackbarPresenter;
    }

    public final void setViewHolderBuilder(@NotNull DestroyableViewHolderBuilder destroyableViewHolderBuilder) {
        Intrinsics.checkNotNullParameter(destroyableViewHolderBuilder, "<set-?>");
        this.viewHolderBuilder = destroyableViewHolderBuilder;
    }
}
