package a2.j.b.d.j;

import android.view.View;
import com.google.android.material.datepicker.MaterialDatePicker;
public class m implements View.OnClickListener {
    public final /* synthetic */ MaterialDatePicker a;

    public m(MaterialDatePicker materialDatePicker) {
        this.a = materialDatePicker;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MaterialDatePicker materialDatePicker = this.a;
        materialDatePicker.q.setEnabled(materialDatePicker.f.isSelectionComplete());
        this.a.o.toggle();
        MaterialDatePicker materialDatePicker2 = this.a;
        materialDatePicker2.f(materialDatePicker2.o);
        this.a.d();
    }
}
