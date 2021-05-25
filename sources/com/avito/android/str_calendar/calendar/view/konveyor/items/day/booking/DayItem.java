package com.avito.android.str_calendar.calendar.view.konveyor.items.day.booking;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sort;
import com.avito.android.str_calendar.calendar.view.data.items.CalendarItemState;
import com.avito.konveyor.blueprint.Item;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0018¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0017\u001a\u00020\u00148F@\u0006¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u001d\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/booking/DayItem;", "Lcom/avito/konveyor/blueprint/Item;", "Lcom/avito/android/str_calendar/calendar/view/data/items/CalendarItemState;", "c", "Lcom/avito/android/str_calendar/calendar/view/data/items/CalendarItemState;", "getState", "()Lcom/avito/android/str_calendar/calendar/view/data/items/CalendarItemState;", "state", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "text", "", "getSelected", "()Z", "selected", "Ljava/util/Date;", "d", "Ljava/util/Date;", "getDate", "()Ljava/util/Date;", Sort.DATE, "<init>", "(JLjava/lang/String;Lcom/avito/android/str_calendar/calendar/view/data/items/CalendarItemState;Ljava/util/Date;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class DayItem implements Item {
    public final long a;
    @NotNull
    public final String b;
    @NotNull
    public final CalendarItemState c;
    @NotNull
    public final Date d;

    public DayItem(long j, @NotNull String str, @NotNull CalendarItemState calendarItemState, @NotNull Date date) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(calendarItemState, "state");
        Intrinsics.checkNotNullParameter(date, Sort.DATE);
        this.a = j;
        this.b = str;
        this.c = calendarItemState;
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

    public final boolean getSelected() {
        CalendarItemState calendarItemState = this.c;
        return calendarItemState == CalendarItemState.SELECTED_SINGLE || calendarItemState == CalendarItemState.SELECTED || calendarItemState == CalendarItemState.SELECTED_LEFT || calendarItemState == CalendarItemState.SELECTED_RIGHT;
    }

    @NotNull
    public final CalendarItemState getState() {
        return this.c;
    }

    @NotNull
    public final String getText() {
        return this.b;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DayItem(long j, String str, CalendarItemState calendarItemState, Date date, int i, j jVar) {
        this(j, str, (i & 4) != 0 ? CalendarItemState.NORMAL : calendarItemState, date);
    }
}
