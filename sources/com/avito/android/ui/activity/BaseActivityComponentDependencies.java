package com.avito.android.ui.activity;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.grafana.GraphitePrefix;
import com.avito.android.di.ComponentDependencies;
import com.avito.android.lib.util.DarkThemeConfig;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/ui/activity/BaseActivityComponentDependencies;", "Lcom/avito/android/di/ComponentDependencies;", "Lcom/avito/android/analytics/Analytics;", "analytics", "()Lcom/avito/android/analytics/Analytics;", "Lcom/avito/android/Features;", "features", "()Lcom/avito/android/Features;", "Lcom/avito/android/analytics/grafana/GraphitePrefix;", "graphitePrefix", "()Lcom/avito/android/analytics/grafana/GraphitePrefix;", "Lcom/avito/android/lib/util/DarkThemeConfig;", "darkThemeConfig", "()Lcom/avito/android/lib/util/DarkThemeConfig;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface BaseActivityComponentDependencies extends ComponentDependencies {
    @Override // com.avito.android.cart_fab.CartFabDependencies, com.avito.android.rating.publish.select_advert.di.SelectAdvertDependencies, com.avito.android.rating.publish.buyer_info.di.BuyerInfoDependencies, com.avito.android.rating.publish.deal_proofs.di.DealProofsDependencies, com.avito.android.rating.publish.deal_stage.di.DealStageDependencies, com.avito.android.rating.publish.select_rating.di.SelectRatingDependencies, com.avito.android.rating.publish.review_input.di.ReviewInputDependencies, com.avito.android.rating.publish.di.RatingPublishDependencies, com.avito.android.rating.user_contacts.di.UserContactsDependencies, com.avito.android.rating.user_review_details.di.UserReviewDetailsDependencies, com.avito.android.theme_settings.di.ThemeSettingsDependencies, com.avito.android.favorite_sellers.service.di.FavoriteSellerServiceDependencies, com.avito.android.grouping_adverts.di.GroupingAdvertsDependencies, com.avito.android.notification_center.landing.share.NotificationCenterLandingShareDependencies, com.avito.android.delivery.di.component.DeliveryRdsCommonDependencies, com.avito.android.publish.drafts.di.PublishDraftsDependencies, com.avito.android.user_advert.advert.service.di.UserAdvertServiceDependencies, com.avito.android.user_adverts.items_search.di.ProfileItemsSearchDependencies, com.avito.android.favorites.di.FavoriteAdvertsServiceDependencies, com.avito.android.di.component.HomeActivityDependencies, com.avito.android.di.component.StoriesDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.publish.start_publish.di.StartPublishDependencies, com.avito.android.publish_limits_info.history.di.PublishLimitsHistoryDependencies, com.avito.android.basket_legacy.di.shared.BasketDependencies, com.avito.android.rating.user_reviews.di.UserReviewsDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.info.di.InfoActivityDependencies, com.avito.android.photo_gallery.di.GalleryDependencies, com.avito.android.push.MessagingDependencies, com.avito.android.push.UpdateInstanceIdDependencies, com.avito.android.details_sheet.di.DetailsSheetActivityDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.short_term_rent.di.component.HotelsDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.suggest_locations.di.SuggestLocationsDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.location_picker.di.LocationPickerDependencies, com.avito.android.rating.review_details.di.ReviewDetailsDependencies, com.avito.android.app_rater.di.AppRaterDependencies, com.avito.android.soa_stat.di.SoaStatProfileSettingsDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.profile_phones.phones_list.di.PhonesListDependencies, com.avito.android.profile_phones.add_phone.di.AddPhoneDependencies, com.avito.android.profile_phones.landline_verification.di.LandlinePhoneVerificationDependencies, com.avito.android.profile_phones.confirm_phone.di.ConfirmPhoneDependencies, com.avito.android.profile_phones.phone_action.di.PhoneActionDependencies
    @NotNull
    Analytics analytics();

    @Override // com.avito.android.di.component.HomeDependencies, com.avito.android.di.component.StoriesDependencies, com.avito.android.settings.di.SettingsDependencies
    @NotNull
    DarkThemeConfig darkThemeConfig();

    @Override // com.avito.android.cart_fab.CartFabDependencies, com.avito.android.rating.publish.select_advert.di.SelectAdvertDependencies, com.avito.android.rating.publish.di.RatingPublishDependencies, com.avito.android.rating.user_review_details.di.UserReviewDetailsDependencies, com.avito.android.grouping_adverts.di.GroupingAdvertsDependencies, com.avito.android.delivery.di.component.DeliveryRdsCommonDependencies, com.avito.android.user_advert.advert.service.di.UserAdvertServiceDependencies, com.avito.android.user_adverts.items_search.di.ProfileItemsSearchDependencies, com.avito.android.favorites.di.FavoriteAdvertsServiceDependencies, com.avito.android.di.component.HomeActivityDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.vas_performance.di.applied_services.AppliedServicesDependencies, com.avito.android.basket_legacy.di.shared.BasketDependencies, com.avito.android.rating.user_reviews.di.UserReviewsDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.photo_gallery.di.GalleryDependencies, com.avito.android.push.MessagingDependencies, com.avito.android.authorization.account_manager.di.AvitoAuthenticatorDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.suggest_locations.di.SuggestLocationsDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.location_picker.di.LocationPickerDependencies, com.avito.android.rating.review_details.di.ReviewDetailsDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.social.di.esia.EsiaAuthDependencies, com.avito.android.social.di.AppleAuthDependencies, com.avito.android.profile_phones.phones_list.di.PhonesListDependencies
    @NotNull
    Features features();

    @Override // com.avito.android.search.map.di.SearchMapDependencies, com.avito.android.di.SendDataSizeDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.item_map.di.ItemMapDependencies
    @NotNull
    GraphitePrefix graphitePrefix();
}
