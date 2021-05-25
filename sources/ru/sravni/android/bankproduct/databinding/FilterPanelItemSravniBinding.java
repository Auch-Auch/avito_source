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
import ru.sravni.android.bankproduct.utils.filter.adapter.ISelectFilter;
import ru.sravni.android.bankproduct.utils.filter.entity.FilterItem;
public abstract class FilterPanelItemSravniBinding extends ViewDataBinding {
    @Bindable
    public FilterItem mFilterItem;
    @Bindable
    public ISelectFilter mFilterSelector;

    public FilterPanelItemSravniBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static FilterPanelItemSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FilterPanelItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public FilterItem getFilterItem() {
        return this.mFilterItem;
    }

    @Nullable
    public ISelectFilter getFilterSelector() {
        return this.mFilterSelector;
    }

    public abstract void setFilterItem(@Nullable FilterItem filterItem);

    public abstract void setFilterSelector(@Nullable ISelectFilter iSelectFilter);

    @Deprecated
    public static FilterPanelItemSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FilterPanelItemSravniBinding) ViewDataBinding.bind(obj, view, R.layout.filter_panel_item_sravni);
    }

    @NonNull
    @Deprecated
    public static FilterPanelItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FilterPanelItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.filter_panel_item_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static FilterPanelItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FilterPanelItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FilterPanelItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.filter_panel_item_sravni, null, false, obj);
    }
}
