package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.order.OsagoCompanyOrderInfoDomain;
public abstract class OfferOsagoOrderStatusSravniBinding extends ViewDataBinding {
    @NonNull
    public final ImageView imgIconAnswer;
    @Bindable
    public Integer mIconStatus;
    @Bindable
    public Boolean mNeedAlternativeCompany;
    @Bindable
    public OsagoCompanyOrderInfoDomain mOsagoPaymentInfo;
    @NonNull
    public final DiscreteScrollView rvAnotherCompany;
    @NonNull
    public final TextView tvComparisonPrice;
    @NonNull
    public final TextView tvComparisonText;
    @NonNull
    public final TextView tvText;
    @NonNull
    public final TextView tvTextTitle;

    public OfferOsagoOrderStatusSravniBinding(Object obj, View view, int i, ImageView imageView, DiscreteScrollView discreteScrollView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.imgIconAnswer = imageView;
        this.rvAnotherCompany = discreteScrollView;
        this.tvComparisonPrice = textView;
        this.tvComparisonText = textView2;
        this.tvText = textView3;
        this.tvTextTitle = textView4;
    }

    public static OfferOsagoOrderStatusSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static OfferOsagoOrderStatusSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public Integer getIconStatus() {
        return this.mIconStatus;
    }

    @Nullable
    public Boolean getNeedAlternativeCompany() {
        return this.mNeedAlternativeCompany;
    }

    @Nullable
    public OsagoCompanyOrderInfoDomain getOsagoPaymentInfo() {
        return this.mOsagoPaymentInfo;
    }

    public abstract void setIconStatus(@Nullable Integer num);

    public abstract void setNeedAlternativeCompany(@Nullable Boolean bool);

    public abstract void setOsagoPaymentInfo(@Nullable OsagoCompanyOrderInfoDomain osagoCompanyOrderInfoDomain);

    @Deprecated
    public static OfferOsagoOrderStatusSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (OfferOsagoOrderStatusSravniBinding) ViewDataBinding.bind(obj, view, R.layout.offer_osago_order_status_sravni);
    }

    @NonNull
    @Deprecated
    public static OfferOsagoOrderStatusSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (OfferOsagoOrderStatusSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_osago_order_status_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static OfferOsagoOrderStatusSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static OfferOsagoOrderStatusSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (OfferOsagoOrderStatusSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_osago_order_status_sravni, null, false, obj);
    }
}
