package a2.j.b.d.t;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.timepicker.ChipTextInputComboView;
import com.google.android.material.timepicker.TimePickerView;
import java.util.Locale;
import java.util.Objects;
public class j implements TimePickerView.d, h {
    public final LinearLayout a;
    public final f b;
    public final TextWatcher c;
    public final TextWatcher d;
    public final ChipTextInputComboView e;
    public final ChipTextInputComboView f;
    public final i g;
    public final EditText h;
    public final EditText i;
    public MaterialButtonToggleGroup j;

    public class a extends TextWatcherAdapter {
        public a() {
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    f fVar = j.this.b;
                    Objects.requireNonNull(fVar);
                    fVar.e = 0;
                    return;
                }
                int parseInt = Integer.parseInt(editable.toString());
                f fVar2 = j.this.b;
                Objects.requireNonNull(fVar2);
                fVar2.e = parseInt % 60;
            } catch (NumberFormatException unused) {
            }
        }
    }

    public class b extends TextWatcherAdapter {
        public b() {
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    j.this.b.c(0);
                    return;
                }
                j.this.b.c(Integer.parseInt(editable.toString()));
            } catch (NumberFormatException unused) {
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.a(((Integer) view.getTag(R.id.selection_type)).intValue());
        }
    }

    public j(LinearLayout linearLayout, f fVar) {
        a aVar = new a();
        this.c = aVar;
        b bVar = new b();
        this.d = bVar;
        this.a = linearLayout;
        this.b = fVar;
        Resources resources = linearLayout.getResources();
        ChipTextInputComboView chipTextInputComboView = (ChipTextInputComboView) linearLayout.findViewById(R.id.material_minute_text_input);
        this.e = chipTextInputComboView;
        ChipTextInputComboView chipTextInputComboView2 = (ChipTextInputComboView) linearLayout.findViewById(R.id.material_hour_text_input);
        this.f = chipTextInputComboView2;
        int i2 = R.id.material_label;
        ((TextView) chipTextInputComboView.findViewById(i2)).setText(resources.getString(R.string.material_timepicker_minute));
        ((TextView) chipTextInputComboView2.findViewById(i2)).setText(resources.getString(R.string.material_timepicker_hour));
        int i3 = R.id.selection_type;
        chipTextInputComboView.setTag(i3, 12);
        chipTextInputComboView2.setTag(i3, 10);
        if (fVar.c == 0) {
            MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) linearLayout.findViewById(R.id.material_clock_period_toggle);
            this.j = materialButtonToggleGroup;
            materialButtonToggleGroup.addOnButtonCheckedListener(new k(this));
            this.j.setVisibility(0);
            c();
        }
        c cVar = new c();
        chipTextInputComboView2.setOnClickListener(cVar);
        chipTextInputComboView.setOnClickListener(cVar);
        chipTextInputComboView2.a(fVar.b);
        chipTextInputComboView.a(fVar.a);
        EditText editText = chipTextInputComboView2.b.getEditText();
        this.h = editText;
        EditText editText2 = chipTextInputComboView.b.getEditText();
        this.i = editText2;
        i iVar = new i(chipTextInputComboView2, chipTextInputComboView, fVar);
        this.g = iVar;
        ViewCompat.setAccessibilityDelegate(chipTextInputComboView2.a, new a(linearLayout.getContext(), R.string.material_hour_selection));
        ViewCompat.setAccessibilityDelegate(chipTextInputComboView.a, new a(linearLayout.getContext(), R.string.material_minute_selection));
        editText.addTextChangedListener(bVar);
        editText2.addTextChangedListener(aVar);
        b(fVar);
        TextInputLayout textInputLayout = iVar.a.b;
        TextInputLayout textInputLayout2 = iVar.b.b;
        EditText editText3 = textInputLayout.getEditText();
        EditText editText4 = textInputLayout2.getEditText();
        editText3.setImeOptions(268435461);
        editText4.setImeOptions(268435462);
        editText3.setOnEditorActionListener(iVar);
        editText3.setOnKeyListener(iVar);
        editText4.setOnKeyListener(iVar);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.d
    public void a(int i2) {
        this.b.f = i2;
        boolean z = true;
        this.e.setChecked(i2 == 12);
        ChipTextInputComboView chipTextInputComboView = this.f;
        if (i2 != 10) {
            z = false;
        }
        chipTextInputComboView.setChecked(z);
        c();
    }

    public final void b(f fVar) {
        this.h.removeTextChangedListener(this.d);
        this.i.removeTextChangedListener(this.c);
        Locale locale = this.a.getResources().getConfiguration().locale;
        String format = String.format(locale, "%02d", Integer.valueOf(fVar.e));
        String format2 = String.format(locale, "%02d", Integer.valueOf(fVar.b()));
        this.e.b(format);
        this.f.b(format2);
        this.h.addTextChangedListener(this.d);
        this.i.addTextChangedListener(this.c);
        c();
    }

    public final void c() {
        MaterialButtonToggleGroup materialButtonToggleGroup = this.j;
        if (materialButtonToggleGroup != null) {
            materialButtonToggleGroup.check(this.b.g == 0 ? R.id.material_clock_period_am_button : R.id.material_clock_period_pm_button);
        }
    }

    @Override // a2.j.b.d.t.h
    public void hide() {
        View focusedChild = this.a.getFocusedChild();
        if (focusedChild == null) {
            this.a.setVisibility(8);
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) ContextCompat.getSystemService(this.a.getContext(), InputMethodManager.class);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(focusedChild.getWindowToken(), 0);
        }
        this.a.setVisibility(8);
    }

    @Override // a2.j.b.d.t.h
    public void invalidate() {
        b(this.b);
    }

    @Override // a2.j.b.d.t.h
    public void show() {
        this.a.setVisibility(0);
    }
}
