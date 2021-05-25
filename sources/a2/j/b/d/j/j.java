package a2.j.b.d.j;

import android.view.View;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.datepicker.MonthsPagerAdapter;
public class j implements View.OnClickListener {
    public final /* synthetic */ MonthsPagerAdapter a;
    public final /* synthetic */ MaterialCalendar b;

    public j(MaterialCalendar materialCalendar, MonthsPagerAdapter monthsPagerAdapter) {
        this.b = materialCalendar;
        this.a = monthsPagerAdapter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int findFirstVisibleItemPosition = this.b.a().findFirstVisibleItemPosition() + 1;
        if (findFirstVisibleItemPosition < this.b.h.getAdapter().getItemCount()) {
            this.b.c(this.a.a(findFirstVisibleItemPosition));
        }
    }
}
