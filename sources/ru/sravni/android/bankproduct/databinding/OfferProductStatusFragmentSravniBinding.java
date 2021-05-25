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
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.presentation.offer.product.status.viewmodel.IOfferProductStatusViewModel;
public abstract class OfferProductStatusFragmentSravniBinding extends ViewDataBinding {
    @NonNull
    public final AppBarLayout appBarLayout;
    @NonNull
    public final FrameLayout flButtonPanel;
    @Bindable
    public IOfferProductStatusViewModel mViewModel;
    @NonNull
    public final MaterialToolbar toolbar;
    @NonNull
    public final View vShadow;

    public OfferProductStatusFragmentSravniBinding(Object obj, View view, int i, AppBarLayout appBarLayout2, FrameLayout frameLayout, MaterialToolbar materialToolbar, View view2) {
        super(obj, view, i);
        this.appBarLayout = appBarLayout2;
        this.flButtonPanel = frameLayout;
        this.toolbar = materialToolbar;
        this.vShadow = view2;
    }

    public static OfferProductStatusFragmentSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static OfferProductStatusFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public IOfferProductStatusViewModel getViewModel() {
        return this.mViewModel;
    }

    public abstract void setViewModel(@Nullable IOfferProductStatusViewModel iOfferProductStatusViewModel);

    @Deprecated
    public static OfferProductStatusFragmentSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (OfferProductStatusFragmentSravniBinding) ViewDataBinding.bind(obj, view, R.layout.offer_product_status_fragment_sravni);
    }

    @NonNull
    @Deprecated
    public static OfferProductStatusFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (OfferProductStatusFragmentSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_product_status_fragment_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static OfferProductStatusFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static OfferProductStatusFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (OfferProductStatusFragmentSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_product_status_fragment_sravni, null, false, obj);
    }
}
