package com.avito.android.str_calendar.calendar.view.data.items;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sort;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0005R\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/str_calendar/calendar/view/data/items/CalendarMonth;", "", "", "Lcom/avito/android/str_calendar/calendar/view/data/items/CalendarItem;", "component1", "()Ljava/util/List;", "Ljava/util/Date;", "component2", "()Ljava/util/Date;", "items", Sort.DATE, "copy", "(Ljava/util/List;Ljava/util/Date;)Lcom/avito/android/str_calendar/calendar/view/data/items/CalendarMonth;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getItems", AuthSource.BOOKING_ORDER, "Ljava/util/Date;", "getDate", "<init>", "(Ljava/util/List;Ljava/util/Date;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class CalendarMonth {
    @NotNull
    public final List<CalendarItem> a;
    @NotNull
    public final Date b;

    public CalendarMonth(@NotNull List<CalendarItem> list, @NotNull Date date) {
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(date, Sort.DATE);
        this.a = list;
        this.b = date;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.str_calendar.calendar.view.data.items.CalendarMonth */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CalendarMonth copy$default(CalendarMonth calendarMonth, List list, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            list = calendarMonth.a;
        }
        if ((i & 2) != 0) {
            date = calendarMonth.b;
        }
        return calendarMonth.copy(list, date);
    }

    @NotNull
    public final List<CalendarItem> component1() {
        return this.a;
    }

    @NotNull
    public final Date component2() {
        return this.b;
    }

    @NotNull
    public final CalendarMonth copy(@NotNull List<CalendarItem> list, @NotNull Date date) {
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(date, Sort.DATE);
        return new CalendarMonth(list, date);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarMonth)) {
            return false;
        }
        CalendarMonth calendarMonth = (CalendarMonth) obj;
        return Intrinsics.areEqual(this.a, calendarMonth.a) && Intrinsics.areEqual(this.b, calendarMonth.b);
    }

    @NotNull
    public final Date getDate() {
        return this.b;
    }

    @NotNull
    public final List<CalendarItem> getItems() {
        return this.a;
    }

    public int hashCode() {
        List<CalendarItem> list = this.a;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        Date date = this.b;
        if (date != null) {
            i = date.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("CalendarMonth(items=");
        L.append(this.a);
        L.append(", date=");
        L.append(this.b);
        L.append(")");
        return L.toString();
    }
}
