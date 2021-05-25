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
import ru.sravni.android.bankproduct.presentation.auth.tokenfail.viewmodel.ITokenTokenFailDialogViewModel;
public abstract class TokenRefreshDialogSravniBinding extends ViewDataBinding {
    @Bindable
    public ITokenTokenFailDialogViewModel mViewModel;
    @NonNull
    public final TextView tvButtonOk;
    @NonNull
    public final TextView tvErrorDescription;

    public TokenRefreshDialogSravniBinding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.tvButtonOk = textView;
        this.tvErrorDescription = textView2;
    }

    public static TokenRefreshDialogSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static TokenRefreshDialogSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public ITokenTokenFailDialogViewModel getViewModel() {
        return this.mViewModel;
    }

    public abstract void setViewModel(@Nullable ITokenTokenFailDialogViewModel iTokenTokenFailDialogViewModel);

    @Deprecated
    public static TokenRefreshDialogSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (TokenRefreshDialogSravniBinding) ViewDataBinding.bind(obj, view, R.layout.token_refresh_dialog_sravni);
    }

    @NonNull
    @Deprecated
    public static TokenRefreshDialogSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (TokenRefreshDialogSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.token_refresh_dialog_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static TokenRefreshDialogSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static TokenRefreshDialogSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (TokenRefreshDialogSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.token_refresh_dialog_sravni, null, false, obj);
    }
}
