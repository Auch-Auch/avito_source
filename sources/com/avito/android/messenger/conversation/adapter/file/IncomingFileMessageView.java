package com.avito.android.messenger.conversation.adapter.file;

import android.view.View;
import com.avito.android.image_loader.Picture;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.adapter.IncomingMessageView;
import com.avito.android.messenger.conversation.adapter.MessageViewAvatar;
import com.avito.android.messenger.conversation.adapter.MessageViewAvatarDelegate;
import com.avito.android.messenger.conversation.adapter.MessageViewClicks;
import com.avito.android.messenger.conversation.adapter.MessageViewClicksDelegate;
import com.avito.android.messenger.conversation.adapter.MessageViewDate;
import com.avito.android.messenger.conversation.adapter.MessageViewDateDelegate;
import com.avito.android.messenger.conversation.adapter.MessageViewGroupDivider;
import com.avito.android.messenger.conversation.adapter.MessageViewGroupDividerDelegate;
import com.avito.android.messenger.conversation.adapter.file.FileMessageView;
import com.avito.android.remote.model.Sort;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/file/IncomingFileMessageView;", "Lcom/avito/android/messenger/conversation/adapter/IncomingMessageView;", "Lcom/avito/android/messenger/conversation/adapter/file/FileMessageView;", "Impl", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface IncomingFileMessageView extends IncomingMessageView, FileMessageView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull IncomingFileMessageView incomingFileMessageView) {
            IncomingMessageView.DefaultImpls.onUnbind(incomingFileMessageView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B\u000f\u0012\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J\u0010\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\t\u0010\nJ&\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\rH\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001e\u0010\u0019\u001a\u00020\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\rH\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001e\u0010\u001c\u001a\u00020\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001b0\rH\u0001¢\u0006\u0004\b\u001c\u0010\u001aJ\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010!\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u001dH\u0001¢\u0006\u0004\b!\u0010 J\u001a\u0010$\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0001¢\u0006\u0004\b$\u0010%J\u001e\u0010&\u001a\u00020\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\rH\u0001¢\u0006\u0004\b&\u0010\u001aJ\u0018\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u001bH\u0001¢\u0006\u0004\b(\u0010)¨\u0006."}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/file/IncomingFileMessageView$Impl;", "Lcom/avito/android/messenger/conversation/adapter/file/IncomingFileMessageView;", "Lcom/avito/android/messenger/conversation/adapter/file/FileMessageView;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewClicks;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewDate;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewAvatar;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewGroupDivider;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "onUnbind", "()V", "Lcom/avito/android/messenger/conversation/adapter/file/FileMessageView$IconState;", "value", "Lkotlin/Function0;", "onCancelClick", "setIconState", "(Lcom/avito/android/messenger/conversation/adapter/file/FileMessageView$IconState;Lkotlin/jvm/functions/Function0;)V", "", "setName", "(Ljava/lang/CharSequence;)V", "", "sizeInBytes", "setSize", "(J)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "setLongClickListener", "", Sort.DATE, "setDate", "(Ljava/lang/String;)V", "setTime", "Lcom/avito/android/image_loader/Picture;", "picture", "setAvatar", "(Lcom/avito/android/image_loader/Picture;)V", "setAvatarClickListener", "show", "showGroupDivider", "(Z)V", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl extends BaseViewHolder implements IncomingFileMessageView, FileMessageView, MessageViewClicks, MessageViewDate, MessageViewAvatar, MessageViewGroupDivider {
        public final /* synthetic */ FileMessageViewDelegate s;
        public final /* synthetic */ MessageViewClicksDelegate t;
        public final /* synthetic */ MessageViewDateDelegate u;
        public final /* synthetic */ MessageViewAvatarDelegate v;
        public final /* synthetic */ MessageViewGroupDividerDelegate w;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Impl(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.s = new FileMessageViewDelegate(view);
            this.t = new MessageViewClicksDelegate(view);
            this.u = new MessageViewDateDelegate(view);
            this.v = new MessageViewAvatarDelegate(view);
            this.w = new MessageViewGroupDividerDelegate(view);
            view.findViewById(R.id.message).setBackgroundResource(R.drawable.bg_messenger_item_message_incoming);
        }

        @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
        public void onUnbind() {
            this.s.onUnbind();
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewAvatar
        public void setAvatar(@Nullable Picture picture) {
            this.v.setAvatar(picture);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewAvatar
        public void setAvatarClickListener(@NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.v.setAvatarClickListener(function0);
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

        @Override // com.avito.android.messenger.conversation.adapter.file.FileMessageView
        public void setIconState(@NotNull FileMessageView.IconState iconState, @NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(iconState, "value");
            Intrinsics.checkNotNullParameter(function0, "onCancelClick");
            this.s.setIconState(iconState, function0);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewClicks
        public void setLongClickListener(@NotNull Function0<Boolean> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.t.setLongClickListener(function0);
        }

        @Override // com.avito.android.messenger.conversation.adapter.file.FileMessageView
        public void setName(@NotNull CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(charSequence, "value");
            this.s.setName(charSequence);
        }

        @Override // com.avito.android.messenger.conversation.adapter.file.FileMessageView
        public void setSize(long j) {
            this.s.setSize(j);
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
