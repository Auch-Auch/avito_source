package com.avito.android.messenger.conversation.adapter.platform.from_avito.item;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.avito.android.image_loader.Picture;
import com.avito.android.image_loader.SimplePicture;
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
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Size;
import com.avito.android.remote.model.Sort;
import com.avito.android.util.Images;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.ItemView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0013J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\bJ\u0019\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\f\u0010\bJ\u0019\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u000e\u0010\bJ\u0019\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/item/PlatformItemMessageFromAvitoView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/messenger/conversation/adapter/IncomingMessageView;", "Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/MessageViewMargins;", "", "title", "", "setTitle", "(Ljava/lang/CharSequence;)V", "newPrice", "setNewPrice", "oldPrice", "setOldPrice", "location", "setLocation", "Lcom/avito/android/remote/model/Image;", "image", "setImage", "(Lcom/avito/android/remote/model/Image;)V", "Impl", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface PlatformItemMessageFromAvitoView extends ItemView, IncomingMessageView, MessageViewMargins {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull PlatformItemMessageFromAvitoView platformItemMessageFromAvitoView) {
            ItemView.DefaultImpls.onUnbind(platformItemMessageFromAvitoView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B\u000f\u0012\u0006\u0010C\u001a\u00020B¢\u0006\u0004\bD\u0010EJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u0019\u0010\u0010\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0010\u0010\fJ\u0019\u0010\u0012\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0012\u0010\fJ\u0019\u0010\u0015\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0017H\u0001¢\u0006\u0004\b\u001c\u0010\u001aJ\u001a\u0010\u001f\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0001¢\u0006\u0004\b\u001f\u0010 J\u001e\u0010#\u001a\u00020\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0!H\u0001¢\u0006\u0004\b#\u0010$J\u0018\u0010'\u001a\u00020\n2\u0006\u0010&\u001a\u00020%H\u0001¢\u0006\u0004\b'\u0010(J\u001e\u0010)\u001a\u00020\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0!H\u0001¢\u0006\u0004\b)\u0010$J\u001e\u0010*\u001a\u00020\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020%0!H\u0001¢\u0006\u0004\b*\u0010$J$\u0010.\u001a\u00020\n2\b\u0010,\u001a\u0004\u0018\u00010+2\b\u0010-\u001a\u0004\u0018\u00010+H\u0001¢\u0006\u0004\b.\u0010/R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00102R\u0016\u00107\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00102R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u00102R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006F"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/item/PlatformItemMessageFromAvitoView$Impl;", "Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/item/PlatformItemMessageFromAvitoView;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewDate;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewAvatar;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewGroupDivider;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewClicks;", "Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/MessageViewMargins;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "setTitle", "(Ljava/lang/CharSequence;)V", "newPrice", "setNewPrice", "oldPrice", "setOldPrice", "location", "setLocation", "Lcom/avito/android/remote/model/Image;", "image", "setImage", "(Lcom/avito/android/remote/model/Image;)V", "", Sort.DATE, "setDate", "(Ljava/lang/String;)V", "value", "setTime", "Lcom/avito/android/image_loader/Picture;", "picture", "setAvatar", "(Lcom/avito/android/image_loader/Picture;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setAvatarClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "show", "showGroupDivider", "(Z)V", "setClickListener", "setLongClickListener", "", "overrideTopMarginDp", "overrideBottomMarginDp", "overrideMargins", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "Landroid/widget/TextView;", "u", "Landroid/widget/TextView;", "oldPriceView", VKApiConst.VERSION, "locationView", "s", "titleView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "w", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", "t", "newPriceView", "Landroid/graphics/drawable/Drawable;", "x", "Landroid/graphics/drawable/Drawable;", "placeholderImage", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl extends BaseViewHolder implements PlatformItemMessageFromAvitoView, MessageViewDate, MessageViewAvatar, MessageViewGroupDivider, MessageViewClicks, MessageViewMargins {
        public final /* synthetic */ MessageViewGroupDividerDelegate A;
        public final /* synthetic */ MessageViewClicksDelegate B;
        public final /* synthetic */ MessageViewMarginsDelegate C;
        public final TextView s;
        public final TextView t;
        public final TextView u;
        public final TextView v;
        public final SimpleDraweeView w;
        public final Drawable x;
        public final /* synthetic */ MessageViewDateDelegate y;
        public final /* synthetic */ PlatformMessageViewFromAvitoAvatarDelegate z;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Impl(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.y = new MessageViewDateDelegate(view);
            int i = R.id.messenger_platform_item_bubble_from_avito;
            this.z = new PlatformMessageViewFromAvitoAvatarDelegate(view, i);
            this.A = new MessageViewGroupDividerDelegate(view);
            this.B = new MessageViewClicksDelegate(view);
            this.C = new MessageViewMarginsDelegate(view, i, R.id.message);
            View findViewById = view.findViewById(R.id.item_bubble_title);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.item_bubble_title)");
            this.s = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.item_bubble_price);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.item_bubble_price)");
            this.t = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.item_bubble_old_price);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.item_bubble_old_price)");
            this.u = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.item_bubble_location);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.item_bubble_location)");
            this.v = (TextView) findViewById4;
            View findViewById5 = view.findViewById(R.id.item_bubble_image);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.item_bubble_image)");
            this.w = (SimpleDraweeView) findViewById5;
            this.x = ContextCompat.getDrawable(view.getContext(), R.drawable.ic_messenger_item_no_image);
        }

        @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
        public void onUnbind() {
            DefaultImpls.onUnbind(this);
        }

        @Override // com.avito.android.messenger.conversation.adapter.platform.from_avito.MessageViewMargins
        public void overrideMargins(@Nullable Integer num, @Nullable Integer num2) {
            this.C.overrideMargins(num, num2);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewAvatar
        public void setAvatar(@Nullable Picture picture) {
            this.z.setAvatar(picture);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewAvatar
        public void setAvatarClickListener(@NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.z.setAvatarClickListener(function0);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewClicks
        public void setClickListener(@NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.B.setClickListener(function0);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewDate
        public void setDate(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, Sort.DATE);
            this.y.setDate(str);
        }

        @Override // com.avito.android.messenger.conversation.adapter.platform.from_avito.item.PlatformItemMessageFromAvitoView
        public void setImage(@Nullable Image image) {
            Map<Size, Uri> variants;
            Set<Map.Entry<Size, Uri>> entrySet;
            T t2;
            Uri width = Images.fit$default(image, this.w, 0.0f, 0.0f, 0, 14, null).width();
            if (width == null) {
                if (!(image == null || (variants = image.getVariants()) == null || (entrySet = variants.entrySet()) == null)) {
                    Iterator<T> it = entrySet.iterator();
                    if (!it.hasNext()) {
                        t2 = null;
                    } else {
                        t2 = it.next();
                        if (it.hasNext()) {
                            int area = ((Size) t2.getKey()).area();
                            do {
                                T next = it.next();
                                int area2 = ((Size) next.getKey()).area();
                                if (area < area2) {
                                    t2 = next;
                                    area = area2;
                                }
                            } while (it.hasNext());
                        }
                    }
                    T t3 = t2;
                    if (t3 != null) {
                        width = (Uri) t3.getValue();
                    }
                }
                width = null;
            }
            if (width == null) {
                width = Uri.EMPTY;
            }
            SimpleDraweeView simpleDraweeView = this.w;
            Intrinsics.checkNotNullExpressionValue(width, ShareConstants.MEDIA_URI);
            SimpleDraweeViewsKt.loadPicture$default(simpleDraweeView, new SimplePicture(width), this.x, null, 4, null);
        }

        @Override // com.avito.android.messenger.conversation.adapter.platform.from_avito.item.PlatformItemMessageFromAvitoView
        public void setLocation(@Nullable CharSequence charSequence) {
            TextViews.bindText$default(this.v, charSequence, false, 2, null);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewClicks
        public void setLongClickListener(@NotNull Function0<Boolean> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.B.setLongClickListener(function0);
        }

        @Override // com.avito.android.messenger.conversation.adapter.platform.from_avito.item.PlatformItemMessageFromAvitoView
        public void setNewPrice(@NotNull CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(charSequence, "newPrice");
            TextViews.bindText$default(this.t, charSequence, false, 2, null);
        }

        @Override // com.avito.android.messenger.conversation.adapter.platform.from_avito.item.PlatformItemMessageFromAvitoView
        public void setOldPrice(@Nullable CharSequence charSequence) {
            if (charSequence != null) {
                this.u.setText(charSequence);
                TextView textView = this.u;
                textView.setPaintFlags(textView.getPaintFlags() | 16);
                return;
            }
            Views.hide(this.u);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewDate
        public void setTime(@Nullable String str) {
            this.y.setTime(str);
        }

        @Override // com.avito.android.messenger.conversation.adapter.platform.from_avito.item.PlatformItemMessageFromAvitoView
        public void setTitle(@NotNull CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(charSequence, "title");
            TextViews.bindText$default(this.s, charSequence, false, 2, null);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewGroupDivider
        public void showGroupDivider(boolean z2) {
            this.A.showGroupDivider(z2);
        }
    }

    void setImage(@Nullable Image image);

    void setLocation(@Nullable CharSequence charSequence);

    void setNewPrice(@NotNull CharSequence charSequence);

    void setOldPrice(@Nullable CharSequence charSequence);

    void setTitle(@NotNull CharSequence charSequence);
}
