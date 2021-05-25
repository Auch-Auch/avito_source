package a2.a.a.b3.a;

import com.avito.android.str_calendar.booking.CalendarViewModelImpl;
import com.avito.android.str_calendar.utils.DateRange;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
public final class a0<T> implements Consumer<Unit> {
    public final /* synthetic */ CalendarViewModelImpl a;

    public a0(CalendarViewModelImpl calendarViewModelImpl) {
        this.a = calendarViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Unit unit) {
        DateRange selectedRange = this.a.getCalendarDataSource().getSelectedRange();
        if (selectedRange != null) {
            String str = this.a.z;
            if (str != null) {
                this.a.y.trackSelectCalendarEvent(str);
            }
            this.a.getDatesChosenChanges().setValue(selectedRange);
            return;
        }
        this.a.getErrorMessageChanges().setValue(this.a.x.getChooseDates());
    }
}
