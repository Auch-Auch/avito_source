package com.otaliastudios.cameraview.picture;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.otaliastudios.cameraview.PictureResult;
public abstract class PictureRecorder {
    @VisibleForTesting(otherwise = 4)
    public PictureResult.Stub a;
    @VisibleForTesting
    public PictureResultListener b;
    public Exception mError;

    public interface PictureResultListener {
        void onPictureResult(@Nullable PictureResult.Stub stub, @Nullable Exception exc);

        void onPictureShutter(boolean z);
    }

    public PictureRecorder(@NonNull PictureResult.Stub stub, @Nullable PictureResultListener pictureResultListener) {
        this.a = stub;
        this.b = pictureResultListener;
    }

    public void dispatchOnShutter(boolean z) {
        PictureResultListener pictureResultListener = this.b;
        if (pictureResultListener != null) {
            pictureResultListener.onPictureShutter(z);
        }
    }

    public void dispatchResult() {
        PictureResultListener pictureResultListener = this.b;
        if (pictureResultListener != null) {
            pictureResultListener.onPictureResult(this.a, this.mError);
            this.b = null;
            this.a = null;
        }
    }

    public abstract void take();
}
