package a2.a.a.v2.b.i.a;

import com.avito.android.short_term_rent.hotels.dialogs.calendar.HotelsFiltersCalendarViewModelImpl;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
public final class r<T> implements Consumer<Throwable> {
    public final /* synthetic */ HotelsFiltersCalendarViewModelImpl a;

    public r(HotelsFiltersCalendarViewModelImpl hotelsFiltersCalendarViewModelImpl) {
        this.a = hotelsFiltersCalendarViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Logs.error(th);
        this.a.getErrorMessageChanges().postValue(this.a.x.getErrorOccurred());
        this.a.c();
    }
}
