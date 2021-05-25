package com.avito.android.social;

import android.app.Activity;
import com.avito.android.social.SharingManager;
import com.avito.android.social.SignInManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/avito/android/social/SignInSocialManager;", "Lcom/avito/android/social/SignInManager;", "Lcom/avito/android/social/SharingManager;", "social_release"}, k = 1, mv = {1, 4, 2})
public interface SignInSocialManager extends SignInManager, SharingManager {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @Nullable
        public static String getEmail(@NotNull SignInSocialManager signInSocialManager) {
            return SignInManager.DefaultImpls.getEmail(signInSocialManager);
        }

        public static boolean hasToken(@NotNull SignInSocialManager signInSocialManager) {
            return SignInManager.DefaultImpls.hasToken(signInSocialManager);
        }

        public static boolean shouldRestoreShare(@NotNull SignInSocialManager signInSocialManager, @NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            return SharingManager.DefaultImpls.shouldRestoreShare(signInSocialManager, activity);
        }
    }
}
