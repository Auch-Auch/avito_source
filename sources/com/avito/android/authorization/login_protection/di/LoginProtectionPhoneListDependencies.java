package com.avito.android.authorization.login_protection.di;

import com.avito.android.account.AccountInteractor;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/authorization/login_protection/di/LoginProtectionPhoneListDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/remote/ProfileApi;", "profileApi", "()Lcom/avito/android/remote/ProfileApi;", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "Lcom/avito/android/account/AccountInteractor;", "accountInteractor", "()Lcom/avito/android/account/AccountInteractor;", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "typedErrorThrowableConverter", "()Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "authorization_release"}, k = 1, mv = {1, 4, 2})
public interface LoginProtectionPhoneListDependencies extends CoreComponentDependencies {
    @NotNull
    AccountInteractor accountInteractor();

    @Override // com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkDependencies, com.avito.android.profile_phones.phones_list.di.PhonesListDependencies, com.avito.android.profile_phones.add_phone.di.AddPhoneDependencies, com.avito.android.orders.di.component.OrdersDependencies, com.avito.android.booking.di.BookingInfoDependencies, com.avito.android.booking.di.BookingOrderDependencies, com.avito.android.profile.tfa.settings.di.TfaSettingsDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.cart.di.deps.CartSummaryDependencies, com.avito.android.user_stats.di.UserStatsDependencies, com.avito.android.verification.di.VerificationStatusDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies, com.avito.android.screen_opener.di.ProfileScreenResolverFragmentDependencies
    @NotNull
    DeepLinkIntentFactory deepLinkIntentFactory();

    @Override // com.avito.android.profile_phones.phones_list.di.PhonesListDependencies, com.avito.android.profile_phones.add_phone.di.AddPhoneDependencies, com.avito.android.profile_phones.landline_verification.di.LandlinePhoneVerificationDependencies, com.avito.android.profile_phones.confirm_phone.di.ConfirmPhoneDependencies, com.avito.android.profile_phones.phone_action.di.PhoneActionDependencies, com.avito.android.profile.tfa.settings.di.TfaSettingsDependencies
    @NotNull
    ProfileApi profileApi();

    @Override // com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkDependencies, com.avito.android.orders.di.component.OrdersDependencies, com.avito.android.booking.di.BookingInfoDependencies, com.avito.android.booking.di.BookingOrderDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.user_stats.di.UserStatsDependencies, com.avito.android.verification.di.VerificationsListDependencies, com.avito.android.verification.di.VerificationStatusDependencies, com.avito.android.verification.di.VerificationActionDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies
    @NotNull
    TypedErrorThrowableConverter typedErrorThrowableConverter();
}
