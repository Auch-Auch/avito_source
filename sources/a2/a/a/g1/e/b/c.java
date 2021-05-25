package a2.a.a.g1.e.b;

import com.avito.android.inline_filters.dialog.calendar.InlineFiltersCalendarDialog;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
public final class c<T> implements Consumer<Unit> {
    public final /* synthetic */ InlineFiltersCalendarDialog a;

    public c(InlineFiltersCalendarDialog inlineFiltersCalendarDialog) {
        this.a = inlineFiltersCalendarDialog;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Unit unit) {
        this.a.f.invoke();
    }
}
