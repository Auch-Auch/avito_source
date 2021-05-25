package com.avito.android.messenger.conversation.adapter.image;

import android.view.View;
import com.avito.android.component.message_status.MessageDeliveryStatus;
import com.avito.android.image_loader.ImageRequest;
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
import com.avito.android.messenger.conversation.adapter.image.ImageMessageView;
import com.avito.android.remote.model.Sort;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/image/IncomingImageMessageView;", "Lcom/avito/android/messenger/conversation/adapter/image/ImageMessageView;", "Lcom/avito/android/messenger/conversation/adapter/IncomingMessageView;", "Impl", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface IncomingImageMessageView extends ImageMessageView, IncomingMessageView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull IncomingImageMessageView incomingImageMessageView) {
            ImageMessageView.DefaultImpls.onUnbind(incomingImageMessageView);
        }

        public static void setStatus(@NotNull IncomingImageMessageView incomingImageMessageView, @NotNull MessageDeliveryStatus messageDeliveryStatus) {
            Intrinsics.checkNotNullParameter(messageDeliveryStatus, "status");
            ImageMessageView.DefaultImpls.setStatus(incomingImageMessageView, messageDeliveryStatus);
        }

        public static void setStatusClickListener(@NotNull IncomingImageMessageView incomingImageMessageView, @NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            ImageMessageView.DefaultImpls.setStatusClickListener(incomingImageMessageView, function0);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u000f\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J!\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u000f\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\rH\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0012\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00110\rH\u0001¢\u0006\u0004\b\u0012\u0010\u0010J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013H\u0001¢\u0006\u0004\b\u0018\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001e\u0010\u001b\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\rH\u0001¢\u0006\u0004\b\u001b\u0010\u0010J\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u001e\u0010#\u001a\n  *\u0004\u0018\u00010\u001f0\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006("}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/image/IncomingImageMessageView$Impl;", "Lcom/avito/android/messenger/conversation/adapter/image/IncomingImageMessageView;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewClicks;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewDate;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewAvatar;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewGroupDivider;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/image_loader/Picture;", "picture", "thumbnail", "", "setImage", "(Lcom/avito/android/image_loader/Picture;Lcom/avito/android/image_loader/Picture;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "setLongClickListener", "", Sort.DATE, "setDate", "(Ljava/lang/String;)V", "value", "setTime", "setAvatar", "(Lcom/avito/android/image_loader/Picture;)V", "setAvatarClickListener", "show", "showGroupDivider", "(Z)V", "Lcom/facebook/drawee/view/SimpleDraweeView;", "kotlin.jvm.PlatformType", "s", "Lcom/facebook/drawee/view/SimpleDraweeView;", "image", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl extends BaseViewHolder implements IncomingImageMessageView, MessageViewClicks, MessageViewDate, MessageViewAvatar, MessageViewGroupDivider {
        public final SimpleDraweeView s;
        public final /* synthetic */ MessageViewClicksDelegate t;
        public final /* synthetic */ MessageViewDateDelegate u;
        public final /* synthetic */ MessageViewAvatarDelegate v;
        public final /* synthetic */ MessageViewGroupDividerDelegate w;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Impl(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.t = new MessageViewClicksDelegate(view);
            this.u = new MessageViewDateDelegate(view);
            this.v = new MessageViewAvatarDelegate(view);
            this.w = new MessageViewGroupDividerDelegate(view);
            this.s = (SimpleDraweeView) view.findViewById(R.id.message);
        }

        @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
        public void onUnbind() {
            DefaultImpls.onUnbind(this);
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

        @Override // com.avito.android.messenger.conversation.adapter.image.ImageMessageView
        public void setImage(@NotNull Picture picture, @Nullable Picture picture2) {
            Intrinsics.checkNotNullParameter(picture, "picture");
            SimpleDraweeView simpleDraweeView = this.s;
            Intrinsics.checkNotNullExpressionValue(simpleDraweeView, "image");
            ImageRequest.Builder picture3 = SimpleDraweeViewsKt.getRequestBuilder(simpleDraweeView).picture(picture);
            if (picture2 != null) {
                picture3.lowResPicture(picture2);
            }
            picture3.load();
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewClicks
        public void setLongClickListener(@NotNull Function0<Boolean> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.t.setLongClickListener(function0);
        }

        @Override // com.avito.android.messenger.conversation.adapter.image.ImageMessageView, com.avito.android.messenger.conversation.adapter.MessageViewStatus
        public void setStatus(@NotNull MessageDeliveryStatus messageDeliveryStatus) {
            Intrinsics.checkNotNullParameter(messageDeliveryStatus, "status");
            DefaultImpls.setStatus(this, messageDeliveryStatus);
        }

        @Override // com.avito.android.messenger.conversation.adapter.image.ImageMessageView, com.avito.android.messenger.conversation.adapter.MessageViewStatus
        public void setStatusClickListener(@NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            DefaultImpls.setStatusClickListener(this, function0);
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
