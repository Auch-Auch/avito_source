package com.avito.android.messenger.conversation.adapter.app_call;

import android.view.View;
import com.avito.android.component.message_status.MessageDeliveryStatus;
import com.avito.android.messenger.conversation.adapter.MessageViewClicks;
import com.avito.android.messenger.conversation.adapter.MessageViewClicksDelegate;
import com.avito.android.messenger.conversation.adapter.MessageViewDate;
import com.avito.android.messenger.conversation.adapter.MessageViewDateDelegate;
import com.avito.android.messenger.conversation.adapter.MessageViewGroupDivider;
import com.avito.android.messenger.conversation.adapter.MessageViewGroupDividerDelegate;
import com.avito.android.messenger.conversation.adapter.MessageViewStatus;
import com.avito.android.messenger.conversation.adapter.MessageViewStatusDelegate;
import com.avito.android.messenger.conversation.adapter.OutgoingMessageView;
import com.avito.android.messenger.conversation.adapter.app_call.AppCallMessageView;
import com.avito.android.remote.model.Sort;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/app_call/OutgoingAppCallMessageView;", "Lcom/avito/android/messenger/conversation/adapter/app_call/AppCallMessageView;", "Lcom/avito/android/messenger/conversation/adapter/OutgoingMessageView;", "Impl", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface OutgoingAppCallMessageView extends AppCallMessageView, OutgoingMessageView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull OutgoingAppCallMessageView outgoingAppCallMessageView) {
            AppCallMessageView.DefaultImpls.onUnbind(outgoingAppCallMessageView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B\u000f\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u0010\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\u0010\u0010\u000eJ\u001e\u0010\u0013\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\u0016\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00150\u0011H\u0001¢\u0006\u0004\b\u0016\u0010\u0014J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0017H\u0001¢\u0006\u0004\b\u001c\u0010\u001aJ\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0001¢\u0006\u0004\b\u001f\u0010 J\u001e\u0010!\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H\u0001¢\u0006\u0004\b!\u0010\u0014J\u0018\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u0015H\u0001¢\u0006\u0004\b#\u0010$¨\u0006)"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/app_call/OutgoingAppCallMessageView$Impl;", "Lcom/avito/android/messenger/conversation/adapter/app_call/OutgoingAppCallMessageView;", "Lcom/avito/android/messenger/conversation/adapter/app_call/AppCallMessageView;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewClicks;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewDate;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewStatus;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewGroupDivider;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "onUnbind", "()V", "", "actionTitle", "setActionTitle", "(Ljava/lang/CharSequence;)V", "text", "setText", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "setLongClickListener", "", Sort.DATE, "setDate", "(Ljava/lang/String;)V", "value", "setTime", "Lcom/avito/android/component/message_status/MessageDeliveryStatus;", "status", "setStatus", "(Lcom/avito/android/component/message_status/MessageDeliveryStatus;)V", "setStatusClickListener", "show", "showGroupDivider", "(Z)V", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl extends BaseViewHolder implements OutgoingAppCallMessageView, AppCallMessageView, MessageViewClicks, MessageViewDate, MessageViewStatus, MessageViewGroupDivider {
        public final /* synthetic */ AppCallMessageViewDelegate s;
        public final /* synthetic */ MessageViewClicksDelegate t;
        public final /* synthetic */ MessageViewDateDelegate u;
        public final /* synthetic */ MessageViewStatusDelegate v;
        public final /* synthetic */ MessageViewGroupDividerDelegate w;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Impl(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.s = new AppCallMessageViewDelegate(view);
            this.t = new MessageViewClicksDelegate(view);
            this.u = new MessageViewDateDelegate(view);
            this.v = new MessageViewStatusDelegate(view);
            this.w = new MessageViewGroupDividerDelegate(view);
        }

        @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
        public void onUnbind() {
            this.s.onUnbind();
        }

        @Override // com.avito.android.messenger.conversation.adapter.app_call.AppCallMessageView
        public void setActionTitle(@Nullable CharSequence charSequence) {
            this.s.setActionTitle(charSequence);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewClicks
        public void setClickListener(@NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.t.setClickListener(function0);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewDate
        public void setDate(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, Sort.DATE);
            this.u.setDate(str);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewClicks
        public void setLongClickListener(@NotNull Function0<Boolean> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.t.setLongClickListener(function0);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewStatus
        public void setStatus(@NotNull MessageDeliveryStatus messageDeliveryStatus) {
            Intrinsics.checkNotNullParameter(messageDeliveryStatus, "status");
            this.v.setStatus(messageDeliveryStatus);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewStatus
        public void setStatusClickListener(@NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.v.setStatusClickListener(function0);
        }

        @Override // com.avito.android.messenger.conversation.adapter.app_call.AppCallMessageView
        public void setText(@NotNull CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(charSequence, "text");
            this.s.setText(charSequence);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewDate
        public void setTime(@Nullable String str) {
            this.u.setTime(str);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewGroupDivider
        public void showGroupDivider(boolean z) {
            this.w.showGroupDivider(z);
        }
    }
}
