package com.avito.android.shop.detailed.item;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.serp.adapter.SpannedItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/avito/android/shop/detailed/item/ShopGoldHeaderItem;", "Lcom/avito/android/serp/adapter/SpannedItem;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "", AuthSource.BOOKING_ORDER, "I", "getSpanCount", "()I", "spanCount", "Lcom/avito/android/remote/model/Image;", "d", "Lcom/avito/android/remote/model/Image;", "getBackground", "()Lcom/avito/android/remote/model/Image;", "background", "c", "getLogo", "logo", "<init>", "(Ljava/lang/String;ILcom/avito/android/remote/model/Image;Lcom/avito/android/remote/model/Image;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopGoldHeaderItem implements SpannedItem {
    @NotNull
    public final String a;
    public final int b;
    @Nullable
    public final Image c;
    @Nullable
    public final Image d;

    public ShopGoldHeaderItem(@NotNull String str, int i, @Nullable Image image, @Nullable Image image2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        this.a = str;
        this.b = i;
        this.c = image;
        this.d = image2;
    }

    @Nullable
    public final Image getBackground() {
        return this.d;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return SpannedItem.DefaultImpls.getId(this);
    }

    @Nullable
    public final Image getLogo() {
        return this.c;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.b;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }
}
