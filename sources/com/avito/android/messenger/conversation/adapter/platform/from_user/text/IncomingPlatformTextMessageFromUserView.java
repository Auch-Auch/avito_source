package com.avito.android.messenger.conversation.adapter.platform.from_user.text;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.avito.android.image_loader.Picture;
import com.avito.android.messenger.conversation.adapter.IncomingMessageView;
import com.avito.android.messenger.conversation.adapter.MessageViewAvatar;
import com.avito.android.messenger.conversation.adapter.MessageViewAvatarDelegate;
import com.avito.android.messenger.conversation.adapter.MessageViewDate;
import com.avito.android.messenger.conversation.adapter.MessageViewDateDelegate;
import com.avito.android.messenger.conversation.adapter.MessageViewGroupDivider;
import com.avito.android.messenger.conversation.adapter.MessageViewGroupDividerDelegate;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/platform/from_user/text/IncomingPlatformTextMessageFromUserView;", "Lcom/avito/android/messenger/conversation/adapter/IncomingMessageView;", "Lcom/avito/android/messenger/conversation/adapter/platform/from_user/text/PlatformTextMessageFromUserView;", "Impl", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface IncomingPlatformTextMessageFromUserView extends IncomingMessageView, PlatformTextMessageFromUserView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull IncomingPlatformTextMessageFromUserView incomingPlatformTextMessageFromUserView) {
            IncomingMessageView.DefaultImpls.onUnbind(incomingPlatformTextMessageFromUserView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u000f\u0012\u0006\u0010,\u001a\u00020)¢\u0006\u0004\b1\u00102J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tH\u0001¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u0010\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\u0012\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0001¢\u0006\u0004\b\u0012\u0010\u0011J$\u0010\u0017\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0017\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u0017\u0010\u001bJ\u0018\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001cH\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010!\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u001cH\u0001¢\u0006\u0004\b!\u0010\u001fJ\u001a\u0010$\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0001¢\u0006\u0004\b$\u0010%J\u001e\u0010&\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0001¢\u0006\u0004\b&\u0010\u0011J\u0018\u0010(\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u0007H\u0001¢\u0006\u0004\b(\u0010\u000bR\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00063"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/platform/from_user/text/IncomingPlatformTextMessageFromUserView$Impl;", "Lcom/avito/android/messenger/conversation/adapter/platform/from_user/text/IncomingPlatformTextMessageFromUserView;", "Lcom/avito/android/messenger/conversation/adapter/platform/from_user/text/PlatformTextMessageFromUserView;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewDate;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewAvatar;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewGroupDivider;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "isIncoming", "", ServiceTypeKt.SERVICE_HIGHLIGHT, "(Z)V", "onUnbind", "()V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setLongClickListener", "", "charSequence", "Landroid/widget/TextView$BufferType;", "bufferType", "setText", "(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V", "", "stringResId", "(I)V", "", Sort.DATE, "setDate", "(Ljava/lang/String;)V", "value", "setTime", "Lcom/avito/android/image_loader/Picture;", "picture", "setAvatar", "(Lcom/avito/android/image_loader/Picture;)V", "setAvatarClickListener", "show", "showGroupDivider", "Landroid/view/View;", "s", "Landroid/view/View;", "view", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl extends BaseViewHolder implements IncomingPlatformTextMessageFromUserView, PlatformTextMessageFromUserView, MessageViewDate, MessageViewAvatar, MessageViewGroupDivider {
        public final View s;
        public final /* synthetic */ PlatformTextMessageFromUserViewDelegate t;
        public final /* synthetic */ MessageViewDateDelegate u;
        public final /* synthetic */ MessageViewAvatarDelegate v;
        public final /* synthetic */ MessageViewGroupDividerDelegate w;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Impl(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.t = new PlatformTextMessageFromUserViewDelegate(view);
            this.u = new MessageViewDateDelegate(view);
            this.v = new MessageViewAvatarDelegate(view);
            this.w = new MessageViewGroupDividerDelegate(view);
            this.s = view;
        }

        @Override // com.avito.android.messenger.conversation.adapter.platform.from_user.text.PlatformTextMessageFromUserView
        @NotNull
        public Context getContext() {
            return this.t.getContext();
        }

        @Override // com.avito.android.messenger.conversation.adapter.Highlightable
        public void highlight(boolean z) {
            this.t.highlight(z);
        }

        @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
        public void onUnbind() {
            this.t.onUnbind();
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

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewClicks
        public void setLongClickListener(@NotNull Function0<Boolean> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.t.setLongClickListener(function0);
        }

        @Override // com.avito.android.messenger.conversation.adapter.platform.from_user.text.PlatformTextMessageFromUserView
        public void setText(int i) {
            this.t.setText(i);
        }

        @Override // com.avito.android.messenger.conversation.adapter.platform.from_user.text.PlatformTextMessageFromUserView
        public void setText(@Nullable CharSequence charSequence, @NotNull TextView.BufferType bufferType) {
            Intrinsics.checkNotNullParameter(bufferType, "bufferType");
            this.t.setText(charSequence, bufferType);
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
