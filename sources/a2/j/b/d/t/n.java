package a2.j.b.d.t;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import com.google.android.material.timepicker.TimePickerView;
public class n implements View.OnTouchListener {
    public final /* synthetic */ GestureDetector a;

    public n(TimePickerView timePickerView, GestureDetector gestureDetector) {
        this.a = gestureDetector;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (((Checkable) view).isChecked()) {
            return this.a.onTouchEvent(motionEvent);
        }
        return false;
    }
}
