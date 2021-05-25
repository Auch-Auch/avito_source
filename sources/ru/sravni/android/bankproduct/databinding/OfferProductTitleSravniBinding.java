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
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductDisplaySettingsDomain;
import ru.sravni.android.bankproduct.utils.svg.entity.LogoInfo;
public abstract class OfferProductTitleSravniBinding extends ViewDataBinding {
    @NonNull
    public final FrameLayout flCreditCardIcon;
    @NonNull
    public final FrameLayout flCreditIcon;
    @NonNull
    public final FrameLayout flIcon;
    @NonNull
    public final ImageView imgCreditCardIcon;
    @NonNull
    public final ImageView imgCreditCardType;
    @NonNull
    public final ImageView imgCreditIcon;
    @NonNull
    public final ImageView imgCreditSvgIcon;
    @Bindable
    public LogoInfo mLogoInfo;
    @Bindable
    public OfferProductDisplaySettingsDomain mOfferTitleInfo;
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
    public final View vLine;
    @NonNull
    public final View vOptional;

    public OfferProductTitleSravniBinding(Object obj, View view, int i, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view2, View view3) {
        super(obj, view, i);
        this.flCreditCardIcon = frameLayout;
        this.flCreditIcon = frameLayout2;
        this.flIcon = frameLayout3;
        this.imgCreditCardIcon = imageView;
        this.imgCreditCardType = imageView2;
        this.imgCreditIcon = imageView3;
        this.imgCreditSvgIcon = imageView4;
        this.tvCompany = textView;
        this.tvCreditCardIcon = textView2;
        this.tvCreditIcon = textView3;
        this.tvName = textView4;
        this.tvProductName = textView5;
        this.vLine = view2;
        this.vOptional = view3;
    }

    public static OfferProductTitleSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static OfferProductTitleSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public LogoInfo getLogoInfo() {
        return this.mLogoInfo;
    }

    @Nullable
    public OfferProductDisplaySettingsDomain getOfferTitleInfo() {
        return this.mOfferTitleInfo;
    }

    public abstract void setLogoInfo(@Nullable LogoInfo logoInfo);

    public abstract void setOfferTitleInfo(@Nullable OfferProductDisplaySettingsDomain offerProductDisplaySettingsDomain);

    @Deprecated
    public static OfferProductTitleSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (OfferProductTitleSravniBinding) ViewDataBinding.bind(obj, view, R.layout.offer_product_title_sravni);
    }

    @NonNull
    @Deprecated
    public static OfferProductTitleSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (OfferProductTitleSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_product_title_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static OfferProductTitleSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static OfferProductTitleSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (OfferProductTitleSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_product_title_sravni, null, false, obj);
    }
}
