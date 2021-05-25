package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.annotation.NonNull;
public class DropDownPreference extends ListPreference {
    public final Context c0;
    public final ArrayAdapter d0;
    public Spinner e0;
    public final AdapterView.OnItemSelectedListener f0;

    public class a implements AdapterView.OnItemSelectedListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (i >= 0) {
                String charSequence = DropDownPreference.this.getEntryValues()[i].toString();
                if (!charSequence.equals(DropDownPreference.this.getValue()) && DropDownPreference.this.callChangeListener(charSequence)) {
                    DropDownPreference.this.setValue(charSequence);
                }
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public DropDownPreference(Context context) {
        this(context, null);
    }

    public ArrayAdapter createAdapter() {
        return new ArrayAdapter(this.c0, 17367049);
    }

    public final void e() {
        this.d0.clear();
        if (getEntries() != null) {
            for (CharSequence charSequence : getEntries()) {
                this.d0.add(charSequence.toString());
            }
        }
    }

    @Override // androidx.preference.Preference
    public void notifyChanged() {
        super.notifyChanged();
        ArrayAdapter arrayAdapter = this.d0;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        Spinner spinner = (Spinner) preferenceViewHolder.itemView.findViewById(R.id.spinner);
        this.e0 = spinner;
        spinner.setAdapter((SpinnerAdapter) this.d0);
        this.e0.setOnItemSelectedListener(this.f0);
        Spinner spinner2 = this.e0;
        String value = getValue();
        CharSequence[] entryValues = getEntryValues();
        int i = -1;
        if (value != null && entryValues != null) {
            int length = entryValues.length - 1;
            while (true) {
                if (length < 0) {
                    break;
                } else if (entryValues[length].equals(value)) {
                    i = length;
                    break;
                } else {
                    length--;
                }
            }
        }
        spinner2.setSelection(i);
        super.onBindViewHolder(preferenceViewHolder);
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    public void onClick() {
        this.e0.performClick();
    }

    @Override // androidx.preference.ListPreference
    public void setEntries(@NonNull CharSequence[] charSequenceArr) {
        super.setEntries(charSequenceArr);
        e();
    }

    @Override // androidx.preference.ListPreference
    public void setValueIndex(int i) {
        setValue(getEntryValues()[i].toString());
    }

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.dropdownPreferenceStyle);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f0 = new a();
        this.c0 = context;
        this.d0 = createAdapter();
        e();
    }
}
