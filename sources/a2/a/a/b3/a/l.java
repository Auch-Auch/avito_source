package a2.a.a.b3.a;

import androidx.lifecycle.Observer;
import com.avito.android.str_calendar.booking.CalendarViewImpl;
public final class l<T> implements Observer<String> {
    public final /* synthetic */ CalendarViewImpl a;

    public l(CalendarViewImpl calendarViewImpl) {
        this.a = calendarViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(String str) {
        String str2 = str;
        if (str2 != null) {
            this.a.h.setTitle(str2);
        }
    }
}
