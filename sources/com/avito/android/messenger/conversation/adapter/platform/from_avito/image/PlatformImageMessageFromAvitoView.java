package com.avito.android.messenger.conversation.adapter.platform.from_avito.image;

import android.view.View;
import com.avito.android.image_loader.ImageRequest;
import com.avito.android.image_loader.Picture;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.adapter.IncomingMessageView;
import com.avito.android.messenger.conversation.adapter.MessageViewAvatar;
import com.avito.android.messenger.conversation.adapter.MessageViewClicks;
import com.avito.android.messenger.conversation.adapter.MessageViewClicksDelegate;
import com.avito.android.messenger.conversation.adapter.MessageViewDate;
import com.avito.android.messenger.conversation.adapter.MessageViewDateDelegate;
import com.avito.android.messenger.conversation.adapter.MessageViewGroupDivider;
import com.avito.android.messenger.conversation.adapter.MessageViewGroupDividerDelegate;
import com.avito.android.messenger.conversation.adapter.PlatformMessageViewFromAvitoAvatarDelegate;
import com.avito.android.messenger.conversation.adapter.platform.from_avito.MessageViewMargins;
import com.avito.android.messenger.conversation.adapter.platform.from_avito.MessageViewMarginsDelegate;
import com.avito.android.remote.model.Sort;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.ItemView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\nJ%\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/image/PlatformImageMessageFromAvitoView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/messenger/conversation/adapter/IncomingMessageView;", "Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/MessageViewMargins;", "Lcom/avito/android/image_loader/Picture;", "picture", "lowResPicture", "", "setImage", "(Lcom/avito/android/image_loader/Picture;Lcom/avito/android/image_loader/Picture;)V", "Impl", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface PlatformImageMessageFromAvitoView extends ItemView, IncomingMessageView, MessageViewMargins {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull PlatformImageMessageFromAvitoView platformImageMessageFromAvitoView) {
            ItemView.DefaultImpls.onUnbind(platformImageMessageFromAvitoView);
        }

        public static /* synthetic */ void setImage$default(PlatformImageMessageFromAvitoView platformImageMessageFromAvitoView, Picture picture, Picture picture2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    picture2 = null;
                }
                platformImageMessageFromAvitoView.setImage(picture, picture2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setImage");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B\u000f\u0012\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J#\u0010\f\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000eH\u0001¢\u0006\u0004\b\u0013\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\u0018\u001a\u00020\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0016H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001e\u0010\u001e\u001a\u00020\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0016H\u0001¢\u0006\u0004\b\u001e\u0010\u0019J\u001e\u0010\u001f\u001a\u00020\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0016H\u0001¢\u0006\u0004\b\u001f\u0010\u0019J$\u0010#\u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\"\u001a\u0004\u0018\u00010 H\u0001¢\u0006\u0004\b#\u0010$R\u001e\u0010)\u001a\n &*\u0004\u0018\u00010%0%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006."}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/image/PlatformImageMessageFromAvitoView$Impl;", "Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/image/PlatformImageMessageFromAvitoView;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewDate;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewAvatar;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewGroupDivider;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewClicks;", "Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/MessageViewMargins;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/image_loader/Picture;", "picture", "lowResPicture", "", "setImage", "(Lcom/avito/android/image_loader/Picture;Lcom/avito/android/image_loader/Picture;)V", "", Sort.DATE, "setDate", "(Ljava/lang/String;)V", "value", "setTime", "setAvatar", "(Lcom/avito/android/image_loader/Picture;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setAvatarClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "show", "showGroupDivider", "(Z)V", "setClickListener", "setLongClickListener", "", "overrideTopMarginDp", "overrideBottomMarginDp", "overrideMargins", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "Lcom/facebook/drawee/view/SimpleDraweeView;", "kotlin.jvm.PlatformType", "s", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl extends BaseViewHolder implements PlatformImageMessageFromAvitoView, MessageViewDate, MessageViewAvatar, MessageViewGroupDivider, MessageViewClicks, MessageViewMargins {
        public final SimpleDraweeView s;
        public final /* synthetic */ MessageViewDateDelegate t;
        public final /* synthetic */ PlatformMessageViewFromAvitoAvatarDelegate u;
        public final /* synthetic */ MessageViewGroupDividerDelegate v;
        public final /* synthetic */ MessageViewClicksDelegate w;
        public final /* synthetic */ MessageViewMarginsDelegate x;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Impl(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.t = new MessageViewDateDelegate(view);
            int i = R.id.messenger_platform_image_bubble_from_avito;
            this.u = new PlatformMessageViewFromAvitoAvatarDelegate(view, i);
            this.v = new MessageViewGroupDividerDelegate(view);
            this.w = new MessageViewClicksDelegate(view);
            int i2 = R.id.message;
            this.x = new MessageViewMarginsDelegate(view, i, i2);
            this.s = (SimpleDraweeView) view.findViewById(i2);
        }

        @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
        public void onUnbind() {
            DefaultImpls.onUnbind(this);
        }

        @Override // com.avito.android.messenger.conversation.adapter.platform.from_avito.MessageViewMargins
        public void overrideMargins(@Nullable Integer num, @Nullable Integer num2) {
            this.x.overrideMargins(num, num2);
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
            this.w.setClickListener(function0);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewDate
        public void setDate(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, Sort.DATE);
            this.t.setDate(str);
        }

        @Override // com.avito.android.messenger.conversation.adapter.platform.from_avito.image.PlatformImageMessageFromAvitoView
        public void setImage(@Nullable Picture picture, @Nullable Picture picture2) {
            if (picture != null) {
                SimpleDraweeView simpleDraweeView = this.s;
                Intrinsics.checkNotNullExpressionValue(simpleDraweeView, "imageView");
                ImageRequest.Builder picture3 = SimpleDraweeViewsKt.getRequestBuilder(simpleDraweeView).picture(picture);
                if (picture2 != null) {
                    picture3.lowResPicture(picture2);
                }
                picture3.load();
                return;
            }
            SimpleDraweeView simpleDraweeView2 = this.s;
            Intrinsics.checkNotNullExpressionValue(simpleDraweeView2, "imageView");
            SimpleDraweeViewsKt.getRequestBuilder(simpleDraweeView2).clear();
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewClicks
        public void setLongClickListener(@NotNull Function0<Boolean> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.w.setLongClickListener(function0);
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

    void setImage(@Nullable Picture picture, @Nullable Picture picture2);
}
