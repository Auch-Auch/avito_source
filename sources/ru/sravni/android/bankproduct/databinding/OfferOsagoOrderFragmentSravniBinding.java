package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.button.MaterialButton;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.IOfferOsagoOrderViewModel;
public abstract class OfferOsagoOrderFragmentSravniBinding extends ViewDataBinding {
    @NonNull
    public final MaterialButton btnCloseOsago;
    @NonNull
    public final MaterialButton btnPaymentOsago;
    @NonNull
    public final FrameLayout frBtnSection;
    @NonNull
    public final OfferOsagoOrderStatusSravniBinding incStatusView;
    @NonNull
    public final LinearLayout llViewSection;
    @Bindable
    public IOfferOsagoOrderViewModel mOfferOsagoOrderViewModel;
    @NonNull
    public final Toolbar toolbar;

    public OfferOsagoOrderFragmentSravniBinding(Object obj, View view, int i, MaterialButton materialButton, MaterialButton materialButton2, FrameLayout frameLayout, OfferOsagoOrderStatusSravniBinding offerOsagoOrderStatusSravniBinding, LinearLayout linearLayout, Toolbar toolbar2) {
        super(obj, view, i);
        this.btnCloseOsago = materialButton;
        this.btnPaymentOsago = materialButton2;
        this.frBtnSection = frameLayout;
        this.incStatusView = offerOsagoOrderStatusSravniBinding;
        setContainedBinding(offerOsagoOrderStatusSravniBinding);
        this.llViewSection = linearLayout;
        this.toolbar = toolbar2;
    }

    public static OfferOsagoOrderFragmentSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static OfferOsagoOrderFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public IOfferOsagoOrderViewModel getOfferOsagoOrderViewModel() {
        return this.mOfferOsagoOrderViewModel;
    }

    public abstract void setOfferOsagoOrderViewModel(@Nullable IOfferOsagoOrderViewModel iOfferOsagoOrderViewModel);

    @Deprecated
    public static OfferOsagoOrderFragmentSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (OfferOsagoOrderFragmentSravniBinding) ViewDataBinding.bind(obj, view, R.layout.offer_osago_order_fragment_sravni);
    }

    @NonNull
    @Deprecated
    public static OfferOsagoOrderFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (OfferOsagoOrderFragmentSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_osago_order_fragment_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static OfferOsagoOrderFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static OfferOsagoOrderFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (OfferOsagoOrderFragmentSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_osago_order_fragment_sravni, null, false, obj);
    }
}
