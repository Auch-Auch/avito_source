package com.avito.android.str_calendar.calendar.view.konveyor.items.empty;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.str_calendar.calendar.view.data.items.CalendarItemState;
import com.avito.konveyor.blueprint.Item;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0005\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0011\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0017\u001a\u00020\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/str_calendar/calendar/view/konveyor/items/empty/EmptyItem;", "Lcom/avito/konveyor/blueprint/Item;", "", "getSelected", "()Z", "selected", "Lcom/avito/android/str_calendar/calendar/view/data/items/CalendarItemState;", "c", "Lcom/avito/android/str_calendar/calendar/view/data/items/CalendarItemState;", "getState", "()Lcom/avito/android/str_calendar/calendar/view/data/items/CalendarItemState;", "state", "Ljava/util/Date;", AuthSource.BOOKING_ORDER, "Ljava/util/Date;", "getNextDate", "()Ljava/util/Date;", "nextDate", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "<init>", "(JLjava/util/Date;Lcom/avito/android/str_calendar/calendar/view/data/items/CalendarItemState;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class EmptyItem implements Item {
    public final long a;
    @NotNull
    public final Date b;
    @NotNull
    public final CalendarItemState c;

    public EmptyItem(long j, @NotNull Date date, @NotNull CalendarItemState calendarItemState) {
        Intrinsics.checkNotNullParameter(date, "nextDate");
        Intrinsics.checkNotNullParameter(calendarItemState, "state");
        this.a = j;
        this.b = date;
        this.c = calendarItemState;
    }

    @Override // com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @NotNull
    public final Date getNextDate() {
        return this.b;
    }

    public final boolean getSelected() {
        return this.c == CalendarItemState.SELECTED;
    }

    @NotNull
    public final CalendarItemState getState() {
        return this.c;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EmptyItem(long j, Date date, CalendarItemState calendarItemState, int i, j jVar) {
        this(j, date, (i & 4) != 0 ? CalendarItemState.NORMAL : calendarItemState);
    }
}
