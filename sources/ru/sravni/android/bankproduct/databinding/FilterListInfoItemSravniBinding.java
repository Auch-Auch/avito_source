package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.utils.filter.entity.FilterInfo;
public abstract class FilterListInfoItemSravniBinding extends ViewDataBinding {
    @Bindable
    public FilterInfo mFilterInfo;

    public FilterListInfoItemSravniBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static FilterListInfoItemSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FilterListInfoItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public FilterInfo getFilterInfo() {
        return this.mFilterInfo;
    }

    public abstract void setFilterInfo(@Nullable FilterInfo filterInfo);

    @Deprecated
    public static FilterListInfoItemSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FilterListInfoItemSravniBinding) ViewDataBinding.bind(obj, view, R.layout.filter_list_info_item_sravni);
    }

    @NonNull
    @Deprecated
    public static FilterListInfoItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FilterListInfoItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.filter_list_info_item_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static FilterListInfoItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FilterListInfoItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FilterListInfoItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.filter_list_info_item_sravni, null, false, obj);
    }
}
