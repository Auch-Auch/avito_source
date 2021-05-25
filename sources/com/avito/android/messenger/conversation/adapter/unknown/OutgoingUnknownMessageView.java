package com.avito.android.messenger.conversation.adapter.unknown;

import android.view.View;
import com.avito.android.component.message_status.MessageDeliveryStatus;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.adapter.MessageViewClicks;
import com.avito.android.messenger.conversation.adapter.MessageViewClicksDelegate;
import com.avito.android.messenger.conversation.adapter.MessageViewDate;
import com.avito.android.messenger.conversation.adapter.MessageViewDateDelegate;
import com.avito.android.messenger.conversation.adapter.MessageViewGroupDivider;
import com.avito.android.messenger.conversation.adapter.MessageViewGroupDividerDelegate;
import com.avito.android.messenger.conversation.adapter.MessageViewStatus;
import com.avito.android.messenger.conversation.adapter.MessageViewStatusDelegate;
import com.avito.android.messenger.conversation.adapter.OutgoingMessageView;
import com.avito.android.remote.model.Sort;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/unknown/OutgoingUnknownMessageView;", "Lcom/avito/android/messenger/conversation/adapter/OutgoingMessageView;", "Lcom/avito/android/messenger/conversation/adapter/unknown/UnknownMessageView;", "Impl", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface OutgoingUnknownMessageView extends OutgoingMessageView, UnknownMessageView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull OutgoingUnknownMessageView outgoingUnknownMessageView) {
            OutgoingMessageView.DefaultImpls.onUnbind(outgoingUnknownMessageView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B\u000f\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u0010\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\u0011\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000fH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\u0014\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00130\u000fH\u0001¢\u0006\u0004\b\u0014\u0010\u0012J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\u0019\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000fH\u0001¢\u0006\u0004\b\u0019\u0010\u0012J\u0018\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\u001b\u0010\u000eJ\u001a\u0010\u001d\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000bH\u0001¢\u0006\u0004\b\u001d\u0010\u000eJ\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/unknown/OutgoingUnknownMessageView$Impl;", "Lcom/avito/android/messenger/conversation/adapter/unknown/OutgoingUnknownMessageView;", "Lcom/avito/android/messenger/conversation/adapter/unknown/UnknownMessageView;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewClicks;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewStatus;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewDate;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewGroupDivider;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "onUnbind", "()V", "", "text", "setTitle", "(Ljava/lang/String;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "setLongClickListener", "Lcom/avito/android/component/message_status/MessageDeliveryStatus;", "status", "setStatus", "(Lcom/avito/android/component/message_status/MessageDeliveryStatus;)V", "setStatusClickListener", Sort.DATE, "setDate", "value", "setTime", "show", "showGroupDivider", "(Z)V", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl extends BaseViewHolder implements OutgoingUnknownMessageView, UnknownMessageView, MessageViewClicks, MessageViewStatus, MessageViewDate, MessageViewGroupDivider {
        public final /* synthetic */ UnknownMessageViewDelegate s;
        public final /* synthetic */ MessageViewClicksDelegate t;
        public final /* synthetic */ MessageViewStatusDelegate u;
        public final /* synthetic */ MessageViewDateDelegate v;
        public final /* synthetic */ MessageViewGroupDividerDelegate w;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Impl(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.s = new UnknownMessageViewDelegate(view);
            this.t = new MessageViewClicksDelegate(view);
            this.u = new MessageViewStatusDelegate(view);
            this.v = new MessageViewDateDelegate(view);
            this.w = new MessageViewGroupDividerDelegate(view);
            view.findViewById(R.id.message).setBackgroundResource(R.drawable.bg_messenger_unknown_message_outgoing);
        }

        @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
        public void onUnbind() {
            this.s.onUnbind();
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewClicks
        public void setClickListener(@NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.t.setClickListener(function0);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewDate
        public void setDate(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, Sort.DATE);
            this.v.setDate(str);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewClicks
        public void setLongClickListener(@NotNull Function0<Boolean> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.t.setLongClickListener(function0);
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

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewDate
        public void setTime(@Nullable String str) {
            this.v.setTime(str);
        }

        @Override // com.avito.android.messenger.conversation.adapter.unknown.UnknownMessageView
        public void setTitle(@Nullable String str) {
            this.s.setTitle(str);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewGroupDivider
        public void showGroupDivider(boolean z) {
            this.w.showGroupDivider(z);
        }
    }
}
