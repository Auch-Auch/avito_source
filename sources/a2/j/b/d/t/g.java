package a2.j.b.d.t;

import android.view.accessibility.AccessibilityManager;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.advert.item.AdvertDetailsPresenterKt;
import com.avito.android.messenger.conversation.adapter.LocationMessagesKt;
import com.google.android.material.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.timepicker.ClockHandView;
import com.google.android.material.timepicker.TimePickerView;
import java.util.Locale;
import java.util.Objects;
public class g implements ClockHandView.OnRotateListener, TimePickerView.d, TimePickerView.c, ClockHandView.OnActionUpListener, h {
    public static final String[] f = {"12", "1", ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8", AdvertDetailsPresenterKt.AUTO_CATEGORY_ID, "10", "11"};
    public static final String[] g = {"00", ExifInterface.GPS_MEASUREMENT_2D, "4", "6", "8", "10", "12", LocationMessagesKt.MAP_SNIPPET_WITH_MARKERS_ZOOM, "16", "18", "20", "22"};
    public static final String[] h = {"00", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};
    public TimePickerView a;
    public f b;
    public float c;
    public float d;
    public boolean e = false;

    public g(TimePickerView timePickerView, f fVar) {
        this.a = timePickerView;
        this.b = fVar;
        if (fVar.c == 0) {
            timePickerView.u.setVisibility(0);
        }
        this.a.s.g.add(this);
        TimePickerView timePickerView2 = this.a;
        timePickerView2.x = this;
        timePickerView2.w = this;
        timePickerView2.s.o = this;
        e(f, "%d");
        e(g, "%d");
        e(h, "%02d");
        invalidate();
    }

    @Override // com.google.android.material.timepicker.TimePickerView.d
    public void a(int i) {
        c(i, true);
    }

    public final int b() {
        return this.b.c == 1 ? 15 : 30;
    }

    public void c(int i, boolean z) {
        String[] strArr;
        boolean z2 = false;
        boolean z3 = i == 12;
        TimePickerView timePickerView = this.a;
        timePickerView.s.b = z3;
        f fVar = this.b;
        fVar.f = i;
        if (z3) {
            strArr = h;
        } else {
            strArr = fVar.c == 1 ? g : f;
        }
        timePickerView.t.d(strArr, z3 ? R.string.material_minute_suffix : R.string.material_hour_suffix);
        this.a.s.b(z3 ? this.c : this.d, z);
        TimePickerView timePickerView2 = this.a;
        timePickerView2.q.setChecked(i == 12);
        Chip chip = timePickerView2.r;
        if (i == 10) {
            z2 = true;
        }
        chip.setChecked(z2);
        ViewCompat.setAccessibilityDelegate(this.a.r, new a(this.a.getContext(), R.string.material_hour_selection));
        ViewCompat.setAccessibilityDelegate(this.a.q, new a(this.a.getContext(), R.string.material_minute_selection));
    }

    public final void d() {
        TimePickerView timePickerView = this.a;
        f fVar = this.b;
        int i = fVar.g;
        int b2 = fVar.b();
        int i2 = this.b.e;
        timePickerView.u.check(i == 1 ? R.id.material_clock_period_pm_button : R.id.material_clock_period_am_button);
        Locale locale = timePickerView.getResources().getConfiguration().locale;
        String format = String.format(locale, "%02d", Integer.valueOf(i2));
        String format2 = String.format(locale, "%02d", Integer.valueOf(b2));
        timePickerView.q.setText(format);
        timePickerView.r.setText(format2);
    }

    public final void e(String[] strArr, String str) {
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = f.a(this.a.getResources(), strArr[i], str);
        }
    }

    @Override // a2.j.b.d.t.h
    public void hide() {
        this.a.setVisibility(8);
    }

    @Override // a2.j.b.d.t.h
    public void invalidate() {
        this.d = (float) (b() * this.b.b());
        f fVar = this.b;
        this.c = (float) (fVar.e * 6);
        c(fVar.f, false);
        d();
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnActionUpListener
    public void onActionUp(float f2, boolean z) {
        this.e = true;
        f fVar = this.b;
        int i = fVar.e;
        int i2 = fVar.d;
        if (fVar.f == 10) {
            TimePickerView timePickerView = this.a;
            timePickerView.s.b(this.d, false);
            if (!((AccessibilityManager) ContextCompat.getSystemService(this.a.getContext(), AccessibilityManager.class)).isTouchExplorationEnabled()) {
                c(12, true);
            }
        } else {
            int round = Math.round(f2);
            if (!z) {
                f fVar2 = this.b;
                Objects.requireNonNull(fVar2);
                fVar2.e = (((round + 15) / 30) * 5) % 60;
                this.c = (float) (this.b.e * 6);
            }
            TimePickerView timePickerView2 = this.a;
            timePickerView2.s.b(this.c, z);
        }
        this.e = false;
        d();
        f fVar3 = this.b;
        if (fVar3.e != i || fVar3.d != i2) {
            this.a.performHapticFeedback(4);
        }
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnRotateListener
    public void onRotate(float f2, boolean z) {
        if (!this.e) {
            f fVar = this.b;
            int i = fVar.d;
            int i2 = fVar.e;
            int round = Math.round(f2);
            f fVar2 = this.b;
            if (fVar2.f == 12) {
                int i3 = ((round + 3) / 6) % 60;
                fVar2.e = i3;
                this.c = (float) Math.floor((double) (i3 * 6));
            } else {
                this.b.c((round + (b() / 2)) / b());
                this.d = (float) (b() * this.b.b());
            }
            if (!z) {
                d();
                f fVar3 = this.b;
                if (fVar3.e != i2 || fVar3.d != i) {
                    this.a.performHapticFeedback(4);
                }
            }
        }
    }

    @Override // a2.j.b.d.t.h
    public void show() {
        this.a.setVisibility(0);
    }
}
