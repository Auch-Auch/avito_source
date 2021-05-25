package com.avito.android.brandspace.presenter.virtualitems;

import com.avito.android.brandspace.presenter.BrandspaceItem;
import com.avito.android.brandspace.presenter.TrackableBrandspaceItem;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H&¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0004¨\u0006\u000f"}, d2 = {"Lcom/avito/android/brandspace/presenter/virtualitems/VirtualItem;", "Lcom/avito/android/brandspace/presenter/TrackableBrandspaceItem;", "", "isUnpackable", "()Z", "", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "getUnpackItems", "()Ljava/util/List;", "oldItem", "newItem", "", "replaceItem", "(Lcom/avito/android/brandspace/presenter/BrandspaceItem;Lcom/avito/android/brandspace/presenter/BrandspaceItem;)V", "isReplaceableItem", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public interface VirtualItem extends TrackableBrandspaceItem {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static long getTrackId(@NotNull VirtualItem virtualItem) {
            return TrackableBrandspaceItem.DefaultImpls.getTrackId(virtualItem);
        }
    }

    @NotNull
    List<BrandspaceItem> getUnpackItems();

    boolean isReplaceableItem();

    boolean isUnpackable();

    void replaceItem(@NotNull BrandspaceItem brandspaceItem, @NotNull BrandspaceItem brandspaceItem2);
}
