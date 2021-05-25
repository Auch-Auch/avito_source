package com.avito.android.component.cost;

import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/component/cost/CostCardItemPresenterImpl;", "Lcom/avito/android/component/cost/CostCardItemPresenter;", "Lcom/avito/android/component/cost/CostCardViewHolder;", "view", "Lcom/avito/android/component/cost/CostCardItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/component/cost/CostCardViewHolder;Lcom/avito/android/component/cost/CostCardItem;I)V", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class CostCardItemPresenterImpl implements CostCardItemPresenter {
    public void bindView(@NotNull CostCardViewHolder costCardViewHolder, @NotNull CostCardItem costCardItem, int i) {
        Intrinsics.checkNotNullParameter(costCardViewHolder, "view");
        Intrinsics.checkNotNullParameter(costCardItem, "item");
        costCardViewHolder.setTitle(costCardItem.getTitle());
        costCardViewHolder.setValue(costCardItem.getValue());
    }
}
