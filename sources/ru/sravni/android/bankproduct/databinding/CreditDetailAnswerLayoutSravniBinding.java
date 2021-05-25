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
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ICreditDetailAnswerViewModel;
public abstract class CreditDetailAnswerLayoutSravniBinding extends ViewDataBinding {
    @Bindable
    public ICreditDetailAnswerViewModel mCreditDetailAnswerViewModel;
    @Bindable
    public INextContentCard mNextContentCard;

    public CreditDetailAnswerLayoutSravniBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static CreditDetailAnswerLayoutSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static CreditDetailAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public ICreditDetailAnswerViewModel getCreditDetailAnswerViewModel() {
        return this.mCreditDetailAnswerViewModel;
    }

    @Nullable
    public INextContentCard getNextContentCard() {
        return this.mNextContentCard;
    }

    public abstract void setCreditDetailAnswerViewModel(@Nullable ICreditDetailAnswerViewModel iCreditDetailAnswerViewModel);

    public abstract void setNextContentCard(@Nullable INextContentCard iNextContentCard);

    @Deprecated
    public static CreditDetailAnswerLayoutSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (CreditDetailAnswerLayoutSravniBinding) ViewDataBinding.bind(obj, view, R.layout.credit_detail_answer_layout_sravni);
    }

    @NonNull
    @Deprecated
    public static CreditDetailAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (CreditDetailAnswerLayoutSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.credit_detail_answer_layout_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static CreditDetailAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static CreditDetailAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (CreditDetailAnswerLayoutSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.credit_detail_answer_layout_sravni, null, false, obj);
    }
}
