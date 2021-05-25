package com.avito.android.user_advert.di;

import com.avito.android.ServiceIntentFactory;
import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.provider.CurrentUserIdProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.booking.remote.BookingApi;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.di.module.publish.PublishDraftUpdateObservable;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlRenderer;
import com.avito.android.permissions.PermissionStateProvider;
import com.avito.android.permissions.PermissionStorage;
import com.avito.android.profile.ProfileInfoStorage;
import com.avito.android.remote.DeliveryApi;
import com.avito.android.remote.PublishLimitsApi;
import com.avito.android.remote.ShortTermRentApi;
import com.avito.android.remote.UserAdvertsCommonApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.safedeal.remote.SafeDealApi;
import com.avito.android.search.subscriptions.sync.SearchSubscriptionSyncRunner;
import com.avito.android.serp.ad.MyTargetImageBgProvider;
import com.avito.android.server_time.TimeSource;
import com.avito.android.social.SocialTypeToStringMapper;
import com.avito.android.user_advert.UserAdvertsInfoUpdateRunner;
import com.avito.android.user_advert_api.remote.UserAdvertApi;
import com.avito.android.util.preferences.PreferenceFactory;
import com.avito.android.util.preferences.Preferences;
import com.jakewharton.rxrelay3.PublishRelay;
import java.util.Locale;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H&¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H&¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H&¢\u0006\u0004\b'\u0010(J\u000f\u0010*\u001a\u00020)H&¢\u0006\u0004\b*\u0010+J\u000f\u0010-\u001a\u00020,H&¢\u0006\u0004\b-\u0010.J\u000f\u00100\u001a\u00020/H&¢\u0006\u0004\b0\u00101J\u000f\u00103\u001a\u000202H&¢\u0006\u0004\b3\u00104J\u000f\u00106\u001a\u000205H&¢\u0006\u0004\b6\u00107J\u000f\u00109\u001a\u000208H&¢\u0006\u0004\b9\u0010:J\u000f\u0010<\u001a\u00020;H&¢\u0006\u0004\b<\u0010=J\u000f\u0010?\u001a\u00020>H&¢\u0006\u0004\b?\u0010@J\u000f\u0010B\u001a\u00020AH&¢\u0006\u0004\bB\u0010CJ\u000f\u0010E\u001a\u00020DH&¢\u0006\u0004\bE\u0010FJ\u000f\u0010H\u001a\u00020GH&¢\u0006\u0004\bH\u0010IJ\u000f\u0010K\u001a\u00020JH&¢\u0006\u0004\bK\u0010LJ\u000f\u0010N\u001a\u00020MH&¢\u0006\u0004\bN\u0010OJ\u000f\u0010Q\u001a\u00020PH&¢\u0006\u0004\bQ\u0010RJ\u000f\u0010T\u001a\u00020SH&¢\u0006\u0004\bT\u0010UJ\u0015\u0010X\u001a\b\u0012\u0004\u0012\u00020W0VH'¢\u0006\u0004\bX\u0010YJ\u000f\u0010[\u001a\u00020ZH&¢\u0006\u0004\b[\u0010\\¨\u0006]"}, d2 = {"Lcom/avito/android/user_advert/di/MyAdvertDetailsDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "abTestsConfigProvider", "()Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "()Lcom/avito/android/account/AccountStateProvider;", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "()Lcom/avito/android/deep_linking/DeepLinkFactory;", "Lcom/avito/android/remote/DeliveryApi;", "deliveryApi", "()Lcom/avito/android/remote/DeliveryApi;", "Lcom/avito/android/booking/remote/BookingApi;", "bookingApi", "()Lcom/avito/android/booking/remote/BookingApi;", "Ljava/util/Locale;", "locale", "()Ljava/util/Locale;", "Lcom/avito/android/profile/ProfileInfoStorage;", "profileInfoStorage", "()Lcom/avito/android/profile/ProfileInfoStorage;", "Lcom/avito/android/remote/ShortTermRentApi;", "shortTermRentApi", "()Lcom/avito/android/remote/ShortTermRentApi;", "Lcom/avito/android/social/SocialTypeToStringMapper;", "socialTypeToStringMapper", "()Lcom/avito/android/social/SocialTypeToStringMapper;", "Lcom/avito/android/search/subscriptions/sync/SearchSubscriptionSyncRunner;", "searchSubscriptionSyncRunner", "()Lcom/avito/android/search/subscriptions/sync/SearchSubscriptionSyncRunner;", "Lcom/avito/android/ServiceIntentFactory;", "serviceIntentFactory", "()Lcom/avito/android/ServiceIntentFactory;", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "()Lcom/avito/android/server_time/TimeSource;", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "typedErrorThrowableConverter", "()Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "Lcom/avito/android/user_advert_api/remote/UserAdvertApi;", "userAdvertApi", "()Lcom/avito/android/user_advert_api/remote/UserAdvertApi;", "Lcom/avito/android/remote/PublishLimitsApi;", "limitsInfoApi", "()Lcom/avito/android/remote/PublishLimitsApi;", "Lcom/avito/android/user_advert/UserAdvertsInfoUpdateRunner;", "userAdvertsInfoUpdateRunner", "()Lcom/avito/android/user_advert/UserAdvertsInfoUpdateRunner;", "Lcom/avito/android/util/preferences/Preferences;", "preferences", "()Lcom/avito/android/util/preferences/Preferences;", "Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "screenTrackerFactory", "()Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "Lcom/avito/android/analytics/screens/TimerFactory;", "timerFactory", "()Lcom/avito/android/analytics/screens/TimerFactory;", "Lcom/avito/android/safedeal/remote/SafeDealApi;", "safeDealApi", "()Lcom/avito/android/safedeal/remote/SafeDealApi;", "Lcom/avito/android/remote/UserAdvertsCommonApi;", "userAdvertsCommonApi", "()Lcom/avito/android/remote/UserAdvertsCommonApi;", "Lcom/avito/android/analytics/provider/CurrentUserIdProvider;", "currentUserProvider", "()Lcom/avito/android/analytics/provider/CurrentUserIdProvider;", "Lcom/avito/android/permissions/PermissionStateProvider;", "permissionStateProvider", "()Lcom/avito/android/permissions/PermissionStateProvider;", "Lcom/avito/android/permissions/PermissionStorage;", "permissionStorage", "()Lcom/avito/android/permissions/PermissionStorage;", "Lcom/avito/android/html_formatter/HtmlCleaner;", "htmlCleaner", "()Lcom/avito/android/html_formatter/HtmlCleaner;", "Lcom/avito/android/html_formatter/HtmlRenderer;", "htmlRenderer", "()Lcom/avito/android/html_formatter/HtmlRenderer;", "Lcom/avito/android/serp/ad/MyTargetImageBgProvider;", "myTargetImageBgProvider", "()Lcom/avito/android/serp/ad/MyTargetImageBgProvider;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "", "draftSaveObservable", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/util/preferences/PreferenceFactory;", "preferenceFactory", "()Lcom/avito/android/util/preferences/PreferenceFactory;", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public interface MyAdvertDetailsDependencies extends CoreComponentDependencies {
    @Override // com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.advert.closed.di.ClosedAdvertDependencies, com.avito.android.payment.lib.di.PaymentLibraryDependencies
    @NotNull
    AbTestsConfigProvider abTestsConfigProvider();

    @Override // com.avito.android.short_term_rent.di.component.StrStartBookingDependencies, com.avito.android.messenger.map.search.di.GeoSearchFragmentDependencies, com.avito.android.in_app_calls.workers.CallAvailabilityComponentDependencies, com.avito.android.in_app_calls.ui.call.CallFragmentComponentDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.safedeal.delivery_type.di.DeliveryTypeDependencies, com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkDependencies, com.avito.android.booking.di.BookingOrderDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.cart.di.deps.CartSummaryDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    AccountStateProvider accountStateProvider();

    @Override // com.avito.android.booking.di.BookingInfoDependencies, com.avito.android.booking.di.BookingOrderDependencies
    @NotNull
    BookingApi bookingApi();

    @NotNull
    CurrentUserIdProvider currentUserProvider();

    @Override // com.avito.android.push.MessagingDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.payment.lib.di.PaymentLibraryDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.safedeal.delivery_type.di.DeliveryTypeDependencies, com.avito.android.orders.di.component.OrdersDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies
    @NotNull
    DeepLinkFactory deepLinkFactory();

    @Override // com.avito.android.details_sheet.di.DetailsSheetActivityDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.short_term_rent.di.component.HotelsDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.user_subscribers.di.UserSubscribersDependencies, com.avito.android.rating.review_details.di.ReviewDetailsDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.safedeal.delivery_type.di.DeliveryTypeDependencies, com.avito.android.safedeal.profile_settings.di.ProfileDeliverySettingsDependencies, com.avito.android.advert_core.dialog.di.DialogDeepLinkActivityDependencies, com.avito.android.authorization.login_protection.di.LoginProtectionPhoneListDependencies, com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkDependencies, com.avito.android.profile_phones.phones_list.di.PhonesListDependencies, com.avito.android.profile_phones.add_phone.di.AddPhoneDependencies, com.avito.android.orders.di.component.OrdersDependencies, com.avito.android.booking.di.BookingInfoDependencies, com.avito.android.booking.di.BookingOrderDependencies, com.avito.android.profile.tfa.settings.di.TfaSettingsDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.cart.di.deps.CartSummaryDependencies, com.avito.android.user_stats.di.UserStatsDependencies, com.avito.android.verification.di.VerificationStatusDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies, com.avito.android.screen_opener.di.ProfileScreenResolverFragmentDependencies
    @NotNull
    DeepLinkIntentFactory deepLinkIntentFactory();

    @Override // com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies
    @NotNull
    DeliveryApi deliveryApi();

    @PublishDraftUpdateObservable
    @NotNull
    PublishRelay<String> draftSaveObservable();

    @Override // com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrSellerCalendarParametersDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierOrderUpdateDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierSummaryDependencies
    @NotNull
    HtmlCleaner htmlCleaner();

    @Override // com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrSellerCalendarParametersDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierOrderUpdateDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierSummaryDependencies
    @NotNull
    HtmlRenderer htmlRenderer();

    @NotNull
    PublishLimitsApi limitsInfoApi();

    @Override // com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.feedback_adverts.di.FeedbackAdvertsDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.location_picker.di.LocationPickerDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    Locale locale();

    @Override // com.avito.android.advert.di.AdvertFragmentDependencies
    @NotNull
    MyTargetImageBgProvider myTargetImageBgProvider();

    @Override // com.avito.android.in_app_calls.workers.CallAvailabilityComponentDependencies
    @NotNull
    PermissionStateProvider permissionStateProvider();

    @NotNull
    PermissionStorage permissionStorage();

    @Override // com.avito.android.user_stats.di.UserStatsDependencies
    @NotNull
    PreferenceFactory preferenceFactory();

    @Override // com.avito.android.di.ClickStreamSendDependencies, com.avito.android.settings.di.SettingsDependencies, com.avito.android.push.MessagingDependencies, com.avito.android.app_rater.di.AppRaterDependencies
    @NotNull
    Preferences preferences();

    @Override // com.avito.android.settings.di.SettingsDependencies, com.avito.android.advert.di.AdvertFragmentDependencies
    @NotNull
    ProfileInfoStorage profileInfoStorage();

    @Override // com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.safedeal.delivery_type.di.DeliveryTypeDependencies
    @NotNull
    SafeDealApi safeDealApi();

    @Override // com.avito.android.photo_gallery.di.GalleryDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.safedeal.profile_settings.di.ProfileDeliverySettingsDependencies, com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkDependencies, com.avito.android.cart.di.deps.CartSummaryDependencies, com.avito.android.user_stats.di.UserStatsDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies
    @NotNull
    ScreenTrackerFactory screenTrackerFactory();

    @Override // com.avito.android.advert.cpo_program.di.AutotekaCpoProgramDependencies, com.avito.android.feedback_adverts.di.FeedbackAdvertsDependencies
    @NotNull
    SearchSubscriptionSyncRunner searchSubscriptionSyncRunner();

    @Override // com.avito.android.advert.cpo_program.di.AutotekaCpoProgramDependencies, com.avito.android.advert.closed.di.ClosedAdvertDependencies, com.avito.android.feedback_adverts.di.FeedbackAdvertsDependencies
    @NotNull
    ServiceIntentFactory serviceIntentFactory();

    @Override // com.avito.android.advert.consultation_form.di.ConsultationFormDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.short_term_rent.di.component.HotelsDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies
    @NotNull
    ShortTermRentApi shortTermRentApi();

    @NotNull
    SocialTypeToStringMapper socialTypeToStringMapper();

    @Override // com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.location_picker.di.LocationPickerDependencies, com.avito.android.in_app_calls.di.CallActivityComponentDependencies, com.avito.android.in_app_calls.ui.call.CallFragmentComponentDependencies, com.avito.android.in_app_calls.di.CallManagerServiceComponentDependencies, com.avito.android.app_rater.di.AppRaterDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.player.di.PlayerFragmentDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    TimeSource timeSource();

    @Override // com.avito.android.photo_gallery.di.GalleryDependencies, com.avito.android.user_stats.di.UserStatsDependencies
    @NotNull
    TimerFactory timerFactory();

    @Override // com.avito.android.advert.notes.di.AdvertDetailsNoteDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.payment.lib.di.PaymentLibraryDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.soa_stat.di.SoaStatProfileSettingsDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.safedeal.delivery_type.di.DeliveryTypeDependencies, com.avito.android.safedeal.profile_settings.di.ProfileDeliverySettingsDependencies, com.avito.android.profile.sessions.list.di.SessionsListDependencies, com.avito.android.profile.sessions.social_logout.di.SessionsSocialLogoutDependencies, com.avito.android.authorization.login_protection.di.LoginProtectionPhoneListDependencies, com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkDependencies, com.avito.android.orders.di.component.OrdersDependencies, com.avito.android.booking.di.BookingInfoDependencies, com.avito.android.booking.di.BookingOrderDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.user_stats.di.UserStatsDependencies, com.avito.android.verification.di.VerificationsListDependencies, com.avito.android.verification.di.VerificationStatusDependencies, com.avito.android.verification.di.VerificationActionDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies
    @NotNull
    TypedErrorThrowableConverter typedErrorThrowableConverter();

    @NotNull
    UserAdvertApi userAdvertApi();

    @NotNull
    UserAdvertsCommonApi userAdvertsCommonApi();

    @Override // com.avito.android.advert.cpo_program.di.AutotekaCpoProgramDependencies, com.avito.android.advert.closed.di.ClosedAdvertDependencies, com.avito.android.feedback_adverts.di.FeedbackAdvertsDependencies
    @NotNull
    UserAdvertsInfoUpdateRunner userAdvertsInfoUpdateRunner();
}
