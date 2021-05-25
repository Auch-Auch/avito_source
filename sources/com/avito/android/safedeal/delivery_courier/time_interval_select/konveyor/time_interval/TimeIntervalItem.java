package com.avito.android.safedeal.delivery_courier.time_interval_select.konveyor.time_interval;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.delivery_courier.DeliveryCourierTimeIntervals;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u001c\u001a\u00020\u0017¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0016\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u0019\u0010\u001c\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/time_interval_select/konveyor/time_interval/TimeIntervalItem;", "Lcom/avito/conveyor_item/Item;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierTimeIntervals$Data;", "d", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierTimeIntervals$Data;", "getData", "()Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierTimeIntervals$Data;", "data", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierTimeIntervals$ScreenData;", "c", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierTimeIntervals$ScreenData;", "getNestedScreenData", "()Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierTimeIntervals$ScreenData;", "nestedScreenData", AuthSource.SEND_ABUSE, "getStringId", "stringId", "", "e", "Z", "getSelected", "()Z", "selected", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierTimeIntervals$ScreenData;Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierTimeIntervals$Data;Z)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class TimeIntervalItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @Nullable
    public final DeliveryCourierTimeIntervals.ScreenData c;
    @Nullable
    public final DeliveryCourierTimeIntervals.Data d;
    public final boolean e;

    public TimeIntervalItem(@NotNull String str, @NotNull String str2, @Nullable DeliveryCourierTimeIntervals.ScreenData screenData, @Nullable DeliveryCourierTimeIntervals.Data data, boolean z) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.a = str;
        this.b = str2;
        this.c = screenData;
        this.d = data;
        this.e = z;
    }

    @Nullable
    public final DeliveryCourierTimeIntervals.Data getData() {
        return this.d;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @Nullable
    public final DeliveryCourierTimeIntervals.ScreenData getNestedScreenData() {
        return this.c;
    }

    public final boolean getSelected() {
        return this.e;
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
