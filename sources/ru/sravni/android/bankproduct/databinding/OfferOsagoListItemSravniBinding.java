package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.button.MaterialButton;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoDetailDomain;
import ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.ISelectOfferOsago;
public abstract class OfferOsagoListItemSravniBinding extends ViewDataBinding {
    @NonNull
    public final CardView cvIconOsago;
    @NonNull
    public final LinearLayout llSumWaitOsago;
    @Bindable
    public OfferOsagoDetailDomain mOsagoDetail;
    @Bindable
    public ISelectOfferOsago mSelectOfferOsago;
    @NonNull
    public final MaterialButton mbCarInfo;
    @NonNull
    public final TextView tvIconOsago;
    @NonNull
    public final TextView tvNameOsago;
    @NonNull
    public final TextView tvSumOsago;

    public OfferOsagoListItemSravniBinding(Object obj, View view, int i, CardView cardView, LinearLayout linearLayout, MaterialButton materialButton, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.cvIconOsago = cardView;
        this.llSumWaitOsago = linearLayout;
        this.mbCarInfo = materialButton;
        this.tvIconOsago = textView;
        this.tvNameOsago = textView2;
        this.tvSumOsago = textView3;
    }

    public static OfferOsagoListItemSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static OfferOsagoListItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public OfferOsagoDetailDomain getOsagoDetail() {
        return this.mOsagoDetail;
    }

    @Nullable
    public ISelectOfferOsago getSelectOfferOsago() {
        return this.mSelectOfferOsago;
    }

    public abstract void setOsagoDetail(@Nullable OfferOsagoDetailDomain offerOsagoDetailDomain);

    public abstract void setSelectOfferOsago(@Nullable ISelectOfferOsago iSelectOfferOsago);

    @Deprecated
    public static OfferOsagoListItemSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (OfferOsagoListItemSravniBinding) ViewDataBinding.bind(obj, view, R.layout.offer_osago_list_item_sravni);
    }

    @NonNull
    @Deprecated
    public static OfferOsagoListItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (OfferOsagoListItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_osago_list_item_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static OfferOsagoListItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static OfferOsagoListItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (OfferOsagoListItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_osago_list_item_sravni, null, false, obj);
    }
}
