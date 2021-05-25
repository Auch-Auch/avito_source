package a2.j.b.d.j;

import android.view.View;
import com.google.android.material.datepicker.MaterialCalendar;
public class i implements View.OnClickListener {
    public final /* synthetic */ MaterialCalendar a;

    public i(MaterialCalendar materialCalendar) {
        this.a = materialCalendar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MaterialCalendar materialCalendar = this.a;
        MaterialCalendar.e eVar = MaterialCalendar.e.DAY;
        MaterialCalendar.e eVar2 = materialCalendar.e;
        MaterialCalendar.e eVar3 = MaterialCalendar.e.YEAR;
        if (eVar2 == eVar3) {
            materialCalendar.d(eVar);
        } else if (eVar2 == eVar) {
            materialCalendar.d(eVar3);
        }
    }
}
