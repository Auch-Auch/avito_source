package com.avito.android.favorite_sellers.adapter.seller;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import com.avito.android.image_loader.ImageRequestListener;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u0014"}, d2 = {"com/avito/android/favorite_sellers/adapter/seller/SellerItemViewImpl$shopAvatarImageListener$1", "Lcom/avito/android/image_loader/ImageRequestListener;", "", "onStarted", "()V", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "onLoaded", "(II)V", "onFailed", "Landroid/graphics/drawable/ColorDrawable;", AuthSource.BOOKING_ORDER, "Landroid/graphics/drawable/ColorDrawable;", "getGreyBg", "()Landroid/graphics/drawable/ColorDrawable;", "greyBg", AuthSource.SEND_ABUSE, "getWhiteBg", "whiteBg", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
public final class SellerItemViewImpl$shopAvatarImageListener$1 implements ImageRequestListener {
    @NotNull
    public final ColorDrawable a;
    @NotNull
    public final ColorDrawable b;
    public final /* synthetic */ SellerItemViewImpl c;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public SellerItemViewImpl$shopAvatarImageListener$1(SellerItemViewImpl sellerItemViewImpl) {
        this.c = sellerItemViewImpl;
        Context context = sellerItemViewImpl.B.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        this.a = new ColorDrawable(Contexts.getColorByAttr(context, R.attr.white));
        Context context2 = sellerItemViewImpl.B.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "view.context");
        this.b = new ColorDrawable(Contexts.getColorByAttr(context2, R.attr.gray8));
    }

    @NotNull
    public final ColorDrawable getGreyBg() {
        return this.b;
    }

    @NotNull
    public final ColorDrawable getWhiteBg() {
        return this.a;
    }

    @Override // com.avito.android.image_loader.ImageRequestListener
    public void onFailed() {
    }

    @Override // com.avito.android.image_loader.ImageRequestListener
    public void onLoaded(int i, int i2) {
        ((GenericDraweeHierarchy) this.c.t.getHierarchy()).setBackgroundImage(this.a);
    }

    @Override // com.avito.android.image_loader.ImageRequestListener
    public void onStarted() {
        ((GenericDraweeHierarchy) this.c.t.getHierarchy()).setBackgroundImage(this.b);
    }
}
