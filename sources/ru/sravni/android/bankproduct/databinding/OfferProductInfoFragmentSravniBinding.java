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
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.presentation.offer.IOfferRetryErrorViewModel;
import ru.sravni.android.bankproduct.presentation.offer.product.IProductActionGetter;
import ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.IClickOfferProduct;
import ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.IOfferProductInfoControllerForLayout;
public abstract class OfferProductInfoFragmentSravniBinding extends ViewDataBinding {
    @NonNull
    public final AppBarLayout appBarLayout;
    @Bindable
    public IClickOfferProduct mClickOfferProduct;
    @Bindable
    public IOfferProductInfoControllerForLayout mOfferProductInfoViewModel;
    @Bindable
    public IOfferRetryErrorViewModel mOfferRetryErrorViewModel;
    @Bindable
    public IProductActionGetter mProductAction;
    @NonNull
    public final FrameLayout mbSendOffer;
    @NonNull
    public final RecyclerView rvInfo;
    @NonNull
    public final MaterialToolbar toolbar;
    @NonNull
    public final View vShadow;

    public OfferProductInfoFragmentSravniBinding(Object obj, View view, int i, AppBarLayout appBarLayout2, FrameLayout frameLayout, RecyclerView recyclerView, MaterialToolbar materialToolbar, View view2) {
        super(obj, view, i);
        this.appBarLayout = appBarLayout2;
        this.mbSendOffer = frameLayout;
        this.rvInfo = recyclerView;
        this.toolbar = materialToolbar;
        this.vShadow = view2;
    }

    public static OfferProductInfoFragmentSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static OfferProductInfoFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public IClickOfferProduct getClickOfferProduct() {
        return this.mClickOfferProduct;
    }

    @Nullable
    public IOfferProductInfoControllerForLayout getOfferProductInfoViewModel() {
        return this.mOfferProductInfoViewModel;
    }

    @Nullable
    public IOfferRetryErrorViewModel getOfferRetryErrorViewModel() {
        return this.mOfferRetryErrorViewModel;
    }

    @Nullable
    public IProductActionGetter getProductAction() {
        return this.mProductAction;
    }

    public abstract void setClickOfferProduct(@Nullable IClickOfferProduct iClickOfferProduct);

    public abstract void setOfferProductInfoViewModel(@Nullable IOfferProductInfoControllerForLayout iOfferProductInfoControllerForLayout);

    public abstract void setOfferRetryErrorViewModel(@Nullable IOfferRetryErrorViewModel iOfferRetryErrorViewModel);

    public abstract void setProductAction(@Nullable IProductActionGetter iProductActionGetter);

    @Deprecated
    public static OfferProductInfoFragmentSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (OfferProductInfoFragmentSravniBinding) ViewDataBinding.bind(obj, view, R.layout.offer_product_info_fragment_sravni);
    }

    @NonNull
    @Deprecated
    public static OfferProductInfoFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (OfferProductInfoFragmentSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_product_info_fragment_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static OfferProductInfoFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static OfferProductInfoFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (OfferProductInfoFragmentSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_product_info_fragment_sravni, null, false, obj);
    }
}
