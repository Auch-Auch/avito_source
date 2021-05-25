package com.avito.android.profile.di;

import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.remote.LocationApi;
import com.avito.android.remote.ProfileApi;
import com.avito.android.util.PrivatePhotosStorage;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/profile/di/EditProfileDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/remote/LocationApi;", "locationApi", "()Lcom/avito/android/remote/LocationApi;", "Lcom/avito/android/remote/ProfileApi;", "profileApi", "()Lcom/avito/android/remote/ProfileApi;", "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "()Lcom/avito/android/account/AccountStorageInteractor;", "Lcom/avito/android/util/PrivatePhotosStorage;", "privatePhotosStorage", "()Lcom/avito/android/util/PrivatePhotosStorage;", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface EditProfileDependencies extends CoreComponentDependencies {
    @Override // com.avito.android.profile.di.UserProfileDependencies, com.avito.android.user_favorites.di.UserFavoritesDependencies, com.avito.android.abuse.details.di.AbuseDetailsDependencies, com.avito.android.user_adverts.di.host_fragment.UserAdvertsHostFragmentDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.publish.residential_complex_search.di.ResidentialComplexComponentDependencies, com.avito.android.webview.di.WebViewDependencies, com.avito.android.profile.password_change.di.PasswordChangeDependencies, com.avito.android.profile.password_setting.di.PasswordSettingDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.user_adverts.expired_count.di.UserAdvertsInfoDependencies, com.avito.android.profile.sessions.social_logout.di.SessionsSocialLogoutDependencies
    @NotNull
    AccountStorageInteractor accountStorageInteractor();

    @Override // com.avito.android.delivery.di.component.DeliveryLocationSuggestDependencies, com.avito.android.location_list.di.LocationListDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.location.di.LocationDependencies, com.avito.android.suggest_locations.di.SuggestLocationsDependencies, com.avito.android.location_picker.di.LocationPickerDependencies
    @NotNull
    LocationApi locationApi();

    @Override // com.avito.android.publish.di.PublishDependencies, com.avito.android.di.component.ImageUploadServiceDependencies, com.avito.android.photo_picker.legacy.di.PhotoPickerDependencies, com.avito.android.messenger.di.ChannelActivityDependencies, com.avito.android.photo_wizard.di.WizardImageUploadDependencies
    @NotNull
    PrivatePhotosStorage privatePhotosStorage();

    @Override // com.avito.android.profile.di.UserProfileDependencies, com.avito.android.delivery.di.component.DeliveryDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.phone_confirmation.di.PhoneConfirmationDependencies, com.avito.android.profile.password_change.di.PasswordChangeDependencies, com.avito.android.profile.password_setting.di.PasswordSettingDependencies, com.avito.android.contact_access.di.ContactAccessDependencies, com.avito.android.profile_phones.phone_management.di.PhoneManagementDependencies, com.avito.android.social_management.di.SocialManagementDependencies, com.avito.android.code_confirmation.di.CodeConfirmationDependencies, com.avito.android.authorization.login.di.LoginDependencies, com.avito.android.authorization.change_password.di.ChangePasswordDependencies, com.avito.android.authorization.complete_registration.di.CompleteRegistrationDependencies, com.avito.android.authorization.phone_proving.di.PhoneProvingDependencies, com.avito.android.authorization.reset_password.di.ResetPasswordDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.authorization.account_manager.di.AvitoAuthenticatorDependencies, com.avito.android.soa_stat.di.SoaStatProfileSettingsDependencies, com.avito.android.authorization.login_protection.di.LoginProtectionPhoneListDependencies, com.avito.android.profile_phones.phones_list.di.PhonesListDependencies, com.avito.android.profile_phones.add_phone.di.AddPhoneDependencies, com.avito.android.profile_phones.landline_verification.di.LandlinePhoneVerificationDependencies, com.avito.android.profile_phones.confirm_phone.di.ConfirmPhoneDependencies, com.avito.android.profile_phones.phone_action.di.PhoneActionDependencies, com.avito.android.profile.tfa.settings.di.TfaSettingsDependencies
    @NotNull
    ProfileApi profileApi();
}
