package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.util.List;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ISetSuggestion;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.SuggestInfo;
public abstract class SuggestListSravniBinding extends ViewDataBinding {
    @Bindable
    public ISetSuggestion mSuggestInfoSetter;
    @Bindable
    public List<SuggestInfo> mSuggestList;

    public SuggestListSravniBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static SuggestListSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static SuggestListSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public ISetSuggestion getSuggestInfoSetter() {
        return this.mSuggestInfoSetter;
    }

    @Nullable
    public List<SuggestInfo> getSuggestList() {
        return this.mSuggestList;
    }

    public abstract void setSuggestInfoSetter(@Nullable ISetSuggestion iSetSuggestion);

    public abstract void setSuggestList(@Nullable List<SuggestInfo> list);

    @Deprecated
    public static SuggestListSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (SuggestListSravniBinding) ViewDataBinding.bind(obj, view, R.layout.suggest_list_sravni);
    }

    @NonNull
    @Deprecated
    public static SuggestListSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (SuggestListSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.suggest_list_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static SuggestListSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static SuggestListSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (SuggestListSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.suggest_list_sravni, null, false, obj);
    }
}
