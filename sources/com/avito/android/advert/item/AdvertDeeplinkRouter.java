package com.avito.android.advert.item;

import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.deep_linking.links.DeepLink;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/advert/item/AdvertDeeplinkRouter;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "", "followDeeplinkWithTreeParent", "(Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDeeplinkRouter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void followDeeplinkWithTreeParent$default(AdvertDeeplinkRouter advertDeeplinkRouter, DeepLink deepLink, TreeClickStreamParent treeClickStreamParent, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    treeClickStreamParent = null;
                }
                advertDeeplinkRouter.followDeeplinkWithTreeParent(deepLink, treeClickStreamParent);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: followDeeplinkWithTreeParent");
        }
    }

    void followDeeplinkWithTreeParent(@NotNull DeepLink deepLink, @Nullable TreeClickStreamParent treeClickStreamParent);
}
