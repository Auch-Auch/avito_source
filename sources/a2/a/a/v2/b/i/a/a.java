package a2.a.a.v2.b.i.a;

import androidx.lifecycle.Observer;
import com.avito.android.short_term_rent.hotels.dialogs.calendar.HotelsCalendarDialog;
import com.avito.android.str_calendar.utils.DateRange;
public final class a<T> implements Observer<DateRange> {
    public final /* synthetic */ HotelsCalendarDialog a;

    public a(HotelsCalendarDialog hotelsCalendarDialog) {
        this.a = hotelsCalendarDialog;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(DateRange dateRange) {
        DateRange dateRange2 = dateRange;
        this.a.h.invoke(new DateRange(dateRange2.getStart(), dateRange2.getEndInclusive()));
        this.a.dismiss();
    }
}
