package a2.j.b.d.t;

import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
public class k implements MaterialButtonToggleGroup.OnButtonCheckedListener {
    public final /* synthetic */ j a;

    public k(j jVar) {
        this.a = jVar;
    }

    @Override // com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener
    public void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z) {
        this.a.b.d(i == R.id.material_clock_period_pm_button ? 1 : 0);
    }
}
