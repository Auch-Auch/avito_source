package com.avito.android.str_calendar.calendar.view.konveyor;

import com.avito.android.str_calendar.calendar.view.konveyor.items.day.booking.DayItem;
import com.avito.android.str_calendar.calendar.view.konveyor.items.day.seller.SellerDayItem;
import com.avito.android.str_calendar.calendar.view.konveyor.items.empty.EmptyItem;
import com.avito.android.str_calendar.calendar.view.konveyor.items.month.MonthItem;
import com.avito.konveyor.blueprint.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/str_calendar/calendar/view/konveyor/CalendarViewTypeProviderImpl;", "Lcom/avito/android/str_calendar/calendar/view/konveyor/CalendarViewTypeProvider;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "getItemViewType", "(Lcom/avito/konveyor/blueprint/Item;)I", "<init>", "()V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class CalendarViewTypeProviderImpl implements CalendarViewTypeProvider {
    @Override // com.avito.konveyor.blueprint.ViewTypeProvider
    public int getItemViewType(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if ((item instanceof DayItem) || (item instanceof SellerDayItem)) {
            return 1;
        }
        if (item instanceof MonthItem) {
            return 0;
        }
        if (item instanceof EmptyItem) {
            return 2;
        }
        throw new UnsupportedOperationException("Unknown item");
    }
}
