package com.avito.android.safedeal.delivery_courier.summary.konveyor.image;

import android.view.View;
import android.widget.TextView;
import com.avito.android.safedeal.R;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.image.ImageItemView;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\u0010\u001a\n \r*\u0004\u0018\u00010\f0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0014\u001a\n \r*\u0004\u0018\u00010\u00110\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/image/SummaryItemViewImpl;", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/image/ImageItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "setTitle", "(Ljava/lang/CharSequence;)V", "Lcom/avito/android/remote/model/Image;", "image", "setImage", "(Lcom/avito/android/remote/model/Image;)V", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "t", "Landroid/widget/TextView;", "itemTitle", "Lcom/facebook/drawee/view/SimpleDraweeView;", "s", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class SummaryItemViewImpl extends BaseViewHolder implements ImageItemView {
    public final SimpleDraweeView s;
    public final TextView t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SummaryItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = (SimpleDraweeView) view.findViewById(R.id.item_image);
        this.t = (TextView) view.findViewById(R.id.item_title);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        ImageItemView.DefaultImpls.onUnbind(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0038  */
    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.image.ImageItemView
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setImage(@org.jetbrains.annotations.Nullable com.avito.android.remote.model.Image r11) {
        /*
            r10 = this;
            java.lang.String r0 = "imageView"
            if (r11 == 0) goto L_0x0028
            com.facebook.drawee.view.SimpleDraweeView r1 = r10.s
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            int r3 = r1.getWidth()
            com.facebook.drawee.view.SimpleDraweeView r1 = r10.s
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            int r4 = r1.getHeight()
            r5 = 0
            r6 = 0
            r7 = 2
            r8 = 12
            r9 = 0
            r2 = r11
            com.avito.android.util.ImageFitting r11 = com.avito.android.util.Images.fit$default(r2, r3, r4, r5, r6, r7, r8, r9)
            if (r11 == 0) goto L_0x0028
            android.net.Uri r11 = r11.width()
            goto L_0x0029
        L_0x0028:
            r11 = 0
        L_0x0029:
            if (r11 != 0) goto L_0x0038
            com.facebook.drawee.view.SimpleDraweeView r11 = r10.s
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)
            com.avito.android.image_loader.ImageRequest$Builder r11 = com.avito.android.util.SimpleDraweeViewsKt.getRequestBuilder(r11)
            r11.clear()
            goto L_0x0048
        L_0x0038:
            com.facebook.drawee.view.SimpleDraweeView r1 = r10.s
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            com.avito.android.image_loader.ImageRequest$Builder r0 = com.avito.android.util.SimpleDraweeViewsKt.getRequestBuilder(r1)
            com.avito.android.image_loader.ImageRequest$Builder r11 = r0.uri(r11)
            r11.load()
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.safedeal.delivery_courier.summary.konveyor.image.SummaryItemViewImpl.setImage(com.avito.android.remote.model.Image):void");
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.image.ImageItemView
    public void setTitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        TextView textView = this.t;
        Intrinsics.checkNotNullExpressionValue(textView, "itemTitle");
        TextViews.bindText$default(textView, charSequence, false, 2, null);
    }
}
