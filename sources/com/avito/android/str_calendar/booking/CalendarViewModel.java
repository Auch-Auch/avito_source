package com.avito.android.str_calendar.booking;

import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.DiffUtil;
import com.avito.android.str_calendar.calendar.base.BaseCalendarViewModel;
import com.avito.android.str_calendar.utils.DateRange;
import com.avito.konveyor.blueprint.Item;
import io.reactivex.functions.Consumer;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\nR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\nR\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0005R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0005¨\u0006\u001a"}, d2 = {"Lcom/avito/android/str_calendar/booking/CalendarViewModel;", "Lcom/avito/android/str_calendar/calendar/base/BaseCalendarViewModel;", "Lio/reactivex/functions/Consumer;", "", "getChooseClicksConsumer", "()Lio/reactivex/functions/Consumer;", "chooseClicksConsumer", "Landroidx/lifecycle/LiveData;", "", "getToolbarTitleChanges", "()Landroidx/lifecycle/LiveData;", "toolbarTitleChanges", "", "getClearButtonEnableChanges", "clearButtonEnableChanges", "", "getScrollToChanges", "scrollToChanges", "Lcom/avito/android/str_calendar/utils/DateRange;", "getDatesChosenChanges", "datesChosenChanges", "Ljava/util/Date;", "getDayClicksConsumer", "dayClicksConsumer", "getClearClicksConsumer", "clearClicksConsumer", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public interface CalendarViewModel extends BaseCalendarViewModel {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @NotNull
        public static DiffUtil.DiffResult calculateDiff(@NotNull CalendarViewModel calendarViewModel, @NotNull List<? extends Item> list, @NotNull List<? extends Item> list2) {
            Intrinsics.checkNotNullParameter(list, "oldList");
            Intrinsics.checkNotNullParameter(list2, "newList");
            return BaseCalendarViewModel.DefaultImpls.calculateDiff(calendarViewModel, list, list2);
        }
    }

    @NotNull
    Consumer<Unit> getChooseClicksConsumer();

    @NotNull
    LiveData<Boolean> getClearButtonEnableChanges();

    @NotNull
    Consumer<Unit> getClearClicksConsumer();

    @NotNull
    LiveData<DateRange> getDatesChosenChanges();

    @NotNull
    Consumer<Date> getDayClicksConsumer();

    @NotNull
    LiveData<Integer> getScrollToChanges();

    @NotNull
    LiveData<String> getToolbarTitleChanges();
}
