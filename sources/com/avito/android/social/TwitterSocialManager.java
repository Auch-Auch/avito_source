package com.avito.android.social;

import android.app.Activity;
import com.avito.android.social.SharingManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/social/TwitterSocialManager;", "Lcom/avito/android/social/SharingManager;", "Lcom/avito/android/social/SocialType;", "getType", "()Lcom/avito/android/social/SocialType;", "social_release"}, k = 1, mv = {1, 4, 2})
public interface TwitterSocialManager extends SharingManager {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @NotNull
        public static SocialType getType(@NotNull TwitterSocialManager twitterSocialManager) {
            return SocialType.TWITTER;
        }

        public static boolean shouldRestoreShare(@NotNull TwitterSocialManager twitterSocialManager, @NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            return SharingManager.DefaultImpls.shouldRestoreShare(twitterSocialManager, activity);
        }
    }

    @Override // com.avito.android.social.IsSocialNetwork
    @NotNull
    SocialType getType();
}
