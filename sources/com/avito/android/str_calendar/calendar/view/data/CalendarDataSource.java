package com.avito.android.str_calendar.calendar.view.data;

import com.avito.android.remote.model.Sort;
import com.avito.android.str_calendar.utils.DateRange;
import com.avito.konveyor.blueprint.Item;
import io.reactivex.Observable;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\r\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00128&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSource;", "", "Ljava/util/Date;", Sort.DATE, "", "onItemSelected", "(Ljava/util/Date;)Z", "", "onClearSelection", "()V", "Lcom/avito/android/str_calendar/utils/DateRange;", "getSelectedRange", "()Lcom/avito/android/str_calendar/utils/DateRange;", "getSelectedDate", "()Ljava/util/Date;", "", "positionOfDate", "(Ljava/util/Date;)I", "Lio/reactivex/Observable;", "", "Lcom/avito/konveyor/blueprint/Item;", "getListItemsObservable", "()Lio/reactivex/Observable;", "listItemsObservable", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public interface CalendarDataSource {
    @NotNull
    Observable<List<Item>> getListItemsObservable();

    @Nullable
    Date getSelectedDate();

    @Nullable
    DateRange getSelectedRange();

    void onClearSelection();

    boolean onItemSelected(@NotNull Date date);

    int positionOfDate(@NotNull Date date);
}
