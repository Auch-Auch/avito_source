package a2.a.a.b3.a;

import androidx.lifecycle.Observer;
import com.avito.android.str_calendar.booking.CalendarViewImpl;
public final class e<T> implements Observer<Boolean> {
    public final /* synthetic */ CalendarViewImpl a;

    public e(CalendarViewImpl calendarViewImpl) {
        this.a = calendarViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Boolean bool) {
        Boolean bool2 = bool;
        if (bool2 != null) {
            this.a.h.setClearBtnEnable(bool2.booleanValue());
        }
    }
}
