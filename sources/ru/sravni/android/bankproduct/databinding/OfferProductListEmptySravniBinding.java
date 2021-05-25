package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import ru.sravni.android.bankproduct.R;
public abstract class OfferProductListEmptySravniBinding extends ViewDataBinding {
    @NonNull
    public final TextView tvDescription;
    @NonNull
    public final TextView tvHeader;

    public OfferProductListEmptySravniBinding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.tvDescription = textView;
        this.tvHeader = textView2;
    }

    public static OfferProductListEmptySravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static OfferProductListEmptySravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static OfferProductListEmptySravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (OfferProductListEmptySravniBinding) ViewDataBinding.bind(obj, view, R.layout.offer_product_list_empty_sravni);
    }

    @NonNull
    @Deprecated
    public static OfferProductListEmptySravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (OfferProductListEmptySravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_product_list_empty_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static OfferProductListEmptySravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static OfferProductListEmptySravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (OfferProductListEmptySravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_product_list_empty_sravni, null, false, obj);
    }
}
