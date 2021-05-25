package a2.a.a.g1.e.b;

import com.avito.android.inline_filters.dialog.calendar.InlineFiltersCalendarDialog;
import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class d<T> implements Consumer<Throwable> {
    public final /* synthetic */ InlineFiltersCalendarDialog a;

    public d(InlineFiltersCalendarDialog inlineFiltersCalendarDialog) {
        this.a = inlineFiltersCalendarDialog;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Logs.error(th);
        this.a.f.invoke();
    }
}
