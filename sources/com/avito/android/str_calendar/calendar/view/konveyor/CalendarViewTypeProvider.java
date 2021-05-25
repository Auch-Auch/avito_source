package com.avito.android.str_calendar.calendar.view.konveyor;

import com.avito.konveyor.blueprint.ViewTypeProvider;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/avito/android/str_calendar/calendar/view/konveyor/CalendarViewTypeProvider;", "Lcom/avito/konveyor/blueprint/ViewTypeProvider;", "ViewType", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public interface CalendarViewTypeProvider extends ViewTypeProvider {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/avito/android/str_calendar/calendar/view/konveyor/CalendarViewTypeProvider$ViewType;", "", "", "EMPTY", "I", "MONTH", "DAY", "<init>", "()V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
    public static final class ViewType {
        public static final int DAY = 1;
        public static final int EMPTY = 2;
        @NotNull
        public static final ViewType INSTANCE = new ViewType();
        public static final int MONTH = 0;
    }
}
