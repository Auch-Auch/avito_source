package com.avito.android.brandspace.presenter;

import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002R\u0016\u0010\u0006\u001a\u00020\u00038V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/avito/android/brandspace/presenter/TrackableBrandspaceItem;", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker$Item;", "", "getTrackId", "()J", "trackId", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public interface TrackableBrandspaceItem extends BrandspaceItem, ItemVisibilityTracker.Item {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static long getTrackId(@NotNull TrackableBrandspaceItem trackableBrandspaceItem) {
            return trackableBrandspaceItem.getId();
        }
    }

    @Override // com.avito.android.item_visibility_tracker.ItemVisibilityTracker.Item
    long getTrackId();
}
