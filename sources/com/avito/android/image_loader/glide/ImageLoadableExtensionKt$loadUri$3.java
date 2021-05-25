package com.avito.android.image_loader.glide;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.design.ImageLoadable;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.transition.Transition;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\t\u0010\u0007J)\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00032\u0010\u0010\f\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u0003\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"com/avito/android/image_loader/glide/ImageLoadableExtensionKt$loadUri$3", "Lcom/bumptech/glide/request/target/CustomViewTarget;", "Landroid/view/View;", "Landroid/graphics/drawable/Drawable;", "errorDrawable", "", "onLoadFailed", "(Landroid/graphics/drawable/Drawable;)V", InternalConstsKt.PLACEHOLDER, "onResourceCleared", "resource", "Lcom/bumptech/glide/request/transition/Transition;", "transition", "onResourceReady", "(Landroid/graphics/drawable/Drawable;Lcom/bumptech/glide/request/transition/Transition;)V", "image-loader-glide_release"}, k = 1, mv = {1, 4, 2})
public final class ImageLoadableExtensionKt$loadUri$3 extends CustomViewTarget<View, Drawable> {
    public final /* synthetic */ ImageLoadable f;
    public final /* synthetic */ Function0 g;
    public final /* synthetic */ Function1 h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageLoadableExtensionKt$loadUri$3(ImageLoadable imageLoadable, Function0 function0, Function1 function1, View view) {
        super(view);
        this.f = imageLoadable;
        this.g = function0;
        this.h = function1;
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadFailed(@Nullable Drawable drawable) {
        this.g.invoke();
    }

    @Override // com.bumptech.glide.request.target.CustomViewTarget
    public void onResourceCleared(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
        onResourceReady((Drawable) obj, (Transition<? super Drawable>) transition);
    }

    public void onResourceReady(@NotNull Drawable drawable, @Nullable Transition<? super Drawable> transition) {
        Intrinsics.checkNotNullParameter(drawable, "resource");
        this.h.invoke(drawable);
        this.f.setImage(drawable);
    }
}
