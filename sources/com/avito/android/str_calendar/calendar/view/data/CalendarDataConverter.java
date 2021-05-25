package com.avito.android.str_calendar.calendar.view.data;

import com.avito.android.str_calendar.utils.DateRange;
import com.avito.konveyor.blueprint.Item;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J1\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataConverter;", "", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarData;", "data", "Ljava/util/Date;", "selectedDate", "Lcom/avito/android/str_calendar/utils/DateRange;", "selectedRange", "", "Lcom/avito/konveyor/blueprint/Item;", "convert", "(Lcom/avito/android/str_calendar/calendar/view/data/CalendarData;Ljava/util/Date;Lcom/avito/android/str_calendar/utils/DateRange;)Ljava/util/List;", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public interface CalendarDataConverter {
    @NotNull
    List<Item> convert(@NotNull CalendarData calendarData, @Nullable Date date, @Nullable DateRange dateRange);
}
