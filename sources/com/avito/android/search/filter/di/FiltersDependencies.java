package com.avito.android.search.filter.di;

import com.avito.android.CategoriesInteractor;
import com.avito.android.ab_tests.AutoGenerationsFilterWithPhotos;
import com.avito.android.ab_tests.groups.SimpleTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.geo.GeoStorage;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlNodeFactory;
import com.avito.android.remote.SearchApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.server_time.TimeSource;
import com.avito.android.server_time.UtcTimeSource;
import com.avito.android.util.preferences.Preferences;
import java.util.Locale;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H&¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H&¢\u0006\u0004\b$\u0010%J\u0015\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&H'¢\u0006\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lcom/avito/android/search/filter/di/FiltersDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/CategoriesInteractor;", "categoriesInteractor", "()Lcom/avito/android/CategoriesInteractor;", "Ljava/util/Locale;", "locale", "()Ljava/util/Locale;", "Lcom/avito/android/remote/SearchApi;", "searchApi", "()Lcom/avito/android/remote/SearchApi;", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "()Lcom/avito/android/server_time/TimeSource;", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "typedErrorThrowableConverter", "()Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "Lcom/avito/android/server_time/UtcTimeSource;", "utcTimeSource", "()Lcom/avito/android/server_time/UtcTimeSource;", "Lcom/avito/android/util/preferences/Preferences;", "preferences", "()Lcom/avito/android/util/preferences/Preferences;", "Lcom/avito/android/html_formatter/HtmlCleaner;", "htmlCleaner", "()Lcom/avito/android/html_formatter/HtmlCleaner;", "Lcom/avito/android/html_formatter/HtmlNodeFactory;", "htmlNodeFactory", "()Lcom/avito/android/html_formatter/HtmlNodeFactory;", "Lcom/avito/android/geo/GeoStorage;", "geoStorage", "()Lcom/avito/android/geo/GeoStorage;", "Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "screenTrackerFactory", "()Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "Lcom/avito/android/analytics/screens/TimerFactory;", "timerFactory", "()Lcom/avito/android/analytics/screens/TimerFactory;", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroup;", "autoGenerationsFilterWithPhotosTestGroup", "()Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "filter_release"}, k = 1, mv = {1, 4, 2})
public interface FiltersDependencies extends CoreComponentDependencies {
    @Override // com.avito.android.select.di.SelectDialogDependencies
    @AutoGenerationsFilterWithPhotos
    @NotNull
    SingleManuallyExposedAbTestGroup<SimpleTestGroup> autoGenerationsFilterWithPhotosTestGroup();

    @NotNull
    CategoriesInteractor categoriesInteractor();

    @Override // com.avito.android.messenger.map.viewing.di.PlatformMapFragmentDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.location_picker.di.LocationPickerDependencies
    @NotNull
    GeoStorage geoStorage();

    @Override // com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrSellerCalendarParametersDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierOrderUpdateDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierSummaryDependencies
    @NotNull
    HtmlCleaner htmlCleaner();

    @Override // com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrSellerCalendarParametersDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierOrderUpdateDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierSummaryDependencies
    @NotNull
    HtmlNodeFactory htmlNodeFactory();

    @Override // com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.messenger.di.ChannelActivityDependencies, com.avito.android.messenger.blacklist.mvi.di.BlacklistFragmentComponentDependencies, com.avito.android.messenger.search.di.ChannelsSearchComponentDependencies, com.avito.android.messenger.channels.mvi.di.ChannelsDependencies, com.avito.android.photo_gallery.di.PhotoGalleryDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.feedback_adverts.di.FeedbackAdvertsDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.location_picker.di.LocationPickerDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    Locale locale();

    @Override // com.avito.android.messenger.di.ChannelActivityDependencies, com.avito.android.photo_gallery.di.PhotoGalleryDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.di.ClickStreamSendDependencies, com.avito.android.settings.di.SettingsDependencies, com.avito.android.push.MessagingDependencies, com.avito.android.app_rater.di.AppRaterDependencies
    @NotNull
    Preferences preferences();

