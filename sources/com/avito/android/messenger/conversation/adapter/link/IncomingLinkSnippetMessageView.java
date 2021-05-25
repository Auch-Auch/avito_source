package com.avito.android.messenger.conversation.adapter.link;

import android.view.View;
import com.avito.android.image_loader.Picture;
import com.avito.android.messenger.R;
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
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/link/IncomingLinkSnippetMessageView;", "Lcom/avito/android/messenger/conversation/adapter/IncomingMessageView;", "Lcom/avito/android/messenger/conversation/adapter/link/LinkSnippetMessageView;", "Impl", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface IncomingLinkSnippetMessageView extends IncomingMessageView, LinkSnippetMessageView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull IncomingLinkSnippetMessageView incomingLinkSnippetMessageView) {
            IncomingMessageView.DefaultImpls.onUnbind(incomingLinkSnippetMessageView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u0017\u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u0010/\u001a\u00020-¢\u0006\u0004\b0\u00101J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tH\u0001¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u0010\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0001¢\u0006\u0004\b\u001a\u0010\u0011J$\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00122\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0012H\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\tH\u0001¢\u0006\u0004\b\u001f\u0010\rJ4\u0010#\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u00122\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0001¢\u0006\u0004\b#\u0010$J\u0018\u0010&\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0012H\u0001¢\u0006\u0004\b&\u0010\u0015J\u001a\u0010(\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010\u0012H\u0001¢\u0006\u0004\b(\u0010\u0015J\u001a\u0010)\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0001¢\u0006\u0004\b)\u0010\u0019J\u001e\u0010*\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0001¢\u0006\u0004\b*\u0010\u0011J\u0018\u0010,\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0007H\u0001¢\u0006\u0004\b,\u0010\u000b¨\u00062"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/link/IncomingLinkSnippetMessageView$Impl;", "Lcom/avito/android/messenger/conversation/adapter/link/IncomingLinkSnippetMessageView;", "Lcom/avito/android/messenger/conversation/adapter/link/LinkSnippetMessageView;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewDate;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewAvatar;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewGroupDivider;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "isIncoming", "", ServiceTypeKt.SERVICE_HIGHLIGHT, "(Z)V", "onUnbind", "()V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "domain", "setDomain", "(Ljava/lang/String;)V", "Lcom/avito/android/image_loader/Picture;", "picture", "setImage", "(Lcom/avito/android/image_loader/Picture;)V", "setLongClickListener", "title", MessengerShareContentUtility.SUBTITLE, "setText", "(Ljava/lang/String;Ljava/lang/String;)V", "showCopiedMessage", "url", "onOpenInBrowserClick", "onCopyClick", "showLinkMenuLegacy", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", Sort.DATE, "setDate", "value", "setTime", "setAvatar", "setAvatarClickListener", "show", "showGroupDivider", "Landroid/view/View;", "view", "parentView", "<init>", "(Landroid/view/View;Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl extends BaseViewHolder implements IncomingLinkSnippetMessageView, LinkSnippetMessageView, MessageViewDate, MessageViewAvatar, MessageViewGroupDivider {
        public final /* synthetic */ LinkSnippetMessageViewDelegate s;
        public final /* synthetic */ MessageViewDateDelegate t;
        public final /* synthetic */ MessageViewAvatarDelegate u;
        public final /* synthetic */ MessageViewGroupDividerDelegate v;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Impl(@NotNull View view, @NotNull View view2) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(view2, "parentView");
            this.s = new LinkSnippetMessageViewDelegate(view, view2);
            this.t = new MessageViewDateDelegate(view);
            this.u = new MessageViewAvatarDelegate(view);
            this.v = new MessageViewGroupDividerDelegate(view);
            view.findViewById(R.id.message).setBackgroundResource(R.drawable.bg_messenger_item_message_incoming);
        }

        @Override // com.avito.android.messenger.conversation.adapter.Highlightable
        public void highlight(boolean z) {
            this.s.highlight(z);
        }

        @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
        public void onUnbind() {
            this.s.onUnbind();
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewAvatar
        public void setAvatar(@Nullable Picture picture) {
            this.u.setAvatar(picture);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewAvatar
        public void setAvatarClickListener(@NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.u.setAvatarClickListener(function0);
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

        @Override // com.avito.android.messenger.conversation.adapter.link.LinkSnippetMessageView
        public void setDomain(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "domain");
            this.s.setDomain(str);
        }

        @Override // com.avito.android.messenger.conversation.adapter.link.LinkSnippetMessageView
        public void setImage(@Nullable Picture picture) {
            this.s.setImage(picture);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewClicks
        public void setLongClickListener(@NotNull Function0<Boolean> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.s.setLongClickListener(function0);
        }

        @Override // com.avito.android.messenger.conversation.adapter.link.LinkSnippetMessageView
        public void setText(@NotNull String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(str, "title");
            this.s.setText(str, str2);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewDate
        public void setTime(@Nullable String str) {
            this.t.setTime(str);
        }

        @Override // com.avito.android.messenger.conversation.adapter.link.LinkSnippetMessageView
        public void showCopiedMessage() {
            this.s.showCopiedMessage();
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewGroupDivider
        public void showGroupDivider(boolean z) {
            this.v.showGroupDivider(z);
        }

        @Override // com.avito.android.messenger.conversation.adapter.link.LinkSnippetMessageView
        public void showLinkMenuLegacy(@NotNull String str, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
            Intrinsics.checkNotNullParameter(str, "url");
            Intrinsics.checkNotNullParameter(function0, "onOpenInBrowserClick");
            Intrinsics.checkNotNullParameter(function02, "onCopyClick");
            this.s.showLinkMenuLegacy(str, function0, function02);
        }
    }
}
