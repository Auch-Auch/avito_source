package com.avito.android.brandspace.presenter.virtualitems;

import com.avito.android.brandspace.presenter.BrandspaceItem;
import com.avito.android.brandspace.presenter.TrackableBrandspaceItem;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J#\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/brandspace/presenter/virtualitems/AddableItemsWithLoadingBrandspaceItem;", "Lcom/avito/android/brandspace/presenter/TrackableBrandspaceItem;", "", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "items", "replace", "(Ljava/util/List;)Ljava/util/List;", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public interface AddableItemsWithLoadingBrandspaceItem extends TrackableBrandspaceItem {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static long getTrackId(@NotNull AddableItemsWithLoadingBrandspaceItem addableItemsWithLoadingBrandspaceItem) {
            return TrackableBrandspaceItem.DefaultImpls.getTrackId(addableItemsWithLoadingBrandspaceItem);
        }
    }

    @NotNull
    List<BrandspaceItem> replace(@NotNull List<? extends BrandspaceItem> list);
}
