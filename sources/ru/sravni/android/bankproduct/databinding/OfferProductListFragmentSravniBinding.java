package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.IOfferProductListViewModel;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.ISlidingPanelButtonViewModel;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.ISlidingUpPanelViewModel;
public abstract class OfferProductListFragmentSravniBinding extends ViewDataBinding {
    @NonNull
    public final AppBarLayout appBarLayout;
    @NonNull
    public final FrameLayout flFilterPanel;
    @NonNull
    public final FrameLayout flPanelFadeLayout;
    @Bindable
    public IOfferProductListViewModel mOfferProductListViewModel;
    @Bindable
    public ISlidingPanelButtonViewModel mPanelButtonViewModel;
    @Bindable
    public ISlidingUpPanelViewModel mPanelViewModel;
    @Bindable
    public LifecycleOwner mSlideLifecycleOwner;
    @NonNull
    public final RecyclerView rvFilterPanel;
    @NonNull
    public final RecyclerView rvListCreditOffer;
    @NonNull
    public final SlidingUpPanelLayout slidingLayout;
    @NonNull
    public final MaterialToolbar toolbar;
    @NonNull
    public final TextView tvDescription;
    @NonNull
    public final TextView tvHeader;
    @NonNull
    public final View vToolbar;

    public OfferProductListFragmentSravniBinding(Object obj, View view, int i, AppBarLayout appBarLayout2, FrameLayout frameLayout, FrameLayout frameLayout2, RecyclerView recyclerView, RecyclerView recyclerView2, SlidingUpPanelLayout slidingUpPanelLayout, MaterialToolbar materialToolbar, TextView textView, TextView textView2, View view2) {
        super(obj, view, i);
        this.appBarLayout = appBarLayout2;
        this.flFilterPanel = frameLayout;
        this.flPanelFadeLayout = frameLayout2;
        this.rvFilterPanel = recyclerView;
        this.rvListCreditOffer = recyclerView2;
        this.slidingLayout = slidingUpPanelLayout;
        this.toolbar = materialToolbar;
        this.tvDescription = textView;
        this.tvHeader = textView2;
        this.vToolbar = view2;
    }

    public static OfferProductListFragmentSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static OfferProductListFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public IOfferProductListViewModel getOfferProductListViewModel() {
        return this.mOfferProductListViewModel;
    }

    @Nullable
    public ISlidingPanelButtonViewModel getPanelButtonViewModel() {
        return this.mPanelButtonViewModel;
    }

    @Nullable
    public ISlidingUpPanelViewModel getPanelViewModel() {
        return this.mPanelViewModel;
    }

    @Nullable
    public LifecycleOwner getSlideLifecycleOwner() {
        return this.mSlideLifecycleOwner;
    }

    public abstract void setOfferProductListViewModel(@Nullable IOfferProductListViewModel iOfferProductListViewModel);

    public abstract void setPanelButtonViewModel(@Nullable ISlidingPanelButtonViewModel iSlidingPanelButtonViewModel);

    public abstract void setPanelViewModel(@Nullable ISlidingUpPanelViewModel iSlidingUpPanelViewModel);

    public abstract void setSlideLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner);

    @Deprecated
    public static OfferProductListFragmentSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (OfferProductListFragmentSravniBinding) ViewDataBinding.bind(obj, view, R.layout.offer_product_list_fragment_sravni);
    }

    @NonNull
    @Deprecated
    public static OfferProductListFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (OfferProductListFragmentSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_product_list_fragment_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static OfferProductListFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static OfferProductListFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (OfferProductListFragmentSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_product_list_fragment_sravni, null, false, obj);
    }
}
