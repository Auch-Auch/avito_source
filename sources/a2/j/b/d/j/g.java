package a2.j.b.d.j;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;
public class g extends AccessibilityDelegateCompat {
    public final /* synthetic */ MaterialCalendar d;

    public g(MaterialCalendar materialCalendar) {
        this.d = materialCalendar;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        String str;
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        if (this.d.j.getVisibility() == 0) {
            str = this.d.getString(R.string.mtrl_picker_toggle_to_year_selection);
        } else {
            str = this.d.getString(R.string.mtrl_picker_toggle_to_day_selection);
        }
        accessibilityNodeInfoCompat.setHintText(str);
    }
}
