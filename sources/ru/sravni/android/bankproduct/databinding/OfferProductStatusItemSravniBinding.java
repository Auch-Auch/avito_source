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
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductStatusDomain;
public abstract class OfferProductStatusItemSravniBinding extends ViewDataBinding {
    @NonNull
    public final AppCompatImageView ivIcon;
    @Bindable
    public OfferProductStatusDomain.OfferStatusElementDomain mStatusInfo;
    @NonNull
    public final TextView tvText;

    public OfferProductStatusItemSravniBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, TextView textView) {
        super(obj, view, i);
        this.ivIcon = appCompatImageView;
        this.tvText = textView;
    }

    public static OfferProductStatusItemSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static OfferProductStatusItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public OfferProductStatusDomain.OfferStatusElementDomain getStatusInfo() {
        return this.mStatusInfo;
    }

    public abstract void setStatusInfo(@Nullable OfferProductStatusDomain.OfferStatusElementDomain offerStatusElementDomain);

    @Deprecated
    public static OfferProductStatusItemSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (OfferProductStatusItemSravniBinding) ViewDataBinding.bind(obj, view, R.layout.offer_product_status_item_sravni);
    }

    @NonNull
    @Deprecated
    public static OfferProductStatusItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (OfferProductStatusItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_product_status_item_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static OfferProductStatusItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static OfferProductStatusItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (OfferProductStatusItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_product_status_item_sravni, null, false, obj);
    }
}
