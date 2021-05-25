package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.INextContentCard;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IButtonAnswerViewModel;
public abstract class ButtonAnswerLayoutSravniBinding extends ViewDataBinding {
    @Bindable
    public IButtonAnswerViewModel mButtonAnswerViewModel;
    @Bindable
    public INextContentCard mNextContentCard;
    @NonNull
    public final RecyclerView rvButtonAnswer;

    public ButtonAnswerLayoutSravniBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.rvButtonAnswer = recyclerView;
    }

    public static ButtonAnswerLayoutSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ButtonAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public IButtonAnswerViewModel getButtonAnswerViewModel() {
        return this.mButtonAnswerViewModel;
    }

    @Nullable
    public INextContentCard getNextContentCard() {
        return this.mNextContentCard;
    }

    public abstract void setButtonAnswerViewModel(@Nullable IButtonAnswerViewModel iButtonAnswerViewModel);

    public abstract void setNextContentCard(@Nullable INextContentCard iNextContentCard);

    @Deprecated
    public static ButtonAnswerLayoutSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ButtonAnswerLayoutSravniBinding) ViewDataBinding.bind(obj, view, R.layout.button_answer_layout_sravni);
    }

    @NonNull
    @Deprecated
    public static ButtonAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ButtonAnswerLayoutSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.button_answer_layout_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static ButtonAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ButtonAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ButtonAnswerLayoutSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.button_answer_layout_sravni, null, false, obj);
    }
}
