package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.Preference;
public class ListPreference extends DialogPreference {
    public CharSequence[] X;
    public CharSequence[] Y;
    public String Z;
    public String a0;
    public boolean b0;

    public static final class SimpleSummaryProvider implements Preference.SummaryProvider<ListPreference> {
        public static SimpleSummaryProvider a;

        public static SimpleSummaryProvider getInstance() {
            if (a == null) {
                a = new SimpleSummaryProvider();
            }
            return a;
        }

        public CharSequence provideSummary(ListPreference listPreference) {
            if (TextUtils.isEmpty(listPreference.getEntry())) {
                return listPreference.getContext().getString(R.string.not_set);
            }
            return listPreference.getEntry();
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListPreference, i, i2);
        this.X = TypedArrayUtils.getTextArray(obtainStyledAttributes, R.styleable.ListPreference_entries, R.styleable.ListPreference_android_entries);
        this.Y = TypedArrayUtils.getTextArray(obtainStyledAttributes, R.styleable.ListPreference_entryValues, R.styleable.ListPreference_android_entryValues);
        int i3 = R.styleable.ListPreference_useSimpleSummaryProvider;
        if (TypedArrayUtils.getBoolean(obtainStyledAttributes, i3, i3, false)) {
            setSummaryProvider(SimpleSummaryProvider.getInstance());
        }
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.Preference, i, i2);
        this.a0 = TypedArrayUtils.getString(obtainStyledAttributes2, R.styleable.Preference_summary, R.styleable.Preference_android_summary);
        obtainStyledAttributes2.recycle();
    }

    public int findIndexOfValue(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.Y) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (this.Y[length].equals(str)) {
                return length;
            }
        }
        return -1;
    }

    public CharSequence[] getEntries() {
        return this.X;
    }

    public CharSequence getEntry() {
        CharSequence[] charSequenceArr;
        int findIndexOfValue = findIndexOfValue(this.Z);
        if (findIndexOfValue < 0 || (charSequenceArr = this.X) == null) {
            return null;
        }
        return charSequenceArr[findIndexOfValue];
    }

    public CharSequence[] getEntryValues() {
        return this.Y;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0024: APUT  (r3v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r0v2 java.lang.CharSequence) */
    @Override // androidx.preference.Preference
    public CharSequence getSummary() {
        if (getSummaryProvider() != null) {
            return getSummaryProvider().provideSummary(this);
        }
        CharSequence entry = getEntry();
        CharSequence summary = super.getSummary();
        String str = this.a0;
        if (str == null) {
            return summary;
        }
        Object[] objArr = new Object[1];
        if (entry == null) {
            entry = "";
        }
        objArr[0] = entry;
        String format = String.format(str, objArr);
        return TextUtils.equals(format, summary) ? summary : format;
    }

    public String getValue() {
        return this.Z;
    }

    @Override // androidx.preference.Preference
    public Object onGetDefaultValue(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    @Override // androidx.preference.Preference
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(a.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.getSuperState());
        setValue(aVar.a);
    }

    @Override // androidx.preference.Preference
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return onSaveInstanceState;
        }
        a aVar = new a(onSaveInstanceState);
        aVar.a = getValue();
        return aVar;
    }

    @Override // androidx.preference.Preference
    public void onSetInitialValue(Object obj) {
        setValue(getPersistedString((String) obj));
    }

    public void setEntries(CharSequence[] charSequenceArr) {
        this.X = charSequenceArr;
    }

    public void setEntryValues(CharSequence[] charSequenceArr) {
        this.Y = charSequenceArr;
    }

    @Override // androidx.preference.Preference
    public void setSummary(CharSequence charSequence) {
        super.setSummary(charSequence);
        if (charSequence == null && this.a0 != null) {
            this.a0 = null;
        } else if (charSequence != null && !charSequence.equals(this.a0)) {
            this.a0 = charSequence.toString();
        }
    }

    public void setValue(String str) {
        boolean z = !TextUtils.equals(this.Z, str);
        if (z || !this.b0) {
            this.Z = str;
            this.b0 = true;
            persistString(str);
            if (z) {
                notifyChanged();
            }
        }
    }

    public void setValueIndex(int i) {
        CharSequence[] charSequenceArr = this.Y;
        if (charSequenceArr != null) {
            setValue(charSequenceArr[i].toString());
        }
    }

    public static class a extends Preference.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new C0117a();
        public String a;

        /* renamed from: androidx.preference.ListPreference$a$a  reason: collision with other inner class name */
        public static class C0117a implements Parcelable.Creator<a> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public a[] newArray(int i) {
                return new a[i];
            }
        }

        public a(Parcel parcel) {
            super(parcel);
            this.a = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.a);
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public void setEntries(@ArrayRes int i) {
        setEntries(getContext().getResources().getTextArray(i));
    }

    public void setEntryValues(@ArrayRes int i) {
        setEntryValues(getContext().getResources().getTextArray(i));
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.getAttr(context, R.attr.dialogPreferenceStyle, 16842897));
    }

    public ListPreference(Context context) {
        this(context, null);
    }
}
