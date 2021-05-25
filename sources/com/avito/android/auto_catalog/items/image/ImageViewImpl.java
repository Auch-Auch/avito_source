package com.avito.android.auto_catalog.items.image;

import android.net.Uri;
import android.view.View;
import com.avito.android.image_loader.SimplePicture;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/avito/android/auto_catalog/items/image/ImageViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/auto_catalog/items/image/ImageView;", "", "image", "", "setImage", "(Ljava/lang/String;)V", "Lcom/facebook/drawee/view/SimpleDraweeView;", "s", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class ImageViewImpl extends BaseViewHolder implements ImageView {
    public final SimpleDraweeView s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = (SimpleDraweeView) view;
    }

    @Override // com.avito.android.auto_catalog.items.image.ImageView
    public void setImage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "image");
        SimpleDraweeView simpleDraweeView = this.s;
        Uri parse = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(image)");
        SimpleDraweeViewsKt.loadPicture$default(simpleDraweeView, new SimplePicture(parse), null, null, 6, null);
    }
}
