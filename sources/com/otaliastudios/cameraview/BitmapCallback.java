package com.otaliastudios.cameraview;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
public interface BitmapCallback {
    @UiThread
    void onBitmapReady(@Nullable Bitmap bitmap);
}
