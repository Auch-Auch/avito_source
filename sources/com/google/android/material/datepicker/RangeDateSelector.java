package com.google.android.material.datepicker;

import a2.j.b.d.j.t;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.util.Pair;
import androidx.core.util.Preconditions;
import com.google.android.material.R;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Locale;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class RangeDateSelector implements DateSelector<Pair<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new c();
    public String a;
    @Nullable
    public Long b = null;
    @Nullable
    public Long c = null;
    @Nullable
    public Long d = null;
    @Nullable
    public Long e = null;

    public class a extends a2.j.b.d.j.c {
        public final /* synthetic */ TextInputLayout g;
        public final /* synthetic */ TextInputLayout h;
        public final /* synthetic */ OnSelectionChangedListener i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, OnSelectionChangedListener onSelectionChangedListener) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.g = textInputLayout2;
            this.h = textInputLayout3;
            this.i = onSelectionChangedListener;
        }

        @Override // a2.j.b.d.j.c
        public void a() {
            RangeDateSelector rangeDateSelector = RangeDateSelector.this;
            rangeDateSelector.d = null;
            RangeDateSelector.a(rangeDateSelector, this.g, this.h, this.i);
        }

        @Override // a2.j.b.d.j.c
        public void b(@Nullable Long l) {
            RangeDateSelector rangeDateSelector = RangeDateSelector.this;
            rangeDateSelector.d = l;
            RangeDateSelector.a(rangeDateSelector, this.g, this.h, this.i);
        }
    }

    public class b extends a2.j.b.d.j.c {
        public final /* synthetic */ TextInputLayout g;
        public final /* synthetic */ TextInputLayout h;
        public final /* synthetic */ OnSelectionChangedListener i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, OnSelectionChangedListener onSelectionChangedListener) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.g = textInputLayout2;
            this.h = textInputLayout3;
            this.i = onSelectionChangedListener;
        }

        @Override // a2.j.b.d.j.c
        public void a() {
            RangeDateSelector rangeDateSelector = RangeDateSelector.this;
            rangeDateSelector.e = null;
            RangeDateSelector.a(rangeDateSelector, this.g, this.h, this.i);
        }

        @Override // a2.j.b.d.j.c
        public void b(@Nullable Long l) {
            RangeDateSelector rangeDateSelector = RangeDateSelector.this;
            rangeDateSelector.e = l;
            RangeDateSelector.a(rangeDateSelector, this.g, this.h, this.i);
        }
    }

    public static class c implements Parcelable.Creator<RangeDateSelector> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        @NonNull
        public RangeDateSelector createFromParcel(@NonNull Parcel parcel) {
            RangeDateSelector rangeDateSelector = new RangeDateSelector();
            rangeDateSelector.b = (Long) parcel.readValue(Long.class.getClassLoader());
            rangeDateSelector.c = (Long) parcel.readValue(Long.class.getClassLoader());
            return rangeDateSelector;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        @NonNull
        public RangeDateSelector[] newArray(int i) {
            return new RangeDateSelector[i];
        }
    }

    public static void a(RangeDateSelector rangeDateSelector, TextInputLayout textInputLayout, TextInputLayout textInputLayout2, OnSelectionChangedListener onSelectionChangedListener) {
        Long l = rangeDateSelector.d;
        if (l == null || rangeDateSelector.e == null) {
            if (textInputLayout.getError() != null && rangeDateSelector.a.contentEquals(textInputLayout.getError())) {
                textInputLayout.setError(null);
            }
            if (textInputLayout2.getError() != null && " ".contentEquals(textInputLayout2.getError())) {
                textInputLayout2.setError(null);
            }
            onSelectionChangedListener.onIncompleteSelectionChanged();
        } else if (rangeDateSelector.b(l.longValue(), rangeDateSelector.e.longValue())) {
            rangeDateSelector.b = rangeDateSelector.d;
            rangeDateSelector.c = rangeDateSelector.e;
            onSelectionChangedListener.onSelectionChanged(rangeDateSelector.getSelection());
        } else {
            textInputLayout.setError(rangeDateSelector.a);
            textInputLayout2.setError(" ");
            onSelectionChangedListener.onIncompleteSelectionChanged();
        }
    }

    public final boolean b(long j, long j2) {
        return j <= j2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultThemeResId(@NonNull Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return MaterialAttributes.resolveOrThrow(context, Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(R.dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis) ? R.attr.materialCalendarTheme : R.attr.materialCalendarFullscreenTheme, MaterialDatePicker.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultTitleResId() {
        return R.string.mtrl_picker_range_header_title;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Long> getSelectedDays() {
        ArrayList arrayList = new ArrayList();
        Long l = this.b;
        if (l != null) {
            arrayList.add(l);
        }
        Long l2 = this.c;
        if (l2 != null) {
            arrayList.add(l2);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Pair<Long, Long>> getSelectedRanges() {
        if (this.b == null || this.c == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(this.b, this.c));
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public String getSelectionDisplayString(@NonNull Context context) {
        Pair pair;
        Resources resources = context.getResources();
        Long l = this.b;
        if (l == null && this.c == null) {
            return resources.getString(R.string.mtrl_picker_range_header_unselected);
        }
        Long l2 = this.c;
        if (l2 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_start_selected, AppCompatDelegateImpl.i.s0(l.longValue()));
        }
        if (l == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_end_selected, AppCompatDelegateImpl.i.s0(l2.longValue()));
        }
        if (l == null && l2 == null) {
            pair = Pair.create(null, null);
        } else if (l == null) {
            pair = Pair.create(null, AppCompatDelegateImpl.i.t0(l2.longValue(), null));
        } else if (l2 == null) {
            pair = Pair.create(AppCompatDelegateImpl.i.t0(l.longValue(), null), null);
        } else {
            Calendar h = t.h();
            Calendar i = t.i();
            i.setTimeInMillis(l.longValue());
            Calendar i2 = t.i();
            i2.setTimeInMillis(l2.longValue());
            if (i.get(1) != i2.get(1)) {
                pair = Pair.create(AppCompatDelegateImpl.i.K0(l.longValue(), Locale.getDefault()), AppCompatDelegateImpl.i.K0(l2.longValue(), Locale.getDefault()));
            } else if (i.get(1) == h.get(1)) {
                pair = Pair.create(AppCompatDelegateImpl.i.F0(l.longValue(), Locale.getDefault()), AppCompatDelegateImpl.i.F0(l2.longValue(), Locale.getDefault()));
            } else {
                pair = Pair.create(AppCompatDelegateImpl.i.F0(l.longValue(), Locale.getDefault()), AppCompatDelegateImpl.i.K0(l2.longValue(), Locale.getDefault()));
            }
        }
        return resources.getString(R.string.mtrl_picker_range_header_selected, pair.first, pair.second);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean isSelectionComplete() {
        Long l = this.b;
        return (l == null || this.c == null || !b(l.longValue(), this.c.longValue())) ? false : true;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View onCreateTextInputView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, CalendarConstraints calendarConstraints, @NonNull OnSelectionChangedListener<Pair<Long, Long>> onSelectionChangedListener) {
        View inflate = layoutInflater.inflate(R.layout.mtrl_picker_text_input_date_range, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_range_start);
        TextInputLayout textInputLayout2 = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_range_end);
        EditText editText = textInputLayout.getEditText();
        EditText editText2 = textInputLayout2.getEditText();
        if (ManufacturerUtils.isDateInputKeyboardMissingSeparatorCharacters()) {
            editText.setInputType(17);
            editText2.setInputType(17);
        }
        this.a = inflate.getResources().getString(R.string.mtrl_picker_invalid_range);
        SimpleDateFormat e2 = t.e();
        Long l = this.b;
        if (l != null) {
            editText.setText(e2.format(l));
            this.d = this.b;
        }
        Long l2 = this.c;
        if (l2 != null) {
            editText2.setText(e2.format(l2));
            this.e = this.c;
        }
        String f = t.f(inflate.getResources(), e2);
        textInputLayout.setPlaceholderText(f);
        textInputLayout2.setPlaceholderText(f);
        editText.addTextChangedListener(new a(f, e2, textInputLayout, calendarConstraints, textInputLayout, textInputLayout2, onSelectionChangedListener));
        editText2.addTextChangedListener(new b(f, e2, textInputLayout2, calendarConstraints, textInputLayout, textInputLayout2, onSelectionChangedListener));
        ViewUtils.requestFocusAndShowKeyboard(editText);
        return inflate;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void select(long j) {
        Long l = this.b;
        if (l == null) {
            this.b = Long.valueOf(j);
        } else if (this.c != null || !b(l.longValue(), j)) {
            this.c = null;
            this.b = Long.valueOf(j);
        } else {
            this.c = Long.valueOf(j);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeValue(this.b);
        parcel.writeValue(this.c);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Pair<Long, Long> getSelection() {
        return new Pair<>(this.b, this.c);
    }

    public void setSelection(@NonNull Pair<Long, Long> pair) {
        Long l;
        F f = pair.first;
        if (!(f == null || pair.second == null)) {
            Preconditions.checkArgument(b(f.longValue(), pair.second.longValue()));
        }
        F f2 = pair.first;
        Long l2 = null;
        if (f2 == null) {
            l = null;
        } else {
            l = Long.valueOf(t.a(f2.longValue()));
        }
        this.b = l;
        S s = pair.second;
        if (s != null) {
            l2 = Long.valueOf(t.a(s.longValue()));
        }
        this.c = l2;
    }
}
