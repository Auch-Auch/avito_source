package a2.j.b.d.j;

import android.view.View;
import android.widget.AdapterView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import com.google.android.material.datepicker.MonthsPagerAdapter;
import com.google.android.material.datepicker.OnSelectionChangedListener;
import java.util.Iterator;
public class p implements AdapterView.OnItemClickListener {
    public final /* synthetic */ MaterialCalendarGridView a;
    public final /* synthetic */ MonthsPagerAdapter b;

    public p(MonthsPagerAdapter monthsPagerAdapter, MaterialCalendarGridView materialCalendarGridView) {
        this.b = monthsPagerAdapter;
        this.a = materialCalendarGridView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        o a3 = this.a.getAdapter();
        if (i >= a3.b() && i <= a3.d()) {
            MaterialCalendar.f fVar = this.b.f;
            long longValue = this.a.getAdapter().getItem(i).longValue();
            MaterialCalendar.d dVar = (MaterialCalendar.d) fVar;
            if (MaterialCalendar.this.c.getDateValidator().isValid(longValue)) {
                MaterialCalendar.this.b.select(longValue);
                Iterator<OnSelectionChangedListener<S>> it = MaterialCalendar.this.onSelectionChangedListeners.iterator();
                while (it.hasNext()) {
                    it.next().onSelectionChanged(MaterialCalendar.this.b.getSelection());
                }
                MaterialCalendar.this.h.getAdapter().notifyDataSetChanged();
                RecyclerView recyclerView = MaterialCalendar.this.g;
                if (recyclerView != null) {
                    recyclerView.getAdapter().notifyDataSetChanged();
                }
            }
        }
    }
}
