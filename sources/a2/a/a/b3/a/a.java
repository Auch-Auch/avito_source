package a2.a.a.b3.a;

import androidx.fragment.app.FragmentActivity;
import com.avito.android.str_calendar.booking.CalendarFragment;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
public final class a<T> implements Consumer<Unit> {
    public final /* synthetic */ CalendarFragment a;

    public a(CalendarFragment calendarFragment) {
        this.a = calendarFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Unit unit) {
        FragmentActivity activity = this.a.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }
}
