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
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSliderViewModel;
public abstract class FilterSliderLayoutSravniBinding extends ViewDataBinding {
    @Bindable
    public IFilterSliderViewModel mSliderViewModel;
    @NonNull
    public final TextInputEditText tietAmount;
    @NonNull
    public final TextInputLayout tilAmount;
    @NonNull
    public final TextView tvAmountTitle;
    @NonNull
    public final TextView tvMaxAmountTitle;
    @NonNull
    public final TextView tvMinAmountTitle;

    public FilterSliderLayoutSravniBinding(Object obj, View view, int i, TextInputEditText textInputEditText, TextInputLayout textInputLayout, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.tietAmount = textInputEditText;
        this.tilAmount = textInputLayout;
        this.tvAmountTitle = textView;
        this.tvMaxAmountTitle = textView2;
        this.tvMinAmountTitle = textView3;
    }

    public static FilterSliderLayoutSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FilterSliderLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public IFilterSliderViewModel getSliderViewModel() {
        return this.mSliderViewModel;
    }

    public abstract void setSliderViewModel(@Nullable IFilterSliderViewModel iFilterSliderViewModel);

    @Deprecated
    public static FilterSliderLayoutSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FilterSliderLayoutSravniBinding) ViewDataBinding.bind(obj, view, R.layout.filter_slider_layout_sravni);
    }

    @NonNull
    @Deprecated
    public static FilterSliderLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FilterSliderLayoutSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.filter_slider_layout_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static FilterSliderLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FilterSliderLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FilterSliderLayoutSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.filter_slider_layout_sravni, null, false, obj);
    }
}
