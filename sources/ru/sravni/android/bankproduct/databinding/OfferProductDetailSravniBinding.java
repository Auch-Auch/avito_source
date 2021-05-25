package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.presentation.offer.product.IProductActionGetter;
import ru.sravni.android.bankproduct.presentation.offer.product.entity.OfferProductActionInfo;
public abstract class OfferProductDetailSravniBinding extends ViewDataBinding {
    @NonNull
    public final ImageView imgGoUrl;
    @Bindable
    public OfferProductActionInfo mOfferProductStatusInfo;
    @Bindable
    public IProductActionGetter mProductActionGetter;
    @NonNull
    public final TextView tvDescription;
    @NonNull
    public final TextView tvText;
    @NonNull
    public final TextView tvUrl;

    public OfferProductDetailSravniBinding(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.imgGoUrl = imageView;
        this.tvDescription = textView;
        this.tvText = textView2;
        this.tvUrl = textView3;
    }

    public static OfferProductDetailSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static OfferProductDetailSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public OfferProductActionInfo getOfferProductStatusInfo() {
        return this.mOfferProductStatusInfo;
    }

    @Nullable
    public IProductActionGetter getProductActionGetter() {
        return this.mProductActionGetter;
    }

    public abstract void setOfferProductStatusInfo(@Nullable OfferProductActionInfo offerProductActionInfo);

    public abstract void setProductActionGetter(@Nullable IProductActionGetter iProductActionGetter);

    @Deprecated
    public static OfferProductDetailSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (OfferProductDetailSravniBinding) ViewDataBinding.bind(obj, view, R.layout.offer_product_detail_sravni);
    }

    @NonNull
    @Deprecated
    public static OfferProductDetailSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (OfferProductDetailSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_product_detail_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static OfferProductDetailSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static OfferProductDetailSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (OfferProductDetailSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_product_detail_sravni, null, false, obj);
    }
}
