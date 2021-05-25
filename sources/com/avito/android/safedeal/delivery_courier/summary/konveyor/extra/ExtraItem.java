package com.avito.android.safedeal.delivery_courier.summary.konveyor.extra;

import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/extra/ExtraItem;", "Lcom/avito/conveyor_item/Item;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "c", "getExtraInfoTitle", "extraInfoTitle", AuthSource.BOOKING_ORDER, "getTitle", "title", "", "d", "Ljava/util/List;", "getExtraInfoText", "()Ljava/util/List;", "extraInfoText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class ExtraItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final List<String> d;

    public ExtraItem(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "extraInfoTitle");
        Intrinsics.checkNotNullParameter(list, "extraInfoText");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = list;
    }

    @NotNull
    public final List<String> getExtraInfoText() {
        return this.d;
    }

    @NotNull
    public final String getExtraInfoTitle() {
        return this.c;
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

    @NotNull
    public final String getTitle() {
        return this.b;
    }
}
