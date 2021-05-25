package a2.a.a.g1.e.b;

import com.avito.android.inline_filters.dialog.calendar.InlineFiltersCalendarViewModelImpl;
import com.avito.android.str_calendar.booking.model.CalendarBookingRestriction;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Consumer;
import java.util.List;
public final class n<T> implements Consumer<LoadingState<? super List<? extends CalendarBookingRestriction>>> {
    public final /* synthetic */ InlineFiltersCalendarViewModelImpl a;

    public n(InlineFiltersCalendarViewModelImpl inlineFiltersCalendarViewModelImpl) {
        this.a = inlineFiltersCalendarViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(LoadingState<? super List<? extends CalendarBookingRestriction>> loadingState) {
        LoadingState<? super List<? extends CalendarBookingRestriction>> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loaded) {
            InlineFiltersCalendarViewModelImpl.access$onCalendarRestrictionsLoaded(this.a, (List) ((LoadingState.Loaded) loadingState2).getData());
        } else if (loadingState2 instanceof LoadingState.Loading) {
            this.a.onCalendarDataLoading();
        } else if (loadingState2 instanceof LoadingState.Error) {
            this.a.onCalendarDataError(new m(this));
        }
    }
}
