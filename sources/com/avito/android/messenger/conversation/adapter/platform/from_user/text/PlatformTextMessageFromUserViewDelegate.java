package com.avito.android.messenger.conversation.adapter.platform.from_user.text;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.adapter.HighlightableKt;
import com.avito.android.messenger.conversation.adapter.MessageViewClicks;
import com.avito.android.messenger.conversation.adapter.MessageViewClicksDelegate;
import com.avito.android.messenger.conversation.adapter.platform.LinkArrowKeyMovementMethod;
import com.avito.android.messenger.conversation.adapter.platform.from_user.text.PlatformTextMessageFromUserView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ServiceTypeKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\"\u001a\u00020\u001f¢\u0006\u0004\b'\u0010(J!\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0013\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\u0015\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0011H\u0001¢\u0006\u0004\b\u0015\u0010\u0014R\u001e\u0010\u001a\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/platform/from_user/text/PlatformTextMessageFromUserViewDelegate;", "Lcom/avito/android/messenger/conversation/adapter/platform/from_user/text/PlatformTextMessageFromUserView;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewClicks;", "", "charSequence", "Landroid/widget/TextView$BufferType;", "bufferType", "", "setText", "(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V", "", "stringResId", "(I)V", "", "isIncoming", ServiceTypeKt.SERVICE_HIGHLIGHT, "(Z)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setLongClickListener", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/widget/TextView;", "textView", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroid/view/View;", "c", "Landroid/view/View;", "view", "Landroid/animation/ValueAnimator;", AuthSource.BOOKING_ORDER, "Landroid/animation/ValueAnimator;", "animation", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class PlatformTextMessageFromUserViewDelegate implements PlatformTextMessageFromUserView, MessageViewClicks {
    public final TextView a;
    public ValueAnimator b;
    public final View c;
    public final /* synthetic */ MessageViewClicksDelegate d;

    public PlatformTextMessageFromUserViewDelegate(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.d = new MessageViewClicksDelegate(view);
        this.c = view;
        TextView textView = (TextView) view.findViewById(R.id.message);
        this.a = textView;
        Intrinsics.checkNotNullExpressionValue(textView, "textView");
        textView.setMovementMethod(LinkArrowKeyMovementMethod.Companion.getInstance());
    }

    @Override // com.avito.android.messenger.conversation.adapter.platform.from_user.text.PlatformTextMessageFromUserView
    @NotNull
    public Context getContext() {
        Context context = this.c.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        return context;
    }

    @Override // com.avito.android.messenger.conversation.adapter.Highlightable
    public void highlight(boolean z) {
        ValueAnimator valueAnimator;
        TextView textView = this.a;
        Intrinsics.checkNotNullExpressionValue(textView, "textView");
        Drawable background = textView.getBackground();
        if (background != null) {
            background.mutate();
            ValueAnimator valueAnimator2 = this.b;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
            }
            if (z) {
                valueAnimator = HighlightableKt.animateColor(background, getContext(), com.avito.android.lib.design.R.attr.oldBackground, com.avito.android.lib.design.R.attr.gray12);
            } else {
                valueAnimator = HighlightableKt.animateColor(background, getContext(), com.avito.android.lib.design.R.attr.blue50, com.avito.android.lib.design.R.attr.blue200);
            }
            this.b = valueAnimator;
        }
    }

    @Override // com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        PlatformTextMessageFromUserView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.messenger.conversation.adapter.MessageViewClicks
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.d.setClickListener(function0);
    }

    @Override // com.avito.android.messenger.conversation.adapter.MessageViewClicks
    public void setLongClickListener(@NotNull Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.d.setLongClickListener(function0);
    }

    @Override // com.avito.android.messenger.conversation.adapter.platform.from_user.text.PlatformTextMessageFromUserView
    public void setText(@Nullable CharSequence charSequence, @NotNull TextView.BufferType bufferType) {
        Intrinsics.checkNotNullParameter(bufferType, "bufferType");
        this.a.setText(charSequence, bufferType);
    }

    @Override // com.avito.android.messenger.conversation.adapter.platform.from_user.text.PlatformTextMessageFromUserView
    public void setText(int i) {
        this.a.setText(i);
    }
}
