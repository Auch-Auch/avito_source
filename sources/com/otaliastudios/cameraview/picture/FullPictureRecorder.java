package com.otaliastudios.cameraview.picture;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.PictureResult;
import com.otaliastudios.cameraview.picture.PictureRecorder;
public abstract class FullPictureRecorder extends PictureRecorder {
    public static final CameraLogger LOG = CameraLogger.create(FullPictureRecorder.class.getSimpleName());

    public FullPictureRecorder(@NonNull PictureResult.Stub stub, @Nullable PictureRecorder.PictureResultListener pictureResultListener) {
        super(stub, pictureResultListener);
    }
}
