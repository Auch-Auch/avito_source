package com.avito.konveyor.adapter;

import androidx.recyclerview.widget.DiffUtil;
import com.avito.konveyor.blueprint.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"com/avito/konveyor/adapter/ListRecyclerAdapter$Companion$CALLBACK$1", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/avito/konveyor/blueprint/Item;", "oldCellInfo", "newCellInfo", "", "areItemsTheSame", "(Lcom/avito/konveyor/blueprint/Item;Lcom/avito/konveyor/blueprint/Item;)Z", "areContentsTheSame", "konveyor_release"}, k = 1, mv = {1, 4, 2})
public final class ListRecyclerAdapter$Companion$CALLBACK$1 extends DiffUtil.ItemCallback<Item> {
    public boolean areContentsTheSame(@NotNull Item item, @NotNull Item item2) {
        Intrinsics.checkNotNullParameter(item, "oldCellInfo");
        Intrinsics.checkNotNullParameter(item2, "newCellInfo");
        return item.equals(item2);
    }

    public boolean areItemsTheSame(@NotNull Item item, @NotNull Item item2) {
        Intrinsics.checkNotNullParameter(item, "oldCellInfo");
        Intrinsics.checkNotNullParameter(item2, "newCellInfo");
        return item.getId() == item2.getId() && Intrinsics.areEqual(item.getClass(), item2.getClass());
    }
}
