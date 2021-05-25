package com.avito.android.authorization.change_password.di;

import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.remote.ProfileApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/authorization/change_password/di/ChangePasswordDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/remote/ProfileApi;", "profileApi", "()Lcom/avito/android/remote/ProfileApi;", "authorization_release"}, k = 1, mv = {1, 4, 2})
public interface ChangePasswordDependencies extends CoreComponentDependencies {
    @Override // com.avito.android.authorization.complete_registration.di.CompleteRegistrationDependencies, com.avito.android.authorization.phone_proving.di.PhoneProvingDependencies, com.avito.android.authorization.reset_password.di.ResetPasswordDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.authorization.account_manager.di.AvitoAuthenticatorDependencies, com.avito.android.soa_stat.di.SoaStatProfileSettingsDependencies, com.avito.android.authorization.login_protection.di.LoginProtectionPhoneListDependencies, com.avito.android.profile_phones.phones_list.di.PhonesListDependencies, com.avito.android.profile_phones.add_phone.di.AddPhoneDependencies, com.avito.android.profile_phones.landline_verification.di.LandlinePhoneVerificationDependencies, com.avito.android.profile_phones.confirm_phone.di.ConfirmPhoneDependencies, com.avito.android.profile_phones.phone_action.di.PhoneActionDependencies, com.avito.android.profile.tfa.settings.di.TfaSettingsDependencies
    @NotNull
    ProfileApi profileApi();
}
