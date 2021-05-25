package a2.a.a.b3.a;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.str_calendar.booking.CalendarViewImpl;
import java.util.Objects;
public final class j<T> implements Observer<Integer> {
    public final /* synthetic */ CalendarViewImpl a;

    public j(CalendarViewImpl calendarViewImpl) {
        this.a = calendarViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Integer num) {
        Integer num2 = num;
        if (num2 != null) {
            RecyclerView.LayoutManager layoutManager = this.a.getRecyclerView().getLayoutManager();
            Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
            ((GridLayoutManager) layoutManager).scrollToPositionWithOffset(num2.intValue(), this.a.g.getDisplayHeight() / 4);
        }
    }
}
