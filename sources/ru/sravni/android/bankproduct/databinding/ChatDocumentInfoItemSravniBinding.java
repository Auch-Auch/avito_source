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
public abstract class ChatDocumentInfoItemSravniBinding extends ViewDataBinding {
    @Bindable
    public String mMessage;
    @Bindable
    public String mTitle;
    @NonNull
    public final TextView tvText;
    @NonNull
    public final TextView tvTitle;

    public ChatDocumentInfoItemSravniBinding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.tvText = textView;
        this.tvTitle = textView2;
    }

    public static ChatDocumentInfoItemSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChatDocumentInfoItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public String getMessage() {
        return this.mMessage;
    }

    @Nullable
    public String getTitle() {
        return this.mTitle;
    }

    public abstract void setMessage(@Nullable String str);

    public abstract void setTitle(@Nullable String str);

    @Deprecated
    public static ChatDocumentInfoItemSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ChatDocumentInfoItemSravniBinding) ViewDataBinding.bind(obj, view, R.layout.chat_document_info_item_sravni);
    }

    @NonNull
    @Deprecated
    public static ChatDocumentInfoItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChatDocumentInfoItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.chat_document_info_item_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static ChatDocumentInfoItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChatDocumentInfoItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChatDocumentInfoItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.chat_document_info_item_sravni, null, false, obj);
    }
}
