package com.avito.android.publish_limits_info.item;

import com.avito.android.publish_limits_info.ItemId;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.LimitsInfo;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\b\b\u0002\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0019\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/publish_limits_info/item/LimitsInfoItem;", "Lcom/avito/conveyor_item/Item;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "", "d", "Z", "getShowTitle", "()Z", "showTitle", "Lcom/avito/android/publish_limits_info/ItemId;", "c", "Lcom/avito/android/publish_limits_info/ItemId;", "getItemId", "()Lcom/avito/android/publish_limits_info/ItemId;", "itemId", "Lcom/avito/android/remote/model/LimitsInfo;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/LimitsInfo;", "getInfo", "()Lcom/avito/android/remote/model/LimitsInfo;", "info", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/LimitsInfo;Lcom/avito/android/publish_limits_info/ItemId;Z)V", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
public final class LimitsInfoItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final LimitsInfo b;
    @NotNull
    public final ItemId c;
    public final boolean d;

    public LimitsInfoItem(@NotNull String str, @NotNull LimitsInfo limitsInfo, @NotNull ItemId itemId, boolean z) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(limitsInfo, "info");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        this.a = str;
        this.b = limitsInfo;
        this.c = itemId;
        this.d = z;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @NotNull
    public final LimitsInfo getInfo() {
        return this.b;
    }

    @NotNull
    public final ItemId getItemId() {
        return this.c;
    }

    public final boolean getShowTitle() {
        return this.d;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LimitsInfoItem(String str, LimitsInfo limitsInfo, ItemId itemId, boolean z, int i, j jVar) {
        this(str, limitsInfo, itemId, (i & 8) != 0 ? true : z);
    }
}
