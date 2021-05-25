package com.avito.android.authorization;

import android.app.Application;
import android.content.Intent;
import android.os.Parcelable;
import com.avito.android.AuthIntentFactory;
import com.avito.android.Features;
import com.avito.android.authorization.auth.AuthActivityKt;
import com.avito.android.authorization.auth.OldAuthActivityKt;
import com.avito.android.authorization.change_password.ChangePasswordActivityKt;
import com.avito.android.authorization.complete_registration.CompleteRegistrationActivityKt;
import com.avito.android.authorization.login.LoginActivityKt;
import com.avito.android.authorization.login_protection.LoginProtectionPhoneListActivityKt;
import com.avito.android.authorization.login_suggests.LoginSuggestsActivityKt;
import com.avito.android.authorization.phone_proving.PhoneProvingActivityKt;
import com.avito.android.authorization.reset_password.ResetPasswordActivityKt;
import com.avito.android.authorization.select_profile.SelectProfileActivityKt;
import com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsActivityKt;
import com.avito.android.authorization.select_social.SelectSocialActivityKt;
import com.avito.android.authorization.start_registration.StartRegistrationActivityKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.registration.ProfileSocial;
import com.avito.android.remote.model.registration.RegisteredProfile;
import com.avito.android.util.preferences.Preference;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u00109\u001a\u000206\u0012\u0006\u0010=\u001a\u00020:¢\u0006\u0004\b>\u0010?J-\u0010\b\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ)\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ1\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J9\u0010\u0019\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJE\u0010\"\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001f\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010\u00042\u0006\u0010!\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\"\u0010#J+\u0010%\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010$\u001a\u00020\u00122\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b'\u0010(J'\u0010)\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b)\u0010*J'\u0010+\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b+\u0010*J/\u0010.\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\f\u0010-\u001a\b\u0012\u0004\u0012\u00020,0\u00162\b\u0010 \u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b.\u0010/J=\u00104\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\f\u00102\u001a\b\u0012\u0004\u0012\u0002010\u00162\u0006\u00103\u001a\u00020\u0004H\u0016¢\u0006\u0004\b4\u00105R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006@"}, d2 = {"Lcom/avito/android/authorization/AuthIntentFactoryImpl;", "Lcom/avito/android/AuthIntentFactory;", "Landroid/content/Intent;", "successAuthIntent", "", "src", "Landroid/os/Parcelable;", "successAuthResultData", "authIntent", "(Landroid/content/Intent;Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;", "login", "hash", "source", "changePasswordIntent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "challengeId", "phonePart", "inputHint", "", "isOpenedFromPhoneList", "phoneProvingIntent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Landroid/content/Intent;", "", "phones", "isAntihackMode", "antihackPhoneListIntent", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Z)Landroid/content/Intent;", "loginSuggests", "()Landroid/content/Intent;", "intent", Preference.PASSWORD, "isHiddenLogin", "suggestKey", "skipSavedLogin", "loginIntent", "(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Z)Landroid/content/Intent;", "skipLoginEntry", "resetPasswordIntent", "(Ljava/lang/String;ZLjava/lang/String;)Landroid/content/Intent;", "registrationActivityIntent", "(Landroid/content/Intent;)Landroid/content/Intent;", "completeRegistrationIntent", "(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "selectProfileIntent", "Lcom/avito/android/remote/model/registration/ProfileSocial;", "socialList", "selectSocialIntent", "(Landroid/content/Intent;Ljava/util/List;Ljava/lang/String;)Landroid/content/Intent;", "title", "Lcom/avito/android/remote/model/registration/RegisteredProfile;", "profiles", "socialType", "socialRegistrationSuggestsIntent", "(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Landroid/content/Intent;", "Landroid/app/Application;", AuthSource.SEND_ABUSE, "Landroid/app/Application;", "context", "Lcom/avito/android/Features;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/Features;", "features", "<init>", "(Landroid/app/Application;Lcom/avito/android/Features;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class AuthIntentFactoryImpl implements AuthIntentFactory {
    public final Application a;
    public final Features b;

    @Inject
    public AuthIntentFactoryImpl(@NotNull Application application, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(application, "context");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = application;
        this.b = features;
    }

    @Override // com.avito.android.AuthIntentFactory
    @NotNull
    public Intent antihackPhoneListIntent(@Nullable String str, @NotNull List<String> list, @Nullable String str2, boolean z) {
        Intrinsics.checkNotNullParameter(list, "phones");
        return LoginProtectionPhoneListActivityKt.createLoginProtectionPhoneListActivityIntent(this.a, str, list, str2, z);
    }

    @Override // com.avito.android.AuthIntentFactory
    @NotNull
    public Intent authIntent(@Nullable Intent intent, @Nullable String str, @Nullable Parcelable parcelable) {
        if (this.b.getAuthAsFragment().invoke().booleanValue()) {
            return AuthActivityKt.createAuthIntent(this.a, intent, str, parcelable);
        }
        return OldAuthActivityKt.createOldAuthIntent(this.a, intent, str, parcelable);
    }

    @Override // com.avito.android.AuthIntentFactory
    @NotNull
    public Intent changePasswordIntent(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "login");
        Intrinsics.checkNotNullParameter(str2, "hash");
        return ChangePasswordActivityKt.createChangePasswordActivityIntent(this.a, str, str2, str3);
    }

    @Override // com.avito.android.AuthIntentFactory
    @NotNull
    public Intent completeRegistrationIntent(@NotNull Intent intent, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(str, "login");
        Intrinsics.checkNotNullParameter(str2, "hash");
        return CompleteRegistrationActivityKt.createCompleteRegistrationActivityIntent(this.a, intent, str, str2);
    }

    @Override // com.avito.android.AuthIntentFactory
    @NotNull
    public Intent loginIntent(@NotNull Intent intent, @Nullable String str, @Nullable String str2, boolean z, @Nullable String str3, boolean z2) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return LoginActivityKt.createLoginIntent(this.a, intent, str, str2, z, str3, z2);
    }

    @Override // com.avito.android.AuthIntentFactory
    @NotNull
    public Intent loginSuggests() {
        return LoginSuggestsActivityKt.createLoginSuggestsActivityIntent(this.a);
    }

    @Override // com.avito.android.AuthIntentFactory
    @NotNull
    public Intent phoneProvingIntent(@NotNull String str, @NotNull String str2, @Nullable String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "challengeId");
        Intrinsics.checkNotNullParameter(str2, "phonePart");
        if (str3 == null) {
            return PhoneProvingActivityKt.createPhoneProvingActivityIntent$default(this.a, str, str2, null, z, 8, null);
        }
        return PhoneProvingActivityKt.createPhoneProvingActivityIntent(this.a, str, str2, str3, z);
    }

    @Override // com.avito.android.AuthIntentFactory
    @NotNull
    public Intent registrationActivityIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return StartRegistrationActivityKt.createStartRegistrationActivityIntent$default(this.a, intent, null, 4, null);
    }

    @Override // com.avito.android.AuthIntentFactory
    @NotNull
    public Intent resetPasswordIntent(@Nullable String str, boolean z, @Nullable String str2) {
        return ResetPasswordActivityKt.createResetPasswordIntent(this.a, str, z, str2);
    }

    @Override // com.avito.android.AuthIntentFactory
    @NotNull
    public Intent selectProfileIntent(@NotNull Intent intent, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(str, "login");
        Intrinsics.checkNotNullParameter(str2, "hash");
        return SelectProfileActivityKt.createSelectProfileActivityIntent(this.a, intent, str, str2);
    }

    @Override // com.avito.android.AuthIntentFactory
    @NotNull
    public Intent selectSocialIntent(@NotNull Intent intent, @NotNull List<ProfileSocial> list, @Nullable String str) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(list, "socialList");
        return SelectSocialActivityKt.createSelectSocialActivityIntent(this.a, intent, list, str);
    }

    @Override // com.avito.android.AuthIntentFactory
    @NotNull
    public Intent socialRegistrationSuggestsIntent(@NotNull Intent intent, @NotNull String str, @NotNull String str2, @NotNull List<RegisteredProfile> list, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "suggestKey");
        Intrinsics.checkNotNullParameter(list, "profiles");
        Intrinsics.checkNotNullParameter(str3, "socialType");
        return SocialRegistrationSuggestsActivityKt.createSocialRegistrationSuggestsIntent(this.a, intent, str, str2, list, str3);
    }
}
