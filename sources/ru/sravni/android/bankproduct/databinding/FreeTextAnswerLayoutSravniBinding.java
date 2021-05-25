package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.INextContentCard;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IFreeTextAnswerViewModel;
public abstract class FreeTextAnswerLayoutSravniBinding extends ViewDataBinding {
    @NonNull
    public final EditText etAnswer;
    @NonNull
    public final ImageView imgSendAnswer;
    @Bindable
    public IFreeTextAnswerViewModel mFreeTextAnswerViewModel;
    @Bindable
    public INextContentCard mNextContentCard;

    public FreeTextAnswerLayoutSravniBinding(Object obj, View view, int i, EditText editText, ImageView imageView) {
        super(obj, view, i);
        this.etAnswer = editText;
        this.imgSendAnswer = imageView;
    }

    public static FreeTextAnswerLayoutSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FreeTextAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public IFreeTextAnswerViewModel getFreeTextAnswerViewModel() {
        return this.mFreeTextAnswerViewModel;
    }

    @Nullable
    public INextContentCard getNextContentCard() {
        return this.mNextContentCard;
    }

    public abstract void setFreeTextAnswerViewModel(@Nullable IFreeTextAnswerViewModel iFreeTextAnswerViewModel);

    public abstract void setNextContentCard(@Nullable INextContentCard iNextContentCard);

    @Deprecated
    public static FreeTextAnswerLayoutSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FreeTextAnswerLayoutSravniBinding) ViewDataBinding.bind(obj, view, R.layout.free_text_answer_layout_sravni);
    }

    @NonNull
    @Deprecated
    public static FreeTextAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FreeTextAnswerLayoutSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.free_text_answer_layout_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static FreeTextAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FreeTextAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FreeTextAnswerLayoutSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.free_text_answer_layout_sravni, null, false, obj);
    }
}
