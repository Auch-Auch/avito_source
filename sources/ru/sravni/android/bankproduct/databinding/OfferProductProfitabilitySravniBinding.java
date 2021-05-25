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
import antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator;
import ru.sravni.android.bankproduct.R;
public abstract class OfferProductProfitabilitySravniBinding extends ViewDataBinding {
    @NonNull
    public final CircularProgressIndicator cpProbability;
    @Bindable
    public Integer mProfitability;
    @Bindable
    public String mProfitabilityText;
    @NonNull
    public final TextView tvText;

    public OfferProductProfitabilitySravniBinding(Object obj, View view, int i, CircularProgressIndicator circularProgressIndicator, TextView textView) {
        super(obj, view, i);
        this.cpProbability = circularProgressIndicator;
        this.tvText = textView;
    }

    public static OfferProductProfitabilitySravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static OfferProductProfitabilitySravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public Integer getProfitability() {
        return this.mProfitability;
    }

    @Nullable
    public String getProfitabilityText() {
        return this.mProfitabilityText;
    }

    public abstract void setProfitability(@Nullable Integer num);

    public abstract void setProfitabilityText(@Nullable String str);

    @Deprecated
    public static OfferProductProfitabilitySravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (OfferProductProfitabilitySravniBinding) ViewDataBinding.bind(obj, view, R.layout.offer_product_profitability_sravni);
    }

    @NonNull
    @Deprecated
    public static OfferProductProfitabilitySravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (OfferProductProfitabilitySravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_product_profitability_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static OfferProductProfitabilitySravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static OfferProductProfitabilitySravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (OfferProductProfitabilitySravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_product_profitability_sravni, null, false, obj);
    }
}
