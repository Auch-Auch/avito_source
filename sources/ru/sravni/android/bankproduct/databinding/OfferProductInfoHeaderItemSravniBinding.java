package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailInfoDomain;
import ru.sravni.android.bankproduct.utils.svg.entity.LogoInfo;
public abstract class OfferProductInfoHeaderItemSravniBinding extends ViewDataBinding {
    @NonNull
    public final FrameLayout flCreditCardIcon;
    @NonNull
    public final FrameLayout flCreditIcon;
    @NonNull
    public final FrameLayout flIcon;
    @NonNull
    public final FrameLayout flStatus;
    @NonNull
    public final ImageView imgCreditCardIcon;
    @NonNull
    public final ImageView imgCreditCardType;
    @NonNull
    public final ImageView imgCreditIcon;
    @NonNull
    public final ImageView imgCreditSvgIcon;
    @Bindable
    public OfferProductDetailInfoDomain mDetailInfo;
    @Bindable
    public LogoInfo mLogoInfo;
    @NonNull
    public final TextView tvCompany;
    @NonNull
    public final TextView tvCreditCardIcon;
    @NonNull
    public final TextView tvCreditIcon;
    @NonNull
    public final TextView tvName;
    @NonNull
    public final TextView tvProductName;
    @NonNull
    public final View vOptional;

    public OfferProductInfoHeaderItemSravniBinding(Object obj, View view, int i, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view2) {
        super(obj, view, i);
        this.flCreditCardIcon = frameLayout;
        this.flCreditIcon = frameLayout2;
        this.flIcon = frameLayout3;
        this.flStatus = frameLayout4;
        this.imgCreditCardIcon = imageView;
        this.imgCreditCardType = imageView2;
        this.imgCreditIcon = imageView3;
        this.imgCreditSvgIcon = imageView4;
        this.tvCompany = textView;
        this.tvCreditCardIcon = textView2;
        this.tvCreditIcon = textView3;
        this.tvName = textView4;
        this.tvProductName = textView5;
        this.vOptional = view2;
    }

    public static OfferProductInfoHeaderItemSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static OfferProductInfoHeaderItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public OfferProductDetailInfoDomain getDetailInfo() {
        return this.mDetailInfo;
    }

    @Nullable
    public LogoInfo getLogoInfo() {
        return this.mLogoInfo;
    }

    public abstract void setDetailInfo(@Nullable OfferProductDetailInfoDomain offerProductDetailInfoDomain);

    public abstract void setLogoInfo(@Nullable LogoInfo logoInfo);

    @Deprecated
    public static OfferProductInfoHeaderItemSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (OfferProductInfoHeaderItemSravniBinding) ViewDataBinding.bind(obj, view, R.layout.offer_product_info_header_item_sravni);
    }

    @NonNull
    @Deprecated
    public static OfferProductInfoHeaderItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (OfferProductInfoHeaderItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_product_info_header_item_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static OfferProductInfoHeaderItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static OfferProductInfoHeaderItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (OfferProductInfoHeaderItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_product_info_header_item_sravni, null, false, obj);
    }
}
