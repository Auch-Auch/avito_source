package com.avito.android.user_stats.tab.list.items.blueprints.chart;

import com.avito.android.recycler.data_aware.ChangePayloadCreator;
import com.avito.android.user_stats.tab.list.items.ChartItem;
import com.avito.konveyor.blueprint.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ%\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/BarItemPayloadCreator;", "Lcom/avito/android/recycler/data_aware/ChangePayloadCreator;", "Lcom/avito/konveyor/blueprint/Item;", "oldItem", "newItem", "", "getChangePayload", "(Lcom/avito/konveyor/blueprint/Item;Lcom/avito/konveyor/blueprint/Item;)Ljava/lang/Object;", "<init>", "()V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class BarItemPayloadCreator implements ChangePayloadCreator {
    @Override // com.avito.android.recycler.data_aware.ChangePayloadCreator
    @Nullable
    public Object getChangePayload(@Nullable Item item, @Nullable Item item2) {
        boolean z = true;
        if ((!Intrinsics.areEqual(item != null ? Long.valueOf(item.getId()) : null, item2 != null ? Long.valueOf(item2.getId()) : null)) || !(item instanceof ChartItem.BarItem) || !(item2 instanceof ChartItem.BarItem)) {
            return null;
        }
        ChartItem.BarItem barItem = (ChartItem.BarItem) item2;
        BarItemPayload barItemPayload = new BarItemPayload(barItem.isSelected(), barItem.getColor());
        ChartItem.BarItem barItem2 = (ChartItem.BarItem) item;
        if (barItem2.isSelected() == barItem.isSelected() && !(!Intrinsics.areEqual(barItem2.getColor(), barItem.getColor()))) {
            z = false;
        }
        if (z) {
            return barItemPayload;
        }
        return null;
    }
}
