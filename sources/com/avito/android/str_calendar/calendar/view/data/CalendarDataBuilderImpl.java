package com.avito.android.str_calendar.calendar.view.data;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.str_calendar.calendar.utils.CalendarUtilsKt;
import com.avito.android.str_calendar.calendar.view.data.items.CalendarItem;
import com.avito.android.str_calendar.calendar.view.data.items.CalendarMonth;
import com.avito.android.str_calendar.utils.DateRange;
import com.avito.android.util.CalendarsKt;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataBuilderImpl;", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataBuilder;", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarData;", "build", "()Lcom/avito/android/str_calendar/calendar/view/data/CalendarData;", "Lcom/avito/android/str_calendar/utils/DateRange;", AuthSource.SEND_ABUSE, "Lcom/avito/android/str_calendar/utils/DateRange;", "buildingRange", "<init>", "(Lcom/avito/android/str_calendar/utils/DateRange;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class CalendarDataBuilderImpl implements CalendarDataBuilder {
    public final DateRange a;

    public CalendarDataBuilderImpl(@NotNull DateRange dateRange) {
        Intrinsics.checkNotNullParameter(dateRange, "buildingRange");
        this.a = dateRange;
    }

    @Override // com.avito.android.str_calendar.calendar.view.data.CalendarDataBuilder
    @NotNull
    public CalendarData build() {
        List<CalendarItem> items;
        int i;
        int i2;
        ArrayList arrayList = new ArrayList();
        Calendar calendar = CalendarUtilsKt.getCalendar();
        calendar.setTime(this.a.getStart());
        CalendarsKt.clearTime(calendar);
        calendar.set(5, 1);
        Calendar calendar2 = CalendarUtilsKt.getCalendar();
        calendar2.setTime(this.a.getStart());
        Calendar calendar3 = CalendarUtilsKt.getCalendar();
        calendar3.setTime(this.a.getEndInclusive());
        int i3 = (calendar3.get(2) + ((calendar3.get(1) - calendar2.get(1)) * 12)) - calendar2.get(2);
        if (calendar3.get(5) == calendar3.getActualMaximum(5)) {
            i3++;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            Date time = calendar.getTime();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int i5 = calendar.get(7);
            switch (i5) {
                case 1:
                    i = 6;
                    break;
                case 2:
                    i = 0;
                    break;
                case 3:
                    i = 1;
                    break;
                case 4:
                    i = 2;
                    break;
                case 5:
                    i = 3;
                    break;
                case 6:
                    i = 4;
                    break;
                case 7:
                    i = 5;
                    break;
                default:
                    throw new IllegalArgumentException(a.M2("Wrong day of week: ", i5));
            }
            for (int i6 = 0; i6 < i; i6++) {
                Date time2 = calendar.getTime();
                Intrinsics.checkNotNullExpressionValue(time2, "calendar.time");
                arrayList3.add(new CalendarItem.Empty(time2));
            }
            arrayList2.addAll(arrayList3);
            ArrayList arrayList4 = new ArrayList();
            int actualMaximum = calendar.getActualMaximum(5);
            for (int i7 = 0; i7 < actualMaximum; i7++) {
                Date time3 = calendar.getTime();
                Intrinsics.checkNotNullExpressionValue(time3, "calendar.time");
                arrayList4.add(new CalendarItem.Item(time3));
                calendar.add(5, 1);
            }
            arrayList2.addAll(arrayList4);
            ArrayList arrayList5 = new ArrayList();
            int i8 = calendar.get(7);
            switch (i8) {
                case 1:
                    i2 = 1;
                    break;
                case 2:
                    i2 = 0;
                    break;
                case 3:
                    i2 = 6;
                    break;
                case 4:
                    i2 = 5;
                    break;
                case 5:
                    i2 = 4;
                    break;
                case 6:
                    i2 = 3;
                    break;
                case 7:
                    i2 = 2;
                    break;
                default:
                    throw new IllegalArgumentException(a.M2("Wrong day of week: ", i8));
            }
            for (int i9 = 0; i9 < i2; i9++) {
                Date time4 = calendar.getTime();
                Intrinsics.checkNotNullExpressionValue(time4, "calendar.time");
                arrayList5.add(new CalendarItem.Empty(time4));
            }
            arrayList2.addAll(arrayList5);
            Intrinsics.checkNotNullExpressionValue(time, "monthDate");
            arrayList.add(new CalendarMonth(arrayList2, time));
        }
        CalendarMonth calendarMonth = (CalendarMonth) CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) arrayList);
        if (!(calendarMonth == null || (items = calendarMonth.getItems()) == null)) {
            ArrayList arrayList6 = new ArrayList();
            for (int i10 = 0; i10 < 14; i10++) {
                Date time5 = calendar.getTime();
                Intrinsics.checkNotNullExpressionValue(time5, "calendar.time");
                arrayList6.add(new CalendarItem.Empty(time5));
            }
            items.addAll(arrayList6);
        }
        return new CalendarDataImpl(arrayList);
    }
}
