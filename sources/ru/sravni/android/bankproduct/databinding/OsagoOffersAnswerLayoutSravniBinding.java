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
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IOsagoOffersAnswerViewModel;
public abstract class OsagoOffersAnswerLayoutSravniBinding extends ViewDataBinding {
    @Bindable
    public INextContentCard mNextContentCard;
    @Bindable
    public IOsagoOffersAnswerViewModel mOsagoOffersAnswerViewModel;

    public OsagoOffersAnswerLayoutSravniBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static OsagoOffersAnswerLayoutSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static OsagoOffersAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public INextContentCard getNextContentCard() {
        return this.mNextContentCard;
    }

    @Nullable
    public IOsagoOffersAnswerViewModel getOsagoOffersAnswerViewModel() {
        return this.mOsagoOffersAnswerViewModel;
    }

    public abstract void setNextContentCard(@Nullable INextContentCard iNextContentCard);

    public abstract void setOsagoOffersAnswerViewModel(@Nullable IOsagoOffersAnswerViewModel iOsagoOffersAnswerViewModel);

    @Deprecated
    public static OsagoOffersAnswerLayoutSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (OsagoOffersAnswerLayoutSravniBinding) ViewDataBinding.bind(obj, view, R.layout.osago_offers_answer_layout_sravni);
    }

    @NonNull
    @Deprecated
    public static OsagoOffersAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (OsagoOffersAnswerLayoutSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.osago_offers_answer_layout_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static OsagoOffersAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static OsagoOffersAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (OsagoOffersAnswerLayoutSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.osago_offers_answer_layout_sravni, null, false, obj);
    }
}
