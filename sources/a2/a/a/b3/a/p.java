package a2.a.a.b3.a;

import com.avito.android.str_calendar.booking.CalendarViewModelImpl;
import com.avito.android.str_calendar.booking.model.BookingCalendarItem;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Consumer;
import java.util.List;
public final class p<T> implements Consumer<LoadingState<? super List<? extends BookingCalendarItem>>> {
    public final /* synthetic */ CalendarViewModelImpl a;

    public p(CalendarViewModelImpl calendarViewModelImpl) {
        this.a = calendarViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(LoadingState<? super List<? extends BookingCalendarItem>> loadingState) {
        LoadingState<? super List<? extends BookingCalendarItem>> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loaded) {
            CalendarViewModelImpl.access$onBookingCalendarItemsLoaded(this.a, (List) ((LoadingState.Loaded) loadingState2).getData());
        } else if (loadingState2 instanceof LoadingState.Loading) {
            this.a.onCalendarDataLoading();
        } else if (loadingState2 instanceof LoadingState.Error) {
            this.a.onCalendarDataError(new o(this));
        }
    }
}
