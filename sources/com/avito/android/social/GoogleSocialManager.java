package com.avito.android.social;

import android.app.Activity;
import com.avito.android.social.SignInSocialManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/social/GoogleSocialManager;", "Lcom/avito/android/social/SignInSocialManager;", "Lcom/avito/android/social/SocialType;", "getType", "()Lcom/avito/android/social/SocialType;", "", "isAvailable", "()Z", "social_release"}, k = 1, mv = {1, 4, 2})
public interface GoogleSocialManager extends SignInSocialManager {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @Nullable
        public static String getEmail(@NotNull GoogleSocialManager googleSocialManager) {
            return SignInSocialManager.DefaultImpls.getEmail(googleSocialManager);
        }

        @NotNull
        public static SocialType getType(@NotNull GoogleSocialManager googleSocialManager) {
            return SocialType.GOOGLE;
        }

        public static boolean hasToken(@NotNull GoogleSocialManager googleSocialManager) {
            return SignInSocialManager.DefaultImpls.hasToken(googleSocialManager);
        }

        public static boolean shouldRestoreShare(@NotNull GoogleSocialManager googleSocialManager, @NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            return SignInSocialManager.DefaultImpls.shouldRestoreShare(googleSocialManager, activity);
        }
    }

    @Override // com.avito.android.social.IsSocialNetwork
    @NotNull
    SocialType getType();

    boolean isAvailable();
}
