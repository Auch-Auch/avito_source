package com.google.android.material.timepicker;

import a2.j.b.d.t.f;
import a2.j.b.d.t.g;
import a2.j.b.d.t.h;
import a2.j.b.d.t.j;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.timepicker.TimePickerView;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
public final class MaterialTimePicker extends DialogFragment {
    public static final int INPUT_MODE_CLOCK = 0;
    public static final int INPUT_MODE_KEYBOARD = 1;
    public final Set<View.OnClickListener> a = new LinkedHashSet();
    public final Set<View.OnClickListener> b = new LinkedHashSet();
    public final Set<DialogInterface.OnCancelListener> c = new LinkedHashSet();
    public final Set<DialogInterface.OnDismissListener> d = new LinkedHashSet();
    public TimePickerView e;
    public LinearLayout f;
    public ViewStub g;
    @Nullable
    public g h;
    @Nullable
    public j i;
    @Nullable
    public h j;
    @DrawableRes
    public int k;
    @DrawableRes
    public int l;
    public int m = 0;
    public String n;
    public MaterialButton o;
    public int p = 0;
    public f q;

    public static final class Builder {
        public f a = new f(0, 0, 10, 0);
        public int b;
        public int c = 0;
        public CharSequence d;

        @NonNull
        public MaterialTimePicker build() {
            MaterialTimePicker materialTimePicker = new MaterialTimePicker();
            Bundle bundle = new Bundle();
            bundle.putParcelable("TIME_PICKER_TIME_MODEL", this.a);
            bundle.putInt("TIME_PICKER_INPUT_MODE", this.b);
            bundle.putInt("TIME_PICKER_TITLE_RES", this.c);
            CharSequence charSequence = this.d;
            if (charSequence != null) {
                bundle.putString("TIME_PICKER_TITLE_TEXT", charSequence.toString());
            }
            materialTimePicker.setArguments(bundle);
            return materialTimePicker;
        }

        @NonNull
        public Builder setHour(@IntRange(from = 0, to = 23) int i) {
            f fVar = this.a;
            fVar.g = i >= 12 ? 1 : 0;
            fVar.d = i;
            return this;
        }

        @NonNull
        public Builder setInputMode(int i) {
            this.b = i;
            return this;
        }

        @NonNull
        public Builder setMinute(@IntRange(from = 0, to = 60) int i) {
            f fVar = this.a;
            Objects.requireNonNull(fVar);
            fVar.e = i % 60;
            return this;
        }

        @NonNull
        public Builder setTimeFormat(int i) {
            f fVar = this.a;
            int i2 = fVar.d;
            int i3 = fVar.e;
            int i4 = 0;
            f fVar2 = new f(0, 0, 10, i);
            this.a = fVar2;
            fVar2.e = i3 % 60;
            if (i2 >= 12) {
                i4 = 1;
            }
            fVar2.g = i4;
            fVar2.d = i2;
            return this;
        }

        @NonNull
        public Builder setTitleText(@StringRes int i) {
            this.c = i;
            return this;
        }

        @NonNull
        public Builder setTitleText(@Nullable CharSequence charSequence) {
            this.d = charSequence;
            return this;
        }
    }

    public class a implements TimePickerView.b {
        public a() {
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            for (View.OnClickListener onClickListener : MaterialTimePicker.this.a) {
                onClickListener.onClick(view);
            }
            MaterialTimePicker.this.dismiss();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            for (View.OnClickListener onClickListener : MaterialTimePicker.this.b) {
                onClickListener.onClick(view);
            }
            MaterialTimePicker.this.dismiss();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MaterialTimePicker materialTimePicker = MaterialTimePicker.this;
            materialTimePicker.p = materialTimePicker.p == 0 ? 1 : 0;
            materialTimePicker.a(materialTimePicker.o);
        }
    }

    public final void a(MaterialButton materialButton) {
        g gVar;
        Pair pair;
        h hVar = this.j;
        if (hVar != null) {
            hVar.hide();
        }
        if (this.p == 0) {
            g gVar2 = this.h;
            g gVar3 = gVar2;
            if (gVar2 == null) {
                gVar3 = new g(this.e, this.q);
            }
            this.h = gVar3;
            gVar = gVar3;
        } else {
            if (this.i == null) {
                LinearLayout linearLayout = (LinearLayout) this.g.inflate();
                this.f = linearLayout;
                this.i = new j(linearLayout, this.q);
            }
            j jVar = this.i;
            jVar.e.setChecked(false);
            jVar.f.setChecked(false);
            gVar = this.i;
        }
        this.j = gVar;
        gVar.show();
        this.j.invalidate();
        int i2 = this.p;
        if (i2 == 0) {
            pair = new Pair(Integer.valueOf(this.k), Integer.valueOf(R.string.material_timepicker_text_input_mode_description));
        } else if (i2 == 1) {
            pair = new Pair(Integer.valueOf(this.l), Integer.valueOf(R.string.material_timepicker_clock_mode_description));
        } else {
            throw new IllegalArgumentException(a2.b.a.a.a.M2("no icon for mode: ", i2));
        }
        materialButton.setIconResource(((Integer) pair.first).intValue());
        materialButton.setContentDescription(getResources().getString(((Integer) pair.second).intValue()));
    }

