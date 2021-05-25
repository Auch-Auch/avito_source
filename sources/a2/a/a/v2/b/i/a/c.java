package a2.a.a.v2.b.i.a;

import com.avito.android.short_term_rent.hotels.dialogs.calendar.HotelsCalendarDialog;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
public final class c<T> implements Consumer<Unit> {
    public final /* synthetic */ HotelsCalendarDialog a;

    public c(HotelsCalendarDialog hotelsCalendarDialog) {
        this.a = hotelsCalendarDialog;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Unit unit) {
        this.a.f.invoke();
    }
}
