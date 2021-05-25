package com.avito.android.fees.refactor.item.header;

import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/fees/refactor/item/header/HeaderItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/fees/refactor/item/header/HeaderItemView;", "Lcom/avito/android/fees/refactor/item/header/HeaderItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/fees/refactor/item/header/HeaderItemView;Lcom/avito/android/fees/refactor/item/header/HeaderItem;I)V", "<init>", "()V", "fees_release"}, k = 1, mv = {1, 4, 2})
public final class HeaderItemPresenter implements ItemPresenter<HeaderItemView, HeaderItem> {
    public void bindView(@NotNull HeaderItemView headerItemView, @NotNull HeaderItem headerItem, int i) {
        Intrinsics.checkNotNullParameter(headerItemView, "view");
        Intrinsics.checkNotNullParameter(headerItem, "item");
        headerItemView.setMessage(headerItem.getMessage());
    }
}
