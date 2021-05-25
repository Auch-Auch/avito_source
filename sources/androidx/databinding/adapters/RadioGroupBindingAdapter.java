package androidx.databinding.adapters;

import android.widget.RadioGroup;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.InverseBindingMethod;
import androidx.databinding.InverseBindingMethods;
@InverseBindingMethods({@InverseBindingMethod(attribute = "android:checkedButton", method = "getCheckedRadioButtonId", type = RadioGroup.class)})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class RadioGroupBindingAdapter {

    public static class a implements RadioGroup.OnCheckedChangeListener {
        public final /* synthetic */ RadioGroup.OnCheckedChangeListener a;
        public final /* synthetic */ InverseBindingListener b;

        public a(RadioGroup.OnCheckedChangeListener onCheckedChangeListener, InverseBindingListener inverseBindingListener) {
            this.a = onCheckedChangeListener;
            this.b = inverseBindingListener;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            RadioGroup.OnCheckedChangeListener onCheckedChangeListener = this.a;
            if (onCheckedChangeListener != null) {
                onCheckedChangeListener.onCheckedChanged(radioGroup, i);
            }
            this.b.onChange();
        }
    }

    @BindingAdapter({"android:checkedButton"})
    public static void setCheckedButton(RadioGroup radioGroup, int i) {
        if (i != radioGroup.getCheckedRadioButtonId()) {
            radioGroup.check(i);
        }
    }

    @BindingAdapter(requireAll = false, value = {"android:onCheckedChanged", "android:checkedButtonAttrChanged"})
    public static void setListeners(RadioGroup radioGroup, RadioGroup.OnCheckedChangeListener onCheckedChangeListener, InverseBindingListener inverseBindingListener) {
        if (inverseBindingListener == null) {
            radioGroup.setOnCheckedChangeListener(onCheckedChangeListener);
        } else {
            radioGroup.setOnCheckedChangeListener(new a(onCheckedChangeListener, inverseBindingListener));
        }
    }
}
