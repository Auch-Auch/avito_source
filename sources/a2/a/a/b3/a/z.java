package a2.a.a.b3.a;

import com.avito.android.str_calendar.booking.CalendarViewModelImpl;
import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class z<T> implements Consumer<Throwable> {
    public final /* synthetic */ CalendarViewModelImpl a;

    public z(CalendarViewModelImpl calendarViewModelImpl) {
        this.a = calendarViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Logs.error(th);
        this.a.onCalendarDataError(new y(this));
    }
}
