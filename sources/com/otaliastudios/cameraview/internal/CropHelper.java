package com.otaliastudios.cameraview.internal;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.size.AspectRatio;
import com.otaliastudios.cameraview.size.Size;
public class CropHelper {
    @NonNull
    public static Rect computeCrop(@NonNull Size size, @NonNull AspectRatio aspectRatio) {
        int i;
        int width = size.getWidth();
        int height = size.getHeight();
        int i2 = 0;
        if (aspectRatio.matches(size, 5.0E-4f)) {
            return new Rect(0, 0, width, height);
        }
        if (AspectRatio.of(width, height).toFloat() > aspectRatio.toFloat()) {
            int round = Math.round(aspectRatio.toFloat() * ((float) height));
            width = round;
            i2 = Math.round(((float) (width - round)) / 2.0f);
            i = 0;
        } else {
            int round2 = Math.round(((float) width) / aspectRatio.toFloat());
            i = Math.round(((float) (height - round2)) / 2.0f);
            height = round2;
        }
        return new Rect(i2, i, width + i2, height + i);
    }
}
