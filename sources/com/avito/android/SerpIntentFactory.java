package com.avito.android;

import android.content.Intent;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.util.UrlParams;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006JO\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\rH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/SerpIntentFactory;", "", "", "subscriptionId", "Landroid/content/Intent;", "searchSubscriptionIntent", "(Ljava/lang/String;)Landroid/content/Intent;", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "context", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "fromPage", "", "showOver", UrlParams.SIMPLE_MAP, "itemsListIntent", "(Lcom/avito/android/remote/model/SearchParams;Ljava/lang/String;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Ljava/lang/String;ZZ)Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface SerpIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Intent itemsListIntent$default(SerpIntentFactory serpIntentFactory, SearchParams searchParams, String str, TreeClickStreamParent treeClickStreamParent, String str2, boolean z, boolean z2, int i, Object obj) {
            if (obj == null) {
                String str3 = null;
                String str4 = (i & 2) != 0 ? null : str;
                TreeClickStreamParent treeClickStreamParent2 = (i & 4) != 0 ? null : treeClickStreamParent;
                if ((i & 8) == 0) {
                    str3 = str2;
                }
                boolean z3 = false;
                boolean z4 = (i & 16) != 0 ? false : z;
                if ((i & 32) == 0) {
                    z3 = z2;
                }
                return serpIntentFactory.itemsListIntent(searchParams, str4, treeClickStreamParent2, str3, z4, z3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: itemsListIntent");
        }
    }

    @NotNull
    Intent itemsListIntent(@NotNull SearchParams searchParams, @Nullable String str, @Nullable TreeClickStreamParent treeClickStreamParent, @Nullable String str2, boolean z, boolean z2);

    @NotNull
    Intent searchSubscriptionIntent(@NotNull String str);
}
