package com.avito.android.messenger.conversation.adapter.image;

import android.view.View;
import com.avito.android.component.circular_action_progress.CircularActionProgressImpl;
import com.avito.android.component.message_status.MessageDeliveryStatus;
import com.avito.android.image_loader.ImageRequest;
import com.avito.android.image_loader.Picture;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.adapter.MessageViewClicks;
import com.avito.android.messenger.conversation.adapter.MessageViewClicksDelegate;
import com.avito.android.messenger.conversation.adapter.MessageViewDate;
import com.avito.android.messenger.conversation.adapter.MessageViewDateDelegate;
import com.avito.android.messenger.conversation.adapter.MessageViewGroupDivider;
import com.avito.android.messenger.conversation.adapter.MessageViewGroupDividerDelegate;
import com.avito.android.messenger.conversation.adapter.MessageViewStatusDelegate;
import com.avito.android.messenger.conversation.adapter.OutgoingMessageView;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/image/OutgoingImageMessageView;", "Lcom/avito/android/messenger/conversation/adapter/image/ImageMessageView;", "Lcom/avito/android/messenger/conversation/adapter/OutgoingMessageView;", "Impl", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface OutgoingImageMessageView extends ImageMessageView, OutgoingMessageView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull OutgoingImageMessageView outgoingImageMessageView) {
            ImageMessageView.DefaultImpls.onUnbind(outgoingImageMessageView);
        }

        public static void setStatus(@NotNull OutgoingImageMessageView outgoingImageMessageView, @NotNull MessageDeliveryStatus messageDeliveryStatus) {
            Intrinsics.checkNotNullParameter(messageDeliveryStatus, "status");
            ImageMessageView.DefaultImpls.setStatus(outgoingImageMessageView, messageDeliveryStatus);
        }

        public static void setStatusClickListener(@NotNull OutgoingImageMessageView outgoingImageMessageView, @NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            ImageMessageView.DefaultImpls.setStatusClickListener(outgoingImageMessageView, function0);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u000f\u0012\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b/\u00100J!\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001e\u0010\u0014\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0010H\u0001¢\u0006\u0004\b\u0014\u0010\u0013J\u001e\u0010\u0016\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010H\u0001¢\u0006\u0004\b\u0016\u0010\u0013J\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0017H\u0001¢\u0006\u0004\b\u001c\u0010\u001aJ\u0018\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0015H\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001e\u0010,\u001a\n )*\u0004\u0018\u00010(0(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u00061"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/image/OutgoingImageMessageView$Impl;", "Lcom/avito/android/messenger/conversation/adapter/image/OutgoingImageMessageView;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewClicks;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewDate;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewGroupDivider;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/image_loader/Picture;", "picture", "thumbnail", "", "setImage", "(Lcom/avito/android/image_loader/Picture;Lcom/avito/android/image_loader/Picture;)V", "Lcom/avito/android/component/message_status/MessageDeliveryStatus;", "status", "setStatus", "(Lcom/avito/android/component/message_status/MessageDeliveryStatus;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setStatusClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setClickListener", "", "setLongClickListener", "", Sort.DATE, "setDate", "(Ljava/lang/String;)V", "value", "setTime", "show", "showGroupDivider", "(Z)V", "Lcom/avito/android/component/circular_action_progress/CircularActionProgressImpl;", "t", "Lcom/avito/android/component/circular_action_progress/CircularActionProgressImpl;", "progress", "Lcom/avito/android/messenger/conversation/adapter/MessageViewStatusDelegate;", "s", "Lcom/avito/android/messenger/conversation/adapter/MessageViewStatusDelegate;", "statusDelegate", "Lcom/facebook/drawee/view/SimpleDraweeView;", "kotlin.jvm.PlatformType", "u", "Lcom/facebook/drawee/view/SimpleDraweeView;", "image", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl extends BaseViewHolder implements OutgoingImageMessageView, MessageViewClicks, MessageViewDate, MessageViewGroupDivider {
        public final MessageViewStatusDelegate s;
        public final CircularActionProgressImpl t;
        public final SimpleDraweeView u;
        public final /* synthetic */ MessageViewClicksDelegate v;
        public final /* synthetic */ MessageViewDateDelegate w;
        public final /* synthetic */ MessageViewGroupDividerDelegate x;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Impl(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.v = new MessageViewClicksDelegate(view);
            this.w = new MessageViewDateDelegate(view);
            this.x = new MessageViewGroupDividerDelegate(view);
            this.s = new MessageViewStatusDelegate(view);
            View findViewById = view.findViewById(R.id.message_progress);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.message_progress)");
            CircularActionProgressImpl circularActionProgressImpl = new CircularActionProgressImpl(findViewById);
            this.t = circularActionProgressImpl;
            this.u = (SimpleDraweeView) view.findViewById(R.id.message);
            circularActionProgressImpl.stopProgress();
            circularActionProgressImpl.setErrorEnabled(false);
            circularActionProgressImpl.setCancelable(false);
            circularActionProgressImpl.setBackground(view.getContext().getDrawable(R.drawable.bg_messenger_image_message_outgoing_progress));
        }

        @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
        public void onUnbind() {
            DefaultImpls.onUnbind(this);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewClicks
        public void setClickListener(@NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.v.setClickListener(function0);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewDate
        public void setDate(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, Sort.DATE);
            this.w.setDate(str);
        }

        @Override // com.avito.android.messenger.conversation.adapter.image.ImageMessageView
        public void setImage(@NotNull Picture picture, @Nullable Picture picture2) {
            Intrinsics.checkNotNullParameter(picture, "picture");
            SimpleDraweeView simpleDraweeView = this.u;
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
            this.v.setLongClickListener(function0);
        }

        @Override // com.avito.android.messenger.conversation.adapter.image.ImageMessageView, com.avito.android.messenger.conversation.adapter.MessageViewStatus
        public void setStatus(@NotNull MessageDeliveryStatus messageDeliveryStatus) {
            Intrinsics.checkNotNullParameter(messageDeliveryStatus, "status");
            this.s.setStatus(messageDeliveryStatus);
            if (messageDeliveryStatus == MessageDeliveryStatus.SENDING) {
                this.t.show();
                this.t.startProgress();
                return;
            }
            this.t.hide();
            this.t.stopProgress();
        }

        @Override // com.avito.android.messenger.conversation.adapter.image.ImageMessageView, com.avito.android.messenger.conversation.adapter.MessageViewStatus
        public void setStatusClickListener(@NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.s.setStatusClickListener(function0);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewDate
        public void setTime(@Nullable String str) {
            this.w.setTime(str);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewGroupDivider
        public void showGroupDivider(boolean z) {
            this.x.showGroupDivider(z);
        }
    }
}
