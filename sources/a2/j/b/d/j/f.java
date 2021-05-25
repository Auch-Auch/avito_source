package a2.j.b.d.j;

import android.graphics.Canvas;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.datepicker.YearGridAdapter;
import java.util.Calendar;
public class f extends RecyclerView.ItemDecoration {
    public final Calendar a = t.i();
    public final Calendar b = t.i();
    public final /* synthetic */ MaterialCalendar c;

    public f(MaterialCalendar materialCalendar) {
        this.c = materialCalendar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        int i;
        if ((recyclerView.getAdapter() instanceof YearGridAdapter) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            YearGridAdapter yearGridAdapter = (YearGridAdapter) recyclerView.getAdapter();
            GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            for (Pair<Long, Long> pair : this.c.b.getSelectedRanges()) {
                F f = pair.first;
                if (!(f == null || pair.second == null)) {
                    this.a.setTimeInMillis(f.longValue());
                    this.b.setTimeInMillis(pair.second.longValue());
                    int a3 = yearGridAdapter.a(this.a.get(1));
                    int a4 = yearGridAdapter.a(this.b.get(1));
                    View findViewByPosition = gridLayoutManager.findViewByPosition(a3);
                    View findViewByPosition2 = gridLayoutManager.findViewByPosition(a4);
                    int spanCount = a3 / gridLayoutManager.getSpanCount();
                    int spanCount2 = a4 / gridLayoutManager.getSpanCount();
                    for (int i2 = spanCount; i2 <= spanCount2; i2++) {
                        View findViewByPosition3 = gridLayoutManager.findViewByPosition(gridLayoutManager.getSpanCount() * i2);
                        if (findViewByPosition3 != null) {
                            int top = findViewByPosition3.getTop() + this.c.f.d.a.top;
                            int bottom = findViewByPosition3.getBottom() - this.c.f.d.a.bottom;
                            int width = i2 == spanCount ? (findViewByPosition.getWidth() / 2) + findViewByPosition.getLeft() : 0;
                            if (i2 == spanCount2) {
                                i = (findViewByPosition2.getWidth() / 2) + findViewByPosition2.getLeft();
                            } else {
                                i = recyclerView.getWidth();
                            }
                            canvas.drawRect((float) width, (float) top, (float) i, (float) bottom, this.c.f.h);
                        }
                    }
                }
            }
        }
    }
}
