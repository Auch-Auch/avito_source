package a2.a.a.v2.b.i.a;

import com.avito.android.short_term_rent.hotels.dialogs.calendar.HotelsFiltersCalendarViewModelImpl;
import com.avito.android.str_calendar.utils.DateRange;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Date;
import kotlin.Unit;
public final class q<T> implements Consumer<Unit> {
    public final /* synthetic */ HotelsFiltersCalendarViewModelImpl a;

    public q(HotelsFiltersCalendarViewModelImpl hotelsFiltersCalendarViewModelImpl) {
        this.a = hotelsFiltersCalendarViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Unit unit) {
        Date selectedDate = this.a.getCalendarDataSource().getSelectedDate();
        DateRange selectedRange = this.a.getCalendarDataSource().getSelectedRange();
        if (selectedRange != null) {
            this.a.getDatesChosenChanges().setValue(selectedRange);
        } else if (selectedDate != null) {
            this.a.getErrorMessageChanges().setValue(this.a.x.getChooseDates());
        } else {
            this.a.getEmptyDatesSelected().setValue(Unit.INSTANCE);
        }
    }
}
