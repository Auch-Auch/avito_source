package com.avito.android.image_loader.fresco;

import com.avito.android.image_loader.ImageRequest;
import com.avito.android.image_loader.Picture;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\"\u0017\u0010\t\u001a\u00020\u0006*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/facebook/drawee/view/SimpleDraweeView;", "Lcom/avito/android/image_loader/Picture;", "picture", "", "loadPicture", "(Lcom/facebook/drawee/view/SimpleDraweeView;Lcom/avito/android/image_loader/Picture;)V", "Lcom/avito/android/image_loader/ImageRequest$Builder;", "getRequestBuilder", "(Lcom/facebook/drawee/view/SimpleDraweeView;)Lcom/avito/android/image_loader/ImageRequest$Builder;", "requestBuilder", "image-loader-fresco_release"}, k = 2, mv = {1, 4, 2})
public final class SimpleDraweeViewsKt {
    @NotNull
    public static final ImageRequest.Builder getRequestBuilder(@NotNull SimpleDraweeView simpleDraweeView) {
        Intrinsics.checkNotNullParameter(simpleDraweeView, "$this$requestBuilder");
        return new ImageRequest.Builder(new FrescoImageLoader(simpleDraweeView, new FrescoImageRequestFactoryImpl(simpleDraweeView)));
    }

    public static final void loadPicture(@NotNull SimpleDraweeView simpleDraweeView, @NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(simpleDraweeView, "$this$loadPicture");
        Intrinsics.checkNotNullParameter(picture, "picture");
        getRequestBuilder(simpleDraweeView).picture(picture).load();
    }
}
