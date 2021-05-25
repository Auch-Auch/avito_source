package com.avito.android.str_calendar.seller.calendar.data;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.str_calendar.calendar.utils.CalendarUtilsKt;
import com.avito.android.str_calendar.calendar.view.data.CalendarData;
import com.avito.android.str_calendar.calendar.view.data.CalendarDataConverter;
import com.avito.android.str_calendar.calendar.view.data.CalendarDataConverterKt;
import com.avito.android.str_calendar.calendar.view.data.items.CalendarItem;
import com.avito.android.str_calendar.calendar.view.konveyor.items.day.seller.SellerDayItem;
import com.avito.android.str_calendar.calendar.view.konveyor.items.empty.EmptyItem;
import com.avito.android.str_calendar.calendar.view.konveyor.items.month.MonthItem;
import com.avito.android.str_calendar.seller.calendar.data.SellerCalendarDayStateProvider;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b\u001d\u0010\u001eJ1\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u000eR\u0016\u0010\u0018\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u000eR\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/str_calendar/seller/calendar/data/SellerCalendarDataConverter;", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataConverter;", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarData;", "data", "Ljava/util/Date;", "selectedDate", "Lcom/avito/android/str_calendar/utils/DateRange;", "selectedRange", "", "Lcom/avito/konveyor/blueprint/Item;", "convert", "(Lcom/avito/android/str_calendar/calendar/view/data/CalendarData;Ljava/util/Date;Lcom/avito/android/str_calendar/utils/DateRange;)Ljava/util/List;", "Ljava/text/SimpleDateFormat;", "c", "Ljava/text/SimpleDateFormat;", "monthYearFormat", AuthSource.BOOKING_ORDER, "monthFormat", AuthSource.SEND_ABUSE, "Ljava/util/Date;", "currentDate", "d", "yearFormat", "e", "dayFormat", "Lcom/avito/android/str_calendar/seller/calendar/data/SellerCalendarDayStateProvider;", "f", "Lcom/avito/android/str_calendar/seller/calendar/data/SellerCalendarDayStateProvider;", "stateProvider", "<init>", "(Lcom/avito/android/str_calendar/seller/calendar/data/SellerCalendarDayStateProvider;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class SellerCalendarDataConverter implements CalendarDataConverter {
    public final Date a;
    public final SimpleDateFormat b = new SimpleDateFormat(CalendarDataConverterKt.MONTH_PATTERN, Locale.getDefault());
    public final SimpleDateFormat c = new SimpleDateFormat(CalendarDataConverterKt.MONTH_YEAR_PATTERN, Locale.getDefault());
    public final SimpleDateFormat d = new SimpleDateFormat(CalendarDataConverterKt.YEAR_PATTERN, Locale.getDefault());
    public final SimpleDateFormat e = new SimpleDateFormat("d", Locale.getDefault());
    public final SellerCalendarDayStateProvider f;

    public SellerCalendarDataConverter(@NotNull SellerCalendarDayStateProvider sellerCalendarDayStateProvider) {
        Intrinsics.checkNotNullParameter(sellerCalendarDayStateProvider, "stateProvider");
        this.f = sellerCalendarDayStateProvider;
        Date time = CalendarUtilsKt.getCalendar().getTime();
        Intrinsics.checkNotNullExpressionValue(time, "calendar.time");
        this.a = time;
    }

    @Override // com.avito.android.str_calendar.calendar.view.data.CalendarDataConverter
    @NotNull
    public List<Item> convert(@NotNull CalendarData calendarData, @Nullable Date date, @Nullable DateRange dateRange) {
        String str;
        Object obj;
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
                    obj = new SellerDayItem((long) arrayList.size(), format3, SellerCalendarDayStateProvider.DefaultImpls.getDayState$default(this.f, t3.getDate(), null, null, 6, null), t3.getDate());
                } else if (t2 instanceof CalendarItem.Empty) {
                    Date nextDate = t2.getNextDate();
                    obj = new EmptyItem((long) arrayList.size(), nextDate, this.f.getEmptyItemState(nextDate, null));
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
