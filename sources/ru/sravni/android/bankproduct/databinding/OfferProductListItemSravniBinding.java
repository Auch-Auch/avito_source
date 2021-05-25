package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.button.MaterialButton;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailDomain;
import ru.sravni.android.bankproduct.presentation.offer.product.entity.OfferProductActionInfo;
import ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.ISelectOfferProduct;
import ru.sravni.android.bankproduct.utils.components.recyclerview.UntouchableRecyclerView;
import ru.sravni.android.bankproduct.utils.svg.entity.LogoInfo;
public abstract class OfferProductListItemSravniBinding extends ViewDataBinding {
    @NonNull
    public final FrameLayout flStatus;
    @Bindable
    public LogoInfo mLogoInfo;
    @Bindable
    public OfferProductDetailDomain mOffer;
    @Bindable
    public OfferProductActionInfo mOfferProductStatusInfo;
    @Bindable
    public ISelectOfferProduct mSelectOfferProduct;
    @NonNull
    public final MaterialButton mbSendOffer;
    @NonNull
    public final UntouchableRecyclerView rvInfo;
    @NonNull
    public final View statusLine;
    @NonNull
    public final OfferProductTitleSravniBinding title;
    @NonNull
    public final View vOptional;

    public OfferProductListItemSravniBinding(Object obj, View view, int i, FrameLayout frameLayout, MaterialButton materialButton, UntouchableRecyclerView untouchableRecyclerView, View view2, OfferProductTitleSravniBinding offerProductTitleSravniBinding, View view3) {
        super(obj, view, i);
        this.flStatus = frameLayout;
        this.mbSendOffer = materialButton;
        this.rvInfo = untouchableRecyclerView;
        this.statusLine = view2;
        this.title = offerProductTitleSravniBinding;
        setContainedBinding(offerProductTitleSravniBinding);
        this.vOptional = view3;
    }

    public static OfferProductListItemSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static OfferProductListItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public LogoInfo getLogoInfo() {
        return this.mLogoInfo;
    }

    @Nullable
    public OfferProductDetailDomain getOffer() {
        return this.mOffer;
    }

    @Nullable
    public OfferProductActionInfo getOfferProductStatusInfo() {
        return this.mOfferProductStatusInfo;
    }

    @Nullable
    public ISelectOfferProduct getSelectOfferProduct() {
        return this.mSelectOfferProduct;
    }

    public abstract void setLogoInfo(@Nullable LogoInfo logoInfo);

    public abstract void setOffer(@Nullable OfferProductDetailDomain offerProductDetailDomain);

    public abstract void setOfferProductStatusInfo(@Nullable OfferProductActionInfo offerProductActionInfo);

    public abstract void setSelectOfferProduct(@Nullable ISelectOfferProduct iSelectOfferProduct);

    @Deprecated
    public static OfferProductListItemSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (OfferProductListItemSravniBinding) ViewDataBinding.bind(obj, view, R.layout.offer_product_list_item_sravni);
    }

    @NonNull
    @Deprecated
    public static OfferProductListItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (OfferProductListItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_product_list_item_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static OfferProductListItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static OfferProductListItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (OfferProductListItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_product_list_item_sravni, null, false, obj);
    }
}
