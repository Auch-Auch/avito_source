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
import ru.sravni.android.bankproduct.presentation.dialogerror.viewmodel.IDialogErrorViewModel;
public abstract class ErrorDialogFragmentSravniBinding extends ViewDataBinding {
    @Bindable
    public IDialogErrorViewModel mViewModel;
    @NonNull
    public final TextView tvButtonOk;
    @NonNull
    public final TextView tvErrorDescription;

    public ErrorDialogFragmentSravniBinding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.tvButtonOk = textView;
        this.tvErrorDescription = textView2;
    }

    public static ErrorDialogFragmentSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ErrorDialogFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public IDialogErrorViewModel getViewModel() {
        return this.mViewModel;
    }

    public abstract void setViewModel(@Nullable IDialogErrorViewModel iDialogErrorViewModel);

    @Deprecated
    public static ErrorDialogFragmentSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ErrorDialogFragmentSravniBinding) ViewDataBinding.bind(obj, view, R.layout.error_dialog_fragment_sravni);
    }

    @NonNull
    @Deprecated
    public static ErrorDialogFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ErrorDialogFragmentSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.error_dialog_fragment_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static ErrorDialogFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ErrorDialogFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ErrorDialogFragmentSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.error_dialog_fragment_sravni, null, false, obj);
    }
}
