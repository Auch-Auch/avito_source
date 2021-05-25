package androidx.databinding.adapters;

import android.widget.CalendarView;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.InverseBindingMethod;
import androidx.databinding.InverseBindingMethods;
@InverseBindingMethods({@InverseBindingMethod(attribute = "android:date", type = CalendarView.class)})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class CalendarViewBindingAdapter {

    public static class a implements CalendarView.OnDateChangeListener {
        public final /* synthetic */ CalendarView.OnDateChangeListener a;
        public final /* synthetic */ InverseBindingListener b;

        public a(CalendarView.OnDateChangeListener onDateChangeListener, InverseBindingListener inverseBindingListener) {
            this.a = onDateChangeListener;
            this.b = inverseBindingListener;
        }

        @Override // android.widget.CalendarView.OnDateChangeListener
        public void onSelectedDayChange(CalendarView calendarView, int i, int i2, int i3) {
            CalendarView.OnDateChangeListener onDateChangeListener = this.a;
            if (onDateChangeListener != null) {
                onDateChangeListener.onSelectedDayChange(calendarView, i, i2, i3);
            }
            this.b.onChange();
        }
    }

    @BindingAdapter({"android:date"})
    public static void setDate(CalendarView calendarView, long j) {
        if (calendarView.getDate() != j) {
            calendarView.setDate(j);
        }
    }

    @BindingAdapter(requireAll = false, value = {"android:onSelectedDayChange", "android:dateAttrChanged"})
    public static void setListeners(CalendarView calendarView, CalendarView.OnDateChangeListener onDateChangeListener, InverseBindingListener inverseBindingListener) {
        if (inverseBindingListener == null) {
            calendarView.setOnDateChangeListener(onDateChangeListener);
        } else {
            calendarView.setOnDateChangeListener(new a(onDateChangeListener, inverseBindingListener));
        }
    }
}
