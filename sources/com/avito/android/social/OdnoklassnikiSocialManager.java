package com.avito.android.social;

import android.app.Activity;
import com.avito.android.social.SignInSocialManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/social/OdnoklassnikiSocialManager;", "Lcom/avito/android/social/SignInSocialManager;", "Lcom/avito/android/social/SocialType;", "getType", "()Lcom/avito/android/social/SocialType;", "social_release"}, k = 1, mv = {1, 4, 2})
public interface OdnoklassnikiSocialManager extends SignInSocialManager {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @Nullable
        public static String getEmail(@NotNull OdnoklassnikiSocialManager odnoklassnikiSocialManager) {
            return SignInSocialManager.DefaultImpls.getEmail(odnoklassnikiSocialManager);
        }

        @NotNull
        public static SocialType getType(@NotNull OdnoklassnikiSocialManager odnoklassnikiSocialManager) {
            return SocialType.ODNOKLASSNIKI;
        }

        public static boolean hasToken(@NotNull OdnoklassnikiSocialManager odnoklassnikiSocialManager) {
            return SignInSocialManager.DefaultImpls.hasToken(odnoklassnikiSocialManager);
        }

        public static boolean shouldRestoreShare(@NotNull OdnoklassnikiSocialManager odnoklassnikiSocialManager, @NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            return SignInSocialManager.DefaultImpls.shouldRestoreShare(odnoklassnikiSocialManager, activity);
        }
    }

    @Override // com.avito.android.social.IsSocialNetwork
    @NotNull
    SocialType getType();
}
