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
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ButtonAnswerInfo;
public abstract class ButtonAnswerItemSravniBinding extends ViewDataBinding {
    @Bindable
    public ButtonAnswerInfo mButtonAnswerInfo;
    @Bindable
    public INextContentCard mClickSendAnswer;

    public ButtonAnswerItemSravniBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ButtonAnswerItemSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ButtonAnswerItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public ButtonAnswerInfo getButtonAnswerInfo() {
        return this.mButtonAnswerInfo;
    }

    @Nullable
    public INextContentCard getClickSendAnswer() {
        return this.mClickSendAnswer;
    }

    public abstract void setButtonAnswerInfo(@Nullable ButtonAnswerInfo buttonAnswerInfo);

    public abstract void setClickSendAnswer(@Nullable INextContentCard iNextContentCard);

    @Deprecated
    public static ButtonAnswerItemSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ButtonAnswerItemSravniBinding) ViewDataBinding.bind(obj, view, R.layout.button_answer_item_sravni);
    }

    @NonNull
    @Deprecated
    public static ButtonAnswerItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ButtonAnswerItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.button_answer_item_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static ButtonAnswerItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ButtonAnswerItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ButtonAnswerItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.button_answer_item_sravni, null, false, obj);
    }
}
