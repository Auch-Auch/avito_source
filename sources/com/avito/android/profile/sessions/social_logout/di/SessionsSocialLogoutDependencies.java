package com.avito.android.profile.sessions.social_logout.di;

import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.remote.SessionsApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/profile/sessions/social_logout/di/SessionsSocialLogoutDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/remote/SessionsApi;", "sessionsApi", "()Lcom/avito/android/remote/SessionsApi;", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "typedErrorThrowableConverter", "()Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "()Lcom/avito/android/account/AccountStorageInteractor;", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface SessionsSocialLogoutDependencies extends CoreComponentDependencies {
    @NotNull
    AccountStorageInteractor accountStorageInteractor();

    @NotNull
    SessionsApi sessionsApi();

    @Override // com.avito.android.authorization.login_protection.di.LoginProtectionPhoneListDependencies, com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkDependencies, com.avito.android.orders.di.component.OrdersDependencies, com.avito.android.booking.di.BookingInfoDependencies, com.avito.android.booking.di.BookingOrderDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.user_stats.di.UserStatsDependencies, com.avito.android.verification.di.VerificationsListDependencies, com.avito.android.verification.di.VerificationStatusDependencies, com.avito.android.verification.di.VerificationActionDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies
    @NotNull
    TypedErrorThrowableConverter typedErrorThrowableConverter();
}
