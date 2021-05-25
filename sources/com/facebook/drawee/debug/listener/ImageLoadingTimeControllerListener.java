package com.facebook.drawee.debug.listener;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import javax.annotation.Nullable;
public class ImageLoadingTimeControllerListener extends BaseControllerListener {
    public long b = -1;
    public long c = -1;
    @Nullable
    public ImageLoadingTimeListener d;

    public ImageLoadingTimeControllerListener(@Nullable ImageLoadingTimeListener imageLoadingTimeListener) {
        this.d = imageLoadingTimeListener;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        long currentTimeMillis = System.currentTimeMillis();
        this.c = currentTimeMillis;
        ImageLoadingTimeListener imageLoadingTimeListener = this.d;
        if (imageLoadingTimeListener != null) {
            imageLoadingTimeListener.onFinalImageSet(currentTimeMillis - this.b);
        }
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onSubmit(String str, Object obj) {
        this.b = System.currentTimeMillis();
    }
}
