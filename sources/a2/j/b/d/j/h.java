package a2.j.b.d.j;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.datepicker.MonthsPagerAdapter;
public class h extends RecyclerView.OnScrollListener {
    public final /* synthetic */ MonthsPagerAdapter a;
    public final /* synthetic */ MaterialButton b;
    public final /* synthetic */ MaterialCalendar c;

    public h(MaterialCalendar materialCalendar, MonthsPagerAdapter monthsPagerAdapter, MaterialButton materialButton) {
        this.c = materialCalendar;
        this.a = monthsPagerAdapter;
        this.b = materialButton;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
        if (i == 0) {
            recyclerView.announceForAccessibility(this.b.getText());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
        int i3;
        if (i < 0) {
            i3 = this.c.a().findFirstVisibleItemPosition();
        } else {
            i3 = this.c.a().findLastVisibleItemPosition();
        }
        this.c.d = this.a.a(i3);
        MaterialButton materialButton = this.b;
        MonthsPagerAdapter monthsPagerAdapter = this.a;
        materialButton.setText(monthsPagerAdapter.d.a.h(i3).g(monthsPagerAdapter.c));
    }
}
