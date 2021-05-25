package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.order.OsagoCompanyOrderDomain;
public abstract class OfferOsagoOrderInfoSravniBinding extends ViewDataBinding {
    @NonNull
    public final CardView cvIconOsago;
    @Bindable
    public OsagoCompanyOrderDomain mOsagoCompanyOrder;
    @NonNull
    public final TextView tvIconOsago;
    @NonNull
    public final TextView tvNameOsago;
    @NonNull
    public final TextView tvTitleOsago;
    @NonNull
    public final View vLine;

    public OfferOsagoOrderInfoSravniBinding(Object obj, View view, int i, CardView cardView, TextView textView, TextView textView2, TextView textView3, View view2) {
        super(obj, view, i);
        this.cvIconOsago = cardView;
        this.tvIconOsago = textView;
        this.tvNameOsago = textView2;
        this.tvTitleOsago = textView3;
        this.vLine = view2;
    }

    public static OfferOsagoOrderInfoSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static OfferOsagoOrderInfoSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public OsagoCompanyOrderDomain getOsagoCompanyOrder() {
        return this.mOsagoCompanyOrder;
    }

    public abstract void setOsagoCompanyOrder(@Nullable OsagoCompanyOrderDomain osagoCompanyOrderDomain);

    @Deprecated
    public static OfferOsagoOrderInfoSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (OfferOsagoOrderInfoSravniBinding) ViewDataBinding.bind(obj, view, R.layout.offer_osago_order_info_sravni);
    }

    @NonNull
    @Deprecated
    public static OfferOsagoOrderInfoSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (OfferOsagoOrderInfoSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_osago_order_info_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static OfferOsagoOrderInfoSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static OfferOsagoOrderInfoSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (OfferOsagoOrderInfoSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_osago_order_info_sravni, null, false, obj);
    }
}
