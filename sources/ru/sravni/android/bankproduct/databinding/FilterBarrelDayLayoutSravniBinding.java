package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterBarrelDayViewModel;
public abstract class FilterBarrelDayLayoutSravniBinding extends ViewDataBinding {
    @Bindable
    public IFilterBarrelDayViewModel mBarrelDayViewModel;
    @NonNull
    public final TextView tvBarrelDayTitle;

    public FilterBarrelDayLayoutSravniBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.tvBarrelDayTitle = textView;
    }

    public static FilterBarrelDayLayoutSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FilterBarrelDayLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public IFilterBarrelDayViewModel getBarrelDayViewModel() {
        return this.mBarrelDayViewModel;
    }

    public abstract void setBarrelDayViewModel(@Nullable IFilterBarrelDayViewModel iFilterBarrelDayViewModel);

    @Deprecated
    public static FilterBarrelDayLayoutSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FilterBarrelDayLayoutSravniBinding) ViewDataBinding.bind(obj, view, R.layout.filter_barrel_day_layout_sravni);
    }

    @NonNull
    @Deprecated
    public static FilterBarrelDayLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FilterBarrelDayLayoutSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.filter_barrel_day_layout_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static FilterBarrelDayLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FilterBarrelDayLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FilterBarrelDayLayoutSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.filter_barrel_day_layout_sravni, null, false, obj);
    }
}
