package a2.j.b.d.s;

import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import androidx.annotation.NonNull;
public class j implements View.OnTouchListener {
    public final /* synthetic */ AutoCompleteTextView a;
    public final /* synthetic */ h b;

    public j(h hVar, AutoCompleteTextView autoCompleteTextView) {
        this.b = hVar;
        this.a = autoCompleteTextView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@NonNull View view, @NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.b.j()) {
                this.b.i = false;
            }
            h.h(this.b, this.a);
        }
        return false;
    }
}
