package com.google.android.material.timepicker;

import a2.j.b.d.t.l;
import a2.j.b.d.t.m;
import a2.j.b.d.t.n;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
public class TimePickerView extends ConstraintLayout {
    public final Chip q;
    public final Chip r;
    public final ClockHandView s;
    public final ClockFaceView t = ((ClockFaceView) findViewById(R.id.material_clock_face));
    public final MaterialButtonToggleGroup u;
    public final View.OnClickListener v;
    public c w;
    public d x;
    public b y;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar = TimePickerView.this.x;
            if (dVar != null) {
                dVar.a(((Integer) view.getTag(R.id.selection_type)).intValue());
            }
        }
    }

    public interface b {
    }

    public interface c {
    }

    public interface d {
        void a(int i);
    }

    public TimePickerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        a aVar = new a();
        this.v = aVar;
        LayoutInflater.from(context).inflate(R.layout.material_timepicker, this);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R.id.material_clock_period_toggle);
        this.u = materialButtonToggleGroup;
        materialButtonToggleGroup.addOnButtonCheckedListener(new l(this));
        Chip chip = (Chip) findViewById(R.id.material_minute_tv);
        this.q = chip;
        Chip chip2 = (Chip) findViewById(R.id.material_hour_tv);
        this.r = chip2;
        this.s = (ClockHandView) findViewById(R.id.material_clock_hand);
        n nVar = new n(this, new GestureDetector(getContext(), new m(this)));
        chip.setOnTouchListener(nVar);
        chip2.setOnTouchListener(nVar);
        int i = R.id.selection_type;
        chip.setTag(i, 12);
        chip2.setTag(i, 10);
        chip.setOnClickListener(aVar);
        chip2.setOnClickListener(aVar);
    }

    public final void b() {
        if (this.u.getVisibility() == 0) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this);
            int i = 1;
            if (ViewCompat.getLayoutDirection(this) == 0) {
                i = 2;
            }
            constraintSet.clear(R.id.material_clock_display, i);
            constraintSet.applyTo(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b();
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        if (view == this && i == 0) {
            b();
        }
    }
}
