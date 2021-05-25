package com.avito.android.webview.di;

import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.server_time.ServerTimeSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/webview/di/WebViewDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "()Lcom/avito/android/deep_linking/DeepLinkFactory;", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "Lcom/avito/android/server_time/ServerTimeSource;", "serverTimeSource", "()Lcom/avito/android/server_time/ServerTimeSource;", "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "()Lcom/avito/android/account/AccountStorageInteractor;", "webview_release"}, k = 1, mv = {1, 4, 2})
public interface WebViewDependencies extends CoreComponentDependencies {
    @Override // com.avito.android.profile.password_change.di.PasswordChangeDependencies, com.avito.android.profile.password_setting.di.PasswordSettingDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.user_adverts.expired_count.di.UserAdvertsInfoDependencies, com.avito.android.profile.sessions.social_logout.di.SessionsSocialLogoutDependencies
    @NotNull
    AccountStorageInteractor accountStorageInteractor();

    @Override // com.avito.android.messenger.di.ChannelActivityDependencies, com.avito.android.messenger.di.MessageIsReadMarkerDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.push.MessagingDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.payment.lib.di.PaymentLibraryDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.safedeal.delivery_type.di.DeliveryTypeDependencies, com.avito.android.orders.di.component.OrdersDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies
    @NotNull
    DeepLinkFactory deepLinkFactory();

    @Override // com.avito.android.profile.password_change.di.PasswordChangeDependencies, com.avito.android.profile.password_setting.di.PasswordSettingDependencies, com.avito.android.public_profile.di.PublicProfileFragmentDependencies, com.avito.android.basket_legacy.di.shared.BasketDependencies, com.avito.android.public_profile.di.PublicProfileActivityDependencies, com.avito.android.rating.details.di.RatingDetailsDependencies, com.avito.android.rating.user_reviews.di.UserReviewsDependencies, com.avito.android.rating.check.di.RatingPublishCheckDependencies, com.avito.android.contact_access.di.ContactAccessDependencies, com.avito.android.category.di.CategoryDependencies, com.avito.android.profile_phones.phone_management.di.PhoneManagementDependencies, com.avito.android.social_management.di.SocialManagementDependencies, com.avito.android.code_confirmation.di.CodeConfirmationDependencies, com.avito.android.authorization.login.di.LoginDependencies, com.avito.android.authorization.phone_proving.di.PhoneProvingDependencies, com.avito.android.messenger.di.ChannelActivityDependencies, com.avito.android.messenger.map.viewing.di.PlatformMapFragmentDependencies, com.avito.android.photo_gallery.di.PhotoGalleryDependencies, com.avito.android.analytics.di.ClickStreamDeepLinkingDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.details_sheet.di.DetailsSheetActivityDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.short_term_rent.di.component.HotelsDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.user_subscribers.di.UserSubscribersDependencies, com.avito.android.rating.review_details.di.ReviewDetailsDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.safedeal.delivery_type.di.DeliveryTypeDependencies, com.avito.android.safedeal.profile_settings.di.ProfileDeliverySettingsDependencies, com.avito.android.advert_core.dialog.di.DialogDeepLinkActivityDependencies, com.avito.android.authorization.login_protection.di.LoginProtectionPhoneListDependencies, com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkDependencies, com.avito.android.profile_phones.phones_list.di.PhonesListDependencies, com.avito.android.profile_phones.add_phone.di.AddPhoneDependencies, com.avito.android.orders.di.component.OrdersDependencies, com.avito.android.booking.di.BookingInfoDependencies, com.avito.android.booking.di.BookingOrderDependencies, com.avito.android.profile.tfa.settings.di.TfaSettingsDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.cart.di.deps.CartSummaryDependencies, com.avito.android.user_stats.di.UserStatsDependencies, com.avito.android.verification.di.VerificationStatusDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies, com.avito.android.screen_opener.di.ProfileScreenResolverFragmentDependencies
    @NotNull
    DeepLinkIntentFactory deepLinkIntentFactory();

    @Override // com.avito.android.autodeal_details.di.AutoDealDetailsDependencies, com.avito.android.certificate_pinning.di.UnsafeNetworkDependencies
    @NotNull
    ServerTimeSource serverTimeSource();
}
