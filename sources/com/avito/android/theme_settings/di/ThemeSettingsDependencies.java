package com.avito.android.theme_settings.di;

import com.avito.android.analytics.Analytics;
import com.avito.android.di.ComponentDependencies;
import com.avito.android.lib.util.DarkThemeManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/theme_settings/di/ThemeSettingsDependencies;", "Lcom/avito/android/di/ComponentDependencies;", "Lcom/avito/android/lib/util/DarkThemeManager;", "darkThemeManager", "()Lcom/avito/android/lib/util/DarkThemeManager;", "Lcom/avito/android/analytics/Analytics;", "analytics", "()Lcom/avito/android/analytics/Analytics;", "settings_release"}, k = 1, mv = {1, 4, 2})
public interface ThemeSettingsDependencies extends ComponentDependencies {
    @Override // com.avito.android.favorite_sellers.service.di.FavoriteSellerServiceDependencies, com.avito.android.grouping_adverts.di.GroupingAdvertsDependencies, com.avito.android.notification_center.landing.share.NotificationCenterLandingShareDependencies, com.avito.android.delivery.di.component.DeliveryRdsCommonDependencies, com.avito.android.publish.drafts.di.PublishDraftsDependencies, com.avito.android.user_advert.advert.service.di.UserAdvertServiceDependencies, com.avito.android.user_adverts.items_search.di.ProfileItemsSearchDependencies, com.avito.android.favorites.di.FavoriteAdvertsServiceDependencies, com.avito.android.di.component.HomeActivityDependencies, com.avito.android.di.component.StoriesDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.publish.start_publish.di.StartPublishDependencies, com.avito.android.publish_limits_info.history.di.PublishLimitsHistoryDependencies, com.avito.android.basket_legacy.di.shared.BasketDependencies, com.avito.android.rating.user_reviews.di.UserReviewsDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.info.di.InfoActivityDependencies, com.avito.android.photo_gallery.di.GalleryDependencies, com.avito.android.push.MessagingDependencies, com.avito.android.push.UpdateInstanceIdDependencies, com.avito.android.details_sheet.di.DetailsSheetActivityDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.short_term_rent.di.component.HotelsDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.suggest_locations.di.SuggestLocationsDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.location_picker.di.LocationPickerDependencies, com.avito.android.rating.review_details.di.ReviewDetailsDependencies, com.avito.android.app_rater.di.AppRaterDependencies, com.avito.android.soa_stat.di.SoaStatProfileSettingsDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.profile_phones.phones_list.di.PhonesListDependencies, com.avito.android.profile_phones.add_phone.di.AddPhoneDependencies, com.avito.android.profile_phones.landline_verification.di.LandlinePhoneVerificationDependencies, com.avito.android.profile_phones.confirm_phone.di.ConfirmPhoneDependencies, com.avito.android.profile_phones.phone_action.di.PhoneActionDependencies
    @NotNull
    Analytics analytics();

    @Override // com.avito.android.settings.di.SettingsDependencies
    @NotNull
    DarkThemeManager darkThemeManager();
}
