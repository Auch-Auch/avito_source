package com.avito.android.payment.lib.di;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.app.external.ApplicationInfoProvider;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.payment.google_pay.GooglePayInteractor;
import com.avito.android.payment.google_pay.GooglePayRequestBuilder;
import com.avito.android.payment.remote.PaymentApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.google.android.gms.wallet.PaymentsClient;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/avito/android/payment/lib/di/PaymentLibraryDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/payment/remote/PaymentApi;", "paymentApi", "()Lcom/avito/android/payment/remote/PaymentApi;", "Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "abTestsConfigProvider", "()Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "Lcom/avito/android/app/external/ApplicationInfoProvider;", "appInfoProvider", "()Lcom/avito/android/app/external/ApplicationInfoProvider;", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deeplinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "typedErrorThrowableConverter", "()Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "()Lcom/avito/android/deep_linking/DeepLinkFactory;", "Lcom/avito/android/payment/google_pay/GooglePayInteractor;", "googlePayInteractor", "()Lcom/avito/android/payment/google_pay/GooglePayInteractor;", "Lcom/google/android/gms/wallet/PaymentsClient;", "paymentsClient", "()Lcom/google/android/gms/wallet/PaymentsClient;", "Lcom/avito/android/payment/google_pay/GooglePayRequestBuilder;", "googlePayRequest", "()Lcom/avito/android/payment/google_pay/GooglePayRequestBuilder;", "payment-lib_release"}, k = 1, mv = {1, 4, 2})
public interface PaymentLibraryDependencies extends CoreComponentDependencies {
    @NotNull
    AbTestsConfigProvider abTestsConfigProvider();

    @NotNull
    ApplicationInfoProvider appInfoProvider();

    @Override // com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.safedeal.delivery_type.di.DeliveryTypeDependencies, com.avito.android.orders.di.component.OrdersDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies
    @NotNull
    DeepLinkFactory deepLinkFactory();

    @Override // com.avito.android.bundles.vas_union.di.VasUnionDependencies, com.avito.android.job.cv_packages.di.CvPackagesDependencies
    @NotNull
    DeepLinkIntentFactory deeplinkIntentFactory();

    @NotNull
    GooglePayInteractor googlePayInteractor();

    @NotNull
    GooglePayRequestBuilder googlePayRequest();

    @NotNull
    PaymentApi paymentApi();

    @NotNull
    PaymentsClient paymentsClient();

    @Override // com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.soa_stat.di.SoaStatProfileSettingsDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.safedeal.delivery_type.di.DeliveryTypeDependencies, com.avito.android.safedeal.profile_settings.di.ProfileDeliverySettingsDependencies, com.avito.android.profile.sessions.list.di.SessionsListDependencies, com.avito.android.profile.sessions.social_logout.di.SessionsSocialLogoutDependencies, com.avito.android.authorization.login_protection.di.LoginProtectionPhoneListDependencies, com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkDependencies, com.avito.android.orders.di.component.OrdersDependencies, com.avito.android.booking.di.BookingInfoDependencies, com.avito.android.booking.di.BookingOrderDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.user_stats.di.UserStatsDependencies, com.avito.android.verification.di.VerificationsListDependencies, com.avito.android.verification.di.VerificationStatusDependencies, com.avito.android.verification.di.VerificationActionDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies
    @NotNull
    TypedErrorThrowableConverter typedErrorThrowableConverter();
}
