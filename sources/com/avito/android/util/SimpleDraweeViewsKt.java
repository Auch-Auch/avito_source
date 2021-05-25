package com.avito.android.util;

import android.graphics.drawable.Drawable;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.image_loader.ImageRequest;
import com.avito.android.image_loader.ImageRequestListener;
import com.avito.android.image_loader.Picture;
import com.avito.android.image_loader.fresco.FrescoImageLoader;
import com.avito.android.image_loader.fresco.FrescoImageRequestFactoryImpl;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.exoplayer2.offline.DownloadService;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a3\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000b\"\u0017\u0010\u000f\u001a\u00020\f*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/facebook/drawee/view/SimpleDraweeView;", "Lcom/avito/android/image_loader/Picture;", "picture", "Landroid/graphics/drawable/Drawable;", InternalConstsKt.PLACEHOLDER, DownloadService.KEY_FOREGROUND, "", "loadPicture", "(Lcom/facebook/drawee/view/SimpleDraweeView;Lcom/avito/android/image_loader/Picture;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V", "Lcom/avito/android/image_loader/ImageRequestListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "(Lcom/facebook/drawee/view/SimpleDraweeView;Lcom/avito/android/image_loader/Picture;Lcom/avito/android/image_loader/ImageRequestListener;)V", "Lcom/avito/android/image_loader/ImageRequest$Builder;", "getRequestBuilder", "(Lcom/facebook/drawee/view/SimpleDraweeView;)Lcom/avito/android/image_loader/ImageRequest$Builder;", "requestBuilder", "api_release"}, k = 2, mv = {1, 4, 2})
public final class SimpleDraweeViewsKt {
    @NotNull
    public static final ImageRequest.Builder getRequestBuilder(@NotNull SimpleDraweeView simpleDraweeView) {
        Intrinsics.checkNotNullParameter(simpleDraweeView, "$this$requestBuilder");
        return new ImageRequest.Builder(new FrescoImageLoader(simpleDraweeView, new FrescoImageRequestFactoryImpl(simpleDraweeView)));
    }

    public static final void loadPicture(@NotNull SimpleDraweeView simpleDraweeView, @Nullable Picture picture, @Nullable Drawable drawable, @Nullable Drawable drawable2) {
        Intrinsics.checkNotNullParameter(simpleDraweeView, "$this$loadPicture");
        if (picture == null) {
            getRequestBuilder(simpleDraweeView).placeholder(drawable).foreground(drawable2).clear();
        } else {
            getRequestBuilder(simpleDraweeView).placeholder(drawable).foreground(drawable2).picture(picture).load();
        }
    }

    public static /* synthetic */ void loadPicture$default(SimpleDraweeView simpleDraweeView, Picture picture, Drawable drawable, Drawable drawable2, int i, Object obj) {
        if ((i & 2) != 0) {
            drawable = null;
        }
        if ((i & 4) != 0) {
            drawable2 = null;
        }
        loadPicture(simpleDraweeView, picture, drawable, drawable2);
    }

    public static final void loadPicture(@NotNull SimpleDraweeView simpleDraweeView, @Nullable Picture picture, @NotNull ImageRequestListener imageRequestListener) {
        Intrinsics.checkNotNullParameter(simpleDraweeView, "$this$loadPicture");
        Intrinsics.checkNotNullParameter(imageRequestListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (picture == null) {
            getRequestBuilder(simpleDraweeView).listener(imageRequestListener).clear();
        } else {
            getRequestBuilder(simpleDraweeView).listener(imageRequestListener).picture(picture).load();
        }
    }
}
