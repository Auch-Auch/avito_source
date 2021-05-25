package com.avito.android.basket_legacy.item.header;

import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0015\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/avito/android/basket_legacy/item/header/HeaderItem;", "Lcom/avito/conveyor_item/Item;", "", "c", "Ljava/lang/String;", "getSubTitle", "()Ljava/lang/String;", "subTitle", AuthSource.BOOKING_ORDER, "getTitle", "title", "", "d", "I", "getCount", "()I", "setCount", "(I)V", "count", AuthSource.SEND_ABUSE, "getStringId", "stringId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class HeaderItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @Nullable
    public final String c;
    public int d;

    public HeaderItem(@NotNull String str, @NotNull String str2, @Nullable String str3, int i) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = i;
    }

    public final int getCount() {
        return this.d;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Nullable
    public final String getSubTitle() {
        return this.c;
    }

    @NotNull
    public final String getTitle() {
        return this.b;
    }

    public final void setCount(int i) {
        this.d = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HeaderItem(String str, String str2, String str3, int i, int i2, j jVar) {
        this(str, str2, (i2 & 4) != 0 ? null : str3, i);
    }
}
