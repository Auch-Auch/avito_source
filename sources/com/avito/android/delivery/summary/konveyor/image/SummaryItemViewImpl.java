package com.avito.android.delivery.summary.konveyor.image;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.avito.android.delivery.R;
import com.avito.android.delivery.summary.konveyor.image.ImageItemView;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.TextViews;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\u0010\u001a\n \r*\u0004\u0018\u00010\f0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0018\u001a\n \r*\u0004\u0018\u00010\u00150\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/avito/android/delivery/summary/konveyor/image/SummaryItemViewImpl;", "Lcom/avito/android/delivery/summary/konveyor/image/ImageItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/remote/model/text/AttributedText;", "title", "", "setTitle", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "Lcom/avito/android/remote/model/Image;", "image", "setImage", "(Lcom/avito/android/remote/model/Image;)V", "Lcom/facebook/drawee/view/SimpleDraweeView;", "kotlin.jvm.PlatformType", "s", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", "Lcom/avito/android/util/text/AttributedTextFormatter;", "u", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "itemTitle", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class SummaryItemViewImpl extends BaseViewHolder implements ImageItemView {
    public final SimpleDraweeView s;
    public final TextView t;
    public final AttributedTextFormatter u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SummaryItemViewImpl(@NotNull View view, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.u = attributedTextFormatter;
        this.s = (SimpleDraweeView) view.findViewById(R.id.item_image);
        this.t = (TextView) view.findViewById(R.id.item_title);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        ImageItemView.DefaultImpls.onUnbind(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0038  */
    @Override // com.avito.android.delivery.summary.konveyor.image.ImageItemView
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
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.delivery.summary.konveyor.image.SummaryItemViewImpl.setImage(com.avito.android.remote.model.Image):void");
    }

    @Override // com.avito.android.delivery.summary.konveyor.image.ImageItemView
    public void setTitle(@NotNull AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(attributedText, "title");
        TextView textView = this.t;
        Intrinsics.checkNotNullExpressionValue(textView, "itemTitle");
        AttributedTextFormatter attributedTextFormatter = this.u;
        TextView textView2 = this.t;
        Intrinsics.checkNotNullExpressionValue(textView2, "itemTitle");
        Context context = textView2.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemTitle.context");
        TextViews.bindText$default(textView, attributedTextFormatter.format(context, attributedText), false, 2, null);
    }
}
