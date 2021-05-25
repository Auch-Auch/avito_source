package a2.a.a.v2.b.i.a;

import com.avito.android.short_term_rent.hotels.dialogs.calendar.HotelsFiltersCalendarViewModelImpl;
import com.avito.android.str_calendar.booking.model.CalendarBookingRestriction;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
public final class n<T> implements Consumer<LoadingState<? super List<? extends CalendarBookingRestriction>>> {
    public final /* synthetic */ HotelsFiltersCalendarViewModelImpl a;

    public n(HotelsFiltersCalendarViewModelImpl hotelsFiltersCalendarViewModelImpl) {
        this.a = hotelsFiltersCalendarViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(LoadingState<? super List<? extends CalendarBookingRestriction>> loadingState) {
        LoadingState<? super List<? extends CalendarBookingRestriction>> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loaded) {
            HotelsFiltersCalendarViewModelImpl.access$onCalendarRestrictionsLoaded(this.a, (List) ((LoadingState.Loaded) loadingState2).getData());
        } else if (loadingState2 instanceof LoadingState.Loading) {
            this.a.onCalendarDataLoading();
        } else if (loadingState2 instanceof LoadingState.Error) {
            this.a.onCalendarDataError(new m(this));
        }
    }
}
