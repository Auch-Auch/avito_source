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
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ICreditOffersAnswerViewModel;
public abstract class CreditOffersAnswerLayoutSravniBinding extends ViewDataBinding {
    @Bindable
    public ICreditOffersAnswerViewModel mCreditOffersAnswerViewModel;
    @Bindable
    public INextContentCard mNextContentCard;

    public CreditOffersAnswerLayoutSravniBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static CreditOffersAnswerLayoutSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static CreditOffersAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public ICreditOffersAnswerViewModel getCreditOffersAnswerViewModel() {
        return this.mCreditOffersAnswerViewModel;
    }

    @Nullable
    public INextContentCard getNextContentCard() {
        return this.mNextContentCard;
    }

    public abstract void setCreditOffersAnswerViewModel(@Nullable ICreditOffersAnswerViewModel iCreditOffersAnswerViewModel);

    public abstract void setNextContentCard(@Nullable INextContentCard iNextContentCard);

    @Deprecated
    public static CreditOffersAnswerLayoutSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (CreditOffersAnswerLayoutSravniBinding) ViewDataBinding.bind(obj, view, R.layout.credit_offers_answer_layout_sravni);
    }

    @NonNull
    @Deprecated
    public static CreditOffersAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (CreditOffersAnswerLayoutSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.credit_offers_answer_layout_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static CreditOffersAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static CreditOffersAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (CreditOffersAnswerLayoutSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.credit_offers_answer_layout_sravni, null, false, obj);
    }
}
