package com.avito.android.favorite_sellers.di;

import android.app.Activity;
import android.content.res.Resources;
import com.avito.android.analytics.event.favorite.SubscriptionSource;
import com.avito.android.connection_quality.di.ConnectivityProviderModule;
import com.avito.android.di.PerFragment;
import com.avito.android.di.ViewedAdvertsModule;
import com.avito.android.di.module.AdvertItemModule;
import com.avito.android.di.module.FavoriteAdvertsPresenterModule;
import com.avito.android.di.module.SerpItemConverterModule;
import com.avito.android.dialog.di.DialogModule;
import com.avito.android.error_helper.di.ErrorHelperModule;
import com.avito.android.favorite_sellers.FavoriteSellersFragment;
import com.avito.android.favorite_sellers.action.FavoriteSellersItemAction;
import com.avito.android.favorite_sellers.adapter.advert_list.adapter.other_adverts.di.OtherAdvertsItemModule;
import com.avito.android.favorite_sellers.adapter.advert_list.di.AdvertListItemModule;
import com.avito.android.favorite_sellers.adapter.advert_list.di.ForAdvertList;
import com.avito.android.favorite_sellers.adapter.error.di.ErrorItemModule;
import com.avito.android.favorite_sellers.adapter.info.di.InfoItemModule;
import com.avito.android.favorite_sellers.adapter.loading.di.LoadingItemModule;
import com.avito.android.favorite_sellers.adapter.recommendation.ForRecommendation;
import com.avito.android.favorite_sellers.adapter.recommendation.di.RecommendationItemModule;
import com.avito.android.favorite_sellers.adapter.seller.di.SellerItemModule;
import com.avito.android.favorite_sellers.di.FavoriteSellersModule;
import com.avito.android.favorite_sellers.tracker.FavoriteSellersTrackersModule;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarModule;
import com.avito.android.performance.di.PerformanceTrackersModule;
import com.avito.android.section.di.SectionAdvertItemsModule;
import com.avito.android.serp.adapter.onboarding.SerpOnboardingHandler;
import com.avito.android.util.Kundle;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/favorite_sellers/di/FavoriteSellersComponent;", "", "Lcom/avito/android/favorite_sellers/FavoriteSellersFragment;", "fragment", "", "inject", "(Lcom/avito/android/favorite_sellers/FavoriteSellersFragment;)V", "Builder", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {FavoriteSellersDependencies.class}, modules = {PerformanceTrackersModule.class, SerpItemConverterModule.class, FavoriteSellersModule.class, DialogModule.class, ErrorHelperModule.class, AdvertListItemModule.class, SellerItemModule.class, FavoriteAdvertsPresenterModule.class, SectionAdvertItemsModule.class, OtherAdvertsItemModule.class, AdvertItemModule.class, ErrorItemModule.class, ViewedAdvertsModule.class, FavoriteSellersTrackersModule.class, InfoItemModule.class, RecommendationItemModule.class, LoadingItemModule.class, ConnectivityProviderModule.class, CompositeSnackbarModule.class})
@PerFragment
public interface FavoriteSellersComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\b\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\b\u0010\fJ\u001b\u0010\u000f\u001a\u00020\u00002\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\rH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u00002\b\b\u0001\u0010\u0011\u001a\u00020\rH'¢\u0006\u0004\b\u0012\u0010\u0010J\u001b\u0010\u0013\u001a\u00020\u00002\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0004\b\u0013\u0010\tJ\u001b\u0010\u0014\u001a\u00020\u00002\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0004\b\u0014\u0010\tJ\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015H'¢\u0006\u0004\b\b\u0010\u0017J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018H'¢\u0006\u0004\b\b\u0010\u001aJ\u001d\u0010\b\u001a\u00020\u00002\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH'¢\u0006\u0004\b\b\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u001fH'¢\u0006\u0004\b!\u0010\"J\u0019\u0010%\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010#H'¢\u0006\u0004\b%\u0010&J\u000f\u0010(\u001a\u00020'H&¢\u0006\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lcom/avito/android/favorite_sellers/di/FavoriteSellersComponent$Builder;", "", "Lcom/avito/android/favorite_sellers/di/FavoriteSellersDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/favorite_sellers/di/FavoriteSellersDependencies;)Lcom/avito/android/favorite_sellers/di/FavoriteSellersComponent$Builder;", "Lcom/avito/android/util/Kundle;", "state", "with", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/favorite_sellers/di/FavoriteSellersComponent$Builder;", "", "editable", "(Z)Lcom/avito/android/favorite_sellers/di/FavoriteSellersComponent$Builder;", "", "userKey", "withUserKey", "(Ljava/lang/String;)Lcom/avito/android/favorite_sellers/di/FavoriteSellersComponent$Builder;", "dataType", "withDataType", "withAdvertListItemPresenterState", "withRecommendationPresenterState", "Landroid/app/Activity;", "activity", "(Landroid/app/Activity;)Lcom/avito/android/favorite_sellers/di/FavoriteSellersComponent$Builder;", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/favorite_sellers/di/FavoriteSellersComponent$Builder;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/favorite_sellers/action/FavoriteSellersItemAction;", "relay", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lcom/avito/android/favorite_sellers/di/FavoriteSellersComponent$Builder;", "Lcom/avito/android/analytics/event/favorite/SubscriptionSource;", "source", "withAnalyticsRecommendationSource", "(Lcom/avito/android/analytics/event/favorite/SubscriptionSource;)Lcom/avito/android/favorite_sellers/di/FavoriteSellersComponent$Builder;", "Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;", "handler", "withSerpOnboardingHandler", "(Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;)Lcom/avito/android/favorite_sellers/di/FavoriteSellersComponent$Builder;", "Lcom/avito/android/favorite_sellers/di/FavoriteSellersComponent;", "build", "()Lcom/avito/android/favorite_sellers/di/FavoriteSellersComponent;", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        FavoriteSellersComponent build();

        @NotNull
        Builder dependentOn(@NotNull FavoriteSellersDependencies favoriteSellersDependencies);

        @BindsInstance
        @NotNull
        Builder with(@NotNull Activity activity);

        @BindsInstance
        @NotNull
        Builder with(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder with(@Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder with(@NotNull PublishRelay<FavoriteSellersItemAction> publishRelay);

        @BindsInstance
        @NotNull
        Builder with(@FavoriteSellersModule.Editable boolean z);

        @BindsInstance
        @NotNull
        Builder withAdvertListItemPresenterState(@ForAdvertList @Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withAnalyticsRecommendationSource(@NotNull SubscriptionSource subscriptionSource);

        @BindsInstance
        @NotNull
        Builder withDataType(@FavoriteSellersModule.DataType @NotNull String str);

        @BindsInstance
        @NotNull
        Builder withRecommendationPresenterState(@ForRecommendation @Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withSerpOnboardingHandler(@Nullable SerpOnboardingHandler serpOnboardingHandler);

        @BindsInstance
        @NotNull
        Builder withUserKey(@FavoriteSellersModule.UserKey @Nullable String str);
    }

    void inject(@NotNull FavoriteSellersFragment favoriteSellersFragment);
}
