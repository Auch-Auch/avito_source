package com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.single_service;

import com.avito.android.lib.design.list_item.ListItem;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/single_service/SingleCourierServiceItemViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/single_service/SingleCourierServiceItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "Lcom/avito/android/lib/design/list_item/ListItem;", "s", "Lcom/avito/android/lib/design/list_item/ListItem;", "listItem", "<init>", "(Lcom/avito/android/lib/design/list_item/ListItem;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class SingleCourierServiceItemViewHolder extends BaseViewHolder implements SingleCourierServiceItemView {
    public final ListItem s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleCourierServiceItemViewHolder(@NotNull ListItem listItem) {
        super(listItem);
        Intrinsics.checkNotNullParameter(listItem, "listItem");
        this.s = listItem;
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.single_service.SingleCourierServiceItemView
    public void setSubtitle(@Nullable String str) {
        this.s.setSubtitle(str);
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.single_service.SingleCourierServiceItemView
    public void setTitle(@Nullable String str) {
        this.s.setTitle(str);
    }
}
