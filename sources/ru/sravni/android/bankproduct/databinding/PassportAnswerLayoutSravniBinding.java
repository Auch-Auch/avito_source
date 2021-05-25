package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputLayout;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.INextContentCard;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IPassportScanAnswerViewModel;
public abstract class PassportAnswerLayoutSravniBinding extends ViewDataBinding {
    @Bindable
    public INextContentCard mNextContentCard;
    @Bindable
    public IPassportScanAnswerViewModel mPassportScanAnswerViewModel;
    @NonNull
    public final TextInputLayout tilPassportBoth;
    @NonNull
    public final TextInputLayout tilPassportCode;
    @NonNull
    public final TextInputLayout tilPassportDate;
    @NonNull
    public final TextInputLayout tilPassportNumber;

    public PassportAnswerLayoutSravniBinding(Object obj, View view, int i, TextInputLayout textInputLayout, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, TextInputLayout textInputLayout4) {
        super(obj, view, i);
        this.tilPassportBoth = textInputLayout;
        this.tilPassportCode = textInputLayout2;
        this.tilPassportDate = textInputLayout3;
        this.tilPassportNumber = textInputLayout4;
    }

    public static PassportAnswerLayoutSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static PassportAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public INextContentCard getNextContentCard() {
        return this.mNextContentCard;
    }

    @Nullable
    public IPassportScanAnswerViewModel getPassportScanAnswerViewModel() {
        return this.mPassportScanAnswerViewModel;
    }

    public abstract void setNextContentCard(@Nullable INextContentCard iNextContentCard);

    public abstract void setPassportScanAnswerViewModel(@Nullable IPassportScanAnswerViewModel iPassportScanAnswerViewModel);

    @Deprecated
    public static PassportAnswerLayoutSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (PassportAnswerLayoutSravniBinding) ViewDataBinding.bind(obj, view, R.layout.passport_answer_layout_sravni);
    }

    @NonNull
    @Deprecated
    public static PassportAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (PassportAnswerLayoutSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.passport_answer_layout_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static PassportAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static PassportAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (PassportAnswerLayoutSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.passport_answer_layout_sravni, null, false, obj);
    }
}
