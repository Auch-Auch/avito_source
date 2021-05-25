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
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IGoToDashboardAnswerViewModel;
public abstract class CloseChatAnswerLayoutSravniBinding extends ViewDataBinding {
    @Bindable
    public IGoToDashboardAnswerViewModel mGoToDashboardAnswerViewModel;

    public CloseChatAnswerLayoutSravniBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static CloseChatAnswerLayoutSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static CloseChatAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public IGoToDashboardAnswerViewModel getGoToDashboardAnswerViewModel() {
        return this.mGoToDashboardAnswerViewModel;
    }

    public abstract void setGoToDashboardAnswerViewModel(@Nullable IGoToDashboardAnswerViewModel iGoToDashboardAnswerViewModel);

    @Deprecated
    public static CloseChatAnswerLayoutSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (CloseChatAnswerLayoutSravniBinding) ViewDataBinding.bind(obj, view, R.layout.close_chat_answer_layout_sravni);
    }

    @NonNull
    @Deprecated
    public static CloseChatAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (CloseChatAnswerLayoutSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.close_chat_answer_layout_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static CloseChatAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static CloseChatAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (CloseChatAnswerLayoutSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.close_chat_answer_layout_sravni, null, false, obj);
    }
}
