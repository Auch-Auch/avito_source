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
import com.google.android.material.switchmaterial.SwitchMaterial;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.utils.filter.entity.FilterSwitcherInfo;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSwitcherListViewModel;
public abstract class FilterSwitcherListItemSravniBinding extends ViewDataBinding {
    @Bindable
    public IFilterSwitcherListViewModel mSwitcherChanged;
    @Bindable
    public FilterSwitcherInfo mSwitcherInfo;
    @NonNull
    public final SwitchMaterial swActive;
    @NonNull
    public final TextView tvName;

    public FilterSwitcherListItemSravniBinding(Object obj, View view, int i, SwitchMaterial switchMaterial, TextView textView) {
        super(obj, view, i);
        this.swActive = switchMaterial;
        this.tvName = textView;
    }

    public static FilterSwitcherListItemSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FilterSwitcherListItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public IFilterSwitcherListViewModel getSwitcherChanged() {
        return this.mSwitcherChanged;
    }

    @Nullable
    public FilterSwitcherInfo getSwitcherInfo() {
        return this.mSwitcherInfo;
    }

    public abstract void setSwitcherChanged(@Nullable IFilterSwitcherListViewModel iFilterSwitcherListViewModel);

    public abstract void setSwitcherInfo(@Nullable FilterSwitcherInfo filterSwitcherInfo);

    @Deprecated
    public static FilterSwitcherListItemSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FilterSwitcherListItemSravniBinding) ViewDataBinding.bind(obj, view, R.layout.filter_switcher_list_item_sravni);
    }

    @NonNull
    @Deprecated
    public static FilterSwitcherListItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FilterSwitcherListItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.filter_switcher_list_item_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static FilterSwitcherListItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FilterSwitcherListItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FilterSwitcherListItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.filter_switcher_list_item_sravni, null, false, obj);
    }
}
