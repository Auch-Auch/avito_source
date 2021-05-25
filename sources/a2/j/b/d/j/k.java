package a2.j.b.d.j;

import android.view.View;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.datepicker.MonthsPagerAdapter;
public class k implements View.OnClickListener {
    public final /* synthetic */ MonthsPagerAdapter a;
    public final /* synthetic */ MaterialCalendar b;

    public k(MaterialCalendar materialCalendar, MonthsPagerAdapter monthsPagerAdapter) {
        this.b = materialCalendar;
        this.a = monthsPagerAdapter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int findLastVisibleItemPosition = this.b.a().findLastVisibleItemPosition() - 1;
        if (findLastVisibleItemPosition >= 0) {
            this.b.c(this.a.a(findLastVisibleItemPosition));
        }
    }
}
