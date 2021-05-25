package com.avito.android.fees.di;

import com.avito.android.MessengerWorkFactory;
import com.avito.android.ServiceIntentFactory;
import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.fees.remote.FeesApi;
import com.avito.android.search.subscriptions.sync.SearchSubscriptionSyncRunner;
import com.avito.android.user_advert.UserAdvertsInfoUpdateRunner;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/avito/android/fees/di/FeesActivityDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/fees/remote/FeesApi;", "feesApi", "()Lcom/avito/android/fees/remote/FeesApi;", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "publishAnalyticsDataProvider", "()Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deeplinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "abTestConfigProvider", "()Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "()Lcom/avito/android/account/AccountStateProvider;", "Lcom/avito/android/ServiceIntentFactory;", "serviceIntentFactory", "()Lcom/avito/android/ServiceIntentFactory;", "Lcom/avito/android/search/subscriptions/sync/SearchSubscriptionSyncRunner;", "searchSubscriptionSyncRunner", "()Lcom/avito/android/search/subscriptions/sync/SearchSubscriptionSyncRunner;", "Lcom/avito/android/user_advert/UserAdvertsInfoUpdateRunner;", "userAdvertsInfoUpdateRunner", "()Lcom/avito/android/user_advert/UserAdvertsInfoUpdateRunner;", "Lcom/avito/android/MessengerWorkFactory;", "messengerWorkFactory", "()Lcom/avito/android/MessengerWorkFactory;", "fees_release"}, k = 1, mv = {1, 4, 2})
public interface FeesActivityDependencies extends CoreComponentDependencies {
    @Override // com.avito.android.photo_picker.legacy.di.PhotoPickerDependencies, com.avito.android.suggest_locations.di.SuggestLocationsDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    AbTestsConfigProvider abTestConfigProvider();

    @Override // com.avito.android.delivery.di.component.DeliveryDependencies, com.avito.android.delivery.di.component.DeliveryRdsCommonDependencies, com.avito.android.favorites.di.FavoriteAdvertsServiceDependencies, com.avito.android.public_profile.di.ProfileAdvertsDependencies, com.avito.android.shop_settings.di.ShopSettingsFragmentDependencies, com.avito.android.auto_catalog.di.AutoCatalogDependencies, com.avito.android.search.map.di.SearchMapDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.publish.start_publish.di.StartPublishDependencies, com.avito.android.publish.di.NewAdvertDependencies, com.avito.android.favorites.di.FavoriteAdvertsDependencies, com.avito.android.public_profile.di.PublicProfileFragmentDependencies, com.avito.android.rating.details.di.RatingDetailsDependencies, com.avito.android.rating.check.di.RatingPublishCheckDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.messenger.di.ChannelActivityDependencies, com.avito.android.messenger.di.IncompleteMessageLoaderDependencies, com.avito.android.messenger.blacklist.mvi.di.BlacklistFragmentComponentDependencies, com.avito.android.messenger.di.MessageIsReadMarkerDependencies, com.avito.android.messenger.search.di.ChannelsSearchComponentDependencies, com.avito.android.messenger.conversation.create.di.CreateChannelFragmentDependencies, com.avito.android.messenger.di.OpenErrorTrackerDependencies, com.avito.android.messenger.di.SendPendingMessagesWorkerComponentDependencies, com.avito.android.messenger.di.UpdateUnreadMessagesCountDependencies, com.avito.android.messenger.conversation.mvi.file_download.FileDownloadWorkerComponentDependencies, com.avito.android.photo_gallery.di.PhotoGalleryDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.short_term_rent.di.component.StrStartBookingDependencies, com.avito.android.messenger.map.search.di.GeoSearchFragmentDependencies, com.avito.android.in_app_calls.workers.CallAvailabilityComponentDependencies, com.avito.android.in_app_calls.ui.call.CallFragmentComponentDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.safedeal.delivery_type.di.DeliveryTypeDependencies, com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkDependencies, com.avito.android.booking.di.BookingOrderDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.cart.di.deps.CartSummaryDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    AccountStateProvider accountStateProvider();

