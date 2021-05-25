package com.avito.android.messenger.conversation.adapter.item;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import com.avito.android.image_loader.SimplePicture;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.adapter.item.ItemMessageView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Size;
import com.avito.android.util.Contexts;
import com.avito.android.util.Images;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.share.internal.ShareConstants;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001e\u0010\u001b\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u000fR\u0016\u0010\n\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/item/ItemMessageViewDelegate;", "Lcom/avito/android/messenger/conversation/adapter/item/ItemMessageView;", "", "value", "", "setTitle", "(Ljava/lang/String;)V", "setPrice", "setLocation", "Lcom/avito/android/remote/model/Image;", "image", "loadImage", "(Lcom/avito/android/remote/model/Image;)V", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "price", AuthSource.BOOKING_ORDER, "title", "Landroid/graphics/drawable/Drawable;", "f", "Landroid/graphics/drawable/Drawable;", "placeholderImage", "Landroid/content/Context;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "d", "location", "Lcom/facebook/drawee/view/SimpleDraweeView;", "e", "Lcom/facebook/drawee/view/SimpleDraweeView;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ItemMessageViewDelegate implements ItemMessageView {
    public final Context a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final SimpleDraweeView e;
    public final Drawable f;

    public ItemMessageViewDelegate(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Context context = view.getContext();
        this.a = context;
        View findViewById = view.findViewById(R.id.message_link_snippet_title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.message_link_snippet_subtitle);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.c = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.message_link_snippet_domain);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById3;
        this.d = textView;
        View findViewById4 = view.findViewById(R.id.message_link_snippet_image);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.e = (SimpleDraweeView) findViewById4;
        this.f = context.getDrawable(R.drawable.ic_messenger_item_no_image);
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView.setTextColor(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray48));
    }

    @Override // com.avito.android.messenger.conversation.adapter.item.ItemMessageView
    public void loadImage(@Nullable Image image) {
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

    @Override // com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        ItemMessageView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.messenger.conversation.adapter.item.ItemMessageView
    public void setLocation(@Nullable String str) {
        TextViews.bindText$default(this.d, str, false, 2, null);
    }

    @Override // com.avito.android.messenger.conversation.adapter.item.ItemMessageView
    public void setPrice(@Nullable String str) {
        TextViews.bindText$default(this.c, str, false, 2, null);
    }

    @Override // com.avito.android.messenger.conversation.adapter.item.ItemMessageView
    public void setTitle(@Nullable String str) {
        TextViews.bindText$default(this.b, str, false, 2, null);
    }
}
