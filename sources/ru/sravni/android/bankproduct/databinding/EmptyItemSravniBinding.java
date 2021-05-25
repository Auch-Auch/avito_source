package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import ru.sravni.android.bankproduct.R;
public abstract class EmptyItemSravniBinding extends ViewDataBinding {
    public EmptyItemSravniBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static EmptyItemSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static EmptyItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static EmptyItemSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (EmptyItemSravniBinding) ViewDataBinding.bind(obj, view, R.layout.empty_item_sravni);
    }

    @NonNull
    @Deprecated
    public static EmptyItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (EmptyItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.empty_item_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static EmptyItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static EmptyItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (EmptyItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.empty_item_sravni, null, false, obj);
    }
}
