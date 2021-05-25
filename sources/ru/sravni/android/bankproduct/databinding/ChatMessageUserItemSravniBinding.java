package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.presentation.chat.adapter.message.UserMessageItemDescription;
import ru.sravni.android.bankproduct.utils.WrappedTextView;
public abstract class ChatMessageUserItemSravniBinding extends ViewDataBinding {
    @NonNull
    public final ImageView ivStatus;
    @NonNull
    public final ImageView ivWaitingAnimation;
    @NonNull
    public final Guideline leftGuideline;
    @Bindable
    public UserMessageItemDescription mMessageDescription;
    @NonNull
    public final TextView tvCreatedTime;
    @NonNull
    public final WrappedTextView tvText;
    @NonNull
    public final Space tvTextMargin;

    public ChatMessageUserItemSravniBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, Guideline guideline, TextView textView, WrappedTextView wrappedTextView, Space space) {
        super(obj, view, i);
        this.ivStatus = imageView;
        this.ivWaitingAnimation = imageView2;
        this.leftGuideline = guideline;
        this.tvCreatedTime = textView;
        this.tvText = wrappedTextView;
        this.tvTextMargin = space;
    }

    public static ChatMessageUserItemSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChatMessageUserItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public UserMessageItemDescription getMessageDescription() {
        return this.mMessageDescription;
    }

    public abstract void setMessageDescription(@Nullable UserMessageItemDescription userMessageItemDescription);

    @Deprecated
    public static ChatMessageUserItemSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ChatMessageUserItemSravniBinding) ViewDataBinding.bind(obj, view, R.layout.chat_message_user_item_sravni);
    }

    @NonNull
    @Deprecated
    public static ChatMessageUserItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChatMessageUserItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.chat_message_user_item_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static ChatMessageUserItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChatMessageUserItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChatMessageUserItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.chat_message_user_item_sravni, null, false, obj);
    }
}
