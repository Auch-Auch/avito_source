package com.avito.android.str_calendar.booking.data;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.str_calendar.calendar.utils.CalendarUtilsKt;
import com.avito.android.str_calendar.calendar.view.data.CalendarData;
import com.avito.android.str_calendar.calendar.view.data.CalendarDataConverter;
import com.avito.android.str_calendar.calendar.view.data.CalendarDataConverterKt;
import com.avito.android.str_calendar.calendar.view.data.items.CalendarItem;
import com.avito.android.str_calendar.calendar.view.data.items.CalendarItemState;
import com.avito.android.str_calendar.calendar.view.konveyor.items.day.booking.DayItem;
import com.avito.android.str_calendar.calendar.view.konveyor.items.empty.EmptyItem;
import com.avito.android.str_calendar.calendar.view.konveyor.items.month.MonthItem;
import com.avito.android.str_calendar.utils.DateRange;
import com.avito.konveyor.blueprint.Item;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u001d\u0010\u001eJ1\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u0016\u0010\u001c\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/avito/android/str_calendar/booking/data/BookingCalendarDataConverter;", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataConverter;", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarData;", "data", "Ljava/util/Date;", "selectedDate", "Lcom/avito/android/str_calendar/utils/DateRange;", "selectedRange", "", "Lcom/avito/konveyor/blueprint/Item;", "convert", "(Lcom/avito/android/str_calendar/calendar/view/data/CalendarData;Ljava/util/Date;Lcom/avito/android/str_calendar/utils/DateRange;)Ljava/util/List;", AuthSource.SEND_ABUSE, "Ljava/util/Date;", "currentDate", "Lcom/avito/android/str_calendar/booking/data/BookingCalendarDayStateProvider;", "f", "Lcom/avito/android/str_calendar/booking/data/BookingCalendarDayStateProvider;", "stateProvider", "Ljava/text/SimpleDateFormat;", "c", "Ljava/text/SimpleDateFormat;", "monthYearFormat", "e", "dayFormat", AuthSource.BOOKING_ORDER, "monthFormat", "d", "yearFormat", "<init>", "(Lcom/avito/android/str_calendar/booking/data/BookingCalendarDayStateProvider;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class BookingCalendarDataConverter implements CalendarDataConverter {
    public final Date a;
    public final SimpleDateFormat b = new SimpleDateFormat(CalendarDataConverterKt.MONTH_PATTERN, Locale.getDefault());
    public final SimpleDateFormat c = new SimpleDateFormat(CalendarDataConverterKt.MONTH_YEAR_PATTERN, Locale.getDefault());
    public final SimpleDateFormat d = new SimpleDateFormat(CalendarDataConverterKt.YEAR_PATTERN, Locale.getDefault());
    public final SimpleDateFormat e = new SimpleDateFormat("d", Locale.getDefault());
    public final BookingCalendarDayStateProvider f;

    public BookingCalendarDataConverter(@NotNull BookingCalendarDayStateProvider bookingCalendarDayStateProvider) {
        Intrinsics.checkNotNullParameter(bookingCalendarDayStateProvider, "stateProvider");
        this.f = bookingCalendarDayStateProvider;
        Date time = CalendarUtilsKt.getCalendar().getTime();
        Intrinsics.checkNotNullExpressionValue(time, "calendar.time");
        this.a = time;
    }

    @Override // com.avito.android.str_calendar.calendar.view.data.CalendarDataConverter
    @NotNull
    public List<Item> convert(@NotNull CalendarData calendarData, @Nullable Date date, @Nullable DateRange dateRange) {
        String str;
        Object obj;
        CalendarItemState calendarItemState;
        Intrinsics.checkNotNullParameter(calendarData, "data");
        ArrayList arrayList = new ArrayList();
        for (T t : calendarData.getMonths()) {
            long size = (long) arrayList.size();
            Date date2 = t.getDate();
            String format = this.d.format(this.a);
            Intrinsics.checkNotNullExpressionValue(format, "yearFormat.format(currentDate)");
            int parseInt = Integer.parseInt(format);
            String format2 = this.d.format(date2);
            Intrinsics.checkNotNullExpressionValue(format2, "yearFormat.format(monthDate)");
            if (parseInt < Integer.parseInt(format2)) {
                str = this.c.format(date2);
                Intrinsics.checkNotNullExpressionValue(str, "monthYearFormat.format(monthDate)");
            } else {
                str = this.b.format(date2);
                Intrinsics.checkNotNullExpressionValue(str, "monthFormat.format(monthDate)");
            }
            arrayList.add(new MonthItem(size, str));
            List<CalendarItem> items = t.getItems();
            ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(items, 10));
            for (T t2 : items) {
                if (t2 instanceof CalendarItem.Item) {
                    T t3 = t2;
                    String format3 = this.e.format(t3.getDate());
                    Intrinsics.checkNotNullExpressionValue(format3, "dayFormat.format(item.date)");
                    obj = new DayItem((long) arrayList.size(), format3, this.f.getDayState(t3.getDate(), date, dateRange), t3.getDate());
                } else if (t2 instanceof CalendarItem.Empty) {
                    long size2 = (long) arrayList.size();
                    T t4 = t2;
                    Date nextDate = t4.getNextDate();
                    if (dateRange == null || !dateRange.contains(t4.getNextDate()) || !(!Intrinsics.areEqual(dateRange.getStart(), t4.getNextDate()))) {
                        calendarItemState = CalendarItemState.NORMAL;
                    } else {
                        calendarItemState = CalendarItemState.SELECTED;
                    }
                    obj = new EmptyItem(size2, nextDate, calendarItemState);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                arrayList2.add(obj);
            }
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }
}
