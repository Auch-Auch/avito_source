package com.avito.android.di.module;

import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.fps.FpsMetricsTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.di.ComponentDependencies;
import com.avito.android.fps.di.FpsCommunication;
import com.avito.android.fps.di.FpsTrackingThreshold;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH'¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH'¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/di/module/ScreenAnalyticsDependencies;", "Lcom/avito/android/di/ComponentDependencies;", "Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "screenTrackerFactory", "()Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "Lcom/avito/android/analytics/screens/fps/FpsMetricsTracker;", "fpsMetricsTracker", "()Lcom/avito/android/analytics/screens/fps/FpsMetricsTracker;", "Lio/reactivex/Observable;", "", "frameStream", "()Lio/reactivex/Observable;", "Lcom/avito/android/analytics/screens/TimerFactory;", "timerFactory", "()Lcom/avito/android/analytics/screens/TimerFactory;", "", "fpsTrackingThreshold", "()I", "core_release"}, k = 1, mv = {1, 4, 2})
public interface ScreenAnalyticsDependencies extends ComponentDependencies {
    @NotNull
    FpsMetricsTracker fpsMetricsTracker();

    @FpsTrackingThreshold
    int fpsTrackingThreshold();

    @FpsCommunication
    @NotNull
    Observable<Long> frameStream();

    @Override // com.avito.android.authorization.auth.di.AuthDependencies, com.avito.android.authorization.login_suggests.di.LoginSuggestsDependencies, com.avito.android.profile.di.UserProfileDependencies, com.avito.android.rating.publish.select_advert.di.SelectAdvertDependencies, com.avito.android.rating.publish.di.RatingPublishDependencies, com.avito.android.performance.di.PerformanceTrackersDependencies, com.avito.android.grouping_adverts.di.GroupingAdvertsDependencies, com.avito.android.delivery.di.component.DeliveryDependencies, com.avito.android.delivery.di.component.DeliveryRdsCommonDependencies, com.avito.android.user_adverts.di.host_fragment.UserAdvertsHostFragmentDependencies, com.avito.android.user_adverts.items_search.di.ProfileItemsSearchDependencies, com.avito.android.public_profile.di.ProfileAdvertsDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.developments_catalog.di.DevelopmentsCatalogDependencies, com.avito.android.auto_catalog.di.AutoCatalogDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.publish.wizard.di.WizardDependencies, com.avito.android.favorites.di.FavoriteAdvertsDependencies, com.avito.android.advert_stats.di.AdvertStatsDependencies, com.avito.android.basket.paid_services.di.PaidServicesDependencies, com.avito.android.public_profile.di.PublicProfileFragmentDependencies, com.avito.android.basket_legacy.di.shared.BasketDependencies, com.avito.android.search.filter.di.FiltersDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.messenger.search.di.ChannelsSearchComponentDependencies, com.avito.android.photo_gallery.di.PhotoGalleryDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.photo_gallery.di.GalleryDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.safedeal.profile_settings.di.ProfileDeliverySettingsDependencies, com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkDependencies, com.avito.android.cart.di.deps.CartSummaryDependencies, com.avito.android.user_stats.di.UserStatsDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies
    @NotNull
    ScreenTrackerFactory screenTrackerFactory();

    @Override // com.avito.android.profile.di.UserProfileDependencies, com.avito.android.rating.publish.select_advert.di.SelectAdvertDependencies, com.avito.android.rating.publish.di.RatingPublishDependencies, com.avito.android.performance.di.PerformanceTrackersDependencies, com.avito.android.grouping_adverts.di.GroupingAdvertsDependencies, com.avito.android.user_adverts.di.host_fragment.UserAdvertsHostFragmentDependencies, com.avito.android.user_adverts.items_search.di.ProfileItemsSearchDependencies, com.avito.android.public_profile.di.ProfileAdvertsDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.developments_catalog.di.DevelopmentsCatalogDependencies, com.avito.android.auto_catalog.di.AutoCatalogDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.favorites.di.FavoriteAdvertsDependencies, com.avito.android.public_profile.di.PublicProfileFragmentDependencies, com.avito.android.search.filter.di.FiltersDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.messenger.search.di.ChannelsSearchComponentDependencies, com.avito.android.photo_gallery.di.PhotoGalleryDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.photo_gallery.di.GalleryDependencies, com.avito.android.user_stats.di.UserStatsDependencies
    @NotNull
    TimerFactory timerFactory();
}