    @Override // com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.messenger.search.di.ChannelsSearchComponentDependencies, com.avito.android.photo_gallery.di.PhotoGalleryDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.photo_gallery.di.GalleryDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.safedeal.profile_settings.di.ProfileDeliverySettingsDependencies, com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkDependencies, com.avito.android.cart.di.deps.CartSummaryDependencies, com.avito.android.user_stats.di.UserStatsDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies
    @NotNull
    ScreenTrackerFactory screenTrackerFactory();

    @Override // com.avito.android.select.di.SelectDialogDependencies, com.avito.android.settings.di.SettingsDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies
    @NotNull
    SearchApi searchApi();

    @Override // com.avito.android.deep_linking.di.AppLinkDependencies, com.avito.android.certificate_pinning.di.UnsafeNetworkDependencies, com.avito.android.messenger.di.ChannelActivityDependencies, com.avito.android.messenger.blacklist.mvi.di.BlacklistFragmentComponentDependencies, com.avito.android.messenger.di.MessageIsReadMarkerDependencies, com.avito.android.messenger.search.di.ChannelsSearchComponentDependencies, com.avito.android.messenger.channels.mvi.di.ChannelsDependencies, com.avito.android.messenger.di.SendPendingMessagesWorkerComponentDependencies, com.avito.android.messenger.di.DirectReplyServiceDependencies, com.avito.android.messenger.map.viewing.di.PlatformMapFragmentDependencies, com.avito.android.deep_linking.di.DeepLinkingDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.location_picker.di.LocationPickerDependencies, com.avito.android.in_app_calls.di.CallActivityComponentDependencies, com.avito.android.in_app_calls.ui.call.CallFragmentComponentDependencies, com.avito.android.in_app_calls.di.CallManagerServiceComponentDependencies, com.avito.android.app_rater.di.AppRaterDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.player.di.PlayerFragmentDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    TimeSource timeSource();

    @Override // com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.messenger.search.di.ChannelsSearchComponentDependencies, com.avito.android.photo_gallery.di.PhotoGalleryDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.photo_gallery.di.GalleryDependencies, com.avito.android.user_stats.di.UserStatsDependencies
    @NotNull
    TimerFactory timerFactory();

    @Override // com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.profile_phones.phone_management.di.PhoneManagementDependencies, com.avito.android.code_confirmation.di.CodeConfirmationDependencies, com.avito.android.authorization.login.di.LoginDependencies, com.avito.android.authorization.reset_password.di.ResetPasswordDependencies, com.avito.android.messenger.di.ChannelActivityDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.notes.di.AdvertDetailsNoteDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.payment.lib.di.PaymentLibraryDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.soa_stat.di.SoaStatProfileSettingsDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.safedeal.delivery_type.di.DeliveryTypeDependencies, com.avito.android.safedeal.profile_settings.di.ProfileDeliverySettingsDependencies, com.avito.android.profile.sessions.list.di.SessionsListDependencies, com.avito.android.profile.sessions.social_logout.di.SessionsSocialLogoutDependencies, com.avito.android.authorization.login_protection.di.LoginProtectionPhoneListDependencies, com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkDependencies, com.avito.android.orders.di.component.OrdersDependencies, com.avito.android.booking.di.BookingInfoDependencies, com.avito.android.booking.di.BookingOrderDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.user_stats.di.UserStatsDependencies, com.avito.android.verification.di.VerificationsListDependencies, com.avito.android.verification.di.VerificationStatusDependencies, com.avito.android.verification.di.VerificationActionDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies
    @NotNull
    TypedErrorThrowableConverter typedErrorThrowableConverter();

    @Override // com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.advert.di.AdvertFragmentDependencies
    @NotNull
    UtcTimeSource utcTimeSource();
}
