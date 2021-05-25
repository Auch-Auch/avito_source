package a2.j.b.d.t;

import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.timepicker.TimePickerView;
public class l implements MaterialButtonToggleGroup.OnButtonCheckedListener {
    public final /* synthetic */ TimePickerView a;

    public l(TimePickerView timePickerView) {
        this.a = timePickerView;
    }

    @Override // com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener
    public void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z) {
        int i2 = i == R.id.material_clock_period_pm_button ? 1 : 0;
        TimePickerView.c cVar = this.a.w;
        if (cVar != null && z) {
            ((g) cVar).b.d(i2);
        }
    }
}
