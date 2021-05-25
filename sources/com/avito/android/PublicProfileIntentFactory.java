package com.avito.android;

import android.content.Intent;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.analytics.screens.tracker.ScreenTransfer;
import com.avito.android.public_profile.remote.model.DefaultPublicUserProfile;
import com.avito.android.public_profile.remote.model.ExtendedPublicUserProfile;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001JG\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\f\u0010\rJA\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/PublicProfileIntentFactory;", "", "", "userKey", "Lcom/avito/android/public_profile/remote/model/DefaultPublicUserProfile;", "profile", "contextId", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;", "screenTransfer", "Landroid/content/Intent;", "createPublicProfileIntent", "(Ljava/lang/String;Lcom/avito/android/public_profile/remote/model/DefaultPublicUserProfile;Ljava/lang/String;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;)Landroid/content/Intent;", "Lcom/avito/android/public_profile/remote/model/ExtendedPublicUserProfile;", "createExtendedProfileIntent", "(Ljava/lang/String;Lcom/avito/android/public_profile/remote/model/ExtendedPublicUserProfile;Ljava/lang/String;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;)Landroid/content/Intent;", "createProfileScreenResolverIntent", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface PublicProfileIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Intent createExtendedProfileIntent$default(PublicProfileIntentFactory publicProfileIntentFactory, String str, ExtendedPublicUserProfile extendedPublicUserProfile, String str2, TreeClickStreamParent treeClickStreamParent, ScreenTransfer screenTransfer, int i, Object obj) {
            if (obj == null) {
                return publicProfileIntentFactory.createExtendedProfileIntent(str, extendedPublicUserProfile, str2, (i & 8) != 0 ? null : treeClickStreamParent, (i & 16) != 0 ? null : screenTransfer);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createExtendedProfileIntent");
        }

        public static /* synthetic */ Intent createProfileScreenResolverIntent$default(PublicProfileIntentFactory publicProfileIntentFactory, String str, String str2, TreeClickStreamParent treeClickStreamParent, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = null;
                }
                if ((i & 4) != 0) {
                    treeClickStreamParent = null;
                }
                return publicProfileIntentFactory.createProfileScreenResolverIntent(str, str2, treeClickStreamParent);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createProfileScreenResolverIntent");
        }

        public static /* synthetic */ Intent createPublicProfileIntent$default(PublicProfileIntentFactory publicProfileIntentFactory, String str, DefaultPublicUserProfile defaultPublicUserProfile, String str2, TreeClickStreamParent treeClickStreamParent, ScreenTransfer screenTransfer, int i, Object obj) {
            if (obj == null) {
                return publicProfileIntentFactory.createPublicProfileIntent(str, (i & 2) != 0 ? null : defaultPublicUserProfile, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : treeClickStreamParent, (i & 16) != 0 ? null : screenTransfer);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createPublicProfileIntent");
        }
    }

    @NotNull
    Intent createExtendedProfileIntent(@NotNull String str, @NotNull ExtendedPublicUserProfile extendedPublicUserProfile, @Nullable String str2, @Nullable TreeClickStreamParent treeClickStreamParent, @Nullable ScreenTransfer screenTransfer);

    @NotNull
    Intent createProfileScreenResolverIntent(@NotNull String str, @Nullable String str2, @Nullable TreeClickStreamParent treeClickStreamParent);

    @NotNull
    Intent createPublicProfileIntent(@NotNull String str, @Nullable DefaultPublicUserProfile defaultPublicUserProfile, @Nullable String str2, @Nullable TreeClickStreamParent treeClickStreamParent, @Nullable ScreenTransfer screenTransfer);
}
