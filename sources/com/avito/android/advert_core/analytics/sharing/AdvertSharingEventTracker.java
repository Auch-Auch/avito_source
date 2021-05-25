package com.avito.android.advert_core.analytics.sharing;

import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J5\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/advert_core/analytics/sharing/AdvertSharingEventTracker;", "", "", "itemId", "networkType", "", "isAuthorized", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "", "trackSocialItemSharing", "(Ljava/lang/String;Ljava/lang/String;ZLcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)V", "trackItemSharing", "(Ljava/lang/String;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertSharingEventTracker {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void trackItemSharing$default(AdvertSharingEventTracker advertSharingEventTracker, String str, TreeClickStreamParent treeClickStreamParent, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    treeClickStreamParent = null;
                }
                advertSharingEventTracker.trackItemSharing(str, treeClickStreamParent);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackItemSharing");
        }

        public static /* synthetic */ void trackSocialItemSharing$default(AdvertSharingEventTracker advertSharingEventTracker, String str, String str2, boolean z, TreeClickStreamParent treeClickStreamParent, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    treeClickStreamParent = null;
                }
                advertSharingEventTracker.trackSocialItemSharing(str, str2, z, treeClickStreamParent);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackSocialItemSharing");
        }
    }

    void trackItemSharing(@NotNull String str, @Nullable TreeClickStreamParent treeClickStreamParent);

    void trackSocialItemSharing(@NotNull String str, @Nullable String str2, boolean z, @Nullable TreeClickStreamParent treeClickStreamParent);
}
