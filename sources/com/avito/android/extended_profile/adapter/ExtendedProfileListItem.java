package com.avito.android.extended_profile.adapter;

import com.avito.android.extended_profile.adapter.ExtendedProfileSpanLookup;
import com.avito.android.extended_profile.data.ExtendedProfileDataItem;
import com.avito.conveyor_item.ParcelableItem;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002R\u0016\u0010\u0006\u001a\u00020\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/avito/android/extended_profile/adapter/ExtendedProfileListItem;", "Lcom/avito/conveyor_item/ParcelableItem;", "Lcom/avito/android/extended_profile/data/ExtendedProfileDataItem;", "Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;", "getGridItemType", "()Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;", "gridItemType", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public interface ExtendedProfileListItem extends ParcelableItem, ExtendedProfileDataItem {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static long getId(@NotNull ExtendedProfileListItem extendedProfileListItem) {
            return ParcelableItem.DefaultImpls.getId(extendedProfileListItem);
        }
    }

    @NotNull
    ExtendedProfileSpanLookup.GridItemType getGridItemType();
}
