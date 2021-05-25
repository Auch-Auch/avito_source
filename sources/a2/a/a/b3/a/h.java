package a2.a.a.b3.a;

import androidx.lifecycle.Observer;
import com.avito.android.str_calendar.booking.CalendarViewImpl;
import com.avito.android.util.AvitoSnackbar;
public final class h<T> implements Observer<String> {
    public final /* synthetic */ CalendarViewImpl a;

    public h(CalendarViewImpl calendarViewImpl) {
        this.a = calendarViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(String str) {
        String str2 = str;
        if (str2 != null) {
            AvitoSnackbar.make$default(AvitoSnackbar.INSTANCE, this.a.e, str2, -1, null, 0, null, null, 0, 0, 0, 1016, null).show();
        }
    }
}
