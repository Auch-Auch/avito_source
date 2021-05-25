package a2.a.a.b3.a;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.str_calendar.booking.CalendarViewImpl;
import kotlin.jvm.internal.Intrinsics;
public final class m<T> implements Observer<DiffUtil.DiffResult> {
    public final /* synthetic */ CalendarViewImpl a;

    public m(CalendarViewImpl calendarViewImpl) {
        this.a = calendarViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(DiffUtil.DiffResult diffResult) {
        RecyclerView.Adapter adapter;
        DiffUtil.DiffResult diffResult2 = diffResult;
        if (diffResult2 != null && (adapter = this.a.getRecyclerView().getAdapter()) != null) {
            Intrinsics.checkNotNullExpressionValue(adapter, "recyclerView.adapter ?: return@Observer");
            diffResult2.dispatchUpdatesTo(adapter);
        }
    }
}
