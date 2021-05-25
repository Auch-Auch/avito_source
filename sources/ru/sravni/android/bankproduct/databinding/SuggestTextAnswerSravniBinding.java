package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.INextContentCard;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ISuggestionAnswerViewModel;
public abstract class SuggestTextAnswerSravniBinding extends ViewDataBinding {
    @NonNull
    public final AutoCompleteTextView actvAnswer;
    @NonNull
    public final ConstraintLayout clSuggestContainer;
    @NonNull
    public final ImageView imgSendAnswer;
    @Bindable
    public INextContentCard mNextContentCard;
    @Bindable
    public ISuggestionAnswerViewModel mSuggestionAnswerViewModel;

    public SuggestTextAnswerSravniBinding(Object obj, View view, int i, AutoCompleteTextView autoCompleteTextView, ConstraintLayout constraintLayout, ImageView imageView) {
        super(obj, view, i);
        this.actvAnswer = autoCompleteTextView;
        this.clSuggestContainer = constraintLayout;
        this.imgSendAnswer = imageView;
    }

    public static SuggestTextAnswerSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static SuggestTextAnswerSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public INextContentCard getNextContentCard() {
        return this.mNextContentCard;
    }

    @Nullable
    public ISuggestionAnswerViewModel getSuggestionAnswerViewModel() {
        return this.mSuggestionAnswerViewModel;
    }

    public abstract void setNextContentCard(@Nullable INextContentCard iNextContentCard);

    public abstract void setSuggestionAnswerViewModel(@Nullable ISuggestionAnswerViewModel iSuggestionAnswerViewModel);

    @Deprecated
    public static SuggestTextAnswerSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (SuggestTextAnswerSravniBinding) ViewDataBinding.bind(obj, view, R.layout.suggest_text_answer_sravni);
    }

    @NonNull
    @Deprecated
    public static SuggestTextAnswerSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (SuggestTextAnswerSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.suggest_text_answer_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static SuggestTextAnswerSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static SuggestTextAnswerSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (SuggestTextAnswerSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.suggest_text_answer_sravni, null, false, obj);
    }
}
