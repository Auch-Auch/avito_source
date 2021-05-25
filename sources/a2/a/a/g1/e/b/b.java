package a2.a.a.g1.e.b;

import androidx.lifecycle.Observer;
import com.avito.android.inline_filters.dialog.calendar.InlineFiltersCalendarDialog;
import com.avito.android.remote.model.search.InlineFilterValue;
import kotlin.Unit;
public final class b<T> implements Observer<Unit> {
    public final /* synthetic */ InlineFiltersCalendarDialog a;

    public b(InlineFiltersCalendarDialog inlineFiltersCalendarDialog) {
        this.a = inlineFiltersCalendarDialog;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Unit unit) {
        this.a.h.invoke(new InlineFilterValue.InlineFilterDateRangeValue(null, null));
        this.a.dismiss();
    }
}
