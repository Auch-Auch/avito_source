package a2.a.a.b3.a;

import androidx.lifecycle.Observer;
import com.avito.android.str_calendar.booking.CalendarViewImpl;
import kotlin.Unit;
public final class i<T> implements Observer<Unit> {
    public final /* synthetic */ CalendarViewImpl a;

    public i(CalendarViewImpl calendarViewImpl) {
        this.a = calendarViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Unit unit) {
        if (unit != null) {
            this.a.a.showLoading();
        }
    }
}
