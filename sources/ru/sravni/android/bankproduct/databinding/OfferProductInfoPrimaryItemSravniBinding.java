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
import ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailItemDomain;
public abstract class OfferProductInfoPrimaryItemSravniBinding extends ViewDataBinding {
    @Bindable
    public OfferProductDetailItemDomain.ItemParam mMainParam;
    @NonNull
    public final TextView tvName;
    @NonNull
    public final TextView tvValue;

    public OfferProductInfoPrimaryItemSravniBinding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.tvName = textView;
        this.tvValue = textView2;
    }

    public static OfferProductInfoPrimaryItemSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static OfferProductInfoPrimaryItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public OfferProductDetailItemDomain.ItemParam getMainParam() {
        return this.mMainParam;
    }

    public abstract void setMainParam(@Nullable OfferProductDetailItemDomain.ItemParam itemParam);

    @Deprecated
    public static OfferProductInfoPrimaryItemSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (OfferProductInfoPrimaryItemSravniBinding) ViewDataBinding.bind(obj, view, R.layout.offer_product_info_primary_item_sravni);
    }

    @NonNull
    @Deprecated
    public static OfferProductInfoPrimaryItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (OfferProductInfoPrimaryItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_product_info_primary_item_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static OfferProductInfoPrimaryItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static OfferProductInfoPrimaryItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (OfferProductInfoPrimaryItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_product_info_primary_item_sravni, null, false, obj);
    }
}
