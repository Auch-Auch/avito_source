package com.avito.android.grouping_adverts;

import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.ItemBinder;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/grouping_adverts/GroupingAdvertsItemsFilterImpl;", "Lcom/avito/android/grouping_adverts/GroupingAdvertsItemsFilter;", "Lcom/avito/conveyor_item/Item;", "item", "", "hasRegisteredBlueprint", "(Lcom/avito/conveyor_item/Item;)Z", "Lcom/avito/konveyor/ItemBinder;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "<init>", "(Lcom/avito/konveyor/ItemBinder;)V", "grouping-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class GroupingAdvertsItemsFilterImpl implements GroupingAdvertsItemsFilter {
    public final ItemBinder a;

    @Inject
    public GroupingAdvertsItemsFilterImpl(@NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        this.a = itemBinder;
    }

    @Override // com.avito.android.grouping_adverts.GroupingAdvertsItemsFilter
    public boolean hasRegisteredBlueprint(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return this.a.getItemViewType(item) != -1;
    }
}
