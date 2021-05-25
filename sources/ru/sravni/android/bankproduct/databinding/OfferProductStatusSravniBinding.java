package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.domain.offer.product.entity.ProductStatusEnum;
public abstract class OfferProductStatusSravniBinding extends ViewDataBinding {
    @NonNull
    public final AppCompatImageView ivIcon;
    @Bindable
    public ProductStatusEnum mStatusEnum;
    @Bindable
    public String mStatusText;
    @NonNull
    public final TextView tvText;

    public OfferProductStatusSravniBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, TextView textView) {
        super(obj, view, i);
        this.ivIcon = appCompatImageView;
        this.tvText = textView;
    }

    public static OfferProductStatusSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static OfferProductStatusSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public ProductStatusEnum getStatusEnum() {
        return this.mStatusEnum;
    }

    @Nullable
    public String getStatusText() {
        return this.mStatusText;
    }

    public abstract void setStatusEnum(@Nullable ProductStatusEnum productStatusEnum);

    public abstract void setStatusText(@Nullable String str);

    @Deprecated
    public static OfferProductStatusSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (OfferProductStatusSravniBinding) ViewDataBinding.bind(obj, view, R.layout.offer_product_status_sravni);
    }

    @NonNull
    @Deprecated
    public static OfferProductStatusSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (OfferProductStatusSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_product_status_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static OfferProductStatusSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static OfferProductStatusSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (OfferProductStatusSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_product_status_sravni, null, false, obj);
    }
}