    public boolean addOnCancelListener(@NonNull DialogInterface.OnCancelListener onCancelListener) {
        return this.c.add(onCancelListener);
    }

    public boolean addOnDismissListener(@NonNull DialogInterface.OnDismissListener onDismissListener) {
        return this.d.add(onDismissListener);
    }

    public boolean addOnNegativeButtonClickListener(@NonNull View.OnClickListener onClickListener) {
        return this.b.add(onClickListener);
    }

    public boolean addOnPositiveButtonClickListener(@NonNull View.OnClickListener onClickListener) {
        return this.a.add(onClickListener);
    }

    public void clearOnCancelListeners() {
        this.c.clear();
    }

    public void clearOnDismissListeners() {
        this.d.clear();
    }

    public void clearOnNegativeButtonClickListeners() {
        this.b.clear();
    }

    public void clearOnPositiveButtonClickListeners() {
        this.a.clear();
    }

    @IntRange(from = 0, to = 23)
    public int getHour() {
        return this.q.d % 24;
    }

    public int getInputMode() {
        return this.p;
    }

    @IntRange(from = 0, to = 60)
    public int getMinute() {
        return this.q.e;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@NonNull DialogInterface dialogInterface) {
        for (DialogInterface.OnCancelListener onCancelListener : this.c) {
            onCancelListener.onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        if (bundle != null) {
            f fVar = (f) bundle.getParcelable("TIME_PICKER_TIME_MODEL");
            this.q = fVar;
            if (fVar == null) {
                this.q = new f(0, 0, 10, 0);
            }
            this.p = bundle.getInt("TIME_PICKER_INPUT_MODE", 0);
            this.m = bundle.getInt("TIME_PICKER_TITLE_RES", 0);
            this.n = bundle.getString("TIME_PICKER_TITLE_TEXT");
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(@Nullable Bundle bundle) {
        TypedValue resolve = MaterialAttributes.resolve(requireContext(), R.attr.materialTimePickerTheme);
        Dialog dialog = new Dialog(requireContext(), resolve == null ? 0 : resolve.data);
        Context context = dialog.getContext();
        int resolveOrThrow = MaterialAttributes.resolveOrThrow(context, R.attr.colorSurface, MaterialTimePicker.class.getCanonicalName());
        int i2 = R.attr.materialTimePickerStyle;
        int i3 = R.style.Widget_MaterialComponents_TimePicker;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context, null, i2, i3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.MaterialTimePicker, i2, i3);
        this.l = obtainStyledAttributes.getResourceId(R.styleable.MaterialTimePicker_clockIcon, 0);
        this.k = obtainStyledAttributes.getResourceId(R.styleable.MaterialTimePicker_keyboardIcon, 0);
        obtainStyledAttributes.recycle();
        materialShapeDrawable.initializeElevationOverlay(context);
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(resolveOrThrow));
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(materialShapeDrawable);
        window.requestFeature(1);
        window.setLayout(-2, -2);
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.material_timepicker_dialog, viewGroup);
        TimePickerView timePickerView = (TimePickerView) viewGroup2.findViewById(R.id.material_timepicker_view);
        this.e = timePickerView;
        timePickerView.y = new a();
        this.g = (ViewStub) viewGroup2.findViewById(R.id.material_textinput_timepicker);
        this.o = (MaterialButton) viewGroup2.findViewById(R.id.material_timepicker_mode_button);
        TextView textView = (TextView) viewGroup2.findViewById(R.id.header_title);
        if (!TextUtils.isEmpty(this.n)) {
            textView.setText(this.n);
        }
        int i2 = this.m;
        if (i2 != 0) {
            textView.setText(i2);
        }
        a(this.o);
        ((Button) viewGroup2.findViewById(R.id.material_timepicker_ok_button)).setOnClickListener(new b());
        ((Button) viewGroup2.findViewById(R.id.material_timepicker_cancel_button)).setOnClickListener(new c());
        this.o.setOnClickListener(new d());
        return viewGroup2;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@NonNull DialogInterface dialogInterface) {
        for (DialogInterface.OnDismissListener onDismissListener : this.d) {
            onDismissListener.onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("TIME_PICKER_TIME_MODEL", this.q);
        bundle.putInt("TIME_PICKER_INPUT_MODE", this.p);
        bundle.putInt("TIME_PICKER_TITLE_RES", this.m);
        bundle.putString("TIME_PICKER_TITLE_TEXT", this.n);
    }

    public boolean removeOnCancelListener(@NonNull DialogInterface.OnCancelListener onCancelListener) {
        return this.c.remove(onCancelListener);
    }

    public boolean removeOnDismissListener(@NonNull DialogInterface.OnDismissListener onDismissListener) {
        return this.d.remove(onDismissListener);
    }

    public boolean removeOnNegativeButtonClickListener(@NonNull View.OnClickListener onClickListener) {
        return this.b.remove(onClickListener);
    }

    public boolean removeOnPositiveButtonClickListener(@NonNull View.OnClickListener onClickListener) {
        return this.a.remove(onClickListener);
    }
}
