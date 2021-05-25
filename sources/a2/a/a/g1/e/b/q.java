package a2.a.a.g1.e.b;

import com.avito.android.inline_filters.dialog.calendar.InlineFiltersCalendarViewModelImpl;
import com.avito.android.str_calendar.utils.DateRange;
import io.reactivex.functions.Consumer;
import java.util.Date;
import kotlin.Unit;
public final class q<T> implements Consumer<Unit> {
    public final /* synthetic */ InlineFiltersCalendarViewModelImpl a;

    public q(InlineFiltersCalendarViewModelImpl inlineFiltersCalendarViewModelImpl) {
        this.a = inlineFiltersCalendarViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Unit unit) {
        Date selectedDate = this.a.getCalendarDataSource().getSelectedDate();
        DateRange selectedRange = this.a.getCalendarDataSource().getSelectedRange();
        if (selectedRange != null) {
            this.a.getDatesChosenChanges().setValue(selectedRange);
        } else if (selectedDate != null) {
            this.a.getErrorMessageChanges().setValue(this.a.y.getChooseDates());
        } else {
            this.a.getEmptyDatesSelected().setValue(Unit.INSTANCE);
        }
    }
}
