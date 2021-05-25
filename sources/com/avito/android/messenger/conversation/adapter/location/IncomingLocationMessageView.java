package com.avito.android.messenger.conversation.adapter.location;

import android.view.View;
import com.avito.android.image_loader.Picture;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.adapter.IncomingMessageView;
import com.avito.android.messenger.conversation.adapter.MessageViewAvatar;
import com.avito.android.messenger.conversation.adapter.MessageViewDate;
import com.avito.android.messenger.conversation.adapter.MessageViewGroupDivider;
import com.avito.android.messenger.conversation.adapter.MessageViewGroupDividerDelegate;
import com.avito.android.messenger.conversation.adapter.location.LocationMessageView;
import com.avito.android.remote.model.ServiceTypeKt;
import com.avito.android.remote.model.Sort;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/location/IncomingLocationMessageView;", "Lcom/avito/android/messenger/conversation/adapter/location/LocationMessageView;", "Lcom/avito/android/messenger/conversation/adapter/IncomingMessageView;", "Impl", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface IncomingLocationMessageView extends LocationMessageView, IncomingMessageView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull IncomingLocationMessageView incomingLocationMessageView) {
            LocationMessageView.DefaultImpls.onUnbind(incomingLocationMessageView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u000f\u0012\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\tH\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\u0016\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\fH\u0001¢\u0006\u0004\b\u0016\u0010\u000fJ\u001e\u0010\u0017\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00100\fH\u0001¢\u0006\u0004\b\u0017\u0010\u000fJ\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\u0018\u0010\u000bJ\u0018\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\tH\u0001¢\u0006\u0004\b\u001d\u0010\u0015J\u0018\u0010 \u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001eH\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010#\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010\u001eH\u0001¢\u0006\u0004\b#\u0010!J\u0018\u0010%\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u0010H\u0001¢\u0006\u0004\b%\u0010\u0013R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006."}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/location/IncomingLocationMessageView$Impl;", "Lcom/avito/android/messenger/conversation/adapter/location/IncomingLocationMessageView;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewAvatar;", "Lcom/avito/android/messenger/conversation/adapter/location/LocationMessageView;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewDate;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewGroupDivider;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/image_loader/Picture;", "picture", "", "setAvatar", "(Lcom/avito/android/image_loader/Picture;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setAvatarClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "isIncoming", ServiceTypeKt.SERVICE_HIGHLIGHT, "(Z)V", "onUnbind", "()V", "setClickListener", "setLongClickListener", "setMapImage", "", "text", "setText", "(Ljava/lang/CharSequence;)V", "showCopiedText", "", Sort.DATE, "setDate", "(Ljava/lang/String;)V", "value", "setTime", "show", "showGroupDivider", "Lcom/facebook/drawee/view/SimpleDraweeView;", "s", "Lcom/facebook/drawee/view/SimpleDraweeView;", "mapAvatar", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl extends BaseViewHolder implements IncomingLocationMessageView, MessageViewAvatar, LocationMessageView, MessageViewDate, MessageViewGroupDivider {
        public final SimpleDraweeView s;
        public final /* synthetic */ LocationMessageViewDelegate t;
        public final /* synthetic */ LocationMessageViewDateDelegate u;
        public final /* synthetic */ MessageViewGroupDividerDelegate v;

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ Function0 a;

            public a(Function0 function0) {
                this.a = function0;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.invoke();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Impl(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.t = new LocationMessageViewDelegate(view);
            this.u = new LocationMessageViewDateDelegate(view);
            this.v = new MessageViewGroupDividerDelegate(view);
            View findViewById = view.findViewById(R.id.messenger_location_bubble_avatar);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.m…r_location_bubble_avatar)");
            this.s = (SimpleDraweeView) findViewById;
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
            if (picture != null) {
                Views.show(this.s);
                a2.b.a.a.a.L0(this.s, picture);
                return;
            }
            Views.conceal(this.s);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewAvatar
        public void setAvatarClickListener(@NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.s.setOnClickListener(new a(function0));
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

        @Override // com.avito.android.messenger.conversation.adapter.location.LocationMessageView
        public void setMapImage(@NotNull Picture picture) {
            Intrinsics.checkNotNullParameter(picture, "picture");
            this.t.setMapImage(picture);
        }

        @Override // com.avito.android.messenger.conversation.adapter.location.LocationMessageView
        public void setText(@NotNull CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(charSequence, "text");
            this.t.setText(charSequence);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewDate
        public void setTime(@Nullable String str) {
            this.u.setTime(str);
        }

        @Override // com.avito.android.messenger.conversation.adapter.location.LocationMessageView
        public void showCopiedText() {
            this.t.showCopiedText();
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewGroupDivider
        public void showGroupDivider(boolean z) {
            this.v.showGroupDivider(z);
        }
    }
}
