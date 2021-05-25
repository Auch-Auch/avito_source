package a2.a.a.v2.b.i.a;

import androidx.lifecycle.Observer;
import com.avito.android.short_term_rent.hotels.dialogs.calendar.HotelsCalendarDialog;
import kotlin.Unit;
public final class b<T> implements Observer<Unit> {
    public final /* synthetic */ HotelsCalendarDialog a;

    public b(HotelsCalendarDialog hotelsCalendarDialog) {
        this.a = hotelsCalendarDialog;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Unit unit) {
        this.a.h.invoke(null);
        this.a.dismiss();
    }
}
