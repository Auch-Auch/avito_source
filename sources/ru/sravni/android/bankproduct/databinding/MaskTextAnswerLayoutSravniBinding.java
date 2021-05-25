package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.INextContentCard;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IMaskTextAnswerViewModel;
import ru.sravni.android.bankproduct.utils.CustomEditTextWithControlledListeners;
public abstract class MaskTextAnswerLayoutSravniBinding extends ViewDataBinding {
    @NonNull
    public final CustomEditTextWithControlledListeners etAnswer;
    @NonNull
    public final ImageView imgSendAnswer;
    @Bindable
    public IMaskTextAnswerViewModel mMaskTextAnswerViewModel;
    @Bindable
    public INextContentCard mNextContentCard;

    public MaskTextAnswerLayoutSravniBinding(Object obj, View view, int i, CustomEditTextWithControlledListeners customEditTextWithControlledListeners, ImageView imageView) {
        super(obj, view, i);
        this.etAnswer = customEditTextWithControlledListeners;
        this.imgSendAnswer = imageView;
    }

    public static MaskTextAnswerLayoutSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MaskTextAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public IMaskTextAnswerViewModel getMaskTextAnswerViewModel() {
        return this.mMaskTextAnswerViewModel;
    }

    @Nullable
    public INextContentCard getNextContentCard() {
        return this.mNextContentCard;
    }

    public abstract void setMaskTextAnswerViewModel(@Nullable IMaskTextAnswerViewModel iMaskTextAnswerViewModel);

    public abstract void setNextContentCard(@Nullable INextContentCard iNextContentCard);

    @Deprecated
    public static MaskTextAnswerLayoutSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (MaskTextAnswerLayoutSravniBinding) ViewDataBinding.bind(obj, view, R.layout.mask_text_answer_layout_sravni);
    }

    @NonNull
    @Deprecated
    public static MaskTextAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MaskTextAnswerLayoutSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mask_text_answer_layout_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static MaskTextAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MaskTextAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MaskTextAnswerLayoutSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mask_text_answer_layout_sravni, null, false, obj);
    }
}
