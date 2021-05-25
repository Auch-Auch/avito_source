package com.avito.android.messenger.conversation.adapter.platform.from_avito.geo;

import a2.b.a.a.a;
import android.view.View;
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
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.ItemView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\tJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/geo/PlatformGeoMessageFromAvitoView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/messenger/conversation/adapter/IncomingMessageView;", "Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/MessageViewMargins;", "Lcom/avito/android/image_loader/Picture;", "picture", "", "setMapImage", "(Lcom/avito/android/image_loader/Picture;)V", "Impl", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface PlatformGeoMessageFromAvitoView extends ItemView, IncomingMessageView, MessageViewMargins {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull PlatformGeoMessageFromAvitoView platformGeoMessageFromAvitoView) {
            ItemView.DefaultImpls.onUnbind(platformGeoMessageFromAvitoView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B\u000f\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0001¢\u0006\u0004\b\u0012\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0004\b\u0013\u0010\fJ\u001e\u0010\u0016\u001a\u00020\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u0014H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\u001c\u001a\u00020\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u0014H\u0001¢\u0006\u0004\b\u001c\u0010\u0017J\u001e\u0010\u001d\u001a\u00020\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00180\u0014H\u0001¢\u0006\u0004\b\u001d\u0010\u0017J$\u0010!\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u001eH\u0001¢\u0006\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006+"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/geo/PlatformGeoMessageFromAvitoView$Impl;", "Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/geo/PlatformGeoMessageFromAvitoView;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewDate;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewAvatar;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewGroupDivider;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewClicks;", "Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/MessageViewMargins;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/image_loader/Picture;", "picture", "", "setMapImage", "(Lcom/avito/android/image_loader/Picture;)V", "", Sort.DATE, "setDate", "(Ljava/lang/String;)V", "value", "setTime", "setAvatar", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setAvatarClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "show", "showGroupDivider", "(Z)V", "setClickListener", "setLongClickListener", "", "overrideTopMarginDp", "overrideBottomMarginDp", "overrideMargins", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "Lcom/facebook/drawee/view/SimpleDraweeView;", "s", "Lcom/facebook/drawee/view/SimpleDraweeView;", "bubbleImageView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl extends BaseViewHolder implements PlatformGeoMessageFromAvitoView, MessageViewDate, MessageViewAvatar, MessageViewGroupDivider, MessageViewClicks, MessageViewMargins {
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
            int i = R.id.messenger_platform_geo_bubble_from_avito;
            this.u = new PlatformMessageViewFromAvitoAvatarDelegate(view, i);
            this.v = new MessageViewGroupDividerDelegate(view);
            this.w = new MessageViewClicksDelegate(view);
            int i2 = R.id.message;
            this.x = new MessageViewMarginsDelegate(view, i, i2);
            View findViewById = view.findViewById(i2);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
            this.s = (SimpleDraweeView) findViewById;
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

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewClicks
        public void setLongClickListener(@NotNull Function0<Boolean> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.w.setLongClickListener(function0);
        }

        @Override // com.avito.android.messenger.conversation.adapter.platform.from_avito.geo.PlatformGeoMessageFromAvitoView
        public void setMapImage(@NotNull Picture picture) {
            Intrinsics.checkNotNullParameter(picture, "picture");
            a.L0(this.s, picture);
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

    void setMapImage(@NotNull Picture picture);
}
