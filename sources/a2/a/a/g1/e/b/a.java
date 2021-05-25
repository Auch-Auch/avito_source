package a2.a.a.g1.e.b;

import androidx.lifecycle.Observer;
import com.avito.android.inline_filters.dialog.calendar.InlineFiltersCalendarDialog;
import com.avito.android.remote.model.search.InlineFilterValue;
import com.avito.android.str_calendar.utils.DateRange;
public final class a<T> implements Observer<DateRange> {
    public final /* synthetic */ InlineFiltersCalendarDialog a;

    public a(InlineFiltersCalendarDialog inlineFiltersCalendarDialog) {
        this.a = inlineFiltersCalendarDialog;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(DateRange dateRange) {
        DateRange dateRange2 = dateRange;
        this.a.h.invoke(new InlineFilterValue.InlineFilterDateRangeValue(dateRange2.getStart(), dateRange2.getEndInclusive()));
        this.a.dismiss();
    }
}
