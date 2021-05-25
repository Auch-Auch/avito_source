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
public abstract class OfferProductInfoTitleItemSravniBinding extends ViewDataBinding {
    @Bindable
    public String mTitle;
    @NonNull
    public final TextView tvName;

    public OfferProductInfoTitleItemSravniBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.tvName = textView;
    }

    public static OfferProductInfoTitleItemSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static OfferProductInfoTitleItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public String getTitle() {
        return this.mTitle;
    }

    public abstract void setTitle(@Nullable String str);

    @Deprecated
    public static OfferProductInfoTitleItemSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (OfferProductInfoTitleItemSravniBinding) ViewDataBinding.bind(obj, view, R.layout.offer_product_info_title_item_sravni);
    }

    @NonNull
    @Deprecated
    public static OfferProductInfoTitleItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (OfferProductInfoTitleItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_product_info_title_item_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static OfferProductInfoTitleItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static OfferProductInfoTitleItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (OfferProductInfoTitleItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_product_info_title_item_sravni, null, false, obj);
    }
}
