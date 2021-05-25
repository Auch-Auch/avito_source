package com.avito.android.messenger.conversation.adapter.platform.from_user.item;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import com.avito.android.image_loader.SimplePicture;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.adapter.platform.from_user.item.PlatformItemMessageFromUserView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Size;
import com.avito.android.util.Images;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.share.internal.ShareConstants;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010$\u001a\u00020#\u0012\b\b\u0001\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0019\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0006J\u0019\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0016\u0010\u001e\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0017R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006)"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/platform/from_user/item/PlatformItemMessageFromUserViewDelegate;", "Lcom/avito/android/messenger/conversation/adapter/platform/from_user/item/PlatformItemMessageFromUserView;", "", "title", "", "setTitle", "(Ljava/lang/CharSequence;)V", "newPrice", "setNewPrice", "oldPrice", "setOldPrice", "location", "setLocation", "Lcom/avito/android/remote/model/Image;", "image", "setImage", "(Lcom/avito/android/remote/model/Image;)V", "Lcom/facebook/drawee/view/SimpleDraweeView;", "e", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", "Landroid/widget/TextView;", AuthSource.SEND_ABUSE, "Landroid/widget/TextView;", "titleView", "c", "oldPriceView", AuthSource.BOOKING_ORDER, "newPriceView", "d", "locationView", "Landroid/graphics/drawable/Drawable;", "f", "Landroid/graphics/drawable/Drawable;", "placeholderImage", "Landroid/view/View;", "view", "", "backgroundRes", "<init>", "(Landroid/view/View;I)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class PlatformItemMessageFromUserViewDelegate implements PlatformItemMessageFromUserView {
    public final TextView a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final SimpleDraweeView e;
    public final Drawable f;

    public PlatformItemMessageFromUserViewDelegate(@NotNull View view, @DrawableRes int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.item_bubble_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.item_bubble_title)");
        this.a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.item_bubble_price);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.item_bubble_price)");
        this.b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.item_bubble_old_price);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.item_bubble_old_price)");
        this.c = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.item_bubble_location);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.item_bubble_location)");
        this.d = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.item_bubble_image);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.item_bubble_image)");
        this.e = (SimpleDraweeView) findViewById5;
        this.f = ContextCompat.getDrawable(view.getContext(), R.drawable.ic_messenger_item_no_image);
        View findViewById6 = view.findViewById(R.id.message);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "bubbleView");
        Resources resources = findViewById6.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "bubbleView.resources");
        findViewById6.setPadding((int) TypedValue.applyDimension(1, (float) 4, resources.getDisplayMetrics()), 0, 0, 0);
        findViewById6.setBackgroundResource(i);
    }

    @Override // com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        PlatformItemMessageFromUserView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.messenger.conversation.adapter.platform.from_user.item.PlatformItemMessageFromUserView
    public void setImage(@Nullable Image image) {
        Map<Size, Uri> variants;
        Set<Map.Entry<Size, Uri>> entrySet;
        T t;
        Uri width = Images.fit$default(image, this.e, 0.0f, 0.0f, 0, 14, null).width();
        if (width == null) {
            if (!(image == null || (variants = image.getVariants()) == null || (entrySet = variants.entrySet()) == null)) {
                Iterator<T> it = entrySet.iterator();
                if (!it.hasNext()) {
                    t = null;
                } else {
                    t = it.next();
                    if (it.hasNext()) {
                        int area = ((Size) t.getKey()).area();
                        do {
                            T next = it.next();
                            int area2 = ((Size) next.getKey()).area();
                            if (area < area2) {
                                t = next;
                                area = area2;
                            }
                        } while (it.hasNext());
                    }
                }
                T t2 = t;
                if (t2 != null) {
                    width = (Uri) t2.getValue();
                }
            }
            width = null;
        }
        if (width == null) {
            width = Uri.EMPTY;
        }
        SimpleDraweeView simpleDraweeView = this.e;
        Intrinsics.checkNotNullExpressionValue(width, ShareConstants.MEDIA_URI);
        SimpleDraweeViewsKt.loadPicture$default(simpleDraweeView, new SimplePicture(width), this.f, null, 4, null);
    }

    @Override // com.avito.android.messenger.conversation.adapter.platform.from_user.item.PlatformItemMessageFromUserView
    public void setLocation(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.d, charSequence, false, 2, null);
    }

    @Override // com.avito.android.messenger.conversation.adapter.platform.from_user.item.PlatformItemMessageFromUserView
    public void setNewPrice(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "newPrice");
        TextViews.bindText$default(this.b, charSequence, false, 2, null);
    }

    @Override // com.avito.android.messenger.conversation.adapter.platform.from_user.item.PlatformItemMessageFromUserView
    public void setOldPrice(@Nullable CharSequence charSequence) {
        if (charSequence != null) {
            this.c.setText(charSequence);
            TextView textView = this.c;
            textView.setPaintFlags(textView.getPaintFlags() | 16);
            return;
        }
        Views.hide(this.c);
    }

    @Override // com.avito.android.messenger.conversation.adapter.platform.from_user.item.PlatformItemMessageFromUserView
    public void setTitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        TextViews.bindText$default(this.a, charSequence, false, 2, null);
    }
}
