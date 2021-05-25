package com.avito.android.lib.design.promo_block.grouping;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/lib/design/promo_block/grouping/GroupableItemPresenterImpl;", "Lcom/avito/android/lib/design/promo_block/grouping/GroupableItemPresenter;", "", "view", "item", "", "bindView", "(Ljava/lang/Object;Ljava/lang/Object;)V", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class GroupableItemPresenterImpl implements GroupableItemPresenter {
    @Override // com.avito.android.lib.design.promo_block.grouping.GroupableItemPresenter
    public void bindView(@NotNull Object obj, @NotNull Object obj2) {
        Intrinsics.checkNotNullParameter(obj, "view");
        Intrinsics.checkNotNullParameter(obj2, "item");
        if ((obj2 instanceof GroupableItem) && (obj instanceof GroupableItemView)) {
            GroupableItemView groupableItemView = (GroupableItemView) obj;
            GroupableItem groupableItem = (GroupableItem) obj2;
            groupableItemView.setTopEdgeRounded(groupableItem.getOutput().getTopEdge$components_release().isRounded());
            groupableItemView.setBottomEdgeRounded(groupableItem.getOutput().getBottomEdge$components_release().isRounded());
        }
    }
}
