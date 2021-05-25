package com.avito.android.publish.input_vin.items.divider;

import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/publish/input_vin/items/divider/DividerWithTextPresenterImpl;", "Lcom/avito/android/publish/input_vin/items/divider/DividerWithTextPresenter;", "Lcom/avito/android/publish/input_vin/items/divider/DividerWithTextItemView;", "view", "Lcom/avito/android/publish/input_vin/items/divider/DividerWithTextItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/publish/input_vin/items/divider/DividerWithTextItemView;Lcom/avito/android/publish/input_vin/items/divider/DividerWithTextItem;I)V", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class DividerWithTextPresenterImpl implements DividerWithTextPresenter {
    public void bindView(@NotNull DividerWithTextItemView dividerWithTextItemView, @NotNull DividerWithTextItem dividerWithTextItem, int i) {
        Intrinsics.checkNotNullParameter(dividerWithTextItemView, "view");
        Intrinsics.checkNotNullParameter(dividerWithTextItem, "item");
        dividerWithTextItemView.setText(dividerWithTextItem.getWordResource());
    }
}
