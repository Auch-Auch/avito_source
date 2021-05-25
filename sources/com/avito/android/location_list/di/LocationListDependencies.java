package com.avito.android.location_list.di;

import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.geo.GeoStorage;
import com.avito.android.remote.LocationApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.server_time.TimeSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/location_list/di/LocationListDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/remote/LocationApi;", "locationApi", "()Lcom/avito/android/remote/LocationApi;", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "typedErrorThrowableConverter", "()Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "Lcom/avito/android/geo/GeoStorage;", "geoStorage", "()Lcom/avito/android/geo/GeoStorage;", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "()Lcom/avito/android/server_time/TimeSource;", "location-list_release"}, k = 1, mv = {1, 4, 2})
public interface LocationListDependencies extends CoreComponentDependencies {
    @Override // com.avito.android.search.map.di.SearchMapDependencies, com.avito.android.geo.di.GeoDependencies, com.avito.android.search.filter.di.FiltersDependencies, com.avito.android.messenger.map.viewing.di.PlatformMapFragmentDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.location_picker.di.LocationPickerDependencies
    @NotNull
    GeoStorage geoStorage();

    @Override // com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.location.di.LocationDependencies, com.avito.android.suggest_locations.di.SuggestLocationsDependencies, com.avito.android.location_picker.di.LocationPickerDependencies
    @NotNull
    LocationApi locationApi();

    @Override // com.avito.android.auto_catalog.di.AutoCatalogDependencies, com.avito.android.search.map.di.SearchMapDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.phone_confirmation.di.PhoneConfirmationDependencies, com.avito.android.favorites.di.FavoriteAdvertsDependencies, com.avito.android.viewed_items.di.ViewedItemsDependencies, com.avito.android.payment.di.component.PaymentDependencies, com.avito.android.notification_center.list.di.NotificationCenterListDependencies, com.avito.android.notification_center.landing.recommends.di.NotificationCenterLandingRecommendsDependencies, com.avito.android.notification_center.landing.unified.di.NotificationCenterLandingUnifiedDependencies, com.avito.android.express_cv.di.ExpressCvDependencies, com.avito.android.geo.di.GeoDependencies, com.avito.android.search.filter.di.FiltersDependencies, com.avito.android.deep_linking.di.AppLinkDependencies, com.avito.android.certificate_pinning.di.UnsafeNetworkDependencies, com.avito.android.messenger.di.ChannelActivityDependencies, com.avito.android.messenger.blacklist.mvi.di.BlacklistFragmentComponentDependencies, com.avito.android.messenger.di.MessageIsReadMarkerDependencies, com.avito.android.messenger.search.di.ChannelsSearchComponentDependencies, com.avito.android.messenger.channels.mvi.di.ChannelsDependencies, com.avito.android.messenger.di.SendPendingMessagesWorkerComponentDependencies, com.avito.android.messenger.di.DirectReplyServiceDependencies, com.avito.android.messenger.map.viewing.di.PlatformMapFragmentDependencies, com.avito.android.deep_linking.di.DeepLinkingDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.location_picker.di.LocationPickerDependencies, com.avito.android.in_app_calls.di.CallActivityComponentDependencies, com.avito.android.in_app_calls.ui.call.CallFragmentComponentDependencies, com.avito.android.in_app_calls.di.CallManagerServiceComponentDependencies, com.avito.android.app_rater.di.AppRaterDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.player.di.PlayerFragmentDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    TimeSource timeSource();

    @Override // com.avito.android.developments_catalog.di.DevelopmentsCatalogDependencies, com.avito.android.auto_catalog.di.AutoCatalogDependencies, com.avito.android.search.map.di.SearchMapDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.publish.start_publish.di.StartPublishDependencies, com.avito.android.publish.di.NewAdvertDependencies, com.avito.android.publish_limits_info.history.di.PublishLimitsHistoryDependencies, com.avito.android.favorites.di.FavoriteAdvertsDependencies, com.avito.android.viewed_items.di.ViewedItemsDependencies, com.avito.android.autoteka_details.di.AutotekaDetailsDependencies, com.avito.android.search.filter.di.FiltersDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.profile_phones.phone_management.di.PhoneManagementDependencies, com.avito.android.code_confirmation.di.CodeConfirmationDependencies, com.avito.android.authorization.login.di.LoginDependencies, com.avito.android.authorization.reset_password.di.ResetPasswordDependencies, com.avito.android.messenger.di.ChannelActivityDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.notes.di.AdvertDetailsNoteDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.payment.lib.di.PaymentLibraryDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.soa_stat.di.SoaStatProfileSettingsDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.safedeal.delivery_type.di.DeliveryTypeDependencies, com.avito.android.safedeal.profile_settings.di.ProfileDeliverySettingsDependencies, com.avito.android.profile.sessions.list.di.SessionsListDependencies, com.avito.android.profile.sessions.social_logout.di.SessionsSocialLogoutDependencies, com.avito.android.authorization.login_protection.di.LoginProtectionPhoneListDependencies, com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkDependencies, com.avito.android.orders.di.component.OrdersDependencies, com.avito.android.booking.di.BookingInfoDependencies, com.avito.android.booking.di.BookingOrderDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.user_stats.di.UserStatsDependencies, com.avito.android.verification.di.VerificationsListDependencies, com.avito.android.verification.di.VerificationStatusDependencies, com.avito.android.verification.di.VerificationActionDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies
    @NotNull
    TypedErrorThrowableConverter typedErrorThrowableConverter();
}
