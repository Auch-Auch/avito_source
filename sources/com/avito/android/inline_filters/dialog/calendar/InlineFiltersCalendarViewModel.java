package com.avito.android.inline_filters.dialog.calendar;

import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.DiffUtil;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.str_calendar.booking.CalendarViewModel;
import com.avito.konveyor.blueprint.Item;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u000bR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/inline_filters/dialog/calendar/InlineFiltersCalendarViewModel;", "Lcom/avito/android/str_calendar/booking/CalendarViewModel;", "Landroidx/lifecycle/LiveData;", "", "getEmptyDatesSelected", "()Landroidx/lifecycle/LiveData;", "emptyDatesSelected", "Lcom/avito/android/inline_filters/dialog/calendar/InlineFiltersCalendarViewModel$Dates;", "getCurrentDates", "()Lcom/avito/android/inline_filters/dialog/calendar/InlineFiltersCalendarViewModel$Dates;", "currentDates", "Dates", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface InlineFiltersCalendarViewModel extends CalendarViewModel {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/inline_filters/dialog/calendar/InlineFiltersCalendarViewModel$Dates;", "", "Ljava/util/Date;", AuthSource.BOOKING_ORDER, "Ljava/util/Date;", "getTo", "()Ljava/util/Date;", "to", AuthSource.SEND_ABUSE, "getFrom", "from", "<init>", "(Ljava/util/Date;Ljava/util/Date;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Dates {
        @Nullable
        public final Date a;
        @Nullable
        public final Date b;

        public Dates(@Nullable Date date, @Nullable Date date2) {
            this.a = date;
            this.b = date2;
        }

        @Nullable
        public final Date getFrom() {
            return this.a;
        }

        @Nullable
        public final Date getTo() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @NotNull
        public static DiffUtil.DiffResult calculateDiff(@NotNull InlineFiltersCalendarViewModel inlineFiltersCalendarViewModel, @NotNull List<? extends Item> list, @NotNull List<? extends Item> list2) {
            Intrinsics.checkNotNullParameter(list, "oldList");
            Intrinsics.checkNotNullParameter(list2, "newList");
            return CalendarViewModel.DefaultImpls.calculateDiff(inlineFiltersCalendarViewModel, list, list2);
        }
    }

    @NotNull
    Dates getCurrentDates();

    @NotNull
    LiveData<Unit> getEmptyDatesSelected();
}
