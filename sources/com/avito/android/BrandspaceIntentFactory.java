package com.avito.android;

import android.content.Intent;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.bottom_navigation.NavigationTab;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J;\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/BrandspaceIntentFactory;", "", "", "id", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "source", "Lcom/avito/android/bottom_navigation/NavigationTab;", "tab", "Landroid/content/Intent;", "brandspaceIntent", "(Ljava/lang/String;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Ljava/lang/String;Lcom/avito/android/bottom_navigation/NavigationTab;)Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface BrandspaceIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Intent brandspaceIntent$default(BrandspaceIntentFactory brandspaceIntentFactory, String str, TreeClickStreamParent treeClickStreamParent, String str2, NavigationTab navigationTab, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    treeClickStreamParent = null;
                }
                if ((i & 4) != 0) {
                    str2 = null;
                }
                if ((i & 8) != 0) {
                    navigationTab = null;
                }
                return brandspaceIntentFactory.brandspaceIntent(str, treeClickStreamParent, str2, navigationTab);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: brandspaceIntent");
        }
    }

    @NotNull
    Intent brandspaceIntent(@NotNull String str, @Nullable TreeClickStreamParent treeClickStreamParent, @Nullable String str2, @Nullable NavigationTab navigationTab);
}
