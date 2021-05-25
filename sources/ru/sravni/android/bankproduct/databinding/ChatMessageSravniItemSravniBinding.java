package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.presentation.chat.adapter.message.SravniMessageItemDescription;
import ru.sravni.android.bankproduct.utils.WrappedTextView;
public abstract class ChatMessageSravniItemSravniBinding extends ViewDataBinding {
    @NonNull
    public final WrappedTextView chatMessage;
    @NonNull
    public final FrameLayout flCreatedTime;
    @NonNull
    public final ImageView imgFirstPoint;
    @NonNull
    public final ImageView imgSecondPoint;
    @NonNull
    public final ImageView imgThirdPoint;
    @NonNull
    public final ImageView ivBotFace;
    @NonNull
    public final LinearLayout llWritingBot;
    @Bindable
    public Boolean mIsAnimationActive;
    @Bindable
    public Boolean mIsNextMessageFromBot;
    @Bindable
    public String mMessage;
    @Bindable
    public SravniMessageItemDescription mMessageDescription;
    @NonNull
    public final Guideline rightGuideline;
    @NonNull
    public final TextView tvCreatedTime;

    public ChatMessageSravniItemSravniBinding(Object obj, View view, int i, WrappedTextView wrappedTextView, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout, Guideline guideline, TextView textView) {
        super(obj, view, i);
        this.chatMessage = wrappedTextView;
        this.flCreatedTime = frameLayout;
        this.imgFirstPoint = imageView;
        this.imgSecondPoint = imageView2;
        this.imgThirdPoint = imageView3;
        this.ivBotFace = imageView4;
        this.llWritingBot = linearLayout;
        this.rightGuideline = guideline;
        this.tvCreatedTime = textView;
    }

    public static ChatMessageSravniItemSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChatMessageSravniItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public Boolean getIsAnimationActive() {
        return this.mIsAnimationActive;
    }

    @Nullable
    public Boolean getIsNextMessageFromBot() {
        return this.mIsNextMessageFromBot;
    }

    @Nullable
    public String getMessage() {
        return this.mMessage;
    }

    @Nullable
    public SravniMessageItemDescription getMessageDescription() {
        return this.mMessageDescription;
    }

    public abstract void setIsAnimationActive(@Nullable Boolean bool);

    public abstract void setIsNextMessageFromBot(@Nullable Boolean bool);

    public abstract void setMessage(@Nullable String str);

    public abstract void setMessageDescription(@Nullable SravniMessageItemDescription sravniMessageItemDescription);

    @Deprecated
    public static ChatMessageSravniItemSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ChatMessageSravniItemSravniBinding) ViewDataBinding.bind(obj, view, R.layout.chat_message_sravni_item_sravni);
    }

    @NonNull
    @Deprecated
    public static ChatMessageSravniItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChatMessageSravniItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.chat_message_sravni_item_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static ChatMessageSravniItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChatMessageSravniItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChatMessageSravniItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.chat_message_sravni_item_sravni, null, false, obj);
    }
}
