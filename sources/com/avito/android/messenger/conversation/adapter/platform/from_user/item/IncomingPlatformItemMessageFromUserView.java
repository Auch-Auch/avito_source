package com.avito.android.messenger.conversation.adapter.platform.from_user.item;

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
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Sort;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/platform/from_user/item/IncomingPlatformItemMessageFromUserView;", "Lcom/avito/android/messenger/conversation/adapter/IncomingMessageView;", "Lcom/avito/android/messenger/conversation/adapter/platform/from_user/item/PlatformItemMessageFromUserView;", "Impl", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface IncomingPlatformItemMessageFromUserView extends IncomingMessageView, PlatformItemMessageFromUserView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull IncomingPlatformItemMessageFromUserView incomingPlatformItemMessageFromUserView) {
            IncomingMessageView.DefaultImpls.onUnbind(incomingPlatformItemMessageFromUserView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B\u000f\u0012\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b/\u00100J\u0010\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0014\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0001¢\u0006\u0004\b\u0016\u0010\u0012J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0018\u0010\u0012J\u001e\u0010\u001b\u001a\u00020\b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u0019H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001e\u0010\u001e\u001a\u00020\b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0019H\u0001¢\u0006\u0004\b\u001e\u0010\u001cJ\u0018\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001fH\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010$\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\u001fH\u0001¢\u0006\u0004\b$\u0010\"J\u001a\u0010'\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010%H\u0001¢\u0006\u0004\b'\u0010(J\u001e\u0010)\u001a\u00020\b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u0019H\u0001¢\u0006\u0004\b)\u0010\u001cJ\u0018\u0010+\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u001dH\u0001¢\u0006\u0004\b+\u0010,¨\u00061"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/platform/from_user/item/IncomingPlatformItemMessageFromUserView$Impl;", "Lcom/avito/android/messenger/conversation/adapter/platform/from_user/item/IncomingPlatformItemMessageFromUserView;", "Lcom/avito/android/messenger/conversation/adapter/platform/from_user/item/PlatformItemMessageFromUserView;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewClicks;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewDate;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewAvatar;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewGroupDivider;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "onUnbind", "()V", "Lcom/avito/android/remote/model/Image;", "image", "setImage", "(Lcom/avito/android/remote/model/Image;)V", "", "location", "setLocation", "(Ljava/lang/CharSequence;)V", "newPrice", "setNewPrice", "oldPrice", "setOldPrice", "title", "setTitle", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "setLongClickListener", "", Sort.DATE, "setDate", "(Ljava/lang/String;)V", "value", "setTime", "Lcom/avito/android/image_loader/Picture;", "picture", "setAvatar", "(Lcom/avito/android/image_loader/Picture;)V", "setAvatarClickListener", "show", "showGroupDivider", "(Z)V", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl extends BaseViewHolder implements IncomingPlatformItemMessageFromUserView, PlatformItemMessageFromUserView, MessageViewClicks, MessageViewDate, MessageViewAvatar, MessageViewGroupDivider {
        public final /* synthetic */ PlatformItemMessageFromUserViewDelegate s;
        public final /* synthetic */ MessageViewClicksDelegate t;
        public final /* synthetic */ MessageViewDateDelegate u;
        public final /* synthetic */ MessageViewAvatarDelegate v;
        public final /* synthetic */ MessageViewGroupDividerDelegate w;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Impl(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View findViewById = view.findViewById(R.id.message);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.message)");
            this.s = new PlatformItemMessageFromUserViewDelegate(findViewById, R.drawable.bg_messenger_item_message_incoming);
            this.t = new MessageViewClicksDelegate(view);
            this.u = new MessageViewDateDelegate(view);
            this.v = new MessageViewAvatarDelegate(view);
            this.w = new MessageViewGroupDividerDelegate(view);
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

        @Override // com.avito.android.messenger.conversation.adapter.platform.from_user.item.PlatformItemMessageFromUserView
        public void setImage(@Nullable Image image) {
            this.s.setImage(image);
        }

        @Override // com.avito.android.messenger.conversation.adapter.platform.from_user.item.PlatformItemMessageFromUserView
        public void setLocation(@Nullable CharSequence charSequence) {
            this.s.setLocation(charSequence);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewClicks
        public void setLongClickListener(@NotNull Function0<Boolean> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.t.setLongClickListener(function0);
        }

        @Override // com.avito.android.messenger.conversation.adapter.platform.from_user.item.PlatformItemMessageFromUserView
        public void setNewPrice(@NotNull CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(charSequence, "newPrice");
            this.s.setNewPrice(charSequence);
        }

        @Override // com.avito.android.messenger.conversation.adapter.platform.from_user.item.PlatformItemMessageFromUserView
        public void setOldPrice(@Nullable CharSequence charSequence) {
            this.s.setOldPrice(charSequence);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewDate
        public void setTime(@Nullable String str) {
            this.u.setTime(str);
        }

        @Override // com.avito.android.messenger.conversation.adapter.platform.from_user.item.PlatformItemMessageFromUserView
        public void setTitle(@NotNull CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(charSequence, "title");
            this.s.setTitle(charSequence);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewGroupDivider
        public void showGroupDivider(boolean z) {
            this.w.showGroupDivider(z);
        }
    }
}
