package com.avito.android.authorization.select_social.di;

import com.avito.android.account.AccountInteractor;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.social.SocialTypeToStringMapper;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/authorization/select_social/di/SelectSocialDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/account/AccountInteractor;", "accountInteractor", "()Lcom/avito/android/account/AccountInteractor;", "Lcom/avito/android/social/SocialTypeToStringMapper;", "socialTypeToStringMapper", "()Lcom/avito/android/social/SocialTypeToStringMapper;", "authorization_release"}, k = 1, mv = {1, 4, 2})
public interface SelectSocialDependencies extends CoreComponentDependencies {
    @Override // com.avito.android.profile.di.UserProfileDependencies, com.avito.android.code_confirmation.di.CodeConfirmationDependencies, com.avito.android.authorization.login.di.LoginDependencies, com.avito.android.authorization.login_protection.di.LoginProtectionPhoneListDependencies
    @NotNull
    AccountInteractor accountInteractor();

    @Override // com.avito.android.social_management.di.SocialManagementDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies
    @NotNull
    SocialTypeToStringMapper socialTypeToStringMapper();
}
