package com.avito.android.auto_catalog.items.skeleton;

import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/avito/android/auto_catalog/items/skeleton/SkeletonView;", "Lcom/avito/konveyor/blueprint/ItemView;", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
public interface SkeletonView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull SkeletonView skeletonView) {
            ItemView.DefaultImpls.onUnbind(skeletonView);
        }
    }
}
