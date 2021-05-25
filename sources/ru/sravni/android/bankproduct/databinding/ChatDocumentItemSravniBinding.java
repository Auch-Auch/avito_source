package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import ru.sravni.android.bankproduct.R;
public abstract class ChatDocumentItemSravniBinding extends ViewDataBinding {
    @NonNull
    public final RecyclerView rvDocumentItem;

    public ChatDocumentItemSravniBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.rvDocumentItem = recyclerView;
    }

    public static ChatDocumentItemSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChatDocumentItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChatDocumentItemSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ChatDocumentItemSravniBinding) ViewDataBinding.bind(obj, view, R.layout.chat_document_item_sravni);
    }

    @NonNull
    @Deprecated
    public static ChatDocumentItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChatDocumentItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.chat_document_item_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static ChatDocumentItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChatDocumentItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChatDocumentItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.chat_document_item_sravni, null, false, obj);
    }
}
