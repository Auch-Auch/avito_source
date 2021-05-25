package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.SuggestInfo;
public abstract class SuggestItemSravniBinding extends ViewDataBinding {
    @Bindable
    public Boolean mFirstItem;
    @Bindable
    public SuggestInfo mSuggestInfo;
    @NonNull
    public final TextView tvSubText;
    @NonNull
    public final TextView tvSuggestText;

    public SuggestItemSravniBinding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.tvSubText = textView;
        this.tvSuggestText = textView2;
    }

    public static SuggestItemSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static SuggestItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public Boolean getFirstItem() {
        return this.mFirstItem;
    }

    @Nullable
    public SuggestInfo getSuggestInfo() {
        return this.mSuggestInfo;
    }

    public abstract void setFirstItem(@Nullable Boolean bool);

    public abstract void setSuggestInfo(@Nullable SuggestInfo suggestInfo);

    @Deprecated
    public static SuggestItemSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (SuggestItemSravniBinding) ViewDataBinding.bind(obj, view, R.layout.suggest_item_sravni);
    }

    @NonNull
    @Deprecated
    public static SuggestItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (SuggestItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.suggest_item_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static SuggestItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static SuggestItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (SuggestItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.suggest_item_sravni, null, false, obj);
    }
}
