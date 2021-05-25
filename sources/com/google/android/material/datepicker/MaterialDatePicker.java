package com.google.android.material.datepicker;

import a2.j.b.d.j.m;
import a2.j.b.d.j.n;
import a2.j.b.d.j.o;
import a2.j.b.d.j.q;
import a2.j.b.d.j.t;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.R;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.dialog.InsetDialogOnTouchListener;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;
public final class MaterialDatePicker<S> extends DialogFragment {
    public static final int INPUT_MODE_CALENDAR = 0;
    public static final int INPUT_MODE_TEXT = 1;
    public final LinkedHashSet<MaterialPickerOnPositiveButtonClickListener<? super S>> a = new LinkedHashSet<>();
    public final LinkedHashSet<View.OnClickListener> b = new LinkedHashSet<>();
    public final LinkedHashSet<DialogInterface.OnCancelListener> c = new LinkedHashSet<>();
    public final LinkedHashSet<DialogInterface.OnDismissListener> d = new LinkedHashSet<>();
    @StyleRes
    public int e;
    @Nullable
    public DateSelector<S> f;
    public q<S> g;
    @Nullable
    public CalendarConstraints h;
    public MaterialCalendar<S> i;
    @StringRes
    public int j;
    public CharSequence k;
    public boolean l;
    public int m;
    public TextView n;
    public CheckableImageButton o;
    @Nullable
    public MaterialShapeDrawable p;
    public Button q;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface InputMode {
    }

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator<MaterialPickerOnPositiveButtonClickListener<? super S>> it = MaterialDatePicker.this.a.iterator();
            while (it.hasNext()) {
                it.next().onPositiveButtonClick((Object) MaterialDatePicker.this.getSelection());
            }
            MaterialDatePicker.this.dismiss();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator<View.OnClickListener> it = MaterialDatePicker.this.b.iterator();
            while (it.hasNext()) {
                it.next().onClick(view);
            }
            MaterialDatePicker.this.dismiss();
        }
    }

    public class c extends OnSelectionChangedListener<S> {
        public c() {
        }

        @Override // com.google.android.material.datepicker.OnSelectionChangedListener
        public void onIncompleteSelectionChanged() {
            MaterialDatePicker.this.q.setEnabled(false);
        }

        @Override // com.google.android.material.datepicker.OnSelectionChangedListener
        public void onSelectionChanged(S s) {
            MaterialDatePicker materialDatePicker = MaterialDatePicker.this;
            int i = MaterialDatePicker.INPUT_MODE_CALENDAR;
            materialDatePicker.e();
            MaterialDatePicker materialDatePicker2 = MaterialDatePicker.this;
            materialDatePicker2.q.setEnabled(materialDatePicker2.f.isSelectionComplete());
        }
    }

    public static int a(@NonNull Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
        int i2 = n.d().d;
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width) * i2;
        return ((i2 - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding)) + dimensionPixelSize + (dimensionPixelOffset * 2);
    }

    public static boolean b(@NonNull Context context) {
        return c(context, 16843277);
    }

    public static boolean c(@NonNull Context context, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(MaterialAttributes.resolveOrThrow(context, R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), new int[]{i2});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    public static long thisMonthInUtcMilliseconds() {
        return n.d().f;
    }

    public static long todayInUtcMilliseconds() {
        return t.h().getTimeInMillis();
    }

    public boolean addOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        return this.c.add(onCancelListener);
    }

    public boolean addOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        return this.d.add(onDismissListener);
    }

    public boolean addOnNegativeButtonClickListener(View.OnClickListener onClickListener) {
        return this.b.add(onClickListener);
    }

    public boolean addOnPositiveButtonClickListener(MaterialPickerOnPositiveButtonClickListener<? super S> materialPickerOnPositiveButtonClickListener) {
        return this.a.add(materialPickerOnPositiveButtonClickListener);
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

    public final void d() {
        q<S> qVar;
        Context requireContext = requireContext();
        int i2 = this.e;
        if (i2 == 0) {
            i2 = this.f.getDefaultThemeResId(requireContext);
        }
        this.i = MaterialCalendar.newInstance(this.f, i2, this.h);
        if (this.o.isChecked()) {
            DateSelector<S> dateSelector = this.f;
            CalendarConstraints calendarConstraints = this.h;
            qVar = new MaterialTextInputPicker<>();
            Bundle bundle = new Bundle();
            bundle.putInt("THEME_RES_ID_KEY", i2);
            bundle.putParcelable("DATE_SELECTOR_KEY", dateSelector);
            bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
            qVar.setArguments(bundle);
        } else {
            qVar = this.i;
        }
        this.g = qVar;
        e();
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.mtrl_calendar_frame, this.g);
        beginTransaction.commitNow();
        this.g.addOnSelectionChangedListener(new c());
    }

    public final void e() {
        String headerText = getHeaderText();
        this.n.setContentDescription(String.format(getString(R.string.mtrl_picker_announce_current_selection), headerText));
        this.n.setText(headerText);
    }

    public final void f(@NonNull CheckableImageButton checkableImageButton) {
        String str;
        if (this.o.isChecked()) {
            str = checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_calendar_input_mode);
        } else {
            str = checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_text_input_mode);
        }
        this.o.setContentDescription(str);
    }

    public String getHeaderText() {
        return this.f.getSelectionDisplayString(getContext());
    }

    @Nullable
    public final S getSelection() {
        return this.f.getSelection();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.e = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.f = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.h = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.j = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.k = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.m = bundle.getInt("INPUT_MODE_KEY");
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(@Nullable Bundle bundle) {
        Context requireContext = requireContext();
        Context requireContext2 = requireContext();
        int i2 = this.e;
        if (i2 == 0) {
            i2 = this.f.getDefaultThemeResId(requireContext2);
        }
        Dialog dialog = new Dialog(requireContext, i2);
        Context context = dialog.getContext();
        this.l = b(context);
        int resolveOrThrow = MaterialAttributes.resolveOrThrow(context, R.attr.colorSurface, MaterialDatePicker.class.getCanonicalName());
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context, null, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
        this.p = materialShapeDrawable;
        materialShapeDrawable.initializeElevationOverlay(context);
        this.p.setFillColor(ColorStateList.valueOf(resolveOrThrow));
        this.p.setElevation(ViewCompat.getElevation(dialog.getWindow().getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(this.l ? R.layout.mtrl_picker_fullscreen : R.layout.mtrl_picker_dialog, viewGroup);
        Context context = inflate.getContext();
        if (this.l) {
            inflate.findViewById(R.id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(a(context), -2));
        } else {
            View findViewById = inflate.findViewById(R.id.mtrl_calendar_main_pane);
            View findViewById2 = inflate.findViewById(R.id.mtrl_calendar_frame);
            findViewById.setLayoutParams(new LinearLayout.LayoutParams(a(context), -1));
            Resources resources = requireContext().getResources();
            int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelSize(R.dimen.mtrl_calendar_navigation_height);
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_days_of_week_height);
            int i2 = o.f;
            findViewById2.setMinimumHeight(dimensionPixelOffset + dimensionPixelSize + (resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_vertical_padding) * (i2 - 1)) + (resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * i2) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_bottom_padding));
        }
        TextView textView = (TextView) inflate.findViewById(R.id.mtrl_picker_header_selection_text);
        this.n = textView;
        ViewCompat.setAccessibilityLiveRegion(textView, 1);
        this.o = (CheckableImageButton) inflate.findViewById(R.id.mtrl_picker_header_toggle);
        TextView textView2 = (TextView) inflate.findViewById(R.id.mtrl_picker_title_text);
        CharSequence charSequence = this.k;
        if (charSequence != null) {
            textView2.setText(charSequence);
        } else {
            textView2.setText(this.j);
        }
        this.o.setTag("TOGGLE_BUTTON_TAG");
        CheckableImageButton checkableImageButton = this.o;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912}, AppCompatResources.getDrawable(context, R.drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], AppCompatResources.getDrawable(context, R.drawable.material_ic_edit_black_24dp));
        checkableImageButton.setImageDrawable(stateListDrawable);
        this.o.setChecked(this.m != 0);
        ViewCompat.setAccessibilityDelegate(this.o, null);
        f(this.o);
        this.o.setOnClickListener(new m(this));
        this.q = (Button) inflate.findViewById(R.id.confirm_button);
        if (this.f.isSelectionComplete()) {
            this.q.setEnabled(true);
        } else {
            this.q.setEnabled(false);
        }
        this.q.setTag("CONFIRM_BUTTON_TAG");
        this.q.setOnClickListener(new a());
        Button button = (Button) inflate.findViewById(R.id.cancel_button);
        button.setTag("CANCEL_BUTTON_TAG");
        button.setOnClickListener(new b());
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.e);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f);
        CalendarConstraints.Builder builder = new CalendarConstraints.Builder(this.h);
        n nVar = this.i.d;
        if (nVar != null) {
            builder.setOpenAt(nVar.f);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", builder.build());
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.j);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.k);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.l) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.p);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.p, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new InsetDialogOnTouchListener(requireDialog(), rect));
        }
        d();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        this.g.onSelectionChangedListeners.clear();
        super.onStop();
    }

    public boolean removeOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        return this.c.remove(onCancelListener);
    }

    public boolean removeOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        return this.d.remove(onDismissListener);
    }

    public boolean removeOnNegativeButtonClickListener(View.OnClickListener onClickListener) {
        return this.b.remove(onClickListener);
    }

    public boolean removeOnPositiveButtonClickListener(MaterialPickerOnPositiveButtonClickListener<? super S> materialPickerOnPositiveButtonClickListener) {
        return this.a.remove(materialPickerOnPositiveButtonClickListener);
    }

    public static final class Builder<S> {
        public final DateSelector<S> a;
        public int b = 0;
        public CalendarConstraints c;
        public int d = 0;
        public CharSequence e = null;
        @Nullable
        public S f = null;
        public int g = 0;

        public Builder(DateSelector<S> dateSelector) {
            this.a = dateSelector;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static <S> Builder<S> customDatePicker(@NonNull DateSelector<S> dateSelector) {
            return new Builder<>(dateSelector);
        }

        @NonNull
        public static Builder<Long> datePicker() {
            return new Builder<>(new SingleDateSelector());
        }

        @NonNull
        public static Builder<Pair<Long, Long>> dateRangePicker() {
            return new Builder<>(new RangeDateSelector());
        }

        @NonNull
        public MaterialDatePicker<S> build() {
            n nVar;
            if (this.c == null) {
                this.c = new CalendarConstraints.Builder().build();
            }
            if (this.d == 0) {
                this.d = this.a.getDefaultTitleResId();
            }
            S s = this.f;
            if (s != null) {
                this.a.setSelection(s);
            }
            CalendarConstraints calendarConstraints = this.c;
            if (calendarConstraints.d == null) {
                long j = calendarConstraints.a.f;
                long j2 = calendarConstraints.b.f;
                if (!this.a.getSelectedDays().isEmpty()) {
                    long longValue = this.a.getSelectedDays().iterator().next().longValue();
                    if (longValue >= j && longValue <= j2) {
                        nVar = n.c(longValue);
                        calendarConstraints.d = nVar;
                    }
                }
                long thisMonthInUtcMilliseconds = MaterialDatePicker.thisMonthInUtcMilliseconds();
                if (j <= thisMonthInUtcMilliseconds && thisMonthInUtcMilliseconds <= j2) {
                    j = thisMonthInUtcMilliseconds;
                }
                nVar = n.c(j);
                calendarConstraints.d = nVar;
            }
            MaterialDatePicker<S> materialDatePicker = new MaterialDatePicker<>();
            Bundle bundle = new Bundle();
            bundle.putInt("OVERRIDE_THEME_RES_ID", this.b);
            bundle.putParcelable("DATE_SELECTOR_KEY", this.a);
            bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.c);
            bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.d);
            bundle.putCharSequence("TITLE_TEXT_KEY", this.e);
            bundle.putInt("INPUT_MODE_KEY", this.g);
            materialDatePicker.setArguments(bundle);
            return materialDatePicker;
        }

        @NonNull
        public Builder<S> setCalendarConstraints(CalendarConstraints calendarConstraints) {
            this.c = calendarConstraints;
            return this;
        }

        @NonNull
        public Builder<S> setInputMode(int i) {
            this.g = i;
            return this;
        }

        @NonNull
        public Builder<S> setSelection(S s) {
            this.f = s;
            return this;
        }

        @NonNull
        public Builder<S> setTheme(@StyleRes int i) {
            this.b = i;
            return this;
        }

        @NonNull
        public Builder<S> setTitleText(@StringRes int i) {
            this.d = i;
            this.e = null;
            return this;
        }

        @NonNull
        public Builder<S> setTitleText(@Nullable CharSequence charSequence) {
            this.e = charSequence;
            this.d = 0;
            return this;
        }
    }
}
