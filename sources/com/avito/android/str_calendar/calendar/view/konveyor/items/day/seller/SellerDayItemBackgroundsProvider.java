package com.avito.android.str_calendar.calendar.view.konveyor.items.day.seller;

import com.avito.android.str_calendar.calendar.view.konveyor.items.day.Position;
import com.avito.android.str_calendar.seller.calendar.data.Status;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/seller/SellerDayItemBackgroundsProvider;", "", "Lcom/avito/android/str_calendar/seller/calendar/data/Status;", "primaryStatus", "secondaryStatus", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/Position;", "primaryPosition", "secondaryPosition", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/seller/Background;", "getBackground", "(Lcom/avito/android/str_calendar/seller/calendar/data/Status;Lcom/avito/android/str_calendar/seller/calendar/data/Status;Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/Position;Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/Position;)Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/seller/Background;", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public interface SellerDayItemBackgroundsProvider {
    @NotNull
    Background getBackground(@NotNull Status status, @NotNull Status status2, @NotNull Position position, @NotNull Position position2);
}
