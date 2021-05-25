package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.INextContentCard;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IOsagoOrderAnswerViewModel;
public abstract class OsagoOrderAnswerLayoutSravniBinding extends ViewDataBinding {
    @Bindable
    public INextContentCard mNextContentCard;
    @Bindable
    public IOsagoOrderAnswerViewModel mOsagoOrderAnswerViewModel;

    public OsagoOrderAnswerLayoutSravniBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static OsagoOrderAnswerLayoutSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static OsagoOrderAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public INextContentCard getNextContentCard() {
        return this.mNextContentCard;
    }

    @Nullable
    public IOsagoOrderAnswerViewModel getOsagoOrderAnswerViewModel() {
        return this.mOsagoOrderAnswerViewModel;
    }

    public abstract void setNextContentCard(@Nullable INextContentCard iNextContentCard);

    public abstract void setOsagoOrderAnswerViewModel(@Nullable IOsagoOrderAnswerViewModel iOsagoOrderAnswerViewModel);

    @Deprecated
    public static OsagoOrderAnswerLayoutSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (OsagoOrderAnswerLayoutSravniBinding) ViewDataBinding.bind(obj, view, R.layout.osago_order_answer_layout_sravni);
    }

    @NonNull
    @Deprecated
    public static OsagoOrderAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (OsagoOrderAnswerLayoutSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.osago_order_answer_layout_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static OsagoOrderAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static OsagoOrderAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (OsagoOrderAnswerLayoutSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.osago_order_answer_layout_sravni, null, false, obj);
    }
}
