package a2.j.b.d.t;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.google.android.material.timepicker.ChipTextInputComboView;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimePickerView;
public class m extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ TimePickerView a;

    public m(TimePickerView timePickerView) {
        this.a = timePickerView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        boolean onDoubleTap = super.onDoubleTap(motionEvent);
        TimePickerView.b bVar = this.a.y;
        if (bVar != null) {
            MaterialTimePicker.a aVar = (MaterialTimePicker.a) bVar;
            MaterialTimePicker materialTimePicker = MaterialTimePicker.this;
            boolean z = true;
            materialTimePicker.p = 1;
            materialTimePicker.a(materialTimePicker.o);
            j jVar = MaterialTimePicker.this.i;
            jVar.e.setChecked(jVar.b.f == 12);
            ChipTextInputComboView chipTextInputComboView = jVar.f;
            if (jVar.b.f != 10) {
                z = false;
            }
            chipTextInputComboView.setChecked(z);
        }
        return onDoubleTap;
    }
}
