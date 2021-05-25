package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.domain.chat.entity.MessageDomain;
public abstract class ChatDocumentHeaderItemSravniBinding extends ViewDataBinding {
    @NonNull
    public final CardView cvIconHeader;
    @Bindable
    public MessageDomain.HeaderInfoLogo mHeaderInfoLogo;
    @Bindable
    public String mTitle;
    @NonNull
    public final TextView tvHeader;
    @NonNull
    public final TextView tvIconHeader;

    public ChatDocumentHeaderItemSravniBinding(Object obj, View view, int i, CardView cardView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.cvIconHeader = cardView;
        this.tvHeader = textView;
        this.tvIconHeader = textView2;
    }

    public static ChatDocumentHeaderItemSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChatDocumentHeaderItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public MessageDomain.HeaderInfoLogo getHeaderInfoLogo() {
        return this.mHeaderInfoLogo;
    }

    @Nullable
    public String getTitle() {
        return this.mTitle;
    }

    public abstract void setHeaderInfoLogo(@Nullable MessageDomain.HeaderInfoLogo headerInfoLogo);

    public abstract void setTitle(@Nullable String str);

    @Deprecated
    public static ChatDocumentHeaderItemSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ChatDocumentHeaderItemSravniBinding) ViewDataBinding.bind(obj, view, R.layout.chat_document_header_item_sravni);
    }

    @NonNull
    @Deprecated
    public static ChatDocumentHeaderItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChatDocumentHeaderItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.chat_document_header_item_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static ChatDocumentHeaderItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChatDocumentHeaderItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChatDocumentHeaderItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.chat_document_header_item_sravni, null, false, obj);
    }
}
