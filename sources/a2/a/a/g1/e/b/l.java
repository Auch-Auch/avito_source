package a2.a.a.g1.e.b;

import com.avito.android.inline_filters.dialog.calendar.InlineFiltersCalendarViewModelImpl;
import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class l<T> implements Consumer<Throwable> {
    public final /* synthetic */ InlineFiltersCalendarViewModelImpl a;

    public l(InlineFiltersCalendarViewModelImpl inlineFiltersCalendarViewModelImpl) {
        this.a = inlineFiltersCalendarViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Logs.error(th);
        this.a.getErrorChanges().setValue(new k(this));
    }
}
