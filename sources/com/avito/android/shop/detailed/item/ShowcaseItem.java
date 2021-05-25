package com.avito.android.shop.detailed.item;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.SerpItem;
import com.avito.android.serp.adapter.SpannedItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/avito/android/shop/detailed/item/ShowcaseItem;", "Lcom/avito/android/serp/adapter/SpannedItem;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "", AuthSource.BOOKING_ORDER, "I", "getSpanCount", "()I", "spanCount", "", "Lcom/avito/android/serp/adapter/SerpItem;", "d", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "items", "c", "getTitle", "title", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/util/List;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShowcaseItem implements SpannedItem {
    @NotNull
    public final String a;
    public final int b;
    @Nullable
    public final String c;
    @NotNull
    public final List<SerpItem> d;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.List<? extends com.avito.android.serp.adapter.SerpItem> */
    /* JADX WARN: Multi-variable type inference failed */
    public ShowcaseItem(@NotNull String str, int i, @Nullable String str2, @NotNull List<? extends SerpItem> list) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(list, "items");
        this.a = str;
        this.b = i;
        this.c = str2;
        this.d = list;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return SpannedItem.DefaultImpls.getId(this);
    }

    @NotNull
    public final List<SerpItem> getItems() {
        return this.d;
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

    @Nullable
    public final String getTitle() {
        return this.c;
    }
}
