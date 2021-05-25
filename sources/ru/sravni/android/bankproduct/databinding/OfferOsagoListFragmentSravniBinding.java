package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.IOfferOsagoListViewModel;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.ISlidingPanelButtonViewModel;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.ISlidingUpPanelViewModel;
public abstract class OfferOsagoListFragmentSravniBinding extends ViewDataBinding {
    @NonNull
    public final FrameLayout flFilterPanel;
    @NonNull
    public final FrameLayout flPanelFadeLayout;
    @Bindable
    public IOfferOsagoListViewModel mOfferOsagoListViewModel;
    @Bindable
    public ISlidingPanelButtonViewModel mPanelButtonViewModel;
    @Bindable
    public ISlidingUpPanelViewModel mPanelViewModel;
    @Bindable
    public LifecycleOwner mSlideLifecycleOwner;
    @NonNull
    public final RecyclerView rvFilterPanel;
    @NonNull
    public final RecyclerView rvListOsagoOffer;
    @NonNull
    public final SlidingUpPanelLayout slidingLayout;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final View vToolbar;

    public OfferOsagoListFragmentSravniBinding(Object obj, View view, int i, FrameLayout frameLayout, FrameLayout frameLayout2, RecyclerView recyclerView, RecyclerView recyclerView2, SlidingUpPanelLayout slidingUpPanelLayout, Toolbar toolbar2, View view2) {
        super(obj, view, i);
        this.flFilterPanel = frameLayout;
        this.flPanelFadeLayout = frameLayout2;
        this.rvFilterPanel = recyclerView;
        this.rvListOsagoOffer = recyclerView2;
        this.slidingLayout = slidingUpPanelLayout;
        this.toolbar = toolbar2;
        this.vToolbar = view2;
    }

    public static OfferOsagoListFragmentSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static OfferOsagoListFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public IOfferOsagoListViewModel getOfferOsagoListViewModel() {
        return this.mOfferOsagoListViewModel;
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

    public abstract void setOfferOsagoListViewModel(@Nullable IOfferOsagoListViewModel iOfferOsagoListViewModel);

    public abstract void setPanelButtonViewModel(@Nullable ISlidingPanelButtonViewModel iSlidingPanelButtonViewModel);

    public abstract void setPanelViewModel(@Nullable ISlidingUpPanelViewModel iSlidingUpPanelViewModel);

    public abstract void setSlideLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner);

    @Deprecated
    public static OfferOsagoListFragmentSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (OfferOsagoListFragmentSravniBinding) ViewDataBinding.bind(obj, view, R.layout.offer_osago_list_fragment_sravni);
    }

    @NonNull
    @Deprecated
    public static OfferOsagoListFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (OfferOsagoListFragmentSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_osago_list_fragment_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static OfferOsagoListFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static OfferOsagoListFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (OfferOsagoListFragmentSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_osago_list_fragment_sravni, null, false, obj);
    }
}
