package com.google.android.material.datepicker;

import a2.j.b.d.j.q;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import java.util.Iterator;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class MaterialTextInputPicker<S> extends q<S> {
    @StyleRes
    public int a;
    @Nullable
    public DateSelector<S> b;
    @Nullable
    public CalendarConstraints c;

    public class a extends OnSelectionChangedListener<S> {
        public a() {
        }

        @Override // com.google.android.material.datepicker.OnSelectionChangedListener
        public void onIncompleteSelectionChanged() {
            Iterator<OnSelectionChangedListener<S>> it = MaterialTextInputPicker.this.onSelectionChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().onIncompleteSelectionChanged();
            }
        }

        @Override // com.google.android.material.datepicker.OnSelectionChangedListener
        public void onSelectionChanged(S s) {
            Iterator<OnSelectionChangedListener<S>> it = MaterialTextInputPicker.this.onSelectionChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().onSelectionChanged(s);
            }
        }
    }

    @NonNull
    public DateSelector<S> getDateSelector() {
        DateSelector<S> dateSelector = this.b;
        if (dateSelector != null) {
            return dateSelector;
        }
        throw new IllegalStateException("dateSelector should not be null. Use MaterialTextInputPicker#newInstance() to create this fragment with a DateSelector, and call this method after the fragment has been created.");
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.a = bundle.getInt("THEME_RES_ID_KEY");
        this.b = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.c = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return this.b.onCreateTextInputView(layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), this.a)), viewGroup, bundle, this.c, new a());
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.a);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.b);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.c);
    }
}
