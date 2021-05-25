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
import com.google.android.material.button.MaterialButton;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.order.OsagoCompanyOrderInfoDomain;
import ru.sravni.android.bankproduct.presentation.offer.osago.order.adapter.IAlternativeCompany;
public abstract class OfferOsagoOrderAlternativeItemSravniBinding extends ViewDataBinding {
    @NonNull
    public final CardView cvIconOsago;
    @Bindable
    public IAlternativeCompany mAlternativeCompany;
    @Bindable
    public OsagoCompanyOrderInfoDomain.CompanyDomain mCompany;
    @NonNull
    public final MaterialButton mbAnotherCompany;
    @NonNull
    public final TextView tvIconOsago;
    @NonNull
    public final TextView tvNameOsago;
    @NonNull
    public final TextView tvPriceOsago;

    public OfferOsagoOrderAlternativeItemSravniBinding(Object obj, View view, int i, CardView cardView, MaterialButton materialButton, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.cvIconOsago = cardView;
        this.mbAnotherCompany = materialButton;
        this.tvIconOsago = textView;
        this.tvNameOsago = textView2;
        this.tvPriceOsago = textView3;
    }

    public static OfferOsagoOrderAlternativeItemSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static OfferOsagoOrderAlternativeItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public IAlternativeCompany getAlternativeCompany() {
        return this.mAlternativeCompany;
    }

    @Nullable
    public OsagoCompanyOrderInfoDomain.CompanyDomain getCompany() {
        return this.mCompany;
    }

    public abstract void setAlternativeCompany(@Nullable IAlternativeCompany iAlternativeCompany);

    public abstract void setCompany(@Nullable OsagoCompanyOrderInfoDomain.CompanyDomain companyDomain);

    @Deprecated
    public static OfferOsagoOrderAlternativeItemSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (OfferOsagoOrderAlternativeItemSravniBinding) ViewDataBinding.bind(obj, view, R.layout.offer_osago_order_alternative_item_sravni);
    }

    @NonNull
    @Deprecated
    public static OfferOsagoOrderAlternativeItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (OfferOsagoOrderAlternativeItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_osago_order_alternative_item_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static OfferOsagoOrderAlternativeItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static OfferOsagoOrderAlternativeItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (OfferOsagoOrderAlternativeItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_osago_order_alternative_item_sravni, null, false, obj);
    }
}
