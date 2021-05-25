package com.avito.android.user_adverts.di.host_fragment;

import android.app.Application;
import android.content.SharedPreferences;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.analytics.provider.CurrentUserIdProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.cart_fab.CartFabDependencies;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.di.ComponentDependencies;
import com.avito.android.notification_center.counter.NotificationCenterCounterInteractor;
import com.avito.android.remote.UserAdvertsCommonApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.server_time.TimeSource;
import com.avito.android.server_time.UtcTimeSource;
import com.avito.android.user_advert.UserAdvertsInfoUpdateRunner;
import com.avito.android.user_adverts.remote.UserAdvertsApi;
import com.avito.android.user_adverts.root_screen.adverts_host.header.soa_statistics_storage.SoaPopupSessionStorage;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.PreferenceFactory;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Locale;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H&¢\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020$H&¢\u0006\u0004\b%\u0010&J\u000f\u0010(\u001a\u00020'H&¢\u0006\u0004\b(\u0010)J\u000f\u0010+\u001a\u00020*H&¢\u0006\u0004\b+\u0010,J\u000f\u0010.\u001a\u00020-H&¢\u0006\u0004\b.\u0010/J\u000f\u00101\u001a\u000200H&¢\u0006\u0004\b1\u00102J\u000f\u00104\u001a\u000203H&¢\u0006\u0004\b4\u00105J\u000f\u00107\u001a\u000206H&¢\u0006\u0004\b7\u00108J\u000f\u0010:\u001a\u000209H&¢\u0006\u0004\b:\u0010;J\u000f\u0010=\u001a\u00020<H&¢\u0006\u0004\b=\u0010>J\u000f\u0010@\u001a\u00020?H&¢\u0006\u0004\b@\u0010AJ\u000f\u0010C\u001a\u00020BH&¢\u0006\u0004\bC\u0010DJ\u000f\u0010F\u001a\u00020EH&¢\u0006\u0004\bF\u0010G¨\u0006H"}, d2 = {"Lcom/avito/android/user_adverts/di/host_fragment/UserAdvertsHostFragmentDependencies;", "Lcom/avito/android/di/ComponentDependencies;", "Lcom/avito/android/cart_fab/CartFabDependencies;", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "()Lcom/avito/android/util/DeviceMetrics;", "Lcom/avito/android/analytics/provider/CurrentUserIdProvider;", "currentUserProvider", "()Lcom/avito/android/analytics/provider/CurrentUserIdProvider;", "Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "abTestsConfigProvider", "()Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "()Lcom/avito/android/util/SchedulersFactory;", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "()Lcom/avito/android/util/BuildInfo;", "Lcom/avito/android/user_adverts/remote/UserAdvertsApi;", "userAdvertsApi", "()Lcom/avito/android/user_adverts/remote/UserAdvertsApi;", "Landroid/content/SharedPreferences;", "sharedPreferences", "()Landroid/content/SharedPreferences;", "Lcom/avito/android/server_time/UtcTimeSource;", "utcTimeSource", "()Lcom/avito/android/server_time/UtcTimeSource;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "()Landroid/app/Application;", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "()Lcom/avito/android/deep_linking/DeepLinkFactory;", "Lcom/avito/android/user_advert/UserAdvertsInfoUpdateRunner;", "userAdvertsInfoUpdateRunner", "()Lcom/avito/android/user_advert/UserAdvertsInfoUpdateRunner;", "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "()Lcom/avito/android/account/AccountStorageInteractor;", "Lcom/avito/android/notification_center/counter/NotificationCenterCounterInteractor;", "notificationCenterCounterInteractor", "()Lcom/avito/android/notification_center/counter/NotificationCenterCounterInteractor;", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "()Lcom/avito/android/server_time/TimeSource;", "Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "screenTrackerFactory", "()Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "Lcom/avito/android/analytics/screens/TimerFactory;", "timerFactory", "()Lcom/avito/android/analytics/screens/TimerFactory;", "Ljava/util/Locale;", "locale", "()Ljava/util/Locale;", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "()Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "Lcom/avito/android/remote/UserAdvertsCommonApi;", "userAdvertsCommonApi", "()Lcom/avito/android/remote/UserAdvertsCommonApi;", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory3", "()Lcom/avito/android/util/SchedulersFactory3;", "Lcom/avito/android/util/preferences/PreferenceFactory;", "preferenceFactory", "()Lcom/avito/android/util/preferences/PreferenceFactory;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/soa_statistics_storage/SoaPopupSessionStorage;", "soaPopupSessionStorage", "()Lcom/avito/android/user_adverts/root_screen/adverts_host/header/soa_statistics_storage/SoaPopupSessionStorage;", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public interface UserAdvertsHostFragmentDependencies extends ComponentDependencies, CartFabDependencies {
    @Override // com.avito.android.di.component.SerpDependencies, com.avito.android.public_profile.di.ProfileAdvertsDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.auto_catalog.di.AutoCatalogDependencies, com.avito.android.search.map.di.SearchMapDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.publish.wizard.di.WizardDependencies, com.avito.android.favorites.di.FavoriteAdvertsDependencies, com.avito.android.photo_gallery.di.PhotoGalleryDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.advert.closed.di.ClosedAdvertDependencies, com.avito.android.payment.lib.di.PaymentLibraryDependencies
    @NotNull
    AbTestsConfigProvider abTestsConfigProvider();

    @Override // com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.publish.residential_complex_search.di.ResidentialComplexComponentDependencies, com.avito.android.webview.di.WebViewDependencies, com.avito.android.profile.password_change.di.PasswordChangeDependencies, com.avito.android.profile.password_setting.di.PasswordSettingDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.user_adverts.expired_count.di.UserAdvertsInfoDependencies, com.avito.android.profile.sessions.social_logout.di.SessionsSocialLogoutDependencies
    @NotNull
    AccountStorageInteractor accountStorageInteractor();

    @Override // com.avito.android.di.component.HomeActivityDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.publish.start_publish.di.StartPublishDependencies, com.avito.android.basket_legacy.di.shared.BasketDependencies, com.avito.android.rating.user_reviews.di.UserReviewsDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.blocked_ip.di.BlockedIpDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.short_term_rent.di.component.HotelsDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.suggest_locations.di.SuggestLocationsDependencies, com.avito.android.rating.review_details.di.ReviewDetailsDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies
    @NotNull
    ActivityIntentFactory activityIntentFactory();

    @Override // com.avito.android.user_advert.advert.service.di.UserAdvertServiceDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.push.MessagingDependencies, com.avito.android.push.UpdateInstanceIdDependencies
    @NotNull
    Application application();

    @Override // com.avito.android.di.component.HomeActivityDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.photo_picker.legacy.di.PhotoContentProviderDependencies, com.avito.android.push.UpdateInstanceIdDependencies, com.avito.android.authorization.account_manager.di.AvitoAuthenticatorDependencies, com.avito.android.location_picker.di.LocationPickerDependencies
    @NotNull
    BuildInfo buildInfo();

    @Override // com.avito.android.user_advert.di.MyAdvertDetailsDependencies
    @NotNull
    CurrentUserIdProvider currentUserProvider();

    @Override // com.avito.android.user_adverts.items_search.di.ProfileItemsSearchDependencies, com.avito.android.di.component.SerpDependencies, com.avito.android.di.component.StoriesDependencies, com.avito.android.public_profile.di.ProfileAdvertsDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.auto_catalog.di.AutoCatalogDependencies, com.avito.android.search.map.di.SearchMapDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.favorites.di.FavoriteAdvertsDependencies, com.avito.android.notification_center.list.di.NotificationCenterListDependencies, com.avito.android.webview.di.WebViewDependencies, com.avito.android.messenger.di.ChannelActivityDependencies, com.avito.android.messenger.di.MessageIsReadMarkerDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.push.MessagingDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.payment.lib.di.PaymentLibraryDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.safedeal.delivery_type.di.DeliveryTypeDependencies, com.avito.android.orders.di.component.OrdersDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies
    @NotNull
    DeepLinkFactory deepLinkFactory();

    @Override // com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.basket_legacy.di.shared.BasketDependencies, com.avito.android.advert.specifications.di.SpecificationsDependencies, com.avito.android.str_calendar.di.component.StrBookingCalendarDependencies
    @NotNull
    DeviceMetrics deviceMetrics();

    @Override // com.avito.android.favorites.di.FavoriteAdvertsServiceDependencies, com.avito.android.di.component.SerpDependencies, com.avito.android.public_profile.di.ProfileAdvertsDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.auto_catalog.di.AutoCatalogDependencies, com.avito.android.search.map.di.SearchMapDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.favorites.di.FavoriteAdvertsDependencies, com.avito.android.viewed_items.di.ViewedItemsDependencies, com.avito.android.notification_center.list.di.NotificationCenterListDependencies, com.avito.android.notification_center.landing.recommends.di.NotificationCenterLandingRecommendsDependencies, com.avito.android.notification_center.landing.unified.di.NotificationCenterLandingUnifiedDependencies, com.avito.android.express_cv.di.ExpressCvDependencies, com.avito.android.basket.paid_services.di.PaidServicesDependencies, com.avito.android.basket_legacy.di.shared.BasketDependencies, com.avito.android.search.filter.di.FiltersDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.messenger.di.ChannelActivityDependencies, com.avito.android.messenger.blacklist.mvi.di.BlacklistFragmentComponentDependencies, com.avito.android.messenger.search.di.ChannelsSearchComponentDependencies, com.avito.android.messenger.channels.mvi.di.ChannelsDependencies, com.avito.android.photo_gallery.di.PhotoGalleryDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.feedback_adverts.di.FeedbackAdvertsDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.location_picker.di.LocationPickerDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    Locale locale();

    @Override // com.avito.android.di.component.HomeDependencies
    @NotNull
    NotificationCenterCounterInteractor notificationCenterCounterInteractor();

    @Override // com.avito.android.advert_stats.di.AdvertStatsDependencies, com.avito.android.messenger.channels.mvi.di.ChannelsDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.user_stats.di.UserStatsDependencies
    @NotNull
    PreferenceFactory preferenceFactory();

    @Override // com.avito.android.user_adverts.items_search.di.ProfileItemsSearchDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.vas_performance.di.applied_services.AppliedServicesDependencies, com.avito.android.basket_legacy.di.shared.BasketDependencies, com.avito.android.info.di.InfoActivityDependencies, com.avito.android.push.UpdateInstanceIdDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.app_rater.di.AppRaterDependencies, com.avito.android.soa_stat.di.SoaStatProfileSettingsDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies
    @NotNull
    SchedulersFactory schedulersFactory();

    @Override // com.avito.android.di.component.HomeActivityDependencies, com.avito.android.di.component.StoriesDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.publish.start_publish.di.StartPublishDependencies, com.avito.android.publish_limits_info.history.di.PublishLimitsHistoryDependencies, com.avito.android.rating.user_reviews.di.UserReviewsDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.short_term_rent.di.component.HotelsDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.rating.review_details.di.ReviewDetailsDependencies, com.avito.android.profile_phones.phones_list.di.PhonesListDependencies, com.avito.android.profile_phones.add_phone.di.AddPhoneDependencies, com.avito.android.profile_phones.landline_verification.di.LandlinePhoneVerificationDependencies, com.avito.android.profile_phones.confirm_phone.di.ConfirmPhoneDependencies, com.avito.android.profile_phones.phone_action.di.PhoneActionDependencies, com.avito.android.profile_phones.phones_list.actions.di.PhoneActionsDependencies
    @NotNull
    SchedulersFactory3 schedulersFactory3();

    @Override // com.avito.android.user_adverts.items_search.di.ProfileItemsSearchDependencies, com.avito.android.public_profile.di.ProfileAdvertsDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.developments_catalog.di.DevelopmentsCatalogDependencies, com.avito.android.auto_catalog.di.AutoCatalogDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.publish.wizard.di.WizardDependencies, com.avito.android.favorites.di.FavoriteAdvertsDependencies, com.avito.android.advert_stats.di.AdvertStatsDependencies, com.avito.android.basket.paid_services.di.PaidServicesDependencies, com.avito.android.public_profile.di.PublicProfileFragmentDependencies, com.avito.android.basket_legacy.di.shared.BasketDependencies, com.avito.android.search.filter.di.FiltersDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.messenger.search.di.ChannelsSearchComponentDependencies, com.avito.android.photo_gallery.di.PhotoGalleryDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.photo_gallery.di.GalleryDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.safedeal.profile_settings.di.ProfileDeliverySettingsDependencies, com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkDependencies, com.avito.android.cart.di.deps.CartSummaryDependencies, com.avito.android.user_stats.di.UserStatsDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies
    @NotNull
    ScreenTrackerFactory screenTrackerFactory();

    @Override // com.avito.android.search.map.di.SearchMapDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.messenger.channels.mvi.di.ChannelsDependencies
    @NotNull
    SharedPreferences sharedPreferences();

    @NotNull
    SoaPopupSessionStorage soaPopupSessionStorage();

    @Override // com.avito.android.profile_phones.add_phone.di.AddPhoneDependencies, com.avito.android.profile_phones.landline_verification.di.LandlinePhoneVerificationDependencies, com.avito.android.profile_phones.confirm_phone.di.ConfirmPhoneDependencies, com.avito.android.profile_phones.phone_action.di.PhoneActionDependencies
    @NotNull
    TypedErrorThrowableConverter throwableConverter();

    @Override // com.avito.android.favorites.di.FavoriteAdvertsServiceDependencies, com.avito.android.di.component.SerpDependencies, com.avito.android.di.component.StoriesDependencies, com.avito.android.public_profile.di.ProfileAdvertsDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.location_list.di.LocationListDependencies, com.avito.android.auto_catalog.di.AutoCatalogDependencies, com.avito.android.search.map.di.SearchMapDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.phone_confirmation.di.PhoneConfirmationDependencies, com.avito.android.favorites.di.FavoriteAdvertsDependencies, com.avito.android.viewed_items.di.ViewedItemsDependencies, com.avito.android.payment.di.component.PaymentDependencies, com.avito.android.notification_center.list.di.NotificationCenterListDependencies, com.avito.android.notification_center.landing.recommends.di.NotificationCenterLandingRecommendsDependencies, com.avito.android.notification_center.landing.unified.di.NotificationCenterLandingUnifiedDependencies, com.avito.android.express_cv.di.ExpressCvDependencies, com.avito.android.geo.di.GeoDependencies, com.avito.android.search.filter.di.FiltersDependencies, com.avito.android.deep_linking.di.AppLinkDependencies, com.avito.android.certificate_pinning.di.UnsafeNetworkDependencies, com.avito.android.messenger.di.ChannelActivityDependencies, com.avito.android.messenger.blacklist.mvi.di.BlacklistFragmentComponentDependencies, com.avito.android.messenger.di.MessageIsReadMarkerDependencies, com.avito.android.messenger.search.di.ChannelsSearchComponentDependencies, com.avito.android.messenger.channels.mvi.di.ChannelsDependencies, com.avito.android.messenger.di.SendPendingMessagesWorkerComponentDependencies, com.avito.android.messenger.di.DirectReplyServiceDependencies, com.avito.android.messenger.map.viewing.di.PlatformMapFragmentDependencies, com.avito.android.deep_linking.di.DeepLinkingDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.location_picker.di.LocationPickerDependencies, com.avito.android.in_app_calls.di.CallActivityComponentDependencies, com.avito.android.in_app_calls.ui.call.CallFragmentComponentDependencies, com.avito.android.in_app_calls.di.CallManagerServiceComponentDependencies, com.avito.android.app_rater.di.AppRaterDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.player.di.PlayerFragmentDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    TimeSource timeSource();

    @Override // com.avito.android.user_adverts.items_search.di.ProfileItemsSearchDependencies, com.avito.android.public_profile.di.ProfileAdvertsDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.developments_catalog.di.DevelopmentsCatalogDependencies, com.avito.android.auto_catalog.di.AutoCatalogDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.favorites.di.FavoriteAdvertsDependencies, com.avito.android.public_profile.di.PublicProfileFragmentDependencies, com.avito.android.search.filter.di.FiltersDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.messenger.search.di.ChannelsSearchComponentDependencies, com.avito.android.photo_gallery.di.PhotoGalleryDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.photo_gallery.di.GalleryDependencies, com.avito.android.user_stats.di.UserStatsDependencies
    @NotNull
    TimerFactory timerFactory();

    @Override // com.avito.android.user_adverts.expired_count.di.UserAdvertsInfoDependencies
    @NotNull
    UserAdvertsApi userAdvertsApi();

    @Override // com.avito.android.user_advert.di.MyAdvertDetailsDependencies
    @NotNull
    UserAdvertsCommonApi userAdvertsCommonApi();

    @Override // com.avito.android.di.component.HomeActivityDependencies, com.avito.android.notification_center.list.di.NotificationCenterListDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.cpo_program.di.AutotekaCpoProgramDependencies, com.avito.android.advert.closed.di.ClosedAdvertDependencies, com.avito.android.feedback_adverts.di.FeedbackAdvertsDependencies
    @NotNull
    UserAdvertsInfoUpdateRunner userAdvertsInfoUpdateRunner();

    @Override // com.avito.android.di.component.SerpDependencies, com.avito.android.auto_catalog.di.AutoCatalogDependencies, com.avito.android.favorites.di.FavoriteAdvertsDependencies, com.avito.android.search.filter.di.FiltersDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.advert.di.AdvertFragmentDependencies
    @NotNull
    UtcTimeSource utcTimeSource();
}
