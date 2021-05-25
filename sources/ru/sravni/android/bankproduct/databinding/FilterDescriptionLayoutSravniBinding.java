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
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterDescriptionViewModel;
public abstract class FilterDescriptionLayoutSravniBinding extends ViewDataBinding {
    @Bindable
    public IFilterDescriptionViewModel mDescriptionViewModel;
    @NonNull
    public final TextView tvDescription;
    @NonNull
    public final TextView tvDescriptionTitle;

    public FilterDescriptionLayoutSravniBinding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.tvDescription = textView;
        this.tvDescriptionTitle = textView2;
    }

    public static FilterDescriptionLayoutSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FilterDescriptionLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public IFilterDescriptionViewModel getDescriptionViewModel() {
        return this.mDescriptionViewModel;
    }

    public abstract void setDescriptionViewModel(@Nullable IFilterDescriptionViewModel iFilterDescriptionViewModel);

    @Deprecated
    public static FilterDescriptionLayoutSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FilterDescriptionLayoutSravniBinding) ViewDataBinding.bind(obj, view, R.layout.filter_description_layout_sravni);
    }

    @NonNull
    @Deprecated
    public static FilterDescriptionLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FilterDescriptionLayoutSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.filter_description_layout_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static FilterDescriptionLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FilterDescriptionLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FilterDescriptionLayoutSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.filter_description_layout_sravni, null, false, obj);
    }
}
