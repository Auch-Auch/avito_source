package com.avito.android.select.new_metro.adapter;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.recycler.data_aware.ContentsComparator;
import com.avito.android.recycler.data_aware.EqualityComparator;
import com.avito.android.select.new_metro.adapter.metro_station.MetroStationItem;
import com.avito.konveyor.blueprint.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0007¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\t\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/select/new_metro/adapter/MetroItemsComparator;", "Lcom/avito/android/recycler/data_aware/ContentsComparator;", "Lcom/avito/android/recycler/data_aware/EqualityComparator;", "Lcom/avito/konveyor/blueprint/Item;", InternalConstsKt.FIRST_IMAGE, "second", "", "areContentsTheSame", "(Lcom/avito/konveyor/blueprint/Item;Lcom/avito/konveyor/blueprint/Item;)Z", "isEqual", "<init>", "()V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class MetroItemsComparator implements ContentsComparator, EqualityComparator {
    @Override // com.avito.android.recycler.data_aware.ContentsComparator
    public boolean areContentsTheSame(@Nullable Item item, @Nullable Item item2) {
        if (!(item instanceof ComparableContent) || !(item2 instanceof ComparableContent)) {
            return Intrinsics.areEqual(item, item2);
        }
        return ((ComparableContent) item).hasSameContentAs(item2);
    }

    @Override // com.avito.android.recycler.data_aware.EqualityComparator
    public boolean isEqual(@Nullable Item item, @Nullable Item item2) {
        if (!(item instanceof MetroStationItem) || !(item2 instanceof MetroStationItem)) {
            Long l = null;
            Long valueOf = item != null ? Long.valueOf(item.getId()) : null;
            if (item2 != null) {
                l = Long.valueOf(item2.getId());
            }
            return Intrinsics.areEqual(valueOf, l);
        }
        if (Intrinsics.areEqual(item, item2)) {
            MetroStationItem metroStationItem = (MetroStationItem) item;
            MetroStationItem metroStationItem2 = (MetroStationItem) item2;
            if (metroStationItem.getShowLineColor() == metroStationItem2.getShowLineColor() && metroStationItem.isSearchItem() == metroStationItem2.isSearchItem()) {
                return true;
            }
        }
        return false;
    }
}
