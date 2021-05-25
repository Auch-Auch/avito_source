package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.slider.Slider;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.INextContentCard;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ISliderAnswerViewModel;
public abstract class SliderAnswerLayoutSravniBinding extends ViewDataBinding {
    @NonNull
    public final FrameLayout flSlider;
    @NonNull
    public final ImageView imgSendAnswer;
    @NonNull
    public final ConstraintLayout llSliderAnswerLayout;
    @Bindable
    public INextContentCard mNextContentCard;
    @Bindable
    public ISliderAnswerViewModel mSliderAnswerViewModel;
    @NonNull
    public final Slider slider;
    @NonNull
    public final TextView tvMaxAmountTitle;
    @NonNull
    public final TextView tvMinAmountTitle;

    public SliderAnswerLayoutSravniBinding(Object obj, View view, int i, FrameLayout frameLayout, ImageView imageView, ConstraintLayout constraintLayout, Slider slider2, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.flSlider = frameLayout;
        this.imgSendAnswer = imageView;
        this.llSliderAnswerLayout = constraintLayout;
        this.slider = slider2;
        this.tvMaxAmountTitle = textView;
        this.tvMinAmountTitle = textView2;
    }

    public static SliderAnswerLayoutSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static SliderAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public INextContentCard getNextContentCard() {
        return this.mNextContentCard;
    }

    @Nullable
    public ISliderAnswerViewModel getSliderAnswerViewModel() {
        return this.mSliderAnswerViewModel;
    }

    public abstract void setNextContentCard(@Nullable INextContentCard iNextContentCard);

    public abstract void setSliderAnswerViewModel(@Nullable ISliderAnswerViewModel iSliderAnswerViewModel);

    @Deprecated
    public static SliderAnswerLayoutSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (SliderAnswerLayoutSravniBinding) ViewDataBinding.bind(obj, view, R.layout.slider_answer_layout_sravni);
    }

    @NonNull
    @Deprecated
    public static SliderAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (SliderAnswerLayoutSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.slider_answer_layout_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static SliderAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static SliderAnswerLayoutSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (SliderAnswerLayoutSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.slider_answer_layout_sravni, null, false, obj);
    }
}
