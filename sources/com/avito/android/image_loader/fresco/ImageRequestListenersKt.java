package com.avito.android.image_loader.fresco;

import android.graphics.drawable.Animatable;
import com.avito.android.image_loader.ImageRequestListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/image_loader/ImageRequestListener;", "Lcom/facebook/drawee/controller/ControllerListener;", "Lcom/facebook/imagepipeline/image/ImageInfo;", "toControllerListener", "(Lcom/avito/android/image_loader/ImageRequestListener;)Lcom/facebook/drawee/controller/ControllerListener;", "image-loader-fresco_release"}, k = 2, mv = {1, 4, 2})
public final class ImageRequestListenersKt {
    @Nullable
    public static final ControllerListener<ImageInfo> toControllerListener(@Nullable ImageRequestListener imageRequestListener) {
        if (imageRequestListener != null) {
            return new ControllerListener<ImageInfo>(imageRequestListener) { // from class: com.avito.android.image_loader.fresco.ImageRequestListenersKt$toControllerListener$1
                public final /* synthetic */ ImageRequestListener a;

                {
                    this.a = r1;
                }

                @Override // com.facebook.drawee.controller.ControllerListener
                public void onFailure(@Nullable String str, @Nullable Throwable th) {
                    this.a.onFailed();
                }

                @Override // com.facebook.drawee.controller.ControllerListener
                public void onIntermediateImageFailed(@Nullable String str, @Nullable Throwable th) {
                }

                public void onIntermediateImageSet(@Nullable String str, @Nullable ImageInfo imageInfo) {
                }

                @Override // com.facebook.drawee.controller.ControllerListener
                public void onRelease(@Nullable String str) {
                }

                @Override // com.facebook.drawee.controller.ControllerListener
                public void onSubmit(@Nullable String str, @Nullable Object obj) {
                    this.a.onStarted();
                }

                public void onFinalImageSet(@Nullable String str, @Nullable ImageInfo imageInfo, @Nullable Animatable animatable) {
                    ImageRequestListener imageRequestListener2 = this.a;
                    int i = 0;
                    int width = imageInfo != null ? imageInfo.getWidth() : 0;
                    if (imageInfo != null) {
                        i = imageInfo.getHeight();
                    }
                    imageRequestListener2.onLoaded(width, i);
                }
            };
        }
        return null;
    }
}
