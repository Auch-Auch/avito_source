package com.avito.android;

import android.content.Intent;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.remote.model.Location;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J'\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/CategoryIntentFactory;", "", "Lcom/avito/android/remote/model/Location;", "location", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "Landroid/content/Intent;", "createCategoriesListIntent", "(Lcom/avito/android/remote/model/Location;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface CategoryIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Intent createCategoriesListIntent$default(CategoryIntentFactory categoryIntentFactory, Location location, TreeClickStreamParent treeClickStreamParent, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    location = null;
                }
                if ((i & 2) != 0) {
                    treeClickStreamParent = null;
                }
                return categoryIntentFactory.createCategoriesListIntent(location, treeClickStreamParent);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createCategoriesListIntent");
        }
    }

    @NotNull
    Intent createCategoriesListIntent(@Nullable Location location, @Nullable TreeClickStreamParent treeClickStreamParent);
}
