package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import ru.sravni.android.bankproduct.R;
public abstract class UtilsStubFragmentSravniBinding extends ViewDataBinding {
    @NonNull
    public final ImageView logoSravni;
    @NonNull
    public final TextView tvInProgress;

    public UtilsStubFragmentSravniBinding(Object obj, View view, int i, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.logoSravni = imageView;
        this.tvInProgress = textView;
    }

    public static UtilsStubFragmentSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static UtilsStubFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UtilsStubFragmentSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (UtilsStubFragmentSravniBinding) ViewDataBinding.bind(obj, view, R.layout.utils_stub_fragment_sravni);
    }

    @NonNull
    @Deprecated
    public static UtilsStubFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (UtilsStubFragmentSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.utils_stub_fragment_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static UtilsStubFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static UtilsStubFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (UtilsStubFragmentSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.utils_stub_fragment_sravni, null, false, obj);
    }
}
