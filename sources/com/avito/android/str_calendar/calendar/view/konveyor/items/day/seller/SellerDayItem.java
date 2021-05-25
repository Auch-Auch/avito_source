package com.avito.android.str_calendar.calendar.view.konveyor.items.day.seller;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sort;
import com.avito.android.str_calendar.seller.calendar.data.SellerDayItemState;
import com.avito.konveyor.blueprint.Item;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0019\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/seller/SellerDayItem;", "Lcom/avito/konveyor/blueprint/Item;", "Ljava/util/Date;", "d", "Ljava/util/Date;", "getDate", "()Ljava/util/Date;", Sort.DATE, "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "Lcom/avito/android/str_calendar/seller/calendar/data/SellerDayItemState;", "c", "Lcom/avito/android/str_calendar/seller/calendar/data/SellerDayItemState;", "getState", "()Lcom/avito/android/str_calendar/seller/calendar/data/SellerDayItemState;", "state", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "text", "<init>", "(JLjava/lang/String;Lcom/avito/android/str_calendar/seller/calendar/data/SellerDayItemState;Ljava/util/Date;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class SellerDayItem implements Item {
    public final long a;
    @NotNull
    public final String b;
    @NotNull
    public final SellerDayItemState c;
    @NotNull
    public final Date d;

    public SellerDayItem(long j, @NotNull String str, @NotNull SellerDayItemState sellerDayItemState, @NotNull Date date) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(sellerDayItemState, "state");
        Intrinsics.checkNotNullParameter(date, Sort.DATE);
        this.a = j;
        this.b = str;
        this.c = sellerDayItemState;
        this.d = date;
    }

    @NotNull
    public final Date getDate() {
        return this.d;
    }

    @Override // com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @NotNull
    public final SellerDayItemState getState() {
        return this.c;
    }

    @NotNull
    public final String getText() {
        return this.b;
    }
}
