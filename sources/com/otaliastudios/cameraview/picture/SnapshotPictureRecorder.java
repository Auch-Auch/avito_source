package com.otaliastudios.cameraview.picture;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.PictureResult;
import com.otaliastudios.cameraview.picture.PictureRecorder;
public abstract class SnapshotPictureRecorder extends PictureRecorder {
    public static final CameraLogger LOG = CameraLogger.create(SnapshotPictureRecorder.class.getSimpleName());

    public SnapshotPictureRecorder(@NonNull PictureResult.Stub stub, @Nullable PictureRecorder.PictureResultListener pictureResultListener) {
        super(stub, pictureResultListener);
    }
}
