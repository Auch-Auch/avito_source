package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.button.MaterialButton;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.presentation.offer.IOfferRetryErrorViewModel;
public abstract class OfferOsagoOrderWaitErrorSravniBinding extends ViewDataBinding {
    @NonNull
    public final MaterialButton btnRepeat;
    @NonNull
    public final ImageView icErrorIcon;
    @Bindable
    public IOfferRetryErrorViewModel mOfferRetryErrorViewModel;
    @NonNull
    public final ProgressBar pbWait;
    @NonNull
    public final TextView tvDescription;
    @NonNull
    public final TextView tvTitle;

    public OfferOsagoOrderWaitErrorSravniBinding(Object obj, View view, int i, MaterialButton materialButton, ImageView imageView, ProgressBar progressBar, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.btnRepeat = materialButton;
        this.icErrorIcon = imageView;
        this.pbWait = progressBar;
        this.tvDescription = textView;
        this.tvTitle = textView2;
    }

    public static OfferOsagoOrderWaitErrorSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static OfferOsagoOrderWaitErrorSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public IOfferRetryErrorViewModel getOfferRetryErrorViewModel() {
        return this.mOfferRetryErrorViewModel;
    }

    public abstract void setOfferRetryErrorViewModel(@Nullable IOfferRetryErrorViewModel iOfferRetryErrorViewModel);

    @Deprecated
    public static OfferOsagoOrderWaitErrorSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (OfferOsagoOrderWaitErrorSravniBinding) ViewDataBinding.bind(obj, view, R.layout.offer_osago_order_wait_error_sravni);
    }

    @NonNull
    @Deprecated
    public static OfferOsagoOrderWaitErrorSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (OfferOsagoOrderWaitErrorSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_osago_order_wait_error_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static OfferOsagoOrderWaitErrorSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static OfferOsagoOrderWaitErrorSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (OfferOsagoOrderWaitErrorSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.offer_osago_order_wait_error_sravni, null, false, obj);
    }
}
