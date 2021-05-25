package androidx.preference;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
@Deprecated
public class MultiSelectListPreferenceDialogFragment extends PreferenceDialogFragment {
    public Set<String> i = new HashSet();
    public boolean j;
    public CharSequence[] k;
    public CharSequence[] l;

    public class a implements DialogInterface.OnMultiChoiceClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnMultiChoiceClickListener
        public void onClick(DialogInterface dialogInterface, int i, boolean z) {
            if (z) {
                MultiSelectListPreferenceDialogFragment multiSelectListPreferenceDialogFragment = MultiSelectListPreferenceDialogFragment.this;
                multiSelectListPreferenceDialogFragment.j = multiSelectListPreferenceDialogFragment.i.add(multiSelectListPreferenceDialogFragment.l[i].toString()) | multiSelectListPreferenceDialogFragment.j;
                return;
            }
            MultiSelectListPreferenceDialogFragment multiSelectListPreferenceDialogFragment2 = MultiSelectListPreferenceDialogFragment.this;
            multiSelectListPreferenceDialogFragment2.j = multiSelectListPreferenceDialogFragment2.i.remove(multiSelectListPreferenceDialogFragment2.l[i].toString()) | multiSelectListPreferenceDialogFragment2.j;
        }
    }

    @Deprecated
    public static MultiSelectListPreferenceDialogFragment newInstance(String str) {
        MultiSelectListPreferenceDialogFragment multiSelectListPreferenceDialogFragment = new MultiSelectListPreferenceDialogFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        multiSelectListPreferenceDialogFragment.setArguments(bundle);
        return multiSelectListPreferenceDialogFragment;
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            MultiSelectListPreference multiSelectListPreference = (MultiSelectListPreference) getPreference();
            if (multiSelectListPreference.getEntries() == null || multiSelectListPreference.getEntryValues() == null) {
                throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
            }
            this.i.clear();
            this.i.addAll(multiSelectListPreference.getValues());
            this.j = false;
            this.k = multiSelectListPreference.getEntries();
            this.l = multiSelectListPreference.getEntryValues();
            return;
        }
        this.i.clear();
        this.i.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragment.values"));
        this.j = bundle.getBoolean("MultiSelectListPreferenceDialogFragment.changed", false);
        this.k = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragment.entries");
        this.l = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragment.entryValues");
    }

    @Override // androidx.preference.PreferenceDialogFragment
    @Deprecated
    public void onDialogClosed(boolean z) {
        MultiSelectListPreference multiSelectListPreference = (MultiSelectListPreference) getPreference();
        if (z && this.j) {
            Set<String> set = this.i;
            if (multiSelectListPreference.callChangeListener(set)) {
                multiSelectListPreference.setValues(set);
            }
        }
        this.j = false;
    }

    @Override // androidx.preference.PreferenceDialogFragment
    public void onPrepareDialogBuilder(AlertDialog.Builder builder) {
        super.onPrepareDialogBuilder(builder);
        int length = this.l.length;
        boolean[] zArr = new boolean[length];
        for (int i2 = 0; i2 < length; i2++) {
            zArr[i2] = this.i.contains(this.l[i2].toString());
        }
        builder.setMultiChoiceItems(this.k, zArr, new a());
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragment.values", new ArrayList<>(this.i));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragment.changed", this.j);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragment.entries", this.k);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragment.entryValues", this.l);
    }
}
