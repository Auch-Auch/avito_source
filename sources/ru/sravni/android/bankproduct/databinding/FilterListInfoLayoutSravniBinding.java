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
import androidx.recyclerview.widget.RecyclerView;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterListInfoViewModel;
public abstract class FilterListInfoLayoutSravniBinding extends ViewDataBinding {
    @Bindable
    public IFilterListInfoViewModel mListInfoViewModel;
    @NonNull
    public final RecyclerView rvDrivers;
    @NonNull
    public final TextView tvBarrelDayTitle;

    public FilterListInfoLayoutSravniBinding(Object obj, View view, int i, RecyclerView recyclerView, TextView textView) {
        super(obj, view, i);
        this.rvDrivers = recyclerView;
        this.tvBarrelDayTitle = textView;
    }

    public static FilterListInfoLayoutSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FilterListInfoLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public IFilterListInfoViewModel getListInfoViewModel() {
        return this.mListInfoViewModel;
    }

    public abstract void setListInfoViewModel(@Nullable IFilterListInfoViewModel iFilterListInfoViewModel);

    @Deprecated
    public static FilterListInfoLayoutSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FilterListInfoLayoutSravniBinding) ViewDataBinding.bind(obj, view, R.layout.filter_list_info_layout_sravni);
    }

    @NonNull
    @Deprecated
    public static FilterListInfoLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FilterListInfoLayoutSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.filter_list_info_layout_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static FilterListInfoLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FilterListInfoLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FilterListInfoLayoutSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.filter_list_info_layout_sravni, null, false, obj);
    }
}
