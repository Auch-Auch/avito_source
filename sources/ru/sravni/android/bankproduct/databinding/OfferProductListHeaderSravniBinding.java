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
public abstract class OfferProductListHeaderSravniBinding extends ViewDataBinding {
    @Bindable
    public String mDescription;
    @Bindable
    public String mTitleGroup;
    @NonNull
    public final TextView tvDescription;
    @NonNull
    public final TextView tvHeader;

    public OfferProductListHeaderSravniBinding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.tvDescription = textView;
        this.tvHeader = textView2;
    }

    public static OfferProductListHeaderSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static OfferProductListHeaderSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public String getDescription() {
        return this.mDescription;
    }

    @Nullable
    public String getTitleGroup() {
        return this.mTitleGroup;
    }

    public abstract void setDescription(@Nullable String str);

    public abstract void setTitleGroup(@Nullable String str);

    @Deprecated
    public static OfferProductListHeaderSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (OfferProductListHeaderSravniBinding) ViewDataBinding.bind(obj, view, R.layout.offer_product_list_header_sravni);
    }

    @NonNull
    @Deprecated
    public static OfferProductListHeaderSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (OfferProductListHeaderSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_product_list_header_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static OfferProductListHeaderSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static OfferProductListHeaderSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (OfferProductListHeaderSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_product_list_header_sravni, null, false, obj);
    }
}
