package a2.a.a.g1.e.b;

import com.avito.android.inline_filters.dialog.calendar.InlineFiltersCalendarViewModelImpl;
import com.avito.android.str_calendar.utils.DateRange;
import java.util.concurrent.Callable;
public final class g<V> implements Callable<Integer> {
    public final /* synthetic */ DateRange a;
    public final /* synthetic */ InlineFiltersCalendarViewModelImpl b;

    public g(DateRange dateRange, InlineFiltersCalendarViewModelImpl inlineFiltersCalendarViewModelImpl) {
        this.a = dateRange;
        this.b = inlineFiltersCalendarViewModelImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Integer call() {
        return Integer.valueOf(this.b.getCalendarDataSource().positionOfDate(this.a.getStart()));
    }
}
