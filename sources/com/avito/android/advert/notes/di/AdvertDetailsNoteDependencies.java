package com.avito.android.advert.notes.di;

import com.avito.android.advert_details.remote.AdvertDetailsApi;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.favorite.FavoriteAdvertsInteractor;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/advert/notes/di/AdvertDetailsNoteDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/favorite/FavoriteAdvertsInteractor;", "favoriteAdvertsInteractor", "()Lcom/avito/android/favorite/FavoriteAdvertsInteractor;", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "typedErrorThrowableConverter", "()Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "Lcom/avito/android/advert_details/remote/AdvertDetailsApi;", "advertDetailsApi", "()Lcom/avito/android/advert_details/remote/AdvertDetailsApi;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsNoteDependencies extends CoreComponentDependencies {
    @Override // com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.advert.badge_details.di.BadgeDetailsDependencies, com.avito.android.advert.consultation_form.di.ConsultationFormDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    AdvertDetailsApi advertDetailsApi();

    @Override // com.avito.android.advert.closed.di.ClosedAdvertDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies
    @NotNull
    FavoriteAdvertsInteractor favoriteAdvertsInteractor();

    @Override // com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.payment.lib.di.PaymentLibraryDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.soa_stat.di.SoaStatProfileSettingsDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.safedeal.delivery_type.di.DeliveryTypeDependencies, com.avito.android.safedeal.profile_settings.di.ProfileDeliverySettingsDependencies, com.avito.android.profile.sessions.list.di.SessionsListDependencies, com.avito.android.profile.sessions.social_logout.di.SessionsSocialLogoutDependencies, com.avito.android.authorization.login_protection.di.LoginProtectionPhoneListDependencies, com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkDependencies, com.avito.android.orders.di.component.OrdersDependencies, com.avito.android.booking.di.BookingInfoDependencies, com.avito.android.booking.di.BookingOrderDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.user_stats.di.UserStatsDependencies, com.avito.android.verification.di.VerificationsListDependencies, com.avito.android.verification.di.VerificationStatusDependencies, com.avito.android.verification.di.VerificationActionDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies
    @NotNull
    TypedErrorThrowableConverter typedErrorThrowableConverter();
}
