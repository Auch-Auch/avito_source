package com.avito.android.str_calendar.calendar.view.data;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.str_calendar.calendar.view.data.items.CalendarMonth;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\t\u0010\nR\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataImpl;", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarData;", "", "Lcom/avito/android/str_calendar/calendar/view/data/items/CalendarMonth;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getMonths", "()Ljava/util/List;", "months", "<init>", "(Ljava/util/List;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class CalendarDataImpl implements CalendarData {
    @NotNull
    public final List<CalendarMonth> a;

    public CalendarDataImpl(@NotNull List<CalendarMonth> list) {
        Intrinsics.checkNotNullParameter(list, "months");
        this.a = list;
    }

    @Override // com.avito.android.str_calendar.calendar.view.data.CalendarData
    @NotNull
    public List<CalendarMonth> getMonths() {
        return this.a;
    }
}
