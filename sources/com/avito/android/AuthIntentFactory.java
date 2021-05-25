package com.avito.android;

import android.content.Intent;
import android.os.Parcelable;
import com.avito.android.remote.model.registration.ProfileSocial;
import com.avito.android.remote.model.registration.RegisteredProfile;
import com.avito.android.util.preferences.Preference;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 62\u00020\u0001:\u00016J3\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0011\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0013\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H&¢\u0006\u0004\b\u0013\u0010\u0012J1\u0010\u0018\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0018\u0010\u0019J+\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u001b\u0010\u001cJ3\u0010\"\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010!\u001a\u00020 H&¢\u0006\u0004\b\"\u0010#J9\u0010&\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010%\u001a\u00020 H&¢\u0006\u0004\b&\u0010'JO\u0010+\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010)\u001a\u00020 2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010*\u001a\u00020 H&¢\u0006\u0004\b+\u0010,J1\u0010.\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010-\u001a\u00020 2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b.\u0010/J=\u00104\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\f\u00102\u001a\b\u0012\u0004\u0012\u0002010\u00142\u0006\u00103\u001a\u00020\u0004H&¢\u0006\u0004\b4\u00105¨\u00067"}, d2 = {"Lcom/avito/android/AuthIntentFactory;", "", "Landroid/content/Intent;", "successAuthIntent", "", "src", "Landroid/os/Parcelable;", "successAuthResultData", "authIntent", "(Landroid/content/Intent;Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;", "loginSuggests", "()Landroid/content/Intent;", "intent", "registrationActivityIntent", "(Landroid/content/Intent;)Landroid/content/Intent;", "login", "hash", "completeRegistrationIntent", "(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "selectProfileIntent", "", "Lcom/avito/android/remote/model/registration/ProfileSocial;", "socialList", "suggestKey", "selectSocialIntent", "(Landroid/content/Intent;Ljava/util/List;Ljava/lang/String;)Landroid/content/Intent;", "source", "changePasswordIntent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "challengeId", "phonePart", "inputHint", "", "isOpenedFromPhoneList", "phoneProvingIntent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Landroid/content/Intent;", "phones", "isAntihackMode", "antihackPhoneListIntent", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Z)Landroid/content/Intent;", Preference.PASSWORD, "isHiddenLogin", "skipSavedLogin", "loginIntent", "(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Z)Landroid/content/Intent;", "skipLoginEntry", "resetPasswordIntent", "(Ljava/lang/String;ZLjava/lang/String;)Landroid/content/Intent;", "title", "Lcom/avito/android/remote/model/registration/RegisteredProfile;", "profiles", "socialType", "socialRegistrationSuggestsIntent", "(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Landroid/content/Intent;", "Companion", "core_release"}, k = 1, mv = {1, 4, 2})
public interface AuthIntentFactory {
    @NotNull
    public static final Companion Companion = Companion.a;
    @NotNull
    public static final String SUCCESS_AUTH_RESULT_DATA = "SuccessAuthResultData";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/AuthIntentFactory$Companion;", "", "", "SUCCESS_AUTH_RESULT_DATA", "Ljava/lang/String;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        @NotNull
        public static final String SUCCESS_AUTH_RESULT_DATA = "SuccessAuthResultData";
        public static final /* synthetic */ Companion a = new Companion();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Intent authIntent$default(AuthIntentFactory authIntentFactory, Intent intent, String str, Parcelable parcelable, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    intent = null;
                }
                if ((i & 2) != 0) {
                    str = null;
                }
                if ((i & 4) != 0) {
                    parcelable = null;
                }
                return authIntentFactory.authIntent(intent, str, parcelable);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: authIntent");
        }

        public static /* synthetic */ Intent changePasswordIntent$default(AuthIntentFactory authIntentFactory, String str, String str2, String str3, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    str3 = null;
                }
                return authIntentFactory.changePasswordIntent(str, str2, str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: changePasswordIntent");
        }

        public static /* synthetic */ Intent loginIntent$default(AuthIntentFactory authIntentFactory, Intent intent, String str, String str2, boolean z, String str3, boolean z2, int i, Object obj) {
            if (obj == null) {
                String str4 = null;
                String str5 = (i & 2) != 0 ? null : str;
                String str6 = (i & 4) != 0 ? null : str2;
                boolean z3 = false;
                boolean z4 = (i & 8) != 0 ? false : z;
                if ((i & 16) == 0) {
                    str4 = str3;
                }
                if ((i & 32) == 0) {
                    z3 = z2;
                }
                return authIntentFactory.loginIntent(intent, str5, str6, z4, str4, z3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loginIntent");
        }

        public static /* synthetic */ Intent phoneProvingIntent$default(AuthIntentFactory authIntentFactory, String str, String str2, String str3, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    z = false;
                }
                return authIntentFactory.phoneProvingIntent(str, str2, str3, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: phoneProvingIntent");
        }

        public static /* synthetic */ Intent resetPasswordIntent$default(AuthIntentFactory authIntentFactory, String str, boolean z, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                if ((i & 2) != 0) {
                    z = false;
                }
                if ((i & 4) != 0) {
                    str2 = null;
                }
                return authIntentFactory.resetPasswordIntent(str, z, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resetPasswordIntent");
        }

        public static /* synthetic */ Intent selectSocialIntent$default(AuthIntentFactory authIntentFactory, Intent intent, List list, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    str = null;
                }
                return authIntentFactory.selectSocialIntent(intent, list, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectSocialIntent");
        }
    }

    @NotNull
    Intent antihackPhoneListIntent(@Nullable String str, @NotNull List<String> list, @Nullable String str2, boolean z);

    @NotNull
    Intent authIntent(@Nullable Intent intent, @Nullable String str, @Nullable Parcelable parcelable);

    @NotNull
    Intent changePasswordIntent(@NotNull String str, @NotNull String str2, @Nullable String str3);

    @NotNull
    Intent completeRegistrationIntent(@NotNull Intent intent, @NotNull String str, @NotNull String str2);

    @NotNull
    Intent loginIntent(@NotNull Intent intent, @Nullable String str, @Nullable String str2, boolean z, @Nullable String str3, boolean z2);

    @NotNull
    Intent loginSuggests();

    @NotNull
    Intent phoneProvingIntent(@NotNull String str, @NotNull String str2, @Nullable String str3, boolean z);

    @NotNull
    Intent registrationActivityIntent(@NotNull Intent intent);

    @NotNull
    Intent resetPasswordIntent(@Nullable String str, boolean z, @Nullable String str2);

    @NotNull
    Intent selectProfileIntent(@NotNull Intent intent, @NotNull String str, @NotNull String str2);

    @NotNull
    Intent selectSocialIntent(@NotNull Intent intent, @NotNull List<ProfileSocial> list, @Nullable String str);

    @NotNull
    Intent socialRegistrationSuggestsIntent(@NotNull Intent intent, @NotNull String str, @NotNull String str2, @NotNull List<RegisteredProfile> list, @NotNull String str3);
}
