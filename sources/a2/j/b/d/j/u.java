package a2.j.b.d.j;

import android.view.View;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.datepicker.YearGridAdapter;
public class u implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ YearGridAdapter b;

    public u(YearGridAdapter yearGridAdapter, int i) {
        this.b = yearGridAdapter;
        this.a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        n b2 = n.b(this.a, this.b.c.d.b);
        CalendarConstraints calendarConstraints = this.b.c.c;
        if (b2.compareTo(calendarConstraints.a) < 0) {
            b2 = calendarConstraints.a;
        } else if (b2.compareTo(calendarConstraints.b) > 0) {
            b2 = calendarConstraints.b;
        }
        this.b.c.c(b2);
        this.b.c.d(MaterialCalendar.e.DAY);
    }
}
