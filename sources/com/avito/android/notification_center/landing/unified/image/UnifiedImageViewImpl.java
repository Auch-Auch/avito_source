package com.avito.android.notification_center.landing.unified.image;

import android.net.Uri;
import android.view.View;
import com.avito.android.notification_center.R;
import com.avito.android.remote.model.Image;
import com.avito.android.util.Images;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\f\u001a\n \t*\u0004\u0018\u00010\b0\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/avito/android/notification_center/landing/unified/image/UnifiedImageViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/notification_center/landing/unified/image/UnifiedImageView;", "Lcom/avito/android/remote/model/Image;", "image", "", "setImage", "(Lcom/avito/android/remote/model/Image;)V", "Lcom/facebook/drawee/view/SimpleDraweeView;", "kotlin.jvm.PlatformType", "s", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class UnifiedImageViewImpl extends BaseViewHolder implements UnifiedImageView {
    public final SimpleDraweeView s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnifiedImageViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = (SimpleDraweeView) view.findViewById(R.id.image);
    }

    @Override // com.avito.android.notification_center.landing.unified.image.UnifiedImageView
    public void setImage(@NotNull Image image) {
        Intrinsics.checkNotNullParameter(image, "image");
        SimpleDraweeView simpleDraweeView = this.s;
        Intrinsics.checkNotNullExpressionValue(simpleDraweeView, "imageView");
        Uri width = Images.fit$default(image, simpleDraweeView, 0.0f, 0.0f, 2, 6, null).width();
        if (width == null) {
            SimpleDraweeView simpleDraweeView2 = this.s;
            Intrinsics.checkNotNullExpressionValue(simpleDraweeView2, "imageView");
            SimpleDraweeViewsKt.getRequestBuilder(simpleDraweeView2).clear();
            return;
        }
        SimpleDraweeView simpleDraweeView3 = this.s;
        Intrinsics.checkNotNullExpressionValue(simpleDraweeView3, "imageView");
        SimpleDraweeViewsKt.getRequestBuilder(simpleDraweeView3).uri(width).autoPlayAnimations(true).load();
    }
}
