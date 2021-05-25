package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import ru.sravni.android.bankproduct.R;
public abstract class OfferOsagoListHeaderSravniBinding extends ViewDataBinding {
    @Bindable
    public String mTitleGroup;
    @NonNull
    public final TextView tvOsagoHeader;

    public OfferOsagoListHeaderSravniBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.tvOsagoHeader = textView;
    }

    public static OfferOsagoListHeaderSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static OfferOsagoListHeaderSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public String getTitleGroup() {
        return this.mTitleGroup;
    }

    public abstract void setTitleGroup(@Nullable String str);

    @Deprecated
    public static OfferOsagoListHeaderSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (OfferOsagoListHeaderSravniBinding) ViewDataBinding.bind(obj, view, R.layout.offer_osago_list_header_sravni);
    }

    @NonNull
    @Deprecated
    public static OfferOsagoListHeaderSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (OfferOsagoListHeaderSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_osago_list_header_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static OfferOsagoListHeaderSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static OfferOsagoListHeaderSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (OfferOsagoListHeaderSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_osago_list_header_sravni, null, false, obj);
    }
}