    @Override // com.avito.android.publish_limits_info.history.di.PublishLimitsHistoryDependencies, com.avito.android.payment.di.component.PaymentDependencies, com.avito.android.express_cv.di.ExpressCvDependencies, com.avito.android.vas_discount.di.DiscountDependencies, com.avito.android.advert_stats.di.AdvertStatsDependencies, com.avito.android.tariff.TariffDependencies, com.avito.android.vas_performance.di.applied_services.AppliedServicesDependencies, com.avito.android.deep_linking.di.AppLinkDependencies, com.avito.android.deep_linking.di.AppShortcutsDeepLinkDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.messenger.support.di.SupportChatFormDependencies, com.avito.android.deep_linking.di.DeepLinkingDependencies, com.avito.android.advert.badge_details.di.BadgeDetailsDependencies, com.avito.android.payment.lib.di.PaymentLibraryDependencies, com.avito.android.bundles.vas_union.di.VasUnionDependencies, com.avito.android.job.cv_packages.di.CvPackagesDependencies
    @NotNull
    DeepLinkIntentFactory deeplinkIntentFactory();

    @Override // com.avito.android.basket_legacy.di.shared.BasketDependencies
    @NotNull
    FeesApi feesApi();

    @Override // com.avito.android.di.component.HomeActivityDependencies, com.avito.android.messenger.search.di.ChannelsSearchComponentDependencies, com.avito.android.messenger.channels.mvi.di.ChannelsDependencies, com.avito.android.advert.closed.di.ClosedAdvertDependencies, com.avito.android.feedback_adverts.di.FeedbackAdvertsDependencies
    @NotNull
    MessengerWorkFactory messengerWorkFactory();

    @Override // com.avito.android.publish.drafts.di.PublishDraftsDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.publish.start_publish.di.StartPublishDependencies, com.avito.android.location_picker.di.LocationPickerDependencies
    @NotNull
    PublishAnalyticsDataProvider publishAnalyticsDataProvider();

    @Override // com.avito.android.di.component.HomeActivityDependencies, com.avito.android.notification_center.list.di.NotificationCenterListDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.cpo_program.di.AutotekaCpoProgramDependencies, com.avito.android.feedback_adverts.di.FeedbackAdvertsDependencies
    @NotNull
    SearchSubscriptionSyncRunner searchSubscriptionSyncRunner();

    @Override // com.avito.android.di.component.HomeActivityDependencies, com.avito.android.developments_catalog.di.DevelopmentsCatalogDependencies, com.avito.android.auto_catalog.di.AutoCatalogDependencies, com.avito.android.notification_center.list.di.NotificationCenterListDependencies, com.avito.android.messenger.di.ChannelActivityDependencies, com.avito.android.messenger.di.SendPendingMessagesWorkerComponentDependencies, com.avito.android.messenger.di.DirectReplyServiceDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.cpo_program.di.AutotekaCpoProgramDependencies, com.avito.android.advert.closed.di.ClosedAdvertDependencies, com.avito.android.feedback_adverts.di.FeedbackAdvertsDependencies
    @NotNull
    ServiceIntentFactory serviceIntentFactory();

    @Override // com.avito.android.user_adverts.di.host_fragment.UserAdvertsHostFragmentDependencies, com.avito.android.di.component.HomeActivityDependencies, com.avito.android.notification_center.list.di.NotificationCenterListDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.cpo_program.di.AutotekaCpoProgramDependencies, com.avito.android.advert.closed.di.ClosedAdvertDependencies, com.avito.android.feedback_adverts.di.FeedbackAdvertsDependencies
    @NotNull
    UserAdvertsInfoUpdateRunner userAdvertsInfoUpdateRunner();
}
