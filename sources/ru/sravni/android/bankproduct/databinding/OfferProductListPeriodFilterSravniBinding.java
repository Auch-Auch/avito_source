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
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSnapPointViewModel;
public abstract class OfferProductListPeriodFilterSravniBinding extends ViewDataBinding {
    @Bindable
    public IFilterSnapPointViewModel mSnapPointViewModel;
    @NonNull
    public final TextView tvDriversTitle;

    public OfferProductListPeriodFilterSravniBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.tvDriversTitle = textView;
    }

    public static OfferProductListPeriodFilterSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static OfferProductListPeriodFilterSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public IFilterSnapPointViewModel getSnapPointViewModel() {
        return this.mSnapPointViewModel;
    }

    public abstract void setSnapPointViewModel(@Nullable IFilterSnapPointViewModel iFilterSnapPointViewModel);

    @Deprecated
    public static OfferProductListPeriodFilterSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (OfferProductListPeriodFilterSravniBinding) ViewDataBinding.bind(obj, view, R.layout.offer_product_list_period_filter_sravni);
    }

    @NonNull
    @Deprecated
    public static OfferProductListPeriodFilterSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (OfferProductListPeriodFilterSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_product_list_period_filter_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static OfferProductListPeriodFilterSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static OfferProductListPeriodFilterSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (OfferProductListPeriodFilterSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_product_list_period_filter_sravni, null, false, obj);
    }
}
