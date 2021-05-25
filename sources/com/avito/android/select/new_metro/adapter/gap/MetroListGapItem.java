package com.avito.android.select.new_metro.adapter.gap;

import androidx.annotation.DimenRes;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.select.R;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/select/new_metro/adapter/gap/MetroListGapItem;", "Lcom/avito/conveyor_item/Item;", "", AuthSource.BOOKING_ORDER, "I", "getGap", "()I", "gap", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "<init>", "(Ljava/lang/String;I)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class MetroListGapItem implements Item {
    @NotNull
    public final String a;
    public final int b;

    public MetroListGapItem() {
        this(null, 0, 3, null);
    }

    public MetroListGapItem(@NotNull String str, @DimenRes int i) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        this.a = str;
        this.b = i;
    }

    public final int getGap() {
        return this.b;
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

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MetroListGapItem(String str, int i, int i2, j jVar) {
        this((i2 & 1) != 0 ? "MetroLastItemGap" : str, (i2 & 2) != 0 ? R.dimen.select_metro_btn_container_height : i);
    }
}
