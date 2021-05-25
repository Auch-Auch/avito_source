package com.avito.android.messenger.conversation.adapter.platform.from_user.text;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.avito.android.component.message_status.MessageDeliveryStatus;
import com.avito.android.messenger.conversation.adapter.MessageViewDate;
import com.avito.android.messenger.conversation.adapter.MessageViewDateDelegate;
import com.avito.android.messenger.conversation.adapter.MessageViewGroupDivider;
import com.avito.android.messenger.conversation.adapter.MessageViewGroupDividerDelegate;
import com.avito.android.messenger.conversation.adapter.MessageViewStatus;
import com.avito.android.messenger.conversation.adapter.MessageViewStatusDelegate;
import com.avito.android.messenger.conversation.adapter.OutgoingMessageView;
import com.avito.android.remote.model.ServiceTypeKt;
import com.avito.android.remote.model.Sort;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/platform/from_user/text/OutgoingPlatformTextMessageFromUserView;", "Lcom/avito/android/messenger/conversation/adapter/OutgoingMessageView;", "Lcom/avito/android/messenger/conversation/adapter/platform/from_user/text/PlatformTextMessageFromUserView;", "Impl", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface OutgoingPlatformTextMessageFromUserView extends OutgoingMessageView, PlatformTextMessageFromUserView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull OutgoingPlatformTextMessageFromUserView outgoingPlatformTextMessageFromUserView) {
            OutgoingMessageView.DefaultImpls.onUnbind(outgoingPlatformTextMessageFromUserView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u000f\u0012\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b/\u00100J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tH\u0001¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u0010\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\u0012\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0001¢\u0006\u0004\b\u0012\u0010\u0011J$\u0010\u0017\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0017\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u0017\u0010\u001bJ\u0018\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001cH\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010!\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u001cH\u0001¢\u0006\u0004\b!\u0010\u001fJ\u0018\u0010$\u001a\u00020\t2\u0006\u0010#\u001a\u00020\"H\u0001¢\u0006\u0004\b$\u0010%J\u001e\u0010&\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0001¢\u0006\u0004\b&\u0010\u0011J\u0018\u0010(\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u0007H\u0001¢\u0006\u0004\b(\u0010\u000bR\u0016\u0010,\u001a\u00020)8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u00061"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/platform/from_user/text/OutgoingPlatformTextMessageFromUserView$Impl;", "Lcom/avito/android/messenger/conversation/adapter/platform/from_user/text/OutgoingPlatformTextMessageFromUserView;", "Lcom/avito/android/messenger/conversation/adapter/platform/from_user/text/PlatformTextMessageFromUserView;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewDate;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewStatus;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewGroupDivider;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "isIncoming", "", ServiceTypeKt.SERVICE_HIGHLIGHT, "(Z)V", "onUnbind", "()V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setLongClickListener", "", "charSequence", "Landroid/widget/TextView$BufferType;", "bufferType", "setText", "(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V", "", "stringResId", "(I)V", "", Sort.DATE, "setDate", "(Ljava/lang/String;)V", "value", "setTime", "Lcom/avito/android/component/message_status/MessageDeliveryStatus;", "status", "setStatus", "(Lcom/avito/android/component/message_status/MessageDeliveryStatus;)V", "setStatusClickListener", "show", "showGroupDivider", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl extends BaseViewHolder implements OutgoingPlatformTextMessageFromUserView, PlatformTextMessageFromUserView, MessageViewDate, MessageViewStatus, MessageViewGroupDivider {
        public final /* synthetic */ PlatformTextMessageFromUserViewDelegate s;
        public final /* synthetic */ MessageViewDateDelegate t;
        public final /* synthetic */ MessageViewStatusDelegate u;
        public final /* synthetic */ MessageViewGroupDividerDelegate v;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Impl(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.s = new PlatformTextMessageFromUserViewDelegate(view);
            this.t = new MessageViewDateDelegate(view);
            this.u = new MessageViewStatusDelegate(view);
            this.v = new MessageViewGroupDividerDelegate(view);
        }

        @Override // com.avito.android.messenger.conversation.adapter.platform.from_user.text.PlatformTextMessageFromUserView
        @NotNull
        public Context getContext() {
            return this.s.getContext();
        }

        @Override // com.avito.android.messenger.conversation.adapter.Highlightable
        public void highlight(boolean z) {
            this.s.highlight(z);
        }

        @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
        public void onUnbind() {
            this.s.onUnbind();
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewClicks
        public void setClickListener(@NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.s.setClickListener(function0);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewDate
        public void setDate(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, Sort.DATE);
            this.t.setDate(str);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewClicks
        public void setLongClickListener(@NotNull Function0<Boolean> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.s.setLongClickListener(function0);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewStatus
        public void setStatus(@NotNull MessageDeliveryStatus messageDeliveryStatus) {
            Intrinsics.checkNotNullParameter(messageDeliveryStatus, "status");
            this.u.setStatus(messageDeliveryStatus);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewStatus
        public void setStatusClickListener(@NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.u.setStatusClickListener(function0);
        }

        @Override // com.avito.android.messenger.conversation.adapter.platform.from_user.text.PlatformTextMessageFromUserView
        public void setText(int i) {
            this.s.setText(i);
        }

        @Override // com.avito.android.messenger.conversation.adapter.platform.from_user.text.PlatformTextMessageFromUserView
        public void setText(@Nullable CharSequence charSequence, @NotNull TextView.BufferType bufferType) {
            Intrinsics.checkNotNullParameter(bufferType, "bufferType");
            this.s.setText(charSequence, bufferType);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewDate
        public void setTime(@Nullable String str) {
            this.t.setTime(str);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewGroupDivider
        public void showGroupDivider(boolean z) {
            this.v.showGroupDivider(z);
        }
    }
}
