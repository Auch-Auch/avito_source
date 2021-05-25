package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.ITapQuote;
public abstract class OfferOsagoOrderQuoteSravniBinding extends ViewDataBinding {
    @Bindable
    public String mQuote;
    @Bindable
    public ITapQuote mTapQuote;
    @NonNull
    public final ProgressBar pbTimeWait;
    @NonNull
    public final TextView tvTimeWait;

    public OfferOsagoOrderQuoteSravniBinding(Object obj, View view, int i, ProgressBar progressBar, TextView textView) {
        super(obj, view, i);
        this.pbTimeWait = progressBar;
        this.tvTimeWait = textView;
    }

    public static OfferOsagoOrderQuoteSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static OfferOsagoOrderQuoteSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public String getQuote() {
        return this.mQuote;
    }

    @Nullable
    public ITapQuote getTapQuote() {
        return this.mTapQuote;
    }

    public abstract void setQuote(@Nullable String str);

    public abstract void setTapQuote(@Nullable ITapQuote iTapQuote);

    @Deprecated
    public static OfferOsagoOrderQuoteSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (OfferOsagoOrderQuoteSravniBinding) ViewDataBinding.bind(obj, view, R.layout.offer_osago_order_quote_sravni);
    }

    @NonNull
    @Deprecated
    public static OfferOsagoOrderQuoteSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (OfferOsagoOrderQuoteSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_osago_order_quote_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static OfferOsagoOrderQuoteSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static OfferOsagoOrderQuoteSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (OfferOsagoOrderQuoteSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_osago_order_quote_sravni, null, false, obj);
    }
}
