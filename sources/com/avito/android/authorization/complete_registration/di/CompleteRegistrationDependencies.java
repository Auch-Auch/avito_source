package com.avito.android.authorization.complete_registration.di;

import com.avito.android.account.AccountUpdateInteractor;
import com.avito.android.account.LoginSuggestStorage;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.preferences.TokenStorage;
import com.avito.android.push.provider.PushTokenProvider;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/avito/android/authorization/complete_registration/di/CompleteRegistrationDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/account/AccountUpdateInteractor;", "accountUpdateInteractor", "()Lcom/avito/android/account/AccountUpdateInteractor;", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "errorConverter", "()Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "Lcom/avito/android/preferences/TokenStorage;", "gcmTokenStorage", "()Lcom/avito/android/preferences/TokenStorage;", "Lcom/avito/android/push/provider/PushTokenProvider;", "pushTokenProvider", "()Lcom/avito/android/push/provider/PushTokenProvider;", "Lcom/avito/android/account/LoginSuggestStorage;", "loginSuggestStorage", "()Lcom/avito/android/account/LoginSuggestStorage;", "Lcom/avito/android/remote/ProfileApi;", "profileApi", "()Lcom/avito/android/remote/ProfileApi;", "authorization_release"}, k = 1, mv = {1, 4, 2})
public interface CompleteRegistrationDependencies extends CoreComponentDependencies {
    @NotNull
    AccountUpdateInteractor accountUpdateInteractor();

    @NotNull
    TypedErrorThrowableConverter errorConverter();

    @Override // com.avito.android.authorization.account_manager.di.AvitoAuthenticatorDependencies
    @NotNull
    TokenStorage gcmTokenStorage();

    @NotNull
    LoginSuggestStorage loginSuggestStorage();

    @Override // com.avito.android.authorization.phone_proving.di.PhoneProvingDependencies, com.avito.android.authorization.reset_password.di.ResetPasswordDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.authorization.account_manager.di.AvitoAuthenticatorDependencies, com.avito.android.soa_stat.di.SoaStatProfileSettingsDependencies, com.avito.android.authorization.login_protection.di.LoginProtectionPhoneListDependencies, com.avito.android.profile_phones.phones_list.di.PhonesListDependencies, com.avito.android.profile_phones.add_phone.di.AddPhoneDependencies, com.avito.android.profile_phones.landline_verification.di.LandlinePhoneVerificationDependencies, com.avito.android.profile_phones.confirm_phone.di.ConfirmPhoneDependencies, com.avito.android.profile_phones.phone_action.di.PhoneActionDependencies, com.avito.android.profile.tfa.settings.di.TfaSettingsDependencies
    @NotNull
    ProfileApi profileApi();

    @Override // com.avito.android.di.AppUpdateServiceDependencies, com.avito.android.push.MessagingDependencies, com.avito.android.push.UpdateInstanceIdDependencies, com.avito.android.authorization.account_manager.di.AvitoAuthenticatorDependencies
    @NotNull
    PushTokenProvider pushTokenProvider();
}
